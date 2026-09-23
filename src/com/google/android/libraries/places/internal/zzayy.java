package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzayy extends zzazz {
    final /* synthetic */ zzbpa zza;
    final /* synthetic */ zzavu zzb;
    final /* synthetic */ zzazc zzc;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzayy(zzazc zzazcVar, zzbpa zzbpaVar, zzavu zzavuVar) {
        super(zzazcVar.zza.zzi);
        this.zzc = zzazcVar;
        this.zza = zzbpaVar;
        this.zzb = zzavuVar;
    }

    @Override // com.google.android.libraries.places.internal.zzazz
    public final void zza() {
        int i = zzbpb.zza;
        zzazc zzazcVar = this.zzc;
        if (zzazcVar.zzc != null) {
            return;
        }
        try {
            zzazcVar.zzb.zzb(this.zzb);
        } catch (Throwable th) {
            zzazc.zzc(this.zzc, zzaxd.zzb.zzf(th).zzg("Failed to read headers"));
        }
    }
}
