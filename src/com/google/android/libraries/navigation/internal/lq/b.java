package com.google.android.libraries.navigation.internal.lq;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import com.google.android.libraries.navigation.internal.lc.ak;
import com.google.android.libraries.navigation.internal.lc.al;
import com.google.android.libraries.navigation.internal.lh.be;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private static b b;
    public final Context a;

    private b(Context context) {
        this.a = context;
    }

    public static synchronized b a(Context context) {
        Context contextA = a.a(context);
        b bVar = b;
        if (bVar == null || bVar.a != contextA) {
            b bVar2 = null;
            try {
                PackageInfo packageInfo = contextA.getPackageManager().getPackageInfo("com.google.android.gms", 64);
                al alVarA = al.a(contextA);
                if (packageInfo != null && (al.c(packageInfo, false) || (al.c(packageInfo, true) && ak.d(alVarA.a)))) {
                    PackageManager packageManager = contextA.getPackageManager();
                    String authority = c.a.getAuthority();
                    be.j(authority);
                    ProviderInfo providerInfoResolveContentProvider = packageManager.resolveContentProvider(authority, 0);
                    if (providerInfoResolveContentProvider != null) {
                        if (providerInfoResolveContentProvider.packageName.equals("com.google.android.gms")) {
                            bVar2 = new b(contextA);
                        } else {
                            String str = providerInfoResolveContentProvider.packageName;
                        }
                    }
                } else {
                    String str2 = packageInfo.packageName;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            b = bVar2;
        }
        return b;
    }

    public static synchronized void b() {
        b = null;
    }
}
