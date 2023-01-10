package com.jiasu.mdl.auth.utils;

import com.jiasu.mdl.auth.cache.AuthorizationCacheService;
import com.jiasu.mdl.auth.entity.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * session util
 * </p>
 *
 * @author gaopeng
 * @since 2022-05-07
 */
@Component
public class SessionUtil {

    @Autowired
    private AuthorizationCacheService authorizationCacheService;

    /**
     * 获取登录用户信息
     *
     * @return
     */
    public JwtUser getUser() {
        return authorizationCacheService.getUser();
    }

    /**
     * 获取登录用户id
     *
     * @return
     */
    public int getUserId() {
        return getUser().getId();
    }

    /**
     * 获取登录用户账号
     *
     * @return
     */
    public String getUsername() {
        return getUser().getUsername();
    }

    /**
     * 获取用户关联菜单权限
     *
     * @return
     */
    public List<String> getAuthoritys() {
        Collection<? extends GrantedAuthority> authorities = authorizationCacheService.getUser().getAuthorities();
        List<String> roleCodes = new ArrayList<>();
        for (GrantedAuthority authority : authorities) {
            String authoritys = authority.getAuthority();
            String[] split = authoritys.split(",");
            roleCodes = Arrays.asList(split);
        }
        return roleCodes;
    }


}
