package com.gdpu.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hjs
 * @since 2020-06-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Goods implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 货物id
     */
    @TableId(value = "goods_id", type = IdType.AUTO)
    private Integer goodsId;

    /**
     * 货物名
     */
    private String name;

    /**
     * 供货商id
     */
    private Integer providerId;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 规格
     */
    private String size;

    /**
     * 包装
     */
    private String packages;

    @TableField(exist = false)
    private String providerName;

    @TableField(exist = false)
    private String address;
}
