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
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 堆场名称或仓库名称（作业人员绑定）
     */
    private String name;

    /**
     * 所属企业
     */
    private String enterprise;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 认证码
     */
    private String encrypt;

    /**
     * 认证秘钥
     */
    private String sessionKey;

    /**
     * token
     */
    private String token;

    /**
     * 性别
     */
    private String sex;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 创建人
     */
    private String createOpt;

    /**
     * 状态1 正常 0禁用
     */
    private Integer state;

    /**
     * 登陆时间
     */
    private LocalDateTime loginTime;

    /**
     * 通道权限
     */
    private String chnlAuth;

    private String loginIp;

    /**
     * 登陆次数
     */
    private Integer loginNum;

    /**
     * 软删除时间戳
     */
    private Integer deleteTime;

    private Integer updateTime;

    private Integer createTime;


}
