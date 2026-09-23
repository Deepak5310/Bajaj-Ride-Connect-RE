package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbaw extends zzbbp {
    final /* synthetic */ zzbax zza;
    private final zzauu zzb;
    private final zzasz zzc = zzasz.zzb();
    private final zzaso[] zzd;

    /* synthetic */ zzbaw(zzbax zzbaxVar, zzauu zzauuVar, zzaso[] zzasoVarArr, zzbav zzbavVar) {
        this.zza = zzbaxVar;
        this.zzb = zzauuVar;
        this.zzd = zzasoVarArr;
    }

    static /* bridge */ /* synthetic */ Runnable zzb(zzbaw zzbawVar, zzazl zzazlVar) {
        zzasz zzaszVarZza = zzbawVar.zzc.zza();
        try {
            zzauu zzauuVar = zzbawVar.zzb;
            zzazi zzaziVarZza = zzazlVar.zza(zzauuVar.zzc(), zzauuVar.zzb(), zzauuVar.zza(), zzbawVar.zzd);
            return zzbawVar.zze(zzaziVarZza);
        } finally {
            zzbawVar.zzc.zze(zzaszVarZza);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbbp
    protected final void zzc(zzaxd zzaxdVar) {
        int i = 0;
        while (true) {
            zzaso[] zzasoVarArr = this.zzd;
            if (i >= zzasoVarArr.length) {
                return;
            }
            zzaso zzasoVar = zzasoVarArr[i];
            i++;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbbp, com.google.android.libraries.places.internal.zzazi
    public final void zzg(zzbda zzbdaVar) {
        if (this.zzb.zza().zzo()) {
            zzbdaVar.zza("wait_for_ready");
        }
        super.zzg(zzbdaVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbbp, com.google.android.libraries.places.internal.zzazi
    public final void zzh(zzaxd zzaxdVar) {
        super.zzh(zzaxdVar);
        synchronized (this.zza.zzb) {
            zzbax zzbaxVar = this.zza;
            if (zzbaxVar.zzg != null) {
                boolean zRemove = zzbaxVar.zzi.remove(this);
                if (!this.zza.zzn() && zRemove) {
                    zzbax zzbaxVar2 = this.zza;
                    zzbaxVar2.zzd.zzc(zzbaxVar2.zzf);
                    zzbax zzbaxVar3 = this.zza;
                    if (zzbaxVar3.zzj != null) {
                        zzbaxVar3.zzd.zzc(zzbaxVar3.zzg);
                        this.zza.zzg = null;
                    }
                }
            }
        }
        this.zza.zzd.zzb();
    }
}
