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
 * 自动过卡消息推送
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AutoMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 类型1入库单 2出库单
     */
    private Boolean type;

    /**
     * 过卡记录sessionid
     */
    private String processId;

    private String chnlNo;

    /**
     * 通道名称
     */
    private String chnlName;

    private String msg;

    /**
     * 车牌号
     */
    private String carNo;

    /**
     * 电子车牌号
     */
    private String rfLicenseNo;

    /**
     * 出库单id
     */
    private Integer billId;

    /**
     * 进出场I进E出
     */
    private String iEFlag;

    /**
     * 过卡时间
     */
    private LocalDateTime inoutTime;

    /**
     * 入库单ID
     */
    private Integer receiptId;

    /**
     * 处理结果1已经处理0未处理
     */
    private Boolean result;

    /**
     * 是否已读1是0否
     */
    private Boolean isRead;

    private LocalDateTime createTime;


}
