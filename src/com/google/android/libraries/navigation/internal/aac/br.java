package com.google.android.libraries.navigation.internal.aac;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class br extends d.i implements Runnable {
    private final Runnable a;

    public br(Runnable runnable) {
        com.google.android.libraries.navigation.internal.yx.ar.q(runnable);
        this.a = runnable;
    }

    @Override // com.google.android.libraries.navigation.internal.aac.d
    protected final String ao() {
        return "task=[" + String.valueOf(this.a) + "]";
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.run();
        } catch (Throwable th) {
            ap(th);
            throw th;
        }
    }
}
