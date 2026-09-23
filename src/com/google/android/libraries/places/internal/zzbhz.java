package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbhz implements Runnable {
    final /* synthetic */ zzaxd zza;
    final /* synthetic */ zzazj zzb;
    final /* synthetic */ zzavu zzc;
    final /* synthetic */ zzbit zzd;

    zzbhz(zzbit zzbitVar, zzaxd zzaxdVar, zzazj zzazjVar, zzavu zzavuVar) {
        this.zzd = zzbitVar;
        this.zza = zzaxdVar;
        this.zzb = zzazjVar;
        this.zzc = zzavuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zzD = true;
        this.zzd.zzy.zzd(this.zza, this.zzb, this.zzc);
    }
}
