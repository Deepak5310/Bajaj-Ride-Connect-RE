package com.google.android.libraries.navigation.internal.px;

import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.renderer.LabelRenderer;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ax extends al {
    private static final com.google.android.libraries.navigation.internal.adg.el H = com.google.android.libraries.navigation.internal.adg.el.PROJECTION_SCREEN_ALIGNED;
    public static final au a = au.BELOW_CENTER;
    public static final com.google.android.libraries.navigation.internal.adg.ds p = com.google.android.libraries.navigation.internal.adg.ds.CENTER_JUSTIFY;
    public au A;
    public volatile boolean B;
    public volatile boolean C;
    public ev F;
    public ev G;
    private ar M;
    private com.google.android.libraries.geo.mapcore.internal.model.d N;
    private float Q;
    private float R;
    private com.google.android.libraries.navigation.internal.adg.el S;
    private boolean T;
    private boolean U;
    private boolean V;
    private au X;
    private au Y;
    private boolean Z;
    private double aa;
    private boolean ac;
    public ar s;
    public ar t;
    public com.google.android.libraries.geo.mapcore.internal.model.c u;
    public com.google.android.libraries.navigation.internal.ol.o v;
    public boolean w;
    public float x;
    public float y;
    public au z;
    private final Object I = new Object();
    public final Object q = new Object();
    public final com.google.android.libraries.navigation.internal.qa.b r = new com.google.android.libraries.navigation.internal.qa.b();
    private final com.google.android.libraries.navigation.internal.qa.b J = new com.google.android.libraries.navigation.internal.qa.b();
    private final com.google.android.libraries.navigation.internal.qa.b K = new com.google.android.libraries.navigation.internal.qa.b();
    private volatile float L = 0.0f;
    private final com.google.android.libraries.navigation.internal.oe.ay O = new com.google.android.libraries.navigation.internal.oe.ay();
    private final com.google.android.libraries.navigation.internal.oe.ay P = new com.google.android.libraries.navigation.internal.oe.ay();
    public float D = 1.0f;
    public float E = 1.0f;
    private float W = 0.0f;
    private final com.google.android.libraries.navigation.internal.oe.ay ab = new com.google.android.libraries.navigation.internal.oe.ay();

    private final double M(com.google.android.libraries.navigation.internal.pb.t tVar, float f, float f2, aw awVar, com.google.android.libraries.navigation.internal.oe.x xVar, float[] fArr, com.google.android.libraries.navigation.internal.oe.ay ayVar) {
        com.google.android.libraries.navigation.internal.pd.d dVarW = tVar.w();
        float f3 = dVarW.l;
        boolean z = awVar.a.c() && awVar.a.c == 2;
        if (awVar.a.c()) {
            if ((f3 > -1.0E-4f && f3 < 1.0E-4f) || z) {
                double dS = S(dVarW, awVar) - ((double) dVarW.m);
                if (Q()) {
                    dS = (((dS + 360.0d) + 90.0d) % 180.0d) - 90.0d;
                }
                double radians = Math.toRadians(dS);
                ayVar.b = (float) Math.cos(radians);
                ayVar.c = (float) Math.sin(radians);
                return radians;
            }
            com.google.android.libraries.geo.mapcore.internal.model.c cVar = awVar.a;
            float f4 = -cVar.b;
            float f5 = dVarW.k;
            double radians2 = Math.toRadians(f4);
            double dA = com.google.android.libraries.navigation.internal.oe.w.a(f5) * 100.0f;
            double dCos = Math.cos(radians2) * dA;
            double dSin = dA * Math.sin(radians2);
            com.google.android.libraries.navigation.internal.oe.x xVar2 = cVar.a;
            xVar.J(xVar2.a + ((int) dCos), xVar2.b + ((int) dSin));
            if (com.google.android.libraries.navigation.internal.pb.j.m(tVar, xVar, fArr)) {
                float f6 = fArr[0] - f;
                ayVar.b = f6;
                ayVar.c = fArr[1] - f2;
                if (f6 < 0.0f && Q()) {
                    ayVar.b = -ayVar.b;
                    ayVar.c = -ayVar.c;
                }
                com.google.android.libraries.navigation.internal.oe.ay.n(ayVar, ayVar);
                return Math.atan2(ayVar.c, ayVar.b);
            }
        }
        ayVar.b = 1.0f;
        ayVar.c = 0.0f;
        return 0.0d;
    }

    private final void N(float f) {
        if (this.W == f && this.X == this.z && this.Y == this.A) {
            return;
        }
        this.W = f;
        this.X = this.z;
        this.Y = this.A;
        int iC = (int) (this.M.c() * f);
        int iA = (int) (this.M.a() * f);
        this.r.g(0.0f, 0.0f, 0.0d, iC / 2.0f, iA / 2.0f);
        ar arVar = this.s;
        if (arVar != null) {
            float fC = arVar.c() * f;
            float fA = this.s.a() * f;
            P((int) fC, (int) fA, iC, iA, (int) (this.Q * f), this.z, this.s.d, this.J);
        }
        ar arVar2 = this.t;
        if (arVar2 != null) {
            float fC2 = arVar2.c() * f;
            float fA2 = this.t.a() * f;
            P((int) fC2, (int) fA2, iC, iA, (int) (this.R * f), this.A, this.t.d, this.K);
        }
        synchronized (this.I) {
            if (this.s != null) {
                com.google.android.libraries.navigation.internal.oe.ay ayVar = this.O;
                com.google.android.libraries.navigation.internal.oe.ay ayVar2 = this.J.a;
                ayVar.q(ayVar2.b / f, ayVar2.c / f);
            }
            if (this.t != null) {
                com.google.android.libraries.navigation.internal.oe.ay ayVar3 = this.P;
                com.google.android.libraries.navigation.internal.oe.ay ayVar4 = this.K.a;
                ayVar3.q(ayVar4.b / f, ayVar4.c / f);
            }
        }
    }

    private final void O(float f, float f2, float f3, float f4, float f5, com.google.android.libraries.navigation.internal.oe.ay ayVar, com.google.android.libraries.navigation.internal.oe.ay ayVar2) {
        float fA = this.N.a() * f5;
        float fB = this.N.b() * f5;
        float f6 = ((fA * f) / 2.0f) + (f3 * f5);
        float f7 = ayVar.b;
        float f8 = ayVar.c;
        float f9 = ((fB * f2) / 2.0f) + (f4 * f5);
        ayVar2.q((f6 * f7) + (f9 * (-f8)), (f6 * f8) + (f7 * f9));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void P(int i, int i2, int i3, int i4, int i5, au auVar, com.google.android.libraries.navigation.internal.adg.ds dsVar, com.google.android.libraries.navigation.internal.qa.b bVar) {
        int i6;
        int i7;
        int i8;
        com.google.android.libraries.navigation.internal.yx.ar.q(auVar);
        int i9 = (i4 + i2) / 2;
        int i10 = (i3 + i) / 2;
        int i11 = 0;
        switch (auVar.ordinal()) {
            case 0:
            default:
                i6 = 0;
                break;
            case 1:
                i7 = -i9;
                i6 = i7 - i5;
                break;
            case 2:
                i6 = 0;
                i11 = i10 + i5;
                break;
            case 3:
                i6 = i9 + i5;
                break;
            case 4:
                i8 = (-i10) - i5;
                int i12 = i11;
                i11 = i8;
                i6 = i12;
                break;
            case 5:
                i11 = i9 + i5;
                i8 = i10 + i5;
                int i13 = i11;
                i11 = i8;
                i6 = i13;
                break;
            case 6:
                i11 = i9 + i5;
                i8 = (-i10) - i5;
                int i14 = i11;
                i11 = i8;
                i6 = i14;
                break;
            case 7:
                i11 = i10 + i5;
                i7 = -i9;
                i6 = i7 - i5;
                break;
            case 8:
                i7 = -i9;
                i11 = (-i10) - i5;
                i6 = i7 - i5;
                break;
        }
        if (auVar == au.BELOW_CENTER || auVar == au.ABOVE_CENTER) {
            int iOrdinal = dsVar.ordinal();
            if (iOrdinal == 1) {
                i11 = ((i - i3) / 2) - 10;
            } else if (iOrdinal == 2) {
                i11 = ((i3 - i) / 2) + 10;
            }
        }
        bVar.g(i11, i6, 0.0d, i / 2.0f, i2 / 2.0f);
    }

    private final boolean Q() {
        if (this.U) {
            return false;
        }
        return this.M.d == com.google.android.libraries.navigation.internal.adg.ds.CENTER_JUSTIFY && (this.s == null || (this.z == au.AT_CENTER && this.s.d == com.google.android.libraries.navigation.internal.adg.ds.CENTER_JUSTIFY)) && (this.t == null || (this.A == au.AT_CENTER && this.t.d == com.google.android.libraries.navigation.internal.adg.ds.CENTER_JUSTIFY));
    }

    private final boolean R() {
        ar arVar = this.M;
        if ((arVar.e.size() != 1 || arVar.j != 2) && this.S != com.google.android.libraries.navigation.internal.adg.el.PROJECTION_WORLD_ALIGNED) {
            return false;
        }
        ar arVar2 = this.s;
        if (arVar2 != null && !arVar2.o()) {
            return false;
        }
        ar arVar3 = this.t;
        return arVar3 == null || arVar3.o();
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0022  */
    private static final double S(com.google.android.libraries.navigation.internal.pd.d dVar, aw awVar) {
        float f;
        if (awVar.a.c()) {
            com.google.android.libraries.geo.mapcore.internal.model.c cVar = awVar.a;
            int i = cVar.c;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            if (i2 == 0) {
                f = cVar.b;
            } else if (i2 != 1) {
                f = dVar.m;
            } else {
                f = dVar.m + cVar.b;
            }
        } else {
            f = dVar.m;
        }
        return f;
    }

    static au b(com.google.android.libraries.navigation.internal.adg.ee eeVar) {
        com.google.android.libraries.geo.mapcore.internal.model.d[] dVarArr = com.google.android.libraries.geo.mapcore.internal.model.d.a;
        char c = '\t';
        switch (eeVar) {
            case BOTTOM_RIGHT_TO_TOP_LEFT:
                c = '\n';
                break;
            case BOTTOM_RIGHT_TO_TOP_RIGHT:
            case BOTTOM_CENTER_TO_TOP_CENTER:
            case BOTTOM_LEFT_TO_TOP_LEFT:
                break;
            case BOTTOM_LEFT_TO_TOP_RIGHT:
                c = 11;
                break;
            case TOP_RIGHT_TO_TOP_LEFT:
            case CENTER_RIGHT_TO_CENTER_LEFT:
            case BOTTOM_RIGHT_TO_BOTTOM_LEFT:
                c = 6;
                break;
            case TOP_LEFT_TO_TOP_RIGHT:
            case CENTER_LEFT_TO_CENTER_RIGHT:
            case BOTTOM_LEFT_TO_BOTTOM_RIGHT:
                c = 7;
                break;
            case TOP_RIGHT_TO_BOTTOM_LEFT:
                c = 14;
                break;
            case TOP_RIGHT_TO_BOTTOM_RIGHT:
            case TOP_CENTER_TO_BOTTOM_CENTER:
            case TOP_LEFT_TO_BOTTOM_LEFT:
            default:
                c = '\r';
                break;
            case TOP_LEFT_TO_BOTTOM_RIGHT:
                c = 15;
                break;
        }
        com.google.android.libraries.geo.mapcore.internal.model.d dVar = com.google.android.libraries.geo.mapcore.internal.model.d.a[c];
        if (dVar == null) {
            return a;
        }
        switch (dVar.c) {
            case 5:
                return au.AT_CENTER;
            case 6:
                return au.LEFT_OF_CENTER;
            case 7:
                return au.RIGHT_OF_CENTER;
            case 8:
            case 12:
            default:
                throw new IllegalArgumentException("Unknown position");
            case 9:
                return au.ABOVE_CENTER;
            case 10:
                return au.TOP_LEFT;
            case 11:
                return au.TOP_RIGHT;
            case 13:
                return au.BELOW_CENTER;
            case 14:
                return au.BOTTOM_LEFT;
            case 15:
                return au.BOTTOM_RIGHT;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final boolean H() {
        return (g() == null || this.B) ? false : true;
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final boolean I() {
        return (h() == null || this.C) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0082  */
    /* JADX WARN: Code duplicated, block: B:21:0x0088  */
    public final void c(ek ekVar, com.google.android.libraries.geo.mapcore.internal.model.ai aiVar, int i, com.google.android.libraries.geo.mapcore.internal.model.c cVar, ar arVar, com.google.android.libraries.geo.mapcore.internal.model.d dVar, ar arVar2, ar arVar3, au auVar, au auVar2, boolean z, boolean z2, com.google.android.libraries.geo.mapcore.renderer.af afVar, com.google.android.libraries.navigation.internal.pz.d dVar2, com.google.android.libraries.navigation.internal.ol.o oVar, ev evVar, ev evVar2, boolean z3) {
        com.google.android.libraries.navigation.internal.adl.as asVarR;
        super.L(ekVar, i, afVar, dVar2);
        this.u = cVar;
        this.M = arVar;
        this.N = dVar;
        this.s = arVar2;
        this.t = arVar3;
        this.z = auVar;
        this.A = auVar2;
        this.T = z;
        this.U = ekVar.ae();
        this.V = z2;
        this.v = oVar;
        this.F = evVar;
        this.G = evVar2;
        this.Z = z3;
        this.B = arVar2 != null;
        this.C = arVar3 != null;
        this.w = false;
        this.D = 1.0f;
        this.E = 1.0f;
        if (aiVar != null) {
            this.x = aiVar.C;
            this.y = aiVar.D;
            this.Q = aiVar.E;
            if (aiVar.o()) {
                this.S = aiVar.z;
            }
            asVarR = ekVar.r();
            if (asVarR != null) {
                this.R = asVarR.d;
            } else {
                this.R = 0.0f;
            }
        }
        this.x = 0.0f;
        this.y = 0.0f;
        this.Q = 0.0f;
        this.S = H;
        asVarR = ekVar.r();
        if (asVarR != null) {
            this.R = asVarR.d;
        } else {
            this.R = 0.0f;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final float d() {
        return this.L;
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final com.google.android.libraries.navigation.internal.ol.o e() {
        return this.v;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final com.google.android.libraries.navigation.internal.qa.b f() {
        return this.r;
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final com.google.android.libraries.navigation.internal.qa.b g() {
        if (this.s != null) {
            return this.J;
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final com.google.android.libraries.navigation.internal.qa.b h() {
        if (this.t != null) {
            return this.K;
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final void i(cu cuVar, com.google.android.libraries.navigation.internal.pb.t tVar) {
        float f = tVar.w().k;
        this.ac = true;
        if (f >= this.m || this.c.an()) {
            aw awVar = cuVar.m;
            awVar.a(this);
            ap apVarD = this.M.d();
            float[] fArr = cuVar.j;
            float f2 = awVar.e;
            float f3 = awVar.f;
            if (!com.google.android.libraries.navigation.internal.pb.j.m(tVar, awVar.a.a, fArr)) {
                this.ac = false;
                return;
            }
            float f4 = fArr[0];
            float f5 = fArr[1];
            if (R()) {
                this.aa = Math.toRadians(S(tVar.w(), awVar));
                this.M.k(f4, f5);
                return;
            }
            float fE = awVar.b * com.google.android.libraries.navigation.internal.pb.j.e(tVar, awVar.a.a);
            com.google.android.libraries.navigation.internal.oe.ay ayVar = cuVar.c;
            this.aa = M(tVar, f4, f5, awVar, cuVar.h, fArr, this.ab);
            O(apVarD.j, apVarD.k, f2, f3, fE, this.ab, ayVar);
            float f6 = f4 + ayVar.b;
            float f7 = f5 + ayVar.c;
            this.M.k(f6, f7);
            synchronized (this.I) {
                if (this.s != null && this.B) {
                    com.google.android.libraries.navigation.internal.oe.ay ayVar2 = cuVar.d;
                    com.google.android.libraries.navigation.internal.oe.ay.g(this.O, this.ab, ayVar2);
                    ayVar2.p(fE);
                    float f8 = ayVar2.b;
                    float f9 = ayVar2.c;
                    ar arVar = this.s;
                    com.google.android.libraries.navigation.internal.yx.ar.q(arVar);
                    arVar.k(f8 + f6, f9 + f7);
                }
                if (this.t != null && this.C) {
                    com.google.android.libraries.navigation.internal.oe.ay ayVar3 = cuVar.e;
                    com.google.android.libraries.navigation.internal.oe.ay.g(this.P, this.ab, ayVar3);
                    ayVar3.p(fE);
                    float f10 = ayVar3.b;
                    float f11 = ayVar3.c;
                    ar arVar2 = this.t;
                    com.google.android.libraries.navigation.internal.yx.ar.q(arVar2);
                    arVar2.k(f6 + f10, f7 + f11);
                }
            }
            this.L = this.M.b();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.al
    protected final void j() {
        this.M.h();
        ar arVar = this.s;
        if (arVar != null) {
            arVar.h();
        }
        ar arVar2 = this.t;
        if (arVar2 != null) {
            arVar2.h();
        }
        int i = ev.d;
        this.F = lv.a;
        this.G = lv.a;
        this.z = null;
        this.T = false;
        this.B = false;
        this.C = false;
        this.w = false;
        this.L = 0.0f;
        this.D = 1.0f;
        this.W = 0.0f;
        this.X = null;
        this.Y = null;
        this.E = 1.0f;
        super.j();
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final void k() {
        if (this.M.m()) {
            if ((this.s == null || !this.B || this.s.m()) && this.t != null && this.C) {
                this.t.m();
            }
        }
    }

    final void l(com.google.android.libraries.navigation.internal.adg.ds dsVar) {
        ar arVar = this.s;
        if (arVar != null) {
            arVar.j(dsVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final void m(boolean z) {
        this.B = z;
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final void n(boolean z) {
        this.C = z;
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final void o(ai aiVar) {
        ar arVar;
        ar arVar2;
        if (aiVar instanceof ax) {
            ax axVar = (ax) aiVar;
            this.M.g(axVar.M, this.g);
            ar arVar3 = this.s;
            if (arVar3 != null && (arVar2 = axVar.s) != null) {
                arVar3.g(arVar2, this.g);
            }
            ar arVar4 = this.t;
            if (arVar4 == null || (arVar = axVar.t) == null) {
                return;
            }
            arVar4.g(arVar, this.g);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final boolean p() {
        if (this.M.f) {
            return true;
        }
        ar arVar = this.s;
        if (arVar != null && arVar.f) {
            return true;
        }
        ar arVar2 = this.t;
        return arVar2 != null && arVar2.f;
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final boolean r() {
        return this.T;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0092, code lost:
    
        if (r1.q(r23, r25, r4, r8, r7, r17, r22.e, r24) != false) goto L56;
     */
    @Override // com.google.android.libraries.navigation.internal.px.ai
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean s(cu cuVar, com.google.android.libraries.navigation.internal.pb.t tVar, LabelRenderer labelRenderer) {
        boolean zAp;
        boolean z;
        aw awVar;
        if (tVar.w().k >= this.m) {
            zAp = false;
            z = false;
        } else {
            if (!this.c.an()) {
                return true;
            }
            zAp = this.c.ap();
            z = true;
        }
        aw awVar2 = cuVar.m;
        awVar2.a(this);
        ap apVarD = this.M.d();
        float f = this.h * awVar2.c;
        float f2 = awVar2.e;
        float f3 = awVar2.f;
        if (this.ac) {
            if (R()) {
                float f4 = awVar2.b;
                com.google.android.libraries.navigation.internal.oe.ay ayVar = cuVar.a;
                ayVar.q((((1.0f - this.N.a()) * 0.5f) * apVarD.j) - f2, (((1.0f - this.N.b()) * 0.5f) * apVarD.k) - f3);
                double radians = Math.toRadians(S(tVar.w(), awVar2));
                ar arVar = this.M;
                if (true == this.V) {
                    f = 0.0f;
                }
            } else {
                float fE = awVar2.b * com.google.android.libraries.navigation.internal.pb.j.e(tVar, awVar2.a.a);
                long j = awVar2.h - awVar2.g;
                if (this.Z) {
                    this.M.v(cuVar, labelRenderer, this.aa, fE, this.ab, true != this.V ? f : 0.0f, this.e, awVar2.i, j);
                } else {
                    this.M.t(cuVar, labelRenderer, this.aa, fE, this.ab, true != this.V ? f : 0.0f, this.e);
                }
                if (this.s == null || !this.B || zAp) {
                    awVar = awVar2;
                } else {
                    ar arVar2 = this.s;
                    if (this.Z) {
                        awVar = awVar2;
                        arVar2.v(cuVar, labelRenderer, this.aa, fE, this.ab, f, this.e, awVar.i, j);
                    } else {
                        awVar = awVar2;
                        arVar2.t(cuVar, labelRenderer, this.aa, fE, this.ab, f, this.e);
                    }
                }
                if (this.t != null && this.C && !z) {
                    ar arVar3 = this.t;
                    if (this.Z) {
                        arVar3.v(cuVar, labelRenderer, this.aa, fE, this.ab, f, this.e, awVar.i, j);
                    } else {
                        arVar3.t(cuVar, labelRenderer, this.aa, fE, this.ab, f, this.e);
                    }
                }
            }
            this.L = this.M.b();
            return true;
        }
        return !awVar2.d;
    }

    final void t(com.google.android.libraries.navigation.internal.adg.ds dsVar) {
        ar arVar = this.t;
        if (arVar != null) {
            arVar.j(dsVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final boolean u(cu cuVar, com.google.android.libraries.navigation.internal.pb.t tVar) {
        float f;
        cuVar.m.a(this);
        N(cuVar.m.b);
        aw awVar = cuVar.m;
        com.google.android.libraries.navigation.internal.oe.x xVar = awVar.a.a;
        float[] fArr = cuVar.j;
        float f2 = awVar.e;
        float f3 = awVar.f;
        float fE = awVar.b;
        if (!com.google.android.libraries.navigation.internal.pb.j.m(tVar, xVar, fArr)) {
            return false;
        }
        com.google.android.libraries.navigation.internal.oe.ay ayVar = cuVar.a;
        com.google.android.libraries.navigation.internal.oe.ay ayVar2 = cuVar.b;
        com.google.android.libraries.navigation.internal.oe.ay ayVar3 = cuVar.c;
        com.google.android.libraries.navigation.internal.oe.ay ayVar4 = cuVar.d;
        com.google.android.libraries.navigation.internal.oe.ay ayVar5 = cuVar.e;
        ayVar.q(fArr[0], fArr[1]);
        if (!tVar.a().i) {
            fE *= com.google.android.libraries.navigation.internal.pb.j.e(tVar, xVar);
            N(fE);
        }
        float f4 = fE;
        if (awVar.a.c()) {
            double dM = M(tVar, ayVar.b, ayVar.c, awVar, cuVar.h, fArr, ayVar3);
            O(this.M.c(), this.M.a(), f2, f3, f4, ayVar3, ayVar2);
            com.google.android.libraries.navigation.internal.oe.ay.j(ayVar, ayVar2, ayVar);
            com.google.android.libraries.navigation.internal.qa.b bVar = this.r;
            bVar.g(ayVar.b, ayVar.c, dM, bVar.b(), this.r.a());
            if (this.s != null) {
                com.google.android.libraries.navigation.internal.oe.ay.g(this.O, ayVar3, ayVar4);
                f = f4;
                ayVar4.p(f);
                com.google.android.libraries.navigation.internal.oe.ay.j(ayVar4, ayVar, ayVar4);
                com.google.android.libraries.navigation.internal.qa.b bVar2 = this.J;
                bVar2.g(ayVar4.b, ayVar4.c, dM, bVar2.b(), this.J.a());
            } else {
                f = f4;
            }
            if (this.t != null) {
                com.google.android.libraries.navigation.internal.oe.ay.g(this.P, ayVar3, ayVar5);
                ayVar5.p(f);
                com.google.android.libraries.navigation.internal.oe.ay.j(ayVar5, ayVar, ayVar5);
                com.google.android.libraries.navigation.internal.qa.b bVar3 = this.K;
                bVar3.g(ayVar5.b, ayVar5.c, dM, bVar3.b(), this.K.a());
                return true;
            }
        } else {
            float fC = this.M.c();
            float fA = this.M.a();
            float fA2 = this.N.a();
            float f5 = ((fA2 * f4) * fC) / 2.0f;
            ayVar2.q(f5 + (f2 * f4), (((this.N.b() * f4) * fA) / 2.0f) + (f3 * f4));
            com.google.android.libraries.navigation.internal.oe.ay.s(ayVar, this.r.a, ayVar);
            com.google.android.libraries.navigation.internal.oe.ay.j(ayVar, ayVar2, ayVar);
            this.r.c(ayVar);
            if (this.s != null) {
                this.J.c(ayVar);
            }
            if (this.t != null) {
                this.K.c(ayVar);
                return true;
            }
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final long v(int i) {
        ar arVar = this.M;
        long jR = arVar != null ? arVar.r(i) : 0L;
        ar arVar2 = this.s;
        return Math.max(jR, arVar2 != null ? arVar2.r(i) : 0L);
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.qq.ao
    public final int w(com.google.android.libraries.navigation.internal.qq.x xVar, boolean z, com.google.android.libraries.navigation.internal.oe.x xVar2) {
        com.google.android.libraries.navigation.internal.ol.o oVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("intersects");
        try {
            int i = 1;
            if (this.T && (!this.c.ai() || (oVar = this.v) == null || oVar.f())) {
                synchronized (this.q) {
                    xVar2.W(this.u.a);
                }
                if (this.M.n(xVar)) {
                    i = 2;
                } else if (this.s != null && this.B && z && this.s.l(xVar)) {
                    i = 3;
                } else if (this.t != null && this.C && this.t.l(xVar)) {
                    i = 4;
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            return i;
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    final void x(com.google.android.libraries.navigation.internal.ol.bd bdVar, boolean z) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("setTransformations");
        try {
            synchronized (this.q) {
                if (z) {
                    this.w = true;
                }
                if ((bdVar.b & 1) != 0) {
                    com.google.android.libraries.navigation.internal.oe.x xVar = this.u.a;
                    com.google.android.libraries.navigation.internal.acc.d dVar = bdVar.c;
                    if (dVar == null) {
                        dVar = com.google.android.libraries.navigation.internal.acc.d.a;
                    }
                    double d = dVar.d;
                    com.google.android.libraries.navigation.internal.acc.d dVar2 = bdVar.c;
                    if (dVar2 == null) {
                        dVar2 = com.google.android.libraries.navigation.internal.acc.d.a;
                    }
                    xVar.L(d, dVar2.c);
                }
                int i = bdVar.b;
                if ((i & 2) != 0) {
                    this.D = bdVar.d;
                }
                if ((i & 4) != 0) {
                    this.E = bdVar.e;
                }
                if ((i & 16) != 0) {
                    this.x = com.google.android.libraries.geo.mapcore.internal.model.ay.a(bdVar.g);
                }
                if ((i & 32) != 0) {
                    this.y = com.google.android.libraries.geo.mapcore.internal.model.ay.a(bdVar.h);
                }
                if ((i & 8) != 0) {
                    com.google.android.libraries.navigation.internal.ol.bc bcVar = bdVar.f;
                    if (bcVar == null) {
                        bcVar = com.google.android.libraries.navigation.internal.ol.bc.a;
                    }
                    int iA = com.google.android.libraries.navigation.internal.ol.bb.a(bcVar.d);
                    if (iA == 0) {
                        iA = com.google.android.libraries.navigation.internal.ol.bb.a;
                    }
                    if (iA != com.google.android.libraries.navigation.internal.ol.bb.a) {
                        com.google.android.libraries.geo.mapcore.internal.model.c cVar = this.u;
                        com.google.android.libraries.navigation.internal.ol.bc bcVar2 = bdVar.f;
                        if (bcVar2 == null) {
                            bcVar2 = com.google.android.libraries.navigation.internal.ol.bc.a;
                        }
                        float f = bcVar2.c;
                        com.google.android.libraries.navigation.internal.ol.bc bcVar3 = bdVar.f;
                        if (bcVar3 == null) {
                            bcVar3 = com.google.android.libraries.navigation.internal.ol.bc.a;
                        }
                        int iA2 = com.google.android.libraries.navigation.internal.ol.bb.a(bcVar3.d);
                        if (iA2 == 0) {
                            iA2 = com.google.android.libraries.navigation.internal.ol.bb.a;
                        }
                        int i2 = iA2 - 1;
                        if (iA2 == 0) {
                            throw null;
                        }
                        cVar.c = i2 != 1 ? 2 : 1;
                        cVar.b = f;
                    }
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    final boolean y(bi biVar) {
        return this.M.s(biVar);
    }
}
