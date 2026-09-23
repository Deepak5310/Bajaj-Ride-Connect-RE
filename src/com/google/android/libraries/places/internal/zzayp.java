package com.google.android.libraries.places.internal;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzayp implements zzbiv {
    private static final Logger zza = Logger.getLogger(zzayp.class.getName());
    private final ScheduledExecutorService zzb;
    private final zzaxl zzc;
    private zzaxk zzd;
    private final zzbca zze;
    private zzbcb zzf;

    zzayp(zzbca zzbcaVar, ScheduledExecutorService scheduledExecutorService, zzaxl zzaxlVar) {
        this.zze = zzbcaVar;
        this.zzb = scheduledExecutorService;
        this.zzc = zzaxlVar;
    }

    final /* synthetic */ void zza() {
        zzaxk zzaxkVar = this.zzd;
        if (zzaxkVar != null && zzaxkVar.zzb()) {
            zzaxkVar.zza();
        }
        this.zzf = null;
    }

    @Override // com.google.android.libraries.places.internal.zzbiv
    public final void zzb() {
        this.zzc.zzd();
        Runnable runnable = new Runnable() { // from class: com.google.android.libraries.places.internal.zzayo
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zza();
            }
        };
        zzaxl zzaxlVar = this.zzc;
        zzaxlVar.zzc(runnable);
        zzaxlVar.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbiv
    public final void zzc(Runnable runnable) {
        this.zzc.zzd();
        if (this.zzf == null) {
            this.zzf = new zzbcb();
        }
        zzaxk zzaxkVar = this.zzd;
        if (zzaxkVar == null || !zzaxkVar.zzb()) {
            long jZza = this.zzf.zza();
            this.zzd = this.zzc.zza(runnable, jZza, TimeUnit.NANOSECONDS, this.zzb);
            zza.logp(Level.FINE, "io.grpc.internal.BackoffPolicyRetryScheduler", "schedule", "Scheduling DNS resolution backoff for {0}ns", Long.valueOf(jZza));
        }
    }
}
