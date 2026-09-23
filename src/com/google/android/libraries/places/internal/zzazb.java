package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzazb extends zzazz {
    final /* synthetic */ zzbpa zza;
    final /* synthetic */ zzazc zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzazb(zzazc zzazcVar, zzbpa zzbpaVar) {
        super(zzazcVar.zza.zzi);
        this.zzb = zzazcVar;
        this.zza = zzbpaVar;
    }

    @Override // com.google.android.libraries.places.internal.zzazz
    public final void zza() {
        int i = zzbpb.zza;
        zzazc zzazcVar = this.zzb;
        if (zzazcVar.zzc != null) {
            return;
        }
        try {
            zzazcVar.zzb.zzd();
        } catch (Throwable th) {
            zzazc.zzc(this.zzb, zzaxd.zzb.zzf(th).zzg("Failed to call onReady."));
        }
    }
}
