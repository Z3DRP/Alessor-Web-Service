package com.alessor.app.ws.shared.lib;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

@Component
public class Utils {
    private final Random RANDOM = new SecureRandom();
    private final String EXCEPTED_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz1234567890";

    public String generateUserId(int length) {
        return "U" + generateRandomString(length);
    }

    private String generateRandomString(int length) {
        StringBuilder generatedId = new StringBuilder(length);

        for (int i = 0; i < length; i++){
            generatedId.append(EXCEPTED_CHARS.charAt(RANDOM.nextInt(EXCEPTED_CHARS.length())));
        }

        return new String(generatedId);
    }

    public Date getCurrentDateTime() {
        long currentTimeInMillis = System.currentTimeMillis();
        return new Date(currentTimeInMillis);
    }
}
