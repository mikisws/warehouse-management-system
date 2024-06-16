package com.gdpu.controller;


import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.bean.TbUser;
import com.gdpu.common.DataGridView;
import com.gdpu.common.ResultObj;
import com.gdpu.service.TbUserService;
import com.gdpu.vo.UserVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjs
 * @since 2020-06-29
 */
@RestController
@RequestMapping("/user")
public class TbUserController {
    @Resource
    private TbUserService tbUserService;

    /*查询用户*/
    @RequestMapping("loadAllUser")
    public DataGridView loadAllUser(UserVo userVo){
        IPage<TbUser> page = new Page<>(userVo.getPage(),userVo.getLimit());
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper();
        queryWrapper.like(StringUtils.isNotBlank(userVo.getName()),"name",userVo.getName());
        queryWrapper.like(StringUtils.isNotBlank(userVo.getAccount()),"account",userVo.getAccount());
        queryWrapper.eq(StringUtils.isNotBlank(userVo.getSex()),"sex",userVo.getSex());
        tbUserService.page(page,queryWrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    @RequestMapping("addUser")
    public ResultObj addUser(UserVo userVo){
        try{
            String account = userVo.getAccount();
            TbUser user = tbUserService.getByAccount(account);
            if(null != user){
                return ResultObj.ADD_ERROR_EXIST;
            }
            //设置盐
            String salt = IdUtil.simpleUUID().toUpperCase();
            userVo.setSalt(salt);
            //设置密码
            userVo.setPassword(new Md5Hash(userVo.getPassword(),salt,2).toString());
            //设置性别
            String sex = userVo.getSex()=="1"?"男":"女";
            userVo.setSex(sex);
            tbUserService.save(userVo);
            return ResultObj.ADD_SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    @RequestMapping("updateUser")
    public ResultObj updateUser(UserVo userVo){
        try {
            String salt = tbUserService.getById(userVo.getUserId()).getSalt();
            userVo.setPassword(new Md5Hash(userVo.getPassword(),salt,2).toString());

//            //设置性别
            String sex = "1".equals(userVo.getSex())?"男":"女";
            userVo.setSex(sex);
            tbUserService.updateById(userVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }
    @RequestMapping("deleteUser")
    public ResultObj deleteUser(Integer id){
        try {
            this.tbUserService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }
}

