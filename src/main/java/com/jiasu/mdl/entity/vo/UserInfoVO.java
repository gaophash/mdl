package com.jiasu.mdl.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *  
 *
 * @author GaoPeng
 * @Package com.jiasu.mdl.entity
 * @Description: 账号信息页面展示类
 * @date 2023/1/10 11:52
 */
@Data
public class UserInfoVO implements Serializable {
    @ApiModelProperty("用户名称")
    private String nickName;
    @ApiModelProperty("账号")
    private String userName;
    @ApiModelProperty("角色名")
    private String role;
    @ApiModelProperty("到期时间")
    private String date;
}
