package com.google.android.libraries.navigation.internal.ll;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public static Boolean a;
    public static Boolean b;
    private static Boolean c;
    private static Boolean d;

    public static boolean a(Context context) {
        return b(context.getPackageManager());
    }

    public static boolean b(PackageManager packageManager) {
        if (c == null) {
            boolean z = false;
            if (i.b() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z = true;
            }
            c = Boolean.valueOf(z);
        }
        return c.booleanValue();
    }

    public static boolean c(Context context) {
        a(context);
        if (d == null) {
            d = Boolean.valueOf(i.c() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return d.booleanValue() && (!i.d() || Build.VERSION.SDK_INT >= 30);
    }
}
