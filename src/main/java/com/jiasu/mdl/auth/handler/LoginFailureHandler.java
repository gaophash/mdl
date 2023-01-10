package com.jiasu.mdl.auth.handler;


import com.jiasu.mdl.auth.exception.PasswordException;
import com.jiasu.mdl.auth.utils.RestResponseUtil;
import com.jiasu.mdl.enums.ErrorCodeEnum;
import com.jiasu.mdl.entity.Response;
import com.jiasu.mdl.utils.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Version : 1.0
 * @Description : 登录失败处理器
 * @Author : jzyan
 * @CreateDate : 2020/09/16 18:07
 */
@Slf4j
@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        String ip = WebUtil.getIpAddr(request);
        log.warn("[{}][{}]登录失败：{}", request.getRequestURI(), ip, exception.getMessage());
        if (exception instanceof UsernameNotFoundException) {
            RestResponseUtil.response(response, Response.error(ErrorCodeEnum.CODE_1503001.getCode(),
                    exception.getMessage().split(":")[0]));
        }
        if (exception instanceof DisabledException) {
            RestResponseUtil.response(response, Response.error(ErrorCodeEnum.CODE_1502001));
        }
        if (exception instanceof PasswordException) {
            RestResponseUtil.response(response, Response.error(ErrorCodeEnum.CODE_1503001.getCode(), "密码错误"));
        }
        if (exception instanceof AuthenticationServiceException) {
            RestResponseUtil.response(response, Response.error(ErrorCodeEnum.CODE_1503001.getCode(),
                    exception.getMessage()));
        }
    }

}
