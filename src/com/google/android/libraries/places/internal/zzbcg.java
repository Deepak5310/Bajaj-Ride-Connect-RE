package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzbcg implements zzazw {
    zzbcg() {
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("delegate", zzb());
        return zzknVarZzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzazl
    public zzazi zza(zzawa zzawaVar, zzavu zzavuVar, zzasa zzasaVar, zzaso[] zzasoVarArr) {
        throw null;
    }

    protected abstract zzazw zzb();

    @Override // com.google.android.libraries.places.internal.zzauk
    public final zzauf zzc() {
        return zzb().zzc();
    }

    @Override // com.google.android.libraries.places.internal.zzbgc
    public void zzd(zzaxd zzaxdVar) {
        zzb().zzd(zzaxdVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbgc
    public final Runnable zzj(zzbgb zzbgbVar) {
        zzb().zzj(zzbgbVar);
        return null;
    }
}
