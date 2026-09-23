package com.google.android.libraries.navigation.internal.po;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class dw implements Runnable {
    protected final com.google.android.libraries.navigation.internal.qd.d a;
    protected final com.google.android.libraries.navigation.internal.qd.d b;
    final /* synthetic */ dy c;

    public dw(dy dyVar, com.google.android.libraries.navigation.internal.qd.d dVar, com.google.android.libraries.navigation.internal.qd.d dVar2) {
        this.c = dyVar;
        this.a = dVar;
        this.b = dVar2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.B(this.a, this.b, true);
    }
}
