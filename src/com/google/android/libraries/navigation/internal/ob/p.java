package com.google.android.libraries.navigation.internal.ob;

import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class p {
    public abstract r a();

    public abstract void b(long j);

    public abstract void c(int i);

    public abstract void d(int i);

    public abstract void e(int i);

    public abstract void f(int i);

    public abstract void g(int i);

    public abstract void h(u uVar);

    public abstract void i(com.google.android.libraries.navigation.internal.oe.r rVar);

    public final r j() {
        r rVarA = a();
        b bVar = (b) rVarA;
        int iOrdinal = bVar.a.ordinal();
        if (iOrdinal == 4) {
            ar.r(null, "Missing icon for custom icon pin");
        } else if (iOrdinal == 6) {
            ar.l(bVar.c != r.g, "Missing layout named style for named style pin");
            ar.l(bVar.b != r.g, "Missing icon named style for named style pin");
        }
        if (bVar.d > 0) {
            ar.l(bVar.e != r.g, "Missing area named style for named style imprecision circle");
        }
        return rVarA;
    }
}
