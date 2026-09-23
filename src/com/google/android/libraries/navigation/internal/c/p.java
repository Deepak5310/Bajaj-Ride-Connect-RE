package com.google.android.libraries.navigation.internal.c;

import android.os.SystemClock;
import com.google.android.libraries.navigation.internal.b.ad;
import com.google.android.libraries.navigation.internal.b.x;
import com.google.android.libraries.navigation.internal.b.y;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements Future, y, x {
    private boolean a = false;
    private Object b;
    private ad c;

    private final synchronized Object c(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.c != null) {
            throw new ExecutionException(this.c);
        }
        if (!this.a) {
            if (l == null) {
                while (!isDone()) {
                    wait(0L);
                }
            } else if (l.longValue() > 0) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                long jLongValue = l.longValue() + jUptimeMillis;
                while (!isDone() && jUptimeMillis < jLongValue) {
                    wait(jLongValue - jUptimeMillis);
                    jUptimeMillis = SystemClock.uptimeMillis();
                }
            }
            if (this.c != null) {
                throw new ExecutionException(this.c);
            }
            if (!this.a) {
                throw new TimeoutException();
            }
        }
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.b.x
    public final synchronized void a(ad adVar) {
        this.c = adVar;
        notifyAll();
    }

    @Override // com.google.android.libraries.navigation.internal.b.y
    public final synchronized void b(Object obj) {
        this.a = true;
        this.b = obj;
        notifyAll();
    }

    @Override // java.util.concurrent.Future
    public final synchronized boolean cancel(boolean z) {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws ExecutionException, InterruptedException {
        try {
            return c(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return false;
    }

    @Override // java.util.concurrent.Future
    public final synchronized boolean isDone() {
        return this.a || this.c != null;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return c(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }
}
