package com.google.android.libraries.navigation.internal.xe;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class as extends com.google.android.libraries.navigation.internal.dp.g implements com.google.android.libraries.navigation.internal.pi.n {
    public boolean A;
    public boolean B;
    public boolean C;
    public com.google.android.libraries.navigation.internal.abh.fe D;
    private final com.google.android.libraries.navigation.internal.abh.ac E;
    private boolean F;
    private boolean G;
    private boolean H;
    private Boolean I;
    private final com.google.android.libraries.navigation.internal.abh.bt J;
    public final com.google.android.libraries.navigation.internal.pb.i w;
    public final com.google.android.libraries.navigation.internal.pi.s x;
    public final Executor y;
    public boolean z;

    /* JADX WARN: Type inference failed for: r9v0, types: [com.google.android.libraries.navigation.internal.xe.ap] */
    public as(Executor executor, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.ni.a aVar, com.google.android.libraries.navigation.internal.dq.i iVar, com.google.android.libraries.navigation.internal.cw.a aVar2, com.google.android.libraries.navigation.internal.ob.f fVar, com.google.android.libraries.navigation.internal.pb.i iVar2, com.google.android.libraries.navigation.internal.abh.ac acVar, com.google.android.libraries.navigation.internal.afo.a aVar3) {
        super(executor, sVar, eVar, aVar, iVar, aVar2, fVar, aVar3, new Object() { // from class: com.google.android.libraries.navigation.internal.xe.ap
        });
        this.B = true;
        this.J = new aq(this);
        this.E = acVar;
        this.w = iVar2;
        this.x = sVar;
        this.y = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.dp.g
    public final void b() {
        this.G = false;
        if (this.z) {
            super.b();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.dp.g
    public final void c() {
        this.F = false;
        if (this.z) {
            super.c();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.dp.g
    protected final synchronized void d(com.google.android.libraries.navigation.internal.pc.c cVar) {
        if (this.E != null) {
            this.w.b(cVar);
            if (cVar instanceof com.google.android.libraries.navigation.internal.dp.m) {
                this.E.g(this.J);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.dp.g
    public final void g() {
        this.G = true;
        if (this.z) {
            super.g();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.dp.g
    public final void h() {
        this.F = true;
        if (this.z) {
            super.h();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pi.n
    public final void i(com.google.android.libraries.navigation.internal.pi.w wVar) {
        com.google.android.libraries.navigation.internal.abh.fe feVar;
        if (!(wVar instanceof com.google.android.libraries.navigation.internal.pi.ag) || (feVar = this.D) == null) {
            return;
        }
        feVar.i();
    }

    public final void j() {
        if (this.G) {
            super.b();
        }
        if (this.F) {
            super.c();
        }
        l();
        this.z = false;
        this.A = false;
    }

    public final void k() {
        com.google.android.libraries.navigation.internal.nj.i.b();
        if (!this.z) {
            if (this.F) {
                super.h();
            }
            if (this.G) {
                super.g();
            }
            this.z = true;
        }
        Boolean bool = this.I;
        boolean zBooleanValue = bool == null ? this.A : bool.booleanValue();
        if (!Boolean.TRUE.equals(this.I)) {
            this.B = true;
        }
        n(zBooleanValue);
    }

    public final void l() {
        this.g.i(com.google.android.libraries.navigation.internal.dt.c.NONE);
        this.H = false;
    }

    public final void m() {
        if (this.C) {
            this.x.k(this);
            this.C = false;
        }
        this.D = null;
        com.google.android.libraries.navigation.internal.hx.ap.UI_THREAD.f();
        this.g.d();
        this.f403n = null;
        this.k = null;
        this.l = null;
        this.s = null;
    }

    public final void n(boolean z) {
        boolean z2;
        com.google.android.libraries.navigation.internal.dt.c cVar;
        if (!this.z) {
            this.I = Boolean.valueOf(z);
            return;
        }
        if (this.A && !z) {
            o(false);
            if (!this.H) {
                j();
                return;
            }
        }
        boolean z3 = this.A || !z || this.B;
        if (this.H || z3) {
            com.google.android.libraries.navigation.internal.dq.i iVar = this.g;
            if (z) {
                cVar = com.google.android.libraries.navigation.internal.dt.c.NAVIGATION;
                z2 = true;
            } else {
                z2 = false;
                cVar = com.google.android.libraries.navigation.internal.dt.c.MAP;
            }
            iVar.i(cVar);
            this.g.u(z2 ? 1 : 3);
            this.H = true;
        }
        this.A = z;
        this.I = null;
    }

    public final void o(boolean z) {
        d(new ar(z, com.google.android.libraries.navigation.internal.pd.d.c));
    }
}
