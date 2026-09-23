package com.google.android.libraries.navigation.internal.nj;

import com.google.android.libraries.navigation.internal.aac.bl;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class m extends com.google.android.libraries.navigation.internal.aac.d implements Runnable, bl {
    final /* synthetic */ n a;
    private Callable b;
    private final long c;

    public m(n nVar, Callable callable, long j) {
        this.a = nVar;
        this.b = callable;
        this.c = j;
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Delayed delayed) {
        return n.a(this, delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return Math.max(0L, TimeUnit.MILLISECONDS.convert(this.c - this.a.a.a(), timeUnit));
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (isDone()) {
            return;
        }
        try {
            Callable callable = this.b;
            ar.q(callable);
            this.b = null;
            d(callable.call());
        } catch (Throwable th) {
            ap(th);
            throw new RuntimeException(th);
        }
    }
}
