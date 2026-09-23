package com.google.android.libraries.navigation.internal.om;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.adobe.internal.xmp.options.PropertyOptions;
import com.google.android.libraries.navigation.internal.ace.ff;
import com.google.android.libraries.navigation.internal.yx.an;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends k {
    private boolean A;
    private boolean B;
    private long C;
    private boolean D;
    private boolean E;
    private boolean F;
    private an G = com.google.android.libraries.navigation.internal.yx.a.a;
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
    private int S;
    private short T;
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private ff m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f498n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private long z;

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void A(boolean z) {
        this.I = z;
        this.T = (short) (this.T | 4);
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void B(boolean z) {
        this.M = z;
        this.T = (short) (this.T | 64);
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void C(boolean z) {
        this.f498n = z;
        this.S |= 8192;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void D(boolean z) {
        this.r = z;
        this.S |= 131072;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void E(boolean z) {
        this.P = z;
        this.T = (short) (this.T | 512);
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void F() {
        this.S |= 2048;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void G(boolean z) {
        this.i = z;
        this.S |= 256;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void H(boolean z) {
        this.q = z;
        this.S |= 65536;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void I(boolean z) {
        this.A = z;
        this.S |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void J(boolean z) {
        this.e = z;
        this.S |= 16;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void K(boolean z) {
        this.B = z;
        this.S |= 134217728;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void L(boolean z) {
        this.o = z;
        this.S |= 16384;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void M(boolean z) {
        this.p = z;
        this.S |= 32768;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void N(boolean z) {
        this.K = z;
        this.T = (short) (this.T | 16);
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void O(boolean z) {
        this.t = z;
        this.S |= 524288;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void P(long j) {
        this.C = j;
        this.S |= 268435456;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void Q(boolean z) {
        this.b = z;
        this.S |= 2;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void R(boolean z) {
        this.a = z;
        this.S |= 1;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void S() {
        this.S |= Integer.MIN_VALUE;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void T(long j) {
        this.z = j;
        this.S |= 33554432;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void U(boolean z) {
        this.R = z;
        this.T = (short) (this.T | 2048);
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final l a() {
        ff ffVar;
        if (this.S == -1 && this.T == 4095 && (ffVar = this.m) != null) {
            return new d(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, false, ffVar, this.f498n, this.o, this.p, this.q, this.r, this.s, this.t, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.B, this.C, this.D, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.M, this.N, this.O, this.P, this.Q, this.R);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void b(boolean z) {
        this.D = z;
        this.S |= PropertyOptions.DELETE_EXISTING;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void c(boolean z) {
        this.H = z;
        this.T = (short) (this.T | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void d(ff ffVar) {
        Objects.requireNonNull(ffVar);
        this.m = ffVar;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void e(an anVar) {
        Objects.requireNonNull(anVar);
        this.G = anVar;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void f(boolean z) {
        this.F = z;
        this.T = (short) (this.T | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void g(boolean z) {
        this.x = z;
        this.S |= 8388608;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void h(boolean z) {
        this.E = z;
        this.S |= 1073741824;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void i(boolean z) {
        this.j = z;
        this.S |= 512;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void j(boolean z) {
        this.y = z;
        this.S |= 16777216;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void k(boolean z) {
        this.c = z;
        this.S |= 4;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void l(boolean z) {
        this.s = z;
        this.S |= 262144;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void m(boolean z) {
        this.g = z;
        this.S |= 64;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void n(boolean z) {
        this.k = z;
        this.S |= 1024;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void o(boolean z) {
        this.v = z;
        this.S |= 2097152;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void p(boolean z) {
        this.O = z;
        this.T = (short) (this.T | 256);
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void q(boolean z) {
        this.N = z;
        this.T = (short) (this.T | 128);
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void r(boolean z) {
        this.w = z;
        this.S |= 4194304;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void s(boolean z) {
        this.f = z;
        this.S |= 32;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void t(boolean z) {
        this.l = false;
        this.S |= 4096;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void u(boolean z) {
        this.u = z;
        this.S |= 1048576;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void v(boolean z) {
        this.h = z;
        this.S |= 128;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void w(boolean z) {
        this.d = z;
        this.S |= 8;
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void x(boolean z) {
        this.J = z;
        this.T = (short) (this.T | 8);
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void y(boolean z) {
        this.Q = z;
        this.T = (short) (this.T | 1024);
    }

    @Override // com.google.android.libraries.navigation.internal.om.k
    public final void z(boolean z) {
        this.L = z;
        this.T = (short) (this.T | 32);
    }
}
