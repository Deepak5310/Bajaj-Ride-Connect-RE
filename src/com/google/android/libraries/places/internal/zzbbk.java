package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbbk implements Runnable {
    final /* synthetic */ zzbjv zza;
    final /* synthetic */ zzbbo zzb;

    zzbbk(zzbbo zzbboVar, zzbjv zzbjvVar) {
        this.zzb = zzbboVar;
        this.zza = zzbjvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzf(this.zza);
    }
}
