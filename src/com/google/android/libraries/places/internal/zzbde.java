package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbde implements Runnable {
    final /* synthetic */ zzbdf zza;

    zzbde(zzbdf zzbdfVar) {
        this.zza = zzbdfVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbdu zzbduVar = this.zza.zzb;
        zzbgc zzbgcVar = zzbduVar.zzp;
        zzbduVar.zzo = null;
        this.zza.zzb.zzp = null;
        zzbgcVar.zzd(zzaxd.zzp.zzg("InternalSubchannel closed transport due to address change"));
    }
}
