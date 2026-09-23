package com.bajajconnect.security;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class SecurityAES {
    private Cipher cipher;

    public SecurityAES(String str, byte[] bArr) {
        try {
            this.cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            this.cipher.init(1, new SecretKeySpec(str.getBytes(), "AES"), new IvParameterSpec(bArr));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SecurityAES(byte[] bArr, byte[] bArr2) {
        try {
            this.cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            this.cipher.init(1, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public byte[] encode(byte[] bArr) {
        try {
            return this.cipher.doFinal(bArr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
