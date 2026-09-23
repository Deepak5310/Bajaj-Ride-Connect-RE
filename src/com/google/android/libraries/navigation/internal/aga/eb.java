package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class eb implements Runnable {
    final /* synthetic */ ec a;

    public eb(ec ecVar) {
        this.a = ecVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ec ecVar = this.a;
        ecVar.b.execute(new ea(ecVar));
    }
}
