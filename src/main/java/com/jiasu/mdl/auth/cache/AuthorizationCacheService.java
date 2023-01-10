package com.jiasu.mdl.auth.cache;

import com.jiasu.mdl.auth.entity.JwtUser;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @Version : 1.0
 * @Description : 认证授权缓存 扩展请实现该类
 * @Author : gaopeng
 * @CreateDate : 2020/10/30 10:25
 */
public interface AuthorizationCacheService {

    void putUser(String username, String user);

    void removeUserByUsername(String username);

    JwtUser getUserByUsername(String username);

    void putToken(String username, String token);

    void removeTokenByUsername(String username);

    String getTokenByUsername(String username);

    void clearAll(String username);


    default JwtUser getUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        JwtUser user = new JwtUser();
        if (ObjectUtils.isNotEmpty(authentication)) {
            user = (JwtUser) authentication.getPrincipal();
        }
        return user;
    }

}
