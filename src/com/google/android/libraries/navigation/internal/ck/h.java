package com.google.android.libraries.navigation.internal.ck;

import android.content.Context;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h extends cb {
    public final long a;
    public final ev b;
    public final com.google.android.libraries.navigation.internal.ol.ax c;
    public final Context d;
    public final com.google.android.libraries.navigation.internal.mj.a e;
    public final com.google.android.libraries.navigation.internal.fz.d f;
    public final com.google.android.libraries.navigation.internal.iv.f g;
    public final com.google.android.libraries.navigation.internal.hf.c h = null;
    public final Integer i;
    public final com.google.android.libraries.navigation.internal.cl.aj j;
    public final boolean k;
    public final boolean l;
    public final boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f370n;
    public final com.google.android.libraries.navigation.internal.dx.i o;
    public final boolean p;

    public h(long j, ev evVar, com.google.android.libraries.navigation.internal.ol.ax axVar, Context context, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.hf.c cVar, Integer num, com.google.android.libraries.navigation.internal.cl.aj ajVar, boolean z, boolean z2, boolean z3, boolean z4, com.google.android.libraries.navigation.internal.dx.i iVar, boolean z5) {
        this.a = j;
        this.b = evVar;
        this.c = axVar;
        this.d = context;
        this.e = aVar;
        this.f = dVar;
        this.g = fVar;
        this.i = num;
        this.j = ajVar;
        this.k = z;
        this.l = z2;
        this.m = z3;
        this.f370n = z4;
        this.o = iVar;
        this.p = z5;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final long a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final Context b() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final com.google.android.libraries.navigation.internal.cl.aj c() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final com.google.android.libraries.navigation.internal.dx.i d() {
        return this.o;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final com.google.android.libraries.navigation.internal.fz.d e() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof cb) {
            cb cbVar = (cb) obj;
            if (this.a == cbVar.a() && hx.i(this.b, cbVar.j()) && this.c.equals(cbVar.i()) && this.d.equals(cbVar.b()) && this.e.equals(cbVar.h()) && this.f.equals(cbVar.e())) {
                cbVar.q();
                com.google.android.libraries.navigation.internal.iv.f fVar = this.g;
                if (fVar != null ? fVar.equals(cbVar.g()) : cbVar.g() == null) {
                    cbVar.f();
                    Integer num = this.i;
                    if (num != null ? num.equals(cbVar.k()) : cbVar.k() == null) {
                        if (this.j.equals(cbVar.c()) && this.k == cbVar.m() && this.l == cbVar.l() && this.m == cbVar.p() && this.f370n == cbVar.o() && this.o.equals(cbVar.d()) && this.p == cbVar.n()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final com.google.android.libraries.navigation.internal.hf.c f() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final com.google.android.libraries.navigation.internal.iv.f g() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final com.google.android.libraries.navigation.internal.mj.a h() {
        return this.e;
    }

    public final int hashCode() {
        long j = this.a;
        int iHashCode = ((((((((((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode();
        com.google.android.libraries.navigation.internal.iv.f fVar = this.g;
        int iHashCode2 = fVar == null ? 0 : fVar.hashCode();
        int i = iHashCode * (-721379959);
        Integer num = this.i;
        return ((((((((((((((((i ^ iHashCode2) * (-721379959)) ^ (num != null ? num.hashCode() : 0)) * 1000003) ^ this.j.hashCode()) * 1000003) ^ (true != this.k ? 1237 : 1231)) * 1000003) ^ (true != this.l ? 1237 : 1231)) * 1000003) ^ (true != this.m ? 1237 : 1231)) * 1000003) ^ (true != this.f370n ? 1237 : 1231)) * 1000003) ^ this.o.hashCode()) * 1000003) ^ (true == this.p ? 1231 : 1237);
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final com.google.android.libraries.navigation.internal.ol.ax i() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final ev j() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final Integer k() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final boolean l() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final boolean m() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final boolean n() {
        return this.p;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final boolean o() {
        return this.f370n;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final boolean p() {
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.cb
    public final void q() {
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.dx.i iVar = this.o;
        com.google.android.libraries.navigation.internal.cl.aj ajVar = this.j;
        com.google.android.libraries.navigation.internal.iv.f fVar = this.g;
        com.google.android.libraries.navigation.internal.fz.d dVar = this.f;
        com.google.android.libraries.navigation.internal.mj.a aVar = this.e;
        Context context = this.d;
        com.google.android.libraries.navigation.internal.ol.ax axVar = this.c;
        return "{" + this.a + ", " + String.valueOf(this.b) + ", " + String.valueOf(axVar) + ", " + String.valueOf(context) + ", " + String.valueOf(aVar) + ", " + String.valueOf(dVar) + ", null, " + String.valueOf(fVar) + ", null, " + this.i + ", " + String.valueOf(ajVar) + ", " + this.k + ", " + this.l + ", " + this.m + ", " + this.f370n + ", " + String.valueOf(iVar) + ", " + this.p + "}";
    }
}
