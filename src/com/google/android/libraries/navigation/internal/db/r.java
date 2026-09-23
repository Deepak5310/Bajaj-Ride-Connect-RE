package com.google.android.libraries.navigation.internal.db;

import com.google.firebase.analytics.FirebaseAnalytics;
import j$.time.Duration;
import j$.time.Instant;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class r implements n, com.google.android.libraries.navigation.internal.of.a {
    public static final /* synthetic */ int r = 0;
    public final String a;
    public final double b;
    public final double c;
    public final float d;
    public final double e;
    public final float f;
    public final Duration g;
    public final ak h;
    public final v i;
    public final f j;
    public final r k;
    public final ab l;
    public final float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.pt.d f387n;
    public final int o;
    public final boolean p;
    public final boolean q;
    private final float t;
    private final float u;
    private final float v;
    private final float w;
    private final Instant x;

    /* JADX WARN: Code duplicated, block: B:24:0x0097  */
    public r(q qVar) {
        this.a = com.google.android.libraries.navigation.internal.yx.aq.b(qVar.a);
        this.b = qVar.b;
        this.c = qVar.c;
        this.d = qVar.d;
        this.e = qVar.e;
        this.t = qVar.f;
        this.v = qVar.h;
        this.f = qVar.i;
        this.w = qVar.j;
        float f = qVar.g;
        if (Float.isNaN(f)) {
            this.u = Float.NaN;
        } else {
            this.u = f % 360.0f;
        }
        this.g = qVar.g();
        this.x = qVar.l;
        ak akVar = qVar.m;
        this.h = akVar == null ? null : akVar.a();
        u uVar = qVar.f386n;
        this.i = uVar == null ? null : uVar.a();
        this.j = qVar.o;
        this.k = qVar.p;
        this.l = qVar.q;
        this.m = qVar.r;
        if (Objects.equals(qVar.a, "fused") && Objects.equals(qVar.a, "network")) {
            float f2 = qVar.r;
            if (Float.isNaN(f2) || f2 < 0.7f) {
                this.f387n = null;
            } else {
                this.f387n = qVar.s;
            }
        } else {
            this.f387n = qVar.s;
        }
        this.o = qVar.t;
        this.p = qVar.u;
        this.q = qVar.v;
    }

    public static boolean C(boolean z, float f, boolean z2) {
        if (z) {
            return f > 3.0f || z2;
        }
        return false;
    }

    public static q j(r rVar) {
        q qVar = new q(rVar.g);
        qVar.a = rVar.a;
        qVar.s(rVar.b, rVar.c);
        if (rVar.r()) {
            qVar.d = rVar.d;
        }
        if (rVar.s()) {
            qVar.e = rVar.e;
        }
        if (rVar.A()) {
            qVar.f = rVar.i();
        }
        if (rVar.t()) {
            qVar.g = rVar.f();
        }
        if (rVar.u()) {
            qVar.h = rVar.g();
        }
        if (rVar.x()) {
            qVar.i = rVar.f;
        }
        if (rVar.y()) {
            qVar.j = rVar.h();
        }
        if (rVar.z()) {
            qVar.l = rVar.q();
        }
        qVar.k = rVar.g;
        v vVar = rVar.i;
        if (vVar != null) {
            boolean z = vVar.d;
            qVar.f386n = new u(vVar.b, vVar.c, z);
        }
        ab abVar = rVar.l;
        if (abVar != null) {
            qVar.q = abVar;
        }
        r rVar2 = rVar.k;
        if (rVar2 != null) {
            qVar.p = rVar2;
        }
        qVar.v = rVar.q;
        ak akVar = rVar.h;
        if (akVar != null) {
            qVar.m = akVar.a();
        }
        return qVar;
    }

    public final boolean A() {
        return !Float.isNaN(this.t);
    }

    public final boolean B() {
        return l().b;
    }

    @Override // com.google.android.libraries.navigation.internal.db.n
    public final ab a() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.db.as
    public final double b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.db.as
    public final double c() {
        return this.c;
    }

    public final float d(r rVar) {
        return ar.a(this.b, this.c, rVar.b, rVar.c);
    }

    public final float e(com.google.android.libraries.navigation.internal.oe.x xVar) {
        return ar.a(this.b, this.c, xVar.b(), xVar.d());
    }

    public final boolean equals(Object obj) {
        return obj instanceof r;
    }

    @Override // com.google.android.libraries.navigation.internal.of.a
    public final float f() {
        if (t()) {
            return this.u;
        }
        return 0.0f;
    }

    public final float g() {
        if (u()) {
            return this.v;
        }
        return 1000000.0f;
    }

    public final float h() {
        if (y()) {
            return this.w;
        }
        return 1000000.0f;
    }

    public final int hashCode() {
        return 0;
    }

    public final float i() {
        if (A()) {
            return this.t;
        }
        return 1000000.0f;
    }

    public final v k() {
        v vVar = this.i;
        return vVar == null ? v.a : vVar;
    }

    public final ak l() {
        ak akVar = this.h;
        return akVar == null ? ak.a : akVar;
    }

    public final com.google.android.libraries.navigation.internal.oe.r m() {
        return new com.google.android.libraries.navigation.internal.oe.r(this.b, this.c);
    }

    public final com.google.android.libraries.navigation.internal.oe.x n() {
        return com.google.android.libraries.navigation.internal.oe.x.A(this.b, this.c);
    }

    @Override // com.google.android.libraries.navigation.internal.db.as
    public final com.google.android.libraries.navigation.internal.aes.h o() {
        com.google.android.libraries.navigation.internal.aes.g gVarA = w.a(this.b, this.c, this.d);
        int i = com.google.android.libraries.navigation.internal.aes.l.b;
        if (!gVarA.b.H()) {
            gVarA.v();
        }
        com.google.android.libraries.navigation.internal.aes.h hVar = (com.google.android.libraries.navigation.internal.aes.h) gVarA.b;
        com.google.android.libraries.navigation.internal.aes.h hVar2 = com.google.android.libraries.navigation.internal.aes.h.a;
        int i2 = i - 2;
        if (i == 0) {
            throw null;
        }
        hVar.c = i2;
        hVar.b |= 1;
        int i3 = com.google.android.libraries.navigation.internal.aes.j.l;
        if (!gVarA.b.H()) {
            gVarA.v();
        }
        com.google.android.libraries.navigation.internal.aes.h hVar3 = (com.google.android.libraries.navigation.internal.aes.h) gVarA.b;
        int i4 = i3 - 2;
        if (i3 == 0) {
            throw null;
        }
        hVar3.d = i4;
        hVar3.b |= 2;
        if (!gVarA.b.H()) {
            gVarA.v();
        }
        com.google.android.libraries.navigation.internal.aes.h hVar4 = (com.google.android.libraries.navigation.internal.aes.h) gVarA.b;
        hVar4.b |= 256;
        hVar4.h = 68;
        com.google.android.libraries.navigation.internal.aes.e eVar = (com.google.android.libraries.navigation.internal.aes.e) com.google.android.libraries.navigation.internal.aes.f.a.q();
        if (v()) {
            int iRound = Math.round(f());
            if (!eVar.b.H()) {
                eVar.v();
            }
            com.google.android.libraries.navigation.internal.aes.f fVar = (com.google.android.libraries.navigation.internal.aes.f) eVar.b;
            fVar.b |= 2;
            fVar.c = iRound;
        }
        if (x()) {
            int iRound2 = Math.round(this.f * 3.6f);
            if (!eVar.b.H()) {
                eVar.v();
            }
            com.google.android.libraries.navigation.internal.aes.f fVar2 = (com.google.android.libraries.navigation.internal.aes.f) eVar.b;
            fVar2.b |= 8;
            fVar2.d = iRound2;
        }
        com.google.android.libraries.navigation.internal.aes.f fVar3 = (com.google.android.libraries.navigation.internal.aes.f) eVar.t();
        if (!gVarA.b.H()) {
            gVarA.v();
        }
        com.google.android.libraries.navigation.internal.aes.h hVar5 = (com.google.android.libraries.navigation.internal.aes.h) gVarA.b;
        fVar3.getClass();
        hVar5.k = fVar3;
        hVar5.b |= 524288;
        com.google.android.libraries.navigation.internal.pt.d dVar = this.f387n;
        if (dVar != null) {
            com.google.android.libraries.navigation.internal.aes.a aVar = (com.google.android.libraries.navigation.internal.aes.a) com.google.android.libraries.navigation.internal.aes.b.a.q();
            if (!aVar.b.H()) {
                aVar.v();
            }
            com.google.android.libraries.navigation.internal.aes.b bVar = (com.google.android.libraries.navigation.internal.aes.b) aVar.b;
            bVar.b |= 1;
            com.google.android.libraries.navigation.internal.oe.i iVar = dVar.b;
            bVar.c = iVar.b;
            if (!aVar.b.H()) {
                aVar.v();
            }
            long j = iVar.c;
            com.google.android.libraries.navigation.internal.aes.b bVar2 = (com.google.android.libraries.navigation.internal.aes.b) aVar.b;
            bVar2.b |= 2;
            bVar2.d = j;
            com.google.android.libraries.navigation.internal.aes.b bVar3 = (com.google.android.libraries.navigation.internal.aes.b) aVar.t();
            if (!gVarA.b.H()) {
                gVarA.v();
            }
            com.google.android.libraries.navigation.internal.aes.h hVar6 = (com.google.android.libraries.navigation.internal.aes.h) gVarA.b;
            bVar3.getClass();
            hVar6.i = bVar3;
            hVar6.b |= 4096;
            int i5 = dVar.c;
            if (!gVarA.b.H()) {
                gVarA.v();
            }
            com.google.android.libraries.navigation.internal.aes.h hVar7 = (com.google.android.libraries.navigation.internal.aes.h) gVarA.b;
            hVar7.b |= 8192;
            hVar7.j = i5 * 0.001f;
        }
        if (z()) {
            long jA = com.google.android.libraries.navigation.internal.aaa.b.a(q());
            if (!gVarA.b.H()) {
                gVarA.v();
            }
            com.google.android.libraries.navigation.internal.aes.h hVar8 = (com.google.android.libraries.navigation.internal.aes.h) gVarA.b;
            hVar8.b |= 4;
            hVar8.e = jA;
        }
        return (com.google.android.libraries.navigation.internal.aes.h) gVarA.t();
    }

    @Override // com.google.android.libraries.navigation.internal.db.as
    public final Duration p() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.db.as
    public final Instant q() {
        return z() ? this.x : Instant.EPOCH;
    }

    public final boolean r() {
        return !Float.isNaN(this.d);
    }

    public final boolean s() {
        return !Double.isNaN(this.e);
    }

    @Override // com.google.android.libraries.navigation.internal.of.a
    public final boolean t() {
        return !Float.isNaN(this.u);
    }

    public final String toString() {
        String str;
        String str2;
        String str3;
        String str4;
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.g("source", this.a);
        akVarB.g("point", n().E());
        if (r()) {
            str = this.d + " m";
        } else {
            str = "n/a";
        }
        akVarB.g("accuracy", str);
        if (x()) {
            str2 = this.f + " m/s";
        } else {
            str2 = "n/a";
        }
        akVarB.g("speed", str2);
        if (y()) {
            str3 = h() + " m/s";
        } else {
            str3 = "n/a";
        }
        akVarB.g("speedAcc", str3);
        if (t()) {
            str4 = f() + " degrees";
        } else {
            str4 = "n/a";
        }
        akVarB.g("bearing", str4);
        akVarB.g("timestamp", q());
        com.google.android.libraries.navigation.internal.yx.ak akVarD = akVarB.d("elapsedrealtime", com.google.android.libraries.navigation.internal.ja.a.a(this.g));
        com.google.android.libraries.navigation.internal.pt.d dVar = this.f387n;
        akVarD.g(FirebaseAnalytics.Param.LEVEL, dVar != null ? dVar : "n/a");
        akVarD.g("routeSnappingInfo", this.h);
        akVarD.g("gpsInfo", this.i);
        akVarD.g("rawLocation", this.k);
        if (this.q) {
            akVarD.e("fixups", true);
        }
        if (this.p) {
            akVarD.e("isMockLocation", true);
        }
        return akVarD.toString();
    }

    public final boolean u() {
        return !Float.isNaN(this.v);
    }

    public final boolean v() {
        return x() && C(t(), this.f, l().b);
    }

    public final boolean w() {
        return this.h != null;
    }

    @Override // com.google.android.libraries.navigation.internal.of.a
    public final boolean x() {
        return !Float.isNaN(this.f);
    }

    public final boolean y() {
        return !Float.isNaN(this.w);
    }

    @Override // com.google.android.libraries.navigation.internal.db.as
    @Deprecated
    public final boolean z() {
        return this.x != null;
    }
}
