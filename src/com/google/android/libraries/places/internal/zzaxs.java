package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaxs implements Runnable {
    final /* synthetic */ zzaxd zza;
    final /* synthetic */ zzazj zzb;
    final /* synthetic */ zzavu zzc;
    final /* synthetic */ zzaxt zzd;

    zzaxs(zzaxt zzaxtVar, zzaxd zzaxdVar, zzazj zzazjVar, zzavu zzavuVar) {
        this.zzd = zzaxtVar;
        this.zza = zzaxdVar;
        this.zzb = zzazjVar;
        this.zzc = zzavuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zzA(this.zza, this.zzb, this.zzc);
    }
}
