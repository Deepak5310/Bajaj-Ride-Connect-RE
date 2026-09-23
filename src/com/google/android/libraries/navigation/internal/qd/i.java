package com.google.android.libraries.navigation.internal.qd;

import androidx.tracing.Trace;
import com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable.ac;
import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.geo.mapcore.internal.model.ct;
import com.google.android.libraries.geo.mapcore.renderer.ax;
import com.google.android.libraries.navigation.internal.adg.bj;
import com.google.android.libraries.navigation.internal.adg.ef;
import com.google.android.libraries.navigation.internal.ael.bh;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.agi.gs;
import com.google.android.libraries.navigation.internal.agi.gt;
import com.google.android.libraries.navigation.internal.oe.ap;
import com.google.android.libraries.navigation.internal.oe.at;
import com.google.android.libraries.navigation.internal.ol.ai;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.as;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends w implements com.google.android.libraries.navigation.internal.ps.p {
    private static final ap O = ap.a();
    private final ai P;
    private com.google.android.libraries.navigation.internal.ps.o Q;
    private volatile com.google.android.libraries.navigation.internal.qi.f R;
    private com.google.android.libraries.navigation.internal.ps.k S;
    private final Object T;
    private final List U;
    final as a;

    public i(ax axVar, com.google.android.libraries.navigation.internal.pb.t tVar, ap apVar, cg cgVar, com.google.android.libraries.navigation.internal.qv.k kVar, com.google.android.libraries.navigation.internal.qg.j jVar, k kVar2, com.google.android.libraries.navigation.internal.qf.d dVar, com.google.android.libraries.navigation.internal.mj.a aVar, ScheduledExecutorService scheduledExecutorService, com.google.android.libraries.navigation.internal.rc.f fVar, com.google.android.libraries.navigation.internal.pg.h hVar, ct ctVar, int i, ai aiVar, com.google.android.libraries.navigation.internal.qs.a aVar2, at atVar, boolean z, com.google.android.libraries.navigation.internal.afo.a aVar3, boolean z2) {
        super(axVar, tVar, apVar, cgVar, kVar, jVar, kVar2, dVar, aVar, scheduledExecutorService, fVar, new h(hVar, ctVar), null, null, i, true, 256, false, true, null, aVar2, atVar, z, aVar3, false, false, false, com.google.android.libraries.navigation.internal.yx.a.a);
        this.R = null;
        this.T = new Object();
        this.U = new ArrayList();
        this.a = new as() { // from class: com.google.android.libraries.navigation.internal.qd.g
            @Override // com.google.android.libraries.navigation.internal.yx.as
            public final boolean a(Object obj) {
                return this.a.r((ef) obj);
            }
        };
        this.P = aiVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ps.p
    public final void b(com.google.android.libraries.navigation.internal.ps.k kVar) {
        if (this.Q == null) {
            return;
        }
        synchronized (this.T) {
            this.S = kVar;
            com.google.android.libraries.navigation.internal.ps.o oVar = this.Q;
            synchronized (oVar.c) {
                oVar.b = kVar;
            }
            oVar.a = true;
        }
        this.A.o();
    }

    @Override // com.google.android.libraries.navigation.internal.qd.w
    public final w g(cg cgVar, com.google.android.libraries.navigation.internal.qv.k kVar) {
        com.google.android.libraries.navigation.internal.ps.k kVar2;
        com.google.android.libraries.navigation.internal.qg.j jVarC = this.g.c(cgVar, kVar);
        h hVar = (h) this.v;
        com.google.android.libraries.navigation.internal.pg.h hVar2 = hVar.a;
        ct ctVar = hVar.b;
        int i = this.i;
        ai aiVar = this.P;
        k kVar3 = this.z;
        com.google.android.libraries.navigation.internal.qs.a aVar = this.N;
        com.google.android.libraries.navigation.internal.qf.d dVar = this.D;
        at atVar = this.G;
        ax axVar = this.A;
        com.google.android.libraries.navigation.internal.mj.a aVar2 = this.k;
        boolean z = this.J;
        i iVar = new i(axVar, this.H, this.d, cgVar, kVar, jVarC, kVar3, dVar, aVar2, this.C, this.f, hVar2, ctVar, i, aiVar, aVar, atVar, z, this.K, false);
        synchronized (this.T) {
            kVar2 = this.S;
        }
        if (kVar2 != null) {
            iVar.y();
            iVar.b(kVar2);
        }
        return iVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qd.w, com.google.android.libraries.navigation.internal.qd.d
    public final void k() {
        super.k();
        this.P.f(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.qd.w, com.google.android.libraries.navigation.internal.qd.d
    public final void l() {
        super.l();
        this.P.k(this.a);
    }

    @Override // com.google.android.libraries.navigation.internal.qd.w, com.google.android.libraries.navigation.internal.qd.d
    public final void m(com.google.android.libraries.navigation.internal.qq.f fVar, boolean z) {
        if (n(fVar)) {
            super.m(fVar, z);
            this.R = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qd.w
    protected final com.google.android.libraries.navigation.internal.qi.e o(cd cdVar, long j, com.google.android.libraries.navigation.internal.qi.f fVar) {
        com.google.android.libraries.navigation.internal.qi.e eVarO = super.o(cdVar, j, fVar);
        if (eVarO != null) {
            return eVarO;
        }
        if (this.R == null && fVar != null) {
            this.R = com.google.android.libraries.navigation.internal.qi.f.g(O, fVar.d(), fVar.c(), fVar.e(), Integer.valueOf(fVar.a()), null);
        }
        return this.g.d(cdVar, j, this.R);
    }

    @Override // com.google.android.libraries.navigation.internal.qd.w
    protected final void p(com.google.android.libraries.navigation.internal.pg.f fVar) {
        this.Q = (com.google.android.libraries.navigation.internal.ps.o) fVar;
        super.p(fVar);
    }

    @Override // com.google.android.libraries.navigation.internal.qd.w
    protected final boolean q(List list, int i, com.google.android.libraries.navigation.internal.oe.x xVar, long j, Set set) {
        com.google.android.libraries.navigation.internal.pt.c cVarA;
        this.U.clear();
        com.google.android.libraries.navigation.internal.ps.o oVar = this.Q;
        if (oVar != null) {
            List list2 = this.U;
            synchronized (oVar.d) {
                list2.clear();
                list2.addAll(oVar.d.c);
            }
        }
        list.addAll(this.U);
        boolean zQ = super.q(list, i, xVar, j, set);
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("IndoorTileOverlay.updateFocusForGLTiles");
        try {
            synchronized (this.T) {
                if (this.S != null) {
                    synchronized (this.T) {
                        com.google.android.libraries.navigation.internal.ps.k kVar = this.S;
                        cVarA = kVar.a(kVar.a);
                    }
                    gs gsVar = new gs((gt) set);
                    while (gsVar.hasNext()) {
                        com.google.android.libraries.navigation.internal.qi.d dVar = (com.google.android.libraries.navigation.internal.qi.d) gsVar.next();
                        com.google.android.libraries.navigation.internal.pt.d dVar2 = dVar.a().d;
                        if (dVar2 != null) {
                            ((ac) dVar).u(cVarA == null ? false : cVarA.a().equals(dVar2.b));
                        }
                    }
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            return zQ;
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final /* synthetic */ boolean r(ef efVar) {
        com.google.android.libraries.navigation.internal.ps.k kVar;
        bh bhVarS = bi.s(bj.W);
        efVar.h(bhVarS);
        if (!efVar.w.n(bhVarS.d) || com.google.android.libraries.navigation.internal.adl.w.a(com.google.android.libraries.navigation.internal.rb.a.d(efVar).c) == com.google.android.libraries.navigation.internal.adl.w.PLACEMARK_METADATA) {
            return false;
        }
        bh bhVarS2 = bi.s(bj.W);
        efVar.h(bhVarS2);
        Object objK = efVar.w.k(bhVarS2.d);
        Iterator it2 = ((com.google.android.libraries.navigation.internal.acw.j) (objK == null ? bhVarS2.b : bhVarS2.c(objK))).b.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.oe.i iVarA = com.google.android.libraries.navigation.internal.oe.i.a(((com.google.android.libraries.navigation.internal.acw.h) it2.next()).c);
            synchronized (this.T) {
                kVar = this.S;
            }
            if (kVar != null && iVarA != null) {
                Iterator it3 = kVar.c.iterator();
                while (it3.hasNext()) {
                    com.google.android.libraries.navigation.internal.pt.c cVarA = kVar.a(((com.google.android.libraries.navigation.internal.pt.b) it3.next()).b);
                    if (cVarA != null && am.a(iVarA, cVarA.a())) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.qd.w
    protected final void s(Set set) {
        com.google.android.libraries.navigation.internal.ps.o oVar = this.Q;
        if (oVar == null) {
            return;
        }
        synchronized (oVar.d) {
            set.clear();
            set.addAll(oVar.d.d);
        }
    }
}
