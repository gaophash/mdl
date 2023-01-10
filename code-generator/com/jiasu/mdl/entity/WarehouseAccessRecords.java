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
 * 仓储管理-出入记录
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WarehouseAccessRecords implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 货物名称
     */
    private String goodsName;

    /**
     * 货物类型
     */
    private String goodType;

    /**
     * 仓库名称
     */
    private String whName;

    /**
     * 父级仓库
     */
    private String parentWhName;

    /**
     * 所属企业
     */
    private String refCompany;

    /**
     * 介质信息
     */
    private String medium;

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 货物重量
     */
    private String cargoWeight;

    /**
     * 出入类型 I进 E出
     */
    private String inOutType;

    /**
     * 出入时间
     */
    private LocalDateTime inOutTime;

    /**
     * create_time
     */
    private LocalDateTime createTime;

    /**
     * update_time
     */
    private LocalDateTime updateTime;

    /**
     * 入库单ID
     */
    private Integer receiptId;

    /**
     * 提货单id
     */
    private Integer billId;

    private Integer processId;

    /**
     * 软删除时间
     */
    private Integer deleteTime;


}
