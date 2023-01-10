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
 * 进境确报申报
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CustomsEntryDeclare implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 批次号
     */
    private String batchNumber;

    /**
     * 运输工具代码
     */
    private String transportCode;

    /**
     * 运输工具名称
     */
    private String transportName;

    /**
     * 驾驶员代码
     */
    private String driverCode;

    /**
     * 驾驶员名称
     */
    private String driverName;

    /**
     * 司乘人员
     */
    private String driverConductor;

    /**
     * 健康状况
     */
    private String health;

    /**
     * 是否接种疫苗1是0否
     */
    private Boolean isVaccinate;

    /**
     * 确报传输人名称
     */
    private String transName;

    /**
     * 报文发送方代码
     */
    private String sendCode;

    /**
     * 进出境口岸海关代码
     */
    private String customsCode;

    /**
     * 抵达关境内第一目的港日期
     */
    private LocalDate arriveDate;

    /**
     * 操作人
     */
    private String createUser;

    /**
     * 处理结果 0已申报 1待申报 2通过 3拒绝 4撤销中 40已经完结
     */
    private String pResult;

    /**
     * 申报日期
     */
    private LocalDateTime declareTime;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

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
