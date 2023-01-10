package com.jiasu.mdl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 进出场管理
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class EntranceExitManage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 批次号
     */
    private String batchNumber;

    /**
     * 集装箱号
     */
    private String containerNumber;

    /**
     * 货物名称
     */
    private String goodsName;

    /**
     * 批次重量 （货物重量）
     */
    private Integer batchWeight;

    /**
     * 堆场名称
     */
    private String yardName;

    /**
     * 存放位置
     */
    private String yardPosition;

    /**
     * 收货单位
     */
    private String receiveCompany;

    /**
     * 发货单位
     */
    private String company;

    /**
     * 类型
     */
    private String type;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     *  车辆类型  1 蒙煤车 2外发车 
     */
    private Integer vehicleType;

    /**
     * 通讯；0未发送；1已发送
     */
    private String comeFlag;

    /**
     * 集装箱堆场反馈时间
     */
    private LocalDateTime csaTime;

    /**
     * 回执说明
     */
    @TableField("feedbackContent")
    private String feedbackContent;

    /**
     * 通道名称
     */
    private String chnlName;

    /**
     * 车牌号（供前端补全堆场及后续操作使用）
     */
    private String carNo;

    /**
     * 电子车牌号（供前端补全堆场及后续操作使用）
     */
    private String electronicsCarNo;

    /**
     * 状态 1无效状态 2 待查用  3 已核销 （供前端补全堆场及后续操作使用）
     */
    private Integer status;


}
