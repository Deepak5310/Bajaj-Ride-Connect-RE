package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbds implements zzbgb {
    final zzazw zza;
    boolean zzb = false;
    final /* synthetic */ zzbdu zzc;

    zzbds(zzbdu zzbduVar, zzazw zzazwVar) {
        this.zzc = zzbduVar;
        this.zza = zzazwVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbgb
    public final void zza(boolean z) {
        zzbdu.zzB(this.zzc, this.zza, z);
    }

    @Override // com.google.android.libraries.places.internal.zzbgb
    public final void zzb() {
        this.zzc.zzi.zza(2, "READY");
        zzaxl zzaxlVar = this.zzc.zzj;
        zzaxlVar.zzc(new zzbdp(this));
        zzaxlVar.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbgb
    public final void zzc(zzaxd zzaxdVar) {
        zzasd zzasdVar = this.zzc.zzi;
        zzauf zzaufVarZzc = this.zza.zzc();
        zzbdu zzbduVar = this.zzc;
        zzasdVar.zzb(2, "{0} SHUTDOWN with {1}", zzaufVarZzc, zzbdu.zzJ(zzaxdVar));
        this.zzb = true;
        zzaxl zzaxlVar = this.zzc.zzj;
        zzaxlVar.zzc(new zzbdq(this, zzaxdVar));
        zzaxlVar.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbgb
    public final void zzd() {
        zzkt.zzo(this.zzb, "transportShutdown() must be called before transportTerminated().");
        this.zzc.zzi.zzb(2, "{0} Terminated", this.zza.zzc());
        this.zzc.zzf.zzf(this.zza);
        zzbdu.zzB(this.zzc, this.zza, false);
        zzaxl zzaxlVar = this.zzc.zzj;
        zzaxlVar.zzc(new zzbdr(this));
        zzaxlVar.zzb();
    }
}
