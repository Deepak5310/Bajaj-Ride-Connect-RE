package com.google.android.libraries.navigation.internal.abm;

import android.graphics.Bitmap;
import android.util.Pair;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.libraries.navigation.internal.abh.fy;
import com.google.android.libraries.navigation.internal.abh.fz;
import com.google.android.libraries.navigation.internal.abh.gw;
import com.google.android.libraries.navigation.internal.abh.hm;
import com.google.android.libraries.navigation.internal.adg.fd;
import com.google.android.libraries.navigation.internal.adg.ff;
import com.google.android.libraries.navigation.internal.adg.fg;
import com.google.android.libraries.navigation.internal.adg.fh;
import com.google.android.libraries.navigation.internal.adg.fi;
import com.google.android.libraries.navigation.internal.adg.ic;
import com.google.android.libraries.navigation.internal.adg.id;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.po.Cdo;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dx extends com.google.android.libraries.navigation.internal.ol.ar implements fy {
    public final com.google.android.libraries.navigation.internal.ol.z a;
    public final fz b;
    public final df c;
    boolean d;
    com.google.android.libraries.navigation.internal.ol.r e;
    final List f;
    final List g;
    public final List h;
    private final float i;
    private final h j;
    private final h k;
    private final Executor l;
    private final int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final c f136n;
    private final f o;
    private final com.google.android.libraries.navigation.internal.on.h p;
    private final fd q;
    private final List r;
    private final List s;
    private boolean t;
    private final List u;
    private final com.google.android.libraries.navigation.internal.po.bf v;
    private final com.google.android.libraries.navigation.internal.po.be w;
    private final com.google.android.libraries.navigation.internal.po.be x;
    private final com.google.android.libraries.navigation.internal.po.be y;

    public dx(float f, com.google.android.libraries.navigation.internal.ol.z zVar, fz fzVar, com.google.android.libraries.navigation.internal.on.h hVar, int i) {
        Executor executorA = com.google.android.libraries.navigation.internal.abf.ah.a();
        c cVarH = c.h();
        f fVar = f.a;
        df dfVar = df.b;
        this.e = null;
        this.f = new ArrayList();
        this.t = false;
        this.i = f;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
        this.a = zVar;
        this.b = fzVar;
        this.l = executorA;
        this.m = i;
        com.google.android.libraries.navigation.internal.abf.s.k(cVarH, "capProviderPhoenix");
        this.f136n = cVarH;
        this.o = fVar;
        com.google.android.libraries.navigation.internal.abf.s.k(dfVar, "multiZoomStyleFactoryPhoenix");
        this.c = dfVar;
        com.google.android.libraries.navigation.internal.abf.s.k(hVar, "clientRenderOpFactory");
        this.p = hVar;
        com.google.android.libraries.navigation.internal.po.bf bfVarO = zVar.o();
        this.v = bfVarO;
        this.s = new ArrayList();
        this.w = bfVarO.e();
        this.x = bfVarO.e();
        this.y = bfVarO.e();
        this.d = false;
        this.q = (fd) fg.a.q();
        this.r = new ArrayList();
        this.u = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.j = new h(i, 1, this, zVar, hVar);
        this.k = new h(i, 2, this, zVar, hVar);
    }

    private final void g() {
        if (this.d) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.h.size(); i++) {
            arrayList.add(i, Integer.valueOf(((com.google.android.libraries.navigation.internal.ol.aq) this.h.get(i)).a()));
        }
        n();
        f(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.du
            @Override // java.lang.Runnable
            public final void run() {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    dx dxVar = this.a;
                    dxVar.c.d(dxVar.a, ((Integer) it2.next()).intValue());
                }
            }
        });
    }

    private final void h() {
        boolean zN = this.b.N();
        if (com.google.android.libraries.navigation.internal.afu.d.i()) {
            for (com.google.android.libraries.navigation.internal.ol.p pVar : this.f) {
                if (zN) {
                    pVar.k(this);
                } else {
                    pVar.aq();
                }
            }
        } else {
            com.google.android.libraries.navigation.internal.ol.r rVar = this.e;
            if (rVar != null) {
                if (zN) {
                    rVar.k(this);
                    zN = true;
                } else {
                    rVar.aq();
                    zN = false;
                }
            }
        }
        this.j.e(zN);
        this.k.e(zN);
    }

    private final void i() {
        boolean zE = this.b.J().e();
        this.j.g(zE);
        this.k.g(zE);
    }

    private final void j() {
        this.k.d(this.b.H());
    }

    private final void l() {
        dw dwVar;
        this.b.L(this.r, this.u);
        List list = this.r;
        dw dwVar2 = null;
        if (list.size() >= 2) {
            int i = 0;
            LatLng latLng = null;
            while (true) {
                if (i >= list.size()) {
                    dwVar = null;
                    break;
                }
                LatLng latLng2 = (LatLng) list.get(i);
                if (latLng != null && latLng2 != null && !com.google.android.libraries.navigation.internal.abf.r.a(latLng, latLng2)) {
                    dwVar = new dw(latLng, latLng2);
                    break;
                } else {
                    i++;
                    if (latLng == null) {
                        latLng = latLng2;
                    }
                }
            }
        } else {
            dwVar = null;
            break;
        }
        List list2 = this.r;
        if (list2.size() >= 2) {
            int size = list2.size() - 1;
            LatLng latLng3 = null;
            while (size >= 0) {
                LatLng latLng4 = (LatLng) list2.get(size);
                if (latLng3 != null && latLng4 != null && !com.google.android.libraries.navigation.internal.abf.r.a(latLng3, latLng4)) {
                    dwVar2 = new dw(latLng4, latLng3);
                    break;
                } else {
                    size--;
                    if (latLng3 == null) {
                        latLng3 = latLng4;
                    }
                }
            }
        }
        if (dwVar == null || this.r.size() < 2 || ((LatLng) this.r.get(0)).equals(gs.d(this.r))) {
            this.j.b();
            this.k.b();
            return;
        }
        h hVar = this.j;
        LatLng latLng5 = dwVar.b;
        LatLng latLng6 = dwVar.a;
        hVar.f(latLng6, com.google.android.libraries.navigation.internal.abh.bw.c(latLng5, latLng6));
        h hVar2 = this.k;
        LatLng latLng7 = dwVar2.b;
        hVar2.f(latLng7, com.google.android.libraries.navigation.internal.abh.bw.c(dwVar2.a, latLng7));
    }

    private final void m() {
        this.j.d(this.b.I());
    }

    private final void n() {
        Bitmap bitmapE;
        com.google.android.libraries.navigation.internal.ol.aq aqVarD;
        this.g.clear();
        this.g.addAll(this.b.K());
        this.h.clear();
        int i = 0;
        int i2 = 0;
        while (i2 < this.g.size()) {
            hm hmVar = (hm) this.g.get(i2);
            ic icVar = (ic) id.a.q();
            int iA = this.o.a(hmVar.a(), this.i);
            if (!icVar.b.H()) {
                icVar.v();
            }
            id idVar = (id) icVar.b;
            idVar.b |= 8;
            idVar.e = iA;
            Pair pairA = hmVar.a.a();
            int iIntValue = ((Integer) pairA.first).intValue();
            if (!icVar.b.H()) {
                icVar.v();
            }
            id idVar2 = (id) icVar.b;
            idVar2.b |= 1;
            idVar2.c = iIntValue;
            if (!((Integer) pairA.first).equals(pairA.second)) {
                int iIntValue2 = ((Integer) pairA.second).intValue();
                if (!icVar.b.H()) {
                    icVar.v();
                }
                id idVar3 = (id) icVar.b;
                idVar3.b |= 4;
                idVar3.d = iIntValue2;
            }
            if (((hm) this.g.get(i2)).e()) {
                if (i2 == 0) {
                    bitmapE = this.f136n.e(this.b.I().a());
                    i2 = i;
                } else {
                    bitmapE = null;
                }
                Bitmap bitmapE2 = i2 == this.g.size() + (-1) ? this.f136n.e(this.b.H().a()) : null;
                gw gwVar = ((hm) this.g.get(i2)).b;
                List list = this.h;
                gw gwVar2 = ((hm) this.g.get(i2)).b;
                Bitmap bitmap = gwVar2 == null ? null : gwVar2.b;
                if (gwVar != null && gwVar.a.a() && bitmap != null) {
                    df dfVar = this.c;
                    com.google.android.libraries.navigation.internal.ol.z zVar = this.a;
                    float fE = this.b.E();
                    com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
                    id idVar4 = (id) icVar.t();
                    ArrayList arrayList = new ArrayList();
                    com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) idVar4.aH(5, null);
                    bbVar.x(idVar4);
                    ic icVar2 = (ic) bbVar;
                    if (!icVar2.b.H()) {
                        icVar2.v();
                    }
                    id idVar5 = (id) icVar2.b;
                    idVar5.b |= 1;
                    idVar5.c = -1;
                    if (!icVar2.b.H()) {
                        icVar2.v();
                    }
                    id idVar6 = (id) icVar2.b;
                    idVar6.b |= 4;
                    idVar6.d = -1;
                    arrayList.add(new com.google.android.libraries.navigation.internal.ol.b((id) icVar2.t(), bitmap, bitmapE, bitmapE2));
                    aqVarD = zVar.e().e(dfVar.c.b(fE), arrayList);
                } else if (this.b.O() == null || !this.b.D()) {
                    df dfVar2 = this.c;
                    com.google.android.libraries.navigation.internal.ol.z zVar2 = this.a;
                    float fE2 = this.b.E();
                    com.google.android.libraries.navigation.internal.abf.s.k(zVar2, "phoenixGoogleMap");
                    id idVar7 = (id) icVar.t();
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new com.google.android.libraries.navigation.internal.ol.b(idVar7, null, bitmapE, bitmapE2));
                    if (bitmap != null) {
                        com.google.android.libraries.navigation.internal.ael.bb bbVar2 = (com.google.android.libraries.navigation.internal.ael.bb) idVar7.aH(5, null);
                        bbVar2.x(idVar7);
                        ic icVar3 = (ic) bbVar2;
                        if (!icVar3.b.H()) {
                            icVar3.v();
                        }
                        id idVar8 = (id) icVar3.b;
                        idVar8.b |= 1;
                        idVar8.c = -1;
                        if (!icVar3.b.H()) {
                            icVar3.v();
                        }
                        id idVar9 = (id) icVar3.b;
                        idVar9.b |= 4;
                        idVar9.d = -1;
                        arrayList2.add(new com.google.android.libraries.navigation.internal.ol.b((id) icVar3.t(), bitmap, bitmapE, bitmapE2));
                    }
                    aqVarD = zVar2.e().d(dfVar2.c.b(fE2), arrayList2);
                } else {
                    df dfVar3 = this.c;
                    com.google.android.libraries.navigation.internal.ol.z zVar3 = this.a;
                    fz fzVar = this.b;
                    PatternItem[] patternItemArrO = fzVar.O();
                    float fA = fzVar.J().a();
                    float f = this.i;
                    float fE3 = this.b.E();
                    com.google.android.libraries.navigation.internal.on.c cVar = new com.google.android.libraries.navigation.internal.on.c(fA, f);
                    com.google.android.libraries.navigation.internal.abf.s.k(zVar3, "phoenixGoogleMap");
                    com.google.android.libraries.navigation.internal.abf.s.k(patternItemArrO, "patternItems");
                    f fVar = dfVar3.c;
                    com.google.android.libraries.navigation.internal.abf.s.k(fVar, "conversionUtilsPhoenix");
                    id idVar10 = (id) icVar.t();
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(new com.google.android.libraries.navigation.internal.ol.b((id) icVar.t(), df.c(patternItemArrO, cVar), bitmapE, bitmapE2));
                    if (bitmap != null) {
                        com.google.android.libraries.navigation.internal.ael.bb bbVar3 = (com.google.android.libraries.navigation.internal.ael.bb) idVar10.aH(5, null);
                        bbVar3.x(idVar10);
                        ic icVar4 = (ic) bbVar3;
                        if (!icVar4.b.H()) {
                            icVar4.v();
                        }
                        id idVar11 = (id) icVar4.b;
                        idVar11.b |= 1;
                        idVar11.c = -1;
                        if (!icVar4.b.H()) {
                            icVar4.v();
                        }
                        id idVar12 = (id) icVar4.b;
                        idVar12.b |= 4;
                        idVar12.d = -1;
                        arrayList3.add(new com.google.android.libraries.navigation.internal.ol.b((id) icVar4.t(), bitmap, bitmapE, bitmapE2));
                    }
                    aqVarD = zVar3.e().d(fVar.b(fE3), arrayList3);
                }
                list.add(aqVarD);
            } else {
                List list2 = this.h;
                df dfVar4 = this.c;
                com.google.android.libraries.navigation.internal.ol.z zVar4 = this.a;
                float fE4 = this.b.E();
                com.google.android.libraries.navigation.internal.abf.s.k(zVar4, "phoenixGoogleMap");
                if (!icVar.b.H()) {
                    icVar.v();
                }
                id idVar13 = (id) icVar.b;
                idVar13.b |= 1;
                idVar13.c = i;
                list2.add(zVar4.e().d(dfVar4.c.b(fE4), ev.q(new com.google.android.libraries.navigation.internal.ol.b((id) icVar.t(), df.a, null, null))));
            }
            i2++;
            i = 0;
        }
    }

    private final void o() {
        float fA = this.b.J().a();
        this.j.h(fA);
        this.k.h(fA);
    }

    private final void p() {
        this.j.i(this.b.E());
        this.k.i(this.b.E());
    }

    @Override // com.google.android.libraries.navigation.internal.ol.as
    public final /* bridge */ /* synthetic */ void C(Object obj) {
        this.l.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.dt
            @Override // java.lang.Runnable
            public final void run() {
                dx dxVar = this.a;
                if (dxVar.d || !dxVar.b.N()) {
                    return;
                }
                dxVar.b.M();
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fy
    public final void c() {
        if (this.d) {
            return;
        }
        this.j.c();
        this.k.c();
        this.e = null;
        this.w.c(null);
        this.f.clear();
        Iterator it2 = this.s.iterator();
        while (it2.hasNext()) {
            ((com.google.android.libraries.navigation.internal.po.be) it2.next()).c(null);
        }
        this.x.c(null);
        this.y.c(null);
        this.v.d(new Runnable() { // from class: com.google.android.libraries.navigation.internal.abm.dv
            @Override // java.lang.Runnable
            public final void run() {
                int i = 0;
                while (true) {
                    dx dxVar = this.a;
                    if (i >= dxVar.h.size()) {
                        return;
                    }
                    dxVar.c.d(dxVar.a, ((com.google.android.libraries.navigation.internal.ol.aq) dxVar.h.get(i)).a());
                    i++;
                }
            }
        });
        this.d = true;
    }

    final List d() {
        e();
        int size = this.r.size();
        double[] dArr = new double[size + size];
        for (int i = 0; i < this.r.size(); i++) {
            int i2 = i + i;
            dArr[i2] = ((LatLng) this.r.get(i)).latitude;
            dArr[i2 + 1] = ((LatLng) this.r.get(i)).longitude;
        }
        if (this.u.isEmpty()) {
            com.google.android.libraries.navigation.internal.ol.aq aqVar = (com.google.android.libraries.navigation.internal.ol.aq) gs.e(this.h);
            fg fgVar = (fg) this.q.b;
            int i3 = fgVar.o;
            int i4 = fgVar.p;
            int iA = ff.a(fgVar.g);
            if (iA == 0) {
                iA = ff.b;
            }
            int i5 = iA;
            int iA2 = ff.a(((fg) this.q.b).h);
            if (iA2 == 0) {
                iA2 = ff.b;
            }
            int i6 = iA2;
            int iA3 = com.google.android.libraries.navigation.internal.adg.cz.a(((fg) this.q.b).i);
            if (iA3 == 0) {
                iA3 = com.google.android.libraries.navigation.internal.adg.cz.a;
            }
            return ev.q(com.google.android.libraries.navigation.internal.on.h.d(dArr, aqVar, i3, i4, i5, i6, iA3));
        }
        int size2 = this.u.size();
        int[] iArr = new int[size2];
        for (int i7 = 0; i7 < size2; i7++) {
            iArr[i7] = ((Integer) this.u.get(i7)).intValue();
        }
        List list = this.h;
        fg fgVar2 = (fg) this.q.b;
        int i8 = fgVar2.o;
        int i9 = fgVar2.p;
        int iA4 = ff.a(fgVar2.g);
        if (iA4 == 0) {
            iA4 = ff.b;
        }
        int i10 = iA4;
        int iA5 = ff.a(((fg) this.q.b).h);
        if (iA5 == 0) {
            iA5 = ff.b;
        }
        int i11 = iA5;
        int iA6 = com.google.android.libraries.navigation.internal.adg.cz.a(((fg) this.q.b).i);
        if (iA6 == 0) {
            iA6 = com.google.android.libraries.navigation.internal.adg.cz.a;
        }
        return com.google.android.libraries.navigation.internal.on.h.e(dArr, iArr, list, new ArrayList(), i8, i9, i10, i11, iA6, 0.0f);
    }

    public final void e() {
        synchronized (this) {
            if (this.t) {
                return;
            }
            this.t = true;
            fd fdVar = this.q;
            int i = ff.e;
            if (!fdVar.b.H()) {
                fdVar.v();
            }
            fg fgVar = (fg) fdVar.b;
            fg fgVar2 = fg.a;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            fgVar.g = i2;
            fgVar.b |= 4;
            fd fdVar2 = this.q;
            int i3 = ff.e;
            if (!fdVar2.b.H()) {
                fdVar2.v();
            }
            fg fgVar3 = (fg) fdVar2.b;
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            fgVar3.h = i4;
            fgVar3.b |= 8;
            fd fdVar3 = this.q;
            int i5 = this.m;
            if (!fdVar3.b.H()) {
                fdVar3.v();
            }
            fg fgVar4 = (fg) fdVar3.b;
            fgVar4.b |= 1024;
            fgVar4.o = i5;
            l();
            k();
            i();
            o();
            p();
            n();
            m();
            j();
            h();
        }
    }

    /* JADX WARN: Type inference failed for: r12v0, types: [com.google.android.libraries.navigation.internal.ol.av, com.google.android.libraries.navigation.internal.pp.h] */
    public final void f(Runnable runnable) {
        if (this.d) {
            return;
        }
        if (com.google.android.libraries.navigation.internal.afu.d.i()) {
            this.f.clear();
            for (fg fgVar : d()) {
                List list = this.f;
                com.google.android.libraries.navigation.internal.on.h hVar = this.p;
                com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) fgVar.aH(5, null);
                bbVar.x(fgVar);
                fd fdVar = (fd) bbVar;
                fdVar.C(com.google.android.libraries.geo.mapcore.internal.model.aw.e, true);
                list.add(((Cdo) hVar.c).j((fg) fdVar.t(), jr.WORLD_ENCODING_LAT_LNG_DOUBLE, hVar.d.i(), com.google.android.libraries.geo.mapcore.renderer.cg.CLIENT_INJECTED_DRAW_ORDER, com.google.android.libraries.navigation.internal.agg.fd.a, true));
            }
        } else {
            com.google.android.libraries.navigation.internal.on.h hVar2 = this.p;
            List listD = d();
            fh fhVar = (fh) fi.a.q();
            fhVar.c(listD);
            fi fiVar = (fi) fhVar.t();
            com.google.android.libraries.navigation.internal.ol.ak akVar = hVar2.c;
            Cdo cdo = (Cdo) akVar;
            Map map = cdo.c;
            ?? I = hVar2.d.i();
            com.google.android.libraries.navigation.internal.oe.o oVar = (com.google.android.libraries.navigation.internal.oe.o) map.get(jr.WORLD_ENCODING_LAT_LNG_DOUBLE);
            this.e = (oVar == null || I == 0) ? Cdo.a : new com.google.android.libraries.navigation.internal.po.ay(akVar, cdo.b, cdo.d, cdo.h, cdo.f, cdo.e, cdo.g.getResources().getDisplayMetrics().density, fiVar, null, I, oVar);
        }
        h();
        if (com.google.android.libraries.navigation.internal.afu.d.i()) {
            List list2 = this.f;
            List list3 = this.s;
            int size = list2.size();
            int size2 = list3.size();
            while (size2 < size) {
                this.s.add(this.v.e());
                size2++;
            }
            while (size2 > size) {
                List list4 = this.s;
                ((com.google.android.libraries.navigation.internal.po.be) list4.remove(list4.size() - 1)).a();
                size2--;
            }
            for (int i = 0; i < size; i++) {
                ((com.google.android.libraries.navigation.internal.po.be) this.s.get(i)).c((com.google.android.libraries.navigation.internal.ol.p) this.f.get(i));
            }
        } else {
            this.w.c(this.e);
        }
        this.x.c(this.j.a());
        this.y.c(this.k.a());
        this.v.d(runnable);
    }

    private final void k() {
        int iF = this.b.F();
        if (iF == 0) {
            fd fdVar = this.q;
            int i = com.google.android.libraries.navigation.internal.adg.cz.b;
            if (!fdVar.b.H()) {
                fdVar.v();
            }
            fg fgVar = (fg) fdVar.b;
            fg fgVar2 = fg.a;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            fgVar.i = i2;
            fgVar.b |= 16;
            return;
        }
        if (iF == 1) {
            fd fdVar2 = this.q;
            int i3 = com.google.android.libraries.navigation.internal.adg.cz.a;
            if (!fdVar2.b.H()) {
                fdVar2.v();
            }
            fg fgVar3 = (fg) fdVar2.b;
            fg fgVar4 = fg.a;
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            fgVar3.i = i4;
            fgVar3.b |= 16;
            return;
        }
        if (iF != 2) {
            fd fdVar3 = this.q;
            int i5 = com.google.android.libraries.navigation.internal.adg.cz.b;
            if (!fdVar3.b.H()) {
                fdVar3.v();
            }
            fg fgVar5 = (fg) fdVar3.b;
            fg fgVar6 = fg.a;
            int i6 = i5 - 1;
            if (i5 == 0) {
                throw null;
            }
            fgVar5.i = i6;
            fgVar5.b |= 16;
            return;
        }
        fd fdVar4 = this.q;
        int i7 = com.google.android.libraries.navigation.internal.adg.cz.c;
        if (!fdVar4.b.H()) {
            fdVar4.v();
        }
        fg fgVar7 = (fg) fdVar4.b;
        fg fgVar8 = fg.a;
        int i8 = i7 - 1;
        if (i7 == 0) {
            throw null;
        }
        fgVar7.i = i8;
        fgVar7.b |= 16;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fy
    public final void b(int i) {
        if (this.d) {
            return;
        }
        if (i == 0) {
            l();
            if (this.b.l().isEmpty()) {
                f(null);
                return;
            } else {
                g();
                return;
            }
        }
        if (i == 3) {
            o();
            g();
            return;
        }
        if (i != 4) {
            switch (i) {
                case 6:
                    break;
                case 7:
                    p();
                    g();
                    return;
                case 8:
                    m();
                    g();
                    return;
                case 9:
                    j();
                    g();
                    return;
                case 10:
                    k();
                    f(null);
                    return;
                case 11:
                    g();
                    return;
                case 12:
                    h();
                    return;
                case 13:
                    l();
                    g();
                    return;
                default:
                    throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.j(i, "Invalid notifyPropertyUpdated(", ")"));
            }
        }
        i();
        g();
    }
}
