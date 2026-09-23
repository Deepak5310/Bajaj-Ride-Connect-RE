package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzban implements Runnable {
    final /* synthetic */ zzaxd zza;
    final /* synthetic */ zzavu zzb;
    final /* synthetic */ zzbap zzc;

    zzban(zzbap zzbapVar, zzaxd zzaxdVar, zzavu zzavuVar) {
        this.zzc = zzbapVar;
        this.zza = zzaxdVar;
        this.zzb = zzavuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza.zza(this.zza, this.zzb);
    }
}
