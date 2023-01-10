package com.jiasu.mdl.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiasu.mdl.auth.utils.RestResponseUtil;
import com.jiasu.mdl.enums.ErrorCodeEnum;
import com.jiasu.mdl.entity.Response;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 *  
 *
 * @author GaoPeng
 * @Package com.jiasu.mdl.auth.filter
 * @Description: 校验验证码
 * @date 2023/1/10 10:58
 */
@Component
public class ValidateCodeFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //得到请求地址
        String requestURI = request.getRequestURI();
        if (requestURI.equals("/auth/login")) {
            //1,得到登陆时用户输入的验证码
            String code1 = request.getSession().getAttribute("verifyCode").toString();
            String verifyCode = "";
            String username;
            String password;
            ObjectMapper mapper = new ObjectMapper();
            try (InputStream is = request.getInputStream()) {
                Map<String, String> authenticationBean = mapper.readValue(is, Map.class);
                verifyCode = authenticationBean.get("verifyCode");
                username = authenticationBean.get("username");
                password = authenticationBean.get("password");
                request.setAttribute("username",username);
                request.setAttribute("password",password);
            } catch (IOException e) {
                RestResponseUtil.response(response, Response.error(ErrorCodeEnum.CODE_1503001.getCode(),
                        "用户名密码验证码获取异常"));
            } finally {
                request.getInputStream().close();
            }
            if (StringUtils.hasText(verifyCode)) {
                if (verifyCode.equalsIgnoreCase(code1)) {
                    //说明验证码正确  直接放行
                    filterChain.doFilter(request, response);
                    return;
                } else {
                    //说明验证码不正确
                    RestResponseUtil.response(response, Response.error(ErrorCodeEnum.CODE_1503001.getCode(),
                            "验证码错误"));
                    return;
                }
            } else {
                //用户没有输出验证码
                RestResponseUtil.response(response, Response.error(ErrorCodeEnum.CODE_1503001.getCode(),
                        "验证码不能为空"));
                return;
            }

        } else {
            //说明不是登陆 直接放行到下一个过滤器
            filterChain.doFilter(request, response);
            return;
        }
    }

}
