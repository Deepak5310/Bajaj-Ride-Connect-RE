package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfa extends zzawg {
    final zzbex zza;
    final zzawk zzb;
    final /* synthetic */ zzbfr zzc;

    zzbfa(zzbfr zzbfrVar, zzbex zzbexVar, zzawk zzawkVar) {
        this.zzc = zzbfrVar;
        this.zza = zzbexVar;
        zzkt.zzc(zzawkVar, "resolver");
        this.zzb = zzawkVar;
    }

    @Override // com.google.android.libraries.places.internal.zzawg
    public final void zza(zzaxd zzaxdVar) {
        zzkt.zzf(!zzaxdVar.zzl(), "the error status must not be OK");
        zzbey zzbeyVar = new zzbey(this, zzaxdVar);
        zzaxl zzaxlVar = this.zzc.zzf;
        zzaxlVar.zzc(zzbeyVar);
        zzaxlVar.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzawg
    public final void zzb(zzawi zzawiVar) {
        throw null;
    }
}
