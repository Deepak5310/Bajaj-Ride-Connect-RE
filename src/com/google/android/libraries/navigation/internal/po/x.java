package com.google.android.libraries.navigation.internal.po;

import android.graphics.Bitmap;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.no;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class x extends b implements com.google.android.libraries.navigation.internal.pp.d, com.google.android.libraries.navigation.internal.ol.g {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static int f528n;
    private int A;
    private boolean B;
    private final com.google.android.libraries.navigation.internal.kl.b C;
    private final List D;
    final com.google.android.libraries.geo.mapcore.renderer.ax c;
    final com.google.android.libraries.navigation.internal.pb.t d;
    final hi e;
    protected final com.google.android.libraries.navigation.internal.qq.o f;
    protected final v g;
    protected final ay h;
    protected final com.google.android.libraries.navigation.internal.oe.x i;
    public final com.google.android.libraries.navigation.internal.ol.a j;
    public boolean k;
    public com.google.android.libraries.navigation.internal.ol.aq l;
    final gr m;
    private final int o;
    private final com.google.android.libraries.navigation.internal.qq.u p;
    private final com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.aj q;
    private final com.google.android.libraries.geo.mapcore.renderer.ex r;
    private final com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.ae s;
    private final com.google.android.libraries.navigation.internal.adg.aq t;
    private final com.google.android.libraries.geo.mapcore.internal.model.bt u;
    private float v;
    private boolean w;
    private final com.google.android.libraries.navigation.internal.yx.br x;
    private final com.google.android.libraries.navigation.internal.yx.br y;
    private boolean z;

    public x(com.google.android.libraries.navigation.internal.adg.aq aqVar, com.google.android.libraries.navigation.internal.oe.k kVar, com.google.android.libraries.navigation.internal.pp.h hVar, com.google.android.libraries.geo.mapcore.internal.model.ce ceVar, com.google.android.libraries.navigation.internal.ol.aq aqVar2, hi hiVar, w wVar, com.google.android.libraries.geo.mapcore.renderer.ax axVar, com.google.android.libraries.navigation.internal.pb.t tVar, gr grVar, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.navigation.internal.ol.a aVar) throws Throwable {
        com.google.android.libraries.navigation.internal.oe.x xVar;
        com.google.android.libraries.geo.mapcore.internal.model.g gVar;
        boolean z;
        int[] iArr;
        com.google.android.libraries.geo.mapcore.internal.model.g gVar2;
        v vVar;
        float[] fArr;
        int i;
        float fA;
        float f;
        int i2;
        int length;
        int iMin;
        int iMax;
        super(grVar);
        this.q = new com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.aj();
        com.google.android.libraries.navigation.internal.oe.x xVar2 = new com.google.android.libraries.navigation.internal.oe.x(0, 0);
        this.i = xVar2;
        this.v = 1.0f;
        this.w = true;
        this.k = true;
        com.google.android.libraries.navigation.internal.yx.br brVarA = com.google.android.libraries.navigation.internal.yx.bw.a(new com.google.android.libraries.navigation.internal.yx.br() { // from class: com.google.android.libraries.navigation.internal.po.o
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            }
        });
        this.x = brVarA;
        this.z = false;
        this.A = -1;
        this.B = false;
        this.D = new ArrayList();
        this.j = aVar;
        this.t = aqVar;
        this.c = axVar;
        this.C = axVar.s;
        this.m = grVar;
        this.d = tVar;
        this.e = hiVar;
        this.l = aqVar2;
        this.r = new com.google.android.libraries.geo.mapcore.renderer.ex();
        this.y = com.google.android.libraries.navigation.internal.yx.bw.a(new r(brVarA));
        int i3 = f528n;
        this.o = i3;
        f528n = i3 + 2;
        try {
            com.google.android.libraries.geo.mapcore.internal.model.g gVarD = com.google.android.libraries.geo.mapcore.internal.model.g.d(aqVar, kVar, hVar, ceVar, true);
            v vVarB = wVar.b(this, gVarD);
            this.g = vVarB;
            vVarB.a = gVarD.l;
            com.google.android.libraries.geo.mapcore.internal.model.cj cjVar = gVarD.g;
            com.google.android.libraries.navigation.internal.yx.ar.k(cjVar.d.length > 0 || cjVar.c.length > 0);
            com.google.android.libraries.geo.mapcore.internal.model.bt btVar = gVarD.h;
            this.u = btVar;
            com.google.android.libraries.geo.mapcore.internal.model.bt btVarC = c(aqVar2, hiVar, btVar);
            F(btVarC);
            if (!aqVar.e || btVarC == null) {
                this.h = null;
            } else {
                this.h = e(this, wVar, hVar, kVar, gVarD, aqVar, aqVar2);
            }
            int[] iArr2 = gVarD.g.c;
            int length2 = iArr2.length;
            if (length2 == 0) {
                xVar = new com.google.android.libraries.navigation.internal.oe.x(0, 0);
            } else if (length2 == 2) {
                xVar = new com.google.android.libraries.navigation.internal.oe.x(iArr2[0], iArr2[1]);
            } else {
                int i4 = length2 >> 1;
                int i5 = (length2 >> 2) + 2;
                com.google.android.libraries.navigation.internal.agg.dt dtVar = com.google.android.libraries.navigation.internal.agg.dy.b;
                com.google.android.libraries.navigation.internal.agg.dz dzVar = new com.google.android.libraries.navigation.internal.agg.dz(i5, dtVar);
                com.google.android.libraries.navigation.internal.agg.dz dzVar2 = new com.google.android.libraries.navigation.internal.agg.dz(i5);
                com.google.android.libraries.navigation.internal.agg.dz dzVar3 = new com.google.android.libraries.navigation.internal.agg.dz(i5, dtVar);
                com.google.android.libraries.navigation.internal.agg.dz dzVar4 = new com.google.android.libraries.navigation.internal.agg.dz(i5);
                for (int i6 = 0; i6 < i4; i6++) {
                    int i7 = i6 + i6;
                    int i8 = iArr2[i7];
                    int i9 = iArr2[i7 + 1];
                    if (com.google.android.libraries.navigation.internal.agc.f.a(dzVar) || i8 < dzVar.b()) {
                        dzVar.c(i8);
                    } else {
                        dzVar2.c(i8);
                    }
                    if (com.google.android.libraries.navigation.internal.agc.f.a(dzVar3) || i9 < dzVar3.b()) {
                        dzVar3.c(i9);
                    } else {
                        dzVar4.c(i9);
                    }
                    int i10 = dzVar.b;
                    int i11 = dzVar2.b;
                    if (i10 > i11 + 1) {
                        dzVar2.c(dzVar.a());
                    } else if (i11 > i10 + 1) {
                        dzVar.c(dzVar2.a());
                    }
                    int i12 = dzVar3.b;
                    int i13 = dzVar4.b;
                    if (i12 > i13 + 1) {
                        dzVar4.c(dzVar3.a());
                    } else if (i13 > i12 + 1) {
                        dzVar3.c(dzVar4.a());
                    }
                }
                int iB = dzVar2.b();
                int iB2 = dzVar4.b();
                iB = dzVar.b > dzVar2.b ? dzVar.b() : iB;
                iB2 = dzVar3.b > dzVar4.b ? dzVar3.b() : iB2;
                xVar = new com.google.android.libraries.navigation.internal.oe.x(dzVar.b == dzVar2.b ? (iB + dzVar.b()) / 2 : iB, dzVar3.b == dzVar4.b ? (iB2 + dzVar3.b()) / 2 : iB2);
            }
            xVar2.W(xVar);
            com.google.android.libraries.navigation.internal.oe.x xVar3 = this.i;
            v vVar2 = this.g;
            boolean z2 = gVarD.l;
            com.google.android.libraries.geo.mapcore.internal.model.cj cjVar2 = gVarD.g;
            int iD = cjVar2.d();
            int[] iArr3 = cjVar2.f;
            if (iD == 0 || (iArr3 != null && iArr3.length < 2)) {
                gVar = gVarD;
            } else {
                int[] iArr4 = cjVar2.c;
                int length3 = iArr4.length;
                if (length3 > 0) {
                    float[] fArr2 = cjVar2.e;
                    if (fArr2 != null && fArr2.length >= length3) {
                        iArr = iArr3;
                        gVar2 = gVarD;
                        fArr = fArr2;
                        vVar = vVar2;
                        z = z2;
                    } else if ((length3 & 1) != 0) {
                        fArr2 = new float[0];
                        iArr = iArr3;
                        gVar2 = gVarD;
                        fArr = fArr2;
                        vVar = vVar2;
                        z = z2;
                    } else {
                        com.google.android.libraries.navigation.internal.on.i iVar = new com.google.android.libraries.navigation.internal.on.i();
                        int i14 = iArr4[1];
                        iVar.c = i14;
                        iVar.d = i14;
                        for (int i15 = 1; i15 < iArr4.length; i15 += 2) {
                            int i16 = iArr4[i15];
                            iVar.c = Math.min(i16, iVar.c);
                            iVar.d = Math.max(i16, iVar.d);
                        }
                        char c = 0;
                        int i17 = iArr4[0];
                        int i18 = i17;
                        int i19 = 0;
                        int i20 = 0;
                        while (i19 < iArr4.length) {
                            int i21 = iArr4[c];
                            int i22 = iArr4[i19];
                            int iAbs = Math.abs(i21 - i22);
                            iAbs = iAbs > 536870912 ? 1073741824 - iAbs : iAbs;
                            if (iAbs > i20) {
                                i20 = iAbs;
                                i18 = i22;
                            }
                            i19 += 2;
                            c = 0;
                        }
                        int i23 = 0;
                        boolean z3 = false;
                        while (true) {
                            length = iArr4.length;
                            if (i23 >= length) {
                                break;
                            }
                            int i24 = iArr4[i23];
                            int i25 = i18;
                            int iAbs2 = Math.abs(i24 - i25);
                            if (iAbs2 > 536870912) {
                                iAbs2 = 1073741824 - iAbs2;
                                z3 = true;
                            }
                            if (iAbs2 > i20) {
                                i17 = i24;
                                i20 = iAbs2;
                            }
                            i23 += 2;
                            i18 = i25;
                        }
                        int i26 = i18;
                        if (z3) {
                            iMin = Math.max(i26, i17);
                            iVar.a = iMin;
                            iMax = Math.min(i26, i17);
                            iVar.b = iMax;
                        } else {
                            iMin = Math.min(i26, i17);
                            iVar.a = iMin;
                            iMax = Math.max(i26, i17);
                            iVar.b = iMax;
                        }
                        com.google.android.libraries.navigation.internal.oe.x xVar4 = new com.google.android.libraries.navigation.internal.oe.x(iMin, iVar.c, 0);
                        com.google.android.libraries.navigation.internal.oe.x xVar5 = new com.google.android.libraries.navigation.internal.oe.x(iMax, iVar.d, 0);
                        double dA = 1.0d / com.google.android.libraries.navigation.internal.on.j.a(xVar5.d(), xVar4.d());
                        double dB = xVar5.b() - xVar4.b();
                        float[] fArr3 = new float[length];
                        com.google.android.libraries.navigation.internal.oe.x xVar6 = new com.google.android.libraries.navigation.internal.oe.x();
                        int i27 = 0;
                        while (i27 < (iArr4.length >> 1)) {
                            int i28 = i27 + i27;
                            int i29 = i28 + 1;
                            xVar6.J(iArr4[i28], iArr4[i29]);
                            fArr3[i28] = (float) (com.google.android.libraries.navigation.internal.on.j.a(xVar6.d(), xVar4.d()) * dA);
                            fArr3[i29] = (float) (1.0d - ((xVar6.b() - xVar4.b()) * (1.0d / dB)));
                            i27++;
                            iArr3 = iArr3;
                            iArr4 = iArr4;
                            vVar2 = vVar2;
                            z2 = z2;
                            gVarD = gVarD;
                        }
                        z = z2;
                        iArr = iArr3;
                        gVar2 = gVarD;
                        vVar = vVar2;
                        fArr = fArr3;
                    }
                } else {
                    z = z2;
                    iArr = iArr3;
                    gVar2 = gVarD;
                    vVar = vVar2;
                    float[] fArr4 = cjVar2.e;
                    if (fArr4 == null) {
                        float[] fArr5 = cjVar2.d;
                        int length4 = fArr5.length;
                        if (length4 == 0 || (length4 & 1) != 0) {
                            fArr = new float[0];
                        } else {
                            fArr = new float[length4];
                            int i30 = length4 >> 1;
                            float[] fArr6 = new float[i30];
                            float[] fArr7 = new float[i30];
                            int i31 = 0;
                            int i32 = 0;
                            while (i31 < fArr5.length) {
                                fArr6[i32] = fArr5[i31];
                                fArr7[i32] = fArr5[i31 + 1];
                                i31 += 2;
                                i32++;
                            }
                            float fB = com.google.android.libraries.navigation.internal.zy.b.b(fArr6);
                            float fA2 = com.google.android.libraries.navigation.internal.zy.b.a(fArr6);
                            float fB2 = com.google.android.libraries.navigation.internal.zy.b.b(fArr7);
                            float f2 = 1.0f / (fA2 - fB);
                            float fA3 = 1.0f / (com.google.android.libraries.navigation.internal.zy.b.a(fArr7) - fB2);
                            for (int i33 = 0; i33 < (fArr5.length >> 1); i33++) {
                                int i34 = i33 + i33;
                                fArr[i34] = (fArr6[i33] - fB) * f2;
                                fArr[i34 + 1] = 1.0f - ((fArr7[i33] - fB2) * fA3);
                            }
                        }
                    } else {
                        fArr = fArr4;
                    }
                }
                int[] iArr5 = cjVar2.c;
                float[] fArr8 = cjVar2.d;
                int i35 = iD * 3;
                int length5 = iArr5.length;
                int i36 = xVar3.a;
                int i37 = xVar3.b;
                com.google.android.libraries.navigation.internal.gz.e eVar = new com.google.android.libraries.navigation.internal.gz.e(16);
                for (int i38 = 0; i38 < i35; i38++) {
                    int i39 = iArr == null ? i38 : iArr[i38];
                    int i40 = i39 + i39;
                    if (length5 > 0) {
                        if (z) {
                            i2 = iArr5[i40] - i36;
                        } else {
                            i2 = iArr5[i40] - i36;
                            int i41 = com.google.android.libraries.geo.mapcore.internal.vector.gl.m.a;
                            while (i2 > 536870912) {
                                i2 -= 1073741824;
                            }
                            while (i2 < -536870912) {
                                i2 += 1073741824;
                            }
                        }
                        fA = i2;
                        i = i40 + 1;
                        f = iArr5[i] - i37;
                    } else {
                        i = i40 + 1;
                        fA = com.google.android.libraries.geo.mapcore.internal.vector.gl.m.a(fArr8[i40]);
                        f = fArr8[i];
                    }
                    float f3 = fArr[i40];
                    float f4 = fArr[i];
                    eVar.a(Float.floatToIntBits(fA));
                    eVar.a(Float.floatToIntBits(f));
                    eVar.a(Float.floatToIntBits(f3));
                    eVar.a(Float.floatToIntBits(f4));
                }
                com.google.android.libraries.geo.mapcore.renderer.ff ffVar = new com.google.android.libraries.geo.mapcore.renderer.ff("client_area", eVar.d(), i35, 81, 4, 16, (com.google.android.libraries.geo.mapcore.renderer.bq) null);
                ffVar.c(false);
                vVar.w(ffVar);
                gVar = gVar2;
            }
            int i42 = gVar.r;
            com.google.android.libraries.geo.mapcore.internal.model.ba baVar = gVar.q;
            com.google.android.libraries.geo.mapcore.internal.model.az azVar = new com.google.android.libraries.geo.mapcore.internal.model.az();
            azVar.a = baVar.c;
            azVar.b = baVar.d;
            azVar.c = baVar.e;
            if (aqVar2 != null) {
                azVar.b = aqVar2.a();
                com.google.android.libraries.navigation.internal.adg.es esVarE = aqVar2.e();
                if (esVarE != null) {
                    azVar.c = esVarE.c;
                }
            }
            com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.ae aeVar = new com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.ae(azVar.e(), i42, null);
            this.s = aeVar;
            this.q.f(aeVar);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(gVar);
            com.google.android.libraries.navigation.internal.qq.o oVar = new com.google.android.libraries.navigation.internal.qq.o(arrayList);
            this.f = oVar;
            this.p = new com.google.android.libraries.navigation.internal.qq.u(oVar);
            this.g.C(false);
            this.g.f74n = com.google.android.libraries.navigation.internal.qq.u.a;
            this.r.f(1.0f, 1.0f, 1.0f, 1.0f);
            v vVar3 = this.g;
            vVar3.t = 519;
            E((int) vVar3.E().b);
            A();
        } catch (IOException unused) {
            this.g = wVar.b(this, null);
            this.h = null;
            this.u = com.google.android.libraries.geo.mapcore.internal.model.bt.a;
            this.s = null;
            this.f = null;
            this.p = com.google.android.libraries.navigation.internal.qq.u.a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final List C(com.google.android.libraries.navigation.internal.adg.gm gmVar, com.google.android.libraries.navigation.internal.oe.k kVar) {
        int i;
        com.google.android.libraries.navigation.internal.ael.x xVar = gmVar.c;
        com.google.android.libraries.navigation.internal.ael.bq bqVar = gmVar.d;
        int i2 = com.google.android.libraries.navigation.internal.yz.ev.d;
        com.google.android.libraries.navigation.internal.yz.eq eqVar = new com.google.android.libraries.navigation.internal.yz.eq();
        com.google.android.libraries.navigation.internal.yz.eq eqVar2 = new com.google.android.libraries.navigation.internal.yz.eq();
        eqVar2.j(bqVar);
        int iB = kVar.b(xVar);
        if (bqVar.isEmpty() || ((Integer) bqVar.get(bqVar.size() - 1)).intValue() != iB) {
            eqVar2.h(Integer.valueOf(iB));
        }
        com.google.android.libraries.navigation.internal.ael.bq bqVar2 = gmVar.i;
        com.google.android.libraries.navigation.internal.yz.ev evVarG = eqVar2.g();
        lv lvVar = (lv) evVarG;
        ArrayList arrayList = new ArrayList(lvVar.c);
        no it2 = evVarG.iterator();
        while (it2.hasNext()) {
            arrayList.add(new ArrayList());
        }
        int i3 = 0;
        if (!bqVar2.isEmpty()) {
            int iIntValue = ((Integer) bqVar2.get(0)).intValue();
            int iIntValue2 = ((Integer) evVarG.get(0)).intValue();
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (iIntValue < iIntValue2) {
                    ((List) arrayList.get(i4)).add(Integer.valueOf(iIntValue - i5));
                    i6++;
                    if (i6 == bqVar2.size()) {
                        break;
                    }
                    iIntValue = ((Integer) bqVar2.get(i6)).intValue();
                } else {
                    i4++;
                    if (i4 == lvVar.c) {
                        break;
                    }
                    i5 = iIntValue2;
                    iIntValue2 = ((Integer) evVarG.get(i4)).intValue();
                }
            }
        }
        int iA = kVar.a();
        com.google.android.libraries.navigation.internal.yz.ev evVarG2 = eqVar2.g();
        int i7 = ((lv) evVarG2).c;
        int i8 = 0;
        int iIntValue3 = 0;
        int i9 = 0;
        while (i8 < i7) {
            Integer num = (Integer) evVarG2.get(i8);
            int i10 = iIntValue3 * iA;
            com.google.android.libraries.navigation.internal.ael.x xVarJ = xVar.j(i10, (iIntValue3 + 1) * iA);
            com.google.android.libraries.navigation.internal.ael.x xVarJ2 = xVar.j(i10, num.intValue() * iA);
            if (!xVarJ2.w(xVarJ2.d() - iA).equals(xVarJ)) {
                if (Integer.MAX_VALUE - xVarJ2.d() < xVarJ.d()) {
                    throw new IllegalArgumentException("ByteString would be too long: " + xVarJ2.d() + "+" + xVarJ.d());
                }
                xVarJ2 = com.google.android.libraries.navigation.internal.ael.dq.g(xVarJ2, xVarJ);
            }
            List list = (List) arrayList.get(i9);
            ArrayList arrayList2 = new ArrayList(1);
            int iA2 = kVar.a();
            if (list.isEmpty()) {
                arrayList2.add(xVarJ2);
                i = iA;
            } else {
                Iterator it3 = list.iterator();
                int i11 = i3;
                while (it3.hasNext()) {
                    int iIntValue4 = ((Integer) it3.next()).intValue();
                    if (i11 < iIntValue4) {
                        arrayList2.add(xVarJ2.j(i11 * iA2, (iIntValue4 + 1) * iA2));
                    }
                    i11 = iIntValue4 + 1;
                    iA = iA;
                }
                i = iA;
                int iB2 = kVar.b(xVarJ2);
                if (i11 < iB2 - 1) {
                    arrayList2.add(xVarJ2.j(i11 * iA2, iB2 * iA2));
                }
            }
            eqVar.j(arrayList2);
            iIntValue3 = num.intValue();
            i8++;
            i9++;
            iA = i;
            i3 = 0;
        }
        return eqVar.g();
    }

    protected static void D(com.google.android.libraries.navigation.internal.adg.fh fhVar, int i, com.google.android.libraries.navigation.internal.ael.x xVar, com.google.android.libraries.navigation.internal.ol.aq aqVar, int i2, int i3, int i4) {
        com.google.android.libraries.navigation.internal.adg.fd fdVar = (com.google.android.libraries.navigation.internal.adg.fd) com.google.android.libraries.navigation.internal.adg.fg.a.q();
        int i5 = com.google.android.libraries.navigation.internal.adg.ff.a;
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.fg fgVar = (com.google.android.libraries.navigation.internal.adg.fg) fdVar.b;
        int i6 = i5 - 1;
        if (i5 == 0) {
            throw null;
        }
        fgVar.g = i6;
        fgVar.b |= 4;
        int i7 = com.google.android.libraries.navigation.internal.adg.ff.a;
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.fg fgVar2 = (com.google.android.libraries.navigation.internal.adg.fg) fdVar.b;
        int i8 = i7 - 1;
        if (i7 == 0) {
            throw null;
        }
        fgVar2.h = i8;
        fgVar2.b |= 8;
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.fg fgVar3 = (com.google.android.libraries.navigation.internal.adg.fg) fdVar.b;
        fgVar3.b |= 2;
        fgVar3.d = i;
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.fg fgVar4 = (com.google.android.libraries.navigation.internal.adg.fg) fdVar.b;
        xVar.getClass();
        fgVar4.b |= 1;
        fgVar4.c = xVar;
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.fg fgVar5 = (com.google.android.libraries.navigation.internal.adg.fg) fdVar.b;
        fgVar5.b |= 1024;
        fgVar5.o = i2;
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.fg fgVar6 = (com.google.android.libraries.navigation.internal.adg.fg) fdVar.b;
        fgVar6.b |= 2048;
        fgVar6.p = i3;
        if (!fdVar.b.H()) {
            fdVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.fg fgVar7 = (com.google.android.libraries.navigation.internal.adg.fg) fdVar.b;
        int i9 = i4 - 1;
        if (i4 == 0) {
            throw null;
        }
        fgVar7.i = i9;
        fgVar7.b |= 16;
        com.google.android.libraries.navigation.internal.adg.es esVarE = aqVar.e();
        if (esVarE != null) {
            fdVar.C(com.google.android.libraries.navigation.internal.adg.et.f, esVarE);
        } else if (aqVar.a() != -1) {
            int iA = aqVar.a();
            if (!fdVar.b.H()) {
                fdVar.v();
            }
            com.google.android.libraries.navigation.internal.adg.fg fgVar8 = (com.google.android.libraries.navigation.internal.adg.fg) fdVar.b;
            fgVar8.b |= 256;
            fgVar8.m = iA;
        }
        fhVar.d(fdVar);
    }

    private final void E(int i) {
        com.google.android.libraries.geo.mapcore.renderer.ax axVar;
        com.google.android.libraries.navigation.internal.adg.aq aqVar = this.t;
        long j = aqVar.k;
        long j2 = aqVar.l;
        long j3 = i;
        this.g.u(new com.google.android.libraries.geo.mapcore.renderer.ae(j3, j, j2, this.o));
        Iterator it2 = f().iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.qq.j) it2.next()).u(new com.google.android.libraries.geo.mapcore.renderer.ae(j3, j, j2, this.o + 1));
            j2 = j2;
        }
        if (!this.z || (axVar = this.c) == null) {
            return;
        }
        axVar.h(this.g);
    }

    private static boolean F(com.google.android.libraries.geo.mapcore.internal.model.bt btVar) {
        if (btVar != null) {
            int i = 0;
            while (true) {
                com.google.android.libraries.geo.mapcore.internal.model.ai[] aiVarArr = btVar.c;
                if (i >= aiVarArr.length) {
                    break;
                }
                if (!aiVarArr[i].L.c()) {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    private static com.google.android.libraries.geo.mapcore.internal.model.bt c(com.google.android.libraries.navigation.internal.ol.aq aqVar, hi hiVar, com.google.android.libraries.geo.mapcore.internal.model.bt btVar) {
        if (aqVar instanceof dq) {
            return ((dq) aqVar).g();
        }
        return aqVar instanceof ba ? hiVar.g.l(((ba) aqVar).a) : btVar;
    }

    private final void d(boolean z) {
        com.google.android.libraries.geo.mapcore.renderer.ax axVar;
        synchronized (this) {
            if (this.b) {
                return;
            }
            if (z && !this.z) {
                this.z = true;
                v vVar = this.g;
                if (vVar != null && (axVar = this.c) != null) {
                    axVar.d(vVar, this);
                    this.c.h(this.g);
                }
            }
            ay ayVar = this.h;
            if (ayVar != null) {
                if (z) {
                    ayVar.z();
                } else {
                    ayVar.y();
                }
            }
            synchronized (this) {
                this.B = z;
            }
            this.m.b();
        }
    }

    public final synchronized void A() {
        this.a = false;
        final com.google.android.libraries.navigation.internal.hx.d dVar = new com.google.android.libraries.navigation.internal.hx.d((this.h != null ? 1 : 0) + 1, new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.p
            @Override // java.lang.Runnable
            public final void run() {
                this.a.q();
            }
        });
        this.l.f(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.q
            @Override // java.lang.Runnable
            public final void run() {
                dVar.a();
            }
        });
        ay ayVar = this.h;
        if (ayVar != null) {
            ayVar.ar(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.q
                @Override // java.lang.Runnable
                public final void run() {
                    dVar.a();
                }
            });
        }
    }

    public synchronized void B() {
        com.google.android.libraries.geo.mapcore.renderer.ey eyVarT;
        com.google.android.libraries.geo.mapcore.renderer.ea eaVar = com.google.android.libraries.geo.mapcore.renderer.ea.INVALID;
        if (this.a) {
            int iMax = (int) Math.max(0.0f, this.d.w().k);
            if (this.w) {
                this.w = false;
                float f = this.v;
                this.r.f(f, f, f, f);
                ay ayVar = this.h;
                if (ayVar != null) {
                    ayVar.r = f;
                    ayVar.d();
                }
            }
            com.google.android.libraries.geo.mapcore.internal.model.bt btVarC = c(this.l, this.e, this.u);
            int iA = btVarC.a(0);
            for (int i = 1; i < btVarC.b(); i++) {
                if (btVarC.a(i) < iMax) {
                    iA = iMax;
                }
            }
            if (iA > iMax) {
                iA = -1;
            }
            if (this.k || this.A != iA) {
                this.k = false;
                this.A = iA;
                com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("updateStyle");
                try {
                    com.google.android.libraries.geo.mapcore.internal.model.ai aiVarG = iA == -1 ? com.google.android.libraries.geo.mapcore.internal.model.ai.c : btVarC.g(iA);
                    com.google.android.libraries.geo.mapcore.renderer.ae aeVarE = this.g.E();
                    int i2 = aiVarG.H;
                    if (aeVarE.b != i2) {
                        E(i2);
                    }
                    com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.ae aeVar = this.s;
                    if (aeVar != null) {
                        com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.aj ajVar = this.q;
                        if (ajVar.c.a.containsKey(aeVar)) {
                            byte bA = ajVar.c.a(aeVar);
                            int i3 = aiVarG.j;
                            com.google.android.libraries.geo.mapcore.internal.model.bs[] bsVarArr = aiVarG.f58n;
                            com.google.android.libraries.navigation.internal.qh.b bVar = (com.google.android.libraries.navigation.internal.qh.b) ajVar.g.get(bA);
                            if (i3 <= 0 || aiVarG.d) {
                                i3 = 0;
                            }
                            bVar.b(i3, (bsVarArr.length <= 0 || aiVarG.e) ? 0 : bsVarArr[0].b);
                        }
                    }
                    v vVar = this.g;
                    com.google.android.libraries.geo.mapcore.renderer.ef efVar = vVar.m;
                    com.google.android.libraries.geo.mapcore.renderer.ex exVar = this.r;
                    if (efVar != exVar) {
                        vVar.v(exVar);
                        this.g.t(1, 771);
                    }
                    if (F(btVarC)) {
                        eyVarT = this.e.t(aiVarG.L);
                        if (eyVarT == null) {
                            ((com.google.android.libraries.navigation.internal.kk.j) this.C.a(com.google.android.libraries.navigation.internal.km.p.ao)).a();
                        }
                    } else {
                        int i4 = aiVarG.j;
                        if (aiVarG.d) {
                            ((Bitmap) this.x.a()).eraseColor(0);
                        } else {
                            ((Bitmap) this.x.a()).setPixel(0, 0, i4);
                        }
                        eyVarT = (com.google.android.libraries.geo.mapcore.renderer.ey) this.y.a();
                    }
                    if (eyVarT != null) {
                        this.g.B(0, eyVarT);
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
            this.g.C(this.B);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.g
    public final synchronized void a(float f) {
        if (this.v != f) {
            this.v = f;
            this.w = true;
            this.m.b();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.b, com.google.android.libraries.navigation.internal.ol.v
    public final synchronized void aq() {
        super.aq();
        this.g.f74n = com.google.android.libraries.navigation.internal.qq.u.a;
        ay ayVar = this.h;
        if (ayVar != null) {
            ayVar.aq();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.g
    public final void b(final com.google.android.libraries.navigation.internal.ol.aq aqVar) {
        aqVar.f(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.m
            @Override // java.lang.Runnable
            public final void run() {
                final x xVar = this.a;
                com.google.android.libraries.navigation.internal.ol.aq aqVar2 = aqVar;
                synchronized (xVar) {
                    xVar.l = aqVar2;
                    xVar.A();
                }
                xVar.ar(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        x xVar2 = xVar;
                        synchronized (xVar2) {
                            xVar2.k = true;
                        }
                    }
                });
            }
        });
    }

    protected abstract ay e(x xVar, w wVar, com.google.android.libraries.navigation.internal.pp.h hVar, com.google.android.libraries.navigation.internal.oe.k kVar, com.google.android.libraries.geo.mapcore.internal.model.g gVar, com.google.android.libraries.navigation.internal.adg.aq aqVar, com.google.android.libraries.navigation.internal.ol.aq aqVar2);

    protected final List f() {
        this.D.clear();
        ay ayVar = this.h;
        if (ayVar != null) {
            ayVar.b(this.D);
        }
        return this.D;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.v
    public final void h() {
        this.j.c(this);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.v
    public final void i() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.po.b, com.google.android.libraries.navigation.internal.ol.v
    public final synchronized void k(com.google.android.libraries.navigation.internal.ol.as asVar) {
        super.k(asVar);
        this.g.f74n = this.p;
        ay ayVar = this.h;
        if (ayVar != null) {
            ayVar.k(new s(this, asVar));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.po.b, com.google.android.libraries.navigation.internal.ol.v
    public final synchronized void l() {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.v
    public final void m() {
        this.j.e(this);
    }

    @Override // com.google.android.libraries.navigation.internal.ol.au
    public final /* synthetic */ com.google.android.libraries.navigation.internal.ael.cy n() {
        return this.t;
    }

    @Override // com.google.android.libraries.navigation.internal.po.b
    protected final void u(int i) {
        v(i, this);
    }

    @Override // com.google.android.libraries.navigation.internal.pp.d
    public final void w() {
        ay ayVar = this.h;
        if (ayVar != null) {
            ayVar.w();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pp.d
    public final void x() {
        boolean z;
        synchronized (this) {
            z = this.b;
            this.b = true;
        }
        if (z) {
            return;
        }
        o();
        if (this.z) {
            this.c.m(this.g);
            this.m.b();
        }
        ay ayVar = this.h;
        if (ayVar != null) {
            ayVar.x();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pp.d
    public final void y() {
        d(false);
    }

    @Override // com.google.android.libraries.navigation.internal.pp.d
    public final void z() {
        d(true);
    }
}
