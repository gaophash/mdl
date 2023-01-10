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
 * 堆场管理

 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class YardManageCopy1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 堆场名称
     */
    private String yardName;

    /**
     * 堆场位置
     */
    private String yardPosition;

    /**
     * 堆场类型
     */
    private String yardType;

    /**
     * 总存放数
     */
    private Integer allStorageNumber;

    /**
     * 已存放数
     */
    private Integer storageNumber;

    /**
     * 行
     */
    private Integer hang;

    /**
     * 列
     */
    private Integer lie;

    /**
     * 存放详情
     */
    private String storageDetails;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


}
