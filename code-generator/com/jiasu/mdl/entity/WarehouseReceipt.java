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
 * 入库单
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WarehouseReceipt implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 通关单号即绑定对象ID
     */
    private String customsClearanceNo;

    /**
     * 批次号
     */
    private String tgdpch;

    /**
     * 批次号重量
     */
    private Double customsClearanceWeight;

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 电子车牌号
     */
    private String veRfidNo;

    /**
     * 磅单号
     */
    private String poundNo;

    /**
     * 监管号
     */
    private String regulatoryNumber;

    /**
     * 货主企业（发货单位）
     */
    private String company;

    /**
     * 收货单位
     */
    private String receiveCompany;

    /**
     * 货物类型
     */
    private String goodsType;

    /**
     * 入库煤仓
     */
    private String inWh;

    /**
     * 货物名称
     */
    private String goodsName;

    private String printGoodsName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 进入时间
     */
    private LocalDateTime createTime;

    /**
     * 入库状态 1已入库 0未入库
     */
    private String status;

    /**
     * 过卡重量
     */
    private String cardWeight;

    /**
     * 更新状态为完成的时间
     */
    private LocalDateTime updateTime;

    /**
     * 剩余重量
     */
    private Double syWeight;

    /**
     * 检验检疫
     */
    private String jyjy;

    /**
     * 型号
     */
    private String modelName;

    /**
     * 毛重
     */
    private Double grossWeight;

    /**
     * 毛重通道
     */
    private String grossChnl;

    /**
     * 皮重
     */
    private Double tare;

    /**
     * 毛重时间
     */
    private LocalDateTime grossWeightTime;

    /**
     * 毛重司磅员
     */
    private String grossMan;

    /**
     * 皮重时间
     */
    private LocalDateTime tareTime;

    /**
     * 过去皮司磅员
     */
    private String tareMan;

    /**
     * 皮重通道
     */
    private String tareChnl;

    /**
     * 初始毛重
     */
    private Double startGrossWeight;

    /**
     * 初始皮重
     */
    private Double startTare;

    /**
     * 记录生成者
     */
    private String createUser;

    /**
     * 记录修改人
     */
    private String updateUser;

    /**
     * 软删除时间戳
     */
    private Integer deleteTime;

    /**
     * 集装箱号
     */
    private String containerNumber;

    /**
     * 集装箱重量
     */
    private String containerWeight;

    /**
     * 蒙古车号
     */
    private String mongoliaCarNumber;

    /**
     * 提运单号（绑定对象id）
     */
    private String deliveryNumbers;

    private String addUser;


}
