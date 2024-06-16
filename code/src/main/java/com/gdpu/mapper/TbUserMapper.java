package com.gdpu.mapper;

import com.gdpu.bean.TbUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hjs
 * @since 2020-06-29
 */
public interface TbUserMapper extends BaseMapper<TbUser> {

    TbUser getByAccount(String account);
}
