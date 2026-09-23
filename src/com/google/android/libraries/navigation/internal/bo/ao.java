package com.google.android.libraries.navigation.internal.bo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.SparseArray;
import com.google.android.libraries.geo.mapcore.renderer.ax;
import com.google.android.libraries.navigation.internal.adf.m;
import com.google.android.libraries.navigation.internal.adf.n;
import com.google.android.libraries.navigation.internal.adg.Cdo;
import com.google.android.libraries.navigation.internal.adg.cx;
import com.google.android.libraries.navigation.internal.adg.dp;
import com.google.android.libraries.navigation.internal.adg.dq;
import com.google.android.libraries.navigation.internal.adg.dt;
import com.google.android.libraries.navigation.internal.adg.dy;
import com.google.android.libraries.navigation.internal.adg.fr;
import com.google.android.libraries.navigation.internal.adg.fs;
import com.google.android.libraries.navigation.internal.adg.fu;
import com.google.android.libraries.navigation.internal.adg.jr;
import com.google.android.libraries.navigation.internal.adl.ad;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.adr.ee;
import com.google.android.libraries.navigation.internal.adr.ef;
import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.adr.ex;
import com.google.android.libraries.navigation.internal.adr.fb;
import com.google.android.libraries.navigation.internal.adr.ff;
import com.google.android.libraries.navigation.internal.adr.fg;
import com.google.android.libraries.navigation.internal.adr.fh;
import com.google.android.libraries.navigation.internal.adr.fp;
import com.google.android.libraries.navigation.internal.adr.gn;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.afl.nz;
import com.google.android.libraries.navigation.internal.afl.oa;
import com.google.android.libraries.navigation.internal.bp.ap;
import com.google.android.libraries.navigation.internal.bp.ay;
import com.google.android.libraries.navigation.internal.bp.bg;
import com.google.android.libraries.navigation.internal.bp.bj;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.ck.cd;
import com.google.android.libraries.navigation.internal.ck.ck;
import com.google.android.libraries.navigation.internal.ck.cl;
import com.google.android.libraries.navigation.internal.cl.aq;
import com.google.android.libraries.navigation.internal.cl.aw;
import com.google.android.libraries.navigation.internal.cl.az;
import com.google.android.libraries.navigation.internal.po.fk;
import com.google.android.libraries.navigation.internal.po.hi;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.as;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yz.ek;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fw;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.android.libraries.navigation.internal.yz.ma;
import com.google.android.libraries.navigation.internal.yz.mb;
import com.google.android.libraries.navigation.internal.yz.nn;
import com.google.android.libraries.navigation.internal.yz.no;
import j$.time.Duration;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ao {
    public static final /* synthetic */ int F = 0;
    private static final ev G = ev.t(com.google.android.libraries.navigation.internal.adg.b.BOTTOM_RIGHT, com.google.android.libraries.navigation.internal.adg.b.BOTTOM_LEFT, com.google.android.libraries.navigation.internal.adg.b.TOP_RIGHT, com.google.android.libraries.navigation.internal.adg.b.TOP_LEFT);
    public Map A;
    public com.google.android.libraries.navigation.internal.cq.ag B;
    public volatile ev C;
    public final int D;
    public final com.google.android.libraries.navigation.internal.bm.ah E;
    private final boolean H;
    private final boolean I;
    private final boolean J;
    private final boolean K;
    private final boolean L;
    private final boolean M;
    private final Resources N;

    @Deprecated
    private volatile fd O;
    private volatile ev P;
    private int Q;
    private final aq R;
    private final com.google.android.libraries.navigation.internal.oa.e S;
    private final com.google.android.libraries.navigation.internal.oj.l T;
    private final com.google.android.libraries.navigation.internal.op.i U;
    private final com.google.android.libraries.navigation.internal.qk.w V;
    private final boolean W;
    private final com.google.android.libraries.navigation.internal.cr.f X;
    public final cd a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final com.google.android.libraries.navigation.internal.ady.al e;
    public final boolean f;
    public final cl g;
    public ev h;
    public g i;
    public final SparseArray j;
    public final com.google.android.libraries.navigation.internal.cl.t k;
    public final fd l;
    public fy m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.ot.k f348n;
    public volatile ev o;
    public String p;
    public final bg q;
    public final bj r;
    public final com.google.android.libraries.navigation.internal.pi.s s;
    public com.google.android.libraries.navigation.internal.ck.s t;
    public final ax u;
    public final com.google.android.libraries.navigation.internal.oo.b v;
    public final com.google.android.libraries.navigation.internal.fz.d w;
    public final com.google.android.libraries.navigation.internal.cn.o x;
    public final com.google.android.libraries.navigation.internal.dx.i y;
    public int z;

    /* JADX WARN: Multi-variable type inference failed */
    public ao(com.google.android.libraries.navigation.internal.pi.s sVar, ay ayVar, com.google.android.libraries.navigation.internal.oa.e eVar, com.google.android.libraries.navigation.internal.oo.b bVar, com.google.android.libraries.navigation.internal.cr.f fVar, com.google.android.libraries.navigation.internal.qk.w wVar, Context context, ax axVar, cl clVar, boolean z, boolean z2, boolean z3, List list, Rect rect, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.fz.d dVar, boolean z4, com.google.android.libraries.navigation.internal.iv.f fVar2, Map map, com.google.android.libraries.navigation.internal.cq.ag agVar, br brVar, com.google.android.libraries.navigation.internal.dx.i iVar, com.google.android.libraries.navigation.internal.bm.ah ahVar, com.google.android.libraries.navigation.internal.cn.o oVar, int i, boolean z5) {
        fk fkVar;
        int i2;
        int i3;
        int i4 = ev.d;
        this.h = lv.a;
        this.i = null;
        this.j = new SparseArray();
        this.m = mb.a;
        this.o = lv.a;
        this.O = ma.b;
        this.P = lv.a;
        this.Q = 0;
        this.A = ma.b;
        this.B = null;
        this.C = null;
        this.s = sVar;
        this.u = axVar;
        this.N = context.getResources();
        this.g = clVar;
        this.f = z;
        this.b = z2;
        this.c = ayVar.d();
        this.I = dVar.D().d;
        boolean z6 = dVar.D().e;
        this.J = z6;
        this.K = z6 && dVar.p().p;
        this.d = false;
        this.L = false;
        this.M = z3;
        fk fkVar2 = (fk) eVar;
        fk fkVar3 = fkVar2;
        int i5 = 0;
        this.k = new com.google.android.libraries.navigation.internal.cl.t(context, fkVar2.I, bVar.g(), z3, z, fVar2, dVar, aVar, iVar);
        this.S = eVar;
        hi hiVar = fkVar3.I;
        com.google.android.libraries.navigation.internal.oj.l lVar = com.google.android.libraries.navigation.internal.oj.l.a;
        this.T = new com.google.android.libraries.navigation.internal.oj.j(hiVar);
        this.v = bVar;
        this.X = fVar;
        this.U = bVar.g();
        this.V = wVar;
        this.w = dVar;
        this.H = z4;
        this.e = ayVar.a().j;
        this.A = map;
        this.B = agVar;
        this.E = ahVar;
        this.x = oVar;
        this.y = iVar;
        this.W = false;
        if (ayVar.d()) {
            this.D = 1;
        } else {
            ayVar.e();
            this.D = 3;
        }
        if (z) {
            ((Boolean) brVar.a()).booleanValue();
        }
        if (list.isEmpty()) {
            fkVar = fkVar3;
            this.l = ma.b;
            this.f348n = null;
        } else {
            ez ezVar = new ez();
            fw fwVar = new fw();
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                el elVar = (el) it2.next();
                fh fhVar = elVar.c == 22 ? (fh) elVar.d : fh.a;
                fy fyVarC = com.google.android.libraries.navigation.internal.br.l.c(elVar);
                fwVar.k(fyVarC);
                com.google.android.libraries.navigation.internal.aap.d dVar2 = fhVar.d;
                if ((dVar2 == null ? com.google.android.libraries.navigation.internal.aap.d.a : dVar2).c > 0) {
                    com.google.android.libraries.navigation.internal.aap.d dVar3 = fhVar.d;
                    if ((dVar3 == null ? com.google.android.libraries.navigation.internal.aap.d.a : dVar3).c > 59) {
                    }
                }
                fp fpVarB = fp.b(elVar.g);
                if ((fpVarB == null ? fp.UNKNOWN : fpVarB) == fp.ON_ROUTE_PROBLEM) {
                    bm bmVar = (elVar.c == 30 ? (ef) elVar.d : ef.a).c;
                    i3 = (bmVar == null ? bm.a : bmVar).c;
                    i2 = i5;
                } else {
                    ex exVar = fhVar.i;
                    exVar = exVar == null ? ex.a : exVar;
                    int i6 = exVar.c;
                    i2 = exVar.d;
                    i3 = i6;
                }
                fk fkVar4 = fkVar3;
                com.google.android.libraries.navigation.internal.oe.ad adVarC = ayVar.b().c(i3, i2);
                if (adVarC != null) {
                    com.google.android.libraries.navigation.internal.aap.d dVar4 = fhVar.d;
                    am amVar = new am(elVar, dVar4 == null ? com.google.android.libraries.navigation.internal.aap.d.a : dVar4, adVarC, fyVarC, ayVar.d());
                    ezVar.f(new com.google.android.libraries.navigation.internal.cl.u(amVar.c), amVar);
                }
                fkVar3 = fkVar4;
                i5 = 0;
            }
            fkVar = fkVar3;
            this.l = ezVar.d();
            this.f348n = com.google.android.libraries.navigation.internal.ot.k.c(com.google.android.libraries.navigation.internal.cl.u.a(fwVar.i()));
        }
        eq eqVar = new eq();
        ev evVarC = ayVar.c();
        int size = evVarC.size();
        for (int i7 = 0; i7 < size; i7++) {
            oa oaVar = (oa) evVarC.get(i7);
            nz nzVarB = nz.b(oaVar.d);
            if ((nzVarB == null ? nz.INCIDENT_OTHER : nzVarB) != nz.INCIDENT_JAM) {
                eqVar.h(oaVar);
            }
        }
        eq eqVar2 = new eq();
        for (bq bqVar : ayVar.a().l) {
            ev evVar = bqVar.K;
            int i8 = ((lv) evVar).c;
            for (int i9 = 0; i9 < i8; i9++) {
                eqVar2.h(new com.google.android.libraries.navigation.internal.ck.b((ap) evVar.get(i9), ayVar.d(), bqVar.d));
            }
        }
        fk fkVar5 = fkVar;
        this.a = new cd(eqVar.g(), eqVar2.g(), bVar.i(), fkVar5.H, fkVar5.I, z4);
        bg bgVarA = ayVar.a();
        this.q = bgVarA;
        this.r = ayVar.b();
        this.R = new aq(rect, bgVarA.B());
        this.z = i;
        this.m = d(this.l, oVar, bgVarA, z2, i);
    }

    public static fy d(Map map, final com.google.android.libraries.navigation.internal.cn.o oVar, final bg bgVar, final boolean z, final int i) {
        return (fy) map.entrySet().stream().filter(new Predicate() { // from class: com.google.android.libraries.navigation.internal.bo.aa
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return !oVar.a(((am) ((Map.Entry) obj).getValue()).a, Integer.valueOf(i), bgVar, z).booleanValue();
            }
        }).map(new Function() { // from class: com.google.android.libraries.navigation.internal.bo.ab
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (com.google.android.libraries.navigation.internal.cl.u) ((Map.Entry) obj).getKey();
            }
        }).collect(com.google.android.libraries.navigation.internal.yz.br.b);
    }

    public static void h(ek ekVar) {
        nn nnVarListIterator = ekVar.listIterator();
        while (nnVarListIterator.hasNext()) {
            ((com.google.android.libraries.navigation.internal.qk.ak) nnVarListIterator.next()).c();
        }
    }

    public static void i(List list, int i) {
        ez ezVar = new ez();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.qk.ak akVar = (com.google.android.libraries.navigation.internal.qk.ak) it2.next();
            ezVar.f(akVar.a(), akVar.b());
        }
        com.google.android.libraries.navigation.internal.qk.ah ahVar = new com.google.android.libraries.navigation.internal.qk.ah(ezVar.d(), i);
        Iterator it3 = list.iterator();
        while (it3.hasNext()) {
            ((com.google.android.libraries.navigation.internal.qk.ak) it3.next()).e(ahVar);
        }
    }

    /* JADX WARN: Code duplicated, block: B:65:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x0061 A[SYNTHETIC] */
    private final fd j(as asVar, boolean z, as asVar2, as asVar3, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        ak akVar;
        com.google.android.libraries.navigation.internal.oe.ad adVar;
        com.google.android.libraries.navigation.internal.qk.t tVar;
        com.google.android.libraries.navigation.internal.qk.t tVar2;
        if (z && !this.c) {
            return ma.b;
        }
        HashMap map = new HashMap();
        List listO = this.q.O();
        for (Map.Entry entry : this.A.entrySet()) {
            if (((Integer) entry.getKey()).intValue() < listO.size()) {
                com.google.android.libraries.navigation.internal.oe.ad adVarC = ((com.google.android.libraries.navigation.internal.oe.an) listO.get(((Integer) entry.getKey()).intValue())).c();
                for (com.google.android.libraries.navigation.internal.cq.aa aaVar : (List) entry.getValue()) {
                    if (asVar.a(aaVar.e)) {
                        String str = aaVar.d;
                        if (asVar2.a(aaVar.e)) {
                            z5 = true;
                        } else {
                            ar.q(asVar3);
                            if (asVar3.a(aaVar.e)) {
                                String str2 = this.p;
                                z5 = str2 != null && str2.equals(str);
                                akVar = new ak(this, !z5, str);
                            } else {
                                z5 = false;
                            }
                            adVar = (com.google.android.libraries.navigation.internal.oe.ad) n(aaVar.b, aaVar.c, adVarC, this.r).f();
                            if (adVar == null && !map.containsKey(str)) {
                                String str3 = z5 ? aaVar.p : null;
                                int i = z2 ? this.Q : 0;
                                if (akVar != null) {
                                    com.google.android.libraries.navigation.internal.qk.t tVar3 = aaVar.m;
                                    if (z5) {
                                        tVar = com.google.android.libraries.navigation.internal.qk.t.POLYLINE_DECORATION_EXPANDED;
                                    } else {
                                        if (tVar3.equals(com.google.android.libraries.navigation.internal.qk.t.POLYLINE_DECORATION_LIMITED_SPACE)) {
                                            tVar2 = tVar3;
                                        } else {
                                            tVar = com.google.android.libraries.navigation.internal.qk.t.POLYLINE_DECORATION;
                                        }
                                        map.put(str, b(aaVar, str3, false, adVar, i, tVar2, akVar));
                                        if (z3) {
                                            this.Q++;
                                        }
                                    }
                                } else {
                                    tVar = aaVar.m;
                                }
                                tVar2 = tVar;
                                map.put(str, b(aaVar, str3, false, adVar, i, tVar2, akVar));
                                if (z3) {
                                    this.Q++;
                                }
                            }
                        }
                        akVar = null;
                        adVar = (com.google.android.libraries.navigation.internal.oe.ad) n(aaVar.b, aaVar.c, adVarC, this.r).f();
                        if (adVar == null) {
                        }
                    }
                }
            }
        }
        return fd.j(map);
    }

    private final void k() {
        ArrayList arrayList = new ArrayList();
        nn nnVarListIterator = this.O.entrySet().listIterator();
        while (nnVarListIterator.hasNext()) {
            arrayList.add((com.google.android.libraries.navigation.internal.qk.ak) ((Map.Entry) nnVarListIterator.next()).getValue());
        }
        i(arrayList, arrayList.size());
    }

    private final boolean l() {
        return com.google.android.libraries.navigation.internal.gz.i.c(this.N);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void m(com.google.android.libraries.navigation.internal.oj.c cVar, com.google.android.libraries.navigation.internal.oj.l lVar, com.google.android.libraries.navigation.internal.adg.ex exVar, com.google.android.libraries.navigation.internal.adg.ex exVar2, com.google.android.libraries.navigation.internal.adg.ex exVar3, com.google.android.libraries.navigation.internal.cq.t tVar, String str, boolean z, String str2, int i, Integer num, com.google.android.libraries.navigation.internal.cq.z zVar, com.google.android.libraries.navigation.internal.afd.a aVar, String str3, com.google.android.libraries.navigation.internal.ado.j jVar) {
        dq dqVarB;
        int i2 = ev.d;
        eq eqVar = new eq();
        if (tVar == null) {
            dqVarB = cVar.b(lVar.d(exVar));
            eqVar.h(cVar.a(lVar.d(exVar2)));
            if (str != null && !str.isEmpty()) {
                String strConcat = l() ? str.concat("  ") : "  ".concat(str);
                Cdo cdoA = cVar.a(lVar.d(exVar3));
                if (!cdoA.b.H()) {
                    cdoA.v();
                }
                dp dpVar = (dp) cdoA.b;
                dp dpVar2 = dp.a;
                dpVar.b |= 1;
                dpVar.c = strConcat;
                eqVar.h(cdoA);
            }
        } else {
            Object objB = tVar.b();
            Object objA = tVar.a();
            Object objC = tVar.c();
            Object objD = tVar.d();
            Object objE = tVar.e();
            dq dqVarB2 = cVar.b(objB);
            eqVar.h(cVar.a(objA));
            if (str != null && !str.isEmpty()) {
                if (objC != null) {
                    Cdo cdoA2 = cVar.a(objC);
                    if (!cdoA2.b.H()) {
                        cdoA2.v();
                    }
                    dp dpVar3 = (dp) cdoA2.b;
                    dp dpVar4 = dp.a;
                    dpVar3.b |= 1;
                    dpVar3.c = StringUtils.SPACE;
                    eqVar.h(cdoA2);
                }
                if (objD != null) {
                    eqVar.h(cVar.a(objD));
                }
                if (objE != null) {
                    Cdo cdoA3 = cVar.a(objE);
                    if (!cdoA3.b.H()) {
                        cdoA3.v();
                    }
                    dp dpVar5 = (dp) cdoA3.b;
                    dp dpVar6 = dp.a;
                    dpVar5.b |= 1;
                    dpVar5.c = str;
                    eqVar.h(cdoA3);
                }
            }
            dqVarB = dqVarB2;
        }
        ev evVarH = l() ? eqVar.g().h() : eqVar.g();
        int size = evVarH.size();
        for (int i3 = 0; i3 < size; i3++) {
            dqVarB.d((Cdo) evVarH.get(i3));
        }
        dy dyVarC = cVar.c();
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        com.google.android.libraries.navigation.internal.adg.ef efVar = (com.google.android.libraries.navigation.internal.adg.ef) dyVarC.b;
        com.google.android.libraries.navigation.internal.adg.ef efVar2 = com.google.android.libraries.navigation.internal.adg.ef.a;
        efVar.b |= 128;
        efVar.i = i;
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        com.google.android.libraries.navigation.internal.adg.ef efVar3 = (com.google.android.libraries.navigation.internal.adg.ef) dyVarC.b;
        dt dtVar = (dt) dqVarB.t();
        dtVar.getClass();
        efVar3.c = dtVar;
        efVar3.b |= 1;
        com.google.android.libraries.navigation.internal.adg.c cVar2 = (com.google.android.libraries.navigation.internal.adg.c) com.google.android.libraries.navigation.internal.adg.d.a.q();
        com.google.android.libraries.navigation.internal.adg.b bVar = (com.google.android.libraries.navigation.internal.adg.b) G.get(0);
        if (!cVar2.b.H()) {
            cVar2.v();
        }
        com.google.android.libraries.navigation.internal.adg.d dVar = (com.google.android.libraries.navigation.internal.adg.d) cVar2.b;
        dVar.d = bVar.j;
        dVar.b |= 2;
        if (!dyVarC.b.H()) {
            dyVarC.v();
        }
        com.google.android.libraries.navigation.internal.adg.ef efVar4 = (com.google.android.libraries.navigation.internal.adg.ef) dyVarC.b;
        com.google.android.libraries.navigation.internal.adg.d dVar2 = (com.google.android.libraries.navigation.internal.adg.d) cVar2.t();
        dVar2.getClass();
        efVar4.e = dVar2;
        efVar4.b |= 8;
        if (num != null) {
            if (!dyVarC.b.H()) {
                dyVarC.v();
            }
            com.google.android.libraries.navigation.internal.adg.ef efVar5 = (com.google.android.libraries.navigation.internal.adg.ef) dyVarC.b;
            efVar5.b |= 256;
            efVar5.j = 0;
        }
        if (aVar != null) {
            com.google.android.libraries.navigation.internal.adl.ad adVar = com.google.android.libraries.navigation.internal.rp.c.a;
            com.google.android.libraries.navigation.internal.rp.c.e(dyVarC, aVar, new com.google.android.libraries.navigation.internal.hb.a() { // from class: com.google.android.libraries.navigation.internal.rp.b
                @Override // com.google.android.libraries.navigation.internal.hb.a
                public final void a(Object obj, Object obj2) {
                    ad adVar2 = c.a;
                    int iA = ((com.google.android.libraries.navigation.internal.afd.a) obj2).a();
                    bb bbVar = (bb) obj;
                    if (!bbVar.b.H()) {
                        bbVar.v();
                    }
                    n nVar = (n) ((m) obj).b;
                    n nVar2 = n.a;
                    nVar.b |= 8;
                    nVar.d = iA;
                }
            });
            if (jVar != null) {
                com.google.android.libraries.navigation.internal.rp.c.h(dyVarC, jVar);
            }
        }
        if (str3 != null) {
            com.google.android.libraries.navigation.internal.rp.c.d(dyVarC, str3);
        }
        if (zVar != null) {
            fr frVar = (fr) fs.a.q();
            frVar.C(fu.w, cx.a);
            if (!dyVarC.b.H()) {
                dyVarC.v();
            }
            com.google.android.libraries.navigation.internal.adg.ef efVar6 = (com.google.android.libraries.navigation.internal.adg.ef) dyVarC.b;
            fs fsVar = (fs) frVar.t();
            fsVar.getClass();
            efVar6.u = fsVar;
            efVar6.b |= 65536;
        }
        if (str2 == null || str2.isEmpty()) {
            return;
        }
        boolean z2 = zVar != null;
        bh bhVar = com.google.android.libraries.navigation.internal.adg.bj.T;
        com.google.android.libraries.navigation.internal.adg.j jVar2 = (com.google.android.libraries.navigation.internal.adg.j) dyVarC.y(com.google.android.libraries.navigation.internal.adg.bj.T);
        bb bbVar = (bb) jVar2.aH(5, null);
        bbVar.x(jVar2);
        com.google.android.libraries.navigation.internal.adg.i iVar = (com.google.android.libraries.navigation.internal.adg.i) bbVar;
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.j jVar3 = (com.google.android.libraries.navigation.internal.adg.j) iVar.b;
        com.google.android.libraries.navigation.internal.adg.j jVar4 = com.google.android.libraries.navigation.internal.adg.j.a;
        jVar3.b |= 1;
        jVar3.c = str2;
        if (!iVar.b.H()) {
            iVar.v();
        }
        com.google.android.libraries.navigation.internal.adg.j jVar5 = (com.google.android.libraries.navigation.internal.adg.j) iVar.b;
        jVar5.b |= 2;
        jVar5.d = z2;
        dyVarC.C(bhVar, (com.google.android.libraries.navigation.internal.adg.j) iVar.t());
    }

    private final com.google.android.libraries.navigation.internal.yx.an n(int i, int i2, com.google.android.libraries.navigation.internal.oe.ad adVar, bj bjVar) {
        bg bgVar = this.q;
        int iA = (int) bgVar.a(bgVar.m.e() - 1);
        int iMin = Math.min(i, iA);
        double d = iMin;
        double dMin = Math.min(i2, iA - iMin);
        bg bgVar2 = this.q;
        float f = (float) bgVar2.f(d);
        double dF = bgVar2.f(d + dMin) - ((double) f);
        float fA = adVar.a();
        if (f > fA) {
            f = fA;
        }
        float f2 = (float) dF;
        if (f + f2 > fA) {
            f2 = fA - f;
        }
        ar.a(f <= adVar.a());
        float f3 = f2 + f;
        ar.a(f3 <= adVar.a());
        com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x(0, 0);
        com.google.android.libraries.navigation.internal.oe.x xVar2 = new com.google.android.libraries.navigation.internal.oe.x(0, 0);
        int i3 = adVar.i(f / adVar.a(), xVar);
        int i4 = adVar.i(f3 / adVar.a(), xVar2);
        if (i4 < i3) {
            i4 = i3;
        }
        ArrayList arrayListE = hx.e((i4 + 2) - i3);
        arrayListE.add(xVar);
        while (i3 < i4) {
            i3++;
            arrayListE.add(adVar.l(i3));
        }
        arrayListE.add(xVar2);
        return com.google.android.libraries.navigation.internal.yx.an.i(com.google.android.libraries.navigation.internal.oe.ad.n(arrayListE));
    }

    private static final long o(am amVar) {
        el elVar = amVar.a;
        fb fbVar = (elVar.c == 22 ? (fh) elVar.d : fh.a).m;
        if (fbVar == null) {
            fbVar = fb.a;
        }
        long j = fbVar.c;
        return j;
    }

    public final long a() {
        return this.q.Y;
    }

    final com.google.android.libraries.navigation.internal.qk.ak b(com.google.android.libraries.navigation.internal.cq.aa aaVar, String str, boolean z, com.google.android.libraries.navigation.internal.oe.ad adVar, int i, com.google.android.libraries.navigation.internal.qk.t tVar, com.google.android.libraries.navigation.internal.cq.z zVar) {
        boolean z2;
        com.google.android.libraries.navigation.internal.ol.aq aqVarD;
        com.google.android.libraries.navigation.internal.cq.u uVar;
        com.google.android.libraries.navigation.internal.oo.f fVarD;
        com.google.android.libraries.navigation.internal.cq.v vVar;
        aw awVar = new aw(adVar);
        awVar.d = true;
        if (this.w.B().c) {
            z2 = true;
        } else {
            com.google.android.libraries.navigation.internal.cq.k kVar = aaVar.e;
            if ((kVar == com.google.android.libraries.navigation.internal.cq.k.HEIGHT_RESTRICTION || kVar == com.google.android.libraries.navigation.internal.cq.k.WIDTH_RESTRICTION || kVar == com.google.android.libraries.navigation.internal.cq.k.WEIGHT_RESTRICTION || kVar == com.google.android.libraries.navigation.internal.cq.k.LENGTH_RESTRICTION || kVar == com.google.android.libraries.navigation.internal.cq.k.LOW_DATA_QUALITY_ZONE || kVar == com.google.android.libraries.navigation.internal.cq.k.HAZMAT_RESTRICTION || kVar == com.google.android.libraries.navigation.internal.cq.k.ETC_ONLY_TOLL_GATE) && tVar != com.google.android.libraries.navigation.internal.qk.t.LARGE_VEHICLE_HIGH_PRIORITY_INFORMATION && tVar != com.google.android.libraries.navigation.internal.qk.t.LARGE_VEHICLE_IMPASSABLE_RESTRICTIONS && tVar != com.google.android.libraries.navigation.internal.qk.t.LARGE_VEHICLE_LOW_PRIORITY_INFORMATION) {
                com.google.android.libraries.navigation.internal.qk.t tVar2 = com.google.android.libraries.navigation.internal.qk.t.LARGE_VEHICLE_PASSABLE_RESTRICTIONS;
            }
            z2 = false;
        }
        az azVarC = az.c(awVar, this.R, true ^ z2);
        com.google.android.libraries.navigation.internal.adg.ex exVar = aaVar.g;
        if (!this.H) {
            com.google.android.libraries.navigation.internal.cq.w wVar = aaVar.l;
            if (wVar == null) {
                aqVarD = ((com.google.android.libraries.navigation.internal.oj.j) this.T).d(exVar);
            } else {
                ar.q(wVar);
                aqVarD = wVar.b;
            }
            com.google.android.libraries.navigation.internal.oj.l lVar = this.T;
            com.google.android.libraries.navigation.internal.adg.ex exVar2 = aaVar.j;
            com.google.android.libraries.navigation.internal.adg.ex exVar3 = aaVar.k;
            com.google.android.libraries.navigation.internal.cq.w legacyStyles = aaVar.l;
            com.google.android.libraries.navigation.internal.oj.c cVarG = com.google.android.libraries.navigation.internal.oj.c.g(aqVarD);
            if (legacyStyles != null) {
                ar.q(legacyStyles);
                Intrinsics.checkNotNullParameter(legacyStyles, "legacyStyles");
                uVar = new com.google.android.libraries.navigation.internal.cq.u(legacyStyles);
            } else {
                uVar = null;
            }
            m(cVarG, lVar, exVar, exVar2, exVar3, uVar, str, false, aaVar.q, i, aaVar.o, zVar, aaVar.t, aaVar.r, aaVar.s);
            com.google.android.libraries.navigation.internal.po.aa aaVarN = ((fk) this.S).H.n(((com.google.android.libraries.navigation.internal.oj.a) cVarG).e(), jr.WORLD_ENCODING_LAT_LNG_E7);
            if (zVar != null) {
                aaVarN.k(zVar);
            }
            com.google.android.libraries.navigation.internal.qk.g gVarG = com.google.android.libraries.navigation.internal.qk.h.g();
            gVarG.b(aaVarN);
            gVarG.c(azVarC);
            gVarG.d(0);
            gVarG.f(tVar);
            gVarG.e(G);
            return new com.google.android.libraries.navigation.internal.qk.ai(((fk) this.S).K, gVarG.g());
        }
        com.google.android.libraries.navigation.internal.cq.w wVar2 = aaVar.l;
        if (wVar2 == null) {
            com.google.android.libraries.navigation.internal.oj.l lVar2 = com.google.android.libraries.navigation.internal.oj.l.a;
            fVarD = com.google.android.libraries.navigation.internal.rd.e.d(exVar);
        } else {
            ar.q(wVar2);
            fVarD = wVar2.c;
        }
        com.google.android.libraries.navigation.internal.op.i iVar = this.U;
        ar.q(iVar);
        com.google.android.libraries.navigation.internal.oj.c cVarF = com.google.android.libraries.navigation.internal.oj.c.f(iVar, fVarD, new com.google.android.libraries.navigation.internal.op.b());
        com.google.android.libraries.navigation.internal.adg.ex exVar4 = aaVar.j;
        com.google.android.libraries.navigation.internal.adg.ex exVar5 = aaVar.k;
        com.google.android.libraries.navigation.internal.cq.w wVar3 = aaVar.l;
        com.google.android.libraries.navigation.internal.oj.l lVar3 = com.google.android.libraries.navigation.internal.oj.l.a;
        if (wVar3 != null) {
            com.google.android.libraries.navigation.internal.cq.w legacyStyles2 = aaVar.l;
            ar.q(legacyStyles2);
            Intrinsics.checkNotNullParameter(legacyStyles2, "legacyStyles");
            vVar = new com.google.android.libraries.navigation.internal.cq.v(legacyStyles2);
        } else {
            vVar = null;
        }
        m(cVarF, lVar3, exVar, exVar4, exVar5, vVar, str, false, aaVar.q, i, aaVar.o, zVar, aaVar.t, aaVar.r, aaVar.s);
        com.google.android.libraries.navigation.internal.qk.u uVarJ = com.google.android.libraries.navigation.internal.qk.v.j();
        uVarJ.d(((com.google.android.libraries.navigation.internal.oj.b) cVarF).e());
        uVarJ.f(azVarC);
        uVarJ.g(0);
        uVarJ.i(tVar);
        uVarJ.h(G);
        com.google.android.libraries.navigation.internal.qk.v vVarJ = uVarJ.j();
        if (zVar == null) {
            com.google.android.libraries.navigation.internal.qk.w wVar4 = this.V;
            ar.q(wVar4);
            return new com.google.android.libraries.navigation.internal.qk.aj(wVar4, vVarJ, null, null);
        }
        com.google.android.libraries.navigation.internal.qk.w wVar5 = this.V;
        ar.q(wVar5);
        com.google.android.libraries.navigation.internal.cr.f fVar = this.X;
        ar.q(fVar);
        return new com.google.android.libraries.navigation.internal.qk.aj(wVar5, vVarJ, fVar, zVar);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:102:0x01db  */
    /* JADX WARN: Code duplicated, block: B:103:0x01e4  */
    /* JADX WARN: Code duplicated, block: B:107:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:108:0x01fa  */
    /* JADX WARN: Code duplicated, block: B:111:0x0209  */
    /* JADX WARN: Code duplicated, block: B:114:0x021f  */
    /* JADX WARN: Code duplicated, block: B:116:0x0227  */
    /* JADX WARN: Code duplicated, block: B:119:0x0244  */
    /* JADX WARN: Code duplicated, block: B:123:0x0267  */
    /* JADX WARN: Code duplicated, block: B:126:0x026d  */
    /* JADX WARN: Code duplicated, block: B:127:0x026f  */
    /* JADX WARN: Code duplicated, block: B:129:0x0272  */
    /* JADX WARN: Code duplicated, block: B:131:0x027a  */
    /* JADX WARN: Code duplicated, block: B:132:0x027f  */
    /* JADX WARN: Code duplicated, block: B:135:0x0285  */
    /* JADX WARN: Code duplicated, block: B:138:0x0290  */
    /* JADX WARN: Code duplicated, block: B:139:0x0293  */
    /* JADX WARN: Code duplicated, block: B:141:0x029f  */
    /* JADX WARN: Code duplicated, block: B:145:0x02d0  */
    /* JADX WARN: Code duplicated, block: B:148:0x02fd  */
    /* JADX WARN: Code duplicated, block: B:151:0x0338  */
    /* JADX WARN: Code duplicated, block: B:152:0x033b  */
    /* JADX WARN: Code duplicated, block: B:155:0x0345  */
    /* JADX WARN: Code duplicated, block: B:158:0x0352  */
    /* JADX WARN: Code duplicated, block: B:160:0x0362  */
    /* JADX WARN: Code duplicated, block: B:163:0x0383  */
    /* JADX WARN: Code duplicated, block: B:166:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:168:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:172:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:175:0x03ec  */
    /* JADX WARN: Code duplicated, block: B:177:0x03f2  */
    /* JADX WARN: Code duplicated, block: B:178:0x03fd  */
    /* JADX WARN: Code duplicated, block: B:181:0x041b  */
    /* JADX WARN: Code duplicated, block: B:183:0x044e  */
    /* JADX WARN: Code duplicated, block: B:185:0x0470  */
    /* JADX WARN: Code duplicated, block: B:198:0x01ee A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:199:0x04b6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:208:0x000d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:51:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:64:0x0118  */
    /* JADX WARN: Code duplicated, block: B:66:0x0120  */
    /* JADX WARN: Code duplicated, block: B:68:0x0130  */
    /* JADX WARN: Code duplicated, block: B:69:0x013d  */
    /* JADX WARN: Code duplicated, block: B:79:0x016f  */
    /* JADX WARN: Code duplicated, block: B:80:0x0174  */
    /* JADX WARN: Code duplicated, block: B:83:0x017a  */
    /* JADX WARN: Code duplicated, block: B:86:0x018a  */
    /* JADX WARN: Code duplicated, block: B:88:0x018e  */
    /* JADX WARN: Code duplicated, block: B:91:0x0194  */
    /* JADX WARN: Code duplicated, block: B:93:0x0198  */
    /* JADX WARN: Code duplicated, block: B:96:0x019e  */
    /* JADX WARN: Code duplicated, block: B:98:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:99:0x01bd  */
    /* JADX WARN: Multi-variable type inference failed */
    public final ev c(Set set) {
        com.google.android.libraries.navigation.internal.bq.e eVarB;
        com.google.android.libraries.navigation.internal.oj.c cVar;
        com.google.android.libraries.navigation.internal.oj.c cVar2;
        el elVar;
        fh fhVar;
        fg fgVar;
        com.google.android.libraries.navigation.internal.oj.c cVar3;
        com.google.android.libraries.navigation.internal.oj.c cVar4;
        boolean zM;
        fb fbVar;
        fb fbVar2;
        int i;
        boolean zL;
        dy dyVarC;
        fs fsVar;
        bh bhVarS;
        com.google.android.libraries.navigation.internal.adr.Cdo cdoB;
        boolean z;
        com.google.android.libraries.navigation.internal.adr.Cdo cdoB2;
        com.google.android.libraries.navigation.internal.afd.a aVar;
        com.google.android.libraries.navigation.internal.ado.i iVar;
        com.google.android.libraries.navigation.internal.adf.m mVar;
        com.google.android.libraries.navigation.internal.ado.i iVar2;
        com.google.android.libraries.navigation.internal.adq.ae aeVar;
        com.google.android.libraries.navigation.internal.zq.i iVar3;
        int i2;
        com.google.android.libraries.navigation.internal.zq.l lVar;
        Iterator it2;
        int i3;
        al alVar;
        com.google.android.libraries.navigation.internal.qk.r rVarC;
        boolean z2;
        int iA;
        com.google.android.libraries.navigation.internal.qk.u uVarJ;
        el elVar2;
        fh fhVar2;
        fg fgVar2;
        fs fsVar2;
        el elVar3;
        ef efVar;
        gn gnVar;
        com.google.android.libraries.navigation.internal.adr.aj ajVar;
        boolean z3;
        com.google.android.libraries.navigation.internal.oj.c cVar5;
        com.google.android.libraries.navigation.internal.oj.c cVar6;
        boolean zQ;
        int i4 = ev.d;
        eq eqVar = new eq();
        Iterator it3 = set.iterator();
        while (it3.hasNext()) {
            com.google.android.libraries.navigation.internal.cl.u uVar = (com.google.android.libraries.navigation.internal.cl.u) it3.next();
            am amVar = (am) this.l.get(uVar);
            if (amVar != null) {
                fp fpVarB = fp.b(amVar.a.g);
                if (fpVarB == null) {
                    fpVarB = fp.UNKNOWN;
                }
                boolean z4 = fpVarB == fp.ON_ROUTE_PROBLEM;
                if (z4) {
                    el elVar4 = amVar.a;
                    ee eeVar = (elVar4.c == 30 ? (ef) elVar4.d : ef.a).d;
                    if (eeVar == null) {
                        eeVar = ee.a;
                    }
                    eVarB = com.google.android.libraries.navigation.internal.bq.e.a(eeVar, ((fk) this.S).I);
                } else {
                    el elVar5 = amVar.a;
                    fg fgVar3 = (elVar5.c == 22 ? (fh) elVar5.d : fh.a).k;
                    if (fgVar3 == null) {
                        fgVar3 = fg.a;
                    }
                    eVarB = com.google.android.libraries.navigation.internal.bq.e.b(fgVar3, ((fk) this.S).I);
                }
                if (eVarB.b) {
                    el elVar6 = amVar.a;
                    if ((elVar6.b & 131072) != 0) {
                        String strD = com.google.android.libraries.navigation.internal.br.l.d(elVar6, this.M);
                        if (com.google.android.libraries.navigation.internal.yx.aq.c(strD)) {
                            continue;
                        } else {
                            com.google.android.libraries.navigation.internal.yx.an anVar = uVar.a;
                            com.google.android.libraries.navigation.internal.cl.t tVar = this.k;
                            boolean z5 = this.H;
                            com.google.android.libraries.navigation.internal.oj.c cVarC = tVar.c();
                            com.google.android.libraries.navigation.internal.oj.c cVarB = tVar.b();
                            if (z5) {
                                if (cVarB != null) {
                                    if (z4) {
                                        elVar3 = amVar.a;
                                        if (elVar3.c == 30) {
                                            efVar = (ef) elVar3.d;
                                        } else {
                                            efVar = ef.a;
                                        }
                                        gnVar = efVar.e;
                                        if (gnVar == null) {
                                            gnVar = gn.a;
                                        }
                                        ajVar = gnVar.d;
                                        if (ajVar == null) {
                                            ajVar = com.google.android.libraries.navigation.internal.adr.aj.a;
                                        }
                                        z3 = eVarB.c;
                                        String str = ajVar.c;
                                        if (z3 || str.isEmpty()) {
                                            cVar5 = cVarC;
                                            if (this.H) {
                                                zM = this.k.h(cVarB, strD, amVar.a);
                                                cVar4 = cVarB;
                                            } else {
                                                cVar = cVarB;
                                                cVar2 = cVar5;
                                                zL = this.k.m(cVar2, strD, amVar.a);
                                                zM = zL;
                                                cVar3 = cVar2;
                                                cVar4 = cVar;
                                            }
                                        } else {
                                            if (this.H) {
                                                cVar6 = cVarB;
                                                cVar5 = cVarC;
                                                zQ = this.k.o(cVar6, strD, str, (com.google.android.libraries.navigation.internal.oe.x) anVar.f(), amVar.a, false);
                                            } else {
                                                cVar6 = cVarB;
                                                cVar5 = cVarC;
                                                zQ = this.k.q(cVar5, strD, str, (com.google.android.libraries.navigation.internal.oe.x) anVar.f(), amVar.a, false);
                                            }
                                            cVar4 = cVar6;
                                            zM = zQ;
                                        }
                                        cVar3 = cVar5;
                                    } else {
                                        cVar = cVarB;
                                        cVar2 = cVarC;
                                        if (eVarB.c || (i = amVar.b.c) == 0) {
                                            elVar = amVar.a;
                                            if (elVar.c == 22) {
                                                fhVar = (fh) elVar.d;
                                            } else {
                                                fhVar = fh.a;
                                            }
                                            fgVar = fhVar.k;
                                            if (fgVar == null) {
                                                fgVar = fg.a;
                                            }
                                            if (com.google.android.libraries.navigation.internal.bq.e.b(fgVar, ((fk) this.S).I).c) {
                                                fbVar = fhVar.m;
                                                if (fbVar == null) {
                                                    fbVar = fb.a;
                                                }
                                                if (fbVar.c <= 0) {
                                                    cVar3 = cVar2;
                                                    cVar4 = cVar;
                                                    if (this.H) {
                                                        zM = this.k.h(cVar4, strD, amVar.a);
                                                    } else {
                                                        zM = this.k.m(cVar3, strD, amVar.a);
                                                    }
                                                } else {
                                                    fbVar2 = fhVar.m;
                                                    if (fbVar2 == null) {
                                                        fbVar2 = fb.a;
                                                    }
                                                    if (fbVar2.f) {
                                                        cVar3 = cVar2;
                                                        cVar4 = cVar;
                                                        if (this.H) {
                                                            zM = this.k.h(cVar4, strD, amVar.a);
                                                        } else {
                                                            zM = this.k.m(cVar3, strD, amVar.a);
                                                        }
                                                    } else if (this.H) {
                                                        cVar3 = cVar2;
                                                        cVar4 = cVar;
                                                        zM = this.k.i(cVar, o(amVar), strD, null, amVar.a, 1);
                                                    } else {
                                                        cVar3 = cVar2;
                                                        cVar4 = cVar;
                                                        zM = this.k.n(cVar3, o(amVar), strD, null, amVar.a, 1);
                                                    }
                                                }
                                            } else {
                                                cVar3 = cVar2;
                                                cVar4 = cVar;
                                                if (this.H) {
                                                    zM = this.k.h(cVar4, strD, amVar.a);
                                                } else {
                                                    zM = this.k.m(cVar3, strD, amVar.a);
                                                }
                                            }
                                        } else {
                                            if (z5) {
                                                zL = this.k.g(cVar, Duration.ofSeconds(i), strD, amVar.a);
                                            } else {
                                                zL = this.k.l(cVar2, i, strD, amVar.a);
                                            }
                                            zM = zL;
                                            cVar3 = cVar2;
                                            cVar4 = cVar;
                                        }
                                    }
                                    if (zM) {
                                        if (this.H) {
                                            ar.q(cVar4);
                                            dyVarC = cVar4.c();
                                        } else {
                                            ar.q(cVar3);
                                            dyVarC = cVar3.c();
                                        }
                                        fsVar = ((com.google.android.libraries.navigation.internal.adg.ef) dyVarC.b).u;
                                        if (fsVar == null) {
                                            fsVar = fs.a;
                                        }
                                        bhVarS = bi.s(fu.w);
                                        fsVar.h(bhVarS);
                                        if (!fsVar.w.n(bhVarS.d)) {
                                            fsVar2 = ((com.google.android.libraries.navigation.internal.adg.ef) dyVarC.b).u;
                                            if (fsVar2 == null) {
                                                fsVar2 = fs.a;
                                            }
                                            bb bbVar = (bb) fsVar2.aH(5, null);
                                            bbVar.x(fsVar2);
                                            fr frVar = (fr) bbVar;
                                            frVar.C(fu.w, cx.a);
                                            if (!dyVarC.b.H()) {
                                                dyVarC.v();
                                            }
                                            com.google.android.libraries.navigation.internal.adg.ef efVar2 = (com.google.android.libraries.navigation.internal.adg.ef) dyVarC.b;
                                            fs fsVar3 = (fs) frVar.t();
                                            fsVar3.getClass();
                                            efVar2.u = fsVar3;
                                            efVar2.b |= 65536;
                                        }
                                        cdoB = com.google.android.libraries.navigation.internal.adr.Cdo.b(amVar.a.u);
                                        if (cdoB == null) {
                                            cdoB = com.google.android.libraries.navigation.internal.adr.Cdo.INCIDENT_OTHER;
                                        }
                                        if (cdoB == com.google.android.libraries.navigation.internal.adr.Cdo.INCIDENT_ROAD_CLOSED) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        if (z) {
                                            elVar2 = amVar.a;
                                            if (elVar2.c == 22) {
                                                fhVar2 = (fh) elVar2.d;
                                            } else {
                                                fhVar2 = fh.a;
                                            }
                                            fgVar2 = fhVar2.k;
                                            if (fgVar2 == null) {
                                                fgVar2 = fg.a;
                                            }
                                            if (ff.a(fgVar2.c) == 2) {
                                                aVar = com.google.android.libraries.navigation.internal.afe.f.b;
                                            } else {
                                                el elVar7 = amVar.a;
                                                EnumMap enumMap = com.google.android.libraries.navigation.internal.tt.e.b;
                                                cdoB2 = com.google.android.libraries.navigation.internal.adr.Cdo.b(elVar7.u);
                                                if (cdoB2 == null) {
                                                    cdoB2 = com.google.android.libraries.navigation.internal.adr.Cdo.INCIDENT_OTHER;
                                                }
                                                aVar = (com.google.android.libraries.navigation.internal.afd.a) enumMap.getOrDefault(cdoB2, com.google.android.libraries.navigation.internal.afe.o.g);
                                            }
                                        } else {
                                            el elVar8 = amVar.a;
                                            EnumMap enumMap2 = com.google.android.libraries.navigation.internal.tt.e.b;
                                            cdoB2 = com.google.android.libraries.navigation.internal.adr.Cdo.b(elVar8.u);
                                            if (cdoB2 == null) {
                                                cdoB2 = com.google.android.libraries.navigation.internal.adr.Cdo.INCIDENT_OTHER;
                                            }
                                            aVar = (com.google.android.libraries.navigation.internal.afd.a) enumMap2.getOrDefault(cdoB2, com.google.android.libraries.navigation.internal.afe.o.g);
                                        }
                                        int iA2 = aVar.a();
                                        iVar = (com.google.android.libraries.navigation.internal.ado.i) com.google.android.libraries.navigation.internal.ado.j.a.q();
                                        com.google.android.libraries.navigation.internal.adq.ae aeVar2 = (com.google.android.libraries.navigation.internal.adq.ae) com.google.android.libraries.navigation.internal.adq.ah.a.q();
                                        aeVar2.e(com.google.android.libraries.navigation.internal.adq.ad.s);
                                        com.google.android.libraries.navigation.internal.adq.ah ahVar = (com.google.android.libraries.navigation.internal.adq.ah) aeVar2.t();
                                        if (!iVar.b.H()) {
                                            iVar.v();
                                        }
                                        com.google.android.libraries.navigation.internal.ado.j jVar = (com.google.android.libraries.navigation.internal.ado.j) iVar.b;
                                        ahVar.getClass();
                                        jVar.c = ahVar;
                                        jVar.b |= 1;
                                        com.google.android.libraries.navigation.internal.rp.c.h(dyVarC, (com.google.android.libraries.navigation.internal.ado.j) iVar.t());
                                        mVar = (com.google.android.libraries.navigation.internal.adf.m) com.google.android.libraries.navigation.internal.adf.n.a.q();
                                        if (!mVar.b.H()) {
                                            mVar.v();
                                        }
                                        com.google.android.libraries.navigation.internal.adf.n nVar = (com.google.android.libraries.navigation.internal.adf.n) mVar.b;
                                        nVar.b |= 8;
                                        nVar.d = iA2;
                                        com.google.android.libraries.navigation.internal.rp.c.f(dyVarC, (com.google.android.libraries.navigation.internal.adf.n) mVar.t());
                                        com.google.android.libraries.navigation.internal.rp.c.d(dyVarC, amVar.a.e);
                                        iVar2 = (com.google.android.libraries.navigation.internal.ado.i) com.google.android.libraries.navigation.internal.ado.j.a.q();
                                        aeVar = (com.google.android.libraries.navigation.internal.adq.ae) com.google.android.libraries.navigation.internal.adq.ah.a.q();
                                        iVar3 = (com.google.android.libraries.navigation.internal.zq.i) com.google.android.libraries.navigation.internal.zq.l.a.q();
                                        if (this.b) {
                                            i2 = com.google.android.libraries.navigation.internal.zq.k.c;
                                        } else {
                                            i2 = com.google.android.libraries.navigation.internal.zq.k.b;
                                        }
                                        if (!iVar3.b.H()) {
                                            iVar3.v();
                                        }
                                        lVar = (com.google.android.libraries.navigation.internal.zq.l) iVar3.b;
                                        it2 = it3;
                                        i3 = i2 - 1;
                                        if (i2 != 0) {
                                            throw null;
                                        }
                                        lVar.c = i3;
                                        lVar.b |= 1;
                                        if (!aeVar.b.H()) {
                                            aeVar.v();
                                        }
                                        com.google.android.libraries.navigation.internal.adq.ah ahVar2 = (com.google.android.libraries.navigation.internal.adq.ah) aeVar.b;
                                        com.google.android.libraries.navigation.internal.zq.l lVar2 = (com.google.android.libraries.navigation.internal.zq.l) iVar3.t();
                                        lVar2.getClass();
                                        ahVar2.g = lVar2;
                                        ahVar2.b |= 524288;
                                        if (!iVar2.b.H()) {
                                            iVar2.v();
                                        }
                                        com.google.android.libraries.navigation.internal.ado.j jVar2 = (com.google.android.libraries.navigation.internal.ado.j) iVar2.b;
                                        com.google.android.libraries.navigation.internal.adq.ah ahVar3 = (com.google.android.libraries.navigation.internal.adq.ah) aeVar.t();
                                        ahVar3.getClass();
                                        jVar2.c = ahVar3;
                                        jVar2.b |= 1;
                                        com.google.android.libraries.navigation.internal.rp.c.h(dyVarC, (com.google.android.libraries.navigation.internal.ado.j) iVar2.t());
                                        if (z) {
                                            if (!dyVarC.b.H()) {
                                                dyVarC.v();
                                            }
                                            com.google.android.libraries.navigation.internal.adg.ef efVar3 = (com.google.android.libraries.navigation.internal.adg.ef) dyVarC.b;
                                            efVar3.b |= 64;
                                            efVar3.h = 1;
                                        }
                                        int i5 = this.Q;
                                        if (!dyVarC.b.H()) {
                                            dyVarC.v();
                                        }
                                        com.google.android.libraries.navigation.internal.adg.ef efVar4 = (com.google.android.libraries.navigation.internal.adg.ef) dyVarC.b;
                                        efVar4.b |= 128;
                                        efVar4.i = i5;
                                        this.Q++;
                                        alVar = new al(this, amVar);
                                        rVarC = (com.google.android.libraries.navigation.internal.qk.r) uVar.b.f();
                                        if (rVarC == null) {
                                            if (anVar.g()) {
                                                rVarC = com.google.android.libraries.navigation.internal.fv.a.c();
                                                uVar.b = com.google.android.libraries.navigation.internal.yx.an.j(rVarC);
                                            } else {
                                                rVarC = az.c(uVar, this.R, !this.w.B().c);
                                            }
                                        }
                                        el elVar9 = amVar.a;
                                        boolean z6 = eVarB.c;
                                        boolean z7 = amVar.e;
                                        z2 = this.H;
                                        iA = com.google.android.libraries.navigation.internal.cl.t.a(elVar9, z6, z7);
                                        if (z2) {
                                            uVarJ = com.google.android.libraries.navigation.internal.qk.v.j();
                                            ar.q(cVar4);
                                            uVarJ.d(((com.google.android.libraries.navigation.internal.oj.b) cVar4).e());
                                            uVarJ.f(rVarC);
                                            uVarJ.i(com.google.android.libraries.navigation.internal.qk.t.JAMCIDENTS);
                                            uVarJ.g(iA);
                                            uVarJ.h(com.google.android.libraries.navigation.internal.cl.aj.b);
                                            uVarJ.e((com.google.android.libraries.navigation.internal.adg.b) com.google.android.libraries.navigation.internal.cl.aj.b.get(0));
                                            if (anVar.g()) {
                                                ((com.google.android.libraries.navigation.internal.qk.c) uVarJ).a = (com.google.android.libraries.navigation.internal.oe.x) anVar.f();
                                            }
                                            com.google.android.libraries.navigation.internal.qk.w wVar = this.V;
                                            ar.q(wVar);
                                            com.google.android.libraries.navigation.internal.qk.v vVarJ = uVarJ.j();
                                            com.google.android.libraries.navigation.internal.cr.f fVar = this.X;
                                            ar.q(fVar);
                                            eqVar.h(new com.google.android.libraries.navigation.internal.qk.aj(wVar, vVarJ, fVar, alVar));
                                        } else {
                                            com.google.android.libraries.navigation.internal.oa.e eVar = this.S;
                                            ar.q(cVar3);
                                            com.google.android.libraries.navigation.internal.po.aa aaVarN = ((fk) eVar).H.n(((com.google.android.libraries.navigation.internal.oj.a) cVar3).e(), jr.WORLD_ENCODING_LAT_LNG_E7);
                                            aaVarN.k(alVar);
                                            com.google.android.libraries.navigation.internal.qk.g gVarG = com.google.android.libraries.navigation.internal.qk.h.g();
                                            gVarG.b(aaVarN);
                                            gVarG.c(rVarC);
                                            gVarG.f(com.google.android.libraries.navigation.internal.qk.t.JAMCIDENTS);
                                            gVarG.d(iA);
                                            gVarG.e(com.google.android.libraries.navigation.internal.cl.aj.b);
                                            eqVar.h(new com.google.android.libraries.navigation.internal.qk.ai(((fk) this.S).K, gVarG.g()));
                                        }
                                        it3 = it2;
                                    } else {
                                        continue;
                                    }
                                } else {
                                    continue;
                                }
                            } else if (cVarC == null) {
                                continue;
                            } else {
                                if (z4) {
                                    elVar3 = amVar.a;
                                    if (elVar3.c == 30) {
                                        efVar = (ef) elVar3.d;
                                    } else {
                                        efVar = ef.a;
                                    }
                                    gnVar = efVar.e;
                                    if (gnVar == null) {
                                        gnVar = gn.a;
                                    }
                                    ajVar = gnVar.d;
                                    if (ajVar == null) {
                                        ajVar = com.google.android.libraries.navigation.internal.adr.aj.a;
                                    }
                                    z3 = eVarB.c;
                                    String str2 = ajVar.c;
                                    if (z3) {
                                        cVar5 = cVarC;
                                        if (this.H) {
                                            zM = this.k.h(cVarB, strD, amVar.a);
                                            cVar4 = cVarB;
                                        } else {
                                            cVar = cVarB;
                                            cVar2 = cVar5;
                                            zL = this.k.m(cVar2, strD, amVar.a);
                                            zM = zL;
                                            cVar3 = cVar2;
                                            cVar4 = cVar;
                                        }
                                    } else {
                                        cVar5 = cVarC;
                                        if (this.H) {
                                            zM = this.k.h(cVarB, strD, amVar.a);
                                            cVar4 = cVarB;
                                        } else {
                                            cVar = cVarB;
                                            cVar2 = cVar5;
                                            zL = this.k.m(cVar2, strD, amVar.a);
                                            zM = zL;
                                            cVar3 = cVar2;
                                            cVar4 = cVar;
                                        }
                                    }
                                    cVar3 = cVar5;
                                } else {
                                    cVar = cVarB;
                                    cVar2 = cVarC;
                                    if (eVarB.c) {
                                    }
                                    elVar = amVar.a;
                                    if (elVar.c == 22) {
                                        fhVar = (fh) elVar.d;
                                    } else {
                                        fhVar = fh.a;
                                    }
                                    fgVar = fhVar.k;
                                    if (fgVar == null) {
                                        fgVar = fg.a;
                                    }
                                    if (com.google.android.libraries.navigation.internal.bq.e.b(fgVar, ((fk) this.S).I).c) {
                                        cVar3 = cVar2;
                                        cVar4 = cVar;
                                        if (this.H) {
                                            zM = this.k.h(cVar4, strD, amVar.a);
                                        } else {
                                            zM = this.k.m(cVar3, strD, amVar.a);
                                        }
                                    } else {
                                        fbVar = fhVar.m;
                                        if (fbVar == null) {
                                            fbVar = fb.a;
                                        }
                                        if (fbVar.c <= 0) {
                                            cVar3 = cVar2;
                                            cVar4 = cVar;
                                            if (this.H) {
                                                zM = this.k.h(cVar4, strD, amVar.a);
                                            } else {
                                                zM = this.k.m(cVar3, strD, amVar.a);
                                            }
                                        } else {
                                            fbVar2 = fhVar.m;
                                            if (fbVar2 == null) {
                                                fbVar2 = fb.a;
                                            }
                                            if (fbVar2.f) {
                                                cVar3 = cVar2;
                                                cVar4 = cVar;
                                                if (this.H) {
                                                    zM = this.k.h(cVar4, strD, amVar.a);
                                                } else {
                                                    zM = this.k.m(cVar3, strD, amVar.a);
                                                }
                                            } else if (this.H) {
                                                cVar3 = cVar2;
                                                cVar4 = cVar;
                                                zM = this.k.i(cVar, o(amVar), strD, null, amVar.a, 1);
                                            } else {
                                                cVar3 = cVar2;
                                                cVar4 = cVar;
                                                zM = this.k.n(cVar3, o(amVar), strD, null, amVar.a, 1);
                                            }
                                        }
                                    }
                                }
                                if (zM) {
                                    continue;
                                } else {
                                    if (this.H) {
                                        ar.q(cVar4);
                                        dyVarC = cVar4.c();
                                    } else {
                                        ar.q(cVar3);
                                        dyVarC = cVar3.c();
                                    }
                                    fsVar = ((com.google.android.libraries.navigation.internal.adg.ef) dyVarC.b).u;
                                    if (fsVar == null) {
                                        fsVar = fs.a;
                                    }
                                    bhVarS = bi.s(fu.w);
                                    fsVar.h(bhVarS);
                                    if (!fsVar.w.n(bhVarS.d)) {
                                        fsVar2 = ((com.google.android.libraries.navigation.internal.adg.ef) dyVarC.b).u;
                                        if (fsVar2 == null) {
                                            fsVar2 = fs.a;
                                        }
                                        bb bbVar2 = (bb) fsVar2.aH(5, null);
                                        bbVar2.x(fsVar2);
                                        fr frVar2 = (fr) bbVar2;
                                        frVar2.C(fu.w, cx.a);
                                        if (!dyVarC.b.H()) {
                                            dyVarC.v();
                                        }
                                        com.google.android.libraries.navigation.internal.adg.ef efVar5 = (com.google.android.libraries.navigation.internal.adg.ef) dyVarC.b;
                                        fs fsVar4 = (fs) frVar2.t();
                                        fsVar4.getClass();
                                        efVar5.u = fsVar4;
                                        efVar5.b |= 65536;
                                    }
                                    cdoB = com.google.android.libraries.navigation.internal.adr.Cdo.b(amVar.a.u);
                                    if (cdoB == null) {
                                        cdoB = com.google.android.libraries.navigation.internal.adr.Cdo.INCIDENT_OTHER;
                                    }
                                    if (cdoB == com.google.android.libraries.navigation.internal.adr.Cdo.INCIDENT_ROAD_CLOSED) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (z) {
                                        elVar2 = amVar.a;
                                        if (elVar2.c == 22) {
                                            fhVar2 = (fh) elVar2.d;
                                        } else {
                                            fhVar2 = fh.a;
                                        }
                                        fgVar2 = fhVar2.k;
                                        if (fgVar2 == null) {
                                            fgVar2 = fg.a;
                                        }
                                        if (ff.a(fgVar2.c) == 2) {
                                            aVar = com.google.android.libraries.navigation.internal.afe.f.b;
                                        } else {
                                            el elVar10 = amVar.a;
                                            EnumMap enumMap3 = com.google.android.libraries.navigation.internal.tt.e.b;
                                            cdoB2 = com.google.android.libraries.navigation.internal.adr.Cdo.b(elVar10.u);
                                            if (cdoB2 == null) {
                                                cdoB2 = com.google.android.libraries.navigation.internal.adr.Cdo.INCIDENT_OTHER;
                                            }
                                            aVar = (com.google.android.libraries.navigation.internal.afd.a) enumMap3.getOrDefault(cdoB2, com.google.android.libraries.navigation.internal.afe.o.g);
                                        }
                                    } else {
                                        el elVar11 = amVar.a;
                                        EnumMap enumMap4 = com.google.android.libraries.navigation.internal.tt.e.b;
                                        cdoB2 = com.google.android.libraries.navigation.internal.adr.Cdo.b(elVar11.u);
                                        if (cdoB2 == null) {
                                            cdoB2 = com.google.android.libraries.navigation.internal.adr.Cdo.INCIDENT_OTHER;
                                        }
                                        aVar = (com.google.android.libraries.navigation.internal.afd.a) enumMap4.getOrDefault(cdoB2, com.google.android.libraries.navigation.internal.afe.o.g);
                                    }
                                    int iA3 = aVar.a();
                                    iVar = (com.google.android.libraries.navigation.internal.ado.i) com.google.android.libraries.navigation.internal.ado.j.a.q();
                                    com.google.android.libraries.navigation.internal.adq.ae aeVar3 = (com.google.android.libraries.navigation.internal.adq.ae) com.google.android.libraries.navigation.internal.adq.ah.a.q();
                                    aeVar3.e(com.google.android.libraries.navigation.internal.adq.ad.s);
                                    com.google.android.libraries.navigation.internal.adq.ah ahVar4 = (com.google.android.libraries.navigation.internal.adq.ah) aeVar3.t();
                                    if (!iVar.b.H()) {
                                        iVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.ado.j jVar3 = (com.google.android.libraries.navigation.internal.ado.j) iVar.b;
                                    ahVar4.getClass();
                                    jVar3.c = ahVar4;
                                    jVar3.b |= 1;
                                    com.google.android.libraries.navigation.internal.rp.c.h(dyVarC, (com.google.android.libraries.navigation.internal.ado.j) iVar.t());
                                    mVar = (com.google.android.libraries.navigation.internal.adf.m) com.google.android.libraries.navigation.internal.adf.n.a.q();
                                    if (!mVar.b.H()) {
                                        mVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.adf.n nVar2 = (com.google.android.libraries.navigation.internal.adf.n) mVar.b;
                                    nVar2.b |= 8;
                                    nVar2.d = iA3;
                                    com.google.android.libraries.navigation.internal.rp.c.f(dyVarC, (com.google.android.libraries.navigation.internal.adf.n) mVar.t());
                                    com.google.android.libraries.navigation.internal.rp.c.d(dyVarC, amVar.a.e);
                                    iVar2 = (com.google.android.libraries.navigation.internal.ado.i) com.google.android.libraries.navigation.internal.ado.j.a.q();
                                    aeVar = (com.google.android.libraries.navigation.internal.adq.ae) com.google.android.libraries.navigation.internal.adq.ah.a.q();
                                    iVar3 = (com.google.android.libraries.navigation.internal.zq.i) com.google.android.libraries.navigation.internal.zq.l.a.q();
                                    if (this.b) {
                                        i2 = com.google.android.libraries.navigation.internal.zq.k.c;
                                    } else {
                                        i2 = com.google.android.libraries.navigation.internal.zq.k.b;
                                    }
                                    if (!iVar3.b.H()) {
                                        iVar3.v();
                                    }
                                    lVar = (com.google.android.libraries.navigation.internal.zq.l) iVar3.b;
                                    it2 = it3;
                                    i3 = i2 - 1;
                                    if (i2 != 0) {
                                        throw null;
                                    }
                                    lVar.c = i3;
                                    lVar.b |= 1;
                                    if (!aeVar.b.H()) {
                                        aeVar.v();
                                    }
                                    com.google.android.libraries.navigation.internal.adq.ah ahVar5 = (com.google.android.libraries.navigation.internal.adq.ah) aeVar.b;
                                    com.google.android.libraries.navigation.internal.zq.l lVar3 = (com.google.android.libraries.navigation.internal.zq.l) iVar3.t();
                                    lVar3.getClass();
                                    ahVar5.g = lVar3;
                                    ahVar5.b |= 524288;
                                    if (!iVar2.b.H()) {
                                        iVar2.v();
                                    }
                                    com.google.android.libraries.navigation.internal.ado.j jVar4 = (com.google.android.libraries.navigation.internal.ado.j) iVar2.b;
                                    com.google.android.libraries.navigation.internal.adq.ah ahVar6 = (com.google.android.libraries.navigation.internal.adq.ah) aeVar.t();
                                    ahVar6.getClass();
                                    jVar4.c = ahVar6;
                                    jVar4.b |= 1;
                                    com.google.android.libraries.navigation.internal.rp.c.h(dyVarC, (com.google.android.libraries.navigation.internal.ado.j) iVar2.t());
                                    if (z) {
                                        if (!dyVarC.b.H()) {
                                            dyVarC.v();
                                        }
                                        com.google.android.libraries.navigation.internal.adg.ef efVar6 = (com.google.android.libraries.navigation.internal.adg.ef) dyVarC.b;
                                        efVar6.b |= 64;
                                        efVar6.h = 1;
                                    }
                                    int i6 = this.Q;
                                    if (!dyVarC.b.H()) {
                                        dyVarC.v();
                                    }
                                    com.google.android.libraries.navigation.internal.adg.ef efVar7 = (com.google.android.libraries.navigation.internal.adg.ef) dyVarC.b;
                                    efVar7.b |= 128;
                                    efVar7.i = i6;
                                    this.Q++;
                                    alVar = new al(this, amVar);
                                    rVarC = (com.google.android.libraries.navigation.internal.qk.r) uVar.b.f();
                                    if (rVarC == null) {
                                        if (anVar.g()) {
                                            rVarC = com.google.android.libraries.navigation.internal.fv.a.c();
                                            uVar.b = com.google.android.libraries.navigation.internal.yx.an.j(rVarC);
                                        } else {
                                            rVarC = az.c(uVar, this.R, !this.w.B().c);
                                        }
                                    }
                                    el elVar12 = amVar.a;
                                    boolean z8 = eVarB.c;
                                    boolean z9 = amVar.e;
                                    z2 = this.H;
                                    iA = com.google.android.libraries.navigation.internal.cl.t.a(elVar12, z8, z9);
                                    if (z2) {
                                        uVarJ = com.google.android.libraries.navigation.internal.qk.v.j();
                                        ar.q(cVar4);
                                        uVarJ.d(((com.google.android.libraries.navigation.internal.oj.b) cVar4).e());
                                        uVarJ.f(rVarC);
                                        uVarJ.i(com.google.android.libraries.navigation.internal.qk.t.JAMCIDENTS);
                                        uVarJ.g(iA);
                                        uVarJ.h(com.google.android.libraries.navigation.internal.cl.aj.b);
                                        uVarJ.e((com.google.android.libraries.navigation.internal.adg.b) com.google.android.libraries.navigation.internal.cl.aj.b.get(0));
                                        if (anVar.g()) {
                                            ((com.google.android.libraries.navigation.internal.qk.c) uVarJ).a = (com.google.android.libraries.navigation.internal.oe.x) anVar.f();
                                        }
                                        com.google.android.libraries.navigation.internal.qk.w wVar2 = this.V;
                                        ar.q(wVar2);
                                        com.google.android.libraries.navigation.internal.qk.v vVarJ2 = uVarJ.j();
                                        com.google.android.libraries.navigation.internal.cr.f fVar2 = this.X;
                                        ar.q(fVar2);
                                        eqVar.h(new com.google.android.libraries.navigation.internal.qk.aj(wVar2, vVarJ2, fVar2, alVar));
                                    } else {
                                        com.google.android.libraries.navigation.internal.oa.e eVar2 = this.S;
                                        ar.q(cVar3);
                                        com.google.android.libraries.navigation.internal.po.aa aaVarN2 = ((fk) eVar2).H.n(((com.google.android.libraries.navigation.internal.oj.a) cVar3).e(), jr.WORLD_ENCODING_LAT_LNG_E7);
                                        aaVarN2.k(alVar);
                                        com.google.android.libraries.navigation.internal.qk.g gVarG2 = com.google.android.libraries.navigation.internal.qk.h.g();
                                        gVarG2.b(aaVarN2);
                                        gVarG2.c(rVarC);
                                        gVarG2.f(com.google.android.libraries.navigation.internal.qk.t.JAMCIDENTS);
                                        gVarG2.d(iA);
                                        gVarG2.e(com.google.android.libraries.navigation.internal.cl.aj.b);
                                        eqVar.h(new com.google.android.libraries.navigation.internal.qk.ai(((fk) this.S).K, gVarG2.g()));
                                    }
                                    it3 = it2;
                                }
                            }
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return eqVar.g();
    }

    public final void e() {
        this.Q = 0;
        g();
        this.o = c(this.m);
        i(this.o, 3);
        if (!(this.e == com.google.android.libraries.navigation.internal.ady.al.BICYCLE && this.I) ? !(this.e == com.google.android.libraries.navigation.internal.ady.al.WALK && this.J && (this.K || !this.b)) : this.b) {
            this.O = j(new as() { // from class: com.google.android.libraries.navigation.internal.bo.ac
                @Override // com.google.android.libraries.navigation.internal.yx.as
                public final boolean a(Object obj) {
                    int i = ao.F;
                    return true;
                }
            }, true, new as() { // from class: com.google.android.libraries.navigation.internal.bo.ad
                @Override // com.google.android.libraries.navigation.internal.yx.as
                public final boolean a(Object obj) {
                    int i = ao.F;
                    return false;
                }
            }, new as() { // from class: com.google.android.libraries.navigation.internal.bo.ae
                @Override // com.google.android.libraries.navigation.internal.yx.as
                public final boolean a(Object obj) {
                    int i = ao.F;
                    return true;
                }
            }, true, this.J, false);
            k();
            return;
        }
        if (this.e == com.google.android.libraries.navigation.internal.ady.al.DRIVE) {
            this.O = j(new as() { // from class: com.google.android.libraries.navigation.internal.bo.af
                @Override // com.google.android.libraries.navigation.internal.yx.as
                public final boolean a(Object obj) {
                    com.google.android.libraries.navigation.internal.cq.k kVar = (com.google.android.libraries.navigation.internal.cq.k) obj;
                    int i = ao.F;
                    return kVar == com.google.android.libraries.navigation.internal.cq.k.HAZMAT_RESTRICTION || kVar == com.google.android.libraries.navigation.internal.cq.k.HEIGHT_RESTRICTION || kVar == com.google.android.libraries.navigation.internal.cq.k.TRUCKS_PROHIBITED_RESTRICTION || kVar == com.google.android.libraries.navigation.internal.cq.k.WEIGHT_RESTRICTION;
                }
            }, true, new as() { // from class: com.google.android.libraries.navigation.internal.bo.ag
                @Override // com.google.android.libraries.navigation.internal.yx.as
                public final boolean a(Object obj) {
                    int i = ao.F;
                    return true;
                }
            }, null, false, false, false);
            k();
            return;
        }
        com.google.android.libraries.navigation.internal.ady.al alVar = this.e;
        if (alVar == com.google.android.libraries.navigation.internal.ady.al.DRIVE || alVar == com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER) {
            this.O = j(new as() { // from class: com.google.android.libraries.navigation.internal.bo.ah
                @Override // com.google.android.libraries.navigation.internal.yx.as
                public final boolean a(Object obj) {
                    com.google.android.libraries.navigation.internal.cq.k kVar = (com.google.android.libraries.navigation.internal.cq.k) obj;
                    if (kVar == com.google.android.libraries.navigation.internal.cq.k.UNPAVED_ROAD) {
                        return true;
                    }
                    ao aoVar = this.a;
                    if (kVar == com.google.android.libraries.navigation.internal.cq.k.NARROW_ROAD && aoVar.e != com.google.android.libraries.navigation.internal.ady.al.TWO_WHEELER) {
                        return true;
                    }
                    if (kVar == com.google.android.libraries.navigation.internal.cq.k.FLYOVER && aoVar.c) {
                        return true;
                    }
                    return kVar == com.google.android.libraries.navigation.internal.cq.k.ICY_ROAD && aoVar.c;
                }
            }, false, new as() { // from class: com.google.android.libraries.navigation.internal.bo.ai
                @Override // com.google.android.libraries.navigation.internal.yx.as
                public final boolean a(Object obj) {
                    ao aoVar = this.a;
                    com.google.android.libraries.navigation.internal.cq.k kVar = (com.google.android.libraries.navigation.internal.cq.k) obj;
                    if (kVar == com.google.android.libraries.navigation.internal.cq.k.UNPAVED_ROAD && aoVar.b) {
                        return true;
                    }
                    return (kVar == com.google.android.libraries.navigation.internal.cq.k.NARROW_ROAD && aoVar.c && aoVar.b) || kVar == com.google.android.libraries.navigation.internal.cq.k.FLYOVER || kVar == com.google.android.libraries.navigation.internal.cq.k.ICY_ROAD;
                }
            }, new as() { // from class: com.google.android.libraries.navigation.internal.bo.aj
                @Override // com.google.android.libraries.navigation.internal.yx.as
                public final boolean a(Object obj) {
                    return ((com.google.android.libraries.navigation.internal.cq.k) obj) == com.google.android.libraries.navigation.internal.cq.k.UNPAVED_ROAD && !this.a.b;
                }
            }, true, true, false);
            if (this.e == com.google.android.libraries.navigation.internal.ady.al.DRIVE) {
                k();
            } else {
                k();
            }
        }
    }

    public final synchronized void f() {
        ev evVarO;
        cd cdVar = this.a;
        cdVar.c();
        synchronized (cdVar) {
            evVarO = ev.o(cdVar.c);
            cdVar.c.clear();
        }
        int size = evVarO.size();
        for (int i = 0; i < size; i++) {
            ((com.google.android.libraries.navigation.internal.ot.q) evVarO.get(i)).c();
        }
        Iterator it2 = cdVar.b.iterator();
        while (it2.hasNext()) {
            cdVar.a.j((com.google.android.libraries.navigation.internal.ol.aq) it2.next());
        }
        cdVar.b.clear();
        g();
        this.k.d();
        com.google.android.libraries.navigation.internal.ck.s sVar = this.t;
        if (sVar != null) {
            ar.q(sVar);
            sVar.b();
            this.t = null;
        }
        if (!this.h.isEmpty()) {
            no it3 = this.h.iterator();
            while (it3.hasNext()) {
                ck ckVar = (ck) it3.next();
                ckVar.c();
                ckVar.b();
            }
            this.h = lv.a;
        }
        g gVar = this.i;
        if (gVar != null) {
            this.u.n(gVar);
            this.i = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void g() {
        h(this.o);
        int i = ev.d;
        this.o = lv.a;
        h(this.O.values());
        this.O = ma.b;
        ev evVar = this.P;
        int i2 = ((lv) evVar).c;
        for (int i3 = 0; i3 < i2; i3++) {
            h(((an) evVar.get(i3)).a);
        }
        this.P = lv.a;
    }
}
