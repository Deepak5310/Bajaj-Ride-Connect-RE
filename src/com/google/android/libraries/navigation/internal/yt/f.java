package com.google.android.libraries.navigation.internal.yt;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.aac.bj;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements a {
    private static final f a = new f();

    private f() {
    }

    public static final f b(String str) {
        if (str.length() > 127) {
            str = str.substring(0, 127);
        }
        Trace.beginSection(str);
        return a;
    }

    @Override // com.google.android.libraries.navigation.internal.yt.a
    public final bj a(bj bjVar) {
        return bjVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yr.ai, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Trace.endSection();
    }

    public final String toString() {
        return "NonTikTokGmmSpan";
    }
}
