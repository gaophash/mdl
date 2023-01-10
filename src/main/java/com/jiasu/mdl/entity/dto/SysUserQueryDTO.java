package com.jiasu.mdl.entity.dto;

import com.jiasu.mdl.entity.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *  
 *
 * @author GaoPeng
 * @Package com.jiasu.mdl.entity.dto
 * @Description:
 * @date 2023/1/10 13:52
 */
@Data
public class SysUserQueryDTO extends Page {

    @ApiModelProperty(value = "所选角色id")
    private String roleId;
}
