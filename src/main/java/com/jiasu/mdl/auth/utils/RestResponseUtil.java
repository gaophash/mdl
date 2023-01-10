package com.jiasu.mdl.auth.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Version : 1.0
 * @Description :
 * @Author : gaopeng
 *
 */
public class RestResponseUtil {

    public static void response(HttpServletResponse response, Object object) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        ServletOutputStream out = response.getOutputStream();
        String str = JSONObject.toJSONString(object);
        out.write(str.getBytes("UTF-8"));
        out.flush();
        out.close();
    }
}
