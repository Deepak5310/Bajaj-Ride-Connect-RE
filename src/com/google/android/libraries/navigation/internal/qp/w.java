package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.adi.ap;
import com.google.android.libraries.navigation.internal.adi.bc;
import com.google.android.libraries.navigation.internal.adi.bd;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.ael.dj;
import com.google.android.libraries.navigation.internal.qu.bq;
import com.google.android.libraries.navigation.internal.yx.ao;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import com.google.android.libraries.navigation.internal.yz.cq;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class w {
    private static final com.google.android.libraries.navigation.internal.zb.j d = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.qp.w");
    public final bn b;
    public final com.google.android.libraries.navigation.internal.kl.a c;
    private final com.google.android.libraries.navigation.internal.iv.f f;
    private final com.google.android.libraries.navigation.internal.gg.f g;
    private List i;
    private final br j;
    private final br k;
    private final o l;
    public final cq a = new cq(new ConcurrentHashMap());
    private final AtomicInteger e = new AtomicInteger(0);
    private final Map h = new HashMap();

    public w(com.google.android.libraries.navigation.internal.iv.f fVar, bn bnVar, com.google.android.libraries.navigation.internal.gg.f fVar2, o oVar, com.google.android.libraries.navigation.internal.gd.k kVar, com.google.android.libraries.navigation.internal.kl.a aVar, final com.google.android.libraries.navigation.internal.agl.a aVar2) {
        this.f = fVar;
        this.b = bnVar;
        this.g = fVar2;
        fVar2.b().a(kVar);
        this.l = oVar;
        this.c = aVar;
        this.i = new ArrayList();
        this.j = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.qp.r
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.h) ((com.google.android.libraries.navigation.internal.om.p) aVar2.a()).e()).e);
            }
        });
        this.k = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.qp.s
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                return Boolean.valueOf(((com.google.android.libraries.navigation.internal.om.h) ((com.google.android.libraries.navigation.internal.om.p) aVar2.a()).e()).f);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static an a(x xVar) {
        ev evVar = ((ab) xVar).a;
        ar.b(!evVar.isEmpty(), "No tile requests found in the batch.");
        return ((aa) evVar.get(0)).e();
    }

    private final void f() {
        this.i.clear();
        this.i = new ArrayList();
    }

    public final synchronized List b(ao aoVar) {
        List list;
        list = (List) this.h.get(aoVar);
        ar.q(list);
        this.h.remove(aoVar);
        return list;
    }

    public final synchronized void c(aa aaVar) {
        boolean z;
        List list = (List) this.h.get(aaVar.h());
        boolean z2 = false;
        if (!this.f.y(com.google.android.libraries.navigation.internal.iv.ab.C, false)) {
            if (list != null && !list.isEmpty()) {
                list.add(aaVar);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(aaVar);
            this.h.put(aaVar.h(), arrayList);
            o oVar = this.l;
            List list2 = this.i;
            if (!list2.isEmpty() && ((aa) list2.get(0)).c().a != ((c) aaVar).a.a) {
                z = false;
                break;
            }
            ev evVar = oVar.c;
            int i = 0;
            while (true) {
                if (i >= ((lv) evVar).c) {
                    z = true;
                    break;
                }
                boolean zB = ((y) evVar.get(i)).b(list2, aaVar);
                i++;
                if (!zB) {
                    z = false;
                    break;
                }
            }
            boolean z3 = (!((Boolean) this.j.a()).booleanValue() || this.i.isEmpty() || ((c) aaVar).b.equals(((aa) this.i.get(0)).b())) ? false : true;
            if (((Boolean) this.k.a()).booleanValue() && !this.i.isEmpty() && ((c) aaVar).c != ((aa) this.i.get(0)).a()) {
                z2 = true;
            }
            if (!z) {
                ((com.google.android.libraries.navigation.internal.kk.k) this.c.a(com.google.android.libraries.navigation.internal.km.p.aq)).a(com.google.android.libraries.navigation.internal.km.m.a(1));
            }
            if (z3) {
                ((com.google.android.libraries.navigation.internal.kk.k) this.c.a(com.google.android.libraries.navigation.internal.km.p.aq)).a(com.google.android.libraries.navigation.internal.km.m.a(2));
            }
            if (z2) {
                ((com.google.android.libraries.navigation.internal.kk.k) this.c.a(com.google.android.libraries.navigation.internal.km.p.aq)).a(com.google.android.libraries.navigation.internal.km.m.a(3));
            }
            if (!z || z3 || z2) {
                e(this.i);
                f();
            }
            this.i.add(aaVar);
            if (this.i.size() == 1 && this.l.b.a > 1) {
                final List list3 = this.i;
                com.google.android.libraries.navigation.internal.hx.n.a(this.b.schedule(com.google.android.libraries.navigation.internal.yu.f.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qp.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        w wVar = this.a;
                        List list4 = list3;
                        synchronized (wVar) {
                            if (!list4.isEmpty()) {
                                wVar.e(list4);
                                list4.clear();
                            }
                        }
                    }
                }), 50L, TimeUnit.MILLISECONDS), this.b);
            }
            if (this.l.b.a == this.i.size()) {
                e(this.i);
                f();
            }
        }
    }

    public final void d(x xVar, final com.google.android.libraries.navigation.internal.gg.o oVar) {
        Iterator<E> it2 = ((ab) xVar).a.iterator();
        while (it2.hasNext()) {
            Iterator it3 = b(((aa) it2.next()).h()).iterator();
            while (it3.hasNext()) {
                final com.google.android.libraries.navigation.internal.qu.t tVar = (com.google.android.libraries.navigation.internal.qu.t) ((aa) it3.next()).d();
                com.google.android.libraries.navigation.internal.qu.aa aaVar = tVar.b;
                final bq bqVar = tVar.a;
                aaVar.l.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.qu.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        tVar.a(bqVar, oVar);
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(List list) {
        if (list.isEmpty()) {
            return;
        }
        o oVar = this.l;
        ab abVar = new ab(ev.o(list), oVar.c, oVar.d, (com.google.android.libraries.navigation.internal.fu.a) oVar.a.a());
        this.e.incrementAndGet();
        try {
            boolean z = true;
            ar.b(!abVar.a.isEmpty(), "No tile requests present in the batch. Can't create a PaintRequest.");
            com.google.android.libraries.navigation.internal.adi.aj ajVar = abVar.b;
            if (ajVar == null) {
                throw new IllegalArgumentException("No paint request template found for given tile type: ".concat(String.valueOf(abVar.f.name())));
            }
            com.google.android.libraries.navigation.internal.gp.b bVarB = null;
            bb bbVar = (bb) ajVar.aH(5, null);
            bbVar.x(ajVar);
            com.google.android.libraries.navigation.internal.adi.ag agVar = (com.google.android.libraries.navigation.internal.adi.ag) bbVar;
            if (!agVar.b.H()) {
                agVar.v();
            }
            ((com.google.android.libraries.navigation.internal.adi.aj) agVar.b).c = dj.b;
            ev evVar = abVar.a;
            int size = evVar.size();
            for (int i = 0; i < size; i++) {
                aa aaVar = (aa) evVar.get(i);
                bc bcVar = (bc) bd.a.q();
                com.google.android.libraries.navigation.internal.aeg.c cVar = (com.google.android.libraries.navigation.internal.aeg.c) com.google.android.libraries.navigation.internal.aeg.d.a.q();
                int i2 = aaVar.c().a;
                if (!cVar.b.H()) {
                    cVar.v();
                }
                com.google.android.libraries.navigation.internal.aeg.d dVar = (com.google.android.libraries.navigation.internal.aeg.d) cVar.b;
                dVar.b |= 1;
                dVar.c = i2;
                int i3 = aaVar.c().b;
                if (!cVar.b.H()) {
                    cVar.v();
                }
                com.google.android.libraries.navigation.internal.aeg.d dVar2 = (com.google.android.libraries.navigation.internal.aeg.d) cVar.b;
                dVar2.b |= 2;
                dVar2.d = i3;
                int i4 = aaVar.c().c;
                if (!cVar.b.H()) {
                    cVar.v();
                }
                com.google.android.libraries.navigation.internal.aeg.d dVar3 = (com.google.android.libraries.navigation.internal.aeg.d) cVar.b;
                dVar3.b |= 4;
                dVar3.e = i4;
                com.google.android.libraries.navigation.internal.aeg.d dVar4 = (com.google.android.libraries.navigation.internal.aeg.d) cVar.t();
                if (!bcVar.b.H()) {
                    bcVar.v();
                }
                bd bdVar = (bd) bcVar.b;
                dVar4.getClass();
                bdVar.c = dVar4;
                bdVar.b |= 1;
                String strF = aaVar.f();
                if (!bcVar.b.H()) {
                    bcVar.v();
                }
                bd bdVar2 = (bd) bcVar.b;
                strF.getClass();
                bdVar2.b |= 64;
                bdVar2.e = strF;
                if (!aaVar.g()) {
                    if (!bcVar.b.H()) {
                        bcVar.v();
                    }
                    bd bdVar3 = (bd) bcVar.b;
                    bdVar3.b |= 128;
                    bdVar3.f = false;
                }
                agVar.e((bd) bcVar.t());
            }
            ap apVar = ((com.google.android.libraries.navigation.internal.adi.aj) agVar.b).e;
            if (apVar == null) {
                apVar = ap.a;
            }
            bb bbVar2 = (bb) apVar.aH(5, null);
            bbVar2.x(apVar);
            com.google.android.libraries.navigation.internal.adi.ao aoVar = (com.google.android.libraries.navigation.internal.adi.ao) bbVar2;
            String str = abVar.d;
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ap apVar2 = (ap) aoVar.b;
            str.getClass();
            apVar2.b |= 1;
            apVar2.c = str;
            String str2 = abVar.e;
            if (!aoVar.b.H()) {
                aoVar.v();
            }
            ap apVar3 = (ap) aoVar.b;
            str2.getClass();
            apVar3.b |= 2;
            apVar3.d = str2;
            ap apVar4 = (ap) aoVar.t();
            if (!agVar.b.H()) {
                agVar.v();
            }
            com.google.android.libraries.navigation.internal.adi.aj ajVar2 = (com.google.android.libraries.navigation.internal.adi.aj) agVar.b;
            apVar4.getClass();
            ajVar2.e = apVar4;
            ajVar2.b |= 2;
            com.google.android.libraries.navigation.internal.pt.d dVar5 = abVar.f == an.GMM_INDOOR ? ((aa) abVar.a.get(0)).c().d : null;
            ev evVar2 = abVar.c;
            int i5 = ((lv) evVar2).c;
            for (int i6 = 0; i6 < i5; i6++) {
                ((y) evVar2.get(i6)).a(dVar5, agVar);
            }
            com.google.android.libraries.navigation.internal.adi.aj ajVar3 = (com.google.android.libraries.navigation.internal.adi.aj) agVar.t();
            com.google.android.libraries.navigation.internal.gg.f fVar = this.g;
            ev evVar3 = abVar.a;
            com.google.android.libraries.navigation.internal.gh.c cVarB = fVar.b();
            cVarB.k = evVar3.isEmpty() ? com.google.android.libraries.navigation.internal.xn.a.d("EMPTY") : com.google.android.libraries.navigation.internal.xn.a.e(a(abVar));
            try {
                if (((Boolean) this.k.a()).booleanValue()) {
                    com.google.android.libraries.navigation.internal.gd.i iVar = new com.google.android.libraries.navigation.internal.gh.d(cVarB).b;
                    bb bbVar3 = (bb) iVar.aH(5, null);
                    bbVar3.x(iVar);
                    com.google.android.libraries.navigation.internal.gd.f fVar2 = (com.google.android.libraries.navigation.internal.gd.f) bbVar3;
                    ev evVar4 = abVar.a;
                    com.google.android.libraries.navigation.internal.gd.h hVarA = (evVar4.isEmpty() || ((aa) evVar4.get(0)).a() == null) ? com.google.android.libraries.navigation.internal.gd.h.UNSPECIFIED : ((aa) evVar4.get(0)).a();
                    if (!fVar2.b.H()) {
                        fVar2.v();
                    }
                    com.google.android.libraries.navigation.internal.gd.i iVar2 = (com.google.android.libraries.navigation.internal.gd.i) fVar2.b;
                    iVar2.k = hVarA.d;
                    iVar2.b |= 256;
                    cVarB.a = (com.google.android.libraries.navigation.internal.gd.i) fVar2.t();
                }
                ev evVar5 = abVar.a;
                if (evVar5.isEmpty() || !evVar5.stream().anyMatch(new Predicate() { // from class: com.google.android.libraries.navigation.internal.qp.q
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj) {
                        aa aaVar2 = (aa) obj;
                        aaVar2.b();
                        return aaVar2.b().a();
                    }
                })) {
                    z = false;
                }
                if (((Boolean) this.j.a()).booleanValue() && z) {
                    bVarB = ((aa) evVar5.get(0)).b();
                }
                cVarB.l = bVarB;
                this.g.a().a(ajVar3, new v(this, abVar), this.b);
            } catch (IllegalArgumentException e) {
                ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1112)).p("Received error in creating the Paint request proto. Error:");
                com.google.android.libraries.navigation.internal.gg.o oVarB = com.google.android.libraries.navigation.internal.gg.o.b(e);
                d(abVar, oVarB);
                com.google.android.libraries.navigation.internal.qm.a.b(this.c, a(abVar), oVarB.e());
                this.a.add(oVarB.e());
            }
        } catch (IllegalArgumentException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1113)).p("Received error in creating the Paint request proto. Refreshing client parameters. Error:");
            com.google.android.libraries.navigation.internal.gg.o oVar2 = com.google.android.libraries.navigation.internal.gg.o.o;
            d(abVar, oVar2);
            com.google.android.libraries.navigation.internal.qm.a.b(this.c, a(abVar), oVar2.e());
            this.a.add(oVar2.e());
        }
    }
}
