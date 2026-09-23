package com.google.android.libraries.navigation.internal.dp;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.ace.hm;
import com.google.android.libraries.navigation.internal.xe.ap;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class g implements com.google.android.libraries.navigation.internal.dq.c {
    public static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.dp.g");
    public final Executor c;
    public final com.google.android.libraries.navigation.internal.pi.s d;
    public final com.google.android.libraries.navigation.internal.ia.e e;
    public final com.google.android.libraries.navigation.internal.ni.a f;
    public final com.google.android.libraries.navigation.internal.dq.i g;
    public final com.google.android.libraries.navigation.internal.cw.a h;
    public final com.google.android.libraries.navigation.internal.ob.f i;
    public com.google.android.libraries.navigation.internal.oa.k k;
    public com.google.android.libraries.navigation.internal.og.b l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ab f403n;
    public m o;
    public n p;
    public boolean q;
    public boolean r;
    public com.google.android.libraries.navigation.internal.oq.d s;
    public com.google.android.libraries.navigation.internal.ws.a t;
    private final com.google.android.libraries.navigation.internal.afo.a w;
    private final ap z;
    public final Object b = new Object();
    private boolean x = false;
    public boolean j = false;
    public com.google.android.libraries.navigation.internal.ql.a m = com.google.android.libraries.navigation.internal.ql.a.OFF;
    private final com.google.android.libraries.navigation.internal.dq.f y = new c(this);
    public final l u = new e(this);
    public final f v = new f(this);

    public g(Executor executor, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.ni.a aVar, com.google.android.libraries.navigation.internal.dq.i iVar, com.google.android.libraries.navigation.internal.cw.a aVar2, com.google.android.libraries.navigation.internal.ob.f fVar, com.google.android.libraries.navigation.internal.afo.a aVar3, ap apVar) {
        this.c = executor;
        this.d = sVar;
        this.e = eVar;
        this.f = aVar;
        this.g = iVar;
        this.h = aVar2;
        this.i = fVar;
        this.w = aVar3;
        this.z = apVar;
    }

    private final void i(com.google.android.libraries.navigation.internal.ql.a aVar) {
        this.g.k(aVar == com.google.android.libraries.navigation.internal.ql.a.COMPASS);
        com.google.android.libraries.navigation.internal.oa.k kVar = this.k;
        if (kVar != null) {
            boolean z = aVar != com.google.android.libraries.navigation.internal.ql.a.OFF;
            if (!kVar.j) {
                ((com.google.android.libraries.navigation.internal.ob.f) kVar.g.a()).d(z);
            }
        }
        this.e.a(new com.google.android.libraries.navigation.internal.ql.b(aVar));
    }

    private final void j(com.google.android.libraries.navigation.internal.ql.a aVar, com.google.android.libraries.navigation.internal.pd.i iVar, boolean z) {
        boolean z2;
        boolean z3;
        com.google.android.libraries.navigation.internal.pd.g gVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("MyLocationControllerImpl.setAutoPanModeAndRelativeCameraPosition");
        try {
            com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
            if (iVar != null) {
                aVar = iVar.b.c;
            }
            if (aVar == com.google.android.libraries.navigation.internal.ql.a.OFF) {
                iVar = null;
            }
            ar.q(aVar);
            boolean zS = this.g.s(null);
            if ((aVar != com.google.android.libraries.navigation.internal.ql.a.COMPASS && aVar != com.google.android.libraries.navigation.internal.ql.a.TRACKING) || zS) {
                synchronized (this.b) {
                    if (this.m != aVar) {
                        this.m = aVar;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                int iOrdinal = aVar.ordinal();
                if (iOrdinal == 0) {
                    this.g.o();
                } else if (iOrdinal == 1 || iOrdinal == 2) {
                    if (this.j) {
                        n nVar = this.p;
                        if (nVar != null) {
                            synchronized (nVar.b) {
                                com.google.android.libraries.navigation.internal.pd.i iVar2 = nVar.c;
                                boolean z4 = (iVar2 == null || iVar == null || (gVar = iVar2.a) == null || gVar != iVar.a) ? false : true;
                                nVar.c = iVar;
                                boolean z5 = nVar.d;
                                nVar.d = z;
                                int iB = nVar.b();
                                z3 = (z5 == z && z4 && (nVar.e & iB) == iB) ? false : true;
                            }
                            if (z3) {
                                d(this.p);
                            }
                        }
                    } else {
                        m mVar = this.o;
                        if (mVar != null && mVar.f(iVar, z)) {
                            d(this.o);
                        }
                    }
                    this.g.n();
                    this.g.m();
                }
                if ((z2 || !this.x) && ((hm) this.w.a()).g) {
                    i(aVar);
                    this.x = true;
                } else if (!((hm) this.w.a()).g) {
                    i(aVar);
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

    @Override // com.google.android.libraries.navigation.internal.dq.c
    public final com.google.android.libraries.navigation.internal.ql.a a() {
        com.google.android.libraries.navigation.internal.ql.a aVar;
        synchronized (this.b) {
            aVar = this.m;
        }
        return aVar;
    }

    public void b() {
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
    }

    public void c() {
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        ab abVar = this.f403n;
        ar.q(abVar);
        abVar.f = false;
        abVar.b.n(abVar.g);
        com.google.android.libraries.navigation.internal.ws.a aVar = this.t;
        if (aVar != null) {
            aVar.c();
            this.t = null;
        }
        this.g.f();
        this.g.g(this.y);
    }

    protected void d(com.google.android.libraries.navigation.internal.pc.c cVar) {
        com.google.android.libraries.navigation.internal.og.b bVar = this.l;
        if (bVar == null || cVar == null) {
            return;
        }
        bVar.c(cVar);
    }

    @Override // com.google.android.libraries.navigation.internal.dq.c
    public final void e(com.google.android.libraries.navigation.internal.ql.a aVar) {
        j(aVar, null, true);
    }

    @Override // com.google.android.libraries.navigation.internal.dq.c
    public final void f(com.google.android.libraries.navigation.internal.pd.i iVar, boolean z) {
        if (iVar == null) {
            j(com.google.android.libraries.navigation.internal.ql.a.OFF, null, false);
        } else {
            j(null, iVar, z);
        }
    }

    public void g() {
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        synchronized (this.b) {
            this.q = false;
        }
    }

    public void h() {
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        this.g.c(this.y);
        this.g.e();
        com.google.android.libraries.navigation.internal.oa.k kVar = this.k;
        ar.q(kVar);
        kVar.G();
        ab abVar = this.f403n;
        ar.q(abVar);
        abVar.b.d(abVar.g, abVar.a);
        abVar.f = true;
    }
}
