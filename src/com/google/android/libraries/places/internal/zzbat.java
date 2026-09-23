package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbat implements Runnable {
    final /* synthetic */ zzbgb zza;

    zzbat(zzbax zzbaxVar, zzbgb zzbgbVar) {
        this.zza = zzbgbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbeo zzbeoVar = (zzbeo) this.zza;
        zzkt.zzo(zzbeoVar.zza.zzP.get(), "Channel must have been shut down");
        zzbeoVar.zza.zzQ = true;
        zzbeoVar.zza.zzag(false);
        zzbfr.zzP(zzbeoVar.zza);
    }
}
