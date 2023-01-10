package com.jiasu.mdl.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiasu.mdl.auth.constant.Constants;
import com.jiasu.mdl.auth.provider.PasswordAuthenticationToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author gaopeng
 * @since 2022-06-28
 */
@Slf4j
public class PasswordAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
    private boolean postOnly = true;
    /**
     * 设置拦截/login密码登录接口
     */
    private static final AntPathRequestMatcher DEFAULT_ANT_PATH_REQUEST_MATCHER = new AntPathRequestMatcher(Constants.DO_LOGIN_URL, "POST");

    public PasswordAuthenticationFilter() {
        super(DEFAULT_ANT_PATH_REQUEST_MATCHER);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        if (this.postOnly && !"POST".equals(request.getMethod())) {
            throw new AuthenticationServiceException("请求方法不支持:" + request.getMethod());
        }

        if (!(request.getContentType().replace(" ", "").equals(MediaType.APPLICATION_JSON_UTF8_VALUE)
                || request.getContentType().replace(" ", "").equals(MediaType.APPLICATION_JSON_VALUE))) {
            throw new AuthenticationServiceException("请求类型不支持:" + request.getContentType());
        }

        String username = request.getAttribute("username").toString();
        String password = request.getAttribute("password").toString();

        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new AuthenticationServiceException("账号和密码不能为空");
        }
        PasswordAuthenticationToken authRequest = new PasswordAuthenticationToken(
                username.trim(), password);
        setDetails(request, authRequest);
        return this.getAuthenticationManager().authenticate(authRequest);
    }

    protected void setDetails(HttpServletRequest request, PasswordAuthenticationToken authRequest) {
        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
    }

    public boolean isPostOnly() {
        return postOnly;
    }

    public void setPostOnly(boolean postOnly) {
        this.postOnly = postOnly;
    }

}
