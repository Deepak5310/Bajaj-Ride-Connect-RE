package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfh extends zzbaq {
    final zzasz zza;
    final zzawa zzb;
    final zzasa zzc;
    final /* synthetic */ zzbfj zzd;
    private final long zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzbfh(zzbfj zzbfjVar, zzasz zzaszVar, zzawa zzawaVar, zzasa zzasaVar) {
        super(zzbfr.zzI(zzbfjVar.zza, zzasaVar), zzbfjVar.zza.zzt, zzasaVar.zzi());
        this.zzd = zzbfjVar;
        this.zza = zzaszVar;
        this.zzb = zzawaVar;
        this.zzc = zzasaVar;
        this.zze = System.nanoTime();
    }

    @Override // com.google.android.libraries.places.internal.zzbaq
    protected final void zzk() {
        zzbfg zzbfgVar = new zzbfg(this);
        zzaxl zzaxlVar = this.zzd.zza.zzf;
        zzaxlVar.zzc(zzbfgVar);
        zzaxlVar.zzb();
    }

    final void zzl() {
        zzasz zzaszVarZza = this.zza.zza();
        try {
            zzasf zzasfVarZzh = this.zzd.zzh(this.zzb, this.zzc.zze(zzaso.zza, Long.valueOf(System.nanoTime() - this.zze)));
            this.zza.zze(zzaszVarZza);
            Runnable runnableZzh = zzh(zzasfVarZzh);
            if (runnableZzh != null) {
                zzbfj zzbfjVar = this.zzd;
                zzbfr.zzI(zzbfjVar.zza, this.zzc).execute(new zzbff(this, runnableZzh));
            } else {
                zzbfj zzbfjVar2 = this.zzd;
                zzbfg zzbfgVar = new zzbfg(this);
                zzaxl zzaxlVar = zzbfjVar2.zza.zzf;
                zzaxlVar.zzc(zzbfgVar);
                zzaxlVar.zzb();
            }
        } catch (Throwable th) {
            this.zza.zze(zzaszVarZza);
            throw th;
        }
    }
}
