package com.freight.ms.util;

import com.freight.ms.model.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordUtil {
    private RandomNumberGenerator randomNumberGenerator =
            new SecureRandomNumberGenerator();
    private String algorithmName = "md5";
    private final int hashIterations = 2;

    public User encryptPassword(User user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations).toHex();
        user.setPassword(newPassword);

        return user;
    }

    public boolean checkPassword(User user, String password) {
        String p = new SimpleHash(
                algorithmName,
                password,
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                hashIterations).toHex();

        return p.equals(user.getPassword());
    }
}
