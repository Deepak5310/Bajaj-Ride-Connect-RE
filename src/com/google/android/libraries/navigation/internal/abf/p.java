package com.google.android.libraries.navigation.internal.abf;

import android.util.Log;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    public static boolean a = false;

    public static void a(int i, String str, Object... objArr) {
        Log.println(i, "Google Android Maps SDK", String.format(str, objArr));
    }

    public static void b(String str) {
        h(str, " are not supported in Lite Mode");
    }

    public static void c(String str) {
        a(6, str, new Object[0]);
    }

    public static void d(String str, Throwable th) {
        a(6, str + "\n" + Log.getStackTraceString(th), new Object[0]);
    }

    public static void e(String str) {
        h(str, " is not supported in Lite Mode");
    }

    public static final boolean f(String str, int i) {
        return a ? g(o.a, str, i) : g(3, str, i);
    }

    static final boolean g(int i, String str, int i2) {
        int i3;
        switch (i) {
            case 0:
                return false;
            case 1:
            case 2:
                return true;
            case 3:
                i3 = 3;
                break;
            case 4:
                i3 = 4;
                break;
            case 5:
                i3 = 5;
                break;
            case 6:
                i3 = 6;
                break;
            default:
                return Log.isLoggable(str, i2);
        }
        return i2 >= i3;
    }

    private static void h(String str, String str2) {
        a(5, str.concat(str2), new Object[0]);
    }
}
