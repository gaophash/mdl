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
 * 仓储管理-仓库货物
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WarehouseGoods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 货物名称
     */
    private String goodsName;

    /**
     * 货物类型
     */
    private String goodsType;

    /**
     * 所属仓库
     */
    private String bindWh;

    /**
     * 所属企业
     */
    private String bindCompany;

    /**
     * 货物重量
     */
    private Double goodsWeight;

    /**
     * 货物体积
     */
    private String goodsVolume;

    /**
     * 货物数量
     */
    private String goodsNum;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 软删除字段
     */
    private Integer deleteTime;


}
