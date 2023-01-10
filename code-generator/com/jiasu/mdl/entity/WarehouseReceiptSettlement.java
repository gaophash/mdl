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
 * 入库单结算
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WarehouseReceiptSettlement implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属公司
     */
    private String company;

    /**
     * 入库单id
     */
    private Integer receiptId;

    /**
     * 批次号
     */
    private String batchNumber;

    /**
     * 所属煤仓
     */
    private String whName;

    /**
     * 父级仓库
     */
    private String parentWhName;

    /**
     * 入库重量，净重
     */
    private Double weight;

    /**
     * 计算公式
     */
    private String countFormula;

    /**
     * 是否结算1是 0否
     */
    private Boolean status;

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 操作人呢
     */
    private String optUser;

    /**
     * 结算价格
     */
    private Double totalPrice;

    /**
     * 记录添加时间
     */
    private LocalDateTime createTime;

    /**
     * 标记为已经结算的时间
     */
    private LocalDateTime updateTime;

    /**
     * 软删除时间戳
     */
    private Integer deleteTime;


}
