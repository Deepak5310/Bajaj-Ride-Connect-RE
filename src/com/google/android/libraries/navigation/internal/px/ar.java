package com.google.android.libraries.navigation.internal.px;

import android.content.res.Resources;
import androidx.core.view.ViewCompat;
import com.google.android.libraries.geo.mapcore.renderer.LabelRenderer;
import com.google.android.libraries.geo.mapcore.renderer.LayeredLabelRenderer;
import com.google.android.libraries.navigation.internal.adg.ik;
import com.google.android.libraries.navigation.internal.adg.io;
import com.google.android.libraries.navigation.internal.adg.ir;
import com.google.android.libraries.navigation.internal.adg.jb;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class ar {
    public com.google.android.libraries.navigation.internal.adg.ds d;
    public final ArrayList e;
    public boolean f;
    public final com.google.android.libraries.navigation.internal.qc.a g;
    public final float h;
    public final float i;
    public final int j;
    private final int p;
    private ArrayList q;
    private final boolean s;
    private final float t;
    private final float u;
    private final float v;
    private final boolean w;
    private static final com.google.android.libraries.navigation.internal.zb.j k = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.px.ar");
    public static final com.google.android.libraries.navigation.internal.adg.p a = com.google.android.libraries.navigation.internal.adg.p.a;
    public static final jb b = jb.a;
    public static final com.google.android.libraries.navigation.internal.qc.i c = new com.google.android.libraries.navigation.internal.qc.c(0.0f);
    private static final com.google.android.libraries.geo.mapcore.renderer.et l = new com.google.android.libraries.geo.mapcore.renderer.et(new ArrayList());
    private static final com.google.android.libraries.navigation.internal.oe.ay m = new com.google.android.libraries.navigation.internal.oe.ay(1.0f, 0.0f);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float[] f538n = {1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.5f, 0.5f};
    private boolean o = true;
    private final AtomicReference r = new AtomicReference(new ap());

    public ar(ArrayList arrayList, com.google.android.libraries.navigation.internal.qc.b bVar, com.google.android.libraries.navigation.internal.adg.ds dsVar, int i, int i2, boolean z, boolean z2) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        this.w = z2;
        this.e = arrayList;
        this.d = dsVar;
        this.j = i2;
        this.s = z;
        if (arrayList.isEmpty()) {
            f = 0.0f;
            f2 = 0.0f;
            f3 = 0.0f;
            f4 = 0.0f;
            f5 = 0.0f;
        } else {
            int size = arrayList.size();
            float fMax = 0.0f;
            float f8 = 0.0f;
            for (int i3 = 0; i3 < size; i3++) {
                List list = (List) arrayList.get(i3);
                int size2 = list.size();
                float f9 = 0.0f;
                float fMax2 = 0.0f;
                for (int i4 = 0; i4 < size2; i4++) {
                    com.google.android.libraries.navigation.internal.qc.i iVarC = ((an) list.get(i4)).c();
                    f9 += iVarC.h;
                    fMax2 = Math.max(fMax2, iVarC.d());
                }
                fMax = Math.max(fMax, f9);
                f8 += fMax2;
            }
            List list2 = (List) arrayList.get(0);
            if (list2.isEmpty()) {
                f6 = 0.0f;
                f7 = 0.0f;
            } else {
                f7 = (i == 2 || i == 4) ? ((an) list2.get(0)).c().h : 0.0f;
                f6 = (i == 3 || i == 4) ? ((an) gs.d(list2)).c().h : 0.0f;
            }
            List list3 = (List) arrayList.get(0);
            List list4 = (List) gs.d(arrayList);
            int size3 = list3.size();
            float fMax3 = 0.0f;
            float fMax4 = 0.0f;
            for (int i5 = 0; i5 < size3; i5++) {
                com.google.android.libraries.navigation.internal.qc.i iVarC2 = ((an) list3.get(i5)).c();
                float fD = iVarC2.d() / 2.0f;
                fMax4 = Math.max(fMax4, fD);
                fMax3 = Math.max(fMax3, fD + iVarC2.c());
            }
            float f10 = fMax3 > fMax4 ? fMax3 - fMax4 : 0.0f;
            int size4 = list4.size();
            float fMax5 = 0.0f;
            float fMax6 = 0.0f;
            for (int i6 = 0; i6 < size4; i6++) {
                com.google.android.libraries.navigation.internal.qc.i iVarC3 = ((an) list4.get(i6)).c();
                float fD2 = iVarC3.d() / 2.0f;
                fMax6 = Math.max(fMax6, fD2);
                fMax5 = Math.max(fMax5, fD2 + iVarC3.k());
            }
            f5 = (fMax5 > fMax6 ? fMax5 - fMax6 : 0.0f) + f8 + f10;
            f4 = fMax;
            f2 = f6;
            f = f7;
            f3 = f10;
        }
        this.t = f4;
        this.u = f5;
        this.v = f3;
        this.h = f;
        this.i = f2;
        if (bVar != null) {
            this.g = new com.google.android.libraries.navigation.internal.qc.d(new com.google.android.libraries.navigation.internal.py.a(f4, f5, f, f2, bVar.d, bVar.a, bVar.c.getDisplayMetrics().density, false), bVar.b, bVar.c);
        } else {
            this.g = null;
        }
        int size5 = arrayList.size();
        this.q = hx.e(size5);
        int size6 = 0;
        for (int i7 = 0; i7 < size5; i7++) {
            List list5 = (List) arrayList.get(i7);
            this.q.add(Collections.nCopies(list5.size(), aq.a));
            size6 += list5.size();
        }
        this.p = size6;
        this.f = false;
    }

    private static void A(com.google.android.libraries.navigation.internal.adg.s sVar, float f, float[] fArr, int i) {
        if (sVar.b.size() > 0) {
            float[] fArr2 = new com.google.android.libraries.navigation.internal.qq.a(ev.o(sVar.b)).a;
            int length = fArr2.length;
            float f2 = 1.0f;
            if (length != 0) {
                if (f >= 1.0f) {
                    f2 = fArr2[length - 1];
                } else if (f <= 0.0f) {
                    f2 = fArr2[0];
                } else {
                    float f3 = f * (length - 1);
                    double d = f3;
                    int iFloor = (int) Math.floor(d);
                    int iCeil = (int) Math.ceil(d);
                    if (iFloor == iCeil) {
                        f2 = fArr2[iFloor];
                    } else {
                        float f4 = fArr2[iFloor];
                        float f5 = f3 - iFloor;
                        float f6 = iCeil - iFloor;
                        f2 = ((1.0f - ((iCeil - f3) / f6)) * fArr2[iCeil]) + ((1.0f - (f5 / f6)) * f4);
                    }
                }
            }
            fArr[i] = f2;
        }
    }

    public static ar e(com.google.android.libraries.navigation.internal.adg.dt dtVar, ek ekVar, Resources resources, com.google.android.libraries.navigation.internal.pz.a aVar, com.google.android.libraries.navigation.internal.qe.b bVar, com.google.android.libraries.navigation.internal.qc.g gVar, com.google.android.libraries.navigation.internal.qz.g gVar2, com.google.android.libraries.navigation.internal.pz.d dVar) {
        int i = ev.d;
        return w(dtVar, ekVar, 0, lv.a, resources, aVar, bVar, gVar, gVar2, dVar, false, false, false);
    }

    public static ar f(com.google.android.libraries.navigation.internal.adg.dt dtVar, ek ekVar, int i, ev evVar, Resources resources, com.google.android.libraries.navigation.internal.pz.a aVar, com.google.android.libraries.navigation.internal.qe.b bVar, com.google.android.libraries.navigation.internal.qc.g gVar, com.google.android.libraries.navigation.internal.qz.g gVar2, com.google.android.libraries.navigation.internal.pz.d dVar, boolean z) {
        return w(dtVar, ekVar, i, evVar, resources, aVar, bVar, gVar, gVar2, dVar, true, true, z);
    }

    public static void i(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((com.google.android.libraries.geo.mapcore.renderer.et) list.get(i)).c();
        }
    }

    static boolean p(com.google.android.libraries.navigation.internal.qe.b bVar, String str, com.google.android.libraries.geo.mapcore.internal.model.ai aiVar) {
        com.google.android.libraries.geo.mapcore.internal.model.cb cbVar;
        if (str != null && str.length() != 0 && bVar != null && (cbVar = aiVar.r) != null) {
            com.google.android.libraries.geo.mapcore.internal.model.o oVar = (com.google.android.libraries.geo.mapcore.internal.model.o) cbVar;
            if (oVar.c > 0 && (oVar.a & ViewCompat.MEASURED_STATE_MASK) != 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x014d  */
    /* JADX WARN: Code duplicated, block: B:72:0x017f  */
    /* JADX WARN: Code duplicated, block: B:81:0x0195  */
    /* JADX WARN: Multi-variable type inference failed */
    private static ar w(com.google.android.libraries.navigation.internal.adg.dt dtVar, ek ekVar, int i, ev evVar, Resources resources, com.google.android.libraries.navigation.internal.pz.a aVar, com.google.android.libraries.navigation.internal.qe.b bVar, com.google.android.libraries.navigation.internal.qc.g gVar, com.google.android.libraries.navigation.internal.qz.g gVar2, com.google.android.libraries.navigation.internal.pz.d dVar, boolean z, boolean z2, boolean z3) {
        int i2;
        com.google.android.libraries.navigation.internal.adg.ds dsVarA;
        com.google.android.libraries.geo.mapcore.internal.model.bz bzVar;
        com.google.android.libraries.geo.mapcore.internal.model.bz bzVar2;
        com.google.android.libraries.geo.mapcore.internal.model.m mVar;
        ArrayList arrayList;
        boolean z4;
        int i3;
        com.google.android.libraries.navigation.internal.yx.ar.q(aVar);
        if (dtVar == null) {
            return null;
        }
        float f = resources.getDisplayMetrics().density;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int size = dtVar.c.size();
        boolean z5 = true;
        boolean z6 = true;
        int i4 = 0;
        boolean z7 = false;
        boolean z8 = false;
        while (i4 < size) {
            com.google.android.libraries.navigation.internal.adg.dp dpVar = (com.google.android.libraries.navigation.internal.adg.dp) dtVar.c.get(i4);
            com.google.android.libraries.geo.mapcore.internal.model.ai aiVarA = gVar.a(dpVar, ekVar, i);
            if (dpVar.h) {
                arrayList2.add(arrayList3);
                arrayList = new ArrayList();
                z4 = false;
            } else {
                arrayList = arrayList3;
                z4 = z6;
            }
            if (aiVarA.f) {
                i3 = i4;
            } else {
                if ((dpVar.b & 1) == 0 || aiVarA.i()) {
                    i3 = i4;
                    if (aiVarA.i()) {
                        com.google.android.libraries.navigation.internal.qc.e eVarB = com.google.android.libraries.navigation.internal.qc.e.b(aVar, ev.o(ekVar.o().t), dpVar, aiVarA, dVar, gVar2, z3);
                        if (eVarB == null) {
                            return null;
                        }
                        com.google.android.libraries.navigation.internal.adg.p pVar = aiVarA.A;
                        int i5 = aiVarA.B;
                        if (pVar == null) {
                            pVar = a;
                        }
                        arrayList.add(new k(eVarB, pVar, i5, am.ICON));
                        z7 = (!(i3 != 0)) | z7;
                        z8 = (!(i3 != size + (-1))) | z8;
                    } else {
                        com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.geo.mapcore.internal.model.aw.a);
                        dpVar.h(bhVarS);
                        if (dpVar.w.n(bhVarS.d)) {
                            com.google.android.libraries.navigation.internal.ael.bh bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.geo.mapcore.internal.model.aw.a);
                            dpVar.h(bhVarS2);
                            Object objK = dpVar.w.k(bhVarS2.d);
                            com.google.android.libraries.navigation.internal.qc.c cVar = new com.google.android.libraries.navigation.internal.qc.c(((Integer) (objK == null ? bhVarS2.b : bhVarS2.c(objK))).intValue() * f);
                            com.google.android.libraries.navigation.internal.adg.p pVar2 = a;
                            int i6 = com.google.android.libraries.navigation.internal.adg.q.a;
                            int i7 = i6 - 1;
                            if (i6 == 0) {
                                throw null;
                            }
                            arrayList.add(new k(cVar, pVar2, i7, am.BLANK));
                        }
                    }
                } else if (p(bVar, dpVar.c, aiVarA)) {
                    String str = dpVar.c;
                    com.google.android.libraries.geo.mapcore.internal.model.cb cbVar = aiVarA.r;
                    int iB = (int) com.google.android.libraries.navigation.internal.pz.b.b(cbVar != null ? ((com.google.android.libraries.geo.mapcore.internal.model.o) cbVar).c : 0, dVar, f);
                    i3 = i4;
                    com.google.android.libraries.navigation.internal.qc.h hVar = new com.google.android.libraries.navigation.internal.qc.h(bVar, str, aiVarA, iB, bVar.e(str, aiVarA, iB));
                    com.google.android.libraries.navigation.internal.adg.p pVar3 = aiVarA.A;
                    int i8 = aiVarA.B;
                    if (pVar3 == null) {
                        pVar3 = a;
                    }
                    arrayList.add(new k(hVar, pVar3, i8, am.TEXT));
                } else {
                    i3 = i4;
                }
                z5 = false;
            }
            i4 = i3 + 1;
            arrayList3 = arrayList;
            z6 = z4;
        }
        com.google.android.libraries.navigation.internal.qc.b bVar2 = null;
        if (!arrayList3.isEmpty()) {
            arrayList2.add(arrayList3);
        }
        if (z5) {
            arrayList2.clear();
        }
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVarC = gVar.c(dtVar, ekVar, i);
        if (arrayList2.isEmpty() || !z6) {
            i2 = 1;
        } else if (z7) {
            bzVar2 = aiVarC.s;
            if (bzVar2 != null) {
                mVar = (com.google.android.libraries.geo.mapcore.internal.model.m) bzVar2;
                if (mVar.o || mVar.f68n != io.PILL) {
                    i2 = 1;
                } else if (z7) {
                    i2 = z8 ? 4 : 2;
                } else {
                    i2 = 3;
                }
            } else {
                i2 = 1;
            }
        } else if (z8) {
            z8 = true;
            bzVar2 = aiVarC.s;
            if (bzVar2 != null) {
                mVar = (com.google.android.libraries.geo.mapcore.internal.model.m) bzVar2;
                if (mVar.o) {
                    i2 = 1;
                } else {
                    i2 = 1;
                }
            } else {
                i2 = 1;
            }
        } else {
            i2 = 1;
        }
        if (z2 && (bzVar = aiVarC.s) != null && !bzVar.equals(com.google.android.libraries.geo.mapcore.internal.model.bz.p)) {
            com.google.android.libraries.navigation.internal.adg.d dVar2 = ekVar.o().e;
            if (dVar2 == null) {
                dVar2 = com.google.android.libraries.navigation.internal.adg.d.a;
            }
            com.google.android.libraries.navigation.internal.adg.b bVarB = com.google.android.libraries.navigation.internal.adg.b.b(dVar2.d);
            if (bVarB == null) {
                bVarB = com.google.android.libraries.navigation.internal.adg.b.CENTER;
            }
            ev.o(ekVar.o().t);
            bVar2 = new com.google.android.libraries.navigation.internal.qc.b(aiVarC, aVar, resources, bVarB);
        }
        if (evVar.isEmpty()) {
            dsVarA = com.google.android.libraries.navigation.internal.adg.ds.b(dtVar.f);
            if (dsVarA == null) {
                dsVarA = com.google.android.libraries.navigation.internal.adg.ds.CENTER_JUSTIFY;
            }
        } else {
            dsVarA = ((com.google.android.libraries.geo.mapcore.internal.model.aj) evVar.get(0)).a();
        }
        return new ar(arrayList2, bVar2, dsVarA, i2, ekVar.O() ? 2 : 1, z, z3);
    }

    private static void x(com.google.android.libraries.navigation.internal.rm.a aVar, float[] fArr, float f, float f2, int i, cu cuVar, com.google.android.libraries.navigation.internal.oe.ay ayVar, float f3, com.google.android.libraries.navigation.internal.rm.a aVar2) {
        float f4 = fArr[6];
        float[] fArr2 = cuVar.r;
        fArr2[0] = f4;
        fArr2[1] = fArr[7];
        if (i == 0) {
            aVar.d(-0.5f, -0.5f);
            aVar.c(f, f2);
            aVar.d(ayVar.b, ayVar.c);
        }
        aVar.a(fArr2, fArr2);
        aVar2.h();
        aVar2.d(-fArr[6], -fArr[7]);
        aVar2.c(fArr[2] * f, fArr[3] * f2);
        float f5 = fArr[1];
        aVar2.b((f5 + f5) * 3.1415927f);
        aVar2.d(fArr[4] * f, fArr[5] * f2);
        aVar2.b(f3);
        aVar2.d(fArr2[0], fArr2[1]);
        aVar.g(aVar2);
    }

    private static void y(com.google.android.libraries.navigation.internal.adg.cp cpVar, float f, float[] fArr) {
        com.google.android.libraries.navigation.internal.adg.s sVar = cpVar.k;
        if (sVar == null) {
            sVar = com.google.android.libraries.navigation.internal.adg.s.a;
        }
        A(sVar, f, fArr, 0);
        com.google.android.libraries.navigation.internal.adg.s sVar2 = cpVar.j;
        if (sVar2 == null) {
            sVar2 = com.google.android.libraries.navigation.internal.adg.s.a;
        }
        A(sVar2, f, fArr, 1);
        com.google.android.libraries.navigation.internal.adg.s sVar3 = cpVar.h;
        if (sVar3 == null) {
            sVar3 = com.google.android.libraries.navigation.internal.adg.s.a;
        }
        A(sVar3, f, fArr, 2);
        com.google.android.libraries.navigation.internal.adg.s sVar4 = cpVar.i;
        if (sVar4 == null) {
            sVar4 = com.google.android.libraries.navigation.internal.adg.s.a;
        }
        A(sVar4, f, fArr, 3);
        com.google.android.libraries.navigation.internal.adg.s sVar5 = cpVar.f;
        if (sVar5 == null) {
            sVar5 = com.google.android.libraries.navigation.internal.adg.s.a;
        }
        A(sVar5, f, fArr, 4);
        com.google.android.libraries.navigation.internal.adg.s sVar6 = cpVar.g;
        if (sVar6 == null) {
            sVar6 = com.google.android.libraries.navigation.internal.adg.s.a;
        }
        A(sVar6, f, fArr, 5);
        int i = cpVar.b;
        if ((i & 2) != 0) {
            fArr[6] = cpVar.d;
        }
        if ((i & 4) != 0) {
            fArr[7] = cpVar.e;
        }
    }

    private static void z(ir irVar, float f, float[] fArr) {
        com.google.android.libraries.navigation.internal.adg.s sVar = irVar.c;
        if (sVar == null) {
            sVar = com.google.android.libraries.navigation.internal.adg.s.a;
        }
        A(sVar, f, fArr, 0);
    }

    public final float a() {
        com.google.android.libraries.navigation.internal.qc.a aVar = this.g;
        return aVar != null ? aVar.i : this.u;
    }

    final float b() {
        return ((ap) this.r.get()).g.c;
    }

    public final float c() {
        com.google.android.libraries.navigation.internal.qc.a aVar = this.g;
        return aVar != null ? aVar.h : this.t;
    }

    public final ap d() {
        return (ap) this.r.get();
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00e8 A[PHI: r4
      0x00e8: PHI (r4v7 com.google.android.libraries.navigation.internal.qc.i) = 
      (r4v16 com.google.android.libraries.navigation.internal.qc.i)
      (r4v17 com.google.android.libraries.navigation.internal.qc.i)
     binds: [B:31:0x00b0, B:33:0x00b6] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    public final void g(ar arVar, com.google.android.libraries.geo.mapcore.internal.model.ci ciVar) {
        int size;
        List list;
        int i;
        int i2;
        List list2;
        jb jbVar;
        com.google.android.libraries.navigation.internal.qc.i iVar;
        com.google.android.libraries.navigation.internal.qc.i eVar;
        com.google.android.libraries.navigation.internal.qc.e eVar2;
        ar arVar2 = arVar;
        int size2 = arVar2.e.size();
        int size3 = this.e.size();
        this.q = hx.e(size3);
        int i3 = 0;
        this.f = false;
        int i4 = 0;
        while (i4 < size3) {
            if (i4 < size2) {
                list = (List) arVar2.e.get(i4);
                size = list.size();
            } else {
                size = i3;
                list = null;
            }
            List list3 = (List) this.e.get(i4);
            int size4 = list3.size();
            ArrayList arrayListE = hx.e(size4);
            int i5 = i3;
            while (i5 < size4) {
                am amVarB = am.BLANK;
                if (list == null || i5 >= size) {
                    i = size2;
                    i2 = size3;
                    list2 = list;
                    jbVar = null;
                    iVar = null;
                } else {
                    an anVar = (an) list.get(i5);
                    if (ciVar != null) {
                        list2 = list;
                        i = size2;
                        i2 = size3;
                        long jA = ((long) ((an) list3.get(i5)).a()) | (((long) anVar.a()) << 32);
                        if (ciVar.a.d(jA)) {
                            jbVar = (jb) ciVar.b.get(ciVar.a.s(jA));
                        }
                        com.google.android.libraries.navigation.internal.qc.i iVarC = anVar.c();
                        amVarB = anVar.b();
                        iVar = iVarC;
                    } else {
                        i = size2;
                        i2 = size3;
                        list2 = list;
                    }
                    jbVar = null;
                    com.google.android.libraries.navigation.internal.qc.i iVarC2 = anVar.c();
                    amVarB = anVar.b();
                    iVar = iVarC2;
                }
                if (jbVar != null) {
                    boolean z = this.o;
                    int i6 = jbVar.b;
                    this.o = z | (((i6 & 1) == 0 && (i6 & 2) == 0) ? false : true);
                    boolean z2 = iVar instanceof com.google.android.libraries.navigation.internal.qc.e;
                    com.google.android.libraries.navigation.internal.qc.i iVar2 = iVar;
                    if (z2) {
                        eVar2 = (com.google.android.libraries.navigation.internal.qc.e) iVar;
                        if (!eVar2.g) {
                            iVar2 = eVar2;
                            eVar = new com.google.android.libraries.navigation.internal.qc.e(eVar2.h, eVar2.i, eVar2.d, eVar2.a, eVar2.b, eVar2.c, eVar2.f, eVar2.e, true);
                        } else {
                            iVar2 = eVar2;
                            eVar = iVar2;
                        }
                    } else {
                        iVar2 = eVar2;
                        eVar = iVar2;
                    }
                    aq aqVarD = aq.d(jbVar, eVar, amVarB);
                    arrayListE.add(aqVarD);
                    this.f = aqVarD.e() | this.f;
                } else {
                    size = size;
                    list3 = list3;
                    arrayListE.add(aq.a);
                }
                i5++;
                ciVar = ciVar;
                size2 = i;
                list = list2;
                size3 = i2;
                size = size;
                list3 = list3;
            }
            this.q.add(arrayListE);
            i4++;
            arVar2 = arVar;
            i3 = 0;
        }
    }

    public final void h() {
        ((ap) this.r.getAndSet(new ap())).a();
        this.e.clear();
    }

    final void j(com.google.android.libraries.navigation.internal.adg.ds dsVar) {
        if (dsVar.equals(this.d)) {
            return;
        }
        this.d = dsVar;
        this.o = true;
        m();
    }

    public final void k(float f, float f2) {
        ((ap) this.r.get()).g.q(f, f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean l(com.google.android.libraries.navigation.internal.qq.x xVar) {
        ap apVar = (ap) this.r.get();
        if (!apVar.b()) {
            return false;
        }
        int size = apVar.f.size();
        for (int i = 0; i < size; i++) {
            com.google.android.libraries.navigation.internal.oe.ay ayVar = (com.google.android.libraries.navigation.internal.oe.ay) apVar.f.get(i);
            com.google.android.libraries.geo.mapcore.renderer.et etVar = (com.google.android.libraries.geo.mapcore.renderer.et) apVar.a.get(i);
            com.google.android.libraries.navigation.internal.oe.ay ayVar2 = apVar.g;
            xVar.i.g(ayVar2.b + ayVar.b, ayVar2.c + ayVar.c, apVar.h, etVar.a / 2.0f, etVar.b / 2.0f);
            if (xVar.i.d(xVar.b.e)) {
                return true;
            }
        }
        return false;
    }

    final boolean m() {
        char c2;
        if (!this.o) {
            return true;
        }
        int i = 0;
        if (this.e.isEmpty()) {
            this.o = false;
            return true;
        }
        ArrayList arrayListE = hx.e(this.e.size());
        ArrayList arrayListE2 = hx.e(this.e.size());
        int i2 = this.p;
        ArrayList arrayListE3 = hx.e(i2);
        ArrayList arrayListE4 = hx.e(i2);
        for (int i3 = 0; i3 < this.e.size(); i3++) {
            List list = (List) this.e.get(i3);
            List list2 = (List) this.q.get(i3);
            int size = list.size();
            for (int i4 = 0; i4 < size; i4++) {
                an anVar = (an) list.get(i4);
                aq aqVar = (aq) list2.get(i4);
                if (anVar.b() != am.BLANK) {
                    com.google.android.libraries.geo.mapcore.renderer.et etVarJ = anVar.c().j();
                    if (etVarJ == null) {
                        i(arrayListE);
                        i(arrayListE2);
                        this.o = true;
                        return false;
                    }
                    arrayListE.add(etVarJ);
                    arrayListE3.add(anVar);
                    arrayListE4.add(aqVar);
                    com.google.android.libraries.geo.mapcore.renderer.et etVarJ2 = aqVar.b().j();
                    if (etVarJ2 == null) {
                        etVarJ2 = l;
                    }
                    arrayListE2.add(etVarJ2);
                }
            }
        }
        ArrayList arrayListE5 = hx.e(this.e.size());
        float f = this.u - this.v;
        int i5 = 0;
        while (i5 < this.e.size()) {
            List list3 = (List) this.e.get(i5);
            int size2 = list3.size();
            float f2 = 0.0f;
            float fMax = 0.0f;
            for (int i6 = i; i6 < size2; i6++) {
                com.google.android.libraries.navigation.internal.qc.i iVarC = ((an) list3.get(i6)).c();
                fMax = Math.max(fMax, iVarC.d());
                f2 += iVarC.h;
            }
            char c3 = 0;
            float f3 = this.d == com.google.android.libraries.navigation.internal.adg.ds.CENTER_JUSTIFY ? (this.t - f2) / 2.0f : this.d == com.google.android.libraries.navigation.internal.adg.ds.RIGHT_JUSTIFY ? this.t - f2 : 0.0f;
            int size3 = list3.size();
            int i7 = i;
            while (i7 < size3) {
                com.google.android.libraries.navigation.internal.qc.i iVarC2 = ((an) list3.get(i7)).c();
                if (iVarC2 instanceof com.google.android.libraries.navigation.internal.qc.c) {
                    f3 += iVarC2.h;
                    c2 = c3;
                } else {
                    float f4 = iVarC2.h;
                    float f5 = iVarC2.i;
                    c2 = 0;
                    float fD = (f - ((fMax - iVarC2.d()) / 2.0f)) + iVarC2.c();
                    float f6 = f3 - (this.t * 0.5f);
                    float f7 = fD - (this.u * 0.5f);
                    arrayListE5.add(new com.google.android.libraries.navigation.internal.oe.ay((f6 + f4 + f6) * 0.5f, (-((f7 - f5) + f7)) * 0.5f));
                    f3 += iVarC2.h;
                }
                i7++;
                c3 = c2;
                list3 = list3;
                size3 = size3;
                arrayListE2 = arrayListE2;
            }
            f -= fMax;
            i5++;
            i = 0;
        }
        ((ap) this.r.getAndSet(new ap(this, arrayListE, arrayListE3, arrayListE4, arrayListE2, arrayListE5))).a();
        this.o = false;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean n(com.google.android.libraries.navigation.internal.qq.x xVar) {
        ap apVar = (ap) this.r.get();
        if (!apVar.b()) {
            return false;
        }
        int size = apVar.f.size();
        for (int i = 0; i < size; i++) {
            com.google.android.libraries.navigation.internal.oe.ay ayVar = (com.google.android.libraries.navigation.internal.oe.ay) apVar.f.get(i);
            com.google.android.libraries.geo.mapcore.renderer.et etVar = (com.google.android.libraries.geo.mapcore.renderer.et) apVar.a.get(i);
            com.google.android.libraries.navigation.internal.oe.ay ayVar2 = apVar.g;
            if (xVar.b(ayVar2.b + ayVar.b, ayVar2.c + ayVar.c, apVar.h, etVar.a, etVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final boolean o() {
        return this.e.isEmpty();
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0047  */
    /* JADX WARN: Multi-variable type inference failed */
    final boolean q(cu cuVar, LabelRenderer labelRenderer, float f, double d, com.google.android.libraries.navigation.internal.oe.ay ayVar, float f2, com.google.android.libraries.geo.mapcore.renderer.af afVar, com.google.android.libraries.navigation.internal.pb.t tVar) {
        float f3;
        ap apVar;
        double d2;
        char c2;
        ap apVar2 = (ap) this.r.get();
        if (apVar2.f.isEmpty()) {
            return true;
        }
        com.google.android.libraries.navigation.internal.oe.ay ayVar2 = apVar2.g;
        float f4 = ayVar2.b;
        float f5 = ayVar2.c;
        if (apVar2.f.size() <= 1) {
            com.google.android.libraries.navigation.internal.oe.ay ayVar3 = (com.google.android.libraries.navigation.internal.oe.ay) apVar2.f.get(0);
            if (ayVar3.c(ayVar3) > 0.1d) {
                ((com.google.android.libraries.navigation.internal.zb.h) k.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 927)).p("Rendering a perspective label with element offsets; this won't work");
            }
        } else {
            ((com.google.android.libraries.navigation.internal.zb.h) k.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 927)).p("Rendering a perspective label with element offsets; this won't work");
        }
        double dCos = Math.cos(d);
        double dSin = Math.sin(d);
        com.google.android.libraries.navigation.internal.oe.ay ayVar4 = cuVar.b;
        ayVar4.q((float) dCos, (float) dSin);
        com.google.android.libraries.navigation.internal.oe.ay ayVar5 = cuVar.c;
        com.google.android.libraries.navigation.internal.oe.ay.g((com.google.android.libraries.navigation.internal.oe.ay) apVar2.f.get(0), ayVar4, ayVar5);
        com.google.android.libraries.geo.mapcore.renderer.er erVarB = ((com.google.android.libraries.geo.mapcore.renderer.et) apVar2.a.get(0)).b(0);
        com.google.android.libraries.navigation.internal.yx.ar.q(erVarB);
        if (!com.google.android.libraries.navigation.internal.pb.j.q(tVar, f4 + (ayVar5.b * f), f5 + (ayVar5.c * f), cuVar.h, cuVar.j)) {
            return false;
        }
        com.google.android.libraries.navigation.internal.oe.x xVar = cuVar.h;
        int i = xVar.a;
        int i2 = xVar.b;
        float fN = 1.0f / tVar.n();
        float fA = com.google.android.libraries.navigation.internal.oe.w.a(tVar.w().k) * f;
        float f6 = -ayVar.b;
        float f7 = -ayVar.c;
        float f8 = fA * fN;
        float fB = erVarB.b() * f8;
        float fA2 = erVarB.a() * f8;
        double d3 = -dSin;
        double d4 = -dCos;
        if (apVar2.l == null) {
            apVar2.l = new ao();
        }
        float f9 = f7 * f8;
        float f10 = f6 * f8;
        float f11 = fA2 + f9;
        float f12 = fB + f10;
        double d5 = f12 - f10;
        apVar2.l.b.q((float) (d5 * dCos), (float) (d5 * d3));
        double d6 = f11 - f9;
        apVar2.l.c.q((float) (d6 * d3), (float) (d6 * d4));
        com.google.android.libraries.navigation.internal.oe.x xVar2 = cuVar.h;
        double d7 = i;
        double d8 = f10;
        double d9 = d8 * dCos;
        double d10 = f11;
        double d11 = d10 * d3;
        double d12 = i2;
        double d13 = d10 * d4;
        double d14 = (d8 * d3) + d12;
        double d15 = d7 + d9;
        xVar2.J((int) (d15 + d11), (int) (d14 + d13));
        if (!com.google.android.libraries.navigation.internal.pb.j.o(tVar, xVar2, cuVar.j)) {
            return false;
        }
        float[] fArr = cuVar.j;
        float f13 = fArr[0];
        float f14 = fArr[1];
        double d16 = f9;
        double d17 = d16 * d3;
        double d18 = d16 * d4;
        xVar2.J((int) (d15 + d17), (int) (d14 + d18));
        apVar2.l.a.W(xVar2);
        if (!com.google.android.libraries.navigation.internal.pb.j.o(tVar, xVar2, cuVar.j)) {
            return false;
        }
        float[] fArr2 = cuVar.j;
        float f15 = fArr2[0];
        float f16 = fArr2[1];
        double d19 = f12;
        double d20 = d12 + (d19 * d3);
        double d21 = d7 + (d19 * dCos);
        xVar2.J((int) (d21 + d17), (int) (d20 + d18));
        if (!com.google.android.libraries.navigation.internal.pb.j.o(tVar, xVar2, cuVar.j)) {
            return false;
        }
        float[] fArr3 = cuVar.j;
        float f17 = fArr3[0];
        float f18 = fArr3[1];
        xVar2.J((int) (d21 + d11), (int) (d20 + d13));
        if (!com.google.android.libraries.navigation.internal.pb.j.o(tVar, xVar2, cuVar.j)) {
            return false;
        }
        float[] fArr4 = cuVar.j;
        float f19 = fArr4[0];
        float f20 = fArr4[1];
        float f21 = erVarB.b;
        float f22 = erVarB.c;
        float f23 = erVarB.d;
        float f24 = erVarB.e;
        com.google.android.libraries.geo.mapcore.renderer.w wVarA = labelRenderer.b.a(erVarB.i, afVar);
        if (wVarA != null) {
            d2 = d7;
            c2 = 0;
            apVar = apVar2;
            f3 = f9;
            labelRenderer.c(f13, f14, f15, f16, f17, f18, f19, f20, f21, f22, f23, f24, f2, wVarA);
            labelRenderer.b.f(wVarA);
        } else {
            f3 = f9;
            apVar = apVar2;
            d2 = d7;
            c2 = 0;
        }
        double d22 = f10 + f12;
        double d23 = f3 + f11;
        xVar2.J((int) (d2 + (((d22 * dCos) + (d23 * d3)) * 0.5d)), (int) (d12 + (((d22 * d3) + (d23 * d4)) * 0.5d)));
        if (!com.google.android.libraries.navigation.internal.pb.j.o(tVar, xVar2, cuVar.j)) {
            return r16;
        }
        float[] fArr5 = cuVar.j;
        float f25 = fArr5[c2];
        float f26 = fArr5[r16];
        double d24 = d23 * 0.5d;
        xVar2.J((int) (d21 + (d24 * d3)), (int) (d20 + (d24 * d4)));
        if (!com.google.android.libraries.navigation.internal.pb.j.o(tVar, xVar2, cuVar.j)) {
            return r16;
        }
        float[] fArr6 = cuVar.j;
        float f27 = fArr6[c2];
        float f28 = fArr6[r16];
        ap apVar3 = apVar;
        apVar3.g.q(f25, f26);
        apVar3.h = Math.atan2(f28 - f26, f27 - f25);
        apVar3.i = f;
        return 1;
    }

    final boolean s(bi biVar) {
        ap apVar = (ap) this.r.get();
        if (!apVar.b()) {
            biVar.g = 1;
            return false;
        }
        ao aoVar = apVar.l;
        if (aoVar != null) {
            biVar.c.W(aoVar.a);
            biVar.e.r(aoVar.b);
            biVar.f.r(aoVar.c);
            biVar.g = 2;
            return true;
        }
        com.google.android.libraries.navigation.internal.oe.ay ayVar = apVar.g;
        double d = apVar.h;
        float f = apVar.i;
        float f2 = apVar.j * f;
        float f3 = f * apVar.k;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        float f4 = fCos * f2;
        float f5 = f2 * fSin;
        biVar.e.q(f4, f5);
        float f6 = (-fSin) * f3;
        float f7 = fCos * f3;
        biVar.f.q(f6, f7);
        biVar.d.q(ayVar.b - ((f4 + f6) / 2.0f), ayVar.c - ((f5 + f7) / 2.0f));
        biVar.g = 3;
        return true;
    }

    /* JADX WARN: Failed to calculate best type for var: r13v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v1 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r13v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v2 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r13v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r13v3 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v1 ??, new type: com.google.android.libraries.navigation.internal.yz.ev
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v1 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v1 ??, new type: com.google.android.libraries.navigation.internal.yz.ev
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v2 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.calculateFromBounds(FixTypesVisitor.java:159)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.setBestType(FixTypesVisitor.java:136)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:241)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 6 more
     */
    /* JADX WARN: Failed to calculate best type for var: r6v2 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v2 ??, new type: int
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v0 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v0 ??, new type: com.google.android.libraries.navigation.internal.yz.ev
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Failed to calculate best type for var: r7v3 ??
    jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r7v3 ??, new type: com.google.android.libraries.navigation.internal.yz.ev
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.calculateFromBounds(TypeInferenceVisitor.java:147)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.setBestType(TypeInferenceVisitor.java:125)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.lambda$runTypePropagation$2(TypeInferenceVisitor.java:103)
    	at java.base/java.util.ArrayList.forEach(Unknown Source)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runTypePropagation(TypeInferenceVisitor.java:103)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:75)
    Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
    	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
    	... 7 more
     */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*  JADX ERROR: Types fix failed
        jadx.core.utils.exceptions.JadxRuntimeException: Type update failed for variable: r6v2 ??, new type: int
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:109)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:59)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryPossibleTypes(FixTypesVisitor.java:186)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.deduceType(FixTypesVisitor.java:245)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryDeduceTypes(FixTypesVisitor.java:224)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
        Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.InsnArg.getType()" because "arg" is null
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.verifyType(TypeUpdate.java:210)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.queueTypeUpdate(TypeUpdate.java:171)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.sameFirstArgListener(TypeUpdate.java:454)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.requestUpdate(TypeUpdate.java:310)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.runUpdate(TypeUpdate.java:124)
        	at jadx.core.dex.visitors.typeinference.TypeUpdate.apply(TypeUpdate.java:91)
        	... 5 more
        */
    public final void t(com.google.android.libraries.navigation.internal.px.cu r37, com.google.android.libraries.geo.mapcore.renderer.LabelRenderer r38, double r39, float r41, com.google.android.libraries.navigation.internal.oe.ay r42, float r43, com.google.android.libraries.geo.mapcore.renderer.af r44) {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.libraries.navigation.internal.px.ar.t(com.google.android.libraries.navigation.internal.px.cu, com.google.android.libraries.geo.mapcore.renderer.LabelRenderer, double, float, com.google.android.libraries.navigation.internal.oe.ay, float, com.google.android.libraries.geo.mapcore.renderer.af):void");
    }

    public final void u(cu cuVar, LabelRenderer labelRenderer, float f, float f2, float f3, float f4, com.google.android.libraries.geo.mapcore.renderer.af afVar) {
        k(f, f2);
        t(cuVar, labelRenderer, 0.0d, f3, m, f4, afVar);
    }

    /* JADX WARN: Code duplicated, block: B:144:0x0307  */
    /* JADX WARN: Code duplicated, block: B:184:0x0565  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void v(cu cuVar, LabelRenderer labelRenderer, double d, float f, com.google.android.libraries.navigation.internal.oe.ay ayVar, float f2, com.google.android.libraries.geo.mapcore.renderer.af afVar, int i, long j) {
        char c2;
        char c3;
        char c4;
        char c5;
        int i2;
        com.google.android.libraries.geo.mapcore.renderer.cz czVar;
        com.google.android.libraries.navigation.internal.oe.ay ayVar2;
        float f3;
        com.google.android.libraries.navigation.internal.rm.a aVar;
        boolean z;
        boolean z2;
        char c6;
        boolean z3;
        com.google.android.libraries.navigation.internal.adg.cp cpVar;
        int i3;
        com.google.android.libraries.navigation.internal.adg.cp cpVar2;
        int i4;
        com.google.android.libraries.navigation.internal.adg.cp cpVar3;
        int i5;
        com.google.android.libraries.navigation.internal.rm.a aVar2;
        com.google.android.libraries.geo.mapcore.renderer.er erVarB;
        double d2 = d;
        float f4 = f;
        ap apVar = (ap) this.r.get();
        apVar.h = d2;
        com.google.android.libraries.navigation.internal.oe.ay ayVar3 = apVar.g;
        float f5 = ayVar3.b;
        float f6 = ayVar3.c;
        if (labelRenderer.a == null || !(apVar.e == null || this.g == null)) {
            t(cuVar, labelRenderer, d, f, ayVar, f2, afVar);
            return;
        }
        apVar.i = f4;
        com.google.android.libraries.navigation.internal.oe.ay ayVar4 = cuVar.f;
        int size = apVar.f.size();
        int i6 = 0;
        while (i6 < size) {
            com.google.android.libraries.navigation.internal.oe.ay ayVar5 = cuVar.b;
            com.google.android.libraries.navigation.internal.oe.ay.g((com.google.android.libraries.navigation.internal.oe.ay) apVar.f.get(i6), ayVar, ayVar5);
            com.google.android.libraries.geo.mapcore.renderer.et etVar = (com.google.android.libraries.geo.mapcore.renderer.et) apVar.a.get(i6);
            int i7 = size;
            com.google.android.libraries.geo.mapcore.renderer.et etVar2 = (com.google.android.libraries.geo.mapcore.renderer.et) apVar.d.get(i6);
            com.google.android.libraries.navigation.internal.yx.ar.q(etVar);
            com.google.android.libraries.navigation.internal.yx.ar.q(etVar2);
            an anVar = (an) apVar.b.get(i6);
            aq aqVar = (aq) apVar.c.get(i6);
            int i8 = i6;
            ayVar4.q((ayVar5.b * f4) + f5, (ayVar5.c * f4) + f6);
            float fMax = etVar.a;
            float fMax2 = etVar.b;
            ap apVar2 = apVar;
            float f7 = f5;
            if (i == 2 && (aqVar.c().b & 1) != 0) {
                float f8 = etVar2.a;
                float f9 = etVar2.b;
                fMax = Math.max(fMax, f8);
                fMax2 = Math.max(fMax2, f9);
            }
            float f10 = fMax;
            float f11 = fMax2;
            float f12 = f10 * f4;
            float f13 = f11 * f4;
            com.google.android.libraries.navigation.internal.rm.a aVar3 = cuVar.f541n;
            com.google.android.libraries.navigation.internal.rm.a aVar4 = cuVar.p;
            aVar3.h();
            aVar4.h();
            int iMax = Math.max(etVar.a(), etVar2.a());
            List list = cuVar.t;
            list.clear();
            int i9 = 0;
            while (true) {
                com.google.android.libraries.geo.mapcore.renderer.et etVar3 = etVar2;
                if (i9 >= iMax || i9 >= 6) {
                    break;
                }
                com.google.android.libraries.geo.mapcore.renderer.cz czVar2 = cuVar.s[i9];
                list.add(czVar2);
                com.google.android.libraries.geo.mapcore.renderer.et etVar4 = etVar;
                float f14 = (float) d2;
                float[] fArr = cuVar.j;
                float[] fArr2 = cuVar.k;
                List list2 = list;
                boolean z4 = i == 2 && aqVar.e();
                if (z4) {
                    jb jbVarC = aqVar.c();
                    i2 = iMax;
                    float[] fArr3 = f538n;
                    czVar = czVar2;
                    ayVar2 = ayVar4;
                    System.arraycopy(fArr3, 0, fArr2, 0, 8);
                    System.arraycopy(fArr3, 0, fArr, 0, 8);
                    com.google.android.libraries.navigation.internal.adg.ct ctVar = jbVarC.c;
                    if (ctVar == null) {
                        ctVar = com.google.android.libraries.navigation.internal.adg.ct.a;
                    }
                    long jD = i9 < ctVar.d.size() ? ctVar.d.d(i9) : 0L;
                    if (i9 < ctVar.b.size()) {
                        f3 = f6;
                        com.google.android.libraries.navigation.internal.adg.cp cpVar4 = (com.google.android.libraries.navigation.internal.adg.cp) ctVar.b.get(i9);
                        aVar = aVar4;
                        float f15 = j / cpVar4.c;
                        if (f15 >= 0.0f) {
                            y(cpVar4, Math.min(f15, 1.0f), fArr2);
                        }
                    } else {
                        f3 = f6;
                        aVar = aVar4;
                    }
                    if (i9 < ctVar.c.size()) {
                        com.google.android.libraries.navigation.internal.adg.cp cpVar5 = (com.google.android.libraries.navigation.internal.adg.cp) ctVar.c.get(i9);
                        float f16 = j / cpVar5.c;
                        if (f16 >= 0.0f) {
                            y(cpVar5, Math.min(f16, 1.0f), fArr);
                        }
                    }
                    if (j < jD) {
                        z = false;
                        z2 = true;
                        c6 = 2;
                        z3 = true;
                    } else {
                        z = false;
                        z2 = true;
                        c6 = 2;
                        z3 = false;
                    }
                } else {
                    i2 = iMax;
                    czVar = czVar2;
                    ayVar2 = ayVar4;
                    f3 = f6;
                    aVar = aVar4;
                    z = false;
                    System.arraycopy(f538n, 0, fArr, 0, 8);
                    if (anVar.b() != am.ICON || (anVar.d().b & 1) == 0) {
                        if (anVar.b() != am.TEXT || (anVar.d().b & 2) == 0) {
                            z2 = true;
                            c6 = 2;
                        } else {
                            int i10 = i - 1;
                            ik ikVar = anVar.d().d;
                            if (ikVar == null) {
                                ikVar = ik.a;
                            }
                            if (i == 0) {
                                throw null;
                            }
                            if (i10 == 1) {
                                c6 = 2;
                                z2 = true;
                                if ((ikVar.b & 1) != 0) {
                                    ir irVar = ikVar.c;
                                    if (irVar == null) {
                                        irVar = ir.a;
                                    }
                                    int i11 = irVar.b;
                                    if (i11 > 0) {
                                        float f17 = j / i11;
                                        if (f17 <= 1.0f && f17 >= 0.0f) {
                                            z(irVar, f17, fArr);
                                        }
                                    }
                                }
                            } else if (i10 == 2) {
                                c6 = 2;
                                if ((ikVar.b & 2) != 0) {
                                    ir irVar2 = ikVar.d;
                                    if (irVar2 == null) {
                                        irVar2 = ir.a;
                                    }
                                    int i12 = irVar2.b;
                                    if (i12 > 0) {
                                        float f18 = j / i12;
                                        if (f18 <= 1.0f && f18 >= 0.0f) {
                                            z(irVar2, f18, fArr);
                                        }
                                    }
                                }
                                z3 = false;
                                z2 = true;
                            } else if (i10 == 3 && (ikVar.b & 4) != 0) {
                                ir irVar3 = ikVar.e;
                                if (irVar3 == null) {
                                    irVar3 = ir.a;
                                }
                                int i13 = irVar3.b;
                                if (i13 > 0) {
                                    z(irVar3, (j / i13) % 1.0f, fArr);
                                }
                            }
                        }
                        z3 = false;
                    } else {
                        int i14 = i - 1;
                        com.google.android.libraries.navigation.internal.adg.cn cnVar = anVar.d().c;
                        if (cnVar == null) {
                            cnVar = com.google.android.libraries.navigation.internal.adg.cn.a;
                        }
                        if (i == 0) {
                            throw null;
                        }
                        if (i14 != 1) {
                            if (i14 != 2) {
                                if (i14 == 3 && cnVar.d.size() > i9 && (i5 = (cpVar3 = (com.google.android.libraries.navigation.internal.adg.cp) cnVar.d.get(i9)).c) > 0) {
                                    y(cpVar3, (j / i5) % 1.0f, fArr);
                                }
                            } else if (cnVar.c.size() > i9 && (i4 = (cpVar2 = (com.google.android.libraries.navigation.internal.adg.cp) cnVar.c.get(i9)).c) > 0) {
                                float f19 = j / i4;
                                if (f19 <= 1.0f && f19 >= 0.0f) {
                                    y(cpVar2, f19, fArr);
                                }
                            }
                        } else if (cnVar.b.size() > i9 && (i3 = (cpVar = (com.google.android.libraries.navigation.internal.adg.cp) cnVar.b.get(i9)).c) > 0) {
                            float f20 = j / i3;
                            if (f20 <= 1.0f && f20 >= 0.0f) {
                                y(cpVar, f20, fArr);
                            }
                        }
                    }
                    z3 = false;
                    z2 = true;
                    c6 = 2;
                }
                com.google.android.libraries.navigation.internal.rm.a aVar5 = cuVar.o;
                boolean z5 = z;
                int i15 = i2;
                aq aqVar2 = aqVar;
                com.google.android.libraries.geo.mapcore.renderer.cz czVar3 = czVar;
                com.google.android.libraries.navigation.internal.oe.ay ayVar6 = ayVar2;
                float f21 = f3;
                com.google.android.libraries.navigation.internal.rm.a aVar6 = aVar;
                ap apVar3 = apVar2;
                com.google.android.libraries.navigation.internal.rm.a aVar7 = aVar3;
                x(aVar3, fArr, f12, f13, i9, cuVar, ayVar6, f14, aVar5);
                if (z4) {
                    com.google.android.libraries.navigation.internal.rm.a aVar8 = cuVar.q;
                    x(aVar6, fArr2, f12, f13, i9, cuVar, ayVar6, f14, aVar8);
                    if (z3) {
                        aVar2 = aVar8;
                    } else {
                        aVar2 = aVar5;
                    }
                } else {
                    aVar2 = aVar5;
                }
                czVar3.a = z3 ? fArr2[z5 ? 1 : 0] : fArr[z5 ? 1 : 0];
                if (z3) {
                    erVarB = etVar3.b(i9);
                    etVar = etVar4;
                } else {
                    etVar = etVar4;
                    erVarB = etVar.b(i9);
                }
                czVar3.b = erVarB;
                if (erVarB != null) {
                    float fB = erVarB.b() / f10;
                    float fA = erVarB.a() / f11;
                    aVar2.f(0.5f, 0.5f);
                    aVar2.i(fB, fA);
                    aVar2.e();
                    aVar2.f(-0.5f, -0.5f);
                    czVar3.c.g(aVar2);
                }
                i9++;
                d2 = d;
                j = j;
                etVar2 = etVar3;
                aVar3 = aVar7;
                list = list2;
                iMax = i15;
                aqVar = aqVar2;
                ayVar4 = ayVar6;
                f6 = f21;
                aVar4 = aVar6;
                i = i;
                apVar2 = apVar3;
            }
            List list3 = list;
            com.google.android.libraries.navigation.internal.oe.ay ayVar7 = ayVar4;
            float f22 = f6;
            ap apVar4 = apVar2;
            LayeredLabelRenderer layeredLabelRenderer = labelRenderer.a;
            if (layeredLabelRenderer != null && list3.size() > 0) {
                float[] fArrCopyOf = Arrays.copyOf(LayeredLabelRenderer.b, 4);
                int i16 = 0;
                com.google.android.libraries.geo.mapcore.renderer.ep epVar = null;
                while (true) {
                    c2 = 7;
                    c3 = 5;
                    if (i16 >= list3.size()) {
                        break;
                    }
                    List list4 = list3;
                    com.google.android.libraries.geo.mapcore.renderer.cz czVar4 = (com.google.android.libraries.geo.mapcore.renderer.cz) list4.get(i16);
                    float[] fArr4 = czVar4.d;
                    com.google.android.libraries.geo.mapcore.renderer.er erVar = czVar4.b;
                    if (erVar != null) {
                        czVar4.c.a(fArr4, LayeredLabelRenderer.a);
                        float fMin = Math.min(fArrCopyOf[0], fArr4[0]);
                        fArrCopyOf[0] = fMin;
                        float fMin2 = Math.min(fMin, fArr4[2]);
                        fArrCopyOf[0] = fMin2;
                        float fMin3 = Math.min(fMin2, fArr4[4]);
                        fArrCopyOf[0] = fMin3;
                        fArrCopyOf[0] = Math.min(fMin3, fArr4[6]);
                        float fMin4 = Math.min(fArrCopyOf[1], fArr4[1]);
                        fArrCopyOf[1] = fMin4;
                        float fMin5 = Math.min(fMin4, fArr4[3]);
                        fArrCopyOf[1] = fMin5;
                        float fMin6 = Math.min(fMin5, fArr4[5]);
                        fArrCopyOf[1] = fMin6;
                        fArrCopyOf[1] = Math.min(fMin6, fArr4[7]);
                        float fMax3 = Math.max(fArrCopyOf[2], fArr4[0]);
                        fArrCopyOf[2] = fMax3;
                        float fMax4 = Math.max(fMax3, fArr4[2]);
                        fArrCopyOf[2] = fMax4;
                        float fMax5 = Math.max(fMax4, fArr4[4]);
                        fArrCopyOf[2] = fMax5;
                        fArrCopyOf[2] = Math.max(fMax5, fArr4[6]);
                        float fMax6 = Math.max(fArrCopyOf[3], fArr4[1]);
                        fArrCopyOf[3] = fMax6;
                        float fMax7 = Math.max(fMax6, fArr4[3]);
                        fArrCopyOf[3] = fMax7;
                        float fMax8 = Math.max(fMax7, fArr4[5]);
                        fArrCopyOf[3] = fMax8;
                        fArrCopyOf[3] = Math.max(fMax8, fArr4[7]);
                        epVar = erVar.i;
                    }
                    i16++;
                    list3 = list4;
                }
                List list5 = list3;
                if (epVar != null) {
                    com.google.android.libraries.geo.mapcore.renderer.w wVarA = layeredLabelRenderer.d.a(epVar, afVar);
                    if (wVarA != null) {
                        List list6 = layeredLabelRenderer.e;
                        list6.clear();
                        int i17 = 0;
                        while (i17 < list5.size()) {
                            com.google.android.libraries.geo.mapcore.renderer.cz czVar5 = (com.google.android.libraries.geo.mapcore.renderer.cz) list5.get(i17);
                            com.google.android.libraries.navigation.internal.rm.a aVar9 = layeredLabelRenderer.f;
                            float[] fArr5 = czVar5.d;
                            com.google.android.libraries.geo.mapcore.renderer.er erVar2 = czVar5.b;
                            if (erVar2 != null) {
                                float[] fArr6 = czVar5.c.a;
                                float f23 = fArr6[0];
                                float f24 = fArr6[4];
                                float f25 = fArr6[1];
                                float f26 = fArr6[3];
                                float f27 = (f23 * f24) - (f25 * f26);
                                if (f27 != 0.0f) {
                                    float f28 = f24 / f27;
                                    float f29 = (-f25) / f27;
                                    float f30 = (-f26) / f27;
                                    float f31 = f23 / f27;
                                    float f32 = fArr6[2];
                                    float f33 = fArr6[5];
                                    float[] fArr7 = aVar9.a;
                                    fArr7[0] = f28;
                                    fArr7[1] = f29;
                                    fArr7[2] = -((f28 * f32) + (f29 * f33));
                                    fArr7[3] = f30;
                                    fArr7[4] = f31;
                                    fArr7[5] = -((f32 * f30) + (f33 * f31));
                                    list6.add(czVar5);
                                    fArr5[0] = fArrCopyOf[0];
                                    fArr5[1] = fArrCopyOf[1];
                                    fArr5[2] = fArrCopyOf[0];
                                    fArr5[3] = fArrCopyOf[3];
                                    float f34 = fArrCopyOf[2];
                                    fArr5[4] = f34;
                                    fArr5[5] = fArrCopyOf[1];
                                    fArr5[6] = f34;
                                    fArr5[7] = fArrCopyOf[3];
                                    aVar9.a(fArr5, fArr5);
                                    float[] fArr8 = czVar5.e;
                                    float f35 = fArr5[0];
                                    float f36 = erVar2.d;
                                    float f37 = erVar2.b;
                                    fArr8[0] = (f35 * f36) + f37;
                                    float f38 = fArr5[1];
                                    float f39 = erVar2.e;
                                    float f40 = erVar2.c;
                                    fArr8[1] = (f38 * f39) + f40;
                                    fArr8[2] = (fArr5[2] * f36) + f37;
                                    fArr8[3] = (fArr5[3] * f39) + f40;
                                    fArr8[4] = (fArr5[4] * f36) + f37;
                                    c4 = 5;
                                    fArr8[5] = f40 + (fArr5[5] * f39);
                                    fArr8[6] = f37 + (fArr5[6] * f36);
                                    c5 = 7;
                                    fArr8[7] = f40 + (fArr5[7] * f39);
                                } else {
                                    c5 = 7;
                                    c4 = 5;
                                }
                            } else {
                                c4 = c3;
                                c5 = c2;
                            }
                            i17++;
                            c2 = c5;
                            c3 = c4;
                        }
                        LayeredLabelRenderer.a(fArrCopyOf[0], fArrCopyOf[3], list6, 1, f2, wVarA);
                        LayeredLabelRenderer.a(fArrCopyOf[0], fArrCopyOf[1], list6, 0, f2, wVarA);
                        LayeredLabelRenderer.a(fArrCopyOf[2], fArrCopyOf[1], list6, 2, f2, wVarA);
                        LayeredLabelRenderer.a(fArrCopyOf[2], fArrCopyOf[3], list6, 3, f2, wVarA);
                        layeredLabelRenderer.d.f(wVarA);
                    }
                }
            }
            i6 = i8 + 1;
            d2 = d;
            f4 = f;
            apVar = apVar4;
            size = i7;
            f5 = f7;
            ayVar4 = ayVar7;
            f6 = f22;
        }
    }

    /* JADX WARN: Code duplicated, block: B:46:0x00c0  */
    public final long r(int i) {
        int iMax;
        int i2;
        long j;
        int i3;
        boolean z = this.w;
        if (!z) {
            return 0L;
        }
        boolean z2 = this.f;
        if (z2 && i == 2) {
            if (z && z2) {
                ArrayList arrayList = this.q;
                int size = arrayList.size();
                int i4 = 0;
                int iMax2 = 0;
                while (i4 < size) {
                    Iterator it2 = ((List) arrayList.get(i4)).iterator();
                    while (true) {
                        i3 = i4 + 1;
                        if (it2.hasNext()) {
                            aq aqVar = (aq) it2.next();
                            if (aqVar.e()) {
                                com.google.android.libraries.navigation.internal.adg.ct ctVar = aqVar.c().c;
                                if (ctVar == null) {
                                    ctVar = com.google.android.libraries.navigation.internal.adg.ct.a;
                                }
                                int size2 = ctVar.b.size();
                                int size3 = ctVar.c.size();
                                int iMax3 = Math.max(size2, size3);
                                if (iMax3 != 0) {
                                    com.google.android.libraries.navigation.internal.ael.bz bzVar = ctVar.b;
                                    com.google.android.libraries.navigation.internal.ael.bz bzVar2 = ctVar.c;
                                    for (int i5 = 0; i5 < iMax3; i5++) {
                                        if (i5 < size2) {
                                            iMax2 = Math.max(iMax2, ((com.google.android.libraries.navigation.internal.adg.cp) bzVar.get(i5)).c);
                                        }
                                        if (i5 < size3) {
                                            iMax2 = Math.max(iMax2, ((com.google.android.libraries.navigation.internal.adg.cp) bzVar2.get(i5)).c);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i4 = i3;
                }
                j = iMax2;
            } else {
                j = 0;
            }
            if (j > 0) {
                return j;
            }
        }
        int iMax4 = 0;
        for (int i6 = 0; i6 < this.e.size(); i6++) {
            List list = (List) this.e.get(i6);
            for (int i7 = 0; i7 < list.size(); i7++) {
                an anVar = (an) list.get(i7);
                int iOrdinal = anVar.b().ordinal();
                if (iOrdinal == 0) {
                    int i8 = i - 1;
                    com.google.android.libraries.navigation.internal.adg.cn cnVar = anVar.d().c;
                    if (cnVar == null) {
                        cnVar = com.google.android.libraries.navigation.internal.adg.cn.a;
                    }
                    if (i == 0) {
                        throw null;
                    }
                    if (i8 == 1) {
                        Iterator it3 = cnVar.b.iterator();
                        iMax = 0;
                        while (it3.hasNext()) {
                            iMax = Math.max(iMax, ((com.google.android.libraries.navigation.internal.adg.cp) it3.next()).c);
                        }
                    } else if (i8 == 2) {
                        Iterator it4 = cnVar.c.iterator();
                        iMax = 0;
                        while (it4.hasNext()) {
                            iMax = Math.max(iMax, ((com.google.android.libraries.navigation.internal.adg.cp) it4.next()).c);
                        }
                    } else if (i8 != 3) {
                        i2 = 0;
                    } else {
                        Iterator it5 = cnVar.d.iterator();
                        iMax = 0;
                        while (it5.hasNext()) {
                            iMax = Math.max(iMax, ((com.google.android.libraries.navigation.internal.adg.cp) it5.next()).c);
                        }
                    }
                    i2 = iMax;
                } else if (iOrdinal != 1) {
                    i2 = 0;
                } else {
                    int i9 = i - 1;
                    ik ikVar = anVar.d().d;
                    if (ikVar == null) {
                        ikVar = ik.a;
                    }
                    if (i == 0) {
                        throw null;
                    }
                    if (i9 != 1) {
                        if (i9 != 2) {
                            if (i9 == 3 && (ikVar.b & 4) != 0) {
                                ir irVar = ikVar.e;
                                if (irVar == null) {
                                    irVar = ir.a;
                                }
                                i2 = irVar.b;
                            } else {
                                i2 = 0;
                            }
                        } else if ((ikVar.b & 2) != 0) {
                            ir irVar2 = ikVar.d;
                            if (irVar2 == null) {
                                irVar2 = ir.a;
                            }
                            i2 = irVar2.b;
                        } else {
                            i2 = 0;
                        }
                    } else if ((ikVar.b & 1) != 0) {
                        ir irVar3 = ikVar.c;
                        if (irVar3 == null) {
                            irVar3 = ir.a;
                        }
                        i2 = irVar3.b;
                    } else {
                        i2 = 0;
                    }
                }
                iMax4 = Math.max(iMax4, i2);
            }
        }
        return iMax4;
    }
}
