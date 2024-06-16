package com.gdpu.mapper;

import com.gdpu.bean.Warehouse;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hjs
 * @since 2020-06-29
 */
public interface WarehouseMapper extends BaseMapper<Warehouse> {

    public Integer getMaximumId();
}
