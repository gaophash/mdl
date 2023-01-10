package com.jiasu.mdl.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 *  
 *
 * @author GaoPeng
 * @Package com.jiasu.mdl.entity.dto
 * @Description: 账号删除 禁用参数类
 * @date 2023/1/10 15:01
 */
@Data
public class SysUserDTO {

    @ApiModelProperty("用户id")
    private Integer id;

    @ApiModelProperty("状态 1启用 0禁用 启用禁用按钮使用")
    private Integer state;
}
