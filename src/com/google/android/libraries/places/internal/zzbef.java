package com.google.android.libraries.places.internal;

import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbef implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzbfr zza;

    zzbef(zzbfr zzbfrVar) {
        this.zza = zzbfrVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        zzbfr zzbfrVar = this.zza;
        zzbfr.zza.logp(Level.SEVERE, "io.grpc.internal.ManagedChannelImpl$2", "uncaughtException", "[" + String.valueOf(zzbfrVar.zzc()) + "] Uncaught exception in the SynchronizationContext. Panic!", th);
        this.zza.zzV(th);
    }
}
