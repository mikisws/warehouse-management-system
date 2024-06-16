package com.gdpu.vo;

import com.gdpu.bean.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false)
public class CustomerVo extends Customer {
    /**
     * 分页参数，当前是第一页，每页10条数据
     */
    private static final long serialVersionUID = 1L;
    private Integer page=1;
    private Integer limit=10;

}
