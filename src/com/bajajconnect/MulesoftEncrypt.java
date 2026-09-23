package com.bajajconnect;

import android.os.Build;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import j$.util.Base64;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes3.dex */
public class MulesoftEncrypt extends ReactContextBaseJavaModule {
    public static String ALGORITHM = "AES/CBC/PKCS5Padding";

    MulesoftEncrypt(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    @ReactMethod
    public static void encrypt(String str, String str2, Promise promise) {
        try {
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(new PBEKeySpec(str2.toCharArray(), bArr, 65536, 256)).getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(1, secretKeySpec);
            byte[] iv = ((IvParameterSpec) cipher.getParameters().getParameterSpec(IvParameterSpec.class)).getIV();
            byte[] bArrDoFinal = cipher.doFinal(str.getBytes(StandardCharsets.UTF_8));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(bArr);
            byteArrayOutputStream.write(iv);
            byteArrayOutputStream.write(bArrDoFinal);
            if (Build.VERSION.SDK_INT >= 26) {
                promise.resolve(Base64.getEncoder().encodeToString(byteArrayOutputStream.toByteArray()));
            }
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void decrypt(String str, String str2, Promise promise) {
        try {
            byte[] bArrDecode = new byte[0];
            if (Build.VERSION.SDK_INT >= 26) {
                bArrDecode = Base64.getDecoder().decode(str);
            }
            if (bArrDecode.length < 48) {
                promise.resolve("");
            }
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrDecode, 0, 16);
            byte[] bArrCopyOfRange2 = Arrays.copyOfRange(bArrDecode, 16, 32);
            byte[] bArrCopyOfRange3 = Arrays.copyOfRange(bArrDecode, 32, bArrDecode.length);
            SecretKeySpec secretKeySpec = new SecretKeySpec(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256").generateSecret(new PBEKeySpec(str2.toCharArray(), bArrCopyOfRange, 65536, 256)).getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(2, secretKeySpec, new IvParameterSpec(bArrCopyOfRange2));
            promise.resolve(new String(cipher.doFinal(bArrCopyOfRange3), StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject(e);
        }
    }

    @Override // com.facebook.react.bridge.NativeModule
    public String getName() {
        return "AESNativeModule";
    }
}
