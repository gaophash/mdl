package com.jiasu.mdl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统钩子表
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class PreHook implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "hook_id", type = IdType.AUTO)
    private Long hookId;

    /**
     * 标题
     */
    private String title;

    /**
     * 钩子名称
     */
    private String name;

    /**
     * 插件
     */
    private String plugin;

    /**
     * 方法
     */
    private String function;

    /**
     * 描述
     */
    private String description;

    /**
     * 是否系统钩子
     */
    private Boolean system;

    /**
     * 排序
     */
    private Integer listorder;

    /**
     * 创建时间
     */
    private Long createTime;

    /**
     * 更新时间
     */
    private Long updateTime;

    /**
     * 状态
     */
    private Boolean status;


}
