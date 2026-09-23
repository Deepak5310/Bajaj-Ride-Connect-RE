package com.mappls.sdk.maps.module.http;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

/* JADX INFO: loaded from: classes4.dex */
class VTAuthentication {
    private static final VTAuthentication ourInstance = new VTAuthentication();
    private PublicKey publicKey = null;

    public static VTAuthentication getInstance() {
        return ourInstance;
    }

    private VTAuthentication() {
    }

    PublicKey getKey() {
        if (this.publicKey == null && MapplsMapManager.getInstance().getRawPublicKey() != null) {
            try {
                PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(MapplsMapManager.getInstance().getRawPublicKey(), 2)));
                this.publicKey = publicKeyGeneratePublic;
                return publicKeyGeneratePublic;
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidKeySpecException e2) {
                e2.printStackTrace();
            }
        }
        return this.publicKey;
    }

    void clearKey() {
        this.publicKey = null;
    }
}
