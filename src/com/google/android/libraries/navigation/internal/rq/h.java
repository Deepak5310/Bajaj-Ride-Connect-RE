package com.google.android.libraries.navigation.internal.rq;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    private static final ThreadLocal a = new ThreadLocal();

    public static e a() {
        e eVar = (e) a.get();
        if (eVar == null) {
            return new e();
        }
        eVar.b(0);
        return eVar;
    }

    public static void b(e eVar) {
        eVar.c();
        a.set(eVar);
    }
}
