package com.google.android.libraries.navigation.internal.dp;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.db.ar;
import com.google.android.libraries.navigation.internal.dr.ad;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class r {
    final /* synthetic */ v a;

    public r(v vVar) {
        this.a = vVar;
    }

    public static final void g() {
        com.google.android.libraries.navigation.internal.cv.a aVar = com.google.android.libraries.navigation.internal.cv.a.TRAFFIC;
        throw null;
    }

    public final void a(com.google.android.libraries.navigation.internal.dh.p pVar) {
        v vVar = this.a;
        if (vVar.m) {
            com.google.android.libraries.navigation.internal.p002do.l lVar = vVar.s;
            if ((lVar instanceof com.google.android.libraries.navigation.internal.p002do.p) && ((com.google.android.libraries.navigation.internal.p002do.p) lVar).p(pVar)) {
                synchronized (this.a.r) {
                    v vVar2 = this.a;
                    if (vVar2.r.p) {
                        vVar2.r();
                    }
                }
            }
        }
    }

    public final void b(com.google.android.libraries.navigation.internal.cy.a aVar) {
        if (this.a.m) {
            if (aVar.m() == com.google.android.libraries.navigation.internal.db.i.b) {
                this.a.i = aVar.i();
            } else if (aVar.i() - this.a.i < 500) {
                return;
            }
            com.google.android.libraries.navigation.internal.p002do.l lVar = this.a.s;
            if ((lVar instanceof com.google.android.libraries.navigation.internal.p002do.p) && ((com.google.android.libraries.navigation.internal.p002do.p) lVar).o(aVar)) {
                synchronized (this.a.r) {
                    v vVar = this.a;
                    if (vVar.r.p) {
                        vVar.r();
                    }
                }
            }
        }
    }

    public final void c(com.google.android.libraries.navigation.internal.db.s sVar) {
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("MyLocationController.onGmmLocationEvent");
        try {
            v vVar = this.a;
            com.google.android.libraries.navigation.internal.db.r rVarD = sVar.d();
            if (rVarD != null) {
                vVar.f.c(rVarD, com.google.android.libraries.navigation.internal.ja.a.a(rVarD.g));
            }
            com.google.android.libraries.navigation.internal.db.r rVarD2 = sVar.d();
            v vVar2 = this.a;
            vVar2.q = rVarD2 != null;
            if (rVarD2 == null) {
                vVar2.B = null;
                this.a.p();
                synchronized (this.a.r) {
                    this.a.r.b();
                }
            } else {
                com.google.android.libraries.navigation.internal.oa.k kVar = vVar2.l;
                if (kVar == null) {
                    ((com.google.android.libraries.navigation.internal.zb.h) v.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(414)).p("mapContainer is null in onGmmLocationEvent().");
                } else {
                    vVar2.B = rVarD2;
                    kVar.n();
                    v vVar3 = this.a;
                    if (!(vVar3.b.j ? ar.b(vVar3.B, vVar3.d) : ar.c(vVar3.B.q(), this.a.d.f()))) {
                        com.google.android.libraries.navigation.internal.oa.k kVar2 = this.a.l;
                        if (kVar2.f491n.compareAndSet(false, true)) {
                            kVar2.m.i();
                        }
                    }
                    synchronized (this.a) {
                        v vVar4 = this.a;
                        if (!vVar4.p) {
                            vVar4.h();
                        }
                    }
                    v vVar5 = this.a;
                    boolean zM = vVar5.s.m(vVar5.B);
                    synchronized (this.a.r) {
                        long epochMilli = this.a.B.z() ? this.a.B.q().toEpochMilli() : this.a.d.f().toEpochMilli();
                        v vVar6 = this.a;
                        vVar6.r.k = epochMilli;
                        this.a.r.l = com.google.android.libraries.navigation.internal.ja.a.a(vVar6.B.g);
                    }
                    if (zM) {
                        this.a.r();
                    }
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

    public final void d(com.google.android.libraries.navigation.internal.cw.d dVar) {
        k kVar = this.a.f407n;
        boolean z = dVar.d;
        kVar.u = z;
        kVar.v = dVar.e;
        if (kVar.o != null) {
            ad adVar = kVar.o;
            adVar.b = z;
            if (!z) {
                adVar.f = null;
            }
        }
        this.a.r();
    }

    public final void e() {
        this.a.h();
        this.a.r();
    }

    public final void f() {
        this.a.h();
    }
}
