package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.adr.lj;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.common.primitives.SignedBytes;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t extends cj {
    private byte[] A;
    private com.google.android.libraries.navigation.internal.hc.a B;
    private ev C;
    private com.google.android.libraries.navigation.internal.hc.a D;
    private com.google.android.libraries.navigation.internal.hc.a E;
    private boolean F;
    private com.google.android.libraries.navigation.internal.hc.a G;
    private int H;
    private boolean I;
    public String a;
    public com.google.android.libraries.navigation.internal.oe.j b;
    public com.google.android.libraries.navigation.internal.oe.r c;
    public String d;
    public com.google.android.libraries.navigation.internal.pt.d e;
    public String f;
    public String g;
    public String h;
    public String i;
    public Boolean j;
    public byte k;
    public int l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private lj f356n;
    private com.google.android.libraries.navigation.internal.hc.a o;
    private com.google.android.libraries.navigation.internal.hc.a p;
    private com.google.android.libraries.navigation.internal.hc.a q;
    private boolean r;
    private boolean s;
    private int t;
    private boolean u;
    private com.google.android.libraries.navigation.internal.adq.ar v;
    private com.google.android.libraries.navigation.internal.hc.a w;
    private com.google.android.libraries.navigation.internal.hc.a x;
    private ev y;
    private byte[] z;

    public t() {
    }

    public t(ck ckVar) {
        u uVar = (u) ckVar;
        this.f356n = uVar.a;
        this.a = uVar.b;
        this.b = uVar.c;
        this.c = uVar.d;
        this.d = uVar.e;
        this.o = uVar.f;
        this.p = uVar.g;
        this.q = uVar.h;
        this.r = uVar.i;
        this.s = uVar.j;
        this.t = uVar.k;
        this.e = uVar.l;
        this.f = uVar.m;
        this.u = uVar.f357n;
        this.v = uVar.o;
        this.w = uVar.p;
        this.x = uVar.q;
        this.y = uVar.r;
        this.z = uVar.s;
        this.A = uVar.t;
        this.g = uVar.u;
        this.B = uVar.v;
        this.C = uVar.w;
        this.D = uVar.x;
        this.h = uVar.y;
        this.i = uVar.z;
        this.E = uVar.A;
        this.F = uVar.B;
        this.j = uVar.C;
        this.G = uVar.D;
        this.l = uVar.G;
        this.H = uVar.E;
        this.I = uVar.F;
        this.k = (byte) -1;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final cj a(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.D = aVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final cj b(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.B = aVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final cj c(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.G = aVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final cj d(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.q = aVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final cj e(ev evVar) {
        Objects.requireNonNull(evVar);
        this.C = evVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final cj f(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.w = aVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final cj g(ev evVar) {
        Objects.requireNonNull(evVar);
        this.y = evVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final cj h(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.A = bArr;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final cj i(byte[] bArr) {
        Objects.requireNonNull(bArr);
        this.z = bArr;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final cj j(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.E = aVar;
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final ck k() {
        if (this.k != -1 || this.f356n == null || this.v == null || this.y == null || this.z == null || this.A == null || this.C == null) {
            throw new IllegalStateException();
        }
        return new u(this.f356n, this.a, this.b, this.c, this.d, this.o, this.p, this.q, this.r, this.s, this.t, this.e, this.f, this.u, this.v, this.w, this.x, this.y, this.z, this.A, this.g, this.B, this.C, this.D, this.h, this.i, this.E, this.F, this.j, this.G, this.l, this.H, this.I);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final void l(boolean z) {
        this.I = z;
        this.k = (byte) (this.k | (-128));
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final void m(lj ljVar) {
        Objects.requireNonNull(ljVar);
        this.f356n = ljVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final void n(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.o = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final void o(int i) {
        this.H = i;
        this.k = (byte) (this.k | SignedBytes.MAX_POWER_OF_TWO);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final void p(boolean z) {
        this.F = z;
        this.k = (byte) (this.k | 32);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final void q(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.x = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final void r(com.google.android.libraries.navigation.internal.adq.ar arVar) {
        Objects.requireNonNull(arVar);
        this.v = arVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final void s(boolean z) {
        this.s = z;
        this.k = (byte) (this.k | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final void t(int i) {
        this.t = i;
        this.k = (byte) (this.k | 4);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final void u() {
        this.r = true;
        this.k = (byte) (1 | this.k);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final void v(boolean z) {
        this.u = z;
        this.k = (byte) (this.k | 8);
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cj
    public final void w(com.google.android.libraries.navigation.internal.hc.a aVar) {
        this.p = aVar;
    }
}
