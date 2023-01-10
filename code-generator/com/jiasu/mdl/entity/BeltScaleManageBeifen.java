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
 * 皮带秤管理
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BeltScaleManageBeifen implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属企业
     */
    private String refCompany;

    /**
     * 所属仓库
     */
    private String refWh;

    /**
     * 值班时间
     */
    private String beOnDuty;

    /**
     * 品名
     */
    private String brand;

    /**
     * 班组
     */
    private String team;

    /**
     * 串口号
     */
    private String comId;

    /**
     * 波特率
     */
    private String baudrate;

    /**
     * 校验位
     */
    private String parity;

    /**
     * 重量
     */
    private String weight;

    /**
     * 货物名称
     */
    private String goodsName;

    private String batchNumber;

    private String batchWeight;

    private LocalDateTime createTime;

    /**
     * 软删除时间戳
     */
    private Integer deleteTime;


}
