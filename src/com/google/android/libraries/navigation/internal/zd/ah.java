package com.google.android.libraries.navigation.internal.zd;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ah {
    private static String a = "com.google.android.libraries.navigation.internal.ze.d";
    private static String b = "com.google.common.flogger.backend.google.GooglePlatform";
    private static String c = "com.google.android.libraries.navigation.internal.zf.f";
    private static final String[] d = {"com.google.android.libraries.navigation.internal.ze.d", "com.google.common.flogger.backend.google.GooglePlatform", "com.google.android.libraries.navigation.internal.zf.f"};

    public static int a() {
        return com.google.android.libraries.navigation.internal.zj.d.a().a;
    }

    public static long b() {
        return af.a.c();
    }

    public static j d(String str) {
        return af.a.e(str);
    }

    public static n f() {
        return i().a();
    }

    public static ag g() {
        return af.a.h();
    }

    public static com.google.android.libraries.navigation.internal.zg.a i() {
        return af.a.j();
    }

    public static com.google.android.libraries.navigation.internal.zg.l k() {
        return i().b();
    }

    public static String l() {
        return af.a.m();
    }

    public static boolean n(String str, Level level, boolean z) {
        i().c(str, level, z);
        return false;
    }

    protected long c() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    protected abstract j e(String str);

    protected abstract ag h();

    protected com.google.android.libraries.navigation.internal.zg.a j() {
        return com.google.android.libraries.navigation.internal.zg.c.a;
    }

    protected abstract String m();
}
