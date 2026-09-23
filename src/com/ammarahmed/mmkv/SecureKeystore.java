package com.ammarahmed.mmkv;

import android.content.Context;
import android.content.SharedPreferences;
import android.security.KeyPairGeneratorSpec;
import android.util.Log;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.IllegalViewOperationException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.x500.X500Principal;

/* JADX INFO: loaded from: classes3.dex */
public class SecureKeystore {
    private final String SharedPrefFileName = "rnmmkv.shareprefs";
    private SharedPreferences prefs;
    private ReactApplicationContext reactContext;

    private boolean useKeystore() {
        return true;
    }

    public SecureKeystore(ReactApplicationContext reactApplicationContext) {
        this.reactContext = reactApplicationContext;
        if (useKeystore()) {
            return;
        }
        try {
            this.prefs = EncryptedSharedPreferences.create(this.reactContext, "e4b001df9a082298dd090bb7455c45d92fbd5dda.xml", new MasterKey.Builder(this.reactContext).setKeyScheme(MasterKey.KeyScheme.AES256_GCM).build(), EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV, EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM);
        } catch (IOException | RuntimeException | GeneralSecurityException e) {
            Log.e("RNMMKV:SecureKeystore", "Failed to create encrypted shared preferences! Failing back to standard SharedPreferences", e);
            this.prefs = this.reactContext.getSharedPreferences("rnmmkv.shareprefs", 0);
        }
    }

    public static boolean isRTL(Locale locale) {
        byte directionality = Character.getDirectionality(locale.getDisplayName().charAt(0));
        return directionality == 1 || directionality == 2;
    }

    public void setSecureKey(String str, String str2) {
        try {
            if (useKeystore()) {
                Locale locale = Locale.getDefault();
                if (isRTL(locale)) {
                    Locale.setDefault(Locale.ENGLISH);
                    setCipherText(this.reactContext, str, str2);
                    Locale.setDefault(locale);
                } else {
                    setCipherText(this.reactContext, str, str2);
                }
            } else {
                SharedPreferences.Editor editorEdit = this.prefs.edit();
                editorEdit.putString(str, str2);
                editorEdit.apply();
            }
        } catch (Exception unused) {
        }
    }

    public String getSecureKey(String str) {
        if (useKeystore()) {
            try {
                return getPlainText(this.reactContext, str);
            } catch (FileNotFoundException | Exception unused) {
                return null;
            }
        }
        try {
            return this.prefs.getString(str, null);
        } catch (IllegalViewOperationException unused2) {
            return null;
        }
    }

    public boolean secureKeyExists(String str) {
        if (useKeystore()) {
            try {
                return exists(this.reactContext, str);
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            return this.prefs.contains(str);
        } catch (IllegalViewOperationException unused2) {
            return false;
        }
    }

    public void removeSecureKey(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (useKeystore()) {
                String[] strArr = {Constants.SKS_DATA_FILENAME + str, Constants.SKS_KEY_FILENAME + str};
                for (int i = 0; i < 2; i++) {
                    arrayList.add(Boolean.valueOf(this.reactContext.deleteFile(strArr[i])));
                }
                return;
            }
            if (this.prefs.getString(str, null) == null) {
                return;
            }
            this.prefs.edit().remove(str).apply();
        } catch (Exception unused) {
        }
    }

    private PublicKey getOrCreatePublicKey(Context context, String str) throws GeneralSecurityException, IOException {
        KeyStore keyStore = KeyStore.getInstance(getKeyStore());
        keyStore.load(null);
        if (!keyStore.containsAlias(str) || keyStore.getCertificate(str) == null) {
            Log.i(Constants.TAG, "no existing asymmetric keys for alias");
            Calendar calendar = Calendar.getInstance();
            Calendar calendar2 = Calendar.getInstance();
            calendar2.add(1, 50);
            KeyPairGeneratorSpec keyPairGeneratorSpecBuild = new KeyPairGeneratorSpec.Builder(context).setAlias(str).setSubject(new X500Principal("CN=" + str)).setSerialNumber(BigInteger.ONE).setStartDate(calendar.getTime()).setEndDate(calendar2.getTime()).build();
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA", getKeyStore());
            keyPairGenerator.initialize(keyPairGeneratorSpecBuild);
            keyPairGenerator.generateKeyPair();
            Log.i(Constants.TAG, "created new asymmetric keys for alias");
        }
        return keyStore.getCertificate(str).getPublicKey();
    }

