package com.mappls.sdk.services.utils;

import android.util.Base64;
import com.google.common.base.Ascii;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes4.dex */
public class Utils {
    private static final char[] HEX_DIGITS = "0123456789ABCDEF".toLowerCase().toCharArray();

    public static native String getAlgorithm();

    public static native String getOtpAlgorithm();

    public static String encode(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(new String(Base64.decode(getAlgorithm(), 2)));
            messageDigest.update(str.getBytes(), 0, str.length());
            return toHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String toHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            char[] cArr2 = HEX_DIGITS;
            byte b = bArr[i];
            cArr[i2] = cArr2[(b >> 4) & 15];
            cArr[i2 + 1] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }

    public static String sha256(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(new String(Base64.decode(getOtpAlgorithm(), 2)));
            messageDigest.update(str.getBytes(), 0, str.length());
            return toHex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
