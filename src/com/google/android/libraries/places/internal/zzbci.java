package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
class zzbci extends zzawk {
    private final zzawk zza;

    zzbci(zzawk zzawkVar) {
        this.zza = zzawkVar;
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("delegate", this.zza);
        return zzknVarZzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzawk
    public final String zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.libraries.places.internal.zzawk
    public final void zzb() {
        this.zza.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzawk
    public void zzc() {
        this.zza.zzc();
    }

    @Override // com.google.android.libraries.places.internal.zzawk
    public void zzd(zzawg zzawgVar) {
        this.zza.zzd(zzawgVar);
    }
}
