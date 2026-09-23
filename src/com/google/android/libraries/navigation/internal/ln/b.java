package com.google.android.libraries.navigation.internal.ln;

import android.content.Context;
import com.google.android.libraries.navigation.internal.ll.i;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private static Context a;
    private static Boolean b;

    public static synchronized boolean a(Context context) {
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = a;
        if (context2 != null && (bool = b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        b = null;
        if (i.d()) {
            b = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        } else {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                b = true;
            } catch (ClassNotFoundException unused) {
                b = false;
            }
        }
        a = applicationContext;
        return b.booleanValue();
    }
}
