package com.google.android.libraries.navigation.internal.yr;

import com.google.android.libraries.navigation.internal.aac.bj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w implements Runnable, ai {
    public ag a;
    public ag b;
    private final boolean c = com.google.android.libraries.navigation.internal.xx.c.d(Thread.currentThread());
    private boolean d;
    private boolean e;
    private boolean f;

    public w(ag agVar, boolean z) {
        this.f = false;
        this.a = agVar;
        this.b = agVar;
        this.f = z;
    }

    private final void b() {
        this.d = true;
        if (this.c && !this.e) {
            com.google.android.libraries.navigation.internal.xx.c.c();
        }
        this.a = null;
    }

    public final void a(bj bjVar) {
        if (this.d) {
            throw new IllegalStateException("Span was already closed. Did you attach it to a future after calling Tracer.endSpan()?");
        }
        if (this.e) {
            throw new IllegalStateException("Signal is already attached to future");
        }
        this.e = true;
        bjVar.l(this, com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.d || !this.e) {
            com.google.android.libraries.navigation.internal.xx.c.b(new Runnable() { // from class: com.google.android.libraries.navigation.internal.yr.v
                @Override // java.lang.Runnable
                public final void run() {
                    throw new IllegalStateException("Span was closed by an invalid call to SpanEndSignal.run()");
                }
            });
        } else {
            b();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.yr.ai, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ag agVar = this.b;
        try {
            this.b = null;
            if (!this.e) {
                if (this.d) {
                    throw new IllegalStateException("Span was already closed!");
                }
                b();
            }
            if (agVar != null) {
                agVar.close();
            }
            if (this.f) {
                i.d(u.b);
            }
        } catch (Throwable th) {
            if (agVar != null) {
                try {
                    agVar.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
