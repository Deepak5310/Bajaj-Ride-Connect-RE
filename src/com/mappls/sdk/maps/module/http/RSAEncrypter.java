package com.mappls.sdk.maps.module.http;

import android.util.Base64;
import java.security.PublicKey;
import javax.crypto.Cipher;

/* JADX INFO: loaded from: classes4.dex */
class RSAEncrypter {
    private static final RSAEncrypter ourInstance = new RSAEncrypter();

    private native String getAlgorithm();

    private native String getKeyAlgorithm();

    static RSAEncrypter getInstance() {
        return ourInstance;
    }

    private RSAEncrypter() {
    }

    public byte[] encryptWithRSA(PublicKey publicKey, String str) throws Exception {
        Cipher cipher = Cipher.getInstance(new String(Base64.decode(getAlgorithm(), 0)));
        cipher.init(1, publicKey);
        return cipher.doFinal(str.getBytes());
    }
}
