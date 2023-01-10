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
 * 吊车作业
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OperatingCrane implements Serializable {

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
    private String batchWeight;

    /**
     * 堆场名称
     */
    private String yardName;

    /**
     * 作业位置
     */
    private String operatingPosition;

    /**
     * 作业类型 1装货 2卸货 3倒装
     */
    private Boolean operatingType;

    /**
     * 作业状态 1进行中 2已完成 3已挂起 4已分配
     */
    private Integer operatingStatus;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 操作人 （完成或挂起）
     */
    private String operator;

    /**
     * 完成时间
     */
    private LocalDateTime completeTime;

    /**
     * 是否放行 1是 2否 
     */
    private Boolean isRelease;


}
