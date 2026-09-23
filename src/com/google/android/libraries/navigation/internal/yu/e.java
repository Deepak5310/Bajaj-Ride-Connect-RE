package com.google.android.libraries.navigation.internal.yu;

import com.google.android.libraries.navigation.internal.yr.am;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements Runnable {
    private final AtomicReference a;
    private final Runnable b;

    public e(Runnable runnable) {
        this.a = new AtomicReference(am.e(runnable));
        this.b = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((Runnable) this.a.getAndSet(this.b)).run();
    }
}
