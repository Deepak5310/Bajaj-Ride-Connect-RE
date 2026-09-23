package com.google.android.libraries.navigation.internal.b;

import android.util.Log;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag {
    public static final String a = "Volley";
    public static final boolean b = Log.isLoggable(a, 2);
    private static final String c = ag.class.getName();

    public static void a(String str, Object... objArr) {
        if (b) {
            b(str, objArr);
        }
    }

    public static void b(String str, Object... objArr) {
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        for (int i = 2; i < stackTrace.length; i++) {
            if (!stackTrace[i].getClassName().equals(c)) {
                String className = stackTrace[i].getClassName();
                String strSubstring = className.substring(className.lastIndexOf(46) + 1);
                strSubstring.substring(strSubstring.lastIndexOf(36) + 1);
                stackTrace[i].getMethodName();
                break;
            }
        }
        Thread.currentThread().getId();
    }
}
