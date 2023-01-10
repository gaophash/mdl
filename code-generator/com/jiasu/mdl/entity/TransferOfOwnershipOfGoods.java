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
 * 货权转让
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TransferOfOwnershipOfGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 货主企业
     */
    private String company;

    /**
     * 转让重量
     */
    private Double companyWeight;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 批次号
     */
    private String tgdpch;

    /**
     * 删除时间戳
     */
    private Integer deleteTime;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 所属煤仓
     */
    private String bindWh;

    /**
     * 货物名称
     */
    private String goodsName;


}
