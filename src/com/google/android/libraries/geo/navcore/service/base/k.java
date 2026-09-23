package com.google.android.libraries.geo.navcore.service.base;

import android.app.Application;
import android.content.Context;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.ael.x;
import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.sv.ak;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements com.google.android.libraries.navigation.internal.sp.a {
    public final Context a;
    public final com.google.android.libraries.navigation.internal.ia.b b;
    public final com.google.android.libraries.navigation.internal.rw.n c;
    public final ak d;
    public final com.google.android.libraries.navigation.internal.afo.a e;
    public final com.google.android.libraries.navigation.internal.bw.b f;
    public final com.google.android.libraries.navigation.internal.kl.b g;
    public final Executor h;
    public volatile com.google.android.libraries.navigation.internal.si.e i = null;
    public al j = al.DRIVE;
    public com.google.android.libraries.navigation.internal.db.r k = null;
    public final com.google.android.libraries.navigation.internal.wg.b l;
    private final com.google.android.libraries.navigation.internal.ia.e m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Executor f88n;
    private final com.google.android.libraries.navigation.internal.sp.b o;
    private final com.google.android.libraries.navigation.internal.sp.b p;

    public k(Application application, com.google.android.libraries.navigation.internal.ia.e eVar, Executor executor, com.google.android.libraries.navigation.internal.ia.b bVar, com.google.android.libraries.navigation.internal.rw.n nVar, ak akVar, com.google.android.libraries.navigation.internal.sp.b bVar2, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.sp.b bVar3, com.google.android.libraries.navigation.internal.bw.b bVar4, com.google.android.libraries.navigation.internal.kl.b bVar5, com.google.android.libraries.navigation.internal.wg.b bVar6, Executor executor2) {
        this.a = application;
        this.m = eVar;
        this.f88n = executor;
        this.b = bVar;
        this.c = nVar;
        this.d = akVar;
        this.o = bVar2;
        this.e = aVar;
        this.p = bVar3;
        this.f = bVar4;
        this.g = bVar5;
        this.l = bVar6;
        this.h = executor2;
    }

    @Override // com.google.android.libraries.navigation.internal.sp.a
    public final void a() {
        fd fdVarK = fd.k(ap.NAVIGATION_INTERNAL, this.f88n);
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.sr.q.class, new m(0, com.google.android.libraries.navigation.internal.sr.q.class, this, ap.NAVIGATION_INTERNAL, m.b(ap.NAVIGATION_INTERNAL, fdVarK)));
        ap apVar = ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.db.s.class, new m(1, com.google.android.libraries.navigation.internal.db.s.class, this, apVar, m.b(apVar, fdVarK)));
        ap apVar2 = ap.NAVIGATION_INTERNAL;
        fzVar.b(com.google.android.libraries.navigation.internal.sr.r.class, new m(2, com.google.android.libraries.navigation.internal.sr.r.class, this, apVar2, m.b(apVar2, fdVarK)));
        this.m.c(this, fzVar.a());
    }

    @Override // com.google.android.libraries.navigation.internal.sp.a
    public final void b() {
        this.m.e(this);
    }

    public final void c(com.google.android.libraries.navigation.internal.sp.c cVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NavigationModeController.prepareToNavigate");
        try {
            f(false);
            ar.k(this.i == null);
            this.i = cVar.a;
            com.google.android.libraries.navigation.internal.si.e eVar = com.google.android.libraries.navigation.internal.si.e.FREE_NAV;
            int iOrdinal = cVar.a.ordinal();
            if (iOrdinal == 0) {
                this.p.a(cVar);
                com.google.android.libraries.navigation.internal.db.r rVar = this.k;
                if (rVar != null) {
                    ((com.google.android.libraries.navigation.internal.st.a) this.e.a()).c(rVar);
                }
            } else if (iOrdinal == 1) {
                this.o.a(cVar);
                com.google.android.libraries.navigation.internal.db.r rVar2 = this.k;
                if (rVar2 != null) {
                    this.c.a(rVar2);
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
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

    public final void d(al alVar) {
        com.google.android.libraries.navigation.internal.so.e eVar = new com.google.android.libraries.navigation.internal.so.e(com.google.android.libraries.navigation.internal.so.d.a(com.google.android.libraries.navigation.internal.su.d.d(alVar)));
        c(new com.google.android.libraries.navigation.internal.sp.c(com.google.android.libraries.navigation.internal.si.e.FREE_NAV, eVar.a().a(), eVar));
        ((com.google.android.libraries.navigation.internal.st.a) this.e.a()).d(eVar.a());
    }

    public final void e(com.google.android.libraries.navigation.internal.sc.f fVar, List list, x xVar, com.google.android.libraries.navigation.internal.so.e eVar) {
        c(new com.google.android.libraries.navigation.internal.sp.c(com.google.android.libraries.navigation.internal.si.e.GUIDED_NAV, fVar.e.j, eVar));
        int iIndexOf = list.indexOf(fVar);
        ar.b(iIndexOf >= 0, "selectedGuider must be in guider list");
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList.add(((com.google.android.libraries.navigation.internal.sc.f) it2.next()).e);
        }
        this.d.x(bh.h(iIndexOf, arrayList), null, false);
    }

    public final void f(boolean z) {
        if (this.i == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.si.e eVar = com.google.android.libraries.navigation.internal.si.e.FREE_NAV;
        int iOrdinal = this.i.ordinal();
        if (iOrdinal == 0) {
            this.p.b(z);
        } else if (iOrdinal == 1) {
            this.d.y();
            this.o.b(z);
        }
        this.i = null;
        this.m.a(new com.google.android.libraries.navigation.internal.sr.l());
    }
}
