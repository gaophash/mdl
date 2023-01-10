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
 * 申报管理-散杂货申报
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BeltScaleManage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 运输方式
     */
    private String typeOfShipping;

    /**
     * 业务类型
     */
    private String businessType;

    /**
     * 过卡车辆类型
     */
    private String vehicleType;

    /**
     * 进出口标志
     */
    private String importAndExportSigns;

    /**
     * 绑定介质类型
     */
    private String bindMediaType;

    /**
     * 绑定介质关键信息
     */
    private String keyInfoOfBindingMedia;

    /**
     * 车辆重量
     */
    private Double carWeight;

    /**
     * 挂车重量
     */
    private Double trailerWeight;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 进出方向
     */
    private String accessDirection;

    /**
     * 提单类型
     */
    private String typeOfBillOfLading;

    /**
     * 表体-业务类型2
     */
    private String businessType2;

    /**
     * 表体-绑定对象类型
     */
    private String bindObjectType;

    /**
     * 表体-绑定对象id
     */
    private String bindObjId;

    /**
     * 表体-货物运输批次号
     */
    private String cargoTransportBatchNumber;

    /**
     * 表体-提货重量
     */
    private String pickUpWeight;

    /**
     * 货物名称2
     */
    private String printGoodsName;

    /**
     * 收货单位
     */
    private String receiveCompany;

    /**
     * 规格型号
     */
    private String modelName;

    /**
     * 表体-备注信息
     */
    private String remark2;

    /**
     * 是否人工办结 0否 1是
     */
    private String pFinish;

    /**
     * 处理结果 0已申报 1待申报 2通过 3拒绝
     */
    private String pResult;

    /**
     * 是否完结1是 0否 2未入场
     */
    private Boolean status;

    /**
     * 回执说明
     */
    private String receiptRemark;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 申报时间
     */
    private LocalDateTime declarTime;

    /**
     * 车次确认号
     */
    private String sureId;

    /**
     * 操作人员ID
     */
    private String opUserId;

    /**
     * 集装箱重量
     */
    private Double contaWeight;

    private String messageId;

    private LocalDateTime updateTime;

    /**
     * 软删除时间戳
     */
    private Integer deleteTime;

    private String weight;

    private String goodsName;


}
