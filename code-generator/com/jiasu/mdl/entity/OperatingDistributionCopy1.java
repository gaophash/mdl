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
 * 分配作业
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OperatingDistributionCopy1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
     * 作业状态 1进行中 2已完成
     */
    private Integer operatingStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 操作人 （分配）
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


}
