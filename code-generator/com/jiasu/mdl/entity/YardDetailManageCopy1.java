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
 * 堆场详情管理

 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class YardDetailManageCopy1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 集装箱号
     */
    private String containerNumber;

    /**
     * 货物名称
     */
    private String goodsName;

    /**
     * 存放堆场
     */
    private String yardName;

    /**
     * 堆场区域
     */
    private String yardRegion;

    /**
     * 存放贝位
     */
    private String location;

    /**
     * 批次号
     */
    private String batchNumber;

    /**
     * 货物重量
     */
    private Integer goodsWeight;

    /**
     * 集装箱重量
     */
    private Integer containerWeight;

    /**
     * 企业名称
     */
    private String enterpriseName;

    /**
     * 入场时间
     */
    private LocalDateTime createTime;


}
