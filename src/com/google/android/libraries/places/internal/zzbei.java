package com.google.android.libraries.places.internal;

import java.util.HashSet;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbei extends zzbit {
    final /* synthetic */ zzawa zza;
    final /* synthetic */ zzavu zzb;
    final /* synthetic */ zzasa zzc;
    final /* synthetic */ zzbiu zzd;
    final /* synthetic */ zzbcv zze;
    final /* synthetic */ zzasz zzf;
    final /* synthetic */ zzbek zzg;

    /* JADX WARN: Illegal instructions before constructor call */
    zzbei(zzbek zzbekVar, zzawa zzawaVar, zzavu zzavuVar, zzasa zzasaVar, zzbiu zzbiuVar, zzbcv zzbcvVar, zzasz zzaszVar) {
        this.zzg = zzbekVar;
        this.zza = zzawaVar;
        this.zzb = zzavuVar;
        this.zzc = zzasaVar;
        this.zzd = zzbiuVar;
        this.zze = zzbcvVar;
        this.zzf = zzaszVar;
        zzbfr zzbfrVar = zzbekVar.zzb;
        super(zzawaVar, zzavuVar, zzbfrVar.zzac, zzbfrVar.zzad, zzbfrVar.zzae, zzbfr.zzI(zzbfrVar, zzasaVar), zzbekVar.zzb.zzr.zzb(), zzbiuVar, zzbcvVar, zzbekVar.zza);
    }

    @Override // com.google.android.libraries.places.internal.zzbit
    final zzaxd zza() {
        zzbfq zzbfqVar = this.zzg.zzb.zzO;
        synchronized (zzbfqVar.zza) {
            zzaxd zzaxdVar = zzbfqVar.zzc;
            if (zzaxdVar != null) {
                return zzaxdVar;
            }
            zzbfqVar.zzb.add(this);
            return null;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbit
    final zzazi zzb(zzavu zzavuVar, zzasl zzaslVar, int i, boolean z) {
        zzasa zzasaVarZzf = this.zzc.zzf(zzaslVar);
        zzaso[] zzasoVarArrZzj = zzbcu.zzj(zzasaVarZzf, zzavuVar, i, z);
        zzazl zzazlVarZzc = this.zzg.zzc(new zzbgx(this.zza, zzavuVar, zzasaVarZzf));
        zzasz zzaszVarZza = this.zzf.zza();
        try {
            return zzazlVarZzc.zza(this.zza, zzavuVar, zzasaVarZzf, zzasoVarArrZzj);
        } finally {
            this.zzf.zze(zzaszVarZza);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbit
    final void zzc() {
        zzaxd zzaxdVar;
        zzbfq zzbfqVar = this.zzg.zzb.zzO;
        synchronized (zzbfqVar.zza) {
            zzbfqVar.zzb.remove(this);
            if (zzbfqVar.zzb.isEmpty()) {
                zzaxdVar = zzbfqVar.zzc;
                zzbfqVar.zzb = new HashSet();
            } else {
                zzaxdVar = null;
            }
        }
        if (zzaxdVar != null) {
            zzbfqVar.zzd.zzN.zzd(zzaxdVar);
        }
    }
}
