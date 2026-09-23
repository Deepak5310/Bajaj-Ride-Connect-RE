package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbag implements Runnable {
    final /* synthetic */ Object zza;
    final /* synthetic */ zzbaq zzb;

    zzbag(zzbaq zzbaqVar, Object obj) {
        this.zzb = zzbaqVar;
        this.zza = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzh.zzd(this.zza);
    }
}
