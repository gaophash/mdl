package com.jiasu.mdl.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 *  
 *
 * @author GaoPeng
 * @Package com.jiasu.mdl.utils
 * @Description: Web工具类
 * @date 2023/1/9 11:29
 */
public class WebUtil {
    /**
     * 将Value存入Cookie
     *
     * @param key
     * @param value
     * @param validy
     * @return
     */
    public static Cookie cookie(String key, String value, int validy) {
        if (key != null && value != null) {
            Cookie cookie = new Cookie(key, value);
            cookie.setMaxAge(validy);
            cookie.setPath("/");
            return cookie;
        } else {
            return null;
        }
    }

    /**
     * 通过Key获取存入Cookie中的值
     *
     * @param key
     * @param req
     * @return
     */
    public static final String getCookieValue(String key, HttpServletRequest req) {
        String str = null;
        Cookie cookies[] = req.getCookies();
        if (null == cookies) {
            return null;
        }
        for (int i = 0; i < cookies.length && str == null; i++) {
            Cookie cookie = cookies[i];
            if (cookie.getName().equals(key)) {
                return cookie.getValue();
            }
        }
        return null;
    }

    /**
     * 获取当前请求IP
     *
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Real-IP");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("X-Forwarded-For");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 根据Key 值来获得移除的 Cookie
     *
     * @param key
     * @return
     */
    public static Cookie removeableCookie(String key) {
        if (key != null) {
            Cookie cookie = new Cookie(key, "");
            cookie.setMaxAge(-1);
            cookie.setPath("/");
            cookie.setDomain(".shouqianpay.com");
            return cookie;
        } else {
            return null;
        }
    }
}
