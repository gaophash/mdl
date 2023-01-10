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
 * 集装箱堆场数据申报日志
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CsaMessageSend implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String messageId;

    /**
     * 功能代码
     */
    private String functionCode;

    /**
     * 报文类型
     */
    private String messageType;

    /**
     * 发送xml
     */
    private String commondSend;

    /**
     * 发送时间
     */
    private LocalDateTime sendTime;

    /**
     * 关联申报ID
     */
    private Integer collectId;

    /**
     * 反馈xml
     */
    private String commondOut;

    /**
     * 反馈时间
     */
    private LocalDateTime outTime;

    /**
     * 反馈结果
     */
    @TableField("feedbackContent")
    private String feedbackContent;

    /**
     * 表名
     */
    @TableField("tableName")
    private String tableName;


}
