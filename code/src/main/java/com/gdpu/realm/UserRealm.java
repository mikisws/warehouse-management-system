package com.gdpu.realm;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdpu.bean.TbUser;
import com.gdpu.common.ActiveUser;
import com.gdpu.service.TbUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class UserRealm extends AuthorizingRealm {


    @Resource
    private TbUserService tbUserService;

    @Override
    public String getName() {
        return this.getClass().getSimpleName();
    }

    /*
    *   授权
    * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    /*
    *   认证
    * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //mybatisplus3.2.0的条件构造器QueryWrapper<TbUser>用于筛选相同的账号
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper();
        //在数据库中筛选账号相同的user
        queryWrapper.eq("account",token.getPrincipal().toString());
        TbUser tbUser = tbUserService.getOne(queryWrapper);
        if(null != tbUser){
            //新建活动用户
            ActiveUser activeUser = new ActiveUser();
            activeUser.setTbUser(tbUser);
            //获取数据库中该用户的盐，盐由md5加密算法生成
            ByteSource credentials = ByteSource.Util.bytes(tbUser.getSalt());
            System.out.println("credentials = " + credentials);
            //判断密码是否相同
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(activeUser, tbUser.getPassword(),credentials,this.getName());
            return info;
        }
        return null;
    }
}
