package com.google.android.libraries.navigation.internal.abf;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.common.base.Ascii;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static final d a = new d();
    public static final String[] b;
    public static final String c;

    static {
        String[] strArr = {"com.google.android.geo.API_KEY", "com.google.android.maps.v2.API_KEY"};
        b = strArr;
        c = strArr[0];
    }

    public static String a(PackageManager packageManager, String str) {
        byte[] bArrDigest;
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 64);
            if (packageInfo != null && packageInfo.signatures != null && packageInfo.signatures.length != 0) {
                if (packageInfo.signatures[0] != null) {
                    byte[] byteArray = packageInfo.signatures[0].toByteArray();
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
                    if (messageDigest != null && (bArrDigest = messageDigest.digest(byteArray)) != null) {
                        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
                        int length = bArrDigest.length;
                        StringBuilder sb = new StringBuilder(length + length);
                        for (byte b2 : bArrDigest) {
                            sb.append(cArr[(b2 >> 4) & 15]);
                            sb.append(cArr[b2 & Ascii.SI]);
                        }
                        return sb.toString();
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException | NoSuchAlgorithmException unused) {
        }
        return null;
    }

    public final synchronized String b(Context context, String str) {
        String string;
        try {
            try {
                ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 128);
                string = null;
                if (applicationInfo.metaData != null) {
                    String[] strArr = b;
                    int i = 0;
                    for (int i2 = 0; i2 < 2; i2++) {
                        String str2 = strArr[i2];
                        if (applicationInfo.metaData.containsKey(str2)) {
                            string = applicationInfo.metaData.getString(str2);
                            i++;
                        }
                    }
                    if (i > 1) {
                        throw new RuntimeException("The API key can only be specified once. It is recommended that you use the meta-data tag with the name: " + c + " in the <application> element of AndroidManifest.xml");
                    }
                }
                if (string == null) {
                    throw new RuntimeException("API key not found.  Check that <meta-data android:name=\"" + c + "\" android:value=\"your API key\"/> is in the <application> element of AndroidManifest.xml");
                }
            } catch (PackageManager.NameNotFoundException e) {
                throw new AssertionError(e);
            }
        } catch (Throwable th) {
            throw th;
        }
        return string;
    }
}
