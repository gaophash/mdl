package com.jiasu.mdl.auth.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p>
 * md5加密
 * </p>
 *
 * @author gaopeng
 * @since 2022-05-27
 */

public class Md5PasswordEncoder implements PasswordEncoder {
    /**
     * Encode the raw password. Generally, a good encoding algorithm applies a SHA-1 or
     * greater hash combined with an 8-byte or greater randomly generated salt.
     *
     * @param rawPassword
     */
    @Override
    public String encode(CharSequence rawPassword) {
        if (ObjectUtils.isEmpty(rawPassword)) {
            throw new IllegalArgumentException("password is null");
        }
        return DigestUtils.md5Hex(rawPassword.toString());
    }

    /**
     * Verify the encoded password obtained from storage matches the submitted raw
     * password after it too is encoded. Returns true if the passwords match, false if
     * they do not. The stored password itself is never decoded.
     *
     * @param rawPassword     the raw password to encode and match
     * @param encodedPassword the encoded password from storage to compare with
     * @return true if the raw password, after encoding, matches the encoded password from
     * storage
     */
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword.equals(DigestUtils.md5Hex(rawPassword.toString()))) {
            return true;
        }
        return false;
    }

}
