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
 * 企业管理-货主企业
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CargoOwnerMagage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 企业名称
     */
    private String name;

    /**
     * 企业简称
     */
    private String shortName;

    /**
     * 企业性质
     */
    private String nature;

    /**
     * 企业车辆
     */
    private Integer cars;

    /**
     * 企业代码
     */
    private String code;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 英文名称
     */
    private String englishName;

    /**
     * 注册时间
     */
    private LocalDateTime registerTime;

    /**
     * 业务联系人电话
     */
    private String busiPersonPhone;

    /**
     * 企业地址
     */
    private String location;

    /**
     * 经营范围
     */
    private String mRange;

    /**
     * 海关编号
     */
    private String customsNo;

    /**
     * 组织编号
     */
    private String organizeNo;

    /**
     * 是否拖车 0是 1否
     */
    private String isTrailer;

    /**
     * 备注
     */
    private String remark;

    /**
     * 软删除时间戳
     */
    private Integer deleteTime;

    /**
     * 堆场名称
     */
    private String yardName;


}
