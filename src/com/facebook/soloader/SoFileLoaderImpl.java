package com.facebook.soloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class SoFileLoaderImpl implements SoFileLoader {
    private static final String TAG = "SoFileLoaderImpl";

    @Nullable
    private final String mLocalLdLibraryPath;

    @Nullable
    private final String mLocalLdLibraryPathNoZips;

    @Nullable
    private final Method mNativeLoadRuntimeMethod;
    private final Runtime mRuntime = Runtime.getRuntime();

    public SoFileLoaderImpl() {
        Method nativeLoadRuntimeMethod = SysUtil.getNativeLoadRuntimeMethod();
        this.mNativeLoadRuntimeMethod = nativeLoadRuntimeMethod;
        String classLoaderLdLoadLibrary = nativeLoadRuntimeMethod != null ? SysUtil.getClassLoaderLdLoadLibrary() : null;
        this.mLocalLdLibraryPath = classLoaderLdLoadLibrary;
        this.mLocalLdLibraryPathNoZips = SysUtil.makeNonZipPath(classLoaderLdLoadLibrary);
    }

    @Override // com.facebook.soloader.SoFileLoader
    public void loadBytes(String str, ElfByteChannel elfByteChannel, int i) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x007a */
    /* JADX WARN: Bottom block not found for handler: all -> 0x007d */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
    
        if (r3 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0030, code lost:
    
        com.facebook.soloader.LogUtil.e(com.facebook.soloader.SoFileLoaderImpl.TAG, "Error when loading library: " + r3 + ", library hash is " + getLibHash(r8) + ", LD_LIBRARY_PATH is " + r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
    
        return;
     */
    @Override // com.facebook.soloader.SoFileLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void load(String str, int i) {
        if (this.mNativeLoadRuntimeMethod == null) {
            System.load(str);
            return;
        }
        String str2 = (i & 4) == 4 ? this.mLocalLdLibraryPath : this.mLocalLdLibraryPathNoZips;
        String str3 = null;
        try {
            synchronized (this.mRuntime) {
                String str4 = (String) this.mNativeLoadRuntimeMethod.invoke(this.mRuntime, str, SoLoader.class.getClassLoader(), str2);
                try {
                    if (str4 != null) {
                        String str5 = "nativeLoad() returned error for " + str + ": " + str4;
                        try {
                            throw new SoLoaderULError(str, str5);
                        } catch (Throwable th) {
                            str3 = str5;
                            th = th;
                            while (true) {
                                break;
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    str3 = str4;
                }
            }
            while (true) {
                break;
                break;
            }
            throw th;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            str3 = "nativeLoad() error during invocation for " + str + ": " + str3;
            throw new RuntimeException(str3);
        }
    }

    private String getLibHash(String str) {
        try {
            File file = new File(str);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = fileInputStream.read(bArr);
                    if (i > 0) {
                        messageDigest.update(bArr, 0, i);
                    } else {
                        String str2 = String.format("%32x", new BigInteger(1, messageDigest.digest()));
                        fileInputStream.close();
                        return str2;
                    }
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | SecurityException | NoSuchAlgorithmException e) {
            return e.toString();
        }
    }
}
