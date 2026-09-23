package com.google.android.libraries.navigation.internal.aga;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bp implements Runnable {
    final /* synthetic */ com.google.android.libraries.navigation.internal.afx.cl a;
    final /* synthetic */ br b;

    public bp(br brVar, com.google.android.libraries.navigation.internal.afx.cl clVar) {
        this.a = clVar;
        this.b = brVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.c.r.a == com.google.android.libraries.navigation.internal.afx.r.SHUTDOWN) {
            return;
        }
        br brVar = this.b;
        de deVar = brVar.c.q;
        u uVar = brVar.a;
        if (deVar == uVar) {
            brVar.c.q = null;
            this.b.c.h.c();
            this.b.c.d(com.google.android.libraries.navigation.internal.afx.r.IDLE);
            return;
        }
        bt btVar = brVar.c;
        if (btVar.p == uVar) {
            com.google.android.libraries.navigation.internal.yx.ar.o(btVar.r.a == com.google.android.libraries.navigation.internal.afx.r.CONNECTING, "Expected state is CONNECTING, actual state is %s", this.b.c.r.a);
            bn bnVar = this.b.c.h;
            com.google.android.libraries.navigation.internal.afx.z zVar = (com.google.android.libraries.navigation.internal.afx.z) bnVar.a.get(bnVar.b);
            int i = bnVar.c + 1;
            bnVar.c = i;
            if (i >= zVar.b.size()) {
                bnVar.b++;
                bnVar.c = 0;
            }
            bn bnVar2 = this.b.c.h;
            if (bnVar2.b < bnVar2.a.size()) {
                this.b.c.h();
                return;
            }
            this.b.c.p = null;
            this.b.c.h.c();
            br brVar2 = this.b;
            com.google.android.libraries.navigation.internal.afx.cl clVar = this.a;
            bt btVar2 = brVar2.c;
            btVar2.g.d();
            com.google.android.libraries.navigation.internal.yx.ar.b(!clVar.c(), "The error status must not be OK");
            btVar2.e(new com.google.android.libraries.navigation.internal.afx.s(com.google.android.libraries.navigation.internal.afx.r.TRANSIENT_FAILURE, clVar));
            if (btVar2.e) {
                return;
            }
            if (btVar2.u == null) {
                btVar2.u = new ap();
            }
            long jA = btVar2.u.a() - btVar2.j.a(TimeUnit.NANOSECONDS);
            btVar2.d.b(2, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", bt.j(clVar), Long.valueOf(jA));
            com.google.android.libraries.navigation.internal.yx.ar.l(btVar2.k == null, "previous reconnectTask is not done");
            btVar2.k = btVar2.g.a(new be(btVar2), jA, TimeUnit.NANOSECONDS, btVar2.b);
        }
    }
}
