package com.jiasu.mdl.entity.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 修改密码入参
 * </p>
 *
 * @author gaopeng
 * @since 2023-01-10
 */
@Data
@ApiModel("修改密码")
public class UpdatePasswordDTO implements Serializable {

    private static final long serialVersionUID = -7571458648636691452L;

    @NotBlank(message = "not null")
    @ApiModelProperty(value = "旧密码, 需要md5进行加密", required = true)
    private String oldPassword;

    @NotBlank(message = "not null")
    @ApiModelProperty(value = "新密码 需要md5进行加密", required = true)
    private String newPassword;

    @NotBlank(message = "not null")
    @ApiModelProperty(value = "确认新密码 需要md5进行加密", required = true)
    private String confirmPassword;

}
