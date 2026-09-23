package com.google.android.libraries.navigation.internal.bt;

import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.ob.u;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends h {
    public final boolean A;
    public final an B;
    public final an C;
    public final bh a;
    public final ev b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final bq f;
    public final ev g;
    public final ev h;
    public final ev i;
    public final u j;
    public final boolean k;
    public final boolean l;
    public final e m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final an f361n;
    public final g o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final boolean s;
    public final int t;
    public final int u;
    public final com.google.android.libraries.navigation.internal.bn.f v;
    public final boolean w;
    public final br x;
    public final br y;
    public final boolean z;

    public b(bh bhVar, ev evVar, boolean z, boolean z2, boolean z3, bq bqVar, ev evVar2, ev evVar3, ev evVar4, u uVar, boolean z4, boolean z5, e eVar, an anVar, g gVar, boolean z6, boolean z7, boolean z8, boolean z9, int i, int i2, com.google.android.libraries.navigation.internal.bn.f fVar, boolean z10, br brVar, br brVar2, boolean z11, boolean z12, an anVar2, an anVar3) {
        this.a = bhVar;
        this.b = evVar;
        this.c = z;
        this.d = z2;
        this.e = z3;
        this.f = bqVar;
        this.g = evVar2;
        this.h = evVar3;
        this.i = evVar4;
        this.j = uVar;
        this.k = z4;
        this.l = z5;
        this.m = eVar;
        this.f361n = anVar;
        this.o = gVar;
        this.p = z6;
        this.q = z7;
        this.r = z8;
        this.s = z9;
        this.t = i;
        this.u = i2;
        this.v = fVar;
        this.w = z10;
        this.x = brVar;
        this.y = brVar2;
        this.z = z11;
        this.A = z12;
        this.B = anVar2;
        this.C = anVar3;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final boolean A() {
        return this.z;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final boolean B() {
        return this.w;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final boolean C() {
        return this.p;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final boolean D() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final void E() {
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final void F() {
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final void G() {
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final void H() {
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final void I() {
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final void J() {
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final void K() {
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final void L() {
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final void M() {
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final void N() {
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final void O() {
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final void P() {
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final int a() {
        return this.u;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final int b() {
        return this.t;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final com.google.android.libraries.navigation.internal.bn.f c() {
        return this.v;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final bh d() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final bq e() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        bq bqVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.a.equals(hVar.d())) {
                hVar.G();
                if (hx.i(this.b, hVar.r()) && this.c == hVar.D()) {
                    hVar.N();
                    if (this.d == hVar.s() && this.e == hVar.t() && ((bqVar = this.f) != null ? bqVar.equals(hVar.e()) : hVar.e() == null) && hx.i(this.g, hVar.o()) && hx.i(this.h, hVar.q()) && hx.i(this.i, hVar.p()) && this.j.equals(hVar.i()) && this.k == hVar.u() && this.l == hVar.v() && this.m.equals(hVar.g()) && this.f361n.equals(hVar.l()) && this.o.equals(hVar.h()) && this.p == hVar.C() && this.q == hVar.x() && this.r == hVar.y() && this.s == hVar.z()) {
                        hVar.J();
                        hVar.K();
                        if (this.t == hVar.b() && this.u == hVar.a() && this.v.equals(hVar.c()) && this.w == hVar.B() && this.x.equals(hVar.m()) && this.y.equals(hVar.n())) {
                            hVar.E();
                            hVar.F();
                            if (this.z == hVar.A()) {
                                hVar.O();
                                hVar.L();
                                hVar.H();
                                hVar.I();
                                hVar.P();
                                if (this.A == hVar.w() && this.B.equals(hVar.k())) {
                                    hVar.M();
                                    if (this.C.equals(hVar.j())) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final d f() {
        return new a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final e g() {
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final g h() {
        return this.o;
    }

    public final int hashCode() {
        int iHashCode = ((((this.a.hashCode() ^ 1000003) * 1000003) ^ 1237) * 1000003) ^ this.b.hashCode();
        bq bqVar = this.f;
        int iHashCode2 = bqVar == null ? 0 : bqVar.hashCode();
        int i = (((iHashCode * 1000003) ^ (true != this.c ? 1237 : 1231)) * 1000003) ^ 1237;
        return (((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((i * 1000003) ^ (true != this.d ? 1237 : 1231)) * 1000003) ^ (true != this.e ? 1237 : 1231)) * 1000003) ^ iHashCode2) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.j.hashCode()) * 1000003) ^ (true != this.k ? 1237 : 1231)) * 1000003) ^ (true != this.l ? 1237 : 1231)) * 1000003) ^ this.m.hashCode()) * 1000003) ^ this.f361n.hashCode()) * 1000003) ^ this.o.hashCode()) * 1000003) ^ (true != this.p ? 1237 : 1231)) * 1000003) ^ (true != this.q ? 1237 : 1231)) * 1000003) ^ (true != this.r ? 1237 : 1231)) * 1000003) ^ (true != this.s ? 1237 : 1231)) * 1000003) ^ 1237) * (-721379959)) ^ this.t) * 1000003) ^ this.u) * 1000003) ^ this.v.hashCode()) * 1000003) ^ (true != this.w ? 1237 : 1231)) * 1000003) ^ this.x.hashCode()) * 1000003) ^ this.y.hashCode()) * (-721379959)) ^ 1237) * 1000003) ^ (true != this.z ? 1237 : 1231)) * 1000003) ^ 1237) * (-721379959)) ^ 1237) * 1000003) ^ 1237) * 1000003) ^ 1237) * 1000003) ^ (true == this.A ? 1231 : 1237)) * 1000003) ^ this.B.hashCode()) * (-721379959)) ^ this.C.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final u i() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final an j() {
        return this.C;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final an k() {
        return this.B;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final an l() {
        return this.f361n;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final br m() {
        return this.x;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final br n() {
        return this.y;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final ev o() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final ev p() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final ev q() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final ev r() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final boolean s() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final boolean t() {
        return this.e;
    }

    public final String toString() {
        an anVar = this.C;
        an anVar2 = this.B;
        br brVar = this.y;
        br brVar2 = this.x;
        com.google.android.libraries.navigation.internal.bn.f fVar = this.v;
        g gVar = this.o;
        an anVar3 = this.f361n;
        e eVar = this.m;
        u uVar = this.j;
        ev evVar = this.i;
        ev evVar2 = this.h;
        ev evVar3 = this.g;
        bq bqVar = this.f;
        ev evVar4 = this.b;
        String strValueOf = String.valueOf(this.a);
        String strValueOf2 = String.valueOf(evVar4);
        String strValueOf3 = String.valueOf(bqVar);
        String strValueOf4 = String.valueOf(evVar3);
        String strValueOf5 = String.valueOf(evVar2);
        String strValueOf6 = String.valueOf(evVar);
        String strValueOf7 = String.valueOf(uVar);
        String strValueOf8 = String.valueOf(eVar);
        String strValueOf9 = String.valueOf(anVar3);
        String strValueOf10 = String.valueOf(gVar);
        String strValueOf11 = String.valueOf(fVar);
        String strValueOf12 = String.valueOf(brVar2);
        String strValueOf13 = String.valueOf(brVar);
        String strValueOf14 = String.valueOf(anVar2);
        String strValueOf15 = String.valueOf(anVar);
        StringBuilder sb = new StringBuilder("{");
        sb.append(strValueOf);
        sb.append(", false, ");
        sb.append(strValueOf2);
        sb.append(", ");
        sb.append(this.c);
        sb.append(", false, ");
        sb.append(this.d);
        sb.append(", ");
        sb.append(this.e);
        sb.append(", ");
        sb.append(strValueOf3);
        sb.append(", ");
        sb.append(strValueOf4);
        sb.append(", ");
        sb.append(strValueOf5);
        sb.append(", ");
        sb.append(strValueOf6);
        sb.append(", ");
        sb.append(strValueOf7);
        sb.append(", ");
        sb.append(this.k);
        sb.append(", ");
        sb.append(this.l);
        sb.append(", ");
        sb.append(strValueOf8);
        sb.append(", ");
        sb.append(strValueOf9);
        sb.append(", ");
        sb.append(strValueOf10);
        sb.append(", ");
        sb.append(this.p);
        boolean z = this.A;
        boolean z2 = this.z;
        boolean z3 = this.w;
        int i = this.u;
        int i2 = this.t;
        boolean z4 = this.s;
        boolean z5 = this.r;
        boolean z6 = this.q;
        sb.append(", ");
        sb.append(z6);
        sb.append(", ");
        sb.append(z5);
        sb.append(", ");
        sb.append(z4);
        sb.append(", false, 0, ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i);
        sb.append(", ");
        sb.append(strValueOf11);
        sb.append(", ");
        sb.append(z3);
        sb.append(", ");
        sb.append(strValueOf12);
        sb.append(", ");
        sb.append(strValueOf13);
        sb.append(", null, false, ");
        sb.append(z2);
        sb.append(", false, null, false, false, false, ");
        sb.append(z);
        sb.append(", ");
        sb.append(strValueOf14);
        sb.append(", null, ");
        sb.append(strValueOf15);
        sb.append("}");
        return sb.toString();
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final boolean u() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final boolean v() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final boolean w() {
        return this.A;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final boolean x() {
        return this.q;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final boolean y() {
        return this.r;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.h
    public final boolean z() {
        return this.s;
    }
}
