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
 * 过卡管理
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TCollectProcess implements Serializable {

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
     * 采集方式：A 自动，M 人工补采。B 由后台人工录入验放。默认如果不存在该节点则认为是自动
     */
    private String getherMode;

    /**
     * 驾驶员编号
     */
    private String drCustomsNo;

    /**
     * ic号
     */
    private String icCardNo;

    /**
     * 车辆海关编号
     */
    private String veCustomsNo;

    /**
     * 车牌识别车牌号
     */
    private String veLicenseNo;

    /**
     * 蒙车车牌号
     */
    private String veLicenseNo2;

    /**
     * 集装箱号
     */
    private String contaId;

    /**
     * 电子关锁号(安全智能锁号)
     */
    private String esealId;

    /**
     * 原始车重
     */
    private String veWt;

    /**
     * 地磅称重
     */
    private String grossWt;

    /**
     * 操作关员
     */
    private String operatorId;

    /**
     * 操作时间
     */
    private LocalDateTime operateTime;

    /**
     * 后台核放时间
     */
    private LocalDateTime feedbackTime;

    /**
     * 最终处理结果：y为放行，n为报警，m为待人工确认
     */
    private String processResult;

    /**
     * 后台对前端的敏感设备操作
     */
    private String instruction;

    /**
     * 海关业务方面对返回结果代码，返回给关员
     */
    private String procErrorCode;

    /**
     * 业务逻辑错误解释
     */
    private String procErrorDescription;

    /**
     * 技术错误码
     */
    private String techErrorCode;

    /**
     * 技术错误解释
     */
    private String techErrorDescription;

    /**
     * 舱单货物总重量
     */
    private String declGoodsWeight;

    /**
     * 核放结果详细信息核放结果详细信息（布控、地磅等）
     */
    private String opHint;

    /**
     * 81指令xml
     */
    private String commond81;

    /**
     * 82指令xml
     */
    private String commond82;

    /**
     * 进出时间
     */
    private LocalDateTime inoutTime;

    /**
     * 1：采集系统，2：验放系统，3：通讯系统，10：采集系统数据采集完成，等待验放，11：采集系统处理完成，本次过卡完成，20：验放系统处理完成，等待采集系统执行，21：验放系统场站验放完成，等待海关验放，30：通讯平台发送81完成，31：通讯平台接收82完成。海关验放完成，等待验放平台处理。
     */
    private String status;

    private LocalDateTime recvTime81;

    private LocalDateTime sendTime81;

    private LocalDateTime sendTime82;

    private LocalDateTime recvTime82;

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
     *  1行政车辆 2蒙煤车 3外发车
     */
    private String carType;

    /**
     * 蒙煤车车牌号
     */
    private String rfCardId;

    /**
     * 电子车牌号
     */
    private String rfLicenseNo;

    /**
     * 批次号
     */
    private String batchId;

    /**
     * 验放列表id
     */
    private Integer rellistId;

    /**
     * 检验检疫号
     */
    private String jyjy;

    /**
     * 是否已读 1是0否
     */
    private Boolean isRead;

    /**
     * 软删除时间戳
     */
    private Integer deleteTime;


}
