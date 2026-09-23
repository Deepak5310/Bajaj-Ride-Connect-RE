package com.google.android.libraries.navigation.internal.px;

import com.google.android.libraries.geo.mapcore.renderer.LabelRenderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class at extends al {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.px.at");
    private static final double p;
    private static final double q;
    private com.google.android.libraries.geo.mapcore.internal.model.ai A;
    private com.google.android.libraries.navigation.internal.qc.e B;
    private com.google.android.libraries.navigation.internal.oe.ad C;
    private com.google.android.libraries.navigation.internal.qe.b D;
    private az E;
    private com.google.android.libraries.geo.mapcore.renderer.er F;
    private float[] G;
    private float H;
    private boolean I;
    private float J;
    private boolean K;
    private boolean t;
    private float w;
    private float x;
    private int y;
    private final com.google.android.libraries.navigation.internal.qa.b r = new com.google.android.libraries.navigation.internal.qa.b();
    private volatile float s = 0.0f;
    private final com.google.android.libraries.navigation.internal.oe.x u = new com.google.android.libraries.navigation.internal.oe.x();
    private final com.google.android.libraries.navigation.internal.oe.x v = new com.google.android.libraries.navigation.internal.oe.x();
    private int N = 2;
    private String z = "";
    private com.google.android.libraries.geo.mapcore.renderer.v L = null;
    private com.google.android.libraries.geo.mapcore.renderer.v M = null;

    static {
        double radians = Math.toRadians(60.0d);
        p = radians;
        q = Math.cos(radians);
    }

    private static float c(com.google.android.libraries.navigation.internal.pb.t tVar, com.google.android.libraries.navigation.internal.oe.ad adVar, com.google.android.libraries.navigation.internal.oe.x xVar) {
        adVar.u(adVar.e() >> 1, xVar);
        return Math.min(1.0f, com.google.android.libraries.navigation.internal.pb.j.e(tVar, xVar));
    }

    private final boolean l(cu cuVar, com.google.android.libraries.navigation.internal.pb.t tVar, float f, float f2, float f3, com.google.android.libraries.navigation.internal.pl.a aVar) {
        float f4;
        float f5;
        int iE = this.C.e();
        aVar.d();
        aVar.f(iE);
        com.google.android.libraries.navigation.internal.oe.ay ayVar = cuVar.d;
        float fA = 0.0f;
        ayVar.q(0.0f, 0.0f);
        if (f != 0.0f) {
            this.C.t(tVar.n(), ayVar);
            ayVar.p((-f) * tVar.n() * com.google.android.libraries.navigation.internal.pb.j.c(tVar));
            ayVar.p(this.f.e);
        }
        for (int i = 0; i < iE; i++) {
            com.google.android.libraries.navigation.internal.oe.x xVar = cuVar.h;
            this.C.u(i, xVar);
            if (f != 0.0f) {
                xVar.a = (int) (xVar.a + ayVar.b);
                xVar.b = (int) (xVar.b + ayVar.c);
            }
            float[] fArr = cuVar.j;
            if (!com.google.android.libraries.navigation.internal.pb.j.o(tVar, xVar, fArr)) {
                return false;
            }
            aVar.c(fArr[0], fArr[1]);
        }
        float f6 = 1.05f * f2;
        int i2 = this.N;
        int i3 = i2 - 1;
        if (i2 == 0) {
            throw null;
        }
        if (i3 == 0) {
            float f7 = this.w;
            f4 = f7;
            f5 = f7 + f6;
        } else if (i3 != 2) {
            com.google.android.libraries.navigation.internal.oe.x xVar2 = this.u;
            int i4 = this.y;
            if (tVar.w().l > 0.0f) {
                float fB = 0.0f;
                for (int i5 = 0; i5 < i4; i5++) {
                    fB += aVar.b(i5);
                }
                com.google.android.libraries.navigation.internal.oe.ay ayVar2 = cuVar.a;
                aVar.i(i4, ayVar2);
                float[] fArr2 = cuVar.j;
                if (com.google.android.libraries.navigation.internal.pb.j.o(tVar, xVar2, fArr2)) {
                    fA = fB + ((float) Math.hypot(fArr2[0] - ayVar2.b, fArr2[1] - ayVar2.c));
                } else {
                    ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(933)).y("computeLengthToAnchor (%d %d %d) had no valid screen proj.", Integer.valueOf(xVar2.a), Integer.valueOf(xVar2.b), Integer.valueOf(xVar2.c));
                }
            } else {
                fA = aVar.a() * 0.5f;
            }
            f4 = fA - (0.5f * f6);
            f5 = f4 + f6;
        } else {
            float fA2 = aVar.a() - this.w;
            f5 = fA2;
            f4 = fA2 - f6;
        }
        this.C.i(((f6 / 2.0f) + f4) / aVar.a(), this.v);
        aVar.g(cuVar.a, cuVar.b, cuVar.c, f4, f5);
        int i6 = aVar.b;
        int i7 = i6 - 1;
        if (i7 >= 2) {
            aVar.h(0, cuVar.a);
            for (int i8 = 1; i8 < i7; i8++) {
                if (aVar.b(i8) >= f3 || i8 >= i6 - 2) {
                    aVar.h(i8, cuVar.b);
                    double dC = cuVar.a.c(cuVar.b);
                    com.google.android.libraries.navigation.internal.oe.ay ayVar3 = cuVar.a;
                    com.google.android.libraries.navigation.internal.oe.ay ayVar4 = cuVar.b;
                    if (dC < q * Math.sqrt(ayVar3.c(ayVar3) * ayVar4.c(ayVar4))) {
                        return false;
                    }
                    cuVar.a.r(cuVar.b);
                }
            }
        }
        return true;
    }

    final void b(ek ekVar, int i, String str, com.google.android.libraries.geo.mapcore.internal.model.ai aiVar, float f, int i2, float f2, com.google.android.libraries.navigation.internal.oe.x xVar, int i3, com.google.android.libraries.geo.mapcore.renderer.af afVar, com.google.android.libraries.navigation.internal.pz.d dVar, com.google.android.libraries.navigation.internal.qe.b bVar, com.google.android.libraries.navigation.internal.qc.e eVar, boolean z) {
        super.L(ekVar, i, afVar, dVar);
        this.A = aiVar;
        com.google.android.libraries.navigation.internal.oe.ad adVar = ((m) ekVar.h()).b;
        com.google.android.libraries.navigation.internal.yx.ar.q(adVar);
        this.C = adVar;
        this.x = f;
        this.N = i2;
        this.z = com.google.android.libraries.navigation.internal.yx.aq.b(str);
        this.w = f2;
        this.D = bVar;
        this.u.W(xVar);
        this.y = i3;
        this.B = eVar;
        this.t = z;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final float d() {
        return this.s;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final com.google.android.libraries.navigation.internal.qa.b f() {
        return this.r;
    }

    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final void i(cu cuVar, com.google.android.libraries.navigation.internal.pb.t tVar) {
    }

    @Override // com.google.android.libraries.navigation.internal.px.al
    protected final void j() {
        this.z = "";
        this.A = null;
        this.C = null;
        this.I = false;
        this.J = -5.590387E8f;
        this.D = null;
        this.H = -5.590387E8f;
        com.google.android.libraries.geo.mapcore.renderer.er erVar = this.F;
        if (erVar != null) {
            erVar.c();
            this.F = null;
        }
        this.E = null;
        this.G = null;
        this.K = false;
        this.M = null;
        this.L = null;
        this.s = 0.0f;
        this.t = false;
        super.j();
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final void k() {
        com.google.android.libraries.geo.mapcore.renderer.et etVarJ;
        this.b.acquireUninterruptibly();
        try {
            if (this.F == null) {
                String str = this.z;
                if (str.isEmpty()) {
                    com.google.android.libraries.navigation.internal.qc.e eVar = this.B;
                    if (eVar != null && (etVarJ = eVar.j()) != null) {
                        com.google.android.libraries.geo.mapcore.renderer.er erVarB = etVarJ.b(0);
                        this.F = erVarB;
                        if (erVarB != null) {
                            this.G = new float[]{0.0f, erVarB.d};
                        }
                    }
                } else {
                    this.F = this.D.a(str, this.A, this.H);
                    this.G = this.D.d(this.z, this.A, this.H);
                }
            }
        } finally {
            this.b.release();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.px.ai
    public final boolean r() {
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00a3 A[Catch: all -> 0x0180, LOOP:1: B:31:0x009d->B:33:0x00a3, LOOP_END, TryCatch #0 {all -> 0x0180, blocks: (B:11:0x0029, B:14:0x0030, B:16:0x0048, B:40:0x00f6, B:49:0x0163, B:51:0x0171, B:53:0x0177, B:43:0x010c, B:47:0x0117, B:48:0x015f, B:17:0x0054, B:20:0x006f, B:22:0x008a, B:31:0x009d, B:33:0x00a3, B:34:0x00c2, B:36:0x00ca, B:38:0x00ce, B:39:0x00df, B:35:0x00c8), top: B:60:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x00c8 A[Catch: all -> 0x0180, TryCatch #0 {all -> 0x0180, blocks: (B:11:0x0029, B:14:0x0030, B:16:0x0048, B:40:0x00f6, B:49:0x0163, B:51:0x0171, B:53:0x0177, B:43:0x010c, B:47:0x0117, B:48:0x015f, B:17:0x0054, B:20:0x006f, B:22:0x008a, B:31:0x009d, B:33:0x00a3, B:34:0x00c2, B:36:0x00ca, B:38:0x00ce, B:39:0x00df, B:35:0x00c8), top: B:60:0x0029 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x00c2 A[EDGE_INSN: B:63:0x00c2->B:34:0x00c2 BREAK  A[LOOP:1: B:31:0x009d->B:33:0x00a3], SYNTHETIC] */
    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final boolean s(cu cuVar, com.google.android.libraries.navigation.internal.pb.t tVar, LabelRenderer labelRenderer) {
        int i;
        int i2;
        com.google.android.libraries.geo.mapcore.renderer.w wVarA;
        LabelRenderer labelRenderer2 = labelRenderer;
        boolean z = true;
        if (tVar.w().k < this.m && !A().an()) {
            return true;
        }
        if (!this.b.tryAcquire()) {
            return false;
        }
        try {
            com.google.android.libraries.geo.mapcore.renderer.er erVar = this.F;
            if (erVar == null) {
                z = false;
            } else {
                float fC = c(tVar, this.C, cuVar.h);
                com.google.android.libraries.navigation.internal.pb.o oVarA = tVar.a();
                if (oVarA.c(this.M, cuVar.a)) {
                    az azVar = this.E;
                    com.google.android.libraries.navigation.internal.oe.ay ayVar = cuVar.a;
                    com.google.android.libraries.navigation.internal.oe.ay.m(ayVar, ayVar);
                    azVar.d(ayVar);
                } else {
                    com.google.android.libraries.navigation.internal.pl.a aVar = cuVar.l;
                    if (l(cuVar, tVar, this.x, fC * this.J, fC * this.H, aVar)) {
                        com.google.android.libraries.navigation.internal.oe.ay ayVar2 = cuVar.a;
                        com.google.android.libraries.navigation.internal.oe.ay ayVar3 = cuVar.b;
                        aVar.i(0, ayVar2);
                        aVar.i(aVar.b - 1, ayVar3);
                        float f = ayVar3.b - ayVar2.b;
                        if (this.c.ae()) {
                            this.K = false;
                        } else if (this.K) {
                            if (f < 15.0f) {
                                i = 0;
                                while (true) {
                                    i2 = aVar.b;
                                    if (i < i2 / 2) {
                                        break;
                                    }
                                    int i3 = (i2 - i) - 1;
                                    float[] fArr = aVar.a;
                                    int i4 = i + i;
                                    float f2 = fArr[i4];
                                    int i5 = i4 + 1;
                                    float f3 = fArr[i5];
                                    int i6 = i3 + i3;
                                    fArr[i4] = fArr[i6];
                                    int i7 = i6 + 1;
                                    fArr[i5] = fArr[i7];
                                    fArr[i6] = f2;
                                    fArr[i7] = f3;
                                    i++;
                                }
                                aVar.e();
                                this.K = true;
                            } else {
                                this.K = false;
                            }
                        } else if (f >= -15.0f) {
                            this.K = false;
                        } else {
                            i = 0;
                            while (true) {
                                i2 = aVar.b;
                                if (i < i2 / 2) {
                                    break;
                                    break;
                                }
                                int i8 = (i2 - i) - 1;
                                float[] fArr2 = aVar.a;
                                int i9 = i + i;
                                float f4 = fArr2[i9];
                                int i10 = i9 + 1;
                                float f5 = fArr2[i10];
                                int i11 = i8 + i8;
                                fArr2[i9] = fArr2[i11];
                                int i12 = i11 + 1;
                                fArr2[i10] = fArr2[i12];
                                fArr2[i11] = f4;
                                fArr2[i12] = f5;
                                i++;
                            }
                            aVar.e();
                            this.K = true;
                        }
                        if (this.E == null) {
                            this.E = az.e(erVar.b, erVar.c, this.G, erVar.e);
                        }
                        this.E.c(aVar, this.G, erVar.h, fC, cuVar.g);
                    }
                }
                this.M = oVarA.b();
                az azVar2 = this.E;
                float f6 = this.h;
                com.google.android.libraries.geo.mapcore.renderer.af afVar = this.e;
                int iA = azVar2.a();
                if (fC > 0.0f && (wVarA = labelRenderer2.a(erVar.i, afVar, iA)) != null) {
                    int i13 = 0;
                    while (i13 < iA) {
                        ay ayVarB = azVar2.b(i13);
                        com.google.android.libraries.navigation.internal.oe.ay ayVar4 = ayVarB.g;
                        float f7 = ayVar4.b;
                        float f8 = ayVar4.c;
                        float f9 = ayVarB.e;
                        float f10 = ayVarB.f;
                        float f11 = ayVarB.c;
                        float f12 = erVar.h;
                        az azVar3 = azVar2;
                        float f13 = ayVarB.d;
                        labelRenderer.b(f7, f8, f9, f10, f11 * f12 * fC, f12 * f13 * fC, ayVarB.a, ayVarB.b, f11, f13, f6, wVarA);
                        i13++;
                        azVar2 = azVar3;
                        labelRenderer2 = labelRenderer2;
                        iA = iA;
                        erVar = erVar;
                        z = true;
                    }
                    labelRenderer2.d(wVarA);
                }
                az azVar4 = this.E;
                ay ayVarB2 = azVar4.b(azVar4.a() >> 1);
                this.s = ayVarB2 != null ? ayVarB2.g.c : 0.0f;
                z = true;
            }
            return z;
        } finally {
            this.b.release();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.px.al, com.google.android.libraries.navigation.internal.qq.ao
    public final int w(com.google.android.libraries.navigation.internal.qq.x xVar, boolean z, com.google.android.libraries.navigation.internal.oe.x xVar2) {
        if (!this.t) {
            return 1;
        }
        xVar2.W(this.v);
        return xVar.a(this.r) ? 2 : 1;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0093  */
    /* JADX WARN: Code duplicated, block: B:30:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:31:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:36:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:39:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:43:0x0134  */
    @Override // com.google.android.libraries.navigation.internal.px.ai
    public final boolean u(cu cuVar, com.google.android.libraries.navigation.internal.pb.t tVar) {
        float fC;
        com.google.android.libraries.navigation.internal.pb.o oVarA;
        float f;
        float f2;
        com.google.android.libraries.navigation.internal.pl.a aVar;
        int i;
        com.google.android.libraries.navigation.internal.oe.ay ayVar;
        float fD;
        float fA;
        int i2;
        float f3;
        float fAtan2 = 0.0f;
        if (this.I) {
            fC = c(tVar, this.C, cuVar.h);
            oVarA = tVar.a();
            if (oVarA.c(this.L, cuVar.a)) {
                com.google.android.libraries.navigation.internal.qa.b bVar = this.r;
                com.google.android.libraries.navigation.internal.oe.ay ayVar2 = cuVar.a;
                com.google.android.libraries.navigation.internal.oe.ay.m(ayVar2, ayVar2);
                bVar.c(ayVar2);
            } else {
                this.b.acquireUninterruptibly();
                try {
                    f = this.J * fC;
                    f2 = this.H * fC;
                    this.b.release();
                    aVar = cuVar.l;
                    if (l(cuVar, tVar, this.x, f, f2, aVar)) {
                        i = aVar.b;
                        ayVar = cuVar.a;
                        if (i == 2) {
                            aVar.j(0.5f, ayVar);
                            fD = f2 * 0.5f;
                            fA = aVar.a() * 0.5f;
                        } else {
                            com.google.android.libraries.navigation.internal.oe.ay ayVar3 = cuVar.b;
                            com.google.android.libraries.navigation.internal.oe.ay ayVar4 = cuVar.c;
                            com.google.android.libraries.navigation.internal.oe.ay ayVar5 = cuVar.d;
                            aVar.i(0, ayVar3);
                            aVar.i(i - 1, ayVar4);
                            aVar.i(i / 2, ayVar5);
                            com.google.android.libraries.navigation.internal.oe.ay.f(ayVar3, ayVar4, 0.5f, ayVar);
                            com.google.android.libraries.navigation.internal.oe.ay.s(ayVar4, ayVar3, ayVar4);
                            float fD2 = ayVar4.d();
                            com.google.android.libraries.navigation.internal.oe.ay.s(ayVar5, ayVar3, ayVar5);
                            com.google.android.libraries.navigation.internal.oe.ay.l(ayVar4, ayVar5.c(ayVar4) / (fD2 * fD2), ayVar4);
                            com.google.android.libraries.navigation.internal.oe.ay.s(ayVar5, ayVar4, ayVar5);
                            com.google.android.libraries.navigation.internal.oe.ay.l(ayVar5, 0.5f, ayVar5);
                            com.google.android.libraries.navigation.internal.oe.ay.j(ayVar, ayVar5, ayVar);
                            fD = (ayVar5.d() + f2) * 0.5f;
                            fA = fD2 * 0.5f;
                        }
                        float f4 = fD;
                        i2 = aVar.b;
                        if (i2 >= 2) {
                            float[] fArr = aVar.a;
                            int i3 = i2 + i2;
                            fAtan2 = (float) Math.atan2(fArr[i3 - 1] - fArr[1], fArr[i3 - 2] - fArr[0]);
                        }
                        this.r.g(ayVar.b, ayVar.c, fAtan2, fA, f4);
                    }
                } catch (Throwable th) {
                    this.b.release();
                    throw th;
                }
            }
            this.L = oVarA.b();
            return true;
        }
        float fB = com.google.android.libraries.navigation.internal.pz.b.b(this.A.q() ? ((com.google.android.libraries.geo.mapcore.internal.model.o) this.A.r).c : 0, this.f, tVar.n());
        this.I = true;
        this.b.acquireUninterruptibly();
        try {
            String str = this.z;
            if (str.isEmpty()) {
                com.google.android.libraries.navigation.internal.qc.e eVar = this.B;
                if (eVar != null) {
                    this.H = eVar.i;
                    this.J = eVar.h;
                }
            } else {
                this.H = fB;
                com.google.android.libraries.geo.mapcore.internal.model.cb cbVar = this.A.r;
                if (cbVar != null) {
                    f3 = ((com.google.android.libraries.geo.mapcore.internal.model.o) cbVar).d;
                    if (((com.google.android.libraries.geo.mapcore.internal.model.o) cbVar).b == 0) {
                        f3 = 0.0f;
                    }
                } else {
                    f3 = 2.8f;
                }
                com.google.android.libraries.navigation.internal.qe.b bVar2 = this.D;
                bVar2.b(cbVar);
                bVar2.a.setTextSize(fB);
                bVar2.c(cbVar);
                this.J = bVar2.a.measureText(str) + (f3 * bVar2.b);
            }
            float f5 = this.J;
            com.google.android.libraries.geo.mapcore.renderer.er erVar = this.F;
            if (erVar != null) {
                erVar.c();
                this.F = null;
            }
            this.b.release();
            if (f5 != 0.0f) {
                fC = c(tVar, this.C, cuVar.h);
                oVarA = tVar.a();
                if (oVarA.c(this.L, cuVar.a)) {
                    com.google.android.libraries.navigation.internal.qa.b bVar3 = this.r;
                    com.google.android.libraries.navigation.internal.oe.ay ayVar6 = cuVar.a;
                    com.google.android.libraries.navigation.internal.oe.ay.m(ayVar6, ayVar6);
                    bVar3.c(ayVar6);
                } else {
                    this.b.acquireUninterruptibly();
                    f = this.J * fC;
                    f2 = this.H * fC;
                    this.b.release();
                    aVar = cuVar.l;
                    if (l(cuVar, tVar, this.x, f, f2, aVar)) {
                        i = aVar.b;
                        ayVar = cuVar.a;
                        if (i == 2) {
                            aVar.j(0.5f, ayVar);
                            fD = f2 * 0.5f;
                            fA = aVar.a() * 0.5f;
                        } else {
                            com.google.android.libraries.navigation.internal.oe.ay ayVar7 = cuVar.b;
                            com.google.android.libraries.navigation.internal.oe.ay ayVar8 = cuVar.c;
                            com.google.android.libraries.navigation.internal.oe.ay ayVar9 = cuVar.d;
                            aVar.i(0, ayVar7);
                            aVar.i(i - 1, ayVar8);
                            aVar.i(i / 2, ayVar9);
                            com.google.android.libraries.navigation.internal.oe.ay.f(ayVar7, ayVar8, 0.5f, ayVar);
                            com.google.android.libraries.navigation.internal.oe.ay.s(ayVar8, ayVar7, ayVar8);
                            float fD3 = ayVar8.d();
                            com.google.android.libraries.navigation.internal.oe.ay.s(ayVar9, ayVar7, ayVar9);
                            com.google.android.libraries.navigation.internal.oe.ay.l(ayVar8, ayVar9.c(ayVar8) / (fD3 * fD3), ayVar8);
                            com.google.android.libraries.navigation.internal.oe.ay.s(ayVar9, ayVar8, ayVar9);
                            com.google.android.libraries.navigation.internal.oe.ay.l(ayVar9, 0.5f, ayVar9);
                            com.google.android.libraries.navigation.internal.oe.ay.j(ayVar, ayVar9, ayVar);
                            fD = (ayVar9.d() + f2) * 0.5f;
                            fA = fD3 * 0.5f;
                        }
                        float f6 = fD;
                        i2 = aVar.b;
                        if (i2 >= 2) {
                            float[] fArr2 = aVar.a;
                            int i4 = i2 + i2;
                            fAtan2 = (float) Math.atan2(fArr2[i4 - 1] - fArr2[1], fArr2[i4 - 2] - fArr2[0]);
                        }
                        this.r.g(ayVar.b, ayVar.c, fAtan2, fA, f6);
                    }
                }
                this.L = oVarA.b();
                return true;
            }
            com.google.android.libraries.navigation.internal.oe.j jVar = ((b) this.c).d;
        } catch (Throwable th2) {
            this.b.release();
            throw th2;
        }
        return false;
    }
}
