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
 * 
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TCollectManualProcess implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 会话编号
     */
    private String sessionId;

    /**
     * 场站代码
     */
    private String areaId;

    /**
     * 通道代码
     */
    private String chnlNo;

    /**
     * 通道名称
     */
    private String chnlName;

    /**
     * 进出标志
     */
    private String iEFlag;

    /**
     * 采集标志,自动、补采、手工输入
     */
    private String getherMode;

    /**
     * ic号
     */
    private String icCardNo;

    /**
     * 车牌识别车牌号
     */
    private String veLicenseNo;

    /**
     * 地磅称重
     */
    private String grossWt;

    /**
     * 最终处理结果：y为放行，n为报警，m为待人工确认
     */
    private String processResult;

    /**
     * 进出时间
     */
    private LocalDateTime inoutTime;

    /**
     * 过卡照片
     */
    private String imgPath;

    /**
     * 描述信息
     */
    private String remark;

    /**
     * 过卡类型 1正常过卡 2人工过卡 3人工补采 4异常过卡
     */
    private String type;

    /**
     * 电子车牌号
     */
    private String rfLicenseNo;

    private Integer readStatus;


}
