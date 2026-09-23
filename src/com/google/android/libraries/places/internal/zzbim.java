package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbim implements Runnable {
    final /* synthetic */ zzbiq zza;

    zzbim(zzbiq zzbiqVar) {
        this.zza = zzbiqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzb.zzD = true;
        zzbit zzbitVar = this.zza.zzb;
        zzbitVar.zzy.zzd(zzbitVar.zzw.zza, this.zza.zzb.zzw.zzb, this.zza.zzb.zzw.zzc);
    }
}
