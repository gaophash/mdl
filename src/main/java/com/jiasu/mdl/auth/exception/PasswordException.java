package com.jiasu.mdl.auth.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * <p>
 * 密码异常
 * </p>
 *
 * @author jzyan
 * @since 2022-07-29
 */
public class PasswordException extends AuthenticationException {
    public PasswordException(String msg) {
        super(msg);
    }

    public PasswordException(String msg, Throwable t) {
        super(msg, t);
    }
}
