package com.jiasu.mdl.controller;


import com.jiasu.mdl.entity.Response;
import com.jiasu.mdl.entity.SysUser;
import com.jiasu.mdl.entity.dto.SysUserDTO;
import com.jiasu.mdl.entity.dto.SysUserQueryDTO;
import com.jiasu.mdl.entity.dto.UpdatePasswordDTO;
import com.jiasu.mdl.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 账号前端控制器
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@RestController
@RequestMapping("/sys-user")
@Api(tags = "账号管理")
public class SysUserController {

    @Autowired
    ISysUserService iSysUserService;

    @GetMapping("/info")
    @ApiOperation(value = "个人信息", tags = "账号管理")
    public Response info() {
        return iSysUserService.getSysUser();
    }

    @GetMapping("/listByPage")
    @ApiOperation(value = "列表高级查询", tags = "账号管理")
    public Response listByPage(SysUserQueryDTO sysUserQueryDTO) {
        return iSysUserService.listByPage(sysUserQueryDTO);
    }

    @GetMapping("findById")
    @ApiOperation(value = "根据id查询", tags = "账号管理")
    public Response listByPage(SysUserDTO sysUserDTO) {
        return iSysUserService.findById(sysUserDTO);
    }

    @PostMapping("deleteById")
    @ApiOperation(value = "根据id删除", tags = "账号管理")
    public Response deleteById(SysUserDTO sysUserDTO) {
        iSysUserService.removeById(sysUserDTO.getId());
        return Response.ok();
    }
    @PostMapping("enableAndDisable")
    @ApiOperation(value = "禁用/启用", tags = "账号管理")
    public Response enableAndDisable(SysUserDTO sysUserDTO) {
        iSysUserService.enableAndDisable(sysUserDTO);
        return Response.ok();
    }

    @PostMapping("update")
    @ApiOperation(value = "用户修改", tags = "账号管理")
    public Response update(SysUser sysUser) {
        iSysUserService.update(sysUser);
        return Response.ok();
    }

    @PostMapping("insert")
    @ApiOperation(value = "用户新增", tags = "账号管理")
    public Response insert(SysUser sysUser) {
        iSysUserService.insert(sysUser);
        return Response.ok();
    }

    @PostMapping("updatePwd")
    @ApiOperation(value = "修改密码", tags = "账号管理")
    public Response updatePwd(UpdatePasswordDTO updatePasswordDTO) {
        iSysUserService.updatePwd(updatePasswordDTO);
        return Response.ok();
    }

}

