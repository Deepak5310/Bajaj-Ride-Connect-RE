package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbff implements Runnable {
    final /* synthetic */ Runnable zza;
    final /* synthetic */ zzbfh zzb;

    zzbff(zzbfh zzbfhVar, Runnable runnable) {
        this.zzb = zzbfhVar;
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.run();
        zzbfh zzbfhVar = this.zzb;
        zzbfg zzbfgVar = new zzbfg(zzbfhVar);
        zzaxl zzaxlVar = zzbfhVar.zzd.zza.zzf;
        zzaxlVar.zzc(zzbfgVar);
        zzaxlVar.zzb();
    }
}
