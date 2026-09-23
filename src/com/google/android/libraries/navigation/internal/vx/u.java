package com.google.android.libraries.navigation.internal.vx;

import android.app.Application;
import android.content.Context;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.bk;
import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.aac.bz;
import com.google.android.libraries.navigation.internal.afl.lr;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.sx.ae;
import com.google.android.libraries.navigation.internal.sx.be;
import com.google.android.libraries.navigation.internal.yx.aa;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u implements com.google.android.libraries.navigation.internal.vp.g {
    public final Context a;
    public final com.google.android.libraries.navigation.internal.sv.c b;
    public final ScheduledExecutorService c;
    public final be d;
    public final com.google.android.libraries.navigation.internal.mj.a e;
    public final com.google.android.libraries.navigation.internal.afo.a f;
    t g;
    public final ae h;
    private final Executor i;
    private final com.google.android.libraries.navigation.internal.ia.e j;
    private final e k;

    public u(Application application, ae aeVar, com.google.android.libraries.navigation.internal.sv.c cVar, bn bnVar, be beVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.ia.e eVar, e eVar2, com.google.android.libraries.navigation.internal.afo.a aVar2) {
        this.a = application;
        this.h = aeVar;
        this.b = cVar;
        this.c = bnVar;
        this.d = beVar;
        this.e = aVar;
        this.i = new bz(bnVar);
        this.j = eVar;
        this.k = eVar2;
        this.f = aVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.vp.g
    public final void a() {
        d(com.google.android.libraries.navigation.internal.vp.c.ROUTE_CANCELED);
    }

    @Override // com.google.android.libraries.navigation.internal.vp.g
    public final void b() {
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.cw.f.class, new x(com.google.android.libraries.navigation.internal.cw.f.class, this, ap.UI_THREAD));
        this.j.c(this, fzVar.a());
        this.b.b(this.j);
        e eVar = this.k;
        if (eVar.d.compareAndSet(false, true)) {
            com.google.android.libraries.navigation.internal.ia.e eVar2 = this.j;
            fz fzVar2 = new fz();
            fzVar2.b(com.google.android.libraries.navigation.internal.cw.f.class, new g(com.google.android.libraries.navigation.internal.cw.f.class, eVar, ap.UI_THREAD));
            eVar2.c(eVar, fzVar2.a());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.vp.g
    public final void c(final List list, final List list2, final lr lrVar, final long j, final com.google.android.libraries.navigation.internal.vp.f fVar, com.google.android.libraries.navigation.internal.vw.e eVar, final com.google.android.libraries.navigation.internal.vw.f fVar2) {
        final e eVar2 = this.k;
        bj bjVarH = com.google.android.libraries.navigation.internal.aac.j.h(az.l(new com.google.android.libraries.navigation.internal.aac.s() { // from class: com.google.android.libraries.navigation.internal.vx.b
            @Override // com.google.android.libraries.navigation.internal.aac.s
            public final bj a() {
                final e eVar3 = eVar2;
                com.google.android.libraries.navigation.internal.cw.c cVar = eVar3.a;
                if (cVar != null) {
                    return az.h(cVar);
                }
                bk bkVar = new bk(new Callable() { // from class: com.google.android.libraries.navigation.internal.vx.d
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return (com.google.android.libraries.navigation.internal.cw.c) Objects.requireNonNull(eVar3.a);
                    }
                });
                eVar3.b.add(bkVar);
                return bkVar;
            }
        }, eVar2.c), new o(), this.c);
        a();
        bj bjVarI = com.google.android.libraries.navigation.internal.aac.j.i(bjVarH, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.vx.i
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) {
                u uVar = this.a;
                return az.m(uVar.b.a(), j, TimeUnit.MILLISECONDS, uVar.c);
            }
        }, this.c);
        if (eVar != null) {
            if (!bjVarI.isDone()) {
                eVar.b();
            }
            az.o(bjVarI, new r(eVar), this.c);
        }
        az.o(bjVarI, new q(fVar), this.c);
        bj bjVarH2 = com.google.android.libraries.navigation.internal.aac.j.h(bjVarI, new aa() { // from class: com.google.android.libraries.navigation.internal.vx.j
            @Override // com.google.android.libraries.navigation.internal.yx.aa
            public final Object ak(Object obj) {
                com.google.android.libraries.navigation.internal.sx.b bVar = new com.google.android.libraries.navigation.internal.sx.b();
                bVar.e = lrVar;
                bVar.c = (com.google.android.libraries.navigation.internal.db.r) obj;
                bVar.c(false);
                bVar.f = ev.o(list);
                bVar.g = ev.o(list2);
                bVar.b(false);
                return bVar.d();
            }
        }, this.c);
        final bj bjVarI2 = com.google.android.libraries.navigation.internal.aac.j.i(bjVarH2, new com.google.android.libraries.navigation.internal.aac.t() { // from class: com.google.android.libraries.navigation.internal.vx.k
            @Override // com.google.android.libraries.navigation.internal.aac.t
            public final bj a(Object obj) {
                com.google.android.libraries.navigation.internal.vw.f fVar3 = fVar2;
                com.google.android.libraries.navigation.internal.sx.ap apVar = (com.google.android.libraries.navigation.internal.sx.ap) obj;
                if (fVar3 != null) {
                    fVar3.b();
                }
                return this.a.h.a(apVar);
            }
        }, this.c);
        this.i.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.vx.l
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g = new t(bjVarI2, fVar);
            }
        });
        az.o(bjVarI2, new p(this, fVar2, fVar, bjVarH2), this.c);
    }

    public final void d(final com.google.android.libraries.navigation.internal.vp.c cVar) {
        this.i.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.vx.n
            @Override // java.lang.Runnable
            public final void run() {
                t tVar = this.a.g;
                if (tVar == null || tVar.a.isDone()) {
                    return;
                }
                com.google.android.libraries.navigation.internal.vp.c cVar2 = cVar;
                tVar.a.cancel(false);
                tVar.b.a(cVar2);
            }
        });
    }

    public final void e() {
        this.i.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.vx.m
            @Override // java.lang.Runnable
            public final void run() {
                this.a.g = null;
            }
        });
    }
}
