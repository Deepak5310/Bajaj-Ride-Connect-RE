package com.google.android.libraries.navigation.internal.aga;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bk implements Runnable {
    final /* synthetic */ u a;
    final /* synthetic */ boolean b = false;
    final /* synthetic */ bt c;

    public bk(bt btVar, u uVar, boolean z) {
        this.a = uVar;
        this.c = btVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.o.c(this.a, false);
    }
}
