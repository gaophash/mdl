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
public class SysDict implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 字典类型表关联
     */
    private Integer dictTypeId;

    /**
     * 字典名称
     */
    private String k;

    /**
     * 字典数据
     */
    private String v;

    /**
     * 1 蒙煤车 2 外发车
     */
    private Integer carType;

    /**
     * 入库到 1 仓库  2 堆场  
     */
    private Integer rkType;

    /**
     * 堆场区域
     */
    private String yardRegion;

    /**
     * 堆场名称
     */
    private String yardName;

    /**
     * 堆场位置
     */
    private String yardPosition;

    /**
     * 仓库名称
     */
    private String warehouseName;

    /**
     * 颜色
     */
    private String colour;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态 1:启用   0:禁用
     */
    private String status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

    /**
     * 软删除时间戳
     */
    private Integer deleteTime;


}
