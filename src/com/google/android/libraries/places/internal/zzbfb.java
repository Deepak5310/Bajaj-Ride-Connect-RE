package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfb extends zzasb {
    final /* synthetic */ zzbfj zza;

    zzbfb(zzbfj zzbfjVar) {
        this.zza = zzbfjVar;
    }

    @Override // com.google.android.libraries.places.internal.zzasb
    public final zzasf zza(zzawa zzawaVar, zzasa zzasaVar) {
        zzbfr zzbfrVar = this.zza.zza;
        zzazh zzazhVar = new zzazh(zzawaVar, zzbfr.zzI(zzbfrVar, zzasaVar), zzasaVar, zzbfrVar.zzai, zzbfrVar.zzR ? null : this.zza.zza.zzr.zzb(), this.zza.zza.zzU, null);
        zzazhVar.zzm(this.zza.zza.zzy);
        zzazhVar.zzl(this.zza.zza.zzz);
        return zzazhVar;
    }

    @Override // com.google.android.libraries.places.internal.zzasb
    public final String zzb() {
        return this.zza.zzc;
    }
}
