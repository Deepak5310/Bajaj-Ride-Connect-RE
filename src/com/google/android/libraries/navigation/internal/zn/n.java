package com.google.android.libraries.navigation.internal.zn;

import com.google.android.libraries.navigation.internal.yx.bx;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements Closeable {
    public static final m a = new m();
    final m b;
    private final Deque c = new ArrayDeque(4);
    private Throwable d;

    public n(m mVar) {
        this.b = mVar;
    }

    public final RuntimeException a(Throwable th) throws Throwable {
        this.d = th;
        bx.b(th, IOException.class);
        bx.c(th);
        throw new RuntimeException(th);
    }

    public final void b(Closeable closeable) {
        this.c.addFirst(closeable);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        Throwable th = this.d;
        while (!this.c.isEmpty()) {
            Closeable closeable = (Closeable) this.c.removeFirst();
            try {
                closeable.close();
            } catch (Throwable th2) {
                if (th == null) {
                    th = th2;
                } else {
                    m.a(closeable, th, th2);
                }
            }
        }
        if (this.d != null || th == null) {
            return;
        }
        bx.b(th, IOException.class);
        bx.c(th);
        throw new AssertionError(th);
    }
}
