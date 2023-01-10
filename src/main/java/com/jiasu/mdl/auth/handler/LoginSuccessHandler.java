package com.jiasu.mdl.auth.handler;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jiasu.mdl.auth.cache.AuthorizationCacheService;
import com.jiasu.mdl.auth.constant.Constants;
import com.jiasu.mdl.auth.entity.JwtUser;
import com.jiasu.mdl.auth.utils.JwtTokenUtil;
import com.jiasu.mdl.auth.utils.RestResponseUtil;
import com.jiasu.mdl.entity.SysUser;
import com.jiasu.mdl.mapper.AccessMapper;
import com.jiasu.mdl.mapper.RoleMapper;
import com.jiasu.mdl.mapper.SysUserMapper;
import com.jiasu.mdl.entity.Response;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @Version : 1.0
 * @Description : 登录成功处理器
 * @Author : jzyan
 * @CreateDate : 2020/09/16 18:05
 */
@Slf4j
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthorizationCacheService cacheService;
    @Autowired
    private ThreadPoolTaskExecutor baseExeExecutor;
    @Autowired
    SysUserMapper sysUserMapper;
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    AccessMapper accessMapper;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        Date startDate = new Date();
        long startTime = System.currentTimeMillis();
        Object obj = authentication.getPrincipal();
        String username;
        if (obj instanceof String) {
            username = (String) obj;
        } else {
            UserDetails userDetails = (UserDetails) obj;
            username = userDetails.getUsername();
        }
        // TODO 获取登录用户 构建jwt
        SysUser sysUser = sysUserMapper.selectOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, username));
        JwtUser jwtUser = new JwtUser(sysUser.getId(), sysUser.getUsername(), sysUser.getPwd(), sysUser.getState(), null);

        // 缓存登录用户
        cacheService.putUser(jwtUser.getId() + ":" + jwtUser.getUsername(), JSON.toJSONString(jwtUser));
        Map<String, Object> claims = new HashMap<>(3);
        String jti = UUID.randomUUID() + "-" + System.currentTimeMillis();
        claims.put("username", jwtUser.getUsername());
        claims.put("userId", jwtUser.getId());
        claims.put(Claims.ID, jti);
        // 缓存token
        cacheService.putToken(jwtUser.getId() + ":" + jwtUser.getUsername(), jti);

        String token = jwtTokenUtil.getAccessToken(String.valueOf(jwtUser.getId()), claims);
        token = Base64.getEncoder().encodeToString((Constants.TOKEN_HEAD + token).getBytes("UTF-8"));
        claims.clear();
        claims.put("token", token);
        claims.put("username", jwtUser.getUsername());

        // 添加日志
        this.saveLog(request, username, startDate, startTime, Response.ok(claims));
        RestResponseUtil.response(response, Response.ok(claims));
    }

    /**
     * 添加日志
     *
     * @param request
     * @param startDate
     * @param username
     * @param startTime
     */
    private void saveLog(HttpServletRequest request, String username, Date startDate, long startTime, Response claims) {
        baseExeExecutor.submit(() -> {
            //添加日志

            return true;
        });
    }

}
