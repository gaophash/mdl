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
 * 货物管理-提货单管理
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BillOfLadManage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 绑定介质类型
     */
    private String bindMediaType;

    /**
     * 绑定介质关键信息
     */
    private String bindMediaInfo;

    /**
     * 磅单号
     */
    private String poundNo;

    /**
     * 监管号
     */
    private String regulatoryNumber;

    /**
     * 所属企业
     */
    private String billOfLadCompany;

    /**
     * 收货企业
     */
    private String receiveCompany;

    /**
     * 货物类型
     */
    private String goodsType;

    /**
     * 货物名称
     */
    private String goodsName;

    private String printGoodsName;

    /**
     * 货物重量
     */
    private Double goodsWeight;

    /**
     * 修改说明
     */
    private String remark;

    /**
     * 申报时间
     */
    private LocalDateTime declareTime;

    /**
     * 处理结果
     */
    private String handleResult;

    /**
     * 回执说明
     */
    private String receipt;

    /**
     * 批次号
     */
    private String batchNumber;

    /**
     * 批次号重量
     */
    private String batchWeight;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 仓库名称
     */
    private String whName;

    /**
     * 运输状态 1 已运输  0未运输
     */
    private String transportStatus;

    /**
     * 过卡重量
     */
    private Double cardWeight;

    /**
     * 1人工填写 2地磅处生成0未区分
     */
    private Boolean source;

    /**
     * 关联的散杂货申报id
     */
    private Integer declareId;

    /**
     * 申报表名，单个申报或者批量申报
     */
    private String tblName;

    private Double grossWeight;

    /**
     * 毛重通道
     */
    private String grossChnl;

    /**
     * 毛重司磅员
     */
    private String grossMan;

    private Double tare;

    private LocalDateTime grossWeightTime;

    private LocalDateTime tareTime;

    /**
     * 皮重通道
     */
    private String tareChnl;

    /**
     * 皮重司磅员
     */
    private String tareMan;

    /**
     * 初始毛重
     */
    private Double startGrossWeight;

    /**
     * 初始皮重
     */
    private Double startTare;

    /**
     * 检验检疫
     */
    private String jyjy;

    /**
     * 型号
     */
    private String modelName;

    /**
     * 记录创建人
     */
    private String createUser;

    /**
     * 记录修改人
     */
    private String updateUser;

    /**
     * 状态0未完成 1已完成
     */
    private Boolean status;

    /**
     * 更新状态为完成的时间
     */
    private LocalDateTime updateTime;

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
     * 司机姓名
     */
    private String driverName;

    /**
     * 司机身份证号
     */
    private String driverIdCard;

    private String mongoliaCarNumber;


}
