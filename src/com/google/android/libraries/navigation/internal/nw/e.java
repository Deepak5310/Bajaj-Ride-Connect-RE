package com.google.android.libraries.navigation.internal.nw;

import androidx.tracing.Trace;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    private static final d b = new d();
    public static final String[] a = {"com.google", ".android", ".apps", ".gmm"};

    public static d a(c cVar) {
        if (Trace.isEnabled()) {
            return d(cVar.a().a);
        }
        return null;
    }

    public static final d b(String str) {
        if (Trace.isEnabled()) {
            return d(str);
        }
        return null;
    }

    public static d c(String str, Enum r2) {
        if (Trace.isEnabled()) {
            return d(str.concat(String.valueOf(r2.name())));
        }
        return null;
    }

    public static d d(String str) {
        Trace.beginSection(str);
        return b;
    }

    public static void e(com.google.android.libraries.navigation.internal.xn.a aVar, int i) {
        Trace.beginAsyncSection(aVar.a, i);
    }

    public static void f(com.google.android.libraries.navigation.internal.xn.a aVar, int i) {
        Trace.endAsyncSection(aVar.a, i);
    }

    public static void g(com.google.android.libraries.navigation.internal.xn.a aVar, int i) {
        Trace.setCounter(aVar.a, i);
    }
}
