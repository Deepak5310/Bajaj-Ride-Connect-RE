package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ai implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ aj b;

    public ai(aj ajVar, boolean z) {
        this.a = z;
        this.b = ajVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a) {
            am amVar = this.b.b;
            amVar.o = true;
            if (amVar.l > 0) {
                com.google.android.libraries.navigation.internal.yx.bm bmVar = amVar.f332n;
                bmVar.c();
                bmVar.d();
            }
        }
        this.b.b.q = false;
    }
}
