package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ci implements Runnable {
    final /* synthetic */ com.google.android.libraries.navigation.internal.afx.ax a;
    final /* synthetic */ com.google.android.libraries.navigation.internal.afx.r b;
    final /* synthetic */ cj c;

    public ci(cj cjVar, com.google.android.libraries.navigation.internal.afx.ax axVar, com.google.android.libraries.navigation.internal.afx.r rVar) {
        this.a = axVar;
        this.b = rVar;
        this.c = cjVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        cj cjVar = this.c;
        cr crVar = cjVar.b;
        if (cjVar != crVar.p || crVar.q) {
            return;
        }
        crVar.h(this.a);
        if (this.b != com.google.android.libraries.navigation.internal.afx.r.SHUTDOWN) {
            cj cjVar2 = this.c;
            cjVar2.b.y.b(2, "Entering {0} state with picker: {1}", this.b, this.a);
            cj cjVar3 = this.c;
            cjVar3.b.l.a(this.b);
        }
    }
}
