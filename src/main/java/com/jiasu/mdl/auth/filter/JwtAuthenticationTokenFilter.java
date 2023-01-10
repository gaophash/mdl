package com.jiasu.mdl.auth.filter;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jiasu.mdl.auth.cache.AuthorizationCacheService;
import com.jiasu.mdl.auth.constant.Constants;
import com.jiasu.mdl.auth.entity.JwtUser;
import com.jiasu.mdl.auth.handler.AnonymousAuthEntryPoint;
import com.jiasu.mdl.auth.utils.JwtTokenUtil;
import com.jiasu.mdl.entity.Access;
import com.jiasu.mdl.entity.Role;
import com.jiasu.mdl.mapper.AccessMapper;
import com.jiasu.mdl.mapper.RoleMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.Set;

/**
 * @Version : 1.0
 * @Description : token 验证器
 * @Author : gaopeng
 * @CreateDate : 2020/09/21 17:34
 */
@Slf4j
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {



    private JwtTokenUtil jwtTokenUtil;
    private AnonymousAuthEntryPoint anonymousAuthenticationEntryPoint;
    private AuthorizationCacheService cacheService;
    private Set<String> ignoreUrl;

    public JwtAuthenticationTokenFilter(JwtTokenUtil jwtTokenUtil, AnonymousAuthEntryPoint anonymousAuthenticationEntryPoint, AuthorizationCacheService cacheService, Set<String> ignoreUrl) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.anonymousAuthenticationEntryPoint = anonymousAuthenticationEntryPoint;
        this.cacheService = cacheService;
        this.ignoreUrl = ignoreUrl;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.debug(request.getRequestURI());
        if (ignoreUrl.contains(request.getRequestURI())) {
            filterChain.doFilter(request, response);
            return;
        }

        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (!StringUtils.isEmpty(authHeader) && authHeader.startsWith("Basic")) {
            authHeader = null;
        }
        if (authHeader == null) {
            authHeader = request.getParameter(HttpHeaders.AUTHORIZATION);
        }
        if (!StringUtils.isEmpty(authHeader)) {
            String token = "";
            try {
                token = new String(Base64.getDecoder().decode(authHeader), "UTF-8");
            } catch (Exception e) {
                log.error("Token解析异常: {}", e.getMessage());
                anonymousAuthenticationEntryPoint.commence(request, response,
                        new AuthenticationCredentialsNotFoundException("非法请求"));
            }
            if (token.startsWith(Constants.TOKEN_HEAD)) {
                String authToken = token.substring(Constants.TOKEN_HEAD.length());
                if (StringUtils.hasText(authToken)) {
                    if (jwtTokenUtil.validateToken(authToken)) {
                        String username = jwtTokenUtil.getUserName(authToken);
                        String userId = jwtTokenUtil.getUserId(authToken);
                        JwtUser userDetails = cacheService.getUserByUsername(userId + ":" + username);
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        filterChain.doFilter(request, response);
                    } else {
                        anonymousAuthenticationEntryPoint.commence(request, response,
                                new AuthenticationCredentialsNotFoundException("登录超时，请重新登录"));
                    }
                } else {
                    anonymousAuthenticationEntryPoint.commence(request, response,
                            new AuthenticationCredentialsNotFoundException("非法请求"));
                }
            } else {
                anonymousAuthenticationEntryPoint.commence(request, response,
                        new AuthenticationCredentialsNotFoundException("非法请求"));
            }
        } else {
            anonymousAuthenticationEntryPoint.commence(request, response,
                    new AuthenticationCredentialsNotFoundException("非法请求"));
        }
        return;
    }
}
