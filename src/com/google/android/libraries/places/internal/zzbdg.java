package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdg implements Runnable {
    final /* synthetic */ zzaxd zza;
    final /* synthetic */ zzbdu zzb;

    zzbdg(zzbdu zzbduVar, zzaxd zzaxdVar) {
        this.zzb = zzbduVar;
        this.zza = zzaxdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb.zzu.zza() == zzasu.SHUTDOWN) {
            return;
        }
        this.zzb.zzv = this.zza;
        zzbdu zzbduVar = this.zzb;
        zzbgc zzbgcVar = zzbduVar.zzt;
        zzazw zzazwVar = zzbduVar.zzs;
        zzbduVar.zzt = null;
        this.zzb.zzs = null;
        zzbdu.zzz(this.zzb, zzasu.SHUTDOWN);
        this.zzb.zzk.zzd();
        if (this.zzb.zzq.isEmpty()) {
            zzbdu.zzA(this.zzb);
        }
        zzbdu.zzy(this.zzb);
        zzbdu zzbduVar2 = this.zzb;
        if (zzbduVar2.zzo != null) {
            zzbduVar2.zzo.zza();
            zzbdu zzbduVar3 = this.zzb;
            zzbduVar3.zzp.zzd(this.zza);
            this.zzb.zzo = null;
            this.zzb.zzp = null;
        }
        if (zzbgcVar != null) {
            zzbgcVar.zzd(this.zza);
        }
        if (zzazwVar != null) {
            zzazwVar.zzd(this.zza);
        }
    }
}
