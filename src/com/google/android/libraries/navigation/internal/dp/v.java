package com.google.android.libraries.navigation.internal.dp;

import android.content.res.Resources;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.afl.Cdo;
import com.google.android.libraries.navigation.internal.afl.ds;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.po.gr;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class v implements com.google.android.libraries.navigation.internal.dq.i {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.dp.v");
    public int A;
    public com.google.android.libraries.navigation.internal.db.r B;
    t C;
    public final r D;
    final p E;
    private final com.google.android.libraries.navigation.internal.rw.q F;
    private final s G;
    private final com.google.android.libraries.navigation.internal.ia.e H;
    private final com.google.android.libraries.navigation.internal.rw.f I;
    private final com.google.android.libraries.navigation.internal.cw.a J;
    private final com.google.android.libraries.navigation.internal.ed.b K;
    private final Executor L;
    private final com.google.android.libraries.navigation.internal.nt.t M;
    private final com.google.android.libraries.navigation.internal.nt.p N;
    private final com.google.android.libraries.navigation.internal.nt.p O;
    private final z P;
    private com.google.android.libraries.navigation.internal.cw.l Q;
    private y R;
    private boolean S;
    private final int T;
    private final float U;
    private final AtomicBoolean V;
    private final com.google.android.libraries.navigation.internal.nt.p W;
    private q X;
    private final u Y;
    private int Z;
    public final ds b;
    public final com.google.android.libraries.navigation.internal.dq.e c;
    public final com.google.android.libraries.navigation.internal.mj.a d;
    public final com.google.android.libraries.navigation.internal.ni.a e;
    public final com.google.android.libraries.navigation.internal.fr.e f;
    public final com.google.android.libraries.navigation.internal.afo.a g;
    public final com.google.android.libraries.navigation.internal.iv.f h;
    public long i;
    public com.google.android.libraries.navigation.internal.oq.d j;
    public final Set k;
    public com.google.android.libraries.navigation.internal.oa.k l;
    public boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final k f407n;
    public com.google.android.libraries.navigation.internal.dr.i o;
    public boolean p;
    public boolean q;
    public final com.google.android.libraries.navigation.internal.dt.f r;
    public com.google.android.libraries.navigation.internal.p002do.l s;
    public float t;
    public long u;
    public float v;
    public long w;
    public float x;
    public int y;
    public boolean z;

    public v(ds dsVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.rw.f fVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.ni.a aVar2, com.google.android.libraries.navigation.internal.fr.e eVar2, com.google.android.libraries.navigation.internal.cw.a aVar3, com.google.android.libraries.navigation.internal.afo.a aVar4, com.google.android.libraries.navigation.internal.ed.b bVar, Executor executor, k kVar, com.google.android.libraries.navigation.internal.rw.q qVar, com.google.android.libraries.navigation.internal.iv.f fVar2) {
        z zVar = new z();
        this.G = new s(this);
        this.i = 0L;
        this.k = Collections.newSetFromMap(new ConcurrentHashMap());
        this.M = new o(this);
        this.N = new com.google.android.libraries.navigation.internal.nt.p(new com.google.android.libraries.navigation.internal.dq.d());
        this.O = new com.google.android.libraries.navigation.internal.nt.p(new com.google.android.libraries.navigation.internal.dq.a(-1.0f, -1.0f, Float.MAX_VALUE, -1.0f, -1000.0f, null, null, null, com.google.android.libraries.navigation.internal.dq.g.UNKNOWN));
        this.q = false;
        this.r = new com.google.android.libraries.navigation.internal.dt.f();
        this.t = -1.0f;
        this.u = Long.MIN_VALUE;
        this.v = -1.0f;
        this.w = Long.MIN_VALUE;
        this.x = -1.0f;
        this.y = 0;
        this.z = false;
        this.A = -1;
        this.T = -1;
        this.U = -1.0f;
        this.V = new AtomicBoolean(false);
        this.Y = new u(this);
        this.D = new r(this);
        this.E = new p(this);
        this.X = new q(this);
        this.b = dsVar;
        this.H = eVar;
        this.I = fVar;
        this.d = aVar;
        this.e = aVar2;
        this.f = eVar2;
        this.J = aVar3;
        this.g = aVar4;
        this.P = zVar;
        this.h = fVar2;
        this.K = bVar;
        this.L = executor;
        this.f407n = kVar;
        this.F = qVar;
        this.c = null;
        this.W = null;
        this.X = new q(this);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0016  */
    private final void y() {
        com.google.android.libraries.navigation.internal.cw.l lVar;
        if (this.m) {
            if (!this.S || this.Z == 1) {
                ds dsVar = this.b;
                long j = com.google.android.libraries.navigation.internal.de.w.a;
                if (dsVar.d) {
                    lVar = com.google.android.libraries.navigation.internal.cw.l.FAST;
                } else {
                    lVar = com.google.android.libraries.navigation.internal.cw.l.SLOW;
                }
            } else {
                lVar = com.google.android.libraries.navigation.internal.cw.l.FAST;
            }
            com.google.android.libraries.navigation.internal.cw.l lVar2 = this.Q;
            if (lVar != lVar2) {
                if (lVar2 != null) {
                    ((com.google.android.libraries.navigation.internal.cw.m) this.g.a()).b(this.Y);
                }
                this.Q = lVar;
                ((com.google.android.libraries.navigation.internal.cw.m) this.g.a()).a(this.Y, lVar);
                this.z = true;
            }
        }
    }

    private final void z() {
        com.google.android.libraries.navigation.internal.p002do.l lVar = this.s;
        boolean z = false;
        if (this.f407n.q == com.google.android.libraries.navigation.internal.dt.c.LITE_NAV && this.Z != 3) {
            z = true;
        }
        lVar.a(z);
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final float a() {
        float f;
        synchronized (this.r) {
            f = this.r.b;
        }
        return f;
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final com.google.android.libraries.navigation.internal.oe.x b() {
        com.google.android.libraries.navigation.internal.oe.x xVar;
        synchronized (this.r) {
            xVar = this.r.a;
        }
        return xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final void c(com.google.android.libraries.navigation.internal.dq.f fVar) {
        this.k.add(fVar);
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final void d() {
        k kVar = this.f407n;
        com.google.android.libraries.navigation.internal.dr.ab abVar = kVar.f404n;
        if (abVar != null) {
            Iterator it2 = abVar.c.iterator();
            while (it2.hasNext()) {
                ((com.google.android.libraries.navigation.internal.dr.d) it2.next()).a();
            }
        }
        if (kVar.o != null) {
            kVar.o.d();
        }
        com.google.android.libraries.navigation.internal.dr.z zVar = kVar.m;
        if (zVar != null) {
            zVar.d();
        }
        if (kVar.h != null) {
            com.google.android.libraries.navigation.internal.aw.c cVar = kVar.z;
            kVar.x = false;
            kVar.s = false;
            com.google.android.libraries.navigation.internal.aw.a aVar = (com.google.android.libraries.navigation.internal.aw.a) kVar.d.orElse(null);
            if (aVar != null) {
                aVar.a();
            }
        }
        kVar.g.a().h(kVar.A);
        this.l = null;
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final void e() {
        if (this.l == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 419)).p("mapContainer is null in onStart().");
            return;
        }
        com.google.android.libraries.navigation.internal.oq.d dVar = this.j;
        if (dVar == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 418)).p("cameraManager is null in onStart().");
            return;
        }
        this.m = true;
        ar.q(dVar);
        y yVar = this.R;
        ar.q(dVar);
        yVar.a = dVar;
        gr grVar = this.l.p;
        grVar.a(this.R);
        grVar.a(this.C);
        grVar.d(this.C);
        h();
        y();
        this.s.c();
        this.F.a(this.G, this.L);
        this.I.c(this.X, this.L);
        com.google.android.libraries.navigation.internal.ia.e eVar = this.H;
        r rVar = this.D;
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.sr.k.class, new w(0, com.google.android.libraries.navigation.internal.sr.k.class, rVar, ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.db.s.class, new w(1, com.google.android.libraries.navigation.internal.db.s.class, rVar, ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.cy.f.class, new w(2, com.google.android.libraries.navigation.internal.cy.f.class, rVar, ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.cy.b.class, new w(3, com.google.android.libraries.navigation.internal.cy.b.class, rVar, ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.dq.b.class, new w(4, com.google.android.libraries.navigation.internal.dq.b.class, rVar, ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.cy.a.class, new w(5, com.google.android.libraries.navigation.internal.cy.a.class, rVar, ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.dh.p.class, new w(6, com.google.android.libraries.navigation.internal.dh.p.class, rVar, ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.dh.a.class, new w(7, com.google.android.libraries.navigation.internal.dh.a.class, rVar, ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.dh.q.class, new w(8, com.google.android.libraries.navigation.internal.dh.q.class, rVar, ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.dh.o.class, new w(9, com.google.android.libraries.navigation.internal.dh.o.class, rVar, ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.cw.d.class, new w(10, com.google.android.libraries.navigation.internal.cw.d.class, rVar, ap.UI_THREAD));
        fzVar.b(com.google.android.libraries.navigation.internal.cv.d.class, new w(11, com.google.android.libraries.navigation.internal.cv.d.class, rVar, ap.UI_THREAD));
        eVar.c(rVar, fzVar.a());
        com.google.android.libraries.navigation.internal.ed.b bVar = this.K;
        bVar.a().e(this.M, this.L);
        this.l.G();
        if (this.J.a().b() && this.V.compareAndSet(false, true)) {
            this.l.m.m();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final void f() {
        this.f.e(null, this.J.a().a());
        this.K.a().h(this.M);
        this.F.b(this.G);
        this.I.d(this.X);
        this.H.e(this.D);
        com.google.android.libraries.navigation.internal.oa.k kVar = this.l;
        if (kVar == null) {
            ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 420)).p("mapContainer is null in onStop().");
        } else {
            t tVar = this.C;
            gr grVar = kVar.p;
            grVar.e(tVar);
            grVar.e(this.R);
        }
        p();
        if (this.Q != null) {
            ((com.google.android.libraries.navigation.internal.cw.m) this.g.a()).b(this.Y);
            this.Q = null;
        }
        this.x = -1.0f;
        this.y = 0;
        this.s.l(-1.0f);
        this.z = false;
        Cdo cdo = this.b.f;
        if (cdo == null) {
            cdo = Cdo.a;
        }
        if (cdo.b) {
            this.s.g();
        }
        this.m = false;
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final void g(com.google.android.libraries.navigation.internal.dq.f fVar) {
        this.k.remove(fVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:68:0x00cc A[DONT_INVERT, PHI: r1
      0x00cc: PHI (r1v3 boolean) = 
      (r1v2 boolean)
      (r1v4 boolean)
      (r1v5 boolean)
      (r1v6 boolean)
      (r1v7 boolean)
      (r1v8 boolean)
      (r1v9 boolean)
      (r1v10 boolean)
      (r1v11 boolean)
      (r1v12 boolean)
      (r1v2 boolean)
      (r1v13 boolean)
      (r1v14 boolean)
     binds: [B:11:0x0022, B:67:0x00c8, B:62:0x00ba, B:52:0x00a0, B:47:0x0092, B:42:0x0084, B:37:0x0076, B:32:0x0067, B:27:0x0058, B:26:0x0052, B:20:0x0040, B:18:0x0036, B:17:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:69:0x00ce  */
    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final void i(com.google.android.libraries.navigation.internal.dt.c cVar) {
        k kVar = this.f407n;
        if (cVar != com.google.android.libraries.navigation.internal.dt.c.NONE && !cVar.m) {
            ((com.google.android.libraries.navigation.internal.di.b) kVar.f.a()).c();
        }
        if (cVar != kVar.q) {
            kVar.q = cVar;
            boolean zD = false;
            switch (cVar) {
                case MAP:
                    Cdo cdo = kVar.a.f;
                    if (cdo == null) {
                        cdo = Cdo.a;
                    }
                    zD = cdo.b ? kVar.d(kVar.b ? com.google.android.libraries.navigation.internal.dt.b.d : com.google.android.libraries.navigation.internal.dt.b.c) : kVar.d(kVar.b ? com.google.android.libraries.navigation.internal.dt.b.b : com.google.android.libraries.navigation.internal.dt.b.a);
                    if (zD) {
                        h();
                    }
                    break;
                case DIRECTIONS_TWO_WHEELER:
                    zD = kVar.d(kVar.b ? com.google.android.libraries.navigation.internal.dt.b.f : com.google.android.libraries.navigation.internal.dt.b.e);
                    if (zD) {
                        h();
                    }
                    break;
                case DIRECTIONS_DRIVE:
                    zD = kVar.d(kVar.b ? com.google.android.libraries.navigation.internal.dt.b.h : com.google.android.libraries.navigation.internal.dt.b.g);
                    if (zD) {
                        h();
                    }
                    break;
                case DIRECTIONS_WALK:
                    zD = kVar.d(kVar.b ? com.google.android.libraries.navigation.internal.dt.b.j : com.google.android.libraries.navigation.internal.dt.b.i);
                    if (zD) {
                        h();
                    }
                    break;
                case DIRECTIONS_BICYCLE:
                    zD = kVar.d(kVar.b ? com.google.android.libraries.navigation.internal.dt.b.f411n : com.google.android.libraries.navigation.internal.dt.b.m);
                    if (zD) {
                        h();
                    }
                    break;
                case DIRECTIONS_TAXI:
                    zD = kVar.d(kVar.b ? com.google.android.libraries.navigation.internal.dt.b.l : com.google.android.libraries.navigation.internal.dt.b.k);
                    if (zD) {
                        h();
                    }
                    break;
                case NAVIGATION:
                case NAVIGATION_CUSTOM_3D_CHEVRON:
                    zD = kVar.e();
                    if (zD) {
                        h();
                    }
                    break;
                case SAFETY_OFF_ROUTE_DRIVE:
                    zD = kVar.d(kVar.b ? com.google.android.libraries.navigation.internal.dt.b.p : com.google.android.libraries.navigation.internal.dt.b.o);
                    if (zD) {
                        h();
                    }
                    break;
                case NONE:
                    if (kVar.p != null) {
                        kVar.p.b(false);
                    } else if (zD) {
                        h();
                    }
                    break;
                case INCOGNITO:
                    zD = kVar.d(com.google.android.libraries.navigation.internal.dt.b.q);
                    if (zD) {
                        h();
                    }
                    break;
                case LITE_NAV:
                    zD = kVar.d(kVar.b ? com.google.android.libraries.navigation.internal.dt.b.s : com.google.android.libraries.navigation.internal.dt.b.r);
                    if (zD) {
                        h();
                    }
                    break;
                default:
                    if (zD) {
                        h();
                    }
                    break;
            }
        }
        z();
    }

    final void j(com.google.android.libraries.navigation.internal.p002do.l lVar) {
        com.google.android.libraries.navigation.internal.p002do.l lVar2 = this.s;
        this.s = lVar;
        if (lVar2 != null) {
            lVar2.close();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final void k(boolean z) {
        this.S = z;
        y();
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final void l(boolean z) {
        k kVar = this.f407n;
        kVar.t = z;
        if (kVar.o != null) {
            kVar.o.e = z;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final void m() {
        this.s.e();
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final void n() {
        this.s.f();
        r();
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final void o() {
        this.s.h();
        r();
    }

    public final synchronized void p() {
        if (this.p) {
            if (this.l == null) {
                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 422)).p("mapContainer is null in unregisterMyLocationEntities().");
                return;
            }
            com.google.android.libraries.navigation.internal.dr.i iVar = this.o;
            if (iVar != null) {
                iVar.a();
            }
            this.o = null;
            this.p = false;
            this.R.a(null);
        }
    }

    public final void q(com.google.android.libraries.navigation.internal.dq.h hVar) {
        com.google.android.libraries.navigation.internal.nt.p pVar = this.O;
        if (pVar != null) {
            pVar.c(hVar);
        }
    }

    public final void r() {
        y yVar = this.R;
        yVar.b.d(yVar);
        yVar.b.b();
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final boolean s(com.google.android.libraries.navigation.internal.oe.x xVar) {
        synchronized (this) {
            if (!this.q) {
                return false;
            }
            synchronized (this.r) {
                if (!this.r.f()) {
                    return false;
                }
                if (xVar != null) {
                    xVar.W(this.r.a);
                }
                return true;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final int t() {
        return this.Z;
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final void u(int i) {
        int i2 = this.Z;
        if (i == i2) {
            return;
        }
        this.Z = i;
        int i3 = i - 1;
        if (i3 == 0) {
            if (i2 != 2) {
                j(new com.google.android.libraries.navigation.internal.p002do.p(this.e, false, null));
            }
            this.s.d(false);
            if (i2 == 3) {
                synchronized (this.r) {
                    this.r.c = false;
                }
            }
        } else if (i3 != 1) {
            Cdo cdo = this.b.f;
            if (cdo == null) {
                cdo = Cdo.a;
            }
            j(new com.google.android.libraries.navigation.internal.p002do.k(cdo));
        } else {
            if (i2 != 1) {
                j(new com.google.android.libraries.navigation.internal.p002do.p(this.e, false, null));
            }
            this.s.d(true);
        }
        com.google.android.libraries.navigation.internal.db.r rVar = this.B;
        if (rVar != null) {
            this.s.m(rVar);
        }
        z();
        y();
        r();
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final void v(com.google.android.libraries.navigation.internal.oa.k kVar, com.google.android.libraries.navigation.internal.oo.b bVar, com.google.android.libraries.navigation.internal.cr.f fVar, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, Resources resources) {
        this.j = bVar.h();
        this.l = kVar;
        k kVar2 = this.f407n;
        kVar2.h = kVar;
        kVar2.i = bVar;
        if (fVar != null) {
            kVar2.B = fVar;
        }
        kVar2.k = aVar2;
        kVar2.l = resources;
        kVar2.j = aVar;
        kVar2.q = com.google.android.libraries.navigation.internal.dt.c.NONE;
        kVar2.r = false;
        kVar2.s = false;
        kVar2.g.a().e(kVar2.A, kVar2.e);
        Cdo cdo = this.b.f;
        if (cdo == null) {
            cdo = Cdo.a;
        }
        this.s = new com.google.android.libraries.navigation.internal.p002do.k(cdo);
        this.Z = 3;
        synchronized (this) {
            com.google.android.libraries.navigation.internal.dr.i iVar = this.f407n.p;
            this.o = iVar;
            this.R = new y(iVar, this.E, kVar.p);
        }
        this.C = new t(this);
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final void w() {
        k kVar = this.f407n;
        if (kVar.o != null) {
            kVar.o.a = 0.65f;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.dq.i
    public final void x() {
        this.s.n();
    }

    public final synchronized void h() {
        com.google.android.libraries.navigation.internal.dr.i iVar = this.f407n.p;
        if (iVar == null || !this.q) {
            p();
            return;
        }
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("registerMyLocationEntities");
        try {
            if (this.l == null) {
                ((com.google.android.libraries.navigation.internal.zb.h) a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(421)).p("mapContainer is null in registerMyLocationEntities().");
                if (dVarB != null) {
                    Trace.endSection();
                }
            } else {
                p();
                this.o = iVar;
                this.R.a(iVar);
                this.p = true;
                if (dVarB != null) {
                    Trace.endSection();
                }
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
}
