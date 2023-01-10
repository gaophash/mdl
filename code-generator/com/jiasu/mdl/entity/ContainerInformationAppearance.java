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
 * 集装箱出场
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ContainerInformationAppearance implements Serializable {

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
     * 国内车号
     */
    private String veRfidNo;

    /**
     * 货物类型
     */
    private String goodsType;

    /**
     * 增加时间
     */
    private LocalDateTime createTime;

    /**
     * 添加者用户名
     */
    private String addUser;

    /**
     * 1，未出场(默认状态) 2，已出场（核销）
     */
    private Integer status;

    /**
     * 收货单位
     */
    private String receiveCompany;

    /**
     *  车辆类型  1 蒙煤车 2外发车 
     */
    private Integer vehicleType;

    /**
     * 进出类型  1 进场 2出场 
     */
    private Integer type;


}
