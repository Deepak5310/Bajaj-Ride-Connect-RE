package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbke {
    private static final zzbkb zza = new zzbkb(zzbjy.zza);
    private final zzbjy zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private zzbkc zzf;
    private long zzg;
    private final zzbea zzh = zzbeb.zza();
    private volatile long zzi;

    public zzbke() {
        zzbjy zzbjyVar = zzbjy.zza;
        throw null;
    }

    public static zzbkb zza() {
        return zza;
    }

    public final void zzb() {
        this.zzc++;
        this.zzb.zza();
    }

    public final void zzc() {
        this.zzh.zza(1L);
        this.zzi = this.zzb.zza();
    }

    public final void zzd(int i) {
        if (i == 0) {
            return;
        }
        this.zzg += (long) i;
        this.zzb.zza();
    }

    public final void zze(boolean z) {
        if (z) {
            this.zzd++;
        } else {
            this.zze++;
        }
    }

    public final void zzf(zzbkc zzbkcVar) {
        this.zzf = zzbkcVar;
    }
}
