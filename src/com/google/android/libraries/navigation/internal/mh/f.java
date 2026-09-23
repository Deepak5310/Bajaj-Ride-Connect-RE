package com.google.android.libraries.navigation.internal.mh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    private static e a;

    public static synchronized e a() {
        if (a == null) {
            b(new m());
        }
        return a;
    }

    public static synchronized void b(e eVar) {
        if (a != null) {
            throw new IllegalStateException("init() already called");
        }
        a = eVar;
    }
}
