package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bi implements Runnable {
    final /* synthetic */ com.google.android.libraries.navigation.internal.afx.cl a;
    final /* synthetic */ bt b;

    public bi(bt btVar, com.google.android.libraries.navigation.internal.afx.cl clVar) {
        this.a = clVar;
        this.b = btVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.b.r.a == com.google.android.libraries.navigation.internal.afx.r.SHUTDOWN) {
            return;
        }
        bt btVar = this.b;
        btVar.s = this.a;
        bt btVar2 = this.b;
        de deVar = btVar.q;
        u uVar = btVar2.p;
        btVar2.q = null;
        this.b.p = null;
        this.b.d(com.google.android.libraries.navigation.internal.afx.r.SHUTDOWN);
        this.b.h.c();
        if (this.b.f333n.isEmpty()) {
            this.b.f();
        }
        bt btVar3 = this.b;
        btVar3.g.d();
        com.google.android.libraries.navigation.internal.afx.cp cpVar = btVar3.k;
        if (cpVar != null) {
            cpVar.a();
            btVar3.k = null;
            btVar3.u = null;
        }
        com.google.android.libraries.navigation.internal.afx.cp cpVar2 = this.b.l;
        if (cpVar2 != null) {
            cpVar2.a();
            bt btVar4 = this.b;
            btVar4.m.c(this.a);
            bt btVar5 = this.b;
            btVar5.l = null;
            btVar5.m = null;
        }
        if (deVar != null) {
            deVar.c(this.a);
        }
        if (uVar != null) {
            uVar.c(this.a);
        }
    }
}
