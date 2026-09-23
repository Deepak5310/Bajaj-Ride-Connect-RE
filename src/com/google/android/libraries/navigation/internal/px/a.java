package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends em {
    public com.google.android.libraries.geo.mapcore.internal.model.av A;
    public com.google.android.libraries.navigation.internal.or.c B;
    public int C;
    private com.google.android.libraries.navigation.internal.oe.j D;
    private boolean E;
    private com.google.android.libraries.navigation.internal.adl.w F;
    private boolean G;
    private boolean H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private boolean M;
    private boolean N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    public com.google.android.libraries.navigation.internal.adg.ef a;
    public com.google.android.libraries.navigation.internal.adg.ef b;
    public int c;
    public long d;
    public String e;
    public ej f;
    public ev g;
    public String h;
    public cg i;
    public float j;
    public float k;
    public boolean l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f536n;
    public boolean o;
    public boolean p;
    public com.google.android.libraries.navigation.internal.adq.ah q;
    public com.google.android.libraries.geo.mapcore.internal.model.v r;
    public int s;
    public com.google.android.libraries.navigation.internal.adg.es t;
    public boolean u;
    public boolean v;
    public com.google.android.libraries.navigation.internal.ado.j w;
    public boolean x;
    public boolean y;
    public com.google.android.libraries.navigation.internal.adl.as z;

    public a() {
    }

    public a(ep epVar) {
        this.a = epVar.o();
        this.b = epVar.n();
        this.c = epVar.c();
        this.d = epVar.e();
        this.D = epVar.f();
        this.e = epVar.u();
        this.f = epVar.i();
        this.E = epVar.M();
        this.g = epVar.m();
        this.h = epVar.v();
        this.i = epVar.h();
        this.j = epVar.b();
        this.k = epVar.a();
        this.F = epVar.q();
        this.G = epVar.H();
        this.H = epVar.N();
        this.I = epVar.O();
        this.J = epVar.I();
        this.K = epVar.D();
        this.l = epVar.K();
        this.L = epVar.R();
        this.M = epVar.G();
        this.N = epVar.S();
        this.O = epVar.P();
        this.m = epVar.L();
        this.f536n = epVar.B();
        this.o = epVar.C();
        this.p = epVar.E();
        this.q = epVar.t();
        this.r = epVar.k();
        this.s = epVar.d();
        this.t = epVar.p();
        this.P = epVar.y();
        this.u = epVar.w();
        this.v = epVar.z();
        this.w = epVar.s();
        this.Q = epVar.x();
        this.x = epVar.A();
        this.R = epVar.F();
        this.y = epVar.Q();
        this.z = epVar.r();
        this.S = epVar.J();
        this.A = epVar.l();
        this.B = epVar.g();
        this.C = 268435455;
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final ep a() {
        com.google.android.libraries.navigation.internal.adg.ef efVar;
        com.google.android.libraries.navigation.internal.oe.j jVar;
        String str;
        ev evVar;
        String str2;
        cg cgVar;
        com.google.android.libraries.navigation.internal.adl.w wVar;
        com.google.android.libraries.navigation.internal.adg.es esVar;
        if (this.C != 268435455 || (efVar = this.a) == null || (jVar = this.D) == null || (str = this.e) == null || (evVar = this.g) == null || (str2 = this.h) == null || (cgVar = this.i) == null || (wVar = this.F) == null || (esVar = this.t) == null) {
            throw new IllegalStateException();
        }
        return new x(efVar, this.b, this.c, this.d, jVar, str, this.f, this.E, evVar, str2, cgVar, this.j, this.k, wVar, this.G, this.H, this.I, this.J, this.K, this.l, this.L, this.M, this.N, this.O, this.m, this.f536n, this.o, this.p, this.q, this.r, this.s, esVar, this.P, this.u, this.v, this.w, this.Q, this.x, this.R, this.y, this.z, this.S, this.A, this.B);
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final void b(com.google.android.libraries.navigation.internal.adl.w wVar) {
        Objects.requireNonNull(wVar);
        this.F = wVar;
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final void c(com.google.android.libraries.navigation.internal.oe.j jVar) {
        Objects.requireNonNull(jVar);
        this.D = jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final void d(boolean z) {
        this.Q = z;
        this.C |= 8388608;
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final void e(boolean z) {
        this.P = z;
        this.C |= 1048576;
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final void f(boolean z) {
        this.K = z;
        this.C |= 512;
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final void g(boolean z) {
        this.R = z;
        this.C |= 33554432;
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final void h(boolean z) {
        this.M = z;
        this.C |= 4096;
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final void i(boolean z) {
        this.G = z;
        this.C |= 32;
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final void j(boolean z) {
        this.J = z;
        this.C |= 256;
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final void k(boolean z) {
        this.S = z;
        this.C |= 134217728;
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final void l(boolean z) {
        this.E = z;
        this.C |= 4;
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final void m(boolean z) {
        this.H = z;
        this.C |= 64;
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final void n(boolean z) {
        this.I = z;
        this.C |= 128;
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final void o(boolean z) {
        this.O = z;
        this.C |= 16384;
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final void p(boolean z) {
        this.L = z;
        this.C |= 2048;
    }

    @Override // com.google.android.libraries.navigation.internal.px.em
    public final void q(boolean z) {
        this.N = z;
        this.C |= 8192;
    }
}
