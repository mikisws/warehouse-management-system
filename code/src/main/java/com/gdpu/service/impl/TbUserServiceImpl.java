package com.gdpu.service.impl;

import com.gdpu.bean.TbUser;
import com.gdpu.mapper.TbUserMapper;
import com.gdpu.service.TbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjs
 * @since 2020-06-29
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements TbUserService {
    @Resource
    TbUserMapper tbUserMapper;

    @Override
    public TbUser getByAccount(String account) {
        return tbUserMapper.getByAccount(account);
    }
}
