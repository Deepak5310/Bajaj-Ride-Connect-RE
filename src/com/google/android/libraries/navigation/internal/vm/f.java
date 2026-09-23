package com.google.android.libraries.navigation.internal.vm;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.kk.m;
import java.io.Closeable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements Closeable {
    private final com.google.android.libraries.navigation.internal.nw.d a;
    private final m b;

    public f(com.google.android.libraries.navigation.internal.nw.d dVar, m mVar) {
        this.a = dVar;
        this.b = mVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.a != null) {
            Trace.endSection();
        }
        this.b.a();
    }
}
