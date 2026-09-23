package com.google.android.libraries.navigation.internal.bm;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.renderer.cn;
import com.google.android.libraries.navigation.NavigationView;
import com.google.android.libraries.navigation.internal.ace.fj;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.fg;
import com.google.android.libraries.navigation.internal.adr.fh;
import com.google.android.libraries.navigation.internal.adr.ii;
import com.google.android.libraries.navigation.internal.afl.bn;
import com.google.android.libraries.navigation.internal.afl.bo;
import com.google.android.libraries.navigation.internal.afl.fs;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.bp.bj;
import com.google.android.libraries.navigation.internal.bp.bk;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.bt;
import com.google.android.libraries.navigation.internal.bp.cc;
import com.google.android.libraries.navigation.internal.bp.cd;
import com.google.android.libraries.navigation.internal.bp.ce;
import com.google.android.libraries.navigation.internal.bp.cf;
import com.google.android.libraries.navigation.internal.ck.bb;
import com.google.android.libraries.navigation.internal.ck.cl;
import com.google.android.libraries.navigation.internal.ck.ct;
import com.google.android.libraries.navigation.internal.ck.cu;
import com.google.android.libraries.navigation.internal.ck.cv;
import com.google.android.libraries.navigation.internal.cl.be;
import com.google.android.libraries.navigation.internal.po.dh;
import com.google.android.libraries.navigation.internal.po.fk;
import com.google.android.libraries.navigation.internal.po.hi;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.de;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.ma;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ag implements aj {
    final /* synthetic */ com.google.android.libraries.navigation.internal.bt.h a;
    final /* synthetic */ am b;
    final /* synthetic */ m c;

    public ag(am amVar, com.google.android.libraries.navigation.internal.bt.h hVar, m mVar) {
        this.a = hVar;
        this.c = mVar;
        this.b = amVar;
    }

    static /* synthetic */ void a(ak akVar, ak akVar2) {
        if (akVar != null) {
            akVar.a();
        }
        akVar2.c();
    }

    /* JADX WARN: Code duplicated, block: B:361:0x0837 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:391:? A[Catch: all -> 0x0846, SYNTHETIC, TryCatch #4 {all -> 0x0846, blocks: (B:257:0x06fc, B:258:0x06ff, B:275:0x07d1, B:280:0x07de, B:281:0x07eb, B:278:0x07d9, B:307:0x082e, B:306:0x082b, B:322:0x0844, B:319:0x0840, B:318:0x083d, B:259:0x0705, B:261:0x070e, B:263:0x071a, B:269:0x073d, B:271:0x0741, B:273:0x0752, B:272:0x074c, B:265:0x071e, B:267:0x0726, B:268:0x0729, B:302:0x0825, B:314:0x0837), top: B:348:0x05b1, inners: #1, #5, #11 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r36v1 */
    /* JADX WARN: Type inference failed for: r36v10 */
    /* JADX WARN: Type inference failed for: r36v2 */
    /* JADX WARN: Type inference failed for: r36v3 */
    /* JADX WARN: Type inference failed for: r36v4 */
    /* JADX WARN: Type inference failed for: r36v5 */
    /* JADX WARN: Type inference failed for: r36v6 */
    /* JADX WARN: Type inference failed for: r36v7 */
    /* JADX WARN: Type inference failed for: r36v8 */
    /* JADX WARN: Type inference failed for: r36v9, types: [com.google.android.libraries.navigation.internal.cn.o] */
    @Override // com.google.android.libraries.navigation.internal.bm.aj
    public final void b(com.google.android.libraries.navigation.internal.bq.a aVar) throws Throwable {
        com.google.android.libraries.navigation.internal.bo.t tVar;
        ?? r36;
        Throwable th;
        boolean zC;
        com.google.android.libraries.navigation.internal.bo.z zVar;
        ii iiVar;
        ah ahVar;
        int i;
        int i2;
        ev evVar;
        ev evVarO;
        int i3;
        com.google.android.libraries.navigation.internal.nj.i.b();
        synchronized (this.b.U) {
            if (this != this.b.V.b) {
                return;
            }
            am amVar = this.b;
            com.google.android.libraries.navigation.internal.ob.r rVar = com.google.android.libraries.navigation.internal.ob.r.f;
            Rect rect = new Rect();
            amVar.k.f(rVar, rect);
            final am amVar2 = this.b;
            ev evVar2 = aVar.a;
            com.google.android.libraries.navigation.internal.bt.h hVar = this.a;
            boolean zP = amVar2.p(hVar);
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("createTripRouteOverlayList");
            final boolean z = ((com.google.android.libraries.navigation.internal.bt.b) hVar).A;
            com.google.android.libraries.navigation.internal.bt.b bVar = (com.google.android.libraries.navigation.internal.bt.b) hVar;
            bh bhVar = bVar.a;
            try {
                int i4 = ev.d;
                eq eqVar = new eq();
                ah ahVar2 = new ah(amVar2);
                no it2 = evVar2.iterator();
                while (it2.hasNext()) {
                    try {
                        com.google.android.libraries.navigation.internal.bp.ay ayVar = (com.google.android.libraries.navigation.internal.bp.ay) it2.next();
                        long j = ayVar.a().Y;
                        ev evVarD = bVar.q ? am.d(bhVar, ayVar.a(), amVar2.f345n, amVar2.ad) : lv.a;
                        Map map = (Map) amVar2.O.get(Long.valueOf(j));
                        if (map == null) {
                            map = ma.b;
                        }
                        Map map2 = map;
                        amVar2.i.I();
                        com.google.android.libraries.navigation.internal.pi.s sVar = amVar2.c;
                        com.google.android.libraries.navigation.internal.oa.e eVarB = amVar2.i.b();
                        com.google.android.libraries.navigation.internal.oo.b bVar2 = amVar2.j;
                        no noVar = it2;
                        com.google.android.libraries.navigation.internal.cr.f fVar = amVar2.aj;
                        ah ahVar3 = ahVar2;
                        com.google.android.libraries.navigation.internal.qk.w wVar = amVar2.ag;
                        eq eqVar2 = eqVar;
                        Context context = amVar2.l;
                        bh bhVar2 = bhVar;
                        com.google.android.libraries.geo.mapcore.renderer.ax axVarH = amVar2.i.h();
                        com.google.android.libraries.navigation.internal.bt.b bVar3 = bVar;
                        cl clVar = amVar2.C;
                        Rect rect2 = rect;
                        boolean z2 = amVar2.t;
                        boolean z3 = z2 ? amVar2.ah == com.google.android.libraries.navigation.internal.rw.p.GUIDING : zP;
                        boolean zC2 = amVar2.F.c();
                        com.google.android.libraries.navigation.internal.mj.a aVar2 = amVar2.x;
                        com.google.android.libraries.navigation.internal.fz.d dVar = amVar2.f345n;
                        boolean z4 = ((fj) amVar2.o.b()).c;
                        com.google.android.libraries.navigation.internal.iv.f fVar2 = amVar2.s;
                        ayVar.a();
                        com.google.android.libraries.navigation.internal.cq.ag agVarC = am.c(j, amVar2.P);
                        br brVar = new br() { // from class: com.google.android.libraries.navigation.internal.bm.v
                            @Override // com.google.android.libraries.navigation.internal.yx.br
                            public final Object a() {
                                NavigationView.a().booleanValue();
                                return false;
                            }
                        };
                        com.google.android.libraries.navigation.internal.dx.i iVar = amVar2.ad;
                        r36 = amVar2.ae;
                        am amVar3 = amVar2;
                        ah ahVar4 = ahVar3;
                        boolean z5 = z;
                        com.google.android.libraries.navigation.internal.bo.ao aoVar = new com.google.android.libraries.navigation.internal.bo.ao(sVar, ayVar, eVarB, bVar2, fVar, wVar, context, axVarH, clVar, z2, z3, zC2, evVarD, rect2, aVar2, dVar, z4, fVar2, map2, agVarC, brVar, iVar, ahVar4, r36, amVar2.Q, false);
                        eq eqVar3 = new eq();
                        if (aoVar.D != 3) {
                            aoVar.j.clear();
                            int i5 = aoVar.D == 1 ? 1 : 0;
                            bg bgVar = aoVar.q;
                            bj bjVar = aoVar.r;
                            com.google.android.libraries.navigation.internal.fz.d dVar2 = aoVar.w;
                            ArrayList arrayList = new ArrayList();
                            ArrayList arrayList2 = new ArrayList();
                            com.google.android.libraries.navigation.internal.ady.al alVar = bgVar.j;
                            if (alVar == com.google.android.libraries.navigation.internal.ady.al.DRIVE || alVar == com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER) {
                                i = 0;
                                i2 = bgVar.B().size() > 2 ? 1 : i;
                            } else if (alVar == com.google.android.libraries.navigation.internal.ady.al.BICYCLE || alVar == com.google.android.libraries.navigation.internal.ady.al.WALK) {
                                cf cfVar = bgVar.g;
                                if (cfVar.b() > 1) {
                                    i = 0;
                                } else if (cfVar.b() == 1) {
                                    i = 0;
                                    if (cfVar.c(0).a() > 1) {
                                    }
                                } else {
                                    i = 0;
                                }
                            } else {
                                i = 0;
                                i2 = 0;
                            }
                            List listN = bgVar.N();
                            ArrayList arrayList3 = new ArrayList(bgVar.m());
                            com.google.android.libraries.navigation.internal.ady.al alVar2 = bgVar.j;
                            if (alVar2 == com.google.android.libraries.navigation.internal.ady.al.DRIVE || alVar2 == com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER) {
                                ahVar = ahVar4;
                                bq[] bqVarArrAa = bgVar.aa();
                                com.google.android.libraries.navigation.internal.yx.ar.a(bqVarArrAa.length == bgVar.m() + (-1));
                                com.google.android.libraries.navigation.internal.oe.x xVarL = bjVar.d().l(0);
                                bgVar.v(0);
                                evVar = null;
                                arrayList3.add(new bb(xVarL, null));
                                int i6 = 0;
                                while (i6 < bqVarArrAa.length) {
                                    int i7 = bqVarArrAa[i6].k;
                                    if (i7 >= 0 && i7 < listN.size()) {
                                        bgVar.v(i6 + 1);
                                        com.google.android.libraries.navigation.internal.oe.x xVar = (com.google.android.libraries.navigation.internal.oe.x) listN.get(i7);
                                        if (i6 == 0) {
                                            i6 = 0;
                                        }
                                        arrayList3.add(new bb(xVar, null));
                                    }
                                    i6++;
                                }
                            } else {
                                cf cfVar2 = bgVar.g;
                                if (alVar2 == com.google.android.libraries.navigation.internal.ady.al.TAXI && cfVar2.b() == 0) {
                                    arrayList3.add(new bb((com.google.android.libraries.navigation.internal.oe.x) listN.get(i)));
                                }
                                bo boVar = dVar2.D().h;
                                if (boVar == null) {
                                    boVar = bo.a;
                                }
                                int iA = bn.a(boVar.b);
                                if (iA == 0) {
                                    iA = bn.a;
                                }
                                int i8 = iA != bn.c ? i : 1;
                                int i9 = i;
                                int i10 = i9;
                                while (i9 < cfVar2.b()) {
                                    com.google.android.libraries.navigation.internal.bp.av avVarC = cfVar2.c(i9);
                                    ah ahVar5 = ahVar4;
                                    int i11 = i;
                                    int i12 = i11;
                                    while (i12 < avVarC.a()) {
                                        bt btVarB = avVarC.b(i12);
                                        cf cfVar3 = cfVar2;
                                        com.google.android.libraries.navigation.internal.bp.av avVar = avVarC;
                                        bq bqVarB = btVarB.b(0, i11, 0);
                                        i11++;
                                        if (btVarB.j()) {
                                            if (i8 != 0) {
                                                i10 = 1;
                                            } else {
                                                i3 = 0;
                                            }
                                            i12++;
                                            cfVar2 = cfVar3;
                                            avVarC = avVar;
                                        } else {
                                            i3 = i8;
                                        }
                                        if (i10 == 0 || i3 == 0) {
                                            int i13 = bqVarB.k;
                                            if (i13 >= 0 && i13 < listN.size()) {
                                                arrayList3.add(new bb((com.google.android.libraries.navigation.internal.oe.x) listN.get(i13)));
                                            }
                                        } else {
                                            i10 = 0;
                                        }
                                        i12++;
                                        cfVar2 = cfVar3;
                                        avVarC = avVar;
                                    }
                                    i9++;
                                    ahVar4 = ahVar5;
                                    i = 0;
                                }
                                ahVar = ahVar4;
                                if (i10 == 0) {
                                    arrayList3.add(new bb((com.google.android.libraries.navigation.internal.oe.x) gs.d(listN)));
                                }
                                evVar = null;
                            }
                            int i14 = i5 ^ 1;
                            int size = i5 != 0 ? arrayList3.size() : arrayList3.size() - 1;
                            int i15 = 1;
                            while (i14 < size) {
                                com.google.android.libraries.navigation.internal.oe.r rVarT = ((bb) arrayList3.get(i14)).a.t();
                                if (i2 == 0 || i14 == 0) {
                                    arrayList.add(new com.google.android.libraries.navigation.internal.ck.ay(rVarT, i14 == 0 ? 1 : i14 == arrayList3.size() + (-1) ? 3 : 2));
                                } else {
                                    arrayList2.add(new com.google.android.libraries.navigation.internal.ck.ad(rVarT, i15));
                                    i15++;
                                }
                                i14++;
                            }
                            arrayList.addAll(arrayList2);
                            if (bgVar.j == com.google.android.libraries.navigation.internal.ady.al.TRANSIT) {
                                bo boVar2 = dVar2.D().h;
                                if (boVar2 == null) {
                                    boVar2 = bo.a;
                                }
                                int iA2 = bn.a(boVar2.b);
                                if (iA2 == 0) {
                                    iA2 = bn.a;
                                }
                                if (iA2 != bn.c) {
                                    ArrayList arrayList4 = new ArrayList();
                                    ce ceVarS = bgVar.s();
                                    int length = ceVarS.a.length;
                                    for (int i16 = 0; i16 < length; i16++) {
                                        cc ccVar = ceVarS.a[i16];
                                        ev evVarO2 = ccVar == null ? evVar : ev.o(ccVar.a);
                                        if (evVarO2 != null) {
                                            for (int i17 = 1; i17 < evVarO2.size() - 1; i17++) {
                                                cd cdVar = (cd) evVarO2.get(i17);
                                                arrayList4.add(new cv(cdVar.b.a.t(), ct.c(cdVar.f), cu.INTERMEDIATE));
                                            }
                                        }
                                    }
                                    evVarO = ev.o(arrayList4);
                                } else {
                                    evVarO = lv.a;
                                }
                            } else {
                                evVarO = lv.a;
                            }
                            arrayList.addAll(evVarO);
                            Iterator it3 = arrayList.iterator();
                            while (it3.hasNext()) {
                                eqVar3.h(((com.google.android.libraries.navigation.internal.ck.ba) it3.next()).a(aoVar.g, cn.POLYLINE_MEASLES.a()));
                            }
                        } else {
                            ahVar = ahVar4;
                        }
                        aoVar.h = eqVar3.g();
                        aoVar.i = new com.google.android.libraries.navigation.internal.bo.g(aoVar.u, aoVar.h, aoVar.b, aoVar.f, aoVar.v.h());
                        aoVar.u.f(aoVar.i);
                        com.google.android.libraries.navigation.internal.ck.s sVar2 = aoVar.t;
                        if (sVar2 != null) {
                            sVar2.a();
                        }
                        aoVar.u.o();
                        aoVar.a.b();
                        aoVar.k.e();
                        eqVar2.h(aoVar);
                        eqVar = eqVar2;
                        ahVar2 = ahVar;
                        it2 = noVar;
                        amVar2 = amVar3;
                        bhVar = bhVar2;
                        bVar = bVar3;
                        z = z5;
                        rect = rect2;
                    } catch (Throwable th2) {
                        th = th2;
                        Throwable th3 = th;
                        if (dVarB == null) {
                            throw th3;
                        }
                        try {
                            Trace.endSection();
                            throw th3;
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                            throw th3;
                        }
                    }
                }
                Rect rect3 = rect;
                ev evVarG = eqVar.g();
                if (dVarB != null) {
                    Trace.endSection();
                }
                am amVar4 = this.b;
                ev evVar3 = aVar.a;
                com.google.android.libraries.navigation.internal.bt.h hVar2 = this.a;
                eq eqVar4 = new eq();
                com.google.android.libraries.navigation.internal.oa.e eVarB2 = amVar4.i.b();
                ev evVar4 = lv.a;
                com.google.android.libraries.navigation.internal.bo.a aVar3 = new com.google.android.libraries.navigation.internal.bo.a();
                com.google.android.libraries.navigation.internal.fz.d dVar3 = amVar4.f345n;
                Objects.requireNonNull(dVar3);
                aVar3.a = dVar3;
                Context context2 = amVar4.l;
                Objects.requireNonNull(context2);
                aVar3.b = context2;
                com.google.android.libraries.navigation.internal.ci.a aVar4 = amVar4.ai;
                Objects.requireNonNull(aVar4);
                aVar3.u = aVar4;
                com.google.android.libraries.navigation.internal.bn.d dVar4 = amVar4.b;
                Objects.requireNonNull(dVar4);
                aVar3.c = dVar4;
                Objects.requireNonNull(evVar3);
                aVar3.d = evVar3;
                com.google.android.libraries.navigation.internal.bt.b bVar4 = (com.google.android.libraries.navigation.internal.bt.b) hVar2;
                aVar3.e = bVar4.f;
                aVar3.f = false;
                aVar3.t = (byte) 1;
                com.google.android.libraries.navigation.internal.bt.g gVar = bVar4.o;
                Objects.requireNonNull(gVar);
                aVar3.g = gVar;
                aVar3.h = rect3;
                com.google.android.libraries.navigation.internal.hn.r rVar2 = amVar4.o;
                Objects.requireNonNull(rVar2);
                aVar3.i = rVar2;
                fk fkVar = (fk) eVarB2;
                com.google.android.libraries.navigation.internal.po.d dVar5 = fkVar.F;
                Objects.requireNonNull(dVar5);
                aVar3.j = dVar5;
                dh dhVar = fkVar.H;
                Objects.requireNonNull(dhVar);
                aVar3.k = dhVar;
                hi hiVar = fkVar.I;
                Objects.requireNonNull(hiVar);
                aVar3.l = hiVar;
                com.google.android.libraries.navigation.internal.on.h hVarA = eVarB2.a();
                Objects.requireNonNull(hVarA);
                aVar3.m = hVarA;
                com.google.android.libraries.navigation.internal.op.i iVarG = amVar4.j.g();
                Objects.requireNonNull(iVarG);
                aVar3.f347n = iVarG;
                com.google.android.libraries.navigation.internal.qk.n nVar = fkVar.K;
                Objects.requireNonNull(nVar);
                aVar3.o = nVar;
                com.google.android.libraries.navigation.internal.qk.w wVar2 = amVar4.ag;
                Objects.requireNonNull(wVar2);
                aVar3.p = wVar2;
                com.google.android.libraries.navigation.internal.cr.f fVar3 = amVar4.aj;
                Objects.requireNonNull(fVar3);
                aVar3.v = fVar3;
                com.google.android.libraries.navigation.internal.pi.s sVar3 = amVar4.c;
                Objects.requireNonNull(sVar3);
                aVar3.q = sVar3;
                com.google.android.libraries.navigation.internal.ot.h hVarI = amVar4.j.i();
                Objects.requireNonNull(hVarI);
                aVar3.r = hVarI;
                com.google.android.libraries.navigation.internal.yx.ar.q(evVar4);
                Objects.requireNonNull(evVar4);
                aVar3.s = evVar4;
                if (aVar3.t != 1 || aVar3.a == null || aVar3.b == null || aVar3.u == null || aVar3.c == null || aVar3.d == null || aVar3.g == null || aVar3.h == null || aVar3.i == null || aVar3.j == null || aVar3.k == null || aVar3.l == null || aVar3.m == null || aVar3.f347n == null || aVar3.o == null || aVar3.p == null || aVar3.v == null || aVar3.q == null || aVar3.r == null || aVar3.s == null) {
                    throw new IllegalStateException();
                }
                ev evVar5 = amVar4.ac;
                int size2 = evVar5.size();
                for (int i18 = 0; i18 < size2; i18++) {
                    eqVar4.h(((com.google.android.libraries.navigation.internal.bo.n) evVar5.get(i18)).a());
                }
                ev evVarG2 = eqVar4.g();
                if ((((fs) this.b.al.a.b()).aR || ((fs) this.b.al.a.b()).aS) && ((com.google.android.libraries.navigation.internal.bt.b) this.a).a.k() && ((com.google.android.libraries.navigation.internal.bt.b) this.a).a.f().j != com.google.android.libraries.navigation.internal.ady.al.WALK) {
                    bg bgVarF = ((com.google.android.libraries.navigation.internal.bt.b) this.a).a.f();
                    ev evVarO3 = ev.o(bgVarF.g.a.k);
                    am amVar5 = this.b;
                    tVar = new com.google.android.libraries.navigation.internal.bo.t(evVarO3, ((fk) amVar5.i.b()).H, amVar5.j.i(), bgVarF, new com.google.android.libraries.navigation.internal.cm.b(), amVar5.g, amVar5.ah, ((fj) amVar5.o.b()).c);
                } else {
                    tVar = null;
                }
                Object obj = this.b.X;
                synchronized (obj) {
                    try {
                        try {
                            am amVar6 = this.b;
                            final ak akVar = amVar6.Y;
                            amVar6.g();
                            ev evVar6 = aVar.a;
                            com.google.android.libraries.navigation.internal.sg.a aVar5 = this.b.K;
                            com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("createDirectionsRouteOverlay");
                            try {
                                if (this.b.j.s().c()) {
                                    try {
                                        zC = ((com.google.android.libraries.navigation.internal.ok.b) this.b.u.a()).c(com.google.android.libraries.navigation.internal.ob.h.SATELLITE);
                                    } catch (Throwable th5) {
                                        th = th5;
                                        r36 = obj;
                                        if (dVarB2 != null) {
                                            throw th;
                                        }
                                        try {
                                            Trace.endSection();
                                            throw th;
                                        } catch (Throwable th6) {
                                            th.addSuppressed(th6);
                                            throw th;
                                        }
                                    }
                                } else {
                                    zC = this.b.i.J(com.google.android.libraries.navigation.internal.ob.h.SATELLITE);
                                }
                                boolean z6 = zC;
                                am amVar7 = this.b;
                                com.google.android.libraries.navigation.internal.afo.a aVar6 = amVar7.r;
                                boolean zF = aVar6 != null ? ((com.google.android.libraries.navigation.internal.oi.c) aVar6.a()).f() : amVar7.i.K();
                                am amVar8 = this.b;
                                com.google.android.libraries.navigation.internal.pi.s sVar4 = amVar8.c;
                                Resources resources = amVar8.l.getResources();
                                bq bqVar = ((com.google.android.libraries.navigation.internal.bt.b) this.a).f;
                                com.google.android.libraries.navigation.internal.oa.e eVarB3 = this.b.i.b();
                                boolean zP2 = this.b.p(this.a);
                                am amVar9 = this.b;
                                boolean z7 = amVar9.t;
                                boolean z8 = ((com.google.android.libraries.navigation.internal.bt.b) this.a).r;
                                com.google.android.libraries.navigation.internal.up.g gVar2 = amVar9.m;
                                com.google.android.libraries.navigation.internal.cl.ba baVar = (com.google.android.libraries.navigation.internal.cl.ba) amVar9.v.a();
                                boolean z9 = this.b.f345n.C().g;
                                be beVar = (be) this.a.n().a();
                                boolean z10 = ((com.google.android.libraries.navigation.internal.bt.b) this.a).z;
                                am amVar10 = this.b;
                                com.google.android.libraries.navigation.environment.ct ctVar = amVar10.am;
                                com.google.android.libraries.navigation.internal.fz.d dVar6 = amVar10.f345n;
                                Context context3 = amVar10.l;
                                com.google.android.libraries.navigation.internal.iv.f fVar4 = amVar10.s;
                                com.google.android.libraries.navigation.internal.op.i iVar2 = amVar10.af;
                                com.google.android.libraries.navigation.internal.qk.w wVar3 = amVar10.ag;
                                com.google.android.libraries.navigation.internal.cr.f fVar5 = amVar10.aj;
                                boolean z11 = ((fj) amVar10.o.b()).c;
                                this.b.i.I();
                                r36 = obj;
                                try {
                                    com.google.android.libraries.navigation.internal.bo.e eVar = new com.google.android.libraries.navigation.internal.bo.e(sVar4, evVar6, resources, bqVar, eVarB3, tVar, zP2, zF, z6, z7, z8, rect3, gVar2, baVar, z9, beVar, z10, ctVar, aVar5, dVar6, context3, fVar4, iVar2, wVar3, fVar5, z11, false, this.b.Q);
                                    eVar.d(this.a.R());
                                    bk bkVar = this.b.G;
                                    if (bkVar != null) {
                                        eVar.f(bkVar);
                                    }
                                    Boolean bool = this.b.H;
                                    if (bool != null) {
                                        eVar.e(bool.booleanValue());
                                    }
                                    if (dVarB2 != null) {
                                        Trace.endSection();
                                    }
                                    com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("maybeCreateTrafficVisualizationOverlay");
                                    try {
                                        com.google.android.libraries.navigation.internal.bt.h hVar3 = this.a;
                                        if (((com.google.android.libraries.navigation.internal.bt.b) hVar3).q) {
                                            am amVar11 = this.b;
                                            bh bhVar3 = ((com.google.android.libraries.navigation.internal.bt.b) hVar3).a;
                                            ev evVarF = (bhVar3.k() && (iiVar = bhVar3.f().u) != null) ? de.d(iiVar.h).c(new com.google.android.libraries.navigation.internal.yx.as() { // from class: com.google.android.libraries.navigation.internal.bm.u
                                                @Override // com.google.android.libraries.navigation.internal.yx.as
                                                public final boolean a(Object obj2) {
                                                    el elVar = (el) obj2;
                                                    int i19 = am.an;
                                                    if (elVar == null) {
                                                        return false;
                                                    }
                                                    fg fgVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).k;
                                                    if (fgVar == null) {
                                                        fgVar = fg.a;
                                                    }
                                                    return fgVar.c == 1;
                                                }
                                            }).f() : lv.a;
                                            ev evVar7 = evVarF;
                                            com.google.android.libraries.navigation.internal.afo.a aVar7 = amVar11.r;
                                            boolean zF2 = aVar7 != null ? ((com.google.android.libraries.navigation.internal.oi.c) aVar7.a()).f() : amVar11.i.K();
                                            com.google.android.libraries.navigation.internal.oa.k kVar = amVar11.i;
                                            com.google.android.libraries.navigation.internal.bo.z zVar2 = new com.google.android.libraries.navigation.internal.bo.z(evVar7, amVar11.j, amVar11.ag, amVar11.aj, ((fk) kVar.b()).G, ((fk) kVar.b()).I, ((fk) kVar.b()).H, ((fk) kVar.b()).K, new com.google.android.libraries.navigation.internal.on.h(((fk) kVar.b()).J), amVar11.l, amVar11.f, kVar.k.i(), zF2, new ai(amVar11), amVar11.f345n, amVar11.ad, ((fj) amVar11.o.b()).c);
                                            if (dVarB3 != null) {
                                                Trace.endSection();
                                            }
                                            zVar = zVar2;
                                        } else {
                                            if (dVarB3 != null) {
                                                Trace.endSection();
                                            }
                                            zVar = null;
                                        }
                                        final ak akVar2 = new ak(eVar, evVarG, zVar, evVarG2);
                                        this.b.Y = akVar2;
                                        synchronized (this.b.U) {
                                            an anVar = this.b.V;
                                            if (this == anVar.b) {
                                                anVar.c = true;
                                            }
                                        }
                                        synchronized (this.b.X) {
                                            this.b.h.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.bm.af
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    ag.a(akVar, akVar2);
                                                }
                                            });
                                            this.c.a(this.a, aVar);
                                        }
                                    } catch (Throwable th7) {
                                        if (dVarB3 == null) {
                                            throw th7;
                                        }
                                        try {
                                            Trace.endSection();
                                            throw th7;
                                        } catch (Throwable th8) {
                                            th7.addSuppressed(th8);
                                            throw th7;
                                        }
                                    }
                                } catch (Throwable th9) {
                                    th = th9;
                                    th = th;
                                    r36 = r36;
                                    if (dVarB2 != null) {
                                        throw th;
                                    }
                                    Trace.endSection();
                                    throw th;
                                }
                            } catch (Throwable th10) {
                                th = th10;
                                r36 = obj;
                            }
                        } catch (Throwable th11) {
                            th = th11;
                            r36 = obj;
                            throw th;
                        }
                    } catch (Throwable th12) {
                        th = th12;
                        throw th;
                    }
                }
            } catch (Throwable th13) {
                th = th13;
            }
        }
    }
}
