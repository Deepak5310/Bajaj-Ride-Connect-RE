package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbam implements Runnable {
    final /* synthetic */ Object zza;
    final /* synthetic */ zzbap zzb;

    zzbam(zzbap zzbapVar, Object obj) {
        this.zzb = zzbapVar;
        this.zza = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzc(this.zza);
    }
}
