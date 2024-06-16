package com.gdpu.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hjs
 * @since 2020-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class InputForm implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "form_id", type = IdType.AUTO)
    private Integer formId;

    private Integer providerId;

    private Date createTime;

    private Integer goodsId;

    private Integer houseId;

    private Integer changeNumber;

    /**
     * 负责人
     */
    private Integer userId;

    @TableField(exist = false)
    private String goodsName;

    @TableField(exist = false)
    private String providerName;

    @TableField(exist = false)
    private String address;

    @TableField(exist = false)
    private Integer price;

    @TableField(exist = false)
    private String size;

    @TableField(exist = false)
    private String packages;

    @TableField(exist = false)
    private String houseName;

    @TableField(exist = false)
    private String userName;
}
