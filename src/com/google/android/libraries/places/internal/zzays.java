package com.google.android.libraries.places.internal;

import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzays implements zzazn {
    private final zzazn zza;
    private final Executor zzb;

    zzays(zzazn zzaznVar, zzarw zzarwVar, Executor executor) {
        this.zza = zzaznVar;
        zzkt.zzc(executor, "appExecutor");
        this.zzb = executor;
    }

    @Override // com.google.android.libraries.places.internal.zzazn, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.zza.close();
    }

    @Override // com.google.android.libraries.places.internal.zzazn
    public final zzazw zza(SocketAddress socketAddress, zzazm zzazmVar, zzasd zzasdVar) {
        return new zzayr(this, this.zza.zza(socketAddress, zzazmVar, zzasdVar), zzazmVar.zzg());
    }

    @Override // com.google.android.libraries.places.internal.zzazn
    public final ScheduledExecutorService zzb() {
        return this.zza.zzb();
    }
}
