package com.google.android.libraries.navigation.internal.abg;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import com.google.firebase.remoteconfig.RemoteConfigConstants;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x {
    public static final String a = "x";
    public static final x b = new x();
    public static volatile String c = null;

    private x() {
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0047 A[PHI: r3 r10
      0x0047: PHI (r3v3 java.lang.String) = (r3v7 java.lang.String), (r3v6 java.lang.String) binds: [B:15:0x0045, B:9:0x0038] A[DONT_GENERATE, DONT_INLINE]
      0x0047: PHI (r10v5 android.database.Cursor) = (r10v4 android.database.Cursor), (r10v9 android.database.Cursor) binds: [B:15:0x0045, B:9:0x0038] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:22:0x0054  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v2 */
    private static String d(Context context) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        StrictMode.ThreadPolicy threadPolicyA = com.google.android.libraries.navigation.internal.abf.w.a.a();
        ?? r3 = 0;
        string = null;
        string = null;
        string = null;
        String string = null;
        try {
            try {
                cursorQuery = context.getContentResolver().query(Uri.parse("content://com.google.settings/partner"), new String[]{"value"}, com.google.android.libraries.navigation.internal.b.b.g("maps_client_id", "name='", "'"), null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("value"));
                        }
                    } catch (Error | RuntimeException unused) {
                        com.google.android.libraries.navigation.internal.abf.p.f(a, 3);
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th2) {
                th = th2;
                r3 = context;
                if (r3 != 0) {
                    r3.close();
                }
                com.google.android.libraries.navigation.internal.abf.w.a.d(threadPolicyA);
                throw th;
            }
        } catch (Error | RuntimeException unused2) {
            cursorQuery = null;
        } catch (Throwable th3) {
            th = th3;
            if (r3 != 0) {
                r3.close();
            }
            com.google.android.libraries.navigation.internal.abf.w.a.d(threadPolicyA);
            throw th;
        }
        com.google.android.libraries.navigation.internal.abf.w.a.d(threadPolicyA);
        return string;
    }

    public final PackageInfo a(Context context, String str) {
        com.google.android.libraries.navigation.internal.abf.s.k(context, "context");
        com.google.android.libraries.navigation.internal.abf.s.k(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME);
        try {
            return context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            throw new AssertionError(e);
        }
    }

    public final String b(Context context) throws Throwable {
        com.google.android.libraries.navigation.internal.abf.s.k(context, "context");
        String strD = d(context);
        StringBuilder sb = new StringBuilder();
        if (strD == null || strD.length() == 0) {
            sb.append("Web");
        } else {
            sb.append(strD);
        }
        return sb.toString();
    }

    public final String c(boolean z) {
        String str = String.format("android:%s-%s-%s", Build.MANUFACTURER.replace('-', '_'), Build.DEVICE.replace('-', '_'), Build.MODEL.replace('-', '_'));
        return z ? String.valueOf(str).concat("-wear") : str;
    }
}
