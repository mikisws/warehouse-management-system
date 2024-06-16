package com.gdpu.service;

import com.gdpu.bean.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjs
 * @since 2020-06-29
 */
public interface TbUserService extends IService<TbUser> {
    TbUser getByAccount(String account);
}
