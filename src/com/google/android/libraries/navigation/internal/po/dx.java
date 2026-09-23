package com.google.android.libraries.navigation.internal.po;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class dx extends dw {
    public dx(dy dyVar, com.google.android.libraries.navigation.internal.qd.d dVar, com.google.android.libraries.navigation.internal.qd.d dVar2) {
        super(dyVar, dVar, dVar2);
    }

    @Override // com.google.android.libraries.navigation.internal.po.dw, java.lang.Runnable
    public final void run() {
        com.google.android.libraries.navigation.internal.qd.d dVar = this.a;
        if (dVar instanceof com.google.android.libraries.navigation.internal.qd.w) {
            com.google.android.libraries.navigation.internal.qd.d dVar2 = this.b;
            if (dVar2 instanceof com.google.android.libraries.navigation.internal.qd.w) {
                ((com.google.android.libraries.navigation.internal.qd.w) dVar2).w((com.google.android.libraries.navigation.internal.qd.w) dVar);
            }
        }
        super.run();
    }
}
