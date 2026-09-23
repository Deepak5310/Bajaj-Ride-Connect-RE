package com.google.android.libraries.navigation.internal.cl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class e {
    public abstract f a();

    public final f b() {
        f fVarA = a();
        k kVar = (k) fVarA;
        boolean z = (kVar.m == null && kVar.o == null && kVar.q == null) ? false : true;
        boolean z2 = (kVar.l == null && kVar.f375n == null && kVar.p == null) ? false : true;
        if (z) {
            com.google.android.libraries.navigation.internal.yx.ar.l(!z2, "You cannot set V2 MapStyle properties when V3 Style properties are set.");
        }
        return fVarA;
    }

    public abstract void c(bc bcVar);

    public abstract void d(be beVar);

    public abstract void e(bd bdVar);

    public abstract void f(int i);

    public abstract void g(boolean z);

    public abstract void h(boolean z);

    public abstract void i(boolean z);

    public abstract void j(boolean z);

    public abstract void k(boolean z);

    public abstract void l(boolean z);

    public abstract void m(int i);

    public abstract void n(boolean z);
}
