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
 * 车辆管理

 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class VehicleManage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 车辆编号
     */
    private String vehicleNumber;

    /**
     * 车辆账号
     */
    private String vehicleAccountNumber;

    /**
     * 车辆类型 吊车 板车 倒装 
     */
    private String type;

    /**
     * 车辆状态 1启用 2禁用
     */
    private Integer status;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
