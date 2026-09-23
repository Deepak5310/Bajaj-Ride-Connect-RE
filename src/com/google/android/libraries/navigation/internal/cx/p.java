package com.google.android.libraries.navigation.internal.cx;

import android.content.Context;
import android.net.wifi.WifiManager;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    private final Context a;
    private final boolean b;
    private volatile com.google.android.libraries.navigation.internal.np.a c;

    public p(Context context, com.google.android.libraries.navigation.internal.fr.l lVar) {
        this.a = context.getApplicationContext();
        this.b = lVar.c();
    }

    private final boolean e(String str) {
        List listD = this.c != null ? this.c.d() : null;
        return listD != null && listD.contains(str);
    }

    public final void a(com.google.android.libraries.navigation.internal.np.a aVar) {
        this.c = aVar;
    }

    public final int b() {
        if (!this.b) {
            return com.google.android.libraries.navigation.internal.cw.b.b;
        }
        try {
            if (this.c == null || !e("network")) {
                return com.google.android.libraries.navigation.internal.cw.b.b;
            }
            return this.c.j("network") ? com.google.android.libraries.navigation.internal.cw.b.c : com.google.android.libraries.navigation.internal.cw.b.d;
        } catch (SecurityException unused) {
            return com.google.android.libraries.navigation.internal.cw.b.a;
        }
    }

    public final int c() {
        try {
            if (this.c == null || !e("gps")) {
                return com.google.android.libraries.navigation.internal.cw.b.b;
            }
            return this.c.j("gps") ? com.google.android.libraries.navigation.internal.cw.b.c : com.google.android.libraries.navigation.internal.cw.b.d;
        } catch (SecurityException unused) {
            return com.google.android.libraries.navigation.internal.cw.b.a;
        }
    }

    public final int d() {
        try {
            if (this.c == null || !e("network")) {
                return com.google.android.libraries.navigation.internal.cw.b.b;
            }
            if (!this.c.j("network")) {
                return com.google.android.libraries.navigation.internal.cw.b.d;
            }
            WifiManager wifiManager = (WifiManager) this.a.getSystemService("wifi");
            if (wifiManager == null) {
                return com.google.android.libraries.navigation.internal.cw.b.b;
            }
            int wifiState = wifiManager.getWifiState();
            if (wifiState == 3 || wifiState == 2) {
                return com.google.android.libraries.navigation.internal.cw.b.c;
            }
            try {
                Boolean bool = (Boolean) wifiManager.getClass().getDeclaredMethod("isScanAlwaysAvailable", null).invoke(wifiManager, null);
                if (bool != null && bool.booleanValue()) {
                    return com.google.android.libraries.navigation.internal.cw.b.c;
                }
            } catch (Throwable unused) {
            }
            return com.google.android.libraries.navigation.internal.cw.b.d;
        } catch (SecurityException unused2) {
            return com.google.android.libraries.navigation.internal.cw.b.a;
        }
    }
}
