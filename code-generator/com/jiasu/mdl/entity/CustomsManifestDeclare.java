package com.jiasu.mdl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 蒙车进境-原始舱单申报
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CustomsManifestDeclare implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 运输批次号、货物批次号
     */
    private String batchNumber;

    /**
     * 货物装载时间
     */
    private LocalDate loadDate;

    /**
     * 提运单号
     */
    private String billNumber;

    /**
     * 收货人信息
     */
    private String receiveCompany;

    /**
     * 商品毛重
     */
    private Double grossWeight;

    /**
     * 发货人信息
     */
    private String company;

    /**
     * 煤种、商品描述
     */
    private String goodsType;

    /**
     * 货物名称
     */
    private String goodsName;

    /**
     * 货物价值，单位元
     */
    private Double goodsValue;

    /**
     * 商品序号
     */
    private String goodsSerialNumber;

    /**
     * 商品计量单位
     */
    private String goodsMeteringUnit;

    /**
     * 商品包装种类
     */
    private String goodsPickingType;

    /**
     * 商品件数
     */
    private Integer goodsCount;

    /**
     * 舱单传输人名称
     */
    private String transporter;

    /**
     * 卸货地代码
     */
    private String dischargeCode;

    /**
     * 报文发送方代码
     */
    private String sendCode;

    /**
     * 进出境口岸海关代码
     */
    private String customsCode;

    /**
     * 货物包装种类
     */
    private String cargoPickingType;

    /**
     * 货物总件数		
     */
    private Integer cargoCount;

    /**
     * 货物计量单位
     */
    private String cargoMeteringUnit;

    /**
     * 货物总毛重
     */
    private Double cargoGrossWeight;

    /**
     * 金额类型
     */
    private String moneyType;

    /**
     * 企业组织机构代码
     */
    private String organizeCode;

    /**
     * 提运单号前几位
     */
    private String billStartCode;

    /**
     * 填写人id
     */
    private String createUser;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 申报日期
     */
    private LocalDateTime declareTime;

    /**
     * 到达卸货地日期
     */
    private LocalDate arriveDate;

    /**
     * 是否完结0否 1是
     */
    private Boolean status;

    /**
     * 处理结果 0已申报 1待申报 2通过 3拒绝 4撤销中 40已经完结
     */
    private String pResult;

    /**
     * 回执说明
     */
    private String receiptRemark;

    /**
     * 返回的第一段报文
     */
    private String receive1;

    /**
     * 返回的第二段报文
     */
    private String receive2;

    /**
     * 返回的第三段报文
     */
    private String receive3;

    /**
     * 第一段报文的返回结果
     */
    private String status1msg;

    /**
     * 第二段报文的结果
     */
    private String status2msg;

    /**
     * 第三段报文的结果
     */
    private String status3msg;

    /**
     * 软删除时间戳
     */
    private Integer deleteTime;


}
