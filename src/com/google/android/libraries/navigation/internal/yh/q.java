package com.google.android.libraries.navigation.internal.yh;

import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q {
    public Executor a;
    public com.google.android.libraries.navigation.internal.xy.f b;
    public com.google.android.libraries.navigation.internal.yn.a c;
    public com.google.android.libraries.navigation.internal.yl.a d = com.google.android.libraries.navigation.internal.yl.a.a;
    private final HashMap e = new HashMap();

    public final p a() {
        return new p(this.a, this.b, this.d, this.e, this.c);
    }

    public final void b(au auVar) {
        String strB = auVar.b(d.ALLOWED);
        com.google.android.libraries.navigation.internal.yx.ar.f(!this.e.containsKey(strB), "There is already a factory registered for the ID %s", strB);
        this.e.put(strB, auVar);
    }
}
