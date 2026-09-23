package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbhj implements Runnable {
    final /* synthetic */ zzbhk zza;

    /* synthetic */ zzbhj(zzbhk zzbhkVar, zzbhi zzbhiVar) {
        this.zza = zzbhkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbhk zzbhkVar = this.zza;
        zzaxl zzaxlVar = (zzaxl) zzbhkVar.zzb;
        zzaxlVar.zzc(new zzbhh(zzbhkVar, null));
        zzaxlVar.zzb();
    }
}
