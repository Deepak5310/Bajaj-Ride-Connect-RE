package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzboq extends zzbok {
    final /* synthetic */ zzbor zza;

    /* synthetic */ zzboq(zzbor zzborVar, zzbop zzbopVar) {
        this.zza = zzborVar;
    }

    @Override // com.google.android.libraries.places.internal.zzbok, com.google.android.libraries.places.internal.zzaus
    public final void zzd(zzasu zzasuVar, zzauz zzauzVar) {
        zzbor zzborVar = this.zza;
        if (zzborVar.zza.zzg.containsKey(zzborVar.zzb)) {
            this.zza.zzf = zzasuVar;
            this.zza.zzg = zzauzVar;
            zzbor zzborVar2 = this.zza;
            if (zzborVar2.zzh || zzborVar2.zza.zzc) {
                return;
            }
            if (zzasuVar == zzasu.IDLE) {
                this.zza.zzd.zzg().zzc();
            }
            this.zza.zza.zzl();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbok
    protected final zzaus zze() {
        return this.zza.zza.zzh;
    }
}
