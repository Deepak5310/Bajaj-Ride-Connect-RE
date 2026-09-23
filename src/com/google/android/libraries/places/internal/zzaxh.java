package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaxh implements Runnable {
    final /* synthetic */ zzaxi zza;
    final /* synthetic */ Runnable zzb;
    final /* synthetic */ zzaxl zzc;

    zzaxh(zzaxl zzaxlVar, zzaxi zzaxiVar, Runnable runnable) {
        this.zzc = zzaxlVar;
        this.zza = zzaxiVar;
        this.zzb = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaxl zzaxlVar = this.zzc;
        zzaxlVar.zzc(this.zza);
        zzaxlVar.zzb();
    }

    public final String toString() {
        return String.valueOf(this.zzb.toString()).concat("(scheduled in SynchronizationContext)");
    }
}
