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
 * 
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OperatingManageCopy1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 批次号（多个）
     */
    private String batchNumber;

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 所属企业
     */
    private String bindCompany;

    /**
     * 所属煤仓
     */
    private String whName;

    /**
     * 货物名称
     */
    private String goodsName;

    /**
     * 批次号重量（多个）
     */
    private String bachNumberWeight;

    /**
     * 生成时间
     */
    private LocalDateTime createTime;

    /**
     * 作业类型 1装货 2卸货 3倒装
     */
    private Boolean operatingType;

    /**
     * 倒装任务id
     */
    private Integer invertedManageId;

    /**
     * 作业状态 1进行中 2已完成
     */
    private Integer operatingStatus;

    /**
     * 完成时间
     */
    private LocalDateTime finishTime;

    /**
     * 费用
     */
    private Double operationMoney;

    /**
     * 负责人
     */
    private String operatingMan;


}
