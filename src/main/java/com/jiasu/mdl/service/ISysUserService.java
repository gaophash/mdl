package com.jiasu.mdl.service;

import com.jiasu.mdl.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jiasu.mdl.entity.Response;
import com.jiasu.mdl.entity.dto.SysUserDTO;
import com.jiasu.mdl.entity.dto.SysUserQueryDTO;
import com.jiasu.mdl.entity.dto.UpdatePasswordDTO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
public interface ISysUserService extends IService<SysUser> {

    Response getSysUser();

    Response listByPage(SysUserQueryDTO sysUserQueryDTO);

    Response findById(SysUserDTO sysUserDTO);

    Response enableAndDisable(SysUserDTO sysUserDTO);

    Response update(SysUser sysUser);


    Response insert(SysUser sysUser);

    Response updatePwd(UpdatePasswordDTO updatePasswordDTO);
}
