package com.gdpu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.bean.Provider;
import com.gdpu.bean.TbUser;
import com.gdpu.common.DataGridView;
import com.gdpu.common.ResultObj;
import com.gdpu.common.WebUtils;
import com.gdpu.service.ProviderService;
import com.gdpu.vo.ProviderVo;
import org.apache.commons.lang3.StringUtils;
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
@RequestMapping("/provider")
public class ProviderController {

    @Resource
    private ProviderService providerService;


    @RequestMapping("loadAllProvider")
    public DataGridView loadAllProvider(ProviderVo providerVo){
        //1.声明一个分页page对象
        IPage<Provider> page = new Page(providerVo.getPage(),providerVo.getLimit());
        //2.声明一个queryWrapper
        QueryWrapper<Provider> queryWrapper = new QueryWrapper();
        queryWrapper.eq(null != providerVo.getProviderId() && providerVo.getProviderId()!=0,"provider_id",providerVo.getProviderId());
        queryWrapper.like(StringUtils.isNotBlank(providerVo.getManager()),"manager",providerVo.getManager());
        queryWrapper.like(StringUtils.isNotBlank(providerVo.getTalePhone()),"tale_phone",providerVo.getTalePhone());
        providerService.page(page,queryWrapper);
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    /**
     * 添加一个供应商
     * @param providerVo
     * @return
     */
    @RequestMapping("addProvider")
    public ResultObj addProvider(ProviderVo providerVo){
        try {
            providerService.save(providerVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改一个供应商
     * @param providerVo
     * @return
     */
    @RequestMapping("updateProvider")
    public ResultObj updateProvider(ProviderVo providerVo){
        try {
            providerService.updateById(providerVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }


    /**
     * 删除一个供应商
     * @param id
     * @return
     */
    @RequestMapping("deleteProvider")
    public ResultObj deleteProvider(Integer id){
        try {
            providerService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }




    //提供下拉框
    @RequestMapping("loadAllProviderForSelect")
    public DataGridView loadAllProviderForSelect(){
        QueryWrapper<Provider> queryWrapper = new QueryWrapper<Provider>();
        List<Provider> list = providerService.list(queryWrapper);
        return new DataGridView(list);
    }


}

