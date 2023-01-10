package com.jiasu.mdl.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *  
 *
 * @author GaoPeng
 * @Package com.jiasu.mdl.entity.vo
 * @Description:
 * @date 2023/1/10 14:00
 */
@Data
public class SysUserVO implements Serializable {

    @ApiModelProperty("用户名")
    private String nickName;

    @ApiModelProperty("账号")
    private String username;

    @ApiModelProperty("状态 1 正常 0禁用")
    private Integer state;

    @ApiModelProperty("角色名")
    private String role;

    @ApiModelProperty("创建时间")
    private Date createTime;

}
