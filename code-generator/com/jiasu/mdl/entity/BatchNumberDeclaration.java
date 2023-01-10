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
 * 智能申报
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BatchNumberDeclaration implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 通关单号
     */
    private String ccno;

    /**
     * 通关单批次号
     */
    private String bnoccf;

    /**
     * 通关单重量
     */
    private String wfccf;

    /**
     * 所属公司
     */
    private String company;

    /**
     * 关联车辆信息
     */
    private String carRefInfo;

    /**
     * 剩余重量
     */
    private String bloWeight;

    /**
     * 处理结果 0已申报 1待申报 2通过 3拒绝
     */
    private String pResult;

    /**
     * 重量
     */
    private String weight;

    private LocalDateTime createTime;

    /**
     * 所属仓库
     */
    private String wh;


}
