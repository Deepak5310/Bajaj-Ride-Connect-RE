package com.google.android.libraries.navigation.internal.abh;

import com.google.android.libraries.navigation.internal.yz.mp;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fm {
    public final Set a = mp.i();
    public com.google.android.libraries.navigation.internal.ly.ah b = null;
    public com.google.android.libraries.navigation.internal.ly.af c = null;
    public com.google.android.libraries.navigation.internal.ly.bp d = null;
    public com.google.android.libraries.navigation.internal.ly.br e = null;
    public final ht f;
    private final com.google.android.libraries.navigation.internal.abf.z g;

    public fm(com.google.android.libraries.navigation.internal.abf.z zVar, ht htVar) {
        this.g = zVar;
        this.f = htVar;
    }

    public final void a(fl flVar) {
        this.a.add(flVar);
    }

    public final void b(fl flVar) {
        this.a.remove(flVar);
    }

    public final void c(com.google.android.libraries.navigation.internal.ly.af afVar) {
        this.g.a();
        this.c = afVar;
    }

    public final void d(com.google.android.libraries.navigation.internal.ly.ah ahVar) {
        this.g.a();
        this.b = ahVar;
    }

    public final void e(com.google.android.libraries.navigation.internal.ly.bp bpVar) {
        this.g.a();
        this.d = bpVar;
    }

    public final void f(com.google.android.libraries.navigation.internal.ly.br brVar) {
        this.g.a();
        this.e = brVar;
    }
}
