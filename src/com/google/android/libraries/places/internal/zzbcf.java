package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzbcf implements zzazk {
    zzbcf() {
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("delegate", zza());
        return zzknVarZzb.toString();
    }

    protected abstract zzazk zza();

    @Override // com.google.android.libraries.places.internal.zzazk
    public void zzd(zzaxd zzaxdVar, zzazj zzazjVar, zzavu zzavuVar) {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzazk
    public final void zze(zzavu zzavuVar) {
        zza().zze(zzavuVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbjw
    public final void zzf(zzbjv zzbjvVar) {
        zza().zzf(zzbjvVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbjw
    public final void zzg() {
        zza().zzg();
    }
}
