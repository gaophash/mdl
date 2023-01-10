package com.jiasu.mdl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 会员登录日志表
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AdminLoginLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 管理员ID
     */
    private Long adminId;

    /**
     * username
     */
    private String username;

    private String nickName;

    /**
     * 登录IP
     */
    private String loginIp;

    /**
     * 客户端Key
     */
    private String clientKey;

    /**
     * 用户客户端
     */
    private String userAgent;

    /**
     * 客户端cookie
     */
    private String httpCookie;

    /**
     * 登录地点
     */
    private String loginAddress;

    /**
     * 地区信息
     */
    private String loginArea;

    /**
     * 登录时间
     */
    private Long loginTime;

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
