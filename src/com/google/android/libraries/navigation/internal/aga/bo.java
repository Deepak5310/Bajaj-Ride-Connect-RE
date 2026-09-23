package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bo implements Runnable {
    final /* synthetic */ br a;

    public bo(br brVar) {
        this.a = brVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        br brVar = this.a;
        bt btVar = brVar.c;
        btVar.u = null;
        if (btVar.s != null) {
            com.google.android.libraries.navigation.internal.yx.ar.l(btVar.q == null, "Unexpected non-null activeTransport");
            br brVar2 = this.a;
            brVar2.a.c(brVar2.c.s);
            return;
        }
        u uVar = btVar.p;
        u uVar2 = brVar.a;
        if (uVar == uVar2) {
            btVar.q = uVar2;
            this.a.c.p = null;
            bt btVar2 = this.a.c;
            btVar2.t = btVar2.h.a();
            this.a.c.d(com.google.android.libraries.navigation.internal.afx.r.READY);
        }
    }
}
