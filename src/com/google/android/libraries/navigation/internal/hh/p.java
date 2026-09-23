package com.google.android.libraries.navigation.internal.hh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    public final Object a;
    public final boolean b;
    public final int c;

    public p(Object obj, boolean z, int i) {
        this.a = obj;
        this.b = z;
        this.c = i;
    }

    static p b(int i, Exception exc) {
        new o(i, exc);
        return new p(null, false, i);
    }

    public final void a(com.google.android.libraries.navigation.internal.kk.k kVar) {
        kVar.a(this.c - 1);
    }
}
