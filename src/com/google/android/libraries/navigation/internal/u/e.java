package com.google.android.libraries.navigation.internal.u;

import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.navigation.internal.adi.af;
import com.google.android.libraries.navigation.internal.adi.an;
import com.google.android.libraries.navigation.internal.db.r;
import com.google.android.libraries.navigation.internal.db.s;
import com.google.android.libraries.navigation.internal.hj.i;
import com.google.android.libraries.navigation.internal.hm.o;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.ia.k;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.po.fk;
import com.google.android.libraries.navigation.internal.po.g;
import com.google.android.libraries.navigation.internal.qd.w;
import com.google.android.libraries.navigation.internal.qk.n;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends k {
    private final int f;

    public e(int i, Class cls, c cVar, ap apVar) {
        super(cls, cVar, apVar, null);
        this.f = i;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x022a */
    @Override // com.google.android.libraries.navigation.internal.ia.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        w wVarB;
        r rVar;
        int i = this.f;
        if (i == 0) {
            com.google.android.libraries.navigation.internal.oa.e eVarB = ((c) this.c).a.b();
            fk fkVar = (fk) eVarB;
            i iVarC = fkVar.af.c();
            if (am.a(fkVar.E, iVarC)) {
                return;
            }
            fkVar.E = iVarC;
            com.google.android.libraries.navigation.internal.pu.k kVar = fkVar.aq;
            if (kVar == null || !kVar.c()) {
                nn nnVarListIterator = fkVar.al.b.keySet().listIterator();
                while (nnVarListIterator.hasNext()) {
                    an anVar = (an) nnVarListIterator.next();
                    if (anVar != an.GMM_BASEMAP_PHOTOS || !fkVar.al.d(fkVar.W.get())) {
                        if (fkVar.al.c(anVar)) {
                            if (fkVar.E == null) {
                                fkVar.E = fkVar.af.c();
                            }
                            synchronized (fkVar.O) {
                                i iVar = ((fk) eVarB).E;
                                com.google.android.libraries.navigation.internal.oe.ap apVarC = ((fk) eVarB).I(anVar) ? ((fk) eVarB).s.c(anVar, ((fk) eVarB).E.c) : null;
                                if (((fk) eVarB).al.b(anVar)) {
                                    apVarC = ((fk) eVarB).s.b(anVar);
                                }
                                if ((((fk) eVarB).O.containsKey(anVar) || apVarC != null) && (!((fk) eVarB).O.containsKey(anVar) || !am.a(((w) ((fk) eVarB).O.get(anVar)).d, apVarC))) {
                                    if (apVarC != null) {
                                        cg cgVarB = ((fk) eVarB).b();
                                        synchronized (((fk) eVarB).P) {
                                            try {
                                                wVarB = ((fk) eVarB).r.b(apVarC, cgVarB, ((g) ((fk) eVarB).Q).a, false);
                                            } catch (Throwable th) {
                                                throw th;
                                            }
                                        }
                                    } else {
                                        wVarB = null;
                                    }
                                    if (wVarB != null) {
                                        if (((fk) eVarB).O.containsKey(anVar)) {
                                            ((fk) eVarB).U.o((com.google.android.libraries.navigation.internal.qd.d) ((fk) eVarB).O.get(anVar), wVarB);
                                        } else {
                                            ((fk) eVarB).U.g(wVarB);
                                        }
                                        ((fk) eVarB).O.put(anVar, wVarB);
                                    } else if (((fk) eVarB).O.containsKey(anVar)) {
                                        ((fk) eVarB).U.n((com.google.android.libraries.navigation.internal.qd.d) ((fk) eVarB).O.get(anVar));
                                        ((fk) eVarB).O.remove(anVar);
                                    }
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
                return;
            }
            return;
        }
        if (i == 1) {
            ((c) this.c).a.u(((com.google.android.libraries.navigation.internal.ql.b) aVar).a);
            return;
        }
        if (i == 2) {
            ((c) this.c).a.k();
            return;
        }
        if (i == 3) {
            c cVar = (c) this.c;
            final o oVar = (o) aVar;
            cVar.b.ifPresent(new Consumer() { // from class: com.google.android.libraries.navigation.internal.u.b
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((com.google.android.libraries.navigation.internal.oo.e) obj).a((af) oVar.c().a());
                }
            });
            cVar.a.p();
            return;
        }
        com.google.android.libraries.navigation.internal.oa.k kVar2 = ((c) this.c).a;
        final r rVarD = ((s) aVar).d();
        com.google.android.libraries.navigation.internal.oa.e eVarB2 = kVar2.b();
        if (rVarD != null) {
            final fk fkVar2 = (fk) eVarB2;
            if (fkVar2.ao != com.google.android.libraries.navigation.internal.ql.a.OFF) {
                fkVar2.z.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.ei
                    @Override // java.lang.Runnable
                    public final void run() {
                        com.google.android.libraries.navigation.internal.pt.d dVar;
                        fk fkVar3 = fkVar2;
                        com.google.android.libraries.navigation.internal.ps.y yVar = fkVar3.X;
                        com.google.android.libraries.navigation.internal.ql.a aVar2 = fkVar3.ao;
                        if (yVar.j()) {
                            com.google.android.libraries.navigation.internal.of.a aVar3 = rVarD;
                            if (aVar2 == com.google.android.libraries.navigation.internal.ql.a.OFF || (dVar = ((com.google.android.libraries.navigation.internal.db.r) aVar3).f387n) == null) {
                                return;
                            }
                            yVar.h(dVar.b);
                        }
                    }
                });
            }
            rVar = rVarD;
        } else {
            rVar = null;
        }
        n nVar = ((fk) eVarB2).K;
        if (!nVar.g) {
            com.google.android.libraries.navigation.internal.qk.o oVar2 = nVar.e;
            if (rVar != null) {
                oVar2.e = x.A(rVar.b, rVar.c);
            } else {
                oVar2.e = null;
            }
        }
        if (kVar2.j && ((com.google.android.libraries.navigation.internal.ob.f) kVar2.g.a()).e()) {
            com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("MapContainer.changeLocation");
            if (rVarD != null) {
                try {
                    kVar2.n();
                    com.google.android.libraries.navigation.internal.pd.d dVarD = kVar2.d();
                    if (dVarD != null) {
                        com.google.android.libraries.navigation.internal.pd.a aVar2 = new com.google.android.libraries.navigation.internal.pd.a(dVarD);
                        ((com.google.android.libraries.navigation.internal.ob.f) kVar2.g.a()).f(aVar2, rVarD.m());
                        kVar2.b().n(new com.google.android.libraries.navigation.internal.pb.d(aVar2.a()));
                    }
                } catch (Throwable th2) {
                    if (dVarB != null) {
                        try {
                            Trace.endSection();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        }
    }
}
