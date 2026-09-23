package com.google.android.libraries.navigation.internal.xm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q implements Runnable {
    final /* synthetic */ s a;

    public q(s sVar) {
        this.a = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.cancel(true);
    }
}
