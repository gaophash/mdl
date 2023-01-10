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
 * 用户-司机账号表
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SysUserDriver implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 昵称
     */
    private String nickName;

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
    private Boolean state;

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

    /**
     * 来源1场站 2报关
     */
    private Boolean isSource;

    /**
     * 车牌号
     */
    private String carNumber;

    /**
     * 身份证号
     */
    private String idNumber;

    /**
     * 是否核验  0否 1是
     */
    private Integer isVerification;

    /**
     * 是否核验通过  0否 1是 
     */
    private Integer isVerificationPass;

    /**
     * 指纹码
     */
    private String fingerprint;

    /**
     * 指纹图片路径
     */
    private String fingerprintjpg;

    /**
     * 是否核验通过  0否 1是 
     */
    private Integer isVerificationPassFingerprint;


}
