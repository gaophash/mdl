package com.jiasu.mdl.auth.cache;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jiasu.mdl.auth.constant.RedisConstant;
import com.jiasu.mdl.auth.entity.JwtUser;
import com.jiasu.mdl.auth.utils.JwtTokenUtil;
import com.jiasu.mdl.entity.Access;
import com.jiasu.mdl.entity.Role;
import com.jiasu.mdl.mapper.AccessMapper;
import com.jiasu.mdl.mapper.RoleMapper;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Version : 1.0
 * @Description : 基于redis
 * @Author : jzyan
 * @CreateDate : 2020/10/30 15:38
 */
@Component
public class RedisAuthorizationCacheService implements AuthorizationCacheService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Qualifier("jwtUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    AccessMapper accessMapper;

    @Override
    public void putUser(String username, String user) {
        stringRedisTemplate.opsForHash().put(RedisConstant.AUTH_USER_PREFIX, username, user);
    }

    @Override
    public void removeUserByUsername(String username) {
        stringRedisTemplate.opsForHash().delete(RedisConstant.AUTH_USER_PREFIX, username);
    }

    @Override
    public JwtUser getUserByUsername(String username) {
        JwtUser jwtUser;
        Object ob = stringRedisTemplate.opsForHash().get(RedisConstant.AUTH_USER_PREFIX, username);
        if (ObjectUtils.isEmpty(ob)) {
            jwtUser = (JwtUser) userDetailsService.loadUserByUsername(username.split(":")[1]);
            this.putUser(username, JSON.toJSONString(jwtUser));
        } else {
            jwtUser = JSON.parseObject((String) ob, JwtUser.class);
        }
        //创建List集合，用来保存用户菜单权限，GrantedAuthority对象代表赋予当前用户的权限
        List<GrantedAuthority> authorities = new ArrayList<>();
        //获得当前用户角色集合
        Access access = accessMapper.selectOne(Wrappers.<Access>lambdaQuery().eq(Access::getId, jwtUser.getId()));
        if (null != access) {
            Role role = roleMapper.selectById(access.getRoleId());
            authorities.add(new SimpleGrantedAuthority(role.getRules()));
        }
        jwtUser.setAuthorities(authorities);
        return jwtUser;
    }

    @Override
    public void putToken(String username, String token) {
        stringRedisTemplate.opsForValue().set(RedisConstant.AUTH_TOKEN_PREFIX + username, token
                , jwtTokenUtil.getAccessTokenExpireTime().toHours(), TimeUnit.HOURS);
    }

    @Override
    public void removeTokenByUsername(String username) {
        stringRedisTemplate.delete(RedisConstant.AUTH_TOKEN_PREFIX + username);
    }

    @Override
    public String getTokenByUsername(String username) {
        return stringRedisTemplate.opsForValue().get(RedisConstant.AUTH_TOKEN_PREFIX + username);
    }

    @Override
    public void clearAll(String username) {
        SecurityContextHolder.clearContext();
        this.removeUserByUsername(username);
        this.removeTokenByUsername(username);
    }


}
