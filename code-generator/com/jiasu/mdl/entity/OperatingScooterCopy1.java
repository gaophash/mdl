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
 * 板车作业
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OperatingScooterCopy1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 倒装任务id
     */
    private Integer invertedManageId;

    /**
     * 批次号
     */
    private String batchNumber;

    /**
     * 介质信息
     */
    private String mediaInformation;

    /**
     * 货物名称
     */
    private String goodsName;

    /**
     * 集装箱号
     */
    private String containerNumber;

    /**
     * 批次重量
     */
    private Double batchWeight;

    /**
     * 仓库名称
     */
    private String warehouseName;

    /**
     * 作业状态 1进行中 2已完成
     */
    private Integer operatingStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 操作人 （完成）
     */
    private String operator;

    /**
     * 完成时间
     */
    private LocalDateTime completeTime;

    /**
     * 分配信息
     */
    private String distributionInfo;

    /**
     * 是否反箱  1 否 2 是
     */
    private Boolean isBackBox;

    /**
     * 反箱备注
     */
    private String remarkBackBox;

    /**
     * 是否已读 1 否 2是
     */
    private Boolean isRead;


}
