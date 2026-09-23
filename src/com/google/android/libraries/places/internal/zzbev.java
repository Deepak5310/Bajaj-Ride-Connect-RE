package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbev implements Runnable {
    final /* synthetic */ zzauz zza;
    final /* synthetic */ zzasu zzb;
    final /* synthetic */ zzbex zzc;

    zzbev(zzbex zzbexVar, zzauz zzauzVar, zzasu zzasuVar) {
        this.zzc = zzbexVar;
        this.zza = zzauzVar;
        this.zzb = zzasuVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbex zzbexVar = this.zzc;
        zzbfr zzbfrVar = zzbexVar.zzb;
        if (zzbexVar != zzbfrVar.zzG) {
            return;
        }
        zzbfrVar.zzah(this.zza);
        if (this.zzb != zzasu.SHUTDOWN) {
            this.zzc.zzb.zzW.zzb(2, "Entering {0} state with picker: {1}", this.zzb, this.zza);
            zzbex zzbexVar2 = this.zzc;
            zzbexVar2.zzb.zzC.zza(this.zzb);
        }
    }
}
