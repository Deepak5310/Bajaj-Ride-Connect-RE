package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbij implements Runnable {
    final /* synthetic */ zzavu zza;
    final /* synthetic */ zzbiq zzb;

    zzbij(zzbiq zzbiqVar, zzavu zzavuVar) {
        this.zzb = zzbiqVar;
        this.zza = zzavuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb.zzy.zze(this.zza);
    }
}
