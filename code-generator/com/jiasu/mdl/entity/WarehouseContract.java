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
 * 仓储管理-仓库合同
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WarehouseContract implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 企业名称
     */
    private String companyNae;

    /**
     * 仓库名称
     */
    private String whName;

    /**
     * 仓库用途
     */
    private String whEffect;

    /**
     * 价格
     */
    private Double price;

    /**
     * 定金
     */
    private Double deposit;

    /**
     * 是否支付 1是 0否
     */
    private String isPay;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 到期时间
     */
    private LocalDateTime endTime;

    /**
     * 阶梯价格；形式：开始重量,结束重量,价格|开始重量,结束重量,价格
     */
    private String ladderPrice;

    /**
     * 状态1可用 0过期
     */
    private Boolean status;

    /**
     * 合同文档
     */
    private String doc;

    /**
     * 备注
     */
    private String remark;

    /**
     * 软删除时间戳
     */
    private Integer deleteTime;


}
