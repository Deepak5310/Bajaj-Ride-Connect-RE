package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbbn implements Runnable {
    final /* synthetic */ zzaxd zza;
    final /* synthetic */ zzazj zzb;
    final /* synthetic */ zzavu zzc;
    final /* synthetic */ zzbbo zzd;

    zzbbn(zzbbo zzbboVar, zzaxd zzaxdVar, zzazj zzazjVar, zzavu zzavuVar) {
        this.zzd = zzbboVar;
        this.zza = zzaxdVar;
        this.zzb = zzazjVar;
        this.zzc = zzavuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zza.zzd(this.zza, this.zzb, this.zzc);
    }
}
