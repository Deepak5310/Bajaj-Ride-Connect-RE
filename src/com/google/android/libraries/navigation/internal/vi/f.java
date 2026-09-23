package com.google.android.libraries.navigation.internal.vi;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.ms.at;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.nc.ah;
import com.google.android.libraries.navigation.internal.tj.x;
import com.google.android.libraries.navigation.internal.us.y;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.vj.a {
    private final y a;
    private final com.google.android.libraries.navigation.internal.adu.y b;
    private final com.google.android.libraries.navigation.internal.dx.c c;
    private final com.google.android.libraries.navigation.internal.so.a d;
    private final com.google.android.libraries.navigation.internal.afo.a e;
    private final com.google.android.libraries.navigation.internal.dx.o f;
    private final at g;
    private final com.google.android.libraries.navigation.internal.ag.e h;
    private final bn i;
    private final Executor j;
    private final com.google.android.libraries.navigation.internal.nc.t k;
    private final com.google.android.libraries.navigation.internal.nc.t l;
    private boolean m = true;

    /* JADX INFO: compiled from: PG */
    public abstract class a {
        public abstract f a(y yVar, com.google.android.libraries.navigation.internal.adu.y yVar2, com.google.android.libraries.navigation.internal.dx.c cVar, com.google.android.libraries.navigation.internal.nc.t tVar, com.google.android.libraries.navigation.internal.nc.t tVar2);
    }

    public f(y<x> yVar, com.google.android.libraries.navigation.internal.adu.y yVar2, com.google.android.libraries.navigation.internal.dx.c cVar, com.google.android.libraries.navigation.internal.nc.t tVar, com.google.android.libraries.navigation.internal.nc.t tVar2, bn bnVar, Executor executor, com.google.android.libraries.navigation.internal.so.a aVar, com.google.android.libraries.navigation.internal.afo.a<com.google.android.libraries.navigation.internal.vd.g> aVar2, com.google.android.libraries.navigation.internal.dx.i iVar, com.google.android.libraries.navigation.internal.dx.o oVar, final at atVar) {
        this.a = yVar;
        this.b = yVar2;
        this.c = cVar;
        this.i = bnVar;
        this.j = executor;
        this.d = aVar;
        this.e = aVar2;
        this.f = oVar;
        this.g = atVar;
        this.k = tVar;
        this.l = tVar2;
        this.h = new com.google.android.libraries.navigation.internal.ag.e(new g(this), bnVar, executor);
        cVar.b(new com.google.android.libraries.navigation.internal.bn.b() { // from class: com.google.android.libraries.navigation.internal.vi.d
            @Override // com.google.android.libraries.navigation.internal.bn.b
            public final void a(ah ahVar) {
                atVar.a(this.a);
            }
        });
    }

    @Override // com.google.android.libraries.navigation.internal.vj.a
    public com.google.android.libraries.navigation.internal.ah.a a() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.a
    public aa b() {
        com.google.android.libraries.navigation.internal.zb.j jVar = aa.a;
        com.google.android.libraries.navigation.internal.jy.x xVar = new com.google.android.libraries.navigation.internal.jy.x();
        xVar.i = com.google.android.libraries.navigation.internal.afe.i.m;
        com.google.android.libraries.navigation.internal.zp.q qVar = (com.google.android.libraries.navigation.internal.zp.q) com.google.android.libraries.navigation.internal.zp.r.a.q();
        com.google.android.libraries.navigation.internal.zp.s sVar = (com.google.android.libraries.navigation.internal.zp.s) com.google.android.libraries.navigation.internal.zp.t.a.q();
        if (!sVar.b.H()) {
            sVar.v();
        }
        com.google.android.libraries.navigation.internal.adu.y yVar = this.b;
        com.google.android.libraries.navigation.internal.zp.t tVar = (com.google.android.libraries.navigation.internal.zp.t) sVar.b;
        tVar.c = yVar.x;
        tVar.b |= 1;
        if (!qVar.b.H()) {
            qVar.v();
        }
        com.google.android.libraries.navigation.internal.zp.r rVar = (com.google.android.libraries.navigation.internal.zp.r) qVar.b;
        com.google.android.libraries.navigation.internal.zp.t tVar2 = (com.google.android.libraries.navigation.internal.zp.t) sVar.t();
        tVar2.getClass();
        rVar.d = tVar2;
        rVar.c |= 8192;
        xVar.g((com.google.android.libraries.navigation.internal.zp.r) qVar.t());
        return xVar.b();
    }

    @Override // com.google.android.libraries.navigation.internal.vj.a
    public aa c() {
        com.google.android.libraries.navigation.internal.zb.j jVar = aa.a;
        com.google.android.libraries.navigation.internal.jy.x xVar = new com.google.android.libraries.navigation.internal.jy.x();
        xVar.i = com.google.android.libraries.navigation.internal.afe.i.y;
        com.google.android.libraries.navigation.internal.zp.q qVar = (com.google.android.libraries.navigation.internal.zp.q) com.google.android.libraries.navigation.internal.zp.r.a.q();
        com.google.android.libraries.navigation.internal.zp.s sVar = (com.google.android.libraries.navigation.internal.zp.s) com.google.android.libraries.navigation.internal.zp.t.a.q();
        if (!sVar.b.H()) {
            sVar.v();
        }
        com.google.android.libraries.navigation.internal.adu.y yVar = this.b;
        com.google.android.libraries.navigation.internal.zp.t tVar = (com.google.android.libraries.navigation.internal.zp.t) sVar.b;
        tVar.c = yVar.x;
        tVar.b |= 1;
        if (!qVar.b.H()) {
            qVar.v();
        }
        com.google.android.libraries.navigation.internal.zp.r rVar = (com.google.android.libraries.navigation.internal.zp.r) qVar.b;
        com.google.android.libraries.navigation.internal.zp.t tVar2 = (com.google.android.libraries.navigation.internal.zp.t) sVar.t();
        tVar2.getClass();
        rVar.d = tVar2;
        rVar.c |= 8192;
        xVar.g((com.google.android.libraries.navigation.internal.zp.r) qVar.t());
        return xVar.b();
    }

    @Override // com.google.android.libraries.navigation.internal.vj.a
    public cs.a d() {
        this.h.d();
        g();
        return cs.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.a
    public cs.a e() {
        if (!this.m) {
            com.google.android.libraries.navigation.internal.hx.n.a(this.i.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.vi.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.a.a.L();
                }
            }, 2000L, TimeUnit.MILLISECONDS), this.j);
        } else if (!this.h.j()) {
            this.h.g(4000L);
        }
        return cs.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.a
    public cs.a f() {
        this.h.d();
        this.a.L();
        return cs.a.a;
    }

    final cs.a g() {
        this.m = false;
        if (!((com.google.android.libraries.navigation.internal.vd.g) this.e.a()).a()) {
            this.a.L();
            return cs.a.a;
        }
        x xVar = (x) this.a.l();
        this.d.d(xVar.h(), this.b, Float.valueOf(xVar.g()), xVar.i(), xVar.k());
        this.d.c(xVar.h(), this.b);
        this.g.a(this);
        return cs.a.a;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.a
    public com.google.android.libraries.navigation.internal.nc.t h() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.a
    public com.google.android.libraries.navigation.internal.nc.t i() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.a
    public ah j() {
        return this.c.a;
    }

    @Override // com.google.android.libraries.navigation.internal.vj.a
    public Boolean k() {
        return Boolean.valueOf(this.m);
    }
}
