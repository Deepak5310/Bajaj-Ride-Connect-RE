package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbik implements Runnable {
    final /* synthetic */ zzbil zza;

    zzbik(zzbil zzbilVar) {
        this.zza = zzbilVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbil zzbilVar = this.zza;
        zzbilVar.zzb.zzb.zzai(zzbilVar.zza);
    }
}
