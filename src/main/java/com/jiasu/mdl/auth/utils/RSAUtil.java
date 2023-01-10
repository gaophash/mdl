package com.jiasu.mdl.auth.utils;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

/**
 * <p>
 * rsa
 * </p>
 *
 * @author gaopeng
 * @since 2022-06-06
 */
public class RSAUtil {

    public final static String pubKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDUlN8tZIwtI8PWR4QFseDV/9DGl6JYPT3p48IYjYmhl4lwzkfjTd80oK51PWL1j06S0LJQLP9IsRFCZ6HdX0SbNxtUwU4c4Fur8Swr8yNQtEsaWtcVjzUNU+OEO5GOraa0wjEaJUevT9bwRgWTZse+CMRjCRVrUOPK7QXDkwIruwIDAQAB";
    public final static String priKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBANSU3y1kjC0jw9ZHhAWx4NX/0MaXolg9PenjwhiNiaGXiXDOR+NN3zSgrnU9YvWPTpLQslAs/0ixEUJnod1fRJs3G1TBThzgW6vxLCvzI1C0Sxpa1xWPNQ1T44Q7kY6tprTCMRolR69P1vBGBZNmx74IxGMJFWtQ48rtBcOTAiu7AgMBAAECgYBrFyAi5u8y4jyK2vYoREbGp5uOH99Z4mgpRmKGKe82p3dGi7RtTtJt2bBpQWZz3CCyF05s0247OXA/aqOBOLf/KdTgAf2r3nZOjXP0hNFxOVLWViSoCirdfTxpLLjsfnd4zkxL0ENUv91As6JtrieoB4DuGD4u36c3GQXeIlobKQJBAPgKT/E8jNA4AoTPcETa/ZpK6hL1Ocg0BUmKng0WFtE8AhqTRkI23PJQvWI4wF4NL9bftVmf2TkuDklmaEd7xJUCQQDbZ0K24syVFsJK2mFHL1k2rLwATf694tEISxAPZz50aXZ+K5oVfTsk8WDvLJ2OwUDmuc82apcMeT3fw197AksPAkEA6pL+FXuZBBXkM+vmFggwzGlKw1ENK0wfL/SbEm8wdwJUTwO270npXHSFFk3rh0bbVk/MtwzYJx5qPnpN5kSjnQJAXXQHY7UJJTvzeES6iMKvQm2jCpIuPp19IgYvChCU9qrxUN6rnBmidqLmAhpD5kmEpoJgs7IFMsf1xfkHE3MvmwJBANzhAOF17UbedLNp2TltlObPUiKWsPUySrqqqpNmWCrq3mOmtp3PvKNFZuQe8prAaDBV04Swx6Nll5p+JLu6zOY=";

    /**
     * 私钥解密
     *
     * @param cryptoGraph
     * @param priKey
     * @return
     * @throws Exception
     */
    public static String decrypt(String cryptoGraph, String priKey) throws Exception {
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(priKey));
        PrivateKey privateKey = KeyFactory.getInstance("RSA").generatePrivate(keySpec);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] b = Base64.getDecoder().decode(cryptoGraph);
        return new String(cipher.doFinal(b));
    }

}
