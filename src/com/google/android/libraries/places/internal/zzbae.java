package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbae implements Runnable {
    final /* synthetic */ zzase zza;
    final /* synthetic */ zzavu zzb;
    final /* synthetic */ zzbaq zzc;

    zzbae(zzbaq zzbaqVar, zzase zzaseVar, zzavu zzavuVar) {
        this.zzc = zzbaqVar;
        this.zza = zzaseVar;
        this.zzb = zzavuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzh.zze(this.zza, this.zzb);
    }
}
