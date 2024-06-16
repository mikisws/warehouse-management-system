package com.gdpu.service;

import com.gdpu.bean.Warehouse;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.annotation.Resource;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjs
 * @since 2020-06-29
 */
public interface WarehouseService extends IService<Warehouse> {

    Integer getMaximumId();
}
