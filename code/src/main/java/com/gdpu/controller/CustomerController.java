package com.gdpu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gdpu.bean.Customer;
import com.gdpu.bean.Provider;
import com.gdpu.common.DataGridView;
import com.gdpu.common.ResultObj;
import com.gdpu.service.CustomerService;
import com.gdpu.service.ProviderService;
import com.gdpu.vo.CustomerVo;
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
 * @since 2020-07-02
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;


    @RequestMapping("loadAllCustomer")
    public DataGridView loadAllProvider(CustomerVo customerVo){
        //1.声明一个分页page对象
        IPage<Customer> page = new Page<Customer>(customerVo.getPage(),customerVo.getLimit());
        //2.声明一个queryWrapper
        QueryWrapper<Customer> queryWrapper = new QueryWrapper();
        queryWrapper.eq(null != customerVo.getCustomerId() && customerVo.getCustomerId()!=0,"customer_id",customerVo.getCustomerId());
        queryWrapper.like(StringUtils.isNotBlank(customerVo.getManager()),"manager",customerVo.getManager());
        queryWrapper.like(StringUtils.isNotBlank(customerVo.getTalePhone()),"tale_phone",customerVo.getTalePhone());
        customerService.page(page,queryWrapper);
//        System.out.println("page.getTotal() = " + page.getTotal());
//        System.out.println("page.getRecords() = " + page.getRecords());
//        System.out.println("page.getSize() = " + page.getSize());
        return new DataGridView(page.getTotal(),page.getRecords());
    }

    /**
     * 添加一个供应商
     * @param customerVo
     * @return
     */
    @RequestMapping("addCustomer")
    public ResultObj addCustomer(CustomerVo customerVo){
        try {
            customerService.save(customerVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    /**
     * 修改一个供应商
     * @param customerVo
     * @return
     */
    @RequestMapping("updateCustomer")
    public ResultObj updateCustomer(CustomerVo customerVo){
        try {
            customerService.updateById(customerVo);
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
    @RequestMapping("deleteCustomer")
    public ResultObj deleteCutomer(Integer id){
        try {
            customerService.removeById(id);
            return ResultObj.DELETE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.DELETE_ERROR;
        }
    }




    //提供下拉框
    @RequestMapping("loadAllCustomerForSelect")
    public DataGridView loadAllCutomerForSelect(){
        QueryWrapper<Customer> queryWrapper = new QueryWrapper<Customer>();
        List<Customer> list = customerService.list(queryWrapper);
        return new DataGridView(list);
    }
}

