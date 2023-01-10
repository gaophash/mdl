package com.jiasu.mdl.auth.handler;


import com.jiasu.mdl.auth.cache.AuthorizationCacheService;
import com.jiasu.mdl.auth.entity.JwtUser;
import com.jiasu.mdl.auth.utils.RestResponseUtil;
import com.jiasu.mdl.entity.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Version : 1.0
 * @Description : 退出成功处理器
 * @Author : gaopeng
 * @CreateDate : 2020/09/16 18:08
 */
@Slf4j
@Component
public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler {
    @Autowired
    private AuthorizationCacheService cacheService;

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        JwtUser user = (JwtUser) authentication.getPrincipal();
        cacheService.clearAll(user.getId() + ":" + user.getUsername());
        RestResponseUtil.response(response, new Response(200, "退出成功", null));
    }
}
