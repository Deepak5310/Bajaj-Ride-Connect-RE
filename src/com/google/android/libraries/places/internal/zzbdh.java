package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdh implements Runnable {
    final /* synthetic */ zzbdu zza;

    zzbdh(zzbdu zzbduVar) {
        this.zza = zzbduVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzi.zza(2, "Terminated");
        zzbdu zzbduVar = this.zza;
        zzbfm zzbfmVar = (zzbfm) zzbduVar.zzc;
        zzbfmVar.zzb.zzj.zzJ.remove(zzbduVar);
        zzbfmVar.zzb.zzj.zzX.zzh(zzbduVar);
        zzbfr.zzP(zzbfmVar.zzb.zzj);
    }
}
