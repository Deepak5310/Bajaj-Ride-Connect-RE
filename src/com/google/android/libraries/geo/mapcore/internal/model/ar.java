package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.adg.cx;
import com.google.android.libraries.navigation.internal.adg.cz;
import com.google.android.libraries.navigation.internal.adg.es;
import com.google.android.libraries.navigation.internal.adg.et;
import com.google.android.libraries.navigation.internal.adg.ff;
import com.google.android.libraries.navigation.internal.adg.fg;
import com.google.android.libraries.navigation.internal.agg.ez;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ar extends br {
    public final float a;
    public final int b;
    public final int c;
    public final com.google.android.libraries.navigation.internal.oe.ad[] d;
    public final bt e;
    public final bt f;
    public final int g;
    public final int h;
    public final int i;
    public final com.google.android.libraries.navigation.internal.adl.af j;
    public final com.google.android.libraries.navigation.internal.adl.aq k;
    public final com.google.android.libraries.navigation.internal.adl.aw l;
    public final com.google.android.libraries.navigation.internal.pt.f m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.aew.d f60n;
    public final com.google.android.libraries.navigation.internal.adg.bc o;
    public final boolean p;
    private final int s;

    public ar(float f, int i, int i2, com.google.android.libraries.navigation.internal.oe.ad[] adVarArr, bt btVar, bt btVar2, ba baVar, int i3, int i4, int i5, int i6, com.google.android.libraries.navigation.internal.adl.af afVar, com.google.android.libraries.navigation.internal.adl.aq aqVar, com.google.android.libraries.navigation.internal.adl.aw awVar, com.google.android.libraries.navigation.internal.pt.f fVar, com.google.android.libraries.navigation.internal.aew.d dVar, com.google.android.libraries.navigation.internal.adg.bc bcVar, boolean z, int i7) {
        super(baVar, i7);
        this.a = f;
        this.b = i;
        this.c = i2;
        this.d = adVarArr;
        this.s = i6;
        this.e = btVar;
        this.f = btVar2;
        this.g = i3;
        this.h = i4;
        this.i = i5;
        this.j = afVar;
        this.k = aqVar;
        this.l = awVar;
        this.o = bcVar;
        this.m = fVar;
        this.f60n = null;
        this.p = z;
    }

    /* JADX WARN: Code duplicated, block: B:112:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:114:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:115:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:118:0x02ec  */
    /* JADX WARN: Code duplicated, block: B:120:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:123:0x031c  */
    /* JADX WARN: Code duplicated, block: B:125:0x0332  */
    /* JADX WARN: Code duplicated, block: B:131:0x034b  */
    /* JADX WARN: Code duplicated, block: B:134:0x035f  */
    /* JADX WARN: Code duplicated, block: B:136:0x0372  */
    /* JADX WARN: Code duplicated, block: B:137:0x0375  */
    /* JADX WARN: Code duplicated, block: B:139:0x037c  */
    /* JADX WARN: Code duplicated, block: B:142:0x0384  */
    /* JADX WARN: Code duplicated, block: B:143:0x0389  */
    /* JADX WARN: Code duplicated, block: B:151:0x0399  */
    /* JADX WARN: Code duplicated, block: B:153:0x039c  */
    /* JADX WARN: Code duplicated, block: B:155:0x03a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:156:0x03a3  */
    /* JADX WARN: Code duplicated, block: B:158:0x03b1  */
    /* JADX WARN: Code duplicated, block: B:159:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:161:0x03c1  */
    /* JADX WARN: Code duplicated, block: B:164:0x03e8  */
    /* JADX WARN: Code duplicated, block: B:166:0x03f0  */
    /* JADX WARN: Code duplicated, block: B:172:0x03f9  */
    /* JADX WARN: Code duplicated, block: B:176:0x0403  */
    /* JADX WARN: Code duplicated, block: B:178:0x040b  */
    /* JADX WARN: Code duplicated, block: B:184:0x0414  */
    /* JADX WARN: Code duplicated, block: B:188:0x0424  */
    /* JADX WARN: Code duplicated, block: B:191:0x042e A[LOOP:1: B:154:0x039f->B:191:0x042e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:199:0x046c  */
    /* JADX WARN: Code duplicated, block: B:201:0x0470  */
    /* JADX WARN: Code duplicated, block: B:202:0x0475  */
    /* JADX WARN: Code duplicated, block: B:205:0x0488  */
    /* JADX WARN: Code duplicated, block: B:208:0x0492  */
    /* JADX WARN: Code duplicated, block: B:211:0x049c  */
    /* JADX WARN: Code duplicated, block: B:214:0x04a2  */
    /* JADX WARN: Code duplicated, block: B:216:0x04a6  */
    /* JADX WARN: Code duplicated, block: B:218:0x04ac  */
    /* JADX WARN: Code duplicated, block: B:220:0x04cf  */
    /* JADX WARN: Code duplicated, block: B:222:0x04d1  */
    /* JADX WARN: Code duplicated, block: B:224:0x04d3  */
    /* JADX WARN: Code duplicated, block: B:230:0x03f7 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:231:0x0469 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:232:0x0412 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:233:0x0467 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:234:0x0465 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:43:0x00f5  */
    public static void d(fg fgVar, com.google.android.libraries.navigation.internal.oe.o oVar, be beVar, ce ceVar, boolean z, List list, ez ezVar) throws IOException {
        com.google.android.libraries.navigation.internal.oe.ad[] adVarArr;
        bt btVarJ;
        com.google.android.libraries.navigation.internal.adl.af afVar;
        com.google.android.libraries.navigation.internal.adl.aw awVar;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS;
        com.google.android.libraries.navigation.internal.adl.aq aqVar;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS2;
        boolean z2;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS3;
        com.google.android.libraries.navigation.internal.adg.bc bcVar;
        int i;
        int size;
        bt btVar;
        bt btVar2;
        int i2;
        bt btVar3;
        int iA;
        int iA2;
        int iA3;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        ba baVar;
        bt btVar4;
        bt btVar5;
        ba baVar2;
        List list2;
        int i9;
        List list3;
        int i10;
        com.google.android.libraries.navigation.internal.oe.ad[] adVarArr2;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int iA4;
        int i17;
        int i18;
        int i19;
        int iA5;
        int iA6;
        bt btVar6;
        int length;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS4;
        Object objK;
        Object objC;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS5;
        Object objK2;
        Object objC2;
        com.google.android.libraries.navigation.internal.aal.b bVar;
        com.google.android.libraries.navigation.internal.adl.ap apVar;
        com.google.android.libraries.navigation.internal.adl.af afVar2;
        com.google.android.libraries.navigation.internal.ael.x xVar = fgVar.c;
        int i20 = fgVar.d;
        com.google.android.libraries.navigation.internal.ael.bq bqVar = fgVar.e;
        int[] iArrO = oVar.o(xVar, i20);
        int length2 = iArrO.length;
        int iD = oVar.d();
        int iE = oVar.e();
        int iF = oVar.f();
        int i21 = length2 >> 1;
        int i22 = 2;
        int i23 = 0;
        if (bqVar.isEmpty()) {
            adVarArr = i21 >= 2 ? new com.google.android.libraries.navigation.internal.oe.ad[]{new com.google.android.libraries.navigation.internal.oe.ad(iArrO, iD, iE, iF)} : com.google.android.libraries.navigation.internal.oe.o.a;
        } else {
            ArrayList arrayList = new ArrayList();
            int size2 = bqVar.size() + 1;
            int i24 = 0;
            while (i23 < size2) {
                int iIntValue = i23 < bqVar.size() ? ((Integer) bqVar.get(i23)).intValue() : i21;
                if (iIntValue > i21) {
                    throw new IOException("Invalid break");
                }
                int i25 = i21;
                if (iIntValue - i24 >= i22) {
                    arrayList.add(new com.google.android.libraries.navigation.internal.oe.ad(Arrays.copyOfRange(iArrO, i24 + i24, iIntValue + iIntValue), iD, iE, iF));
                }
                i23++;
                i24 = iIntValue;
                i21 = i25;
                i22 = 2;
            }
            adVarArr = new com.google.android.libraries.navigation.internal.oe.ad[arrayList.size()];
            arrayList.toArray(adVarArr);
        }
        if (adVarArr.length == 0) {
            return;
        }
        int i26 = ceVar != null ? ceVar.a.a : 0;
        float fE = ay.e(i26, fgVar.k);
        int i27 = fgVar.l;
        if (!z || beVar == null) {
            btVarJ = null;
        } else {
            com.google.android.libraries.navigation.internal.ael.bh bhVarS6 = com.google.android.libraries.navigation.internal.ael.bi.s(et.f);
            fgVar.h(bhVarS6);
            if (fgVar.w.n(bhVarS6.d)) {
                com.google.android.libraries.navigation.internal.ael.bh bhVarS7 = com.google.android.libraries.navigation.internal.ael.bi.s(et.f);
                fgVar.h(bhVarS7);
                Object objK3 = fgVar.w.k(bhVarS7.d);
                btVarJ = beVar.d(((es) (objK3 == null ? bhVarS7.b : bhVarS7.c(objK3))).c, ezVar);
            } else {
                int i28 = fgVar.b;
                if ((i28 & 256) != 0) {
                    btVarJ = beVar.k(fgVar.m);
                } else if ((i28 & 512) != 0) {
                    btVarJ = beVar.j(fgVar.f197n);
                } else {
                    btVarJ = null;
                }
            }
        }
        int i29 = fgVar.b;
        boolean z3 = ((i29 & 512) == 0 && (i29 & 256) == 0 && btVarJ == null) ? false : true;
        ba baVarE = new az().b(fgVar).e();
        int i30 = ev.d;
        List arrayList2 = lv.a;
        List arrayList3 = lv.a;
        List arrayList4 = lv.a;
        com.google.android.libraries.navigation.internal.ael.bh bhVarS8 = com.google.android.libraries.navigation.internal.ael.bi.s(et.g);
        fgVar.h(bhVarS8);
        Object objK4 = fgVar.w.k(bhVarS8.d);
        List list4 = (List) (objK4 == null ? bhVarS8.b : bhVarS8.c(objK4));
        com.google.android.libraries.navigation.internal.ael.bh bhVarS9 = com.google.android.libraries.navigation.internal.ael.bi.s(et.h);
        fgVar.h(bhVarS9);
        Object objK5 = fgVar.w.k(bhVarS9.d);
        List list5 = (List) (objK5 == null ? bhVarS9.b : bhVarS9.c(objK5));
        if (list4.isEmpty()) {
            int size3 = fgVar.f.size();
            if (size3 > 0) {
                arrayList2 = new ArrayList();
                arrayList4 = new ArrayList();
                for (int i31 = 0; i31 < size3; i31++) {
                    if (!z || beVar == null) {
                        az azVar = new az();
                        azVar.a = fgVar.f.a(i31);
                        arrayList4.add(azVar.e());
                    } else {
                        arrayList2.add(beVar.k((int) fgVar.f.a(i31)));
                    }
                }
            }
        } else {
            arrayList2 = new ArrayList();
            arrayList3 = new ArrayList();
            if (beVar != null) {
                Iterator it2 = list4.iterator();
                while (it2.hasNext()) {
                    arrayList2.add(beVar.d(((es) it2.next()).c, ezVar));
                }
                Iterator it3 = list5.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(beVar.d(((es) it3.next()).c, ezVar));
                }
            }
        }
        com.google.android.libraries.navigation.internal.ael.bh bhVarS10 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.x);
        fgVar.h(bhVarS10);
        if (fgVar.w.n(bhVarS10.d)) {
            com.google.android.libraries.navigation.internal.ael.bh bhVarS11 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.x);
            fgVar.h(bhVarS11);
            Object objK6 = fgVar.w.k(bhVarS11.d);
            cx cxVar = (cx) (objK6 == null ? bhVarS11.b : bhVarS11.c(objK6));
            if (cxVar.e.isEmpty()) {
                afVar2 = null;
            } else {
                com.google.android.libraries.navigation.internal.adl.ae aeVar = (com.google.android.libraries.navigation.internal.adl.ae) com.google.android.libraries.navigation.internal.adl.af.a.q();
                String str = cxVar.c;
                if (!aeVar.b.H()) {
                    aeVar.v();
                }
                com.google.android.libraries.navigation.internal.adl.af afVar3 = (com.google.android.libraries.navigation.internal.adl.af) aeVar.b;
                str.getClass();
                afVar3.b |= 1;
                afVar3.c = str;
                String str2 = cxVar.d;
                if (!aeVar.b.H()) {
                    aeVar.v();
                }
                com.google.android.libraries.navigation.internal.adl.af afVar4 = (com.google.android.libraries.navigation.internal.adl.af) aeVar.b;
                str2.getClass();
                afVar4.b |= 2;
                afVar4.d = str2;
                String str3 = cxVar.e;
                if (!aeVar.b.H()) {
                    aeVar.v();
                }
                com.google.android.libraries.navigation.internal.adl.af afVar5 = (com.google.android.libraries.navigation.internal.adl.af) aeVar.b;
                str3.getClass();
                afVar5.b |= 4;
                afVar5.e = str3;
                afVar2 = (com.google.android.libraries.navigation.internal.adl.af) aeVar.t();
            }
            if (cxVar.f184n) {
                com.google.android.libraries.navigation.internal.adl.av avVar = (com.google.android.libraries.navigation.internal.adl.av) com.google.android.libraries.navigation.internal.adl.aw.a.q();
                com.google.android.libraries.navigation.internal.adl.af afVar6 = afVar2;
                String strF = new com.google.android.libraries.navigation.internal.oe.j(cxVar.f, cxVar.g).f();
                if (!avVar.b.H()) {
                    avVar.v();
                }
                com.google.android.libraries.navigation.internal.adl.aw awVar2 = (com.google.android.libraries.navigation.internal.adl.aw) avVar.b;
                awVar2.b |= 1;
                awVar2.c = strF;
                awVar = (com.google.android.libraries.navigation.internal.adl.aw) avVar.t();
                afVar = afVar6;
            } else {
                afVar = afVar2;
            }
            bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.u);
            fgVar.h(bhVarS);
            if (fgVar.w.n(bhVarS.d)) {
                bhVarS5 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.u);
                fgVar.h(bhVarS5);
                objK2 = fgVar.w.k(bhVarS5.d);
                if (objK2 == null) {
                    objC2 = bhVarS5.b;
                } else {
                    objC2 = bhVarS5.c(objK2);
                }
                bVar = (com.google.android.libraries.navigation.internal.aal.b) objC2;
                if ((bVar.b & 1) != 0) {
                    apVar = (com.google.android.libraries.navigation.internal.adl.ap) com.google.android.libraries.navigation.internal.adl.aq.a.q();
                    String str4 = bVar.c;
                    if (!apVar.b.H()) {
                        apVar.v();
                    }
                    com.google.android.libraries.navigation.internal.adl.aq aqVar2 = (com.google.android.libraries.navigation.internal.adl.aq) apVar.b;
                    str4.getClass();
                    aqVar2.b |= 1;
                    aqVar2.c = str4;
                    int i32 = bVar.d;
                    if (!apVar.b.H()) {
                        apVar.v();
                    }
                    com.google.android.libraries.navigation.internal.adl.aq aqVar3 = (com.google.android.libraries.navigation.internal.adl.aq) apVar.b;
                    aqVar3.b |= 2;
                    aqVar3.d = i32;
                    aqVar = (com.google.android.libraries.navigation.internal.adl.aq) apVar.t();
                } else {
                    aqVar = null;
                }
            } else {
                aqVar = null;
            }
            bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.x);
            fgVar.h(bhVarS2);
            if (fgVar.w.n(bhVarS2.d) && aqVar == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            bhVarS3 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.A);
            fgVar.h(bhVarS3);
            if (fgVar.w.n(bhVarS3.d)) {
                bhVarS4 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.A);
                fgVar.h(bhVarS4);
                objK = fgVar.w.k(bhVarS4.d);
                if (objK == null) {
                    objC = bhVarS4.b;
                } else {
                    objC = bhVarS4.c(objK);
                }
                bcVar = (com.google.android.libraries.navigation.internal.adg.bc) objC;
            } else {
                bcVar = null;
            }
            i = fgVar.p ^ Integer.MIN_VALUE;
            if (z) {
                size = arrayList2.size();
            } else {
                size = arrayList4.size();
            }
            btVar = btVarJ;
            if (!z3 || (size == (length = adVarArr.length) && length != 0)) {
                if (true == z3) {
                    size = 1;
                }
                if (!z3) {
                    if (btVar == null) {
                        btVar2 = bt.a;
                    } else {
                        btVar.m();
                        btVar2 = btVar;
                    }
                    i2 = fgVar.o;
                    btVar3 = bt.a;
                    iA = ff.a(fgVar.g);
                    if (iA == 0) {
                        iA = ff.b;
                    }
                    iA2 = ff.a(fgVar.h);
                    if (iA2 == 0) {
                        iA2 = ff.b;
                    }
                    iA3 = cz.a(fgVar.i);
                    if (iA3 == 0) {
                        iA3 = cz.a;
                    }
                    i3 = iA2 - 1;
                    if (iA2 != 0) {
                        throw null;
                    }
                    i4 = iA - 1;
                    if (iA != 0) {
                        throw null;
                    }
                    i5 = fgVar.j;
                    i6 = iA3 - 1;
                    if (iA3 != 0) {
                        throw null;
                    }
                    list.add(new ar(fE, i2, i, adVarArr, btVar2, btVar3, baVarE, i4, i3, i6, i5, afVar, aqVar, awVar, null, null, bcVar, z2, i26));
                    return;
                }
                i7 = size - 1;
                i8 = 0;
                while (i8 < size) {
                    if (z) {
                        bt btVar7 = (bt) arrayList2.get(i8);
                        if (i8 < arrayList3.size()) {
                            btVar6 = (bt) arrayList3.get(i8);
                        } else {
                            btVar6 = bt.a;
                        }
                        baVar = ba.a;
                        btVar5 = btVar6;
                        btVar4 = btVar7;
                    } else {
                        bt btVar8 = bt.a;
                        bt btVar9 = bt.a;
                        baVar = (ba) arrayList4.get(i8);
                        btVar4 = btVar8;
                        btVar5 = btVar9;
                    }
                    baVar2 = baVar;
                    list2 = arrayList3;
                    i9 = fgVar.o;
                    list3 = arrayList4;
                    i10 = size;
                    adVarArr2 = new com.google.android.libraries.navigation.internal.oe.ad[]{adVarArr[i8]};
                    if (i8 == 0) {
                        iA6 = ff.a(fgVar.g);
                        if (iA6 == 0) {
                            iA6 = ff.b;
                        }
                        i12 = iA6 - 1;
                        if (iA6 == 0) {
                            throw null;
                        }
                    } else {
                        i11 = ff.a;
                        i12 = i11 - 1;
                        if (i11 == 0) {
                            throw null;
                        }
                    }
                    i13 = i12;
                    if (i8 == i7) {
                        iA5 = ff.a(fgVar.h);
                        if (iA5 == 0) {
                            iA5 = ff.b;
                        }
                        i15 = iA5 - 1;
                        if (iA5 == 0) {
                            throw null;
                        }
                    } else {
                        i14 = ff.a;
                        i15 = i14 - 1;
                        if (i14 == 0) {
                            throw null;
                        }
                    }
                    i16 = i15;
                    iA4 = cz.a(fgVar.i);
                    if (iA4 == 0) {
                        iA4 = cz.a;
                    }
                    i17 = i7;
                    i18 = fgVar.j;
                    i19 = iA4 - 1;
                    if (iA4 != 0) {
                        throw null;
                    }
                    ar arVar = new ar(fE, i9, i, adVarArr2, btVar4, btVar5, baVar2, i13, i16, i19, i18, afVar, aqVar, awVar, null, null, bcVar, z2, i26);
                    arVar.e.m();
                    list.add(arVar);
                    i8++;
                    i7 = i17;
                    arrayList2 = arrayList2;
                    arrayList3 = list2;
                    size = i10;
                    arrayList4 = list3;
                }
            }
            return;
        }
        afVar = null;
        awVar = null;
        bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.u);
        fgVar.h(bhVarS);
        if (fgVar.w.n(bhVarS.d)) {
            bhVarS5 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.u);
            fgVar.h(bhVarS5);
            objK2 = fgVar.w.k(bhVarS5.d);
            if (objK2 == null) {
                objC2 = bhVarS5.b;
            } else {
                objC2 = bhVarS5.c(objK2);
            }
            bVar = (com.google.android.libraries.navigation.internal.aal.b) objC2;
            if ((bVar.b & 1) != 0) {
                apVar = (com.google.android.libraries.navigation.internal.adl.ap) com.google.android.libraries.navigation.internal.adl.aq.a.q();
                String str5 = bVar.c;
                if (!apVar.b.H()) {
                    apVar.v();
                }
                com.google.android.libraries.navigation.internal.adl.aq aqVar4 = (com.google.android.libraries.navigation.internal.adl.aq) apVar.b;
                str5.getClass();
                aqVar4.b |= 1;
                aqVar4.c = str5;
                int i33 = bVar.d;
                if (!apVar.b.H()) {
                    apVar.v();
                }
                com.google.android.libraries.navigation.internal.adl.aq aqVar5 = (com.google.android.libraries.navigation.internal.adl.aq) apVar.b;
                aqVar5.b |= 2;
                aqVar5.d = i33;
                aqVar = (com.google.android.libraries.navigation.internal.adl.aq) apVar.t();
            } else {
                aqVar = null;
            }
        } else {
            aqVar = null;
        }
        bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.x);
        fgVar.h(bhVarS2);
        if (fgVar.w.n(bhVarS2.d)) {
            z2 = true;
        } else {
            z2 = true;
        }
        bhVarS3 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.A);
        fgVar.h(bhVarS3);
        if (fgVar.w.n(bhVarS3.d)) {
            bhVarS4 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.bj.A);
            fgVar.h(bhVarS4);
            objK = fgVar.w.k(bhVarS4.d);
            if (objK == null) {
                objC = bhVarS4.b;
            } else {
                objC = bhVarS4.c(objK);
            }
            bcVar = (com.google.android.libraries.navigation.internal.adg.bc) objC;
        } else {
            bcVar = null;
        }
        i = fgVar.p ^ Integer.MIN_VALUE;
        if (z) {
            size = arrayList2.size();
        } else {
            size = arrayList4.size();
        }
        btVar = btVarJ;
        if (z3) {
        }
        if (true == z3) {
            size = 1;
        }
        if (!z3) {
            if (btVar == null) {
                btVar2 = bt.a;
            } else {
                btVar.m();
                btVar2 = btVar;
            }
            i2 = fgVar.o;
            btVar3 = bt.a;
            iA = ff.a(fgVar.g);
            if (iA == 0) {
                iA = ff.b;
            }
            iA2 = ff.a(fgVar.h);
            if (iA2 == 0) {
                iA2 = ff.b;
            }
            iA3 = cz.a(fgVar.i);
            if (iA3 == 0) {
                iA3 = cz.a;
            }
            i3 = iA2 - 1;
            if (iA2 != 0) {
                throw null;
            }
            i4 = iA - 1;
            if (iA != 0) {
                throw null;
            }
            i5 = fgVar.j;
            i6 = iA3 - 1;
            if (iA3 != 0) {
                throw null;
            }
            list.add(new ar(fE, i2, i, adVarArr, btVar2, btVar3, baVarE, i4, i3, i6, i5, afVar, aqVar, awVar, null, null, bcVar, z2, i26));
            return;
        }
        i7 = size - 1;
        i8 = 0;
        while (i8 < size) {
            if (z) {
                bt btVar10 = (bt) arrayList2.get(i8);
                if (i8 < arrayList3.size()) {
                    btVar6 = (bt) arrayList3.get(i8);
                } else {
                    btVar6 = bt.a;
                }
                baVar = ba.a;
                btVar5 = btVar6;
                btVar4 = btVar10;
            } else {
                bt btVar11 = bt.a;
                bt btVar12 = bt.a;
                baVar = (ba) arrayList4.get(i8);
                btVar4 = btVar11;
                btVar5 = btVar12;
            }
            baVar2 = baVar;
            list2 = arrayList3;
            i9 = fgVar.o;
            list3 = arrayList4;
            i10 = size;
            adVarArr2 = new com.google.android.libraries.navigation.internal.oe.ad[]{adVarArr[i8]};
            if (i8 == 0) {
                iA6 = ff.a(fgVar.g);
                if (iA6 == 0) {
                    iA6 = ff.b;
                }
                i12 = iA6 - 1;
                if (iA6 == 0) {
                    throw null;
                }
            } else {
                i11 = ff.a;
                i12 = i11 - 1;
                if (i11 == 0) {
                    throw null;
                }
            }
            i13 = i12;
            if (i8 == i7) {
                iA5 = ff.a(fgVar.h);
                if (iA5 == 0) {
                    iA5 = ff.b;
                }
                i15 = iA5 - 1;
                if (iA5 == 0) {
                    throw null;
                }
            } else {
                i14 = ff.a;
                i15 = i14 - 1;
                if (i14 == 0) {
                    throw null;
                }
            }
            i16 = i15;
            iA4 = cz.a(fgVar.i);
            if (iA4 == 0) {
                iA4 = cz.a;
            }
            i17 = i7;
            i18 = fgVar.j;
            i19 = iA4 - 1;
            if (iA4 != 0) {
                throw null;
            }
            ar arVar2 = new ar(fE, i9, i, adVarArr2, btVar4, btVar5, baVar2, i13, i16, i19, i18, afVar, aqVar, awVar, null, null, bcVar, z2, i26);
            arVar2.e.m();
            list.add(arVar2);
            i8++;
            i7 = i17;
            arrayList2 = arrayList2;
            arrayList3 = list2;
            size = i10;
            arrayList4 = list3;
        }
    }

    public static boolean e(br brVar, ai aiVar) {
        return brVar.a() == 8 && aiVar.o.length != 0;
    }

    public static boolean f(br brVar, ai aiVar) {
        if (brVar.a() != 8) {
            return false;
        }
        ar arVar = (ar) brVar;
        com.google.android.libraries.navigation.internal.adl.af afVar = arVar.j;
        if ((afVar != null && !afVar.e.isEmpty()) || arVar.l != null || arVar.k != null) {
            return true;
        }
        if (ay.f(arVar.s, 1)) {
            return false;
        }
        for (bs bsVar : aiVar.o) {
            if (bsVar.h != 0.0f) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.br
    public final int a() {
        return 8;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.br
    public final int b() {
        return this.b;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.br
    public final int c() {
        return this.c;
    }
}
