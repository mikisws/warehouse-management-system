package com.gdpu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gdpu.bean.Goods;
import com.gdpu.bean.TbUser;
import com.gdpu.bean.Warehouse;
import com.gdpu.common.DataGridView;
import com.gdpu.common.WebUtils;
import com.gdpu.service.WarehouseService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author hjs
 * @since 2020-06-29
 */
@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Resource
    WarehouseService warehouseService;
    //提供下拉框
    @RequestMapping("loadAllHouseForSelect")
    public DataGridView loadAllHouseForSelect(){
        QueryWrapper<Warehouse> queryWrapper = new QueryWrapper<Warehouse>();
        TbUser tbUser = (TbUser) WebUtils.getSession().getAttribute("user");
        queryWrapper.eq(0!=tbUser.getRoleId(),"house_id",tbUser.getRoleId());
        List<Warehouse> list = warehouseService.list(queryWrapper);
        return new DataGridView(list);
    }

}

