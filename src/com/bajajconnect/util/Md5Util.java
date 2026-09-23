package com.bajajconnect.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class Md5Util {
    public static byte[] digest(byte[] bArr) {
        try {
            return MessageDigest.getInstance("MD5").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static String bytesToHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b)));
        }
        return sb.toString();
    }

    @Nullable
    public static String getMd5(byte[] bArr) {
        try {
            return bytesToHex(digest(bArr));
        } catch (Exception unused) {
            return null;
        }
    }
}
