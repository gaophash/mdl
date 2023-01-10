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
public class OperatingMan implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 作业管理人员
     */
    private String operatingMan;

    /**
     * 负责 煤矿
     */
    private String bunkerResponsible;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 删除时间时间戳
     */
    private LocalDateTime deleteTime;

    /**
     * 账号名称
     */
    private String userList;


}
