package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbok extends zzaus {
    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("delegate", zze());
        return zzknVarZzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzaus
    public final zzauy zza(zzaup zzaupVar) {
        return zze().zza(zzaupVar);
    }

    @Override // com.google.android.libraries.places.internal.zzaus
    public final zzaxl zzb() {
        return zze().zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzaus
    public final void zzc() {
        zze().zzc();
    }

    @Override // com.google.android.libraries.places.internal.zzaus
    public void zzd(zzasu zzasuVar, zzauz zzauzVar) {
        throw null;
    }

    protected abstract zzaus zze();
}
