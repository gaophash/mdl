package com.jiasu.mdl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 企业集装箱
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class ContainerInformationEnterprise implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 集装箱号
     */
    private String containerNumber;

    /**
     * 集装箱号2
     */
    private String containerNumber2;

    /**
     * 货物类型
     */
    private String goodsType;

    /**
     * 增加时间
     */
    private Integer addTime;

    /**
     * 添加者用户名
     */
    private String addUser;

    /**
     * 1，未入场 2，已入场（核销）3.已出场  
     */
    private Integer status;

    /**
     * 修改说明
     */
    private String modifyRemark;

    /**
     * 收货单位
     */
    private String receiveCompany;

    /**
     * 发货单位
     */
    private String company;

    /**
     * 蒙古车号
     */
    private String mongoliaCarNumber;

    /**
     * 毛重
     */
    private Double grossWeight;

    /**
     * 皮重
     */
    private Double tareWeight;

    /**
     * 净重
     */
    private Double netWeight;


}
