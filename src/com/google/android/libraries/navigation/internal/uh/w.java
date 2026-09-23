package com.google.android.libraries.navigation.internal.uh;

import android.os.Bundle;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.io.IOException;
import java.io.Serializable;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class w extends a<com.google.android.libraries.navigation.internal.ui.a, com.google.android.libraries.navigation.internal.ui.a.C0035a> implements p, o {
    private static final com.google.android.libraries.navigation.internal.zb.j m = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.uh.w");
    private final com.google.android.libraries.navigation.internal.rw.f A;
    private final u B;
    public final n e;
    public final com.google.android.libraries.navigation.internal.sy.a f;
    public final com.google.android.libraries.navigation.internal.sy.b g;
    public final com.google.android.libraries.navigation.internal.sy.d h;
    public boolean i;
    public com.google.android.libraries.navigation.internal.uc.k j;
    public final com.google.android.libraries.navigation.internal.ue.c k;
    public final t l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.ia.e f613n;
    private final com.google.android.libraries.navigation.internal.hh.i o;
    private final v p;
    private final com.google.android.libraries.navigation.internal.ed.b q;
    private final com.google.android.libraries.navigation.internal.nt.m r;
    private final Executor s;
    private final com.google.android.libraries.navigation.internal.nt.t t;
    private final com.google.android.libraries.navigation.internal.nt.t u;
    private boolean v;
    private boolean w;
    private final Optional x;
    private final AtomicBoolean y;
    private final com.google.android.libraries.navigation.internal.nt.t z;

    public w(com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.fz.d dVar, com.google.android.libraries.navigation.internal.hh.i iVar, com.google.android.libraries.navigation.internal.ed.b bVar, Executor executor, com.google.android.libraries.navigation.internal.sy.d dVar2, com.google.android.libraries.navigation.internal.sy.b bVar2, com.google.android.libraries.navigation.internal.ar.a aVar, n nVar, v vVar, com.google.android.libraries.navigation.internal.ue.c cVar, com.google.android.libraries.navigation.internal.rw.f fVar, Optional optional) {
        super(new com.google.android.libraries.navigation.internal.ui.a.C0035a());
        this.t = new q(this);
        this.u = new r(this);
        this.y = new AtomicBoolean(false);
        this.z = new s(this);
        this.l = new t(this);
        this.B = new u(this);
        this.e = nVar;
        this.f613n = eVar;
        this.o = iVar;
        this.p = vVar;
        this.f = new com.google.android.libraries.navigation.internal.sy.a(iVar);
        this.g = bVar2;
        this.h = dVar2;
        this.q = bVar;
        this.r = aVar.a();
        this.s = executor;
        this.j = new com.google.android.libraries.navigation.internal.uc.j(a).a();
        this.k = cVar;
        this.A = fVar;
        com.google.android.libraries.navigation.internal.rw.p pVar = com.google.android.libraries.navigation.internal.rw.p.OFF;
        this.x = optional;
    }

    private final void r(com.google.android.libraries.navigation.internal.uc.k kVar) {
        if (kVar.a == com.google.android.libraries.navigation.internal.uc.g.FOLLOWING && kVar.c() == null) {
            this.j = kVar;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.uh.d
    public final void a() {
        com.google.android.libraries.navigation.internal.uc.k kVar = this.b.c;
        if (kVar.a != com.google.android.libraries.navigation.internal.uc.g.INSPECT_ROUTE_SECTION) {
            return;
        }
        if (kVar instanceof com.google.android.libraries.navigation.internal.uc.q) {
            ((com.google.android.libraries.navigation.internal.ui.a.C0035a) this.b).b(((com.google.android.libraries.navigation.internal.uc.q) kVar).g);
        } else {
            com.google.android.libraries.navigation.internal.ea.c cVar = this.b;
            com.google.android.libraries.navigation.internal.uc.j jVar = new com.google.android.libraries.navigation.internal.uc.j();
            jVar.a = com.google.android.libraries.navigation.internal.uc.g.FOLLOWING;
            ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).b(jVar.a());
        }
        q();
    }

    @Override // com.google.android.libraries.navigation.internal.uh.d
    public final void b() {
        com.google.android.libraries.navigation.internal.ea.c cVar = this.b;
        com.google.android.libraries.navigation.internal.uc.j jVar = new com.google.android.libraries.navigation.internal.uc.j(cVar.c);
        jVar.a = com.google.android.libraries.navigation.internal.uc.g.FREE_MOVEMENT;
        jVar.e = null;
        ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).b(jVar.a());
        q();
    }

    @Override // com.google.android.libraries.navigation.internal.uh.d
    public final void c() {
        com.google.android.libraries.navigation.internal.ea.c cVar = this.b;
        com.google.android.libraries.navigation.internal.uc.j jVar = new com.google.android.libraries.navigation.internal.uc.j(cVar.c);
        jVar.a = com.google.android.libraries.navigation.internal.uc.g.OVERVIEW;
        jVar.e = com.google.android.libraries.navigation.internal.ue.b.NORTH_UP;
        ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).b(jVar.a());
        q();
    }

    @Override // com.google.android.libraries.navigation.internal.uh.d
    public final void d(com.google.android.libraries.navigation.internal.ea.g gVar) {
        this.b.d = gVar;
        q();
    }

    @Override // com.google.android.libraries.navigation.internal.uh.d
    public final void e(Float f) {
        com.google.android.libraries.navigation.internal.ea.c cVar = this.b;
        com.google.android.libraries.navigation.internal.uc.j jVarA = cVar.c.a();
        jVarA.c = f;
        ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).b(jVarA.a());
        this.c = ((com.google.android.libraries.navigation.internal.ui.a.C0035a) this.b).a();
    }

    @Override // com.google.android.libraries.navigation.internal.uh.o
    public final void f(com.google.android.libraries.navigation.internal.ui.a aVar, com.google.android.libraries.navigation.internal.ui.a aVar2) {
    }

    @Override // com.google.android.libraries.navigation.internal.uh.p
    public final void g(bq bqVar) {
        com.google.android.libraries.navigation.internal.ea.c cVar = this.b;
        com.google.android.libraries.navigation.internal.uc.j jVar = new com.google.android.libraries.navigation.internal.uc.j(cVar.c);
        jVar.a = com.google.android.libraries.navigation.internal.uc.g.INSPECT_STEP;
        jVar.e = null;
        ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).b(jVar.a());
        ((com.google.android.libraries.navigation.internal.ui.a.C0035a) this.b).k = bqVar;
        q();
    }

    @Override // com.google.android.libraries.navigation.internal.uh.a, com.google.android.libraries.navigation.internal.uh.c
    public final void j(Bundle bundle) {
        com.google.android.libraries.navigation.internal.ui.a aVarA = ((com.google.android.libraries.navigation.internal.ui.a.C0035a) this.b).a();
        com.google.android.libraries.navigation.internal.uc.k kVar = aVarA.c;
        boolean z = aVarA.k;
        bq bqVar = aVarA.j;
        Float fC = kVar.c();
        com.google.android.libraries.navigation.internal.uc.g gVar = kVar.a;
        Float f = (gVar == com.google.android.libraries.navigation.internal.uc.g.FOLLOWING || gVar == com.google.android.libraries.navigation.internal.uc.g.INSPECT_POINT_ON_ROUTE) ? kVar.c : null;
        com.google.android.libraries.navigation.internal.hh.i iVar = this.o;
        com.google.android.libraries.navigation.internal.uc.k kVar2 = aVarA.c;
        com.google.android.libraries.navigation.internal.hh.w wVar = new com.google.android.libraries.navigation.internal.hh.w(null, new com.google.android.libraries.navigation.internal.ui.b(gVar, z, bqVar, fC, f, kVar2.d, kVar2.e, aVarA.e, aVarA.f, aVarA.m, aVarA.f614n, aVarA.p), true, true);
        iVar.d(wVar);
        com.google.android.libraries.navigation.internal.hh.h hVar = new com.google.android.libraries.navigation.internal.hh.h(wVar, false);
        hVar.c.c(iVar);
        bundle.putSerializable("navigationUiState", hVar);
    }

    @Override // com.google.android.libraries.navigation.internal.uh.a, com.google.android.libraries.navigation.internal.uh.c
    public final void k() {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NavigationUiStateTracker.onHostStarted()");
        try {
            this.A.b();
            this.i = false;
            com.google.android.libraries.navigation.internal.ia.e eVar = this.f613n;
            u uVar = this.B;
            fz fzVar = new fz();
            fzVar.b(com.google.android.libraries.navigation.internal.sr.e.class, new y(0, com.google.android.libraries.navigation.internal.sr.e.class, uVar, ap.UI_THREAD));
            fzVar.b(com.google.android.libraries.navigation.internal.sr.j.class, new y(1, com.google.android.libraries.navigation.internal.sr.j.class, uVar, ap.UI_THREAD));
            fzVar.b(com.google.android.libraries.navigation.internal.si.f.class, new y(2, com.google.android.libraries.navigation.internal.si.f.class, uVar, ap.UI_THREAD));
            fzVar.b(com.google.android.libraries.navigation.internal.sr.o.class, new y(3, com.google.android.libraries.navigation.internal.sr.o.class, uVar, ap.UI_THREAD));
            fzVar.b(com.google.android.libraries.navigation.internal.jn.a.class, new y(4, com.google.android.libraries.navigation.internal.jn.a.class, uVar, ap.UI_THREAD));
            eVar.c(uVar, fzVar.a());
            this.A.c(this.l, this.s);
            this.l.a(this.A.a());
            this.q.a().e(this.t, this.s);
            this.r.e(this.u, this.s);
            if (this.y.compareAndSet(false, true) && this.x.isPresent() && ((com.google.android.libraries.navigation.internal.dn.a) this.x.get()).a() != null) {
                ((com.google.android.libraries.navigation.internal.dn.a) this.x.get()).a().e(this.z, this.s);
            }
            if (ap.i(ap.UI_THREAD)) {
                if (this.q.a().i()) {
                    this.t.a(this.q.a());
                }
                if (this.r.i()) {
                    this.u.a(this.r);
                }
                if (this.y.get() && this.x.isPresent() && ((com.google.android.libraries.navigation.internal.dn.a) this.x.get()).a() != null) {
                    this.z.a(((com.google.android.libraries.navigation.internal.dn.a) this.x.get()).a());
                }
            }
            super.k();
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

    @Override // com.google.android.libraries.navigation.internal.uh.a, com.google.android.libraries.navigation.internal.uh.c
    public final void l() {
        super.l();
        this.r.h(this.u);
        this.q.a().h(this.t);
        this.A.d(this.l);
        this.f613n.e(this.B);
        this.i = false;
        if (this.y.compareAndSet(true, false) && this.x.isPresent() && ((com.google.android.libraries.navigation.internal.dn.a) this.x.get()).a() != null) {
            ((com.google.android.libraries.navigation.internal.dn.a) this.x.get()).a().h(this.z);
        }
        com.google.android.libraries.navigation.internal.ea.c cVar = this.b;
        com.google.android.libraries.navigation.internal.uc.j jVarA = cVar.c.a();
        jVarA.d = true;
        ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).b(jVarA.a());
    }

    @Override // com.google.android.libraries.navigation.internal.uh.d
    public final void m(Float f) {
        com.google.android.libraries.navigation.internal.ea.c cVar = this.b;
        com.google.android.libraries.navigation.internal.uc.j jVarA = cVar.c.a();
        jVarA.b = f;
        ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).b(jVarA.a());
        this.c = ((com.google.android.libraries.navigation.internal.ui.a.C0035a) this.b).a();
    }

    public final void n() {
        ar.k(this.d);
        ar.l(this.i, "receivedNavUiStateChangedEvent");
        if (q()) {
            this.p.a((com.google.android.libraries.navigation.internal.ui.a) this.c);
        }
        com.google.android.libraries.navigation.internal.uc.j jVarA = this.b.c.a();
        jVarA.d = false;
        com.google.android.libraries.navigation.internal.uc.k kVarA = jVarA.a();
        r(kVarA);
        ((com.google.android.libraries.navigation.internal.ui.a.C0035a) this.b).b(kVarA);
    }

    public final void o(Bundle bundle) {
        com.google.android.libraries.navigation.internal.ui.a.C0035a c0035a = (com.google.android.libraries.navigation.internal.ui.a.C0035a) this.b;
        Serializable serializableA = null;
        c0035a.i = null;
        c0035a.j = false;
        c0035a.k = null;
        c0035a.l = true;
        c0035a.m = null;
        c0035a.f615n = false;
        c0035a.o = null;
        c0035a.p = null;
        c0035a.q = 0;
        c0035a.r = false;
        c0035a.s = null;
        if (bundle == null) {
            return;
        }
        try {
            com.google.android.libraries.navigation.internal.hh.i iVar = this.o;
            Serializable serializable = bundle.getSerializable("navigationUiState");
            if (serializable instanceof com.google.android.libraries.navigation.internal.hh.h) {
                com.google.android.libraries.navigation.internal.hh.h hVar = (com.google.android.libraries.navigation.internal.hh.h) serializable;
                com.google.android.libraries.navigation.internal.hh.w wVarA = hVar.c;
                if (wVarA == null) {
                    wVarA = iVar.a(hVar.a);
                    hVar.c = wVarA;
                }
                boolean z = hVar.b;
                serializableA = wVarA.a();
            }
            if (serializableA != null && !com.google.android.libraries.navigation.internal.ui.b.class.isInstance(serializableA)) {
                IOException iOException = new IOException(new ClassCastException(String.valueOf(serializableA.getClass()) + " cannot be cast to " + com.google.android.libraries.navigation.internal.ui.b.class.toString()));
                serializableA.getClass();
                throw iOException;
            }
            com.google.android.libraries.navigation.internal.ui.b bVar = (com.google.android.libraries.navigation.internal.ui.b) serializableA;
            if (bVar != null) {
                com.google.android.libraries.navigation.internal.ea.c cVar = this.b;
                ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).p = bVar;
                ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).l = bVar.b;
                ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).f = bVar.i;
                ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).g = bVar.j;
                ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).r = bVar.l;
                ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).s = bVar.m;
                com.google.android.libraries.navigation.internal.uc.j jVar = new com.google.android.libraries.navigation.internal.uc.j();
                jVar.a = bVar.a;
                jVar.b = bVar.e;
                jVar.c = bVar.f;
                jVar.d = bVar.g;
                jVar.e = bVar.h;
                ((com.google.android.libraries.navigation.internal.ui.a.C0035a) cVar).b(jVar.a());
            }
        } catch (IOException e) {
            ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) m.d(com.google.android.libraries.navigation.internal.nl.a.a).g(e)).F((char) 1893)).p("Corrupt NAVIGATION_FRAGMENT_STATE_KEY data");
        }
    }

    public final void p() {
        com.google.android.libraries.navigation.internal.uc.j jVar = new com.google.android.libraries.navigation.internal.uc.j(this.b.c);
        jVar.a = com.google.android.libraries.navigation.internal.uc.g.FOLLOWING;
        jVar.e = null;
        com.google.android.libraries.navigation.internal.uc.k kVarA = jVar.a();
        r(kVarA);
        ((com.google.android.libraries.navigation.internal.ui.a.C0035a) this.b).b(kVarA);
    }

    public final boolean q() {
        boolean zQ = false;
        if (!this.d) {
            return false;
        }
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NavigationUiStateTracker.dispatchStateChange");
        try {
            if (this.v) {
                this.w = true;
            } else {
                this.v = true;
                com.google.android.libraries.navigation.internal.ea.e eVar = this.c;
                this.c = ((com.google.android.libraries.navigation.internal.ui.a.C0035a) this.b).a();
                this.p.f((com.google.android.libraries.navigation.internal.ui.a) this.c, (com.google.android.libraries.navigation.internal.ui.a) eVar);
                this.v = false;
                if (this.w) {
                    this.w = false;
                    zQ = q();
                } else {
                    zQ = true;
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
}
