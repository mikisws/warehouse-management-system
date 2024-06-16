package com.gdpu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.bean.*;
import com.gdpu.common.DataGridView;
import com.gdpu.common.ResultObj;
import com.gdpu.common.WebUtils;
import com.gdpu.service.*;
import com.gdpu.vo.StockVo;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.util.Date;
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
@RequestMapping("/stock")
public class StockController {


    @Resource
    private GoodsService goodsService;

    @Resource
    private WarehouseService warehouseService;

    @Resource
    private StockService stockService;

    @Resource
    private RoleService roleService;

    @RequestMapping("loadAllGoodsForHouseSelect")
    public DataGridView loadAllGoodsForHouseSelect(Integer houseId){
        QueryWrapper<Stock> queryWrapper = new QueryWrapper();
        queryWrapper.eq(null!=houseId,"house_id",houseId);
        List<Stock> list = stockService.list(queryWrapper);
        for (Stock stock : list) {
            Goods goods = goodsService.getById(stock.getGoodsId());
            if( null != goods){
                stock.setName(goods.getName());
            }
        }
        return new DataGridView((list));
    }

    @RequestMapping("loadAllStock")
    public DataGridView loadAllStock(StockVo stockVo){
        IPage<Stock> page = new Page<>(stockVo.getPage(),stockVo.getLimit());
        QueryWrapper<Stock> queryWrapper = new QueryWrapper<Stock>();
        queryWrapper.eq(null != stockVo.getGoodsId() && stockVo.getGoodsId() !=0,"goods_id",stockVo.getGoodsId());
        TbUser tbUser = (TbUser) WebUtils.getSession().getAttribute("user");
        if(tbUser.getRoleId()!=0){
            queryWrapper.eq(0!=tbUser.getRoleId(),"house_id",tbUser.getRoleId());
        }else {
            queryWrapper.eq(null != stockVo.getHouseId() && stockVo.getHouseId() !=0,"house_id",stockVo.getHouseId());
        }
        queryWrapper.notIn("goods_id",0);
        stockService.page(page,queryWrapper);
        List<Stock> records = page.getRecords();
        for (Stock stock : records) {
            Warehouse warehouse = warehouseService.getById(stock.getHouseId());
            if(null != warehouse){
                stock.setHouseName(warehouse.getName());
                stock.setAddress(warehouse.getAddress());
            }
            Goods goods = goodsService.getById(stock.getGoodsId());
            if(null != goods){
                stock.setName(goods.getName());
                stock.setSize(goods.getSize());
                stock.setPackages(goods.getPackages());
                stock.setPrice(goods.getPrice());
            }
        }
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    @RequestMapping("addHouse")
    public ResultObj addHouse(StockVo stockVo){
        try {
            Integer houseId = warehouseService.getMaximumId()+1;
            stockVo.setHouseId(houseId);
            stockVo.setGoodsId(0);
            stockVo.setNumber(0);
            stockService.save(stockVo);

            Warehouse warehouse = new Warehouse();
            warehouse.setHouseId(houseId);
            warehouse.setName(stockVo.getHouseName());
            warehouse.setAddress(stockVo.getAddress());
            warehouseService.save(warehouse);

            Role role = new Role();
            role.setAvailable(0);
            role.setName(houseId+"号仓库管理员");
            role.setRoleId(houseId);
            role.setCreatetime(new Date());
            roleService.save(role);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    @RequestMapping("updateHouse")
    public ResultObj updateHouse(StockVo stockVo){
        QueryWrapper<Stock> queryWrapper = new QueryWrapper<Stock>();
        queryWrapper.eq("house_id",stockVo.getHouseId());
        queryWrapper.eq("goods_id",stockVo.getGoodsId());
        Integer number = stockService.getOne(queryWrapper).getNumber();
        try {
            if(stockVo.getUpperAlert() < number){       //超出新的预警库存
                return ResultObj.UPDATE_ERROR_EXCEED;
            }else if(stockVo.getUnderAlert() > number){ //低于新的预警库存
                return ResultObj.UPDATE_ERROR_UNDER;
            }else {
                stockService.updateByIds(stockVo);
                return ResultObj.UPDATE_SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    @RequestMapping("deleteHouse")
    public ResultObj deleteHouse(Integer id){
        try {
            QueryWrapper<Stock> queryWrapper = new QueryWrapper();
            queryWrapper.eq("house_id",id);
            if(stockService.count(queryWrapper)>1){ //库存中仍有货物，无法删除
                return ResultObj.DELETE_ERROR_STOCK;
            }
            warehouseService.removeById(id);
            stockService.remove(queryWrapper);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }

}

