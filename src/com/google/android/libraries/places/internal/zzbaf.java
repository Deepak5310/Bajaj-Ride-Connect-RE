package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbaf implements Runnable {
    final /* synthetic */ zzaxd zza;
    final /* synthetic */ zzbaq zzb;

    zzbaf(zzbaq zzbaqVar, zzaxd zzaxdVar) {
        this.zzb = zzbaqVar;
        this.zza = zzaxdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzaxd zzaxdVar = this.zza;
        this.zzb.zzh.zza(zzaxdVar.zzi(), zzaxdVar.zzj());
    }
}
