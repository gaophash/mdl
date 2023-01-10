package com.jiasu.mdl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jiasu.mdl.auth.utils.SessionUtil;
import com.jiasu.mdl.entity.*;
import com.jiasu.mdl.entity.dto.SysUserDTO;
import com.jiasu.mdl.entity.dto.SysUserQueryDTO;
import com.jiasu.mdl.entity.dto.UpdatePasswordDTO;
import com.jiasu.mdl.entity.vo.SysUserVO;
import com.jiasu.mdl.entity.vo.UserInfoVO;
import com.jiasu.mdl.enums.ErrorCodeEnum;
import com.jiasu.mdl.mapper.AccessMapper;
import com.jiasu.mdl.mapper.RoleMapper;
import com.jiasu.mdl.mapper.SysUserMapper;
import com.jiasu.mdl.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jiasu.mdl.utils.TimeStampToDateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author GaoPeng
 * @since 2023-01-09
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    SessionUtil sessionUtil;
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    AccessMapper accessMapper;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public Response getSysUser() {
        int userId = sessionUtil.getUserId();
        SysUser sysUser = sysUserMapper.selectOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getId, userId));
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setNickName(sysUser.getNickName());
        userInfoVO.setUserName(sysUser.getUsername());
        Access access = accessMapper.selectOne(Wrappers.<Access>lambdaQuery().eq(Access::getUserId, userId));
        if (null == access) {
            userInfoVO.setRole("无");
        } else {
            Role role = roleMapper.selectOne(Wrappers.<Role>lambdaQuery().eq(Role::getId, access.getRoleId()));
            userInfoVO.setRole(role.getTitle());
        }

        return Response.ok(userInfoVO);
    }

    @Override
    public Response listByPage(SysUserQueryDTO sysUserQueryDTO) {
        com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysUser> pageInfo = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysUser>(sysUserQueryDTO.getCurrentPage(), sysUserQueryDTO.getPageSize());
        LambdaQueryWrapper<SysUser> wrapper = new LambdaQueryWrapper<SysUser>();
        List<Long> userIds = new ArrayList<>();
        if (StringUtils.isNotBlank(sysUserQueryDTO.getRoleId())) {
            List<Access> accessList = accessMapper.selectList(Wrappers.<Access>lambdaQuery().eq(Access::getRoleId, sysUserQueryDTO.getRoleId()));
            userIds = accessList.stream().map(Access::getUserId).collect(Collectors.toList());
            wrapper.in(SysUser::getId, userIds);
        }
        wrapper.orderByDesc(SysUser::getCreateTime);
        IPage<SysUser> pages = sysUserMapper.selectPage(pageInfo, wrapper);
        IPage<SysUserVO> resultPage = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<SysUserVO>(sysUserQueryDTO.getCurrentPage(), sysUserQueryDTO.getPageSize());
        List<SysUserVO> list = new ArrayList<>();
        if (pages != null) {
            List<SysUser> records = pages.getRecords();
            for (SysUser record : records) {
                SysUserVO sysUserVO = new SysUserVO();
                sysUserVO.setUsername(record.getUsername());
                sysUserVO.setNickName(record.getNickName());
                sysUserVO.setState(record.getState());
                Access access = accessMapper.selectOne(Wrappers.<Access>lambdaQuery().eq(Access::getUserId, record.getId()));
                if (null == access) {
                    sysUserVO.setRole("");
                } else {
                    Role role = roleMapper.selectOne(Wrappers.<Role>lambdaQuery().eq(Role::getId, access.getRoleId()));
                    sysUserVO.setRole(role.getTitle());
                }
                sysUserVO.setCreateTime(TimeStampToDateUtil.TimeStampToDate(record.getCreateTime()));
                list.add(sysUserVO);
            }
            resultPage.setRecords(list);
            resultPage.setTotal(pages.getTotal());
            resultPage.setSize(pages.getSize());
        }
        return Response.ok(resultPage);
    }

    @Override
    public Response findById(SysUserDTO sysUserDTO) {
        SysUser sysUser = sysUserMapper.selectOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getId, sysUserDTO.getId()));
        return Response.ok(sysUser);
    }

    @Override
    @Transactional
    public Response enableAndDisable(SysUserDTO sysUserDTO) {
        SysUser sysUser = sysUserMapper.selectOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getId, sysUserDTO.getId()));
        sysUser.setState(sysUserDTO.getState());
        sysUserMapper.updateById(sysUser);
        return Response.ok();
    }

    @Override
    public Response update(SysUser sysUser) {

        return null;
    }

    @Override
    public Response insert(SysUser sysUser) {

        return null;
    }

    @Override
    public Response updatePwd(UpdatePasswordDTO updatePasswordDTO) {
        int userId = sessionUtil.getUserId();
        SysUser sysUser = sysUserMapper.selectById(userId);
        if (!updatePasswordDTO.getNewPassword().equals(updatePasswordDTO.getConfirmPassword())) {
            return Response.error(ErrorCodeEnum.CODE_1502008);
        } else if (!updatePasswordDTO.getOldPassword().equals(sysUser.getPwd())) {
            return Response.error(ErrorCodeEnum.CODE_1502007);
        }
        sysUser.setPwd(updatePasswordDTO.getNewPassword());
        sysUserMapper.updateById(sysUser);
        return Response.ok();
    }
}
