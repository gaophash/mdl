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
 * 集装箱
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ContainerInformation implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 批次号
     */
    private String batchNumber;

    /**
     * 批次重量
     */
    private Double batchWeight;

    /**
     * 提运单号（绑定对象id）
     */
    private String deliveryNumbers;

    /**
     * 集装箱号
     */
    private String containerNumber;

    /**
     * 集装箱重量
     */
    private Double containerWeight;

    /**
     * 集装箱号2
     */
    private String containerNumber2;

    /**
     * 集装箱重量2
     */
    private Double containerWeight2;

    /**
     * 国内车牌号
     */
    private String veRfidNo;

    /**
     * 货物类型
     */
    private String goodsType;

    /**
     * 增加时间
     */
    private Integer addTime;

    /**
     * 添加者用户名
     */
    private String addUser;

    /**
     * 1，未入场 2，已入场（核销）3.已出场  
     */
    private Integer status;

    /**
     * 修改说明
     */
    private String modifyRemark;

    /**
     * 过卡时间
     */
    private LocalDateTime passDate;

    /**
     * 过卡重量
     */
    private Double passWeight;

    /**
     * 过卡车牌号
     */
    private String passCarNo;

    /**
     * 收货单位
     */
    private String receiveCompany;

    /**
     * 发货单位
     */
    private String company;

    /**
     * 蒙古车号
     */
    private String mongoliaCarNumber;

    /**
     * 报关单号
     */
    private String customsDeclarationNo;


}
