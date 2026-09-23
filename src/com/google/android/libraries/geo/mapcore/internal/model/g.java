package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.adg.cx;
import com.google.android.libraries.navigation.internal.adg.es;
import com.google.android.libraries.navigation.internal.adg.et;
import com.google.android.libraries.navigation.internal.adg.gm;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class g extends br {
    public final float a;
    public final float b;
    public final int c;
    public final int d;
    public final at e;
    public final com.google.android.libraries.navigation.internal.oe.j f;
    public final cj g;
    public final bt h;
    public final int i;
    public final com.google.android.libraries.navigation.internal.adl.af j;
    public final com.google.android.libraries.navigation.internal.adl.j k;
    public final boolean l;
    public final fd m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.pt.a f66n;
    public final com.google.android.libraries.navigation.internal.pt.f o;
    public final com.google.android.libraries.navigation.internal.adg.bc p;
    private final int[] s;
    private final int[] t;
    private final boolean u;

    public g(float f, float f2, int i, int i2, at atVar, com.google.android.libraries.navigation.internal.oe.j jVar, cj cjVar, int[] iArr, int[] iArr2, ba baVar, int i3, bt btVar, int i4, com.google.android.libraries.navigation.internal.pt.a aVar, com.google.android.libraries.navigation.internal.pt.f fVar, com.google.android.libraries.navigation.internal.adl.af afVar, fd fdVar, com.google.android.libraries.navigation.internal.adg.bc bcVar, com.google.android.libraries.navigation.internal.adl.j jVar2, boolean z, boolean z2) {
        super(baVar, i3);
        this.a = f;
        this.b = f2;
        this.c = i;
        this.d = i2;
        this.e = atVar;
        this.f = jVar;
        this.g = cjVar;
        this.s = iArr;
        this.t = iArr2;
        this.h = btVar;
        this.i = i4;
        this.f66n = aVar;
        this.o = fVar;
        this.j = afVar;
        this.m = null;
        this.p = bcVar;
        this.k = jVar2;
        this.u = z;
        this.l = z2;
    }

    /* JADX WARN: Code duplicated, block: B:274:0x05e5  */
    /* JADX WARN: Code duplicated, block: B:276:0x05f8  */
    /* JADX WARN: Code duplicated, block: B:277:0x05fb  */
    /* JADX WARN: Code duplicated, block: B:281:0x0615  */
    /* JADX WARN: Code duplicated, block: B:283:0x0628  */
    /* JADX WARN: Code duplicated, block: B:284:0x062b  */
    /* JADX WARN: Code duplicated, block: B:286:0x0634  */
    /* JADX WARN: Code duplicated, block: B:289:0x064d  */
    /* JADX WARN: Code duplicated, block: B:290:0x0657  */
    /* JADX WARN: Multi-variable type inference failed */
    public static g d(com.google.android.libraries.navigation.internal.adg.aq aqVar, com.google.android.libraries.navigation.internal.oe.o oVar, be beVar, ce ceVar, boolean z) throws Throwable {
        int iB;
        int iB2;
        int i;
        int i2;
        int i3;
        cj cjVar;
        int i4;
        int[] iArr;
        int[] iArrF;
        bt btVar;
        int i5;
        com.google.android.libraries.navigation.internal.pt.a aVar;
        com.google.android.libraries.navigation.internal.pt.f fVarA;
        boolean z2;
        com.google.android.libraries.navigation.internal.adl.af afVar;
        at atVar;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS2;
        com.google.android.libraries.navigation.internal.adg.bc bcVar;
        boolean z3;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS3;
        Object objK;
        Object objC;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS4;
        Object objK2;
        Object objC2;
        com.google.android.libraries.navigation.internal.oe.q qVar;
        com.google.android.libraries.navigation.internal.pt.a aVar2;
        com.google.android.libraries.navigation.internal.oe.bd bdVar;
        com.google.android.libraries.navigation.internal.pt.c cVar;
        bt btVarJ;
        int[] iArrF2;
        gm gmVar = aqVar.c;
        if (gmVar == null) {
            gmVar = gm.a;
        }
        boolean z4 = z && (gmVar.b & 8) != 0 && gmVar.j >= 0;
        if (aqVar.d) {
            int iMax = 256 << Math.max(4, ceVar.a());
            int iMin = ceVar.a.g + Math.min(0, 4 - ceVar.a());
            cd cdVar = ceVar.a;
            cjVar = new cj(new int[]{0, 0, 0, iMax, iMax, iMax, iMax, 0}, cj.b, null, cj.g(0, 4), 8, cdVar.e, cdVar.f, iMin);
        } else {
            boolean z5 = !z4;
            int iMin2 = z ? 0 : ceVar.a.g + Math.min(0, 4 - ceVar.a());
            int i6 = z ? 0 : ceVar.a.e;
            int i7 = z ? 0 : ceVar.a.f;
            boolean[] zArr = cj.a;
            int[] iArr2 = NativeTessellator.a;
            bc bcVar2 = new bc();
            bcVar2.a = oVar instanceof com.google.android.libraries.navigation.internal.oe.am;
            bcVar2.d = oVar.b(gmVar.c);
            bcVar2.h = null;
            if (gmVar.e.size() > 0) {
                bcVar2.h = com.google.android.libraries.navigation.internal.zy.b.c(gmVar.e);
            }
            int iB3 = gmVar.f;
            if (iB3 == 0) {
                iB3 = (gmVar.b & 1) != 0 ? oVar.b(gmVar.c) : 0;
                if ((gmVar.b & 16) != 0) {
                    iB3 += oVar.b(gmVar.k);
                }
                if ((gmVar.b & 32) != 0) {
                    iB3 += oVar.b(gmVar.m);
                }
            }
            int i8 = iB3 + iB3;
            if (bcVar2.a) {
                bcVar2.c = new float[i8];
                oVar.i(gmVar.c, 0, bcVar2.c);
            } else {
                bcVar2.b = new int[i8];
                oVar.l(gmVar.c, 0, bcVar2.b);
            }
            bcVar2.a(gmVar, oVar, z5);
            int i9 = gmVar.b;
            int i10 = i9 & 16;
            if (i10 != 0 || (i9 & 32) != 0) {
                com.google.android.libraries.navigation.internal.yx.ar.a((i10 == 0 && (i9 & 32) == 0) ? false : true);
                if ((gmVar.b & 16) != 0) {
                    iB = oVar.b(gmVar.k);
                    if (bcVar2.a) {
                        com.google.android.libraries.navigation.internal.ael.x xVar = gmVar.k;
                        int i11 = bcVar2.d;
                        float[] fArr = bcVar2.f;
                        com.google.android.libraries.navigation.internal.yx.ar.q(fArr);
                        oVar.i(xVar, i11, fArr);
                    } else {
                        com.google.android.libraries.navigation.internal.ael.x xVar2 = gmVar.k;
                        int i12 = bcVar2.d;
                        int[] iArr3 = bcVar2.e;
                        com.google.android.libraries.navigation.internal.yx.ar.q(iArr3);
                        oVar.l(xVar2, i12, iArr3);
                    }
                } else {
                    iB = 0;
                }
                if ((gmVar.b & 32) != 0) {
                    iB2 = oVar.b(gmVar.m);
                    if (bcVar2.a) {
                        com.google.android.libraries.navigation.internal.ael.x xVar3 = gmVar.m;
                        int i13 = bcVar2.d + iB;
                        float[] fArr2 = bcVar2.f;
                        com.google.android.libraries.navigation.internal.yx.ar.q(fArr2);
                        oVar.i(xVar3, i13, fArr2);
                    } else {
                        com.google.android.libraries.navigation.internal.ael.x xVar4 = gmVar.m;
                        int i14 = bcVar2.d + iB;
                        int[] iArr4 = bcVar2.e;
                        com.google.android.libraries.navigation.internal.yx.ar.q(iArr4);
                        oVar.l(xVar4, i14, iArr4);
                    }
                } else {
                    iB2 = 0;
                }
                if (iB > 2) {
                    int size = gmVar.l.size() + 1;
                    i = iB - (size + size);
                } else {
                    i = 0;
                }
                if (iB2 > 2) {
                    int size2 = gmVar.f200n.size() + 1;
                    i2 = iB2 - (size2 + size2);
                } else {
                    i2 = 0;
                }
                int[] iArr5 = bcVar2.g;
                int length = iArr5 == null ? 0 : iArr5.length;
                int[] iArr6 = new int[((i + i2) * 3) + length];
                if (iArr5 == null) {
                    com.google.android.libraries.navigation.internal.ael.bq bqVar = gmVar.g;
                    for (int i15 = 0; i15 < bqVar.size(); i15++) {
                        iArr6[i15] = ((Integer) bqVar.get(i15)).intValue();
                    }
                } else {
                    System.arraycopy(iArr5, 0, iArr6, 0, length);
                }
                com.google.android.libraries.navigation.internal.ael.bq bqVar2 = gmVar.l;
                com.google.android.libraries.navigation.internal.ael.bq bqVar3 = gmVar.f200n;
                int i16 = bcVar2.d;
                if (iB != 0 || iB2 != 0) {
                    int i17 = 0;
                    int i18 = 0;
                    while (i17 <= bqVar2.size()) {
                        int iIntValue = i17 < bqVar2.size() ? ((Integer) bqVar2.get(i17)).intValue() : iB;
                        for (int i19 = i18; i19 < iIntValue - 2; i19++) {
                            iArr6[length] = i16 + i18;
                            int i20 = length + 2;
                            int i21 = i16 + i19;
                            iArr6[length + 1] = i21 + 1;
                            length += 3;
                            iArr6[i20] = i21 + 2;
                        }
                        i17++;
                        i18 = iIntValue;
                    }
                    int i22 = i16 + iB;
                    int i23 = 0;
                    int i24 = 0;
                    while (i23 <= bqVar3.size()) {
                        int iIntValue2 = i23 < bqVar3.size() ? ((Integer) bqVar3.get(i23)).intValue() : iB2;
                        boolean z6 = false;
                        while (i24 < iIntValue2 - 2) {
                            int i25 = length + 1;
                            int i26 = i22 + i24;
                            if (z6) {
                                i3 = length + 2;
                                iArr6[length] = i26 + 1;
                                iArr6[i25] = i26;
                            } else {
                                i3 = length + 2;
                                iArr6[length] = i26;
                                iArr6[i25] = i26 + 1;
                            }
                            length = i3 + 1;
                            iArr6[i3] = i26 + 2;
                            z6 = !z6;
                            i24++;
                        }
                        i23++;
                        i24 = iIntValue2;
                    }
                }
                bcVar2.g = iArr6;
            }
            int[] iArr7 = bcVar2.e;
            com.google.android.libraries.navigation.internal.yx.ar.q(iArr7);
            float[] fArr3 = bcVar2.f;
            com.google.android.libraries.navigation.internal.yx.ar.q(fArr3);
            float[] fArr4 = bcVar2.h;
            int[] iArr8 = bcVar2.g;
            int i27 = bcVar2.d;
            cjVar = new cj(iArr7, fArr3, fArr4, iArr8, i27 + i27, i6, i7, iMin2);
        }
        if (aqVar.e) {
            if (gmVar.i.size() > 0) {
                iArrF2 = com.google.android.libraries.navigation.internal.zy.i.f(gmVar.i);
                i4 = 0;
            } else {
                i4 = 0;
                iArrF2 = new int[0];
            }
            iArrF = gmVar.d.size() > 0 ? com.google.android.libraries.navigation.internal.zy.i.f(gmVar.d) : new int[i4];
            iArr = iArrF2;
        } else {
            i4 = 0;
            iArr = null;
            iArrF = null;
        }
        com.google.android.libraries.navigation.internal.ael.bh bhVarS5 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.e);
        aqVar.h(bhVarS5);
        Object objK3 = aqVar.w.k(bhVarS5.d);
        int i28 = true != ((Boolean) (objK3 == null ? bhVarS5.b : bhVarS5.c(objK3))).booleanValue() ? i4 : 4;
        cd cdVar2 = ceVar.a;
        ba baVarE = new az().a(aqVar).e();
        bt btVar2 = bt.a;
        if (!z4 || beVar == null) {
            btVar = btVar2;
        } else {
            com.google.android.libraries.navigation.internal.ael.bh bhVarS6 = com.google.android.libraries.navigation.internal.ael.bi.s(et.b);
            aqVar.h(bhVarS6);
            if (aqVar.w.n(bhVarS6.d)) {
                com.google.android.libraries.navigation.internal.ael.bh bhVarS7 = com.google.android.libraries.navigation.internal.ael.bi.s(et.b);
                aqVar.h(bhVarS7);
                Object objK4 = aqVar.w.k(bhVarS7.d);
                btVarJ = beVar.l(((es) (objK4 == null ? bhVarS7.b : bhVarS7.c(objK4))).c);
            } else {
                btVarJ = (aqVar.b & 256) != 0 ? beVar.j(aqVar.j) : beVar.k(aqVar.i);
            }
            btVar = btVarJ;
        }
        com.google.android.libraries.navigation.internal.ael.bh bhVarS8 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.b);
        aqVar.h(bhVarS8);
        if (aqVar.w.n(bhVarS8.d)) {
            com.google.android.libraries.navigation.internal.ael.bh bhVarS9 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.b);
            aqVar.h(bhVarS9);
            Object objK5 = aqVar.w.k(bhVarS9.d);
            com.google.android.libraries.navigation.internal.acw.b bVar = (com.google.android.libraries.navigation.internal.acw.b) (objK5 == null ? bhVarS9.b : bhVarS9.c(objK5));
            com.google.android.libraries.navigation.internal.oe.i iVarA = com.google.android.libraries.navigation.internal.oe.i.a(bVar.c);
            if (iVarA == null) {
                String str = bVar.c;
                aVar2 = null;
            } else {
                int size3 = bVar.d.size();
                eq eqVarJ = ev.j(size3);
                for (int i29 = i4; i29 < size3; i29++) {
                    com.google.android.libraries.navigation.internal.acw.f fVar = (com.google.android.libraries.navigation.internal.acw.f) bVar.d.get(i29);
                    com.google.android.libraries.navigation.internal.oe.i iVarA2 = com.google.android.libraries.navigation.internal.oe.i.a(fVar.c);
                    if (iVarA2 == null) {
                        String str2 = fVar.c;
                        cVar = null;
                    } else {
                        int size4 = fVar.d.size();
                        eq eqVarJ2 = ev.j(size4);
                        for (int i30 = i4; i30 < size4; i30++) {
                            com.google.android.libraries.navigation.internal.oe.i iVarA3 = com.google.android.libraries.navigation.internal.oe.i.a((String) fVar.d.get(i30));
                            if (iVarA3 != null) {
                                eqVarJ2.h(iVarA3);
                            }
                        }
                        ev evVarG = eqVarJ2.g();
                        int i31 = fVar.b;
                        String str3 = (i31 & 2) != 0 ? fVar.e : fVar.f;
                        String str4 = (i31 & 4) != 0 ? fVar.f : fVar.e;
                        int i32 = fVar.g;
                        int i33 = (i31 & 16) != 0 ? fVar.h : Integer.MIN_VALUE;
                        if ((i31 & 32) != 0) {
                            com.google.android.libraries.navigation.internal.aax.f fVar2 = fVar.i;
                            if (fVar2 == null) {
                                fVar2 = com.google.android.libraries.navigation.internal.aax.f.a;
                            }
                            com.google.android.libraries.navigation.internal.aax.d dVar = fVar2.b;
                            if (dVar == null) {
                                dVar = com.google.android.libraries.navigation.internal.aax.d.a;
                            }
                            int i34 = dVar.c;
                            com.google.android.libraries.navigation.internal.aax.d dVar2 = fVar2.b;
                            if (dVar2 == null) {
                                dVar2 = com.google.android.libraries.navigation.internal.aax.d.a;
                            }
                            com.google.android.libraries.navigation.internal.oe.x xVarX = com.google.android.libraries.navigation.internal.oe.x.x(i34, dVar2.d);
                            com.google.android.libraries.navigation.internal.aax.d dVar3 = fVar2.c;
                            if (dVar3 == null) {
                                dVar3 = com.google.android.libraries.navigation.internal.aax.d.a;
                            }
                            int i35 = dVar3.c;
                            com.google.android.libraries.navigation.internal.aax.d dVar4 = fVar2.c;
                            if (dVar4 == null) {
                                dVar4 = com.google.android.libraries.navigation.internal.aax.d.a;
                            }
                            com.google.android.libraries.navigation.internal.oe.x xVarX2 = com.google.android.libraries.navigation.internal.oe.x.x(i35, dVar4.d);
                            int i36 = xVarX.a;
                            int i37 = xVarX2.a;
                            if (i36 > i37) {
                                xVarX2.a = i37 + 1073741824;
                            }
                            bdVar = new com.google.android.libraries.navigation.internal.oe.bd(new com.google.android.libraries.navigation.internal.oe.ai(xVarX, xVarX2));
                        } else {
                            bdVar = null;
                        }
                        cVar = new com.google.android.libraries.navigation.internal.pt.c(iVarA2, evVarG, str3, str4, i32, i33, bdVar);
                    }
                    if (cVar != null) {
                        eqVarJ.h(cVar);
                        cVar.b.contains(iVarA);
                    }
                }
                ev evVarG2 = eqVarJ.g();
                boolean z7 = bVar.f;
                int i38 = bVar.e;
                int i39 = (i38 < 0 || i38 >= size3) ? size3 == 0 ? -1 : i4 : i38;
                if ((bVar.b & 8) != 0) {
                    com.google.android.libraries.navigation.internal.aax.d dVar5 = bVar.g;
                    if (dVar5 == null) {
                        dVar5 = com.google.android.libraries.navigation.internal.aax.d.a;
                    }
                    int i40 = dVar5.c;
                    com.google.android.libraries.navigation.internal.aax.d dVar6 = bVar.g;
                    if (dVar6 == null) {
                        dVar6 = com.google.android.libraries.navigation.internal.aax.d.a;
                    }
                    qVar = new com.google.android.libraries.navigation.internal.oe.q(com.google.android.libraries.navigation.internal.oe.x.x(i40, dVar6.d));
                } else {
                    qVar = null;
                }
                aVar2 = new com.google.android.libraries.navigation.internal.pt.a(iVarA, evVarG2, i39, z7, qVar, null);
                if (z7) {
                    eq eqVarJ3 = ev.j(((lv) evVarG2).c + 1);
                    eqVarJ3.h(new com.google.android.libraries.navigation.internal.pt.c(com.google.android.libraries.navigation.internal.pt.c.a, ev.q(iVarA), "—", "—", 0, 0, null));
                    eqVarJ3.j(evVarG2);
                    aVar2 = new com.google.android.libraries.navigation.internal.pt.a(iVarA, eqVarJ3.g(), 0, true, qVar, aVar2);
                }
            }
            i5 = i28 | 8;
            aVar = aVar2;
        } else {
            i5 = i28;
            aVar = null;
        }
        com.google.android.libraries.navigation.internal.ael.bh bhVarS10 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.c);
        aqVar.h(bhVarS10);
        if (aqVar.w.n(bhVarS10.d)) {
            com.google.android.libraries.navigation.internal.ael.bh bhVarS11 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.c);
            aqVar.h(bhVarS11);
            Object objK6 = aqVar.w.k(bhVarS11.d);
            fVarA = com.google.android.libraries.navigation.internal.pt.f.a((com.google.android.libraries.navigation.internal.acw.j) (objK6 == null ? bhVarS11.b : bhVarS11.c(objK6)));
        } else {
            fVarA = null;
        }
        com.google.android.libraries.navigation.internal.adl.ae aeVar = (com.google.android.libraries.navigation.internal.adl.ae) com.google.android.libraries.navigation.internal.adl.af.a.q();
        com.google.android.libraries.navigation.internal.adl.i iVar = (com.google.android.libraries.navigation.internal.adl.i) com.google.android.libraries.navigation.internal.adl.j.a.q();
        com.google.android.libraries.navigation.internal.ael.bh bhVarS12 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.a);
        aqVar.h(bhVarS12);
        if (aqVar.w.n(bhVarS12.d)) {
            com.google.android.libraries.navigation.internal.ael.bh bhVarS13 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.a);
            aqVar.h(bhVarS13);
            Object objK7 = aqVar.w.k(bhVarS13.d);
            cx cxVar = (cx) (objK7 == null ? bhVarS13.b : bhVarS13.c(objK7));
            if (cxVar.e.isEmpty()) {
                z2 = true;
            } else {
                String str5 = cxVar.c;
                if (!aeVar.b.H()) {
                    aeVar.v();
                }
                com.google.android.libraries.navigation.internal.adl.af afVar2 = (com.google.android.libraries.navigation.internal.adl.af) aeVar.b;
                str5.getClass();
                z2 = true;
                afVar2.b |= 1;
                afVar2.c = str5;
                String str6 = cxVar.d;
                if (!aeVar.b.H()) {
                    aeVar.v();
                }
                com.google.android.libraries.navigation.internal.adl.af afVar3 = (com.google.android.libraries.navigation.internal.adl.af) aeVar.b;
                str6.getClass();
                afVar3.b |= 2;
                afVar3.d = str6;
                String str7 = cxVar.e;
                if (!aeVar.b.H()) {
                    aeVar.v();
                }
                com.google.android.libraries.navigation.internal.adl.af afVar4 = (com.google.android.libraries.navigation.internal.adl.af) aeVar.b;
                str7.getClass();
                afVar4.b |= 4;
                afVar4.e = str7;
            }
            long j = cxVar.g;
            com.google.android.libraries.navigation.internal.oe.j jVar = j != 0 ? new com.google.android.libraries.navigation.internal.oe.j(cxVar.f, j) : null;
            afVar = (com.google.android.libraries.navigation.internal.adl.af) aeVar.t();
            com.google.android.libraries.navigation.internal.adl.j jVar2 = (com.google.android.libraries.navigation.internal.adl.j) iVar.t();
            atVar = at.DEFAULT;
            bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(aw.b);
            aqVar.h(bhVarS);
            if (aqVar.w.n(bhVarS.d)) {
                bhVarS4 = com.google.android.libraries.navigation.internal.ael.bi.s(aw.b);
                aqVar.h(bhVarS4);
                objK2 = aqVar.w.k(bhVarS4.d);
                if (objK2 == null) {
                    objC2 = bhVarS4.b;
                } else {
                    objC2 = bhVarS4.c(objK2);
                }
                atVar = (at) objC2;
            }
            at atVar2 = atVar;
            bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.m);
            aqVar.h(bhVarS2);
            if (aqVar.w.n(bhVarS2.d)) {
                bhVarS3 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.m);
                aqVar.h(bhVarS3);
                objK = aqVar.w.k(bhVarS3.d);
                if (objK == null) {
                    objC = bhVarS3.b;
                } else {
                    objC = bhVarS3.c(objK);
                }
                bcVar = (com.google.android.libraries.navigation.internal.adg.bc) objC;
            } else {
                bcVar = null;
            }
            int i41 = cdVar2.a;
            int i42 = Integer.MIN_VALUE ^ aqVar.l;
            float fE = ay.e(i41, aqVar.g);
            float fC = ay.c(i41, aqVar.h);
            if (i(afVar)) {
                z3 = z2;
            } else {
                j().booleanValue();
                z3 = i4;
            }
            return new g(fE, fC, aqVar.k, i42, atVar2, jVar, cjVar, iArr, iArrF, baVarE, i41, btVar, i5, aVar, fVarA, afVar, null, bcVar, jVar2, z3, z4);
        }
        z2 = true;
        afVar = (com.google.android.libraries.navigation.internal.adl.af) aeVar.t();
        com.google.android.libraries.navigation.internal.adl.j jVar3 = (com.google.android.libraries.navigation.internal.adl.j) iVar.t();
        atVar = at.DEFAULT;
        bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(aw.b);
        aqVar.h(bhVarS);
        if (aqVar.w.n(bhVarS.d)) {
            bhVarS4 = com.google.android.libraries.navigation.internal.ael.bi.s(aw.b);
            aqVar.h(bhVarS4);
            objK2 = aqVar.w.k(bhVarS4.d);
            if (objK2 == null) {
                objC2 = bhVarS4.b;
            } else {
                objC2 = bhVarS4.c(objK2);
            }
            atVar = (at) objC2;
        }
        at atVar3 = atVar;
        bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.m);
        aqVar.h(bhVarS2);
        if (aqVar.w.n(bhVarS2.d)) {
            bhVarS3 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.m);
            aqVar.h(bhVarS3);
            objK = aqVar.w.k(bhVarS3.d);
            if (objK == null) {
                objC = bhVarS3.b;
            } else {
                objC = bhVarS3.c(objK);
            }
            bcVar = (com.google.android.libraries.navigation.internal.adg.bc) objC;
        } else {
            bcVar = null;
        }
        int i43 = cdVar2.a;
        int i44 = Integer.MIN_VALUE ^ aqVar.l;
        float fE2 = ay.e(i43, aqVar.g);
        float fC2 = ay.c(i43, aqVar.h);
        if (i(afVar)) {
            j().booleanValue();
            z3 = i4;
        } else {
            z3 = z2;
        }
        return new g(fE2, fC2, aqVar.k, i44, atVar3, jVar, cjVar, iArr, iArrF, baVarE, i43, btVar, i5, aVar, fVarA, afVar, null, bcVar, jVar3, z3, z4);
    }

    public static boolean i(com.google.android.libraries.navigation.internal.adl.af afVar) {
        return !afVar.e.isEmpty();
    }

    public static Boolean j() {
        return false;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.br
    public final int a() {
        return 3;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.br
    public final int b() {
        return this.c;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.br
    public final int c() {
        return this.d;
    }

    public final Boolean e() {
        return Boolean.valueOf(this.u);
    }

    public final List f() {
        int[] iArr;
        int[] iArr2;
        int i;
        ArrayList arrayList = new ArrayList();
        cj cjVar = this.g;
        int i2 = cjVar.g / 2;
        if (i2 >= 2 && (iArr = this.t) != null && (iArr2 = this.s) != null) {
            int i3 = 0;
            com.google.android.libraries.navigation.internal.oe.x xVarE = cjVar.e(0);
            int i4 = iArr.length <= 0 ? -1 : iArr[0];
            com.google.android.libraries.navigation.internal.oe.ab abVar = new com.google.android.libraries.navigation.internal.oe.ab(cjVar.j, cjVar.h, cjVar.i);
            int length = iArr2.length;
            int i5 = length <= 0 ? -1 : iArr2[0];
            int i6 = 1;
            if (i5 == 0) {
                i5 = length <= 1 ? -1 : iArr2[1];
                i = 1;
            } else {
                abVar.c(xVarE);
                i = 0;
            }
            int i7 = 1;
            while (i7 < i2) {
                com.google.android.libraries.navigation.internal.oe.x xVarE2 = cjVar.e(i7);
                if (xVarE == null) {
                    xVarE = xVarE2;
                }
                int i8 = i7 + 1;
                if (i4 == i8) {
                    i3++;
                    i4 = i3 >= iArr.length ? -1 : iArr[i3];
                    abVar.c(xVarE2);
                    if (i5 == i7) {
                        i++;
                        i5 = i >= iArr2.length ? -1 : iArr2[i];
                    } else {
                        abVar.c(xVarE);
                    }
                    if (abVar.a > i6) {
                        arrayList.add(abVar.a());
                    }
                    xVarE = null;
                    abVar = new com.google.android.libraries.navigation.internal.oe.ab(cjVar.j, cjVar.h, cjVar.i);
                } else if (i5 == i7) {
                    i++;
                    abVar.c(xVarE2);
                    i5 = i >= iArr2.length ? -1 : iArr2[i];
                    if (abVar.a > i6) {
                        arrayList.add(abVar.a());
                    }
                    abVar = new com.google.android.libraries.navigation.internal.oe.ab(cjVar.j, cjVar.h, cjVar.i);
                } else {
                    abVar.c(xVarE2);
                }
                i7 = i8;
                i6 = 1;
            }
            if (i5 == -1 && xVarE != null) {
                abVar.c(xVarE);
            }
            if (abVar.a > 1) {
                arrayList.add(abVar.a());
            }
        }
        return arrayList;
    }

    public final boolean g() {
        return this.t != null;
    }

    public final boolean h() {
        return ay.f(this.i, 4);
    }
}
