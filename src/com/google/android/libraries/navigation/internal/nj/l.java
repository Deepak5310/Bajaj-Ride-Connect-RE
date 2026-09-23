package com.google.android.libraries.navigation.internal.nj;

import com.google.android.libraries.navigation.internal.aac.bl;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l extends com.google.android.libraries.navigation.internal.aac.d implements Runnable, bl {
    final long a;
    final long b;
    final boolean c;
    final AtomicLong d = new AtomicLong(0);
    Runnable e;
    final /* synthetic */ n f;

    public l(n nVar, Runnable runnable, long j, long j2, boolean z) {
        this.f = nVar;
        this.e = runnable;
        this.a = j;
        this.b = j2;
        this.c = z;
    }

    private final long f() {
        return Math.max(0L, ((this.d.get() * this.b) + this.a) - this.f.a.a());
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(Delayed delayed) {
        return n.a(this, delayed);
    }

    @Override // java.util.concurrent.Delayed
    public final long getDelay(TimeUnit timeUnit) {
        return timeUnit.convert(f(), TimeUnit.MILLISECONDS);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (isDone()) {
            return;
        }
        this.d.incrementAndGet();
        try {
            Runnable runnable = this.e;
            ar.q(runnable);
            runnable.run();
            if (this.c) {
                n nVar = this.f;
                nVar.b.postDelayed(this, f());
            } else {
                n nVar2 = this.f;
                nVar2.b.postDelayed(this, this.b);
            }
        } catch (Throwable th) {
            this.e = null;
            ap(th);
        }
    }
}
