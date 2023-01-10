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
 * 错误日志
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AutoLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 过卡记录sessionid
     */
    private String processId;

    /**
     * 通道编号
     */
    private String chnlNo;

    /**
     * 进出标志I进 E出
     */
    private String iEFlag;

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 电子车牌号
     */
    private String rfLicenseNo;

    /**
     * 过卡结果最终处理结果：y为放行，n为报警，m为待人工确认
     */
    private String processResult;

    private LocalDateTime inoutTime;

    /**
     * 错误描述
     */
    private String description;

    /**
     * 过卡结果0失败1成功
     */
    private Boolean isSuccess;

    /**
     * 入库单id
     */
    private Integer receiptId;

    /**
     * 出库单id
     */
    private Integer billId;

    /**
     * 蒙煤车1外发车2
     */
    private Boolean type;

    private LocalDateTime createTime;

    /**
     * 软删除时间戳
     */
    private Integer deleteTime;

    private String handleIndex;

    private String emptyIndex;

    private String firstRes;

    private String emptyRes;


}
