package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbin implements Runnable {
    final /* synthetic */ zzbir zza;
    final /* synthetic */ zzbiq zzb;

    zzbin(zzbiq zzbiqVar, zzbir zzbirVar) {
        this.zzb = zzbiqVar;
        this.zza = zzbirVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzb.zzai(this.zza);
    }
}
