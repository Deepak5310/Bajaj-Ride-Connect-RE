package com.google.android.libraries.navigation.internal.nw;

import androidx.tracing.Trace;
import java.io.Closeable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Trace.endSection();
    }
}
