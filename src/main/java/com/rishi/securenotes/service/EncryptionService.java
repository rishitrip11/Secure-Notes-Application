package com.rishi.securenotes.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class EncryptionService {

    private static final String ALGO = "AES";

    private static SecretKeySpec getKey(String password) {
        byte[] key = password.getBytes();
        byte[] keyBytes = new byte[16];

        for (int i = 0; i < key.length && i < 16; i++) {
            keyBytes[i] = key[i];
        }

        return new SecretKeySpec(keyBytes, ALGO);
    }

    public static String encrypt(String data, String password) {
        try {
            Cipher cipher = Cipher.getInstance(ALGO);
            cipher.init(Cipher.ENCRYPT_MODE, getKey(password));
            byte[] encrypted = cipher.doFinal(data.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String encryptedData, String password) {
        try {
            Cipher cipher = Cipher.getInstance(ALGO);
            cipher.init(Cipher.DECRYPT_MODE, getKey(password));
            byte[] decoded = Base64.getDecoder().decode(encryptedData);
            return new String(cipher.doFinal(decoded));
        } catch (Exception e) {
            return " Wrong password or corrupted data";
        }
    }
}