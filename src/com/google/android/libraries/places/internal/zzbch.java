package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
class zzbch extends zzavg {
    private final zzavg zza;

    zzbch(zzavg zzavgVar) {
        this.zza = zzavgVar;
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("delegate", this.zza);
        return zzknVarZzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzasb
    public final zzasf zza(zzawa zzawaVar, zzasa zzasaVar) {
        return this.zza.zza(zzawaVar, zzasaVar);
    }

    @Override // com.google.android.libraries.places.internal.zzasb
    public final String zzb() {
        return this.zza.zzb();
    }
}
