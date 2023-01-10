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
 * 排队车辆表
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CustomsCar implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 批次号
     */
    private String bachNumber;

    /**
     * 批次号重量
     */
    private Double bachNumberWeight;

    /**
     * 提货单的批次重量
     */
    private String billBatchWeight;

    /**
     * 毛重
     */
    private Double grossWeight;

    /**
     * 收货单位
     */
    private String deliverRecCompany;

    /**
     * 入境id
     */
    private Integer entryId;

    /**
     * 申报id
     */
    private Integer groceriesId;

    /**
     * 散杂货申报表名
     */
    private String groceriesTable;

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 车辆重量
     */
    private Double carWeight;

    /**
     * 所属企业、发货单位
     */
    private String bindCompany;

    /**
     * 所属煤仓 （弃用）
     */
    private String whName;

    /**
     * 货物名称 
     */
    private String goodsName;

    /**
     * 车辆排号
     */
    private Integer vehicleQueuingNumber;

    /**
     * 申报时间
     */
    private LocalDateTime applicationTime;

    /**
     * 实际进站时间
     */
    private LocalDateTime actualArrivalTime;

    /**
     * 车辆状态 0未到达 1已到达 2已进场
     */
    private Integer carStatus;

    /**
     * 入库单id
     */
    private Integer receiptId;

    /**
     * 出库单id
     */
    private Integer billId;

    /**
     * 规格型号
     */
    private String spec;

    /**
     * 软删除时间戳
     */
    private Integer deleteTime;

    /**
     * 1蒙车0外发车
     */
    private Integer isCar;

    /**
     * 1已排号0未排号
     */
    private Integer isArrival;

    /**
     * 检验检疫号
     */
    private String jyjy;

    /**
     * 规格型号
     */
    private String modelName;

    /**
     * 货物名称2外发车
     */
    private String goodsName2;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 排号时间
     */
    private LocalDateTime numberTime;

    /**
     * 1叫号0未叫号 （满都拉不用）
     */
    private Integer isCallNumber;

    /**
     * 取消排号
     */
    private Integer cancelNumber;

    /**
     * 1已读 2未读
     */
    private Integer isRead;

    private String createUser;

    /**
     * 通道索引
     */
    private Integer indexNumber;

    /**
     * 预计进场时间
     */
    private LocalDate estimateInDate;


}
