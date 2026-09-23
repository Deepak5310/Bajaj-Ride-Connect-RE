package com.google.android.libraries.navigation.internal.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements Runnable {
    private volatile Runnable a;

    public e(Runnable runnable) {
        this.a = runnable;
    }

    public final void a() {
        this.a = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Runnable runnable = this.a;
        if (runnable == null) {
            return;
        }
        runnable.run();
    }
}
