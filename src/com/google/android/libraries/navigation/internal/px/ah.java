package com.google.android.libraries.navigation.internal.px;

import android.content.res.Resources;
import android.graphics.RectF;
import com.google.android.libraries.geo.mapcore.renderer.LabelRenderer;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.mb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class ah extends al {
    private static final com.google.android.libraries.navigation.internal.zb.j p = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.px.ah");
    private float B;
    private com.google.android.libraries.navigation.internal.ol.l C;
    private com.google.android.libraries.geo.mapcore.renderer.er D;
    private com.google.android.libraries.navigation.internal.pz.a E;
    private com.google.android.libraries.navigation.internal.qe.b F;
    private com.google.android.libraries.navigation.internal.qc.g G;
    private float H;
    private Resources I;
    private com.google.android.libraries.navigation.internal.qz.g J;
    private ek K;
    private ae Q;
    public com.google.android.libraries.navigation.internal.py.a a;
    private com.google.android.libraries.navigation.internal.ol.n s;
    private boolean t;
    private com.google.android.libraries.geo.mapcore.internal.model.ai u;
    private boolean v;
    private ar w;
    private ar x;
    private boolean z;
    private final com.google.android.libraries.navigation.internal.qa.a q = new com.google.android.libraries.navigation.internal.qa.a(0.0f, 0.0f, 0.0f, 0.0f);
    private volatile float r = 0.0f;
    private final com.google.android.libraries.navigation.internal.oe.x y = new com.google.android.libraries.navigation.internal.oe.x();
    private com.google.android.libraries.navigation.internal.adg.b A = com.google.android.libraries.navigation.internal.adg.b.BOTTOM_LEFT;
    private final com.google.android.libraries.navigation.internal.ol.m L = new com.google.android.libraries.navigation.internal.ol.m();
    private final com.google.android.libraries.navigation.internal.oe.ay M = new com.google.android.libraries.navigation.internal.oe.ay();
    private final com.google.android.libraries.navigation.internal.oe.ay N = new com.google.android.libraries.navigation.internal.oe.ay();
    private ab O = ab.CENTERED;
    private ab P = ab.CENTERED;

    private final float M() {
        ar arVar = this.w;
        if (arVar != null) {
            return arVar.a();
        }
        return 0.0f;
    }

    private final float N() {
        ar arVar = this.w;
        if (arVar != null) {
            return arVar.c();
        }
        return 0.0f;
    }

    private final float O() {
        ar arVar = this.x;
        if (arVar != null) {
            return arVar.a();
        }
        return 0.0f;
    }

    private final float P() {
        ar arVar = this.x;
        if (arVar != null) {
            return arVar.c();
        }
        return 0.0f;
    }

    private final void Q(com.google.android.libraries.navigation.internal.oe.x xVar) {
        this.y.W(xVar);
        this.z = true;
    }

    private final void R() {
        this.M.q(this.O.a(N(), P()), this.P.a(M(), O()));
        if (this.x != null) {
            this.N.q(this.O.b(N(), P()), this.P.b(M(), O()));
        }
    }

    private final boolean S() {
        com.google.android.libraries.geo.mapcore.internal.model.bz bzVar = this.u.s;
        if (bzVar == null) {
            return false;
        }
        return ((com.google.android.libraries.geo.mapcore.internal.model.m) bzVar).m.contains(this.A);
    }

    private final boolean T() {
        com.google.android.libraries.navigation.internal.py.a aVar = this.a;
        if (aVar != null) {
            if (aVar.c == c() && this.a.d == b()) {
                return false;
            }
        }
        float fC = c();
        float fB = b();
        ar arVar = this.w;
        this.a = new com.google.android.libraries.navigation.internal.py.a(fC, fB, arVar != null ? arVar.h : 0.0f, arVar != null ? arVar.i : 0.0f, this.A, this.u, this.H, true);
        return true;
    }

    private final boolean U() {
        ar arVar = this.w;
        if (arVar != null && !arVar.m()) {
            return false;
        }
        ar arVar2 = this.x;
        if ((arVar2 != null && !arVar2.m()) || this.a == null) {
            return false;
        }
        com.google.android.libraries.geo.mapcore.renderer.er erVar = this.D;
        if (erVar != null) {
            erVar.c();
            this.D = null;
        }
        com.google.android.libraries.navigation.internal.py.a aVar = this.a;
        com.google.android.libraries.navigation.internal.yx.ar.q(aVar);
        com.google.android.libraries.geo.mapcore.renderer.et etVarJ = new com.google.android.libraries.navigation.internal.qc.d(aVar, this.E, this.I).j();
        if (etVarJ == null) {
            return true;
        }
        this.D = etVarJ.b(0);
        return true;
    }

    final float b() {
        ab abVar = ab.SECONDARY_FIRST;
        int iOrdinal = this.P.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
                return Math.max(M(), O());
            }
            if (iOrdinal != 4) {
                ((com.google.android.libraries.navigation.internal.zb.h) p.d(com.google.android.libraries.navigation.internal.nl.a.a).F(925)).s("Unsupported secondary label vertical alignment: %s", this.P);
                return Math.max(M(), O());
            }
        }
        return M() + O();
    }

    final float c() {
        ab abVar = ab.SECONDARY_FIRST;
        int iOrdinal = this.O.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1 || iOrdinal == 2 || iOrdinal == 3) {
                return Math.max(N(), P());
            }
            if (iOrdinal != 4) {
                ((com.google.android.libraries.navigation.internal.zb.h) p.d(com.google.android.libraries.navigation.internal.nl.a.a).F(926)).s("Unsupported secondary label horizontal alignment: %s", this.O);
                return N() + P();
            }
        }
        return N() + P();
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final float d() {
        return this.r;
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final com.google.android.libraries.navigation.internal.ol.o e() {
        return this.s;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final com.google.android.libraries.navigation.internal.qa.b f() {
        com.google.android.libraries.navigation.internal.qa.b bVar = new com.google.android.libraries.navigation.internal.qa.b();
        com.google.android.libraries.navigation.internal.qa.a aVar = this.q;
        float f = aVar.a;
        float f2 = aVar.c;
        float f3 = aVar.b;
        float f4 = aVar.d;
        bVar.g((f + f2) * 0.5f, (f3 + f4) * 0.5f, 0.0d, (f2 - f) * 0.5f, (f4 - f3) * 0.5f);
        return bVar;
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.qa.b g() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final /* bridge */ /* synthetic */ com.google.android.libraries.navigation.internal.qa.b h() {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final void i(cu cuVar, com.google.android.libraries.navigation.internal.pb.t tVar) {
    }

    @Override // com.google.android.libraries.navigation.internal.px.al
    protected final void j() {
        this.u = null;
        this.v = true;
        ar arVar = this.w;
        if (arVar != null) {
            arVar.h();
            this.w = null;
        }
        ar arVar2 = this.x;
        if (arVar2 != null) {
            arVar2.h();
            this.x = null;
        }
        com.google.android.libraries.geo.mapcore.renderer.er erVar = this.D;
        if (erVar != null) {
            erVar.c();
            this.D = null;
        }
        this.t = false;
        this.a = null;
        this.s = null;
        this.r = 0.0f;
        super.j();
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final void k() {
        this.b.acquireUninterruptibly();
        try {
            if (this.v && U()) {
                this.v = false;
            }
        } finally {
            this.b.release();
        }
    }

    public final void l(com.google.android.libraries.navigation.internal.ol.l lVar) {
        this.b.acquireUninterruptibly();
        try {
            this.C = lVar;
        } finally {
            this.b.release();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final /* bridge */ /* synthetic */ void m(boolean z) {
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final /* bridge */ /* synthetic */ void n(boolean z) {
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final /* bridge */ /* synthetic */ void o(ai aiVar) {
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final /* bridge */ /* synthetic */ boolean p() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.qq.ao
    public final boolean q() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final boolean r() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final boolean s(cu cuVar, com.google.android.libraries.navigation.internal.pb.t tVar, LabelRenderer labelRenderer) {
        boolean z;
        cu cuVar2;
        com.google.android.libraries.navigation.internal.py.a aVar;
        boolean z2 = false;
        if (!this.b.tryAcquire()) {
            return false;
        }
        try {
            if (this.z && tVar.w().k >= ((b) this.c).g - 1.0f) {
                float[] fArr = cuVar.j;
                com.google.android.libraries.navigation.internal.ol.l lVar = this.C;
                if (lVar != null) {
                    lVar.a(this.L);
                    Q(this.L.a);
                    com.google.android.libraries.navigation.internal.pb.j.m(tVar, this.y, fArr);
                    com.google.android.libraries.navigation.internal.adg.b bVar = this.A;
                    com.google.android.libraries.navigation.internal.adg.b bVar2 = this.L.b;
                    if (bVar != bVar2) {
                        this.A = bVar2;
                        if (S() && (aVar = this.a) != null) {
                            aVar.c(this.A);
                        }
                        this.v = true;
                    }
                } else {
                    com.google.android.libraries.navigation.internal.pb.j.m(tVar, this.y, fArr);
                }
                if (!this.v) {
                    com.google.android.libraries.navigation.internal.ol.au auVar = this.s;
                    if (auVar != null) {
                        float f = fArr[0];
                        float f2 = fArr[1];
                        com.google.android.libraries.navigation.internal.adg.ef efVarN = ((com.google.android.libraries.navigation.internal.po.ag) auVar).n();
                        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.b);
                        efVarN.h(bhVarS);
                        Object objK = efVarN.w.k(bhVarS.d);
                        com.google.android.libraries.navigation.internal.on.f.a(f, f2, ((com.google.android.libraries.navigation.internal.adl.f) (objK == null ? bhVarS.b : bhVarS.c(objK))).c, this.A, fArr);
                    }
                    float f3 = fArr[0];
                    float f4 = fArr[1];
                    com.google.android.libraries.navigation.internal.py.a aVar2 = this.a;
                    com.google.android.libraries.navigation.internal.yx.ar.q(aVar2);
                    float f5 = this.B;
                    com.google.android.libraries.navigation.internal.oe.ay ayVar = cuVar.a;
                    com.google.android.libraries.navigation.internal.qa.a aVar3 = aVar2.k;
                    aVar2.d(f3, f4, f5, aVar2.g, aVar2.j, aVar3);
                    RectF rectF = aVar2.j;
                    float fA = aVar2.a(aVar2.a) / 2.0f;
                    aVar3.d(aVar3.a + (((rectF.left + fA) - aVar2.e) * f5), aVar3.b + (rectF.top * f5), aVar3.c - (((rectF.right + fA) - aVar2.f) * f5), aVar3.d - (rectF.bottom * f5));
                    aVar2.k = aVar3;
                    ayVar.r(aVar2.k.e);
                    aVar2.f(f3, f4, this.B, aVar2.g, aVar2.j, cuVar.b);
                    aVar2.e(f3, f4, this.q);
                    R();
                    com.google.android.libraries.navigation.internal.oe.ay ayVar2 = cuVar.a;
                    com.google.android.libraries.navigation.internal.oe.ay ayVar3 = cuVar.c;
                    com.google.android.libraries.navigation.internal.oe.ay ayVar4 = cuVar.d;
                    float f6 = ayVar2.b;
                    com.google.android.libraries.navigation.internal.oe.ay ayVar5 = this.M;
                    ayVar3.q(f6 + ayVar5.b, ayVar2.c + ayVar5.c);
                    float f7 = ayVar2.b;
                    com.google.android.libraries.navigation.internal.oe.ay ayVar6 = this.N;
                    ayVar4.q(f7 + ayVar6.b, ayVar2.c + ayVar6.c);
                    com.google.android.libraries.geo.mapcore.renderer.er erVar = this.D;
                    if (erVar != null) {
                        com.google.android.libraries.geo.mapcore.renderer.af afVar = this.e;
                        com.google.android.libraries.navigation.internal.oe.ay ayVar7 = cuVar.b;
                        float f8 = ayVar7.b;
                        float f9 = ayVar7.c;
                        float f10 = erVar.d;
                        float f11 = erVar.h;
                        float f12 = this.B;
                        float f13 = f10 * f11 * f12;
                        float f14 = erVar.e;
                        float f15 = f11 * f14 * f12;
                        float f16 = erVar.b;
                        float f17 = erVar.c;
                        float f18 = this.h;
                        com.google.android.libraries.geo.mapcore.renderer.w wVarA = labelRenderer.b.a(erVar.i, afVar);
                        if (wVarA != null) {
                            float f19 = f13 * 0.5f;
                            float f20 = f15 * 0.5f;
                            float f21 = f8 - f19;
                            float f22 = f9 + f20;
                            float f23 = f9 - f20;
                            float f24 = f8 + f19;
                            z = true;
                            labelRenderer.c(f21, f22, f21, f23, f24, f23, f24, f22, f16, f17, f10, f14, f18, wVarA);
                            labelRenderer.b.f(wVarA);
                        } else {
                            z = true;
                        }
                        ar arVar = this.w;
                        if (arVar != null) {
                            cuVar2 = cuVar;
                            com.google.android.libraries.navigation.internal.oe.ay ayVar8 = cuVar2.c;
                            arVar.u(cuVar, labelRenderer, ayVar8.b, ayVar8.c, this.B, this.h, this.e);
                        } else {
                            cuVar2 = cuVar;
                        }
                        ar arVar2 = this.x;
                        if (arVar2 != null) {
                            com.google.android.libraries.navigation.internal.oe.ay ayVar9 = cuVar2.d;
                            arVar2.u(cuVar, labelRenderer, ayVar9.b, ayVar9.c, this.B, this.h, this.e);
                        }
                        z2 = z;
                    }
                    ar arVar3 = this.w;
                    this.r = arVar3 != null ? arVar3.b() : 0.0f;
                }
            } else {
                z2 = true;
            }
            return z2;
        } finally {
            this.b.release();
        }
    }

    public final boolean t() {
        com.google.android.libraries.navigation.internal.adg.dt dtVar;
        this.b.acquireUninterruptibly();
        try {
            if (this.t) {
                return true;
            }
            com.google.android.libraries.navigation.internal.adg.dt dtVar2 = ((b) this.c).a.c;
            if (dtVar2 == null) {
                dtVar2 = com.google.android.libraries.navigation.internal.adg.dt.a;
            }
            com.google.android.libraries.navigation.internal.adg.dt dtVar3 = dtVar2;
            com.google.android.libraries.navigation.internal.adg.ef efVar = ((b) this.c).a;
            if ((efVar.b & 2) != 0) {
                dtVar = efVar.d;
                if (dtVar == null) {
                    dtVar = com.google.android.libraries.navigation.internal.adg.dt.a;
                }
            } else {
                dtVar = null;
            }
            ek ekVar = this.K;
            if (ekVar == null) {
                ekVar = this.c;
            }
            ek ekVar2 = ekVar;
            ar arVarE = ar.e(dtVar3, ekVar2, this.I, this.E, this.F, this.G, this.J, this.f);
            ar arVarE2 = ar.e(dtVar, ekVar2, this.I, this.E, this.F, this.G, this.J, this.f);
            this.t = arVarE != null && (dtVar == null || arVarE2 != null);
            ar arVar = this.w;
            if (arVar != null) {
                arVar.h();
            }
            this.w = arVarE;
            ar arVar2 = this.x;
            if (arVar2 != null) {
                arVar2.h();
            }
            this.x = arVarE2;
            this.v = true;
            if (this.t && S()) {
                T();
                if (U()) {
                    this.v = false;
                }
            }
            if (this.t) {
                this.K = null;
            }
            return this.t;
        } finally {
            this.b.release();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final boolean u(cu cuVar, com.google.android.libraries.navigation.internal.pb.t tVar) {
        boolean z = false;
        if (!t()) {
            return false;
        }
        this.b.acquireUninterruptibly();
        try {
            if (S()) {
                boolean z2 = this.z;
                float[] fArr = cuVar.j;
                if (z2) {
                    com.google.android.libraries.navigation.internal.pb.j.m(tVar, this.y, fArr);
                } else {
                    fArr[0] = 0.0f;
                    fArr[1] = 0.0f;
                }
                if (T()) {
                    this.v = true;
                }
                com.google.android.libraries.navigation.internal.py.a aVar = this.a;
                if (aVar != null) {
                    com.google.android.libraries.navigation.internal.ol.au auVar = this.s;
                    if (auVar != null) {
                        float f = fArr[0];
                        float f2 = fArr[1];
                        com.google.android.libraries.navigation.internal.adg.ef efVarN = ((com.google.android.libraries.navigation.internal.po.ag) auVar).n();
                        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adl.k.b);
                        efVarN.h(bhVarS);
                        Object objK = efVarN.w.k(bhVarS.d);
                        com.google.android.libraries.navigation.internal.on.f.a(f, f2, ((com.google.android.libraries.navigation.internal.adl.f) (objK == null ? bhVarS.b : bhVarS.c(objK))).c, this.A, fArr);
                    }
                    aVar.e(fArr[0], fArr[1], this.q);
                    R();
                }
                z = true;
            }
            return z;
        } finally {
            this.b.release();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final /* bridge */ /* synthetic */ long v(int i) {
        return 0L;
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.qq.ao
    public final int w(com.google.android.libraries.navigation.internal.qq.x xVar, boolean z, com.google.android.libraries.navigation.internal.oe.x xVar2) {
        com.google.android.libraries.navigation.internal.ol.n nVar = this.s;
        if (nVar != null && !nVar.f()) {
            return 1;
        }
        this.b.acquireUninterruptibly();
        try {
            xVar2.W(this.y);
            com.google.android.libraries.navigation.internal.qa.a aVar = this.q;
            com.google.android.libraries.navigation.internal.oe.ay ayVar = aVar.e;
            return xVar.b(ayVar.b, ayVar.c, 0.0d, aVar.b(), aVar.a()) ? 2 : 1;
        } finally {
            this.b.release();
        }
    }

    public final void x(ek ekVar, int i, float f, com.google.android.libraries.navigation.internal.qc.g gVar, com.google.android.libraries.navigation.internal.qe.b bVar, com.google.android.libraries.navigation.internal.pz.a aVar, com.google.android.libraries.navigation.internal.qz.g gVar2, com.google.android.libraries.geo.mapcore.renderer.ck ckVar, Resources resources, com.google.android.libraries.navigation.internal.adg.b bVar2, com.google.android.libraries.navigation.internal.adg.ee eeVar, com.google.android.libraries.navigation.internal.pz.d dVar, com.google.android.libraries.navigation.internal.ol.n nVar, ae aeVar) {
        com.google.android.libraries.navigation.internal.adg.b bVar3;
        ab abVar;
        ab abVar2;
        this.K = ekVar;
        b bVar4 = (b) ekVar;
        com.google.android.libraries.navigation.internal.adg.dt dtVar = bVar4.a.c;
        if (dtVar == null) {
            dtVar = com.google.android.libraries.navigation.internal.adg.dt.a;
        }
        this.u = gVar.c(dtVar, ekVar, 0);
        super.L(ekVar, i, ckVar, dVar);
        this.v = true;
        cg cgVar = bVar4.f;
        if (cgVar.h()) {
            Q(((m) cgVar).a.a);
        } else {
            this.z = false;
        }
        this.G = gVar;
        this.F = bVar;
        this.E = aVar;
        this.H = f;
        this.J = gVar2;
        if (bVar2 == null) {
            com.google.android.libraries.geo.mapcore.internal.model.ai aiVar = this.u;
            bVar3 = (com.google.android.libraries.navigation.internal.adg.b) gs.c(aiVar.p() ? fy.o(((com.google.android.libraries.geo.mapcore.internal.model.m) aiVar.s).m) : mb.a, com.google.android.libraries.navigation.internal.adg.b.BOTTOM_LEFT);
        } else {
            bVar3 = bVar2;
        }
        this.A = bVar3;
        if (eeVar != null) {
            ab abVar3 = ab.SECONDARY_FIRST;
            switch (eeVar) {
                case BOTTOM_RIGHT_TO_TOP_LEFT:
                case TOP_RIGHT_TO_TOP_LEFT:
                case CENTER_RIGHT_TO_CENTER_LEFT:
                case BOTTOM_RIGHT_TO_BOTTOM_LEFT:
                case TOP_RIGHT_TO_BOTTOM_LEFT:
                    abVar = ab.SECONDARY_FIRST;
                    break;
                case BOTTOM_RIGHT_TO_TOP_RIGHT:
                case TOP_RIGHT_TO_BOTTOM_RIGHT:
                    abVar = ab.TRAILING_EDGE_ALIGNED;
                    break;
                case BOTTOM_CENTER_TO_TOP_CENTER:
                case TOP_CENTER_TO_BOTTOM_CENTER:
                    abVar = ab.CENTERED;
                    break;
                case BOTTOM_LEFT_TO_TOP_LEFT:
                case TOP_LEFT_TO_BOTTOM_LEFT:
                    abVar = ab.LEADING_EDGE_ALIGNED;
                    break;
                case BOTTOM_LEFT_TO_TOP_RIGHT:
                case TOP_LEFT_TO_TOP_RIGHT:
                case CENTER_LEFT_TO_CENTER_RIGHT:
                case BOTTOM_LEFT_TO_BOTTOM_RIGHT:
                case TOP_LEFT_TO_BOTTOM_RIGHT:
                    abVar = ab.PRIMARY_FIRST;
                    break;
                default:
                    ((com.google.android.libraries.navigation.internal.zb.h) ab.f.d(com.google.android.libraries.navigation.internal.nl.a.a).F(923)).s("Saw TiePointPosition encountered that isn't handled. Saw %s. Defaulting to a horizontal alignment of PRIMARY_FIRST.", eeVar);
                    abVar = ab.PRIMARY_FIRST;
                    break;
            }
            this.O = abVar;
            switch (eeVar) {
                case BOTTOM_RIGHT_TO_TOP_LEFT:
                case BOTTOM_RIGHT_TO_TOP_RIGHT:
                case BOTTOM_CENTER_TO_TOP_CENTER:
                case BOTTOM_LEFT_TO_TOP_LEFT:
                case BOTTOM_LEFT_TO_TOP_RIGHT:
                    abVar2 = ab.SECONDARY_FIRST;
                    break;
                case TOP_RIGHT_TO_TOP_LEFT:
                case TOP_LEFT_TO_TOP_RIGHT:
                    abVar2 = ab.LEADING_EDGE_ALIGNED;
                    break;
                case CENTER_RIGHT_TO_CENTER_LEFT:
                case CENTER_LEFT_TO_CENTER_RIGHT:
                    abVar2 = ab.CENTERED;
                    break;
                case BOTTOM_RIGHT_TO_BOTTOM_LEFT:
                case BOTTOM_LEFT_TO_BOTTOM_RIGHT:
                    abVar2 = ab.TRAILING_EDGE_ALIGNED;
                    break;
                case TOP_RIGHT_TO_BOTTOM_LEFT:
                case TOP_RIGHT_TO_BOTTOM_RIGHT:
                case TOP_CENTER_TO_BOTTOM_CENTER:
                case TOP_LEFT_TO_BOTTOM_LEFT:
                case TOP_LEFT_TO_BOTTOM_RIGHT:
                    abVar2 = ab.PRIMARY_FIRST;
                    break;
                default:
                    ((com.google.android.libraries.navigation.internal.zb.h) ab.f.d(com.google.android.libraries.navigation.internal.nl.a.a).F(924)).s("Saw TiePointPosition encountered that isn't handled. Saw %s. Defaulting to a vertical alignment of CENTERED.", eeVar);
                    abVar2 = ab.CENTERED;
                    break;
            }
            this.P = abVar2;
        }
        this.B = 1.0f;
        this.I = resources;
        this.s = nVar;
        this.Q = aeVar;
        t();
    }

    public final void y(com.google.android.libraries.navigation.internal.oe.x xVar, com.google.android.libraries.navigation.internal.adg.b bVar) {
        com.google.android.libraries.navigation.internal.py.a aVar;
        this.b.acquireUninterruptibly();
        try {
            Q(xVar);
            this.B = 1.0f;
            if (this.A != bVar) {
                this.A = bVar;
                if (S() && (aVar = this.a) != null) {
                    aVar.c(bVar);
                }
                this.v = true;
            }
        } finally {
            this.b.release();
        }
    }
}
