package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbex extends zzaus {
    zzayf zza;
    final /* synthetic */ zzbfr zzb;

    /* synthetic */ zzbex(zzbfr zzbfrVar, zzbew zzbewVar) {
        this.zzb = zzbfrVar;
    }

    @Override // com.google.android.libraries.places.internal.zzaus
    public final /* bridge */ /* synthetic */ zzauy zza(zzaup zzaupVar) {
        this.zzb.zzf.zzd();
        zzkt.zzo(!this.zzb.zzQ, "Channel is being terminated");
        return new zzbfo(this.zzb, zzaupVar);
    }

    @Override // com.google.android.libraries.places.internal.zzaus
    public final zzaxl zzb() {
        return this.zzb.zzf;
    }

    @Override // com.google.android.libraries.places.internal.zzaus
    public final void zzc() {
        this.zzb.zzf.zzd();
        zzbeu zzbeuVar = new zzbeu(this);
        zzaxl zzaxlVar = this.zzb.zzf;
        zzaxlVar.zzc(zzbeuVar);
        zzaxlVar.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzaus
    public final void zzd(zzasu zzasuVar, zzauz zzauzVar) {
        this.zzb.zzf.zzd();
        zzkt.zzc(zzasuVar, "newState");
        zzbev zzbevVar = new zzbev(this, zzauzVar, zzasuVar);
        zzaxl zzaxlVar = this.zzb.zzf;
        zzaxlVar.zzc(zzbevVar);
        zzaxlVar.zzb();
    }
}
