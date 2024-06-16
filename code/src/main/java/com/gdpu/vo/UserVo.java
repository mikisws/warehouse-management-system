package com.gdpu.vo;

import com.gdpu.bean.TbUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;


@Data
@EqualsAndHashCode(callSuper = false)
public class UserVo extends TbUser {

    private static final Long serialVersionUID = 1L;


    private Integer page = 1;
    private Integer limit = 10;
}
