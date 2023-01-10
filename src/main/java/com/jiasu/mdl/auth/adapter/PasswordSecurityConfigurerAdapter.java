package com.jiasu.mdl.auth.adapter;


import com.jiasu.mdl.auth.filter.PasswordAuthenticationFilter;
import com.jiasu.mdl.auth.handler.LoginFailureHandler;
import com.jiasu.mdl.auth.handler.LoginSuccessHandler;
import com.jiasu.mdl.auth.provider.PasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * <p>
 * sms config
 * </p>
 *
 * @author gaopeng
 * @since 2022-05-05
 */
@Configuration
public class PasswordSecurityConfigurerAdapter extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    private LoginFailureHandler loginFailureHandler;
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    private PasswordAuthenticationProvider passwordAuthenticationProvider;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        PasswordAuthenticationFilter passwordAuthenticationFilter = new PasswordAuthenticationFilter();
        passwordAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        passwordAuthenticationFilter.setAuthenticationSuccessHandler(loginSuccessHandler);
        passwordAuthenticationFilter.setAuthenticationFailureHandler(loginFailureHandler);
        http.authenticationProvider(passwordAuthenticationProvider).addFilterAt(passwordAuthenticationFilter
                , UsernamePasswordAuthenticationFilter.class);
    }

}
