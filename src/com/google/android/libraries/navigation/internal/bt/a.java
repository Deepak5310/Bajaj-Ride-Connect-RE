package com.google.android.libraries.navigation.internal.bt;

import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.ob.u;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.h6ah4i.android.widget.advrecyclerview.adapter.ItemViewTypeComposer;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends d {
    private boolean A;
    private br B;
    private br C;
    private boolean D;
    public boolean a;
    public bq b;
    public u c;
    public g d;
    public int e;
    public int f;
    public boolean g;
    public an h;
    public an i;
    public int j;
    private bh k;
    private ev l;
    private boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f360n;
    private ev o;
    private ev p;
    private ev q;
    private boolean r;
    private boolean s;
    private e t;
    private an u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private com.google.android.libraries.navigation.internal.bn.f z;

    public a() {
        com.google.android.libraries.navigation.internal.yx.a aVar = com.google.android.libraries.navigation.internal.yx.a.a;
        this.u = aVar;
        this.h = aVar;
        this.i = aVar;
    }

    public a(h hVar) {
        com.google.android.libraries.navigation.internal.yx.a aVar = com.google.android.libraries.navigation.internal.yx.a.a;
        this.u = aVar;
        this.h = aVar;
        this.i = aVar;
        b bVar = (b) hVar;
        this.k = bVar.a;
        this.l = bVar.b;
        this.m = bVar.c;
        this.a = bVar.d;
        this.f360n = bVar.e;
        this.b = bVar.f;
        this.o = bVar.g;
        this.p = bVar.h;
        this.q = bVar.i;
        this.c = bVar.j;
        this.r = bVar.k;
        this.s = bVar.l;
        this.t = bVar.m;
        this.u = bVar.f361n;
        this.d = bVar.o;
        this.v = bVar.p;
        this.w = bVar.q;
        this.x = bVar.r;
        this.y = bVar.s;
        this.e = bVar.t;
        this.f = bVar.u;
        this.z = bVar.v;
        this.A = bVar.w;
        this.B = bVar.x;
        this.C = bVar.y;
        this.g = bVar.z;
        this.D = bVar.A;
        this.h = bVar.B;
        this.i = bVar.C;
        this.j = ItemViewTypeComposer.MAX_WRAPPED_VIEW_TYPE;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void A(boolean z) {
        this.D = z;
        this.j |= 4194304;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void B(boolean z) {
        this.w = z;
        this.j |= 256;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void C(boolean z) {
        this.x = z;
        this.j |= 512;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void D(boolean z) {
        this.y = z;
        this.j |= 1024;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void E(com.google.android.libraries.navigation.internal.bn.f fVar) {
        Objects.requireNonNull(fVar);
        this.z = fVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    protected final void F(ev evVar) {
        Objects.requireNonNull(evVar);
        this.l = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void G(boolean z) {
        this.A = z;
        this.j |= 32768;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void H() {
        this.j |= 2097152;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    protected final int a() {
        if ((this.j & 8192) != 0) {
            return this.e;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    protected final bh b() {
        bh bhVar = this.k;
        if (bhVar != null) {
            return bhVar;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    protected final e c() {
        e eVar = this.t;
        if (eVar != null) {
            return eVar;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    protected final h d() {
        if (this.j != 8388607 || this.k == null || this.l == null || this.o == null || this.p == null || this.q == null || this.c == null || this.t == null || this.d == null || this.z == null || this.B == null || this.C == null) {
            throw new IllegalStateException();
        }
        return new b(this.k, this.l, this.m, this.a, this.f360n, this.b, this.o, this.p, this.q, this.c, this.r, this.s, this.t, this.u, this.d, this.v, this.w, this.x, this.y, this.e, this.f, this.z, this.A, this.B, this.C, this.g, this.D, this.h, this.i);
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    protected final u e() {
        u uVar = this.c;
        if (uVar != null) {
            return uVar;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    protected final an f() {
        return this.u;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    protected final ev g() {
        ev evVar = this.o;
        if (evVar != null) {
            return evVar;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    protected final void h() {
        if ((this.j & 2048) == 0) {
            throw new IllegalStateException();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    protected final void i() {
        if ((this.j & 4096) == 0) {
            throw new IllegalStateException();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    protected final void j() {
        if (this.z == null) {
            throw new IllegalStateException();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void k() {
        this.j |= 1;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void l(br brVar) {
        Objects.requireNonNull(brVar);
        this.B = brVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void m(br brVar) {
        Objects.requireNonNull(brVar);
        this.C = brVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void n(ev evVar) {
        Objects.requireNonNull(evVar);
        this.o = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void o() {
        this.j |= 1048576;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    protected final void p(ev evVar) {
        Objects.requireNonNull(evVar);
        this.q = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void q(boolean z) {
        this.v = z;
        this.j |= 128;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void r(boolean z) {
        this.f360n = z;
        this.j |= 16;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void s(an anVar) {
        Objects.requireNonNull(anVar);
        this.u = anVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void t(e eVar) {
        Objects.requireNonNull(eVar);
        this.t = eVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    protected final void u(ev evVar) {
        Objects.requireNonNull(evVar);
        this.p = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void v(bh bhVar) {
        Objects.requireNonNull(bhVar);
        this.k = bhVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void w(boolean z) {
        this.r = z;
        this.j |= 32;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void x() {
        this.j |= 4;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void y(boolean z) {
        this.m = z;
        this.j |= 2;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.d
    public final void z(boolean z) {
        this.s = z;
        this.j |= 64;
    }
}
