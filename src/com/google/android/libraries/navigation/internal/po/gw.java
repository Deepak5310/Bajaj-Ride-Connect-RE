package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.geo.mapcore.internal.vector.gl.GeometryUtil;
import com.google.android.libraries.navigation.internal.adg.ib;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class gw {
    public final gv a;
    public final com.google.android.libraries.navigation.internal.oe.o b;
    public final com.google.android.libraries.navigation.internal.qq.d d;
    public final boolean e;
    public com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.a g;
    private final float k;
    private final int l;
    private com.google.android.libraries.geo.mapcore.internal.model.be m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.google.android.libraries.geo.mapcore.renderer.ae f526n;
    private final List i = new ArrayList();
    public final List c = new ArrayList();
    private List j = new ArrayList();
    public int f = 0;
    public com.google.android.libraries.geo.mapcore.renderer.ef h = null;

    public gw(com.google.android.libraries.geo.mapcore.internal.model.be beVar, gv gvVar, com.google.android.libraries.navigation.internal.oe.o oVar, int i, float f, int i2, com.google.android.libraries.navigation.internal.qq.d dVar) {
        this.m = beVar;
        this.a = gvVar;
        this.b = oVar;
        this.e = i == 2;
        this.k = f;
        this.l = i2;
        this.f526n = dVar.E();
        this.d = dVar;
        dVar.C(false);
        dVar.t = 519;
        dVar.t(1, 771);
        dVar.l(1.0f);
    }

    public static com.google.android.libraries.geo.mapcore.internal.model.ai a(com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.a aVar, int i) {
        return ((com.google.android.libraries.geo.mapcore.internal.model.bt) aVar.c.get(0)).g(i);
    }

    public static com.google.android.libraries.geo.mapcore.renderer.ae b(int i) {
        return new com.google.android.libraries.geo.mapcore.renderer.ae(2147483647L, 2147483647L, 2147483647L, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List c(boolean z, com.google.android.libraries.geo.mapcore.internal.vector.gl.p pVar, int i) {
        com.google.android.libraries.geo.mapcore.internal.model.bt[] btVarArr;
        com.google.android.libraries.geo.mapcore.internal.model.bt[] btVarArr2;
        com.google.android.libraries.geo.mapcore.internal.model.bt btVarJ;
        this.g = new com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.a(this.k, i, this.e);
        this.d.a = pVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(this.g);
        com.google.android.libraries.navigation.internal.yx.ar.q(this.g);
        com.google.android.libraries.navigation.internal.yz.eq eqVar = new com.google.android.libraries.navigation.internal.yz.eq();
        for (com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.t tVar : this.c) {
            com.google.android.libraries.navigation.internal.adg.fg fgVar = tVar.a;
            com.google.android.libraries.navigation.internal.ael.bh bhVarS = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.g);
            fgVar.h(bhVarS);
            Object objK = fgVar.w.k(bhVarS.d);
            List list = (List) (objK == null ? bhVarS.b : bhVarS.c(objK));
            com.google.android.libraries.navigation.internal.ael.bh bhVarS2 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.h);
            fgVar.h(bhVarS2);
            Object objK2 = fgVar.w.k(bhVarS2.d);
            List list2 = (List) (objK2 == null ? bhVarS2.b : bhVarS2.c(objK2));
            if (fgVar.f.size() == 0 && list.isEmpty()) {
                com.google.android.libraries.navigation.internal.ael.bh bhVarS3 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.f);
                fgVar.h(bhVarS3);
                if (fgVar.w.n(bhVarS3.d)) {
                    com.google.android.libraries.navigation.internal.ael.bh bhVarS4 = com.google.android.libraries.navigation.internal.ael.bi.s(com.google.android.libraries.navigation.internal.adg.et.f);
                    fgVar.h(bhVarS4);
                    Object objK3 = fgVar.w.k(bhVarS4.d);
                    btVarJ = this.m.l(((com.google.android.libraries.navigation.internal.adg.es) (objK3 == null ? bhVarS4.b : bhVarS4.c(objK3))).c);
                } else {
                    btVarJ = (fgVar.b & 512) != 0 ? this.m.j(fgVar.f197n) : this.m.k(fgVar.m);
                }
                btVarArr2 = new com.google.android.libraries.geo.mapcore.internal.model.bt[]{btVarJ};
                com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.u uVar = (com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.u) tVar.b.get(0);
                this.g.g(uVar.i[0], btVarJ, com.google.android.libraries.geo.mapcore.internal.model.bt.a);
                uVar.j[0] = btVarJ;
            } else {
                if (list.isEmpty()) {
                    int size = fgVar.f.size();
                    com.google.android.libraries.geo.mapcore.internal.model.bt[] btVarArr3 = new com.google.android.libraries.geo.mapcore.internal.model.bt[size];
                    btVarArr = new com.google.android.libraries.geo.mapcore.internal.model.bt[fgVar.f.size()];
                    for (int i2 = 0; i2 < size; i2++) {
                        btVarArr3[i2] = this.m.k((int) fgVar.f.a(i2));
                        btVarArr[i2] = com.google.android.libraries.geo.mapcore.internal.model.bt.a;
                    }
                    btVarArr2 = btVarArr3;
                } else {
                    com.google.android.libraries.geo.mapcore.internal.model.bt[] btVarArr4 = new com.google.android.libraries.geo.mapcore.internal.model.bt[list.size()];
                    btVarArr = new com.google.android.libraries.geo.mapcore.internal.model.bt[list.size()];
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        btVarArr4[i3] = this.m.l(((com.google.android.libraries.navigation.internal.adg.es) list.get(i3)).c);
                        if (i3 < list2.size()) {
                            btVarArr[i3] = this.m.l(((com.google.android.libraries.navigation.internal.adg.es) list2.get(i3)).c);
                        } else {
                            btVarArr[i3] = com.google.android.libraries.geo.mapcore.internal.model.bt.a;
                        }
                    }
                    btVarArr2 = btVarArr4;
                }
                int i4 = 0;
                int i5 = 0;
                for (int i6 = 0; i6 < btVarArr2.length; i6++) {
                    com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.u uVar2 = (com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.u) tVar.b.get(i4);
                    uVar2.i[i5] = this.g.c(btVarArr2[i6], btVarArr[i6]);
                    uVar2.j[i5] = btVarArr2[i6];
                    i5++;
                    if (i5 == uVar2.i.length) {
                        i4++;
                        i5 = 0;
                    }
                }
            }
            eqVar.h(btVarArr2);
        }
        com.google.android.libraries.navigation.internal.yz.ev evVarG = eqVar.g();
        this.j = evVarG;
        if (!this.e) {
            this.f526n = b(this.l);
            for (int i7 = 0; i7 < this.c.size(); i7++) {
                com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.t tVar2 = (com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.t) this.c.get(i7);
                long j = ((com.google.android.libraries.geo.mapcore.internal.model.bt[]) evVarG.get(i7))[0].d().H;
                com.google.android.libraries.navigation.internal.adg.fg fgVar2 = tVar2.a;
                com.google.android.libraries.geo.mapcore.renderer.ae aeVar = new com.google.android.libraries.geo.mapcore.renderer.ae(j, fgVar2.o, fgVar2.p, this.l);
                if (aeVar.compareTo(this.f526n) < 0) {
                    this.f526n = aeVar;
                }
            }
            this.d.u(this.f526n);
        }
        return this.j;
    }

    public final void d() {
        this.d.k(this.a.b());
        this.f = 0;
        for (com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.t tVar : this.c) {
            for (com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.u uVar : tVar.b) {
                this.f += GeometryUtil.getMaxGeneratedVerticesForLine(Math.max(uVar.b.length >> 1, uVar.c.length >> 1), tVar.e, uVar.a.length);
            }
        }
    }

    public final boolean e(com.google.android.libraries.navigation.internal.adg.fg fgVar, List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.pp.g gVar = (com.google.android.libraries.navigation.internal.pp.g) it2.next();
            if (!this.i.contains(gVar)) {
                arrayList.add(gVar);
            }
        }
        if (!arrayList.isEmpty()) {
            if (arrayList.size() > 8 - this.i.size() || (!arrayList.isEmpty() && !this.i.isEmpty() && !((com.google.android.libraries.navigation.internal.pp.g) this.i.get(0)).o((com.google.android.libraries.navigation.internal.ol.aq) arrayList.get(0), this.e))) {
                return false;
            }
        }
        this.i.addAll(arrayList);
        com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.t tVar = new com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.t(fgVar, this.b);
        this.c.add(tVar);
        this.a.d(tVar);
        return true;
    }

    public final boolean f() {
        com.google.android.libraries.geo.mapcore.internal.legacy.internal.vector.gl.a aVar = this.g;
        if (aVar == null || aVar.c.isEmpty()) {
            return false;
        }
        com.google.android.libraries.geo.mapcore.internal.model.ai aiVarD = ((com.google.android.libraries.geo.mapcore.internal.model.bt) this.g.c.get(0)).d();
        int i = this.e ? aiVarD.K : aiVarD.J;
        int i2 = ib.a;
        if (i2 != 0) {
            return com.google.android.libraries.geo.mapcore.internal.model.ay.f(i, i2);
        }
        throw null;
    }
}
