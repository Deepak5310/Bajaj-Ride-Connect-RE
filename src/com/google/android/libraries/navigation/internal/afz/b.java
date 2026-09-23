package com.google.android.libraries.navigation.internal.afz;

import com.google.android.libraries.navigation.internal.aga.az;
import com.google.android.libraries.navigation.internal.aga.er;
import com.google.android.libraries.navigation.internal.aga.ev;
import com.google.android.libraries.navigation.internal.aga.r;
import com.google.android.libraries.navigation.internal.aga.s;
import com.google.android.libraries.navigation.internal.aga.u;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b implements s {
    private final Executor b;
    private final c d;
    private final ev e;
    private final ScheduledExecutorService a = (ScheduledExecutorService) er.a(az.c);
    private final int c = 4194304;

    public b(c cVar, Executor executor, int i, ev evVar) {
        this.d = cVar;
        ar.r(executor, "executor");
        this.b = executor;
        this.e = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aga.s
    public final u a(SocketAddress socketAddress, r rVar, com.google.android.libraries.navigation.internal.afx.g gVar) {
        return new g((InetSocketAddress) socketAddress, rVar.b, this.b, this.e);
    }

    @Override // com.google.android.libraries.navigation.internal.aga.s
    public final Collection b() {
        return Collections.singleton(InetSocketAddress.class);
    }

    @Override // com.google.android.libraries.navigation.internal.aga.s
    public final ScheduledExecutorService c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.aga.s, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        er.d(az.c, this.a);
    }
}
