package com.gdpu.service;

import com.gdpu.bean.Stock;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjs
 * @since 2020-06-29
 */
public interface StockService extends IService<Stock> {

    void updateByIds(Stock stock);
}
