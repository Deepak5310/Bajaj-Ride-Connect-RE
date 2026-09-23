package com.mappls.android.util;

import android.util.Base64;
import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes6.dex */
public class MessageEncryptor {
    static {
        System.loadLibrary("mappls-lms-native-lib");
    }

    public static String encryptMessage(String str) throws InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(getKey(), 2), new String(Base64.decode(getKeyAlgorithm(), 2)));
        try {
            Cipher cipher = Cipher.getInstance(new String(Base64.decode(getAlgorithm(), 2)));
            cipher.init(1, secretKeySpec, new IvParameterSpec(Base64.decode(getIV(), 2)));
            return Base64.encodeToString(cipher.doFinal(str.getBytes(Charset.forName("UTF-8"))), 2);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
            return null;
        }
    }

    static native String getAlgorithm();

    static native String getIV();

    static native String getKey();

    static native String getKeyAlgorithm();

    static native String getOfflineIV();

    static native String getOfflineKey();

    public static String offlineDecryptMessage(String str) throws InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(getOfflineKey(), 2), new String(Base64.decode(getKeyAlgorithm(), 2)));
        try {
            Cipher cipher = Cipher.getInstance(new String(Base64.decode(getAlgorithm(), 2)));
            cipher.init(2, secretKeySpec, new IvParameterSpec(Base64.decode(getOfflineIV(), 2)));
            return new String(cipher.doFinal(Base64.decode(str, 2)), Charset.forName("UTF-8"));
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
            return null;
        }
    }

    public static String offlineEncryptMessage(String str) throws InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.decode(getOfflineKey(), 2), new String(Base64.decode(getKeyAlgorithm(), 2)));
        try {
            Cipher cipher = Cipher.getInstance(new String(Base64.decode(getAlgorithm(), 2)));
            cipher.init(1, secretKeySpec, new IvParameterSpec(Base64.decode(getOfflineIV(), 2)));
            return Base64.encodeToString(cipher.doFinal(str.getBytes(Charset.forName("UTF-8"))), 2);
        } catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException unused) {
            return null;
        }
    }
}
