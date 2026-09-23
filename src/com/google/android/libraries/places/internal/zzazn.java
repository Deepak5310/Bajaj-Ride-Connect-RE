package com.google.android.libraries.places.internal;

import java.io.Closeable;
import java.net.SocketAddress;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzazn extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    zzazw zza(SocketAddress socketAddress, zzazm zzazmVar, zzasd zzasdVar);

    ScheduledExecutorService zzb();
}
