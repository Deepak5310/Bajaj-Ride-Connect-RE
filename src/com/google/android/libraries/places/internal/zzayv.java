package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzayv {
    static final zzayu zza = new zzayt();
    private final zzbjy zzb;
    private final zzbea zzc = zzbeb.zza();
    private final zzbea zzd = zzbeb.zza();
    private final zzbea zze = zzbeb.zza();
    private volatile long zzf;

    zzayv(zzbjy zzbjyVar) {
        this.zzb = zzbjyVar;
    }

    public final void zza(boolean z) {
        if (z) {
            this.zzd.zza(1L);
        } else {
            this.zze.zza(1L);
        }
    }

    public final void zzb() {
        this.zzc.zza(1L);
        this.zzf = this.zzb.zza();
    }
}
