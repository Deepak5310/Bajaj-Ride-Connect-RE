package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbal implements Runnable {
    final /* synthetic */ zzavu zza;
    final /* synthetic */ zzbap zzb;

    zzbal(zzbap zzbapVar, zzavu zzavuVar) {
        this.zzb = zzbapVar;
        this.zza = zzavuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzb(this.zza);
    }
}
