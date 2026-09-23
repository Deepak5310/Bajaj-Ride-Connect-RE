package com.google.android.libraries.navigation.internal.po;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class by implements Runnable, com.google.android.libraries.navigation.internal.qz.g {
    private final Executor a;
    private final com.google.android.libraries.navigation.internal.aac.ca b;
    private int c;

    public by(Executor executor, com.google.android.libraries.navigation.internal.aac.ca caVar, int i) {
        com.google.android.libraries.navigation.internal.yx.ar.d(i > 0, "BackgroundBarrier given a count <= 0: %s", i);
        this.a = executor;
        this.b = caVar;
        this.c = i;
    }

    @Override // com.google.android.libraries.navigation.internal.qz.g
    public final void a(com.google.android.libraries.navigation.internal.qz.k kVar) {
        int i;
        synchronized (this) {
            i = this.c - 1;
            this.c = i;
        }
        if (i == 0) {
            this.a.execute(this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.d(null);
    }
}
