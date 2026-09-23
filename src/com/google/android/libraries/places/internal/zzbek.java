package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbek implements zzazd {
    volatile zzbis zza;
    final /* synthetic */ zzbfr zzb;

    /* synthetic */ zzbek(zzbfr zzbfrVar, zzbej zzbejVar) {
        this.zzb = zzbfrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzazl zzc(zzauu zzauuVar) {
        zzbfr zzbfrVar = this.zzb;
        zzauz zzauzVar = zzbfrVar.zzH;
        if (!zzbfrVar.zzP.get()) {
            if (zzauzVar == null) {
                zzbfr zzbfrVar2 = this.zzb;
                zzbeh zzbehVar = new zzbeh(this);
                zzaxl zzaxlVar = zzbfrVar2.zzf;
                zzaxlVar.zzc(zzbehVar);
                zzaxlVar.zzb();
                return this.zzb.zzN;
            }
            zzazl zzazlVarZzc = zzbcu.zzc(zzauzVar.zza(zzauuVar), zzauuVar.zza().zzo());
            if (zzazlVarZzc != null) {
                return zzazlVarZzc;
            }
        }
        return this.zzb.zzN;
    }

    @Override // com.google.android.libraries.places.internal.zzazd
    public final zzazi zza(zzawa zzawaVar, zzasa zzasaVar, zzavu zzavuVar, zzasz zzaszVar) {
        if (this.zzb.zzaf) {
            zzbfx zzbfxVar = (zzbfx) zzasaVar.zzl(zzbfx.zza);
            return new zzbei(this, zzawaVar, zzavuVar, zzasaVar, zzbfxVar == null ? null : zzbfxVar.zzf, zzbfxVar != null ? zzbfxVar.zzg : null, zzaszVar);
        }
        zzazl zzazlVarZzc = zzc(new zzbgx(zzawaVar, zzavuVar, zzasaVar));
        zzasz zzaszVarZza = zzaszVar.zza();
        try {
            return zzazlVarZzc.zza(zzawaVar, zzavuVar, zzasaVar, zzbcu.zzj(zzasaVar, zzavuVar, 0, false));
        } finally {
            zzaszVar.zze(zzaszVarZza);
        }
    }
}
