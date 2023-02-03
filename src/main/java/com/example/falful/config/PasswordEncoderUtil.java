package com.example.falful.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public final class PasswordEncoderUtil {
    private static final BCryptPasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    private PasswordEncoderUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static BCryptPasswordEncoder getInstance() {
        return PASSWORD_ENCODER;
    }

}
