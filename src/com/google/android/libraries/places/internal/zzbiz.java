package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbiz extends zzawg {
    final /* synthetic */ zzbja zza;
    private final zzawg zzb;

    zzbiz(zzbja zzbjaVar, zzawg zzawgVar) {
        this.zza = zzbjaVar;
        this.zzb = zzawgVar;
    }

    @Override // com.google.android.libraries.places.internal.zzawg
    public final void zza(zzaxd zzaxdVar) {
        this.zzb.zza(zzaxdVar);
        zzaxl zzaxlVar = this.zza.zzd;
        zzaxlVar.zzc(new Runnable() { // from class: com.google.android.libraries.places.internal.zzbiy
            @Override // java.lang.Runnable
            public final void run() {
                zzbja zzbjaVar = this.zza.zza;
                zzbjaVar.zzc.zzc(new zzbiw(zzbjaVar));
            }
        });
        zzaxlVar.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzawg
    public final void zzb(zzawi zzawiVar) {
        if (zzawiVar.zza().zzc(zzbja.zza) != null) {
            throw new IllegalStateException("RetryingNameResolver can only be used once to wrap a NameResolver");
        }
        zzawg zzawgVar = this.zzb;
        zzawh zzawhVarZzd = zzawiVar.zzd();
        zzars zzarsVarZzb = zzawiVar.zza().zzb();
        zzarsVarZzb.zzb(zzbja.zza, new zzbix(this.zza));
        zzawhVarZzd.zzb(zzarsVarZzb.zzc());
        zzbfa zzbfaVar = (zzbfa) zzawgVar;
        zzbez zzbezVar = new zzbez(zzbfaVar, zzawhVarZzd.zzd());
        zzaxl zzaxlVar = zzbfaVar.zzc.zzf;
        zzaxlVar.zzc(zzbezVar);
        zzaxlVar.zzb();
    }
}
