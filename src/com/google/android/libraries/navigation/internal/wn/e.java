package com.google.android.libraries.navigation.internal.wn;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.kk.m;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public final AtomicInteger a = new AtomicInteger();
    public final com.google.android.libraries.navigation.internal.kl.b b;
    public final Executor c;

    public e(com.google.android.libraries.navigation.internal.kl.b bVar, Executor executor) {
        this.b = bVar;
        this.c = executor;
    }

    public static final void a(String str, m mVar, int i) {
        String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
        Trace.endAsyncSection("GuidanceRouteExtractorImpl.getRoutesForGuidance", i);
        mVar.a();
    }
}
