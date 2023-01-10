package com.jiasu.mdl.auth;


import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jiasu.mdl.auth.entity.JwtUser;
import com.jiasu.mdl.entity.Access;
import com.jiasu.mdl.entity.Role;
import com.jiasu.mdl.entity.SysUser;
import com.jiasu.mdl.mapper.AccessMapper;
import com.jiasu.mdl.mapper.RoleMapper;
import com.jiasu.mdl.mapper.SysUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @Version : 1.0
 * @Description : 登录
 * @Author : gaopeng
 * @CreateDate : 2020/09/17 15:10
 */
@Slf4j
@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    AccessMapper accessMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)) {
            throw new UsernameNotFoundException("未知用户:" + username);
        }
        //调用持久层接口findByUsername方法查询用户。
        SysUser sysUser = sysUserMapper.selectOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username));
        if (null == sysUser) {
            throw new UsernameNotFoundException("用户不存在");
        }
        //创建List集合，用来保存用户菜单权限，GrantedAuthority对象代表赋予当前用户的权限
        List<GrantedAuthority> authorities = new ArrayList<>();
        //获得当前用户角色集合
        Access access = accessMapper.selectOne(Wrappers.<Access>lambdaQuery().eq(Access::getId, sysUser.getId()));
        if (null != access) {
            Role role = roleMapper.selectById(access.getRoleId());

            authorities.add(new SimpleGrantedAuthority(role.getRules()));
        }

        //此处返回的是org.springframework.security.core.userdetails.User类，该类是SpringSecurity内部的实现
        //org.springframework.security.core.userdetails.User类实现了UserDetails接口
        return new JwtUser(sysUser.getId(), sysUser.getUsername(), sysUser.getPwd(), sysUser.getState(), authorities);
    }

}
