package com.jiasu.mdl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限节点
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Node implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父级ID
     */
    private Integer pid;

    /**
     * 验证规则
     */
    private String name;

    /**
     * 标题
     */
    private String title;

    /**
     * 模块
     */
    private String module;

    /**
     * 控制器
     */
    private String controller;

    /**
     * 方法
     */
    private String actions;

    /**
     * 参数
     */
    private String param;

    /**
     * 条件
     */
    @TableField("`condition`")
    private String condition;

    /**
     * 匹配条件
     */
    private String relaction;

    /**
     * 图标
     */
    private String icon;

    /**
     * 等级  1 模块  2 模型  3 方法
     */
    @TableField("`level`")
    private Integer level;

    private Integer type;

    /**
     * 备注
     */
    private String remark;

    /**
     * 数据
     */
    @TableField("`data`")
    private String data;

    /**
     * 是否显示
     */
    @TableField("`show`")
    private Integer show;

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
     * 删除时间
     */
    private Long deleteTime;

    /**
     * 状态
     */
    @TableField("`status`")
    private Integer status;

    /**
     * 来源1场站 2报关
     */
    private Boolean isSource;


}
