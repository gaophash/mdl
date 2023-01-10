package com.jiasu.mdl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 删除记录表
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DeleteLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 1、散杂货 2批量申报 3过卡管理 4入库单管理 5出库单管理 6企业管理 7仓库管理 8仓库货物 9仓库合同 10货运车辆 11行政车辆 12结算系统 13用户管理 14用户角色管理 15菜单管理
     */
    private Integer type;

    /**
     * 来源
     */
    private String source;

    /**
     * 主键ID
     */
    private Integer tableId;

    /**
     * 表名
     */
    private String tableName;

    /**
     * 删除原因
     */
    private String deleteRemark;

    /**
     * 删除人
     */
    private String deleteUser;

    /**
     * 删除时间
     */
    private Integer createTime;

    /**
     * 软删除时间戳
     */
    private Integer softDelete;


}
