package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cg implements Runnable {
    final /* synthetic */ cr a;

    public cg(cr crVar) {
        this.a = crVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cr crVar = this.a;
        if (crVar.p == null) {
            return;
        }
        crVar.g(true);
        crVar.t.d(null);
        crVar.y.a(2, "Entering IDLE state");
        crVar.l.a(com.google.android.libraries.navigation.internal.afx.r.IDLE);
        bb bbVar = crVar.F;
        Object[] objArr = {crVar.s, crVar.t};
        for (int i = 0; i < 2; i++) {
            if (bbVar.a.contains(objArr[i])) {
                crVar.d();
                return;
            }
        }
    }
}
