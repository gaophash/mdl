package com.jiasu.mdl.auth.provider;

import com.jiasu.mdl.auth.exception.PasswordException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * <p>
 * 密码登录
 * </p>
 *
 * @author gaopeng
 * @since 2022-05-05
 */
@Slf4j
@Component
public class PasswordAuthenticationProvider implements AuthenticationProvider {
    @Qualifier("jwtUserDetailsService")
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        PasswordAuthenticationToken authenticationToken = (PasswordAuthenticationToken) authentication;
        // 获取凭证
        String username = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        log.info("密码登录入参: username={}, password={}", username, password);
        // 2. 根据用戶名查询用户信息
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (!password.equals(userDetails.getPassword())) {
            throw new PasswordException("密码错误");
        }
        PasswordAuthenticationToken passwordAuthenticationToken =
                new PasswordAuthenticationToken(userDetails.getAuthorities(), username, password);
        passwordAuthenticationToken.setDetails(authenticationToken.getDetails());
        return passwordAuthenticationToken;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return PasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }

}
