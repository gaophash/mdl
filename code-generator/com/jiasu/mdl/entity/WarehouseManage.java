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
 * 仓储管理—仓库管理
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WarehouseManage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 仓库名称
     */
    private String whName;

    /**
     * 仓库类型
     */
    private String whType;

    /**
     * 仓库位置
     */
    private String whLocaltion;

    /**
     * 仓库容量 单位kg
     */
    private Double whWeight;

    /**
     * 剩余体积
     */
    private String syVolume;

    /**
     * 剩余可用库存
     */
    private Double syAvailableWeight;

    /**
     * 仓库面积
     */
    private String whArea;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 1:主仓库  2:子仓库
     */
    private String ident;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 软删除时间戳
     */
    private Integer deleteTime;


}
