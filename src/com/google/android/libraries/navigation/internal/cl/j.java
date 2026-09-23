package com.google.android.libraries.navigation.internal.cl;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j extends e {
    public String a;
    public com.google.android.libraries.navigation.internal.ol.aq b;
    public com.google.android.libraries.navigation.internal.oo.f c;
    public com.google.android.libraries.navigation.internal.ol.aq d;
    public com.google.android.libraries.navigation.internal.oo.f e;
    public com.google.android.libraries.navigation.internal.ol.aq f;
    public com.google.android.libraries.navigation.internal.oo.f g;
    public boolean h;
    public short i;
    private bd j;
    private bc k;
    private be l;
    private boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f374n;
    private int o;
    private int p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;

    @Override // com.google.android.libraries.navigation.internal.cl.e
    public final f a() {
        bd bdVar;
        bc bcVar;
        be beVar;
        if (this.i != 1023 || (bdVar = this.j) == null || (bcVar = this.k) == null || (beVar = this.l) == null) {
            throw new IllegalStateException();
        }
        return new k(bdVar, bcVar, beVar, this.m, this.f374n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
    }

    @Override // com.google.android.libraries.navigation.internal.cl.e
    public final void c(bc bcVar) {
        Objects.requireNonNull(bcVar);
        this.k = bcVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.e
    public final void d(be beVar) {
        Objects.requireNonNull(beVar);
        this.l = beVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.e
    public final void e(bd bdVar) {
        Objects.requireNonNull(bdVar);
        this.j = bdVar;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.e
    public final void f(int i) {
        this.p = i;
        this.i = (short) (this.i | 8);
    }

    @Override // com.google.android.libraries.navigation.internal.cl.e
    public final void g(boolean z) {
        this.t = z;
        this.i = (short) (this.i | 128);
    }

    @Override // com.google.android.libraries.navigation.internal.cl.e
    public final void h(boolean z) {
        this.s = z;
        this.i = (short) (this.i | 64);
    }

    @Override // com.google.android.libraries.navigation.internal.cl.e
    public final void i(boolean z) {
        this.q = z;
        this.i = (short) (this.i | 16);
    }

    @Override // com.google.android.libraries.navigation.internal.cl.e
    public final void j(boolean z) {
        this.u = z;
        this.i = (short) (this.i | 256);
    }

    @Override // com.google.android.libraries.navigation.internal.cl.e
    public final void k(boolean z) {
        this.f374n = z;
        this.i = (short) (this.i | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.cl.e
    public final void l(boolean z) {
        this.m = z;
        this.i = (short) (this.i | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.cl.e
    public final void m(int i) {
        this.o = i;
        this.i = (short) (this.i | 4);
    }

    @Override // com.google.android.libraries.navigation.internal.cl.e
    public final void n(boolean z) {
        this.r = z;
        this.i = (short) (this.i | 32);
    }
}
