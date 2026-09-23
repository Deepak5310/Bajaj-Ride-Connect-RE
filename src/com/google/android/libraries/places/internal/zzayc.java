package com.google.android.libraries.places.internal;

import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzayc {
    final /* synthetic */ zzayd zza;
    private final long zzb;

    /* synthetic */ zzayc(zzayd zzaydVar, long j, zzayb zzaybVar) {
        this.zza = zzaydVar;
        this.zzb = j;
    }

    public final void zza() {
        zzayd zzaydVar = this.zza;
        long j = this.zzb;
        long jMax = Math.max(j + j, j);
        if (zzaydVar.zzc.compareAndSet(j, jMax)) {
            zzayd.zza.logp(Level.WARNING, "io.grpc.internal.AtomicBackoff$State", "backoff", "Increased {0} to {1}", new Object[]{this.zza.zzb, Long.valueOf(jMax)});
        }
    }
}