    private byte[] encryptRsaPlainText(PublicKey publicKey, byte[] bArr) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance(Constants.RSA_ALGORITHM);
        cipher.init(1, publicKey);
        return encryptCipherText(cipher, bArr);
    }

    private byte[] encryptAesPlainText(SecretKey secretKey, String str) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance(Constants.AES_ALGORITHM);
        cipher.init(1, secretKey);
        return encryptCipherText(cipher, str);
    }

    private byte[] encryptCipherText(Cipher cipher, String str) throws GeneralSecurityException, IOException {
        return encryptCipherText(cipher, str.getBytes("UTF-8"));
    }

    private byte[] encryptCipherText(Cipher cipher, byte[] bArr) throws GeneralSecurityException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        CipherOutputStream cipherOutputStream = new CipherOutputStream(byteArrayOutputStream, cipher);
        cipherOutputStream.write(bArr);
        cipherOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private SecretKey getOrCreateSecretKey(Context context, String str) throws GeneralSecurityException, IOException {
        try {
            return getSymmetricKey(context, str);
        } catch (FileNotFoundException unused) {
            Log.i(Constants.TAG, "no existing symmetric key for alias");
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);
            SecretKey secretKeyGenerateKey = keyGenerator.generateKey();
            Storage.writeValues(context, Constants.SKS_KEY_FILENAME + str, encryptRsaPlainText(getOrCreatePublicKey(context, str), secretKeyGenerateKey.getEncoded()));
            Log.i(Constants.TAG, "created new symmetric keys for alias");
            return secretKeyGenerateKey;
        }
    }

    public void setCipherText(Context context, String str, String str2) throws GeneralSecurityException, IOException {
        Storage.writeValues(context, Constants.SKS_DATA_FILENAME + str, encryptAesPlainText(getOrCreateSecretKey(context, str), str2));
    }

    private PrivateKey getPrivateKey(String str) throws GeneralSecurityException, IOException {
        KeyStore keyStore = KeyStore.getInstance(getKeyStore());
        keyStore.load(null);
        return (PrivateKey) keyStore.getKey(str, null);
    }

    private byte[] decryptRsaCipherText(PrivateKey privateKey, byte[] bArr) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance(Constants.RSA_ALGORITHM);
        cipher.init(2, privateKey);
        return decryptCipherText(cipher, bArr);
    }

    private byte[] decryptAesCipherText(SecretKey secretKey, byte[] bArr) throws GeneralSecurityException, IOException {
        Cipher cipher = Cipher.getInstance(Constants.AES_ALGORITHM);
        cipher.init(2, secretKey);
        return decryptCipherText(cipher, bArr);
    }

    private byte[] decryptCipherText(Cipher cipher, byte[] bArr) throws IOException {
        CipherInputStream cipherInputStream = new CipherInputStream(new ByteArrayInputStream(bArr), cipher);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[256];
        for (int i = cipherInputStream.read(bArr2); i != -1; i = cipherInputStream.read(bArr2)) {
            byteArrayOutputStream.write(bArr2, 0, i);
        }
        return byteArrayOutputStream.toByteArray();
    }

    private SecretKey getSymmetricKey(Context context, String str) throws GeneralSecurityException, IOException {
        return new SecretKeySpec(decryptRsaCipherText(getPrivateKey(str), Storage.readValues(context, Constants.SKS_KEY_FILENAME + str)), Constants.AES_ALGORITHM);
    }

    public String getPlainText(Context context, String str) throws GeneralSecurityException, IOException {
        return new String(decryptAesCipherText(getSymmetricKey(context, str), Storage.readValues(context, Constants.SKS_DATA_FILENAME + str)), "UTF-8");
    }

    public boolean exists(Context context, String str) throws IOException {
        return Storage.exists(context, Constants.SKS_DATA_FILENAME + str);
    }

    private String getKeyStore() {
        try {
            try {
                KeyStore.getInstance(Constants.KEYSTORE_PROVIDER_1);
                return Constants.KEYSTORE_PROVIDER_1;
            } catch (Exception unused) {
                return Constants.KEYSTORE_PROVIDER_3;
            }
        } catch (Exception unused2) {
            KeyStore.getInstance(Constants.KEYSTORE_PROVIDER_2);
            return Constants.KEYSTORE_PROVIDER_2;
        }
    }
}
