package com.google.android.libraries.navigation.internal.jb;

import android.content.Context;
import android.os.Build;
import com.google.android.libraries.navigation.internal.yx.bj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final bj a = bj.b('-');

    public static String a(Context context) {
        try {
            return com.google.android.libraries.navigation.internal.mh.b.c(context.getContentResolver(), "maps_client_id", "dev");
        } catch (RuntimeException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F(740)).p("Swallowed exception. See b/26710136 and b/31244960.");
            return "dev";
        }
    }

    public static String b() {
        String str = Build.MANUFACTURER;
        String str2 = Build.DEVICE;
        String str3 = Build.MODEL;
        return "android:" + str.replace('-', '_') + "-" + str2.replace('-', '_') + "-" + str3.replace('-', '_');
    }
}
