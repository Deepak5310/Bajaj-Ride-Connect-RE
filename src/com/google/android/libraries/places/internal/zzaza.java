package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaza extends zzazz {
    final /* synthetic */ zzbpa zza;
    final /* synthetic */ zzaxd zzb;
    final /* synthetic */ zzavu zzc;
    final /* synthetic */ zzazc zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzaza(zzazc zzazcVar, zzbpa zzbpaVar, zzaxd zzaxdVar, zzavu zzavuVar) {
        super(zzazcVar.zza.zzi);
        this.zzd = zzazcVar;
        this.zza = zzbpaVar;
        this.zzb = zzaxdVar;
        this.zzc = zzavuVar;
    }

    @Override // com.google.android.libraries.places.internal.zzazz
    public final void zza() {
        int i = zzbpb.zza;
        zzaxd zzaxdVar = this.zzb;
        zzavu zzavuVar = this.zzc;
        zzazc zzazcVar = this.zzd;
        if (zzazcVar.zzc != null) {
            zzaxdVar = zzazcVar.zzc;
            zzavuVar = new zzavu();
        }
        this.zzd.zza.zzn = true;
        try {
            this.zzd.zzb.zza(zzaxdVar, zzavuVar);
        } finally {
            this.zzd.zza.zzs();
            this.zzd.zza.zzh.zza(zzaxdVar.zzl());
        }
    }
}
