package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzazc implements zzazk {
    final /* synthetic */ zzazh zza;
    private final zzase zzb;
    private zzaxd zzc;

    public zzazc(zzazh zzazhVar, zzase zzaseVar) {
        this.zza = zzazhVar;
        this.zzb = zzaseVar;
    }

    static /* bridge */ /* synthetic */ void zzc(zzazc zzazcVar, zzaxd zzaxdVar) {
        zzazcVar.zzc = zzaxdVar;
        zzazcVar.zza.zzm.zzh(zzaxdVar);
    }

    @Override // com.google.android.libraries.places.internal.zzazk
    public final void zzd(zzaxd zzaxdVar, zzazj zzazjVar, zzavu zzavuVar) {
        int i = zzbpb.zza;
        zzatd zzatdVarZzr = this.zza.zzr();
        if (zzaxdVar.zza() == zzawy.CANCELLED && zzatdVarZzr != null && zzatdVarZzr.zze()) {
            zzbda zzbdaVar = new zzbda();
            this.zza.zzm.zzg(zzbdaVar);
            zzaxdVar = zzaxd.zze.zzc("ClientCall was cancelled at or after deadline. ".concat(zzbdaVar.toString()));
            zzavuVar = new zzavu();
        }
        this.zza.zzf.execute(new zzaza(this, zzbpb.zza(), zzaxdVar, zzavuVar));
    }

    @Override // com.google.android.libraries.places.internal.zzazk
    public final void zze(zzavu zzavuVar) {
        int i = zzbpb.zza;
        this.zza.zzf.execute(new zzayy(this, zzbpb.zza(), zzavuVar));
    }

    @Override // com.google.android.libraries.places.internal.zzbjw
    public final void zzf(zzbjv zzbjvVar) {
        int i = zzbpb.zza;
        this.zza.zzf.execute(new zzayz(this, zzbpb.zza(), zzbjvVar));
    }

    @Override // com.google.android.libraries.places.internal.zzbjw
    public final void zzg() {
        zzavy zzavyVarZzb = this.zza.zzd.zzb();
        if (zzavyVarZzb == zzavy.UNARY || zzavyVarZzb == zzavy.SERVER_STREAMING) {
            return;
        }
        int i = zzbpb.zza;
        this.zza.zzf.execute(new zzazb(this, zzbpb.zza()));
    }
}
