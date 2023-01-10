package com.jiasu.mdl.auth.handler;


import com.jiasu.mdl.auth.utils.RestResponseUtil;
import com.jiasu.mdl.enums.ErrorCodeEnum;
import com.jiasu.mdl.entity.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Version : 1.0
 * @Description : 匿名用户访问处理器
 * @Author : gaopeng
 * @CreateDate : 2020/09/21 14:21
 */
@Slf4j
@Component
public class AnonymousAuthEntryPoint implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        Object result = Response.error(ErrorCodeEnum.CODE_9998.getCode(), authException.getMessage());
        RestResponseUtil.response(response, result);
    }


}
