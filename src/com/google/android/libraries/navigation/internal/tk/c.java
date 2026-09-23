package com.google.android.libraries.navigation.internal.tk;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.adr.dh;
import com.google.android.libraries.navigation.internal.adr.hs;
import com.google.android.libraries.navigation.internal.adr.hu;
import com.google.android.libraries.navigation.internal.bp.bp;
import com.google.android.libraries.navigation.internal.bp.bq;
import com.google.android.libraries.navigation.internal.bp.bw;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    private static final int m;
    public final com.google.android.libraries.navigation.internal.afo.a b;
    public final com.google.android.libraries.navigation.internal.afo.a c;
    public com.google.android.libraries.navigation.internal.se.b d;
    public boolean e;
    public boolean f;
    public boolean g;
    public com.google.android.libraries.navigation.internal.tp.f h;
    public long i;
    public final com.google.android.libraries.navigation.internal.kk.e l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Service f598n;
    private final com.google.android.libraries.navigation.internal.mj.a o;
    private final com.google.android.libraries.navigation.internal.aq.m p;
    private final com.google.android.libraries.navigation.internal.afo.a q;
    private final com.google.android.libraries.navigation.internal.afo.a r;
    private final com.google.android.libraries.navigation.internal.kl.b s;
    private final e t;
    private boolean u;
    private boolean v;
    private bq w;
    public final Runnable j = new a(this);
    public final Runnable k = new b(this);
    public final Handler a = new Handler(Looper.getMainLooper());

    static {
        m = Build.VERSION.SDK_INT >= 26 ? 201326592 : 134217728;
    }

    public c(Service service, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.aq.m mVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.afo.a aVar3, com.google.android.libraries.navigation.internal.afo.a aVar4, com.google.android.libraries.navigation.internal.afo.a aVar5, com.google.android.libraries.navigation.internal.kl.b bVar, e eVar) {
        this.f598n = service;
        this.o = aVar;
        this.p = mVar;
        this.q = aVar2;
        this.r = aVar3;
        this.b = aVar4;
        this.c = aVar5;
        this.s = bVar;
        this.l = bVar.c();
        this.t = eVar;
    }

    private final boolean g() {
        return (this.i == 0 || this.f) ? false : true;
    }

    private final boolean h() {
        return (!this.e || this.f || this.p.a().a()) ? false : true;
    }

    public final PendingIntent a() {
        Intent intent = this.t.c;
        if (intent != null) {
            return PendingIntent.getActivity(this.f598n, 0, intent, m);
        }
        return null;
    }

    public final void b() {
        com.google.android.libraries.navigation.internal.tp.f fVar = this.h;
        if (fVar != null) {
            fVar.a();
        }
    }

    /* JADX WARN: Code duplicated, block: B:120:0x0203 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:135:? A[SYNTHETIC] */
    public final void c(com.google.android.libraries.navigation.internal.rw.b bVar) throws Throwable {
        Throwable th;
        com.google.android.libraries.navigation.internal.bl.d.a aVar;
        com.google.android.libraries.navigation.internal.rw.p pVar = com.google.android.libraries.navigation.internal.rw.p.GUIDING;
        com.google.android.libraries.navigation.internal.rw.p pVar2 = com.google.android.libraries.navigation.internal.rw.p.CRUISING;
        com.google.android.libraries.navigation.internal.rw.i iVar = (com.google.android.libraries.navigation.internal.rw.i) bVar;
        com.google.android.libraries.navigation.internal.rw.p pVar3 = iVar.c;
        boolean z = pVar3 == pVar;
        boolean z2 = pVar3 == pVar2;
        Bitmap bitmap = null;
        if (!z) {
            if (this.d != null && z2 && this.p.a().a()) {
                b();
            }
            this.d = null;
        }
        if (!z) {
            if (!z2) {
                b();
                return;
            }
            com.google.android.libraries.navigation.internal.tm.c cVar = (com.google.android.libraries.navigation.internal.tm.c) this.r.a();
            com.google.android.libraries.navigation.internal.tj.h hVar = iVar.e;
            ar.q(hVar);
            PendingIntent pendingIntentA = a();
            cVar.b.f();
            com.google.android.libraries.navigation.internal.tm.b bVar2 = cVar.c;
            if (bVar2 != null) {
                com.google.android.libraries.navigation.internal.tm.i iVarA = bVar2.a.a(hVar);
                if (!iVarA.equals(bVar2.b)) {
                    bVar2.b = iVarA;
                    cVar.c.a(pendingIntentA);
                }
            } else {
                com.google.android.libraries.navigation.internal.tm.e eVar = cVar.a;
                Intent intent = (Intent) eVar.a.a();
                intent.getClass();
                com.google.android.libraries.navigation.internal.tm.g gVar = (com.google.android.libraries.navigation.internal.tm.g) eVar.b.a();
                gVar.getClass();
                com.google.android.libraries.navigation.internal.wa.a aVar2 = (com.google.android.libraries.navigation.internal.wa.a) eVar.c.a();
                aVar2.getClass();
                com.google.android.libraries.navigation.internal.tp.d dVar = (com.google.android.libraries.navigation.internal.tp.d) eVar.d.a();
                dVar.getClass();
                com.google.android.libraries.navigation.internal.wa.g gVar2 = (com.google.android.libraries.navigation.internal.wa.g) eVar.e.a();
                gVar2.getClass();
                com.google.android.libraries.navigation.internal.aq.m mVar = (com.google.android.libraries.navigation.internal.aq.m) eVar.f.a();
                mVar.getClass();
                Service service = (Service) eVar.g.a();
                service.getClass();
                cVar.c = new com.google.android.libraries.navigation.internal.tm.b(intent, gVar, aVar2, dVar, gVar2, mVar, service, hVar);
                cVar.c.a(pendingIntentA);
            }
            e(cVar);
            return;
        }
        com.google.android.libraries.navigation.internal.tj.j jVar = iVar.d;
        ar.q(jVar);
        com.google.android.libraries.navigation.internal.se.b bVarC = jVar.c();
        this.d = bVarC;
        if (this.w != bVarC.c) {
            this.i = 0L;
        }
        com.google.android.libraries.navigation.internal.tn.e eVar2 = (com.google.android.libraries.navigation.internal.tn.e) this.q.a();
        boolean zH = h();
        long j = g() ? this.i : 0L;
        boolean z3 = this.v;
        PendingIntent pendingIntentA2 = a();
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("GuidedNavNotificationContentController.showNotification");
        try {
            bq bqVar = jVar.c().c;
            if (bqVar != null) {
                boolean zE = jVar.e();
                com.google.android.libraries.navigation.internal.nw.d dVarB2 = com.google.android.libraries.navigation.internal.nw.e.b("NavigationManeuverIndicatorUtils.getStepManeuver");
                try {
                    bq bqVar2 = bqVar.N;
                    if (zE && bqVar2 != null && bqVar2.b() != null) {
                        bp bpVarA = bqVar.a();
                        bpVarA.a = com.google.android.libraries.navigation.internal.aap.l.STRAIGHT;
                        bpVarA.b = hs.SIDE_UNSPECIFIED;
                        bpVarA.c = hu.TURN_STRAIGHT;
                        bqVar = new bq(bpVarA);
                    }
                    com.google.android.libraries.navigation.internal.bl.d.a aVarF = com.google.android.libraries.navigation.internal.bl.d.f(bqVar);
                    if (dVarB2 != null) {
                        Trace.endSection();
                    }
                    aVar = aVarF;
                } catch (Throwable th2) {
                    if (dVarB2 == null) {
                        throw th2;
                    }
                    try {
                        Trace.endSection();
                        throw th2;
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                        throw th2;
                    }
                }
            } else {
                aVar = null;
            }
            if (aVar != null) {
                com.google.android.libraries.navigation.internal.tn.l lVar = eVar2.e;
                int iE = com.google.android.libraries.navigation.internal.tn.e.a.e(eVar2.b);
                int i = eVar2.d.a;
                if (aVar != lVar.b || lVar.c == null || iE != lVar.a) {
                    lVar.b = aVar;
                    lVar.a = iE;
                    com.google.android.libraries.navigation.internal.nw.d dVarB3 = com.google.android.libraries.navigation.internal.nw.e.b("NavigationManeuverIndicatorUtils.getManeuverBitmap");
                    try {
                        Drawable drawableB = com.google.android.libraries.navigation.internal.bl.d.b(aVar, -1);
                        ar.q(drawableB);
                        ar.a(iE > 0);
                        Bitmap bitmapB = com.google.android.libraries.navigation.internal.gw.f.b(drawableB, iE, iE, Bitmap.Config.ARGB_8888);
                        if (Build.VERSION.SDK_INT >= 31) {
                            bitmapB = bitmapB.asShared();
                        } else {
                            Bitmap bitmapCopy = bitmapB.copy(Bitmap.Config.ARGB_8888, false);
                            if (bitmapCopy != null) {
                                bitmapB = bitmapCopy;
                            }
                        }
                        if (dVarB3 != null) {
                            Trace.endSection();
                        }
                        lVar.c = bitmapB;
                    } catch (Throwable th4) {
                        if (dVarB3 == null) {
                            throw th4;
                        }
                        try {
                            Trace.endSection();
                            throw th4;
                        } catch (Throwable th5) {
                            th4.addSuppressed(th5);
                            throw th4;
                        }
                    }
                }
                bitmap = lVar.c;
            }
            Bitmap bitmap2 = bitmap;
            com.google.android.libraries.navigation.internal.tn.d dVar2 = eVar2.h;
            if (dVar2 != null) {
                dVar2.b(jVar, aVar, bitmap2, zH, j, z3, pendingIntentA2);
            } else {
                com.google.android.libraries.navigation.internal.tn.g gVar3 = eVar2.c;
                com.google.android.libraries.navigation.internal.hn.r rVar = eVar2.g;
                bn bnVar = eVar2.f;
                Intent intent2 = (Intent) gVar3.a.a();
                intent2.getClass();
                com.google.android.libraries.navigation.internal.tp.d dVar3 = (com.google.android.libraries.navigation.internal.tp.d) gVar3.b.a();
                dVar3.getClass();
                Service service2 = (Service) gVar3.c.a();
                service2.getClass();
                com.google.android.libraries.navigation.internal.wa.c cVar2 = (com.google.android.libraries.navigation.internal.wa.c) gVar3.d.a();
                cVar2.getClass();
                ((com.google.android.libraries.navigation.internal.tn.i) gVar3.e.a()).getClass();
                com.google.android.libraries.navigation.internal.wa.g gVar4 = (com.google.android.libraries.navigation.internal.wa.g) gVar3.f.a();
                gVar4.getClass();
                com.google.android.libraries.navigation.internal.tn.m mVar2 = (com.google.android.libraries.navigation.internal.tn.m) gVar3.g.a();
                mVar2.getClass();
                com.google.android.libraries.navigation.internal.tn.q qVar = (com.google.android.libraries.navigation.internal.tn.q) gVar3.h.a();
                qVar.getClass();
                com.google.android.libraries.navigation.internal.afo.a aVar3 = (com.google.android.libraries.navigation.internal.afo.a) gVar3.i.a();
                aVar3.getClass();
                com.google.android.libraries.navigation.internal.mj.a aVar4 = (com.google.android.libraries.navigation.internal.mj.a) gVar3.j.a();
                aVar4.getClass();
                rVar.getClass();
                try {
                    eVar2.h = new com.google.android.libraries.navigation.internal.tn.d(intent2, dVar3, service2, cVar2, gVar4, mVar2, qVar, aVar3, aVar4, jVar, aVar, bitmap2, bnVar);
                    eVar2.h.a(zH, j, z3, pendingIntentA2);
                } catch (Throwable th6) {
                    th = th6;
                    th = th;
                    if (dVarB != null) {
                        throw th;
                    }
                    try {
                        Trace.endSection();
                        throw th;
                    } catch (Throwable th7) {
                        th.addSuppressed(th7);
                        throw th;
                    }
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
            e(eVar2);
            this.v = false;
            if (this.u || !this.g) {
                return;
            }
            this.u = true;
        } catch (Throwable th8) {
            th = th8;
            th = th;
            if (dVarB != null) {
                throw th;
            }
            Trace.endSection();
            throw th;
        }
    }

    final void d(bw bwVar) {
        if (this.f) {
            return;
        }
        if (bwVar.a == dh.ACT || bwVar.a == dh.PREPARE) {
            this.i = this.o.a();
            this.w = bwVar.a();
            if (this.p.a().a()) {
                f();
                return;
            }
            this.v = true;
            this.e = true;
            f();
            this.a.removeCallbacks(this.j);
            this.a.postDelayed(this.j, 10000L);
            this.a.removeCallbacks(this.k);
            this.a.postDelayed(this.k, 1000L);
        }
    }

    public final void e(com.google.android.libraries.navigation.internal.tp.f fVar) {
        com.google.android.libraries.navigation.internal.tp.f fVar2 = this.h;
        if (fVar2 != null && fVar2 != fVar) {
            fVar2.b();
        }
        this.h = fVar;
    }

    final void f() {
        com.google.android.libraries.navigation.internal.tp.f fVar = this.h;
        if (fVar != null) {
            fVar.c(h(), g() ? this.i : 0L, this.v, a());
            this.v = false;
        }
    }
}
