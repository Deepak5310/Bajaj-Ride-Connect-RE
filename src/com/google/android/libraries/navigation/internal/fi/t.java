package com.google.android.libraries.navigation.internal.fi;

import com.google.android.libraries.navigation.internal.yx.ar;
import j$.time.Instant;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class t {
    public final c a;
    public volatile boolean b;
    private final Executor c;
    private boolean d;
    private int f = 1;
    private long e = 0;

    public t(Executor executor, c cVar) {
        this.c = executor;
        this.a = cVar;
    }

    public final synchronized void a() {
        this.f = 3;
        notifyAll();
    }

    public final synchronized void b() {
        this.f = 1;
        notifyAll();
    }

    public final synchronized void c(final f fVar) {
        ar.k(!this.d);
        ar.k(!this.b);
        this.d = true;
        this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.fi.s
            @Override // java.lang.Runnable
            public final void run() {
                f fVar2 = fVar;
                t tVar = this.a;
                try {
                    tVar.a.a(tVar);
                    synchronized (tVar) {
                        tVar.b = true;
                        tVar.notifyAll();
                    }
                    fVar2.f(tVar);
                } catch (Throwable th) {
                    fVar2.f(tVar);
                    throw th;
                }
            }
        });
    }

    public final synchronized void d() {
        this.b = true;
        notifyAll();
    }

    public final synchronized boolean e() {
        while (!this.b && this.f == 3) {
            try {
                wait();
            } catch (InterruptedException unused) {
                return false;
            }
        }
        return !this.b;
    }

    public final synchronized void f() {
        this.e++;
        if (this.f == 2) {
            this.f = 3;
        }
        notifyAll();
    }

    public final synchronized void g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        while (!this.b) {
            long epochMilli = 1000 - Instant.now().minusMillis(jCurrentTimeMillis).toEpochMilli();
            if (epochMilli <= 0) {
                break;
            }
            try {
                wait(epochMilli);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
