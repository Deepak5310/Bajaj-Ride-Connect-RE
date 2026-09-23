package com.google.android.libraries.places.internal;

import java.util.concurrent.ScheduledFuture;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaxk {
    private final zzaxi zza;
    private final ScheduledFuture zzb;

    /* synthetic */ zzaxk(zzaxi zzaxiVar, ScheduledFuture scheduledFuture, zzaxj zzaxjVar) {
        this.zza = zzaxiVar;
        zzkt.zzc(scheduledFuture, "future");
        this.zzb = scheduledFuture;
    }

    public final void zza() {
        this.zza.zzb = true;
        this.zzb.cancel(false);
    }

    public final boolean zzb() {
        zzaxi zzaxiVar = this.zza;
        return (zzaxiVar.zzc || zzaxiVar.zzb) ? false : true;
    }
}
