package com.google.android.libraries.navigation.internal.we;

import android.app.Application;
import android.content.Context;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.add.bw;
import com.google.android.libraries.navigation.internal.add.bx;
import com.google.android.libraries.navigation.internal.add.by;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ez;
import com.google.android.libraries.navigation.internal.yz.nn;
import j$.time.Instant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements a, l {
    public final aa a;
    public final i b;
    public final com.google.android.libraries.navigation.internal.kl.b c;
    public final Executor d;
    public int e;
    public final aw f;
    public final af g;
    private final Context h;
    private final com.google.android.libraries.navigation.internal.so.b i;

    public g(Application application, com.google.android.libraries.navigation.internal.so.b bVar, aa aaVar, aw awVar, i iVar, com.google.android.libraries.navigation.internal.kl.b bVar2, af afVar, Executor executor) {
        this.h = application;
        this.i = bVar;
        this.a = aaVar;
        this.f = awVar;
        this.b = iVar;
        this.c = bVar2;
        this.g = afVar;
        this.d = executor;
        e();
    }

    public static final void e() {
        com.google.android.libraries.navigation.internal.rw.b.a().a();
    }

    @Override // com.google.android.libraries.navigation.internal.we.a
    public final bj a(final com.google.android.libraries.navigation.internal.add.bd bdVar) {
        return com.google.android.libraries.navigation.internal.yu.c.a(new com.google.android.libraries.navigation.internal.aac.s() { // from class: com.google.android.libraries.navigation.internal.we.f
            @Override // com.google.android.libraries.navigation.internal.aac.s
            public final bj a() {
                final g gVar = this.a;
                int iE = gVar.g.e();
                if (iE != com.google.android.libraries.navigation.internal.add.ab.b) {
                    com.google.android.libraries.navigation.internal.add.ab.a(iE);
                    if (iE == 0) {
                        throw null;
                    }
                    ((com.google.android.libraries.navigation.internal.kk.k) gVar.c.a(com.google.android.libraries.navigation.internal.km.ak.c)).a(com.google.android.libraries.navigation.internal.km.ai.a(1));
                    return com.google.android.libraries.navigation.internal.aac.az.g(new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.ALREADY_EXISTS, "Active guidance session already running.", null)));
                }
                com.google.android.libraries.navigation.internal.add.bd bdVar2 = bdVar;
                gVar.g.d(aw.a());
                gVar.g.f(com.google.android.libraries.navigation.internal.add.ab.c);
                g.e();
                aa aaVar = gVar.a;
                com.google.android.libraries.navigation.internal.add.aw awVar = bdVar2.c;
                if (awVar == null) {
                    awVar = com.google.android.libraries.navigation.internal.add.aw.a;
                }
                return com.google.android.libraries.navigation.internal.yu.a.b(aaVar.a(awVar, gVar.d)).c(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.we.c
                    @Override // com.google.android.libraries.navigation.internal.yx.aa
                    public final Object ak(Object obj) {
                        g gVar2 = gVar;
                        com.google.android.libraries.navigation.internal.wl.d dVar = (com.google.android.libraries.navigation.internal.wl.d) obj;
                        if (gVar2.g.e() == com.google.android.libraries.navigation.internal.add.ab.b) {
                            ((com.google.android.libraries.navigation.internal.kk.k) gVar2.c.a(com.google.android.libraries.navigation.internal.km.ak.c)).a(com.google.android.libraries.navigation.internal.km.ai.a(2));
                            throw new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.CANCELLED, "startActiveGuidance() failed. Guidance is stopped.", null));
                        }
                        gVar2.d(dVar);
                        gVar2.g.f(com.google.android.libraries.navigation.internal.add.ab.d);
                        String strE = gVar2.b.e();
                        com.google.android.libraries.navigation.internal.wo.a.a(strE);
                        com.google.android.libraries.navigation.internal.add.be beVar = (com.google.android.libraries.navigation.internal.add.be) com.google.android.libraries.navigation.internal.add.bf.a.q();
                        com.google.android.libraries.navigation.internal.add.aa aaVar2 = (com.google.android.libraries.navigation.internal.add.aa) com.google.android.libraries.navigation.internal.add.ac.a.q();
                        String strA = gVar2.g.a();
                        if (!aaVar2.b.H()) {
                            aaVar2.v();
                        }
                        com.google.android.libraries.navigation.internal.add.ac acVar = (com.google.android.libraries.navigation.internal.add.ac) aaVar2.b;
                        strA.getClass();
                        acVar.b = strA;
                        int iE2 = gVar2.g.e();
                        if (!aaVar2.b.H()) {
                            aaVar2.v();
                        }
                        ((com.google.android.libraries.navigation.internal.add.ac) aaVar2.b).c = com.google.android.libraries.navigation.internal.add.ab.b(iE2);
                        com.google.android.libraries.navigation.internal.add.ac acVar2 = (com.google.android.libraries.navigation.internal.add.ac) aaVar2.t();
                        if (!beVar.b.H()) {
                            beVar.v();
                        }
                        com.google.android.libraries.navigation.internal.add.bf bfVar = (com.google.android.libraries.navigation.internal.add.bf) beVar.b;
                        acVar2.getClass();
                        bfVar.c = acVar2;
                        bfVar.b |= 1;
                        if (!beVar.b.H()) {
                            beVar.v();
                        }
                        com.google.android.libraries.navigation.internal.add.bf bfVar2 = (com.google.android.libraries.navigation.internal.add.bf) beVar.b;
                        bfVar2.b |= 2;
                        bfVar2.d = strE;
                        return (com.google.android.libraries.navigation.internal.add.bf) beVar.t();
                    }
                }, gVar.d).a(Exception.class, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.we.d
                    @Override // com.google.android.libraries.navigation.internal.aac.t
                    public final bj a(Object obj) {
                        ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 1947)).p("Failed to start guidance with fetched routes.");
                        g gVar2 = gVar;
                        gVar2.g.c();
                        gVar2.b.f();
                        g.e();
                        gVar2.g.b();
                        return com.google.android.libraries.navigation.internal.aac.az.g((Exception) obj);
                    }
                }, gVar.d);
            }
        }, this.d);
    }

    @Override // com.google.android.libraries.navigation.internal.we.a
    public final bj b(final bw bwVar) {
        return com.google.android.libraries.navigation.internal.yu.c.a(new com.google.android.libraries.navigation.internal.aac.s() { // from class: com.google.android.libraries.navigation.internal.we.b
            @Override // com.google.android.libraries.navigation.internal.aac.s
            public final bj a() {
                final g gVar = this.a;
                int iE = gVar.g.e();
                if (iE != com.google.android.libraries.navigation.internal.add.ab.d) {
                    com.google.android.libraries.navigation.internal.add.ab.a(iE);
                    if (iE == 0) {
                        throw null;
                    }
                    ((com.google.android.libraries.navigation.internal.kk.k) gVar.c.a(com.google.android.libraries.navigation.internal.km.ak.d)).a(com.google.android.libraries.navigation.internal.km.aj.a(1));
                    return com.google.android.libraries.navigation.internal.aac.az.g(new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.FAILED_PRECONDITION, "No active guidance session running.", null)));
                }
                bw bwVar2 = bwVar;
                final int i = gVar.e + 1;
                gVar.e = i;
                com.google.android.libraries.navigation.internal.add.aw awVarC = gVar.b.c();
                com.google.android.libraries.navigation.internal.add.aw awVar = bwVar2.c;
                if (awVar == null) {
                    awVar = com.google.android.libraries.navigation.internal.add.aw.a;
                }
                if (awVarC.equals(awVar)) {
                    ((com.google.android.libraries.navigation.internal.kk.k) gVar.c.a(com.google.android.libraries.navigation.internal.km.ak.d)).a(com.google.android.libraries.navigation.internal.km.aj.a(2));
                    return com.google.android.libraries.navigation.internal.aac.az.g(new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.ALREADY_EXISTS, "Already guiding the same route set.", null)));
                }
                i iVar = gVar.b;
                com.google.android.libraries.navigation.internal.add.aw awVar2 = bwVar2.c;
                if (awVar2 == null) {
                    awVar2 = com.google.android.libraries.navigation.internal.add.aw.a;
                }
                com.google.android.libraries.navigation.internal.wl.d dVarA = iVar.a(awVar2);
                if (dVarA != null) {
                    return gVar.c(dVarA, i);
                }
                aa aaVar = gVar.a;
                com.google.android.libraries.navigation.internal.add.aw awVar3 = bwVar2.c;
                if (awVar3 == null) {
                    awVar3 = com.google.android.libraries.navigation.internal.add.aw.a;
                }
                return com.google.android.libraries.navigation.internal.yu.c.c(aaVar.a(awVar3, gVar.d), new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.we.e
                    @Override // com.google.android.libraries.navigation.internal.aac.t
                    public final bj a(Object obj) {
                        return gVar.c((com.google.android.libraries.navigation.internal.wl.d) obj, i);
                    }
                }, gVar.d);
            }
        }, this.d);
    }

    public final bj c(com.google.android.libraries.navigation.internal.wl.d dVar, int i) {
        if (this.g.e() == com.google.android.libraries.navigation.internal.add.ab.b) {
            ((com.google.android.libraries.navigation.internal.kk.k) this.c.a(com.google.android.libraries.navigation.internal.km.ak.d)).a(com.google.android.libraries.navigation.internal.km.aj.a(3));
            return com.google.android.libraries.navigation.internal.aac.az.g(new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.CANCELLED, "Guidance was stopped while updateRoutes() was processing.", null)));
        }
        if (i != this.e) {
            ((com.google.android.libraries.navigation.internal.kk.k) this.c.a(com.google.android.libraries.navigation.internal.km.ak.d)).a(com.google.android.libraries.navigation.internal.km.aj.a(4));
            return com.google.android.libraries.navigation.internal.aac.az.g(new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.CANCELLED, "Cancelled obsolete UpdateRoutes request.", null)));
        }
        d(dVar);
        String strE = this.b.e();
        com.google.android.libraries.navigation.internal.wo.a.a(strE);
        bx bxVar = (bx) by.a.q();
        com.google.android.libraries.navigation.internal.add.aa aaVar = (com.google.android.libraries.navigation.internal.add.aa) com.google.android.libraries.navigation.internal.add.ac.a.q();
        String strA = this.g.a();
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        com.google.android.libraries.navigation.internal.add.ac acVar = (com.google.android.libraries.navigation.internal.add.ac) aaVar.b;
        strA.getClass();
        acVar.b = strA;
        int iE = this.g.e();
        if (!aaVar.b.H()) {
            aaVar.v();
        }
        ((com.google.android.libraries.navigation.internal.add.ac) aaVar.b).c = com.google.android.libraries.navigation.internal.add.ab.b(iE);
        com.google.android.libraries.navigation.internal.add.ac acVar2 = (com.google.android.libraries.navigation.internal.add.ac) aaVar.t();
        if (!bxVar.b.H()) {
            bxVar.v();
        }
        by byVar = (by) bxVar.b;
        acVar2.getClass();
        byVar.c = acVar2;
        byVar.b |= 1;
        if (!bxVar.b.H()) {
            bxVar.v();
        }
        by byVar2 = (by) bxVar.b;
        byVar2.b |= 2;
        byVar2.d = strE;
        return com.google.android.libraries.navigation.internal.aac.az.h((by) bxVar.t());
    }

    public final void d(com.google.android.libraries.navigation.internal.wl.d dVar) {
        com.google.android.libraries.navigation.internal.ade.p pVar = dVar.b().c;
        if (pVar == null) {
            pVar = com.google.android.libraries.navigation.internal.ade.p.a;
        }
        String str = pVar.b;
        com.google.android.libraries.navigation.internal.wl.c cVar = (com.google.android.libraries.navigation.internal.wl.c) dVar.a().get(str);
        if (cVar == null) {
            ((com.google.android.libraries.navigation.internal.kk.k) this.c.a(com.google.android.libraries.navigation.internal.km.ak.c)).a(com.google.android.libraries.navigation.internal.km.ai.a(3));
            throw new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.INTERNAL, "Selected route bundle is null.", null));
        }
        if (dVar.a().keySet().equals(this.b.b().keySet())) {
            com.google.android.libraries.navigation.internal.ade.p pVar2 = this.b.c().c;
            if (pVar2 == null) {
                pVar2 = com.google.android.libraries.navigation.internal.ade.p.a;
            }
            if (!pVar2.b.equals(str)) {
                this.i.c(str);
                return;
            }
        }
        com.google.android.libraries.navigation.internal.bp.bg bgVarA = cVar.a();
        HashMap map = new HashMap();
        nn nnVarListIterator = dVar.a().entrySet().listIterator();
        while (nnVarListIterator.hasNext()) {
            Map.Entry entry = (Map.Entry) nnVarListIterator.next();
            map.put(Integer.valueOf(((com.google.android.libraries.navigation.internal.wl.c) entry.getValue()).a().f), (String) entry.getKey());
        }
        com.google.android.libraries.navigation.internal.bp.af afVar = new com.google.android.libraries.navigation.internal.bp.af(bgVarA.d, bgVarA.e);
        com.google.android.libraries.navigation.internal.bp.ah ahVar = new com.google.android.libraries.navigation.internal.bp.ah();
        ahVar.a = afVar;
        ahVar.c = bgVarA.j;
        ahVar.d(bgVarA.p);
        ahVar.c(bgVarA.P);
        for (Map.Entry entry2 : map.entrySet()) {
            Integer num = (Integer) entry2.getKey();
            num.intValue();
            ahVar.b.put(num, (String) entry2.getValue());
        }
        ahVar.h = Instant.ofEpochMilli(bgVarA.i.toEpochMilli());
        com.google.android.libraries.navigation.internal.bp.ai aiVar = new com.google.android.libraries.navigation.internal.bp.ai(ahVar);
        ez ezVar = new ez();
        com.google.android.libraries.navigation.internal.ade.p pVar3 = dVar.b().c;
        if (pVar3 == null) {
            pVar3 = com.google.android.libraries.navigation.internal.ade.p.a;
        }
        ezVar.f(pVar3.b, g((com.google.android.libraries.navigation.internal.wl.c) dVar.a().get(pVar3.b), aiVar));
        for (com.google.android.libraries.navigation.internal.ade.p pVar4 : dVar.b().d) {
            ezVar.f(pVar4.b, g((com.google.android.libraries.navigation.internal.wl.c) dVar.a().get(pVar4.b), aiVar));
        }
        try {
            com.google.android.libraries.navigation.internal.wl.b bVar = new com.google.android.libraries.navigation.internal.wl.b(dVar.b(), ezVar.d());
            if (this.b.g(bVar, cVar.b())) {
                this.b.h();
            }
            com.google.android.libraries.navigation.internal.ade.p pVar5 = bVar.a.c;
            if (pVar5 == null) {
                pVar5 = com.google.android.libraries.navigation.internal.ade.p.a;
            }
            eq eqVar = new eq();
            com.google.android.libraries.navigation.internal.wl.c cVar2 = (com.google.android.libraries.navigation.internal.wl.c) bVar.b.get(pVar5.b);
            if (cVar2 != null) {
                eqVar.h(cVar2.a());
            }
            Iterator it2 = bVar.a.d.iterator();
            while (it2.hasNext()) {
                com.google.android.libraries.navigation.internal.wl.c cVar3 = (com.google.android.libraries.navigation.internal.wl.c) bVar.b.get(((com.google.android.libraries.navigation.internal.ade.p) it2.next()).b);
                if (cVar3 != null) {
                    eqVar.h(cVar3.a());
                }
            }
            this.i.a(new com.google.android.libraries.navigation.internal.so.e(com.google.android.libraries.navigation.internal.so.d.b(bh.h(0, eqVar.g()), aiVar.b())));
        } catch (IllegalArgumentException e) {
            ((com.google.android.libraries.navigation.internal.kk.j) this.c.a(com.google.android.libraries.navigation.internal.km.ak.e)).a();
            throw new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.INTERNAL, e.getMessage(), e.getCause()));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.we.l
    public final void f() {
    }

    private final com.google.android.libraries.navigation.internal.wl.c g(com.google.android.libraries.navigation.internal.wl.c cVar, com.google.android.libraries.navigation.internal.bp.ai aiVar) {
        if (cVar == null) {
            ((com.google.android.libraries.navigation.internal.kk.j) this.c.a(com.google.android.libraries.navigation.internal.km.ak.e)).a();
            throw new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.INTERNAL, "Existing route bundle is null.", null));
        }
        int i = cVar.a().f;
        com.google.android.libraries.navigation.internal.bp.bg bgVarA = aiVar.a(i, this.h);
        if (bgVarA != null) {
            return new com.google.android.libraries.navigation.internal.wl.a(bgVarA, cVar.b());
        }
        ((com.google.android.libraries.navigation.internal.kk.j) this.c.a(com.google.android.libraries.navigation.internal.km.ak.e)).a();
        throw new com.google.android.libraries.navigation.internal.wq.b(new com.google.android.libraries.navigation.internal.wq.a(com.google.android.libraries.navigation.internal.aei.a.INTERNAL, String.format("RouteDescription for trip index %s is null.", Integer.valueOf(i)), null));
    }
}
