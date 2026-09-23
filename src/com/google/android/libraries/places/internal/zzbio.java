package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbio implements Runnable {
    final /* synthetic */ zzbjv zza;
    final /* synthetic */ zzbiq zzb;

    zzbio(zzbiq zzbiqVar, zzbjv zzbjvVar) {
        this.zzb = zzbiqVar;
        this.zza = zzbjvVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb.zzy.zzf(this.zza);
    }
}
