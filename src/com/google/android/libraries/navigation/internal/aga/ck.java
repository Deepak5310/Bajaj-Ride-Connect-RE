package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ck implements Runnable {
    final /* synthetic */ com.google.android.libraries.navigation.internal.afx.cl a;
    final /* synthetic */ cl b;

    public ck(cl clVar, com.google.android.libraries.navigation.internal.afx.cl clVar2) {
        this.a = clVar2;
        this.b = clVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b(this.a);
    }
}
