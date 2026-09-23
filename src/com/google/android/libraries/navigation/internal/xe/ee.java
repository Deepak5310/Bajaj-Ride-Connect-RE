package com.google.android.libraries.navigation.internal.xe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ee implements Runnable {
    final /* synthetic */ com.google.android.libraries.navigation.environment.am a;
    final /* synthetic */ int b;
    final /* synthetic */ ef c;

    public ee(ef efVar, com.google.android.libraries.navigation.environment.am amVar, int i) {
        this.a = amVar;
        this.b = i;
        this.c = efVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.google.android.libraries.navigation.internal.wd.f fVarA = this.a.bv().a(com.google.android.libraries.navigation.internal.abx.b.NAVIGATION_SERVICE_READY);
        this.c.b.c(this.a, this.b);
        fVarA.b(this.b);
    }
}
