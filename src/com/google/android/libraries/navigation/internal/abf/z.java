package com.google.android.libraries.navigation.internal.abf;

import android.os.Looper;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class z {
    public static final z a = new z(Looper.getMainLooper().getThread());
    private final Thread b;

    public z(Thread thread) {
        s.k(thread, "expectedThread");
        this.b = thread;
    }

    public final void a() {
        t.b(Thread.currentThread() == this.b, "Not on the main thread");
    }

    public final void b() {
        t.b(Thread.currentThread() != this.b, "Should not be on the main thread");
    }
}
