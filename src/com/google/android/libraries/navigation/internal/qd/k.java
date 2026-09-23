package com.google.android.libraries.navigation.internal.qd;

import android.util.Log;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.km.ac;
import com.google.android.libraries.navigation.internal.km.an;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.fd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k implements com.google.android.libraries.navigation.internal.pn.k {
    private final com.google.android.libraries.navigation.internal.kn.a o;
    private final com.google.android.libraries.navigation.internal.kl.b p;
    private final com.google.android.libraries.navigation.internal.km.ab q;
    private final com.google.android.libraries.navigation.internal.km.ab r;
    private final com.google.android.libraries.navigation.internal.km.ab s;
    private final com.google.android.libraries.navigation.internal.it.a t;
    private final com.google.android.libraries.navigation.internal.wd.g x;
    private boolean a = false;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private boolean e = true;
    private boolean f = false;
    private long g = 0;
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;
    private boolean m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f546n = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;

    public k(com.google.android.libraries.navigation.internal.kl.b bVar, com.google.android.libraries.navigation.internal.kn.a aVar, com.google.android.libraries.navigation.internal.it.a aVar2, com.google.android.libraries.navigation.internal.wd.g gVar) {
        this.p = bVar;
        this.t = aVar2;
        this.o = aVar;
        ac acVar = (ac) com.google.android.libraries.navigation.internal.km.q.h.get(aVar);
        ar.q(acVar);
        this.q = (com.google.android.libraries.navigation.internal.km.ab) bVar.a(acVar);
        ac acVar2 = (ac) com.google.android.libraries.navigation.internal.km.q.i.get(aVar);
        ar.q(acVar2);
        this.r = (com.google.android.libraries.navigation.internal.km.ab) bVar.a(acVar2);
        this.s = (com.google.android.libraries.navigation.internal.km.ab) bVar.a(an.a);
        this.x = gVar;
    }

    private final void r(fd fdVar) {
        com.google.android.libraries.navigation.internal.xn.a aVar = (com.google.android.libraries.navigation.internal.xn.a) fdVar.get(this.o);
        ar.q(aVar);
        com.google.android.libraries.navigation.internal.it.a aVar2 = this.t;
        if (aVar2 != null) {
            aVar2.a();
        }
        com.google.android.libraries.navigation.internal.nw.e.f(aVar, 1);
    }

    private final void s(fd fdVar) {
        ar.q((com.google.android.libraries.navigation.internal.km.y) fdVar.get(this.o));
        int i = com.google.android.libraries.navigation.internal.gx.a.a;
    }

    private final void t(fd fdVar) {
        ar.q((com.google.android.libraries.navigation.internal.km.y) fdVar.get(this.o));
        int i = com.google.android.libraries.navigation.internal.gx.a.a;
    }

    private final void u(fd fdVar) {
        if (this.t == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.xn.a aVar = (com.google.android.libraries.navigation.internal.xn.a) fdVar.get(this.o);
        ar.q(aVar);
        this.t.c();
        com.google.android.libraries.navigation.internal.nw.e.f(aVar, 1);
    }

    private final void v() {
        com.google.android.libraries.navigation.internal.km.v vVar = com.google.android.libraries.navigation.internal.km.v.AUTO_PAN_MODE_ENABLED;
        this.p.l();
        this.p.l();
    }

    @Override // com.google.android.libraries.navigation.internal.pn.k
    public final synchronized void a() {
        this.h = true;
    }

    public final synchronized void b() {
        if (this.l) {
            return;
        }
        if (this.e) {
            com.google.android.libraries.navigation.internal.yt.a aVarA = com.google.android.libraries.navigation.internal.yt.d.a("GlobalTimer.LastLabelTile");
            try {
                String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
                Trace.endAsyncSection("LastLabelTile", 1);
                aVarA.close();
                t(com.google.android.libraries.navigation.internal.km.q.e);
                com.google.android.libraries.navigation.internal.zp.n nVar = com.google.android.libraries.navigation.internal.zp.n.z;
                com.google.android.libraries.navigation.internal.gx.a.a();
                ar.q((String) com.google.android.libraries.navigation.internal.gx.b.d.get(this.o));
                s(com.google.android.libraries.navigation.internal.km.q.k);
                u(com.google.android.libraries.navigation.internal.ko.a.h);
                u(com.google.android.libraries.navigation.internal.ko.a.m);
                com.google.android.libraries.navigation.internal.it.a aVar = this.t;
                if (aVar != null) {
                    ar.q((com.google.android.libraries.navigation.internal.xn.a) com.google.android.libraries.navigation.internal.ko.a.o.get(this.o));
                    aVar.b();
                    com.google.android.libraries.navigation.internal.it.a aVar2 = this.t;
                    ar.q((com.google.android.libraries.navigation.internal.xn.a) com.google.android.libraries.navigation.internal.ko.a.i.get(this.o));
                    aVar2.a();
                }
            } catch (Throwable th) {
                try {
                    aVarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        t(com.google.android.libraries.navigation.internal.km.q.j);
        this.l = true;
    }

    public final synchronized void c() {
        if (this.f546n) {
            return;
        }
        if (this.e) {
            t(com.google.android.libraries.navigation.internal.km.q.d);
            u(com.google.android.libraries.navigation.internal.ko.a.f);
            u(com.google.android.libraries.navigation.internal.ko.a.e);
        }
        com.google.android.libraries.navigation.internal.yt.a aVarA = com.google.android.libraries.navigation.internal.yt.d.a("GlobalTimer.BasemapLabelLoad");
        try {
            String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
            Trace.endAsyncSection("BasemapLabelLoad", 1);
            aVarA.close();
            this.f546n = true;
        } catch (Throwable th) {
            try {
                aVarA.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final synchronized void d() {
        if (this.m) {
            return;
        }
        if (this.e) {
            t(com.google.android.libraries.navigation.internal.km.q.c);
            u(com.google.android.libraries.navigation.internal.ko.a.c);
            u(com.google.android.libraries.navigation.internal.ko.a.d);
        }
        com.google.android.libraries.navigation.internal.yt.a aVarA = com.google.android.libraries.navigation.internal.yt.d.a("GlobalTimer.BasemapTilesLoad");
        try {
            String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
            Trace.endAsyncSection("BasemapTilesLoad", 1);
            aVarA.close();
            this.m = true;
        } catch (Throwable th) {
            try {
                aVarA.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final synchronized void e() {
        if (this.j) {
            return;
        }
        if (com.google.android.libraries.navigation.internal.nw.e.b("FirstMapTileRendered") != null) {
            Trace.endSection();
        }
        ar.q((String) com.google.android.libraries.navigation.internal.gx.b.a.get(this.o));
        if (this.e) {
            v();
            t(com.google.android.libraries.navigation.internal.km.q.a);
            ((com.google.android.libraries.navigation.internal.km.ab) this.p.a(com.google.android.libraries.navigation.internal.km.d.a)).c();
            u(com.google.android.libraries.navigation.internal.ko.a.a);
            u(com.google.android.libraries.navigation.internal.ko.a.b);
            Trace.endAsyncSection("CarActivityCreationToFirstMapTileTime", 1);
        }
        this.j = true;
    }

    public final synchronized void f() {
        if (this.k) {
            return;
        }
        if (this.e) {
            v();
            t(com.google.android.libraries.navigation.internal.km.q.b);
            com.google.android.libraries.navigation.internal.zp.n nVar = com.google.android.libraries.navigation.internal.zp.n.A;
            com.google.android.libraries.navigation.internal.gx.a.a();
        }
        com.google.android.libraries.navigation.internal.yt.a aVarA = com.google.android.libraries.navigation.internal.yt.d.a("GlobalTimer.LastMapTile");
        try {
            String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
            Trace.endAsyncSection("LastMapTile", 1);
            aVarA.close();
            if (com.google.android.libraries.navigation.internal.nw.e.b("LastMapTileRendered") != null) {
                Trace.endSection();
            }
            ar.q((String) com.google.android.libraries.navigation.internal.gx.b.b.get(this.o));
            u(com.google.android.libraries.navigation.internal.ko.a.g);
            u(com.google.android.libraries.navigation.internal.ko.a.l);
            com.google.android.libraries.navigation.internal.it.a aVar = this.t;
            if (aVar != null) {
                ar.q((com.google.android.libraries.navigation.internal.xn.a) com.google.android.libraries.navigation.internal.ko.a.j.get(this.o));
                aVar.a();
            }
            this.k = true;
        } catch (Throwable th) {
            try {
                aVarA.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final synchronized void g() {
        if (!this.w && !this.l) {
            if (com.google.android.libraries.navigation.internal.nw.e.b("ViewportInterrupted") != null) {
                Trace.endSection();
            }
            com.google.android.libraries.navigation.internal.zp.n nVar = com.google.android.libraries.navigation.internal.zp.n.y;
            com.google.android.libraries.navigation.internal.gx.a.a();
            s(com.google.android.libraries.navigation.internal.km.q.a);
            s(com.google.android.libraries.navigation.internal.km.q.b);
            s(com.google.android.libraries.navigation.internal.km.q.e);
            s(com.google.android.libraries.navigation.internal.km.q.j);
            s(com.google.android.libraries.navigation.internal.km.q.g);
            s(com.google.android.libraries.navigation.internal.km.q.c);
            s(com.google.android.libraries.navigation.internal.km.q.d);
            r(com.google.android.libraries.navigation.internal.ko.a.f474n);
            r(com.google.android.libraries.navigation.internal.ko.a.b);
            r(com.google.android.libraries.navigation.internal.ko.a.l);
            r(com.google.android.libraries.navigation.internal.ko.a.m);
            r(com.google.android.libraries.navigation.internal.ko.a.d);
            r(com.google.android.libraries.navigation.internal.ko.a.f);
            r(com.google.android.libraries.navigation.internal.ko.a.k);
            r(com.google.android.libraries.navigation.internal.ko.a.a);
            r(com.google.android.libraries.navigation.internal.ko.a.g);
            r(com.google.android.libraries.navigation.internal.ko.a.h);
            r(com.google.android.libraries.navigation.internal.ko.a.c);
            r(com.google.android.libraries.navigation.internal.ko.a.e);
            com.google.android.libraries.navigation.internal.kl.b bVar = this.p;
            com.google.android.libraries.navigation.internal.km.s sVar = (com.google.android.libraries.navigation.internal.km.s) com.google.android.libraries.navigation.internal.km.q.f.get(this.o);
            ar.q(sVar);
            ((com.google.android.libraries.navigation.internal.kk.j) bVar.a(sVar)).a();
            t(com.google.android.libraries.navigation.internal.km.q.k);
            if (this.t != null) {
                if (!this.k) {
                    u(com.google.android.libraries.navigation.internal.ko.a.j);
                }
                if (!this.l) {
                    u(com.google.android.libraries.navigation.internal.ko.a.i);
                }
            }
            com.google.android.libraries.navigation.internal.wd.g gVar = this.x;
            if (gVar != null) {
                gVar.c(com.google.android.libraries.navigation.internal.abx.b.MAP_READY);
            }
        }
        this.w = true;
        this.e = false;
    }

    public final synchronized void h() {
        if (this.i) {
            return;
        }
        if (this.e) {
            t(com.google.android.libraries.navigation.internal.km.q.g);
            com.google.android.libraries.navigation.internal.zp.n nVar = com.google.android.libraries.navigation.internal.zp.n.x;
            com.google.android.libraries.navigation.internal.gx.a.a();
            ar.q((String) com.google.android.libraries.navigation.internal.gx.b.c.get(this.o));
            u(com.google.android.libraries.navigation.internal.ko.a.k);
            u(com.google.android.libraries.navigation.internal.ko.a.f474n);
            s(com.google.android.libraries.navigation.internal.km.q.k);
        } else {
            s(com.google.android.libraries.navigation.internal.km.q.g);
        }
        this.i = true;
        Log.isLoggable("WaitForStableMap", 2);
    }

    public final synchronized void i() {
        this.v = true;
        this.s.c();
    }

    public final synchronized void j() {
        this.u = true;
        this.q.c();
        this.r.c();
    }

    public final synchronized void k() {
        this.e = false;
        com.google.android.libraries.navigation.internal.wd.g gVar = this.x;
        if (gVar != null) {
            gVar.c(com.google.android.libraries.navigation.internal.abx.b.MAP_READY);
        }
    }

    public final synchronized void l() {
        if (this.u) {
            this.q.a();
        } else {
            this.q.b();
        }
    }

    public final synchronized void m() {
        if (this.v) {
            this.s.a();
        } else {
            this.s.b();
        }
    }

    public final synchronized void n() {
        if (com.google.android.libraries.navigation.internal.nw.e.b("onStartEarlyTileFetching") != null) {
            Trace.endSection();
        }
        if (this.u) {
            this.r.a();
        } else {
            this.r.b();
        }
    }

    public final synchronized void o(com.google.android.libraries.navigation.internal.adi.an anVar) {
        if (anVar == com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE) {
            this.d = true;
        }
        this.b = true;
    }

    public final synchronized void p(com.google.android.libraries.navigation.internal.adi.an anVar) {
        if (anVar == com.google.android.libraries.navigation.internal.adi.an.GMM_VECTOR_BASE) {
            this.c = true;
        }
        this.a = true;
    }

    public final synchronized void q(long j) {
        if (!this.i && !this.f) {
            long j2 = this.g;
            if (j2 == 0) {
                this.g = j;
                return;
            }
            if (j2 != j) {
                if (this.h) {
                    com.google.android.libraries.navigation.internal.kl.b bVar = this.p;
                    com.google.android.libraries.navigation.internal.km.v vVar = com.google.android.libraries.navigation.internal.km.v.AUTO_PAN_MODE_ENABLED;
                    bVar.l();
                } else {
                    com.google.android.libraries.navigation.internal.kl.b bVar2 = this.p;
                    com.google.android.libraries.navigation.internal.km.v vVar2 = com.google.android.libraries.navigation.internal.km.v.AUTO_PAN_MODE_ENABLED;
                    bVar2.l();
                }
                this.g = j;
                this.f = true;
            }
        }
    }
}
