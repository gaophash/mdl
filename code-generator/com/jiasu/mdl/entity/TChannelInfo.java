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
 * 通道配置
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TChannelInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属场站ID
     */
    private String stationId;

    /**
     * 通道编号
     */
    private String cChnlNo;

    /**
     * 通道名称
     */
    private String cChnlName;

    /**
     * 车道类型：0、货运车道；1、行政车道
     */
    private String cChnlType;

    /**
     * 车道方向：I，进场；E，出场
     */
    private String cChnlDirection;

    /**
     * 创建时间
     */
    @TableField("CRTIME")
    private LocalDateTime crtime;

    /**
     * 创建人
     */
    @TableField("CRUSER")
    private String cruser;

    /**
     * 创建人名称
     */
    @TableField("CRUSERNAME")
    private String crusername;

    /**
     * 状态（0正常 1停用）
     */
    private String status;

    /**
     * 地磅名称
     */
    private String poundName;

    /**
     * 设备当前状态：0,停止；1，启动'
     */
    private Integer passTimes;

    /**
     * 是否删除状态
     */
    @TableField("DEL")
    private Integer del;

    private String startstatus;

    /**
     * 软删除时间戳
     */
    private Integer deleteTime;

    /**
     * 1  进口通道  2  出口通道 
     */
    private Boolean type;


}
