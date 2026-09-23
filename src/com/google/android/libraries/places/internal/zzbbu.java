package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbbu implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzbbv zzb;

    zzbbu(zzbbv zzbbvVar, boolean z) {
        this.zzb = zzbbvVar;
        this.zza = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zza) {
            zzbby zzbbyVar = this.zzb.zza;
            zzbbyVar.zzf = true;
            if (zzbbyVar.zzt > 0) {
                zzla zzlaVar = zzbbyVar.zzv;
                zzlaVar.zzc();
                zzlaVar.zzd();
            }
        }
        this.zzb.zza.zzA = false;
    }
}
