package com.gdpu.bean;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2020-07-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Customer implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "customer_id", type = IdType.AUTO)
    private Integer customerId;

    private String name;

    private String address;

    private String manager;

    private String talePhone;


}
