package com.jiasu.mdl.auth.config;


import com.jiasu.mdl.auth.adapter.PasswordSecurityConfigurerAdapter;
import com.jiasu.mdl.auth.cache.AuthorizationCacheService;
import com.jiasu.mdl.auth.constant.Constants;
import com.jiasu.mdl.auth.filter.JwtAuthenticationTokenFilter;
import com.jiasu.mdl.auth.filter.ValidateCodeFilter;
import com.jiasu.mdl.auth.handler.AnonymousAuthEntryPoint;
import com.jiasu.mdl.auth.handler.LoginFailureHandler;
import com.jiasu.mdl.auth.handler.LoginSuccessHandler;
import com.jiasu.mdl.auth.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import java.util.HashSet;
import java.util.Set;

/**
 * @Version : 1.0
 * @Description : web 安全配置
 * @Author : jzyan
 * @CreateDate : 2020/09/17 18:00
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private AnonymousAuthEntryPoint anonymousAuthenticationEntryPoint;
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler;
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private LoginFailureHandler loginFailureHandler;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthorizationCacheService cacheService;
    @Autowired
    private PasswordSecurityConfigurerAdapter passwordSecurityConfigurerAdapter;
    @Autowired
    private ValidateCodeFilter validateCodeFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity.ignoring().antMatchers("/",
                "/*.html",
                "/*.txt",
                "/**/*.html",
                "/**/*.css",
                "/**/*.js",
                "/favicon.ico",
                "/swagger-resources/**",
                "/v2/api-docs/**",
                "/**/auth/reserve",
                "/auth/forget/password",
                "/open-api/**",
                "/**/open-api/**",
                "/common/captcha",
                "/actuator/**"
        ).antMatchers(HttpMethod.OPTIONS, "/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 由于使用的是JWT，我们这里不需要csrf
        http.csrf().disable()
                // 基于token，所以不需要session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin()
                .successHandler(loginSuccessHandler).failureHandler(loginFailureHandler).permitAll().and().logout()
                .logoutUrl(Constants.DO_LOGOUT_URL).logoutSuccessHandler(logoutSuccessHandler).and()
                // 添加自定义密码登录
                .apply(passwordSecurityConfigurerAdapter);

        // 禁用缓存
        http.headers().cacheControl();
        // 添加JWT filter
        http.addFilterBefore(getJwtAuthenticationTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(getJwtAuthenticationTokenFilter(), LogoutFilter.class);
        http.addFilterBefore(validateCodeFilter,UsernamePasswordAuthenticationFilter.class);
        // 添加自定义未授权和未登录结果返回
        http.exceptionHandling().authenticationEntryPoint(anonymousAuthenticationEntryPoint);
    }

    public JwtAuthenticationTokenFilter getJwtAuthenticationTokenFilter() {
        Set<String> set = new HashSet<>();
        set.add(Constants.DO_LOGIN_URL);
        return new JwtAuthenticationTokenFilter(jwtTokenUtil, anonymousAuthenticationEntryPoint, cacheService, set);
    }

}
