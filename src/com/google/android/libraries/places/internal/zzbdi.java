package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdi implements Runnable {
    final /* synthetic */ zzazw zza;
    final /* synthetic */ boolean zzb;
    final /* synthetic */ zzbdu zzc;

    zzbdi(zzbdu zzbduVar, zzazw zzazwVar, boolean z) {
        this.zzc = zzbduVar;
        this.zza = zzazwVar;
        this.zzb = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzr.zzc(this.zza, this.zzb);
    }
}
