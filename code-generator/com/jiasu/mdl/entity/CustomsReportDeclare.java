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
 * 蒙车进境-集报清单
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CustomsReportDeclare implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 运输批次号
     */
    private String batchNumber;

    /**
     * 提运单号
     */
    private String billNumber;

    /**
     * 收发货单位
     */
    private String deliverRecCompany;

    /**
     * 收发货单位编码
     */
    private String deliverRecCode;

    /**
     * 贸易方式/监管方式
     */
    private String tradeType;

    /**
     * 进口日期
     */
    private LocalDate importDate;

    /**
     * 分册海关编号
     */
    private String customsNumber;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品编号
     */
    private String goodsNumber;

    /**
     * 商品序号
     */
    private String goodsSerialNumber;

    /**
     * 规格型号
     */
    private String modelName;

    /**
     * 毛重
     */
    private Double grossWeight;

    /**
     * 净重
     */
    private Double netWeight;

    /**
     * 运输方式
     */
    private String transportMode;

    /**
     * 运输工具名称
     */
    private String transportName;

    /**
     * 件数
     */
    private Integer counts;

    /**
     * 申报单位名称
     */
    private String declareCompanyName;

    /**
     * 申报单位代码	
     */
    private String declareCompanyCode;

    /**
     * 进出口岸
     */
    private String portName;

    /**
     * 包装类型
     */
    private String pickingType;

    /**
     * 申报地海关
     */
    private String declareCustoms;

    /**
     * 申报数量(毛重)
     */
    private Double declareNumber;

    /**
     * 计量单位
     */
    private String meteringUnit;

    /**
     * 单价
     */
    private Double nuitPrice;

    /**
     * 总价
     */
    private Double totalPrice;

    /**
     * 商品备案号
     */
    private String goodsRecordNumber;

    /**
     * 币制
     */
    private String moneyType;

    /**
     * 法定计量单位
     */
    private String legalMeteringUnit;

    /**
     * 操作员ic卡号
     */
    private String operatorIcNumber;

    /**
     * 操作员姓名
     */
    private String operatorName;

    /**
     * 企业组织结构代码
     */
    private String organizeCode;

    /**
     * 备案号
     */
    private String recordNumber;

    /**
     * 邮箱id
     */
    private String email;

    /**
     * 企业主管海关
     */
    private String companyCustoms;

    /**
     * 经营单位名称
     */
    private String unitName;

    /**
     * 经营单位编码
     */
    private String unitCode;

    /**
     * 原产国
     */
    private String originCountry;

    /**
     * 起运国
     */
    private String consignCountry;

    /**
     * 装运港
     */
    private String loadingPort;

    /**
     * 境内目的地
     */
    private String destination;

    /**
     * 处理结果 0已申报 1待申报 2通过 3拒绝 4撤销中 40已经完结
     */
    private String pResult;

    /**
     * 操作人
     */
    private String createUser;

    private LocalDateTime declareTime;

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

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 软删除时间戳
     */
    private Integer deleteTime;


}
