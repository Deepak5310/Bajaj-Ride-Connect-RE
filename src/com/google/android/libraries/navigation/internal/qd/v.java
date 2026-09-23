package com.google.android.libraries.navigation.internal.qd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class v implements Runnable {
    public volatile Runnable a;
    public final Runnable b;

    public v(Runnable runnable) {
        this.a = runnable;
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.run();
    }
}
