package com.google.android.libraries.navigation.internal.sk;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.os.Vibrator;
import androidx.mediarouter.media.MediaRouter;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class x implements com.google.android.libraries.navigation.internal.sl.d, ae, dm, dn {
    public static final /* synthetic */ int s = 0;
    private final com.google.android.libraries.navigation.internal.sn.h A;
    private final com.google.android.libraries.navigation.internal.th.c B;
    private final com.google.android.libraries.navigation.internal.sl.q C;
    private final er D;
    private final ce E;
    public final Application b;
    public final com.google.android.libraries.navigation.internal.rw.f c;
    public final com.google.android.libraries.navigation.internal.ia.e d;
    public final com.google.android.libraries.navigation.internal.iv.f e;
    public final ck f;
    public final com.google.android.libraries.navigation.internal.aac.bn g;
    public final com.google.android.libraries.navigation.internal.km.ab h;

    @Deprecated
    public final com.google.android.libraries.navigation.internal.aac.bn i;
    public final Executor j;
    public af k;
    public BroadcastReceiver l;
    public final com.google.android.libraries.navigation.internal.afo.a m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.afo.a f576n;
    public com.google.android.libraries.navigation.internal.vn.d o;
    public dp p;
    public dp prevJob;
    public dp q;
    public final t r;
    private final z w;
    private final z x;
    private final z y;
    private final com.google.android.libraries.navigation.internal.fz.d z;
    private static final com.google.android.libraries.navigation.internal.zb.j u = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.sk.x");
    private static final com.google.android.libraries.navigation.internal.sl.a v = new s();
    static final Set a = EnumSet.of(com.google.android.libraries.navigation.internal.vn.c.PREPARE, com.google.android.libraries.navigation.internal.vn.c.ACT, com.google.android.libraries.navigation.internal.vn.c.SUCCESS, com.google.android.libraries.navigation.internal.vn.c.OTHER_WITH_LOCALIZED_NAME);

    public x(Application application, com.google.android.libraries.navigation.internal.rw.f fVar, com.google.android.libraries.navigation.internal.aac.bn bnVar, d dVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.iv.f fVar2, com.google.android.libraries.navigation.internal.fz.d dVar2, com.google.android.libraries.navigation.internal.kl.b bVar, ce ceVar, ck ckVar, com.google.android.libraries.navigation.internal.sl.q qVar, com.google.android.libraries.navigation.internal.th.c cVar, com.google.android.libraries.navigation.internal.afo.a aVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.sn.h hVar) {
        bz bzVar = new bz(application.getResources(), ceVar, fVar2);
        dq dqVar = new dq(application.getResources(), ceVar, fVar2);
        en enVar = new en((Vibrator) application.getSystemService("vibrator"));
        er erVar = new er(eVar);
        this.r = new t(this);
        this.b = application;
        this.c = fVar;
        this.e = fVar2;
        this.z = dVar2;
        this.g = bnVar;
        com.google.android.libraries.navigation.internal.aac.bn bnVar2 = (com.google.android.libraries.navigation.internal.aac.bn) (dVar.e ? dVar.a : dVar.c).a();
        this.i = bnVar2;
        this.j = new com.google.android.libraries.navigation.internal.aac.bz(bnVar2);
        this.A = hVar;
        this.w = bzVar;
        this.x = dqVar;
        this.y = enVar;
        this.D = erVar;
        this.B = cVar;
        this.f = ckVar;
        this.d = eVar;
        this.f576n = aVar;
        this.m = aVar2;
        this.C = qVar;
        this.E = ceVar;
        this.h = (com.google.android.libraries.navigation.internal.km.ab) bVar.a(com.google.android.libraries.navigation.internal.km.ak.s);
    }

    static void o(com.google.android.libraries.navigation.internal.sl.c cVar) {
        if (cVar != null) {
            com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
            cVar.b(com.google.android.libraries.navigation.internal.sl.b.a);
        }
    }

    static boolean x(com.google.android.libraries.navigation.internal.sl.h hVar, ck ckVar, com.google.android.libraries.navigation.internal.rw.f fVar) {
        if (ckVar.d(hVar)) {
            return false;
        }
        if (fVar.b() == com.google.android.libraries.navigation.internal.rw.p.CRUISING) {
            return (hVar == com.google.android.libraries.navigation.internal.sl.h.a || hVar == com.google.android.libraries.navigation.internal.sl.h.e) ? false : true;
        }
        return true;
    }

    static boolean y(com.google.android.libraries.navigation.internal.sl.h hVar, com.google.android.libraries.navigation.internal.sl.q qVar, com.google.android.libraries.navigation.internal.rw.f fVar) {
        Vibrator vibrator;
        if (!qVar.a || (vibrator = (Vibrator) qVar.c.getSystemService("vibrator")) == null || !vibrator.hasVibrator()) {
            return false;
        }
        if (fVar.b() == com.google.android.libraries.navigation.internal.rw.p.CRUISING) {
            return (hVar == com.google.android.libraries.navigation.internal.sl.h.a || hVar == com.google.android.libraries.navigation.internal.sl.h.e) ? false : true;
        }
        return true;
    }

    static boolean z(com.google.android.libraries.navigation.internal.sl.h hVar, com.google.android.libraries.navigation.internal.sl.q qVar, com.google.android.libraries.navigation.internal.rw.f fVar) {
        if (!qVar.b) {
            return false;
        }
        if (fVar.b() == com.google.android.libraries.navigation.internal.rw.p.CRUISING) {
            return (hVar == com.google.android.libraries.navigation.internal.sl.h.a || hVar == com.google.android.libraries.navigation.internal.sl.h.e) ? false : true;
        }
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.dm
    public final z a() {
        return this.w;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.dm
    public final z b() {
        return this.x;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.dm
    public final z c() {
        return this.y;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.dm
    public final dt d() {
        return (dt) this.f576n.a();
    }

    @Override // com.google.android.libraries.navigation.internal.sk.dm
    public final du e() {
        return (du) this.m.a();
    }

    @Override // com.google.android.libraries.navigation.internal.sk.dm
    public final er f() {
        return this.D;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.ae
    public final com.google.android.libraries.navigation.internal.sl.h g() {
        com.google.android.libraries.navigation.internal.aac.bj bjVarK = com.google.android.libraries.navigation.internal.aac.az.k(new w(this), this.j);
        if (bjVarK.isDone()) {
            try {
                return (com.google.android.libraries.navigation.internal.sl.h) com.google.android.libraries.navigation.internal.aac.az.n(bjVarK);
            } catch (ExecutionException unused) {
            }
        }
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.sk.dm
    public final com.google.android.libraries.navigation.internal.th.c h() {
        return this.B;
    }

    @Override // com.google.android.libraries.navigation.internal.sl.d
    public final com.google.android.libraries.navigation.internal.aac.bj i(com.google.android.libraries.navigation.internal.vn.d dVar, final com.google.android.libraries.navigation.internal.sl.h hVar, final com.google.android.libraries.navigation.internal.sl.c cVar) {
        if (!w(hVar) && !y(hVar, this.C, this.c) && !z(hVar, this.C, this.c)) {
            o(cVar);
            return com.google.android.libraries.navigation.internal.aac.az.h(v);
        }
        if (dVar == null) {
            if (cVar != null) {
                com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
                cVar.b(com.google.android.libraries.navigation.internal.sl.b.a);
            }
            return com.google.android.libraries.navigation.internal.aac.az.h(v);
        }
        com.google.android.libraries.navigation.internal.aac.bn bnVar = this.g;
        com.google.android.libraries.navigation.internal.aac.bn bnVar2 = this.i;
        af afVar = (af) Objects.requireNonNull(this.k);
        ck ckVar = this.f;
        com.google.android.libraries.navigation.internal.iv.f fVar = this.e;
        Application application = this.b;
        final dp dpVar = new dp(bnVar, bnVar2, afVar, ckVar, dVar, fVar, hVar, cVar, application.getApplicationContext(), application.getResources(), this.C, this.E, this.c, this.z, this, this);
        return com.google.android.libraries.navigation.internal.aac.az.k(new Callable() { // from class: com.google.android.libraries.navigation.internal.sk.i
            @Override // java.util.concurrent.Callable
            public final Object call() {
                com.google.android.libraries.navigation.internal.bp.bw bwVar;
                com.google.android.libraries.navigation.internal.bp.bw bwVar2;
                x xVar = this.a;
                dp dpVar2 = xVar.p;
                com.google.android.libraries.navigation.internal.vn.d dVar2 = dpVar2 != null ? dpVar2.d : xVar.o;
                dp dpVar3 = dpVar;
                if (!((com.google.android.libraries.navigation.internal.sl.k) hVar.l).c && dVar2 != null && (bwVar = dpVar3.d.d) != null && (bwVar2 = dVar2.d) != null && bwVar.a != com.google.android.libraries.navigation.internal.adr.dh.SUCCESS && bwVar.a == bwVar2.a && dpVar3.d.equals(dVar2) && bwVar.a().c.equals(bwVar2.a().c)) {
                    final com.google.android.libraries.navigation.internal.sl.c cVar2 = cVar;
                    bwVar.b();
                    bwVar.a();
                    xVar.g.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            int i = x.s;
                            com.google.android.libraries.navigation.internal.sl.c cVar3 = cVar2;
                            if (cVar3 != null) {
                                cVar3.b(com.google.android.libraries.navigation.internal.sl.b.a);
                            }
                        }
                    });
                } else if (xVar.p != null) {
                    xVar.m();
                    xVar.q = dpVar3;
                } else {
                    xVar.v(dpVar3);
                }
                return dpVar3;
            }
        }, this.j);
    }

    public final /* synthetic */ Boolean j(Boolean bool) {
        boolean z = true;
        if (!bool.booleanValue()) {
            return true;
        }
        af afVar = this.k;
        com.google.android.libraries.navigation.internal.yx.ar.q(afVar);
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        bf bfVar = (bf) afVar;
        ac acVar = (ac) bfVar.h;
        MediaRouter.RouteInfo routeInfo = acVar.c;
        if (acVar.e != 3 || routeInfo == null) {
            z = false;
        } else if (acVar.b.getSelectedRoute().getId().equals(routeInfo.getId())) {
            acVar.e = 1;
            acVar.c = null;
            z = false;
        } else {
            acVar.e = 4;
            acVar.b.selectRoute(routeInfo);
        }
        boolean z2 = !z;
        if (!z) {
            bfVar.d();
        }
        return Boolean.valueOf(z2);
    }

    @Override // com.google.android.libraries.navigation.internal.sl.d
    public final void k(final com.google.android.libraries.navigation.internal.sl.a aVar) {
        this.j.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.k
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.libraries.navigation.internal.sl.a aVar2 = aVar;
                x xVar = this.a;
                if (aVar2 == xVar.q) {
                    xVar.m();
                } else if (xVar.p == aVar2) {
                    xVar.l();
                }
            }
        });
    }

    public final void l() {
        final dp dpVar = this.p;
        if (dpVar != null) {
            this.prevJob = dpVar;
            this.p = null;
            com.google.android.libraries.navigation.internal.aac.bn bnVar = this.g;
            Objects.requireNonNull(dpVar);
            bnVar.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.g
                @Override // java.lang.Runnable
                public final void run() {
                    dp dpVar2 = dpVar;
                    com.google.android.libraries.navigation.internal.aac.az.o(dpVar2.b(), new de(dpVar2), dpVar2.b);
                }
            });
        }
    }

    public final void m() {
        final com.google.android.libraries.navigation.internal.sl.c cVar;
        dp dpVar = this.q;
        this.q = null;
        if (dpVar == null || (cVar = dpVar.j) == null) {
            return;
        }
        this.g.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.f
            @Override // java.lang.Runnable
            public final void run() {
                int i = x.s;
                cVar.b(com.google.android.libraries.navigation.internal.sl.b.b);
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.sk.dn
    public final void n() {
        com.google.android.libraries.navigation.internal.aac.az.o(com.google.android.libraries.navigation.internal.aac.j.h(com.google.android.libraries.navigation.internal.aac.az.k(new Callable() { // from class: com.google.android.libraries.navigation.internal.sk.n
            @Override // java.util.concurrent.Callable
            public final Object call() {
                x xVar = this.a;
                dp dpVar = xVar.p;
                if (dpVar != null) {
                    xVar.o = dpVar.d;
                }
                dp dpVar2 = xVar.q;
                boolean z = true;
                if (dpVar2 != null && xVar.w(dpVar2.k)) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
        }, this.j), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.sk.o
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                return this.a.j((Boolean) obj);
            }
        }, this.g), new v(this), this.j);
    }

    @Override // com.google.android.libraries.navigation.internal.sk.ae
    public final void p() {
        this.j.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.j
            @Override // java.lang.Runnable
            public final void run() {
                x xVar = this.a;
                if (xVar.q != null) {
                    xVar.m();
                }
                if (xVar.p != null) {
                    xVar.l();
                }
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.sk.ae
    public final void q() {
        n();
    }

    @Override // com.google.android.libraries.navigation.internal.sk.ae
    public final void r() {
        this.j.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.l
            @Override // java.lang.Runnable
            public final void run() {
                dp dpVar = this.a.p;
                if (dpVar != null) {
                    dpVar.e();
                }
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.sl.d
    public final void s(final boolean z) {
        this.j.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.r
            @Override // java.lang.Runnable
            public final void run() {
                x xVar = this.a;
                if (z) {
                    dp dpVar = xVar.q;
                    if (dpVar != null && !dpVar.k.b()) {
                        xVar.m();
                    }
                    dp dpVar2 = xVar.p;
                    if (dpVar2 != null && !dpVar2.k.b()) {
                        xVar.l();
                    }
                }
                dp dpVar3 = xVar.p;
                if (dpVar3 != null) {
                    xVar.prevJob = dpVar3;
                }
                xVar.p = null;
                xVar.o = null;
            }
        });
        u();
        this.A.f();
    }

    @Override // com.google.android.libraries.navigation.internal.sl.d
    public final void t(List list) {
        if (this.z.R().c) {
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    ((dt) this.f576n.a()).e((com.google.android.libraries.navigation.internal.vn.d) list.get(0), com.google.android.libraries.navigation.internal.tv.c.SOON);
                } else {
                    ((dt) this.f576n.a()).e((com.google.android.libraries.navigation.internal.vn.d) list.get(i), com.google.android.libraries.navigation.internal.tv.c.PREFETCH);
                }
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.sl.d
    public final void u() {
        ((dt) this.f576n.a()).b();
        this.A.g();
    }

    public final void v(final dp dpVar) {
        this.prevJob = this.p;
        this.p = dpVar;
        final com.google.android.libraries.navigation.internal.sl.i iVar = dpVar.k.a() == com.google.android.libraries.navigation.internal.sl.i.PLAYING_PROMPTED ? com.google.android.libraries.navigation.internal.sl.i.PENDING_PROMPTED : com.google.android.libraries.navigation.internal.sl.i.PENDING_UNPROMPTED;
        this.i.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.sk.p
            @Override // java.lang.Runnable
            public final void run() {
                x xVar = this.a;
                af afVar = xVar.k;
                com.google.android.libraries.navigation.internal.yx.ar.q(afVar);
                afVar.b(iVar);
                dp dpVar2 = dpVar;
                dpVar2.d.c();
                com.google.android.libraries.navigation.internal.aac.az.o(dpVar2.a(false), new dc(dpVar2), dpVar2.b);
                xVar.h.c();
            }
        });
    }

    public final boolean w(com.google.android.libraries.navigation.internal.sl.h hVar) {
        return x(hVar, this.f, this.c);
    }
}
