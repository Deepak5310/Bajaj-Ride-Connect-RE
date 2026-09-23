package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzboj extends zzavb {
    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("delegate", zzg());
        return zzknVarZzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzavb
    public final void zza(zzaxd zzaxdVar) {
        zzg().zza(zzaxdVar);
    }

    @Override // com.google.android.libraries.places.internal.zzavb
    public final void zzb(zzaux zzauxVar) {
        zzg().zzb(zzauxVar);
    }

    @Override // com.google.android.libraries.places.internal.zzavb
    public final void zzc() {
        zzg().zzc();
    }

    @Override // com.google.android.libraries.places.internal.zzavb
    public void zzd() {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzavb
    public final boolean zzf() {
        zzg().zzf();
        return false;
    }

    protected abstract zzavb zzg();
}
