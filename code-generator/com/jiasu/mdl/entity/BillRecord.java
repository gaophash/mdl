package com.jiasu.mdl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 微调记录
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BillRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 货物id
     */
    private Integer billId;

    /**
     * 操作人
     */
    private String optUser;

    /**
     * 操作重量
     */
    private Double weight;

    /**
     * 备注
     */
    private String remark;

    /**
     * 时间
     */
    private LocalDateTime createTime;

    /**
     * 软删除时间
     */
    private Integer deleteTime;


}
