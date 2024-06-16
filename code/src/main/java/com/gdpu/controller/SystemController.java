package com.gdpu.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys")
public class SystemController {

    /*
    * 跳转到登陆页面
     * @return
    * */
    @RequestMapping("toLogin")
    public String toLogin(){
        return "/index/login";
    }



    /*
    * 跳转到首页
    *
    * */
    @RequestMapping("index")
    public String index(){
        return "/index/index";
    }

    /*
    * 跳转到工作台
    * */
    @RequestMapping("toDesktopManager")
    public String toDesktopManager(){
        return "/index/desktopManager";
    }



    /**
     * 跳转到角色管理
     * @return
     */
    @RequestMapping("toRoleManager")
    public String toRoleManager(){
        return "/role/roleManager";
    }

    /**
     * 跳转到用户管理
     * @return
     */
    @RequestMapping("toUserManager")
    public String toUserManager(){
        return "/user/userManager";
    }

    @RequestMapping("toGoodsManager")
    public String toGoodsManager(){
        return "/goods/goodsManager";
    }


    @RequestMapping("toProviderManager")
    public String toProviderManager(){
        return "/provider/providerManager";
    }

    @RequestMapping("toCustomerManager")
    public String toCustomerManager(){
        return "/customer/customerManager";
    }

    @RequestMapping("toInputManager")
    public String toInputManager(){
        return "/input/inputManager";
    }

    @RequestMapping("toOutputManager")
    public String toOutputManager(){
        return "/output/outputManager";
    }

    @RequestMapping("toWarehouseManager")
    public String toWarehouseManager(){
        return "/warehouse/warehouseManager";
    }

}
