package com.google.android.libraries.navigation.internal.km;

import android.os.SystemClock;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t {
    private final com.google.android.libraries.navigation.internal.kk.l a;
    private final com.google.android.libraries.navigation.internal.mj.a b;
    private boolean c;
    private long d;
    private long e = -1;

    public t(com.google.android.libraries.navigation.internal.kk.l lVar, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.a = lVar;
        this.b = aVar;
    }

    public final synchronized void a() {
        if (this.e >= 0) {
            this.e = -1L;
        }
        this.c = false;
    }

    public final synchronized void b() {
        this.d = SystemClock.elapsedRealtime();
        this.c = true;
    }

    public final synchronized void c() {
        if (this.c) {
            long j = this.e;
            if (j < 0) {
                this.e = 0L;
                j = 0;
            }
            this.e = j + (SystemClock.elapsedRealtime() - this.d);
            this.c = false;
        }
    }
}
