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
 * 审批管理-出口审批
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ExportApplicationManage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 企业名称
     */
    private String enterpriseName;

    /**
     * 代理名称
     */
    private String agentName;

    /**
     * 货物名称
     */
    private String goodsName;

    /**
     * 货物名称编号
     */
    private Integer goodsNameId;

    /**
     * 货物类型
     */
    private String goodsType;

    /**
     * 货物总件数
     */
    private Integer goodsNumber;

    /**
     *  货物总毛重 (kg)
     */
    private Double totalGrossWeight;

    /**
     * 仓储区域
     */
    private String inWh;

    /**
     * 发生日期
     */
    private LocalDateTime happenDate;

    /**
     * 运抵票数
     */
    private String ydps;

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 规格型号
     */
    private String modelName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 审批状态 1 审批中  2 已审批（同意） 3 拒绝
     */
    private Boolean status;

    /**
     * 审批备注
     */
    private String approvalRemark;

    /**
     * 审批操作人
     */
    private String operator;

    /**
     * 过卡状态  1 未入场 2 已入场
     */
    private Boolean passStatus;

    /**
     * 删除时间
     */
    private Integer deleteTime;

    /**
     * 添加人
     */
    private String addUser;


}
