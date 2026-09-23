package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzii {
    private zziu zza;
    private Long zzb;
    private zzid zzc;
    private Long zzd;
    private zzij zze;
    private Long zzf;

    public final zzii zzb(Long l) {
        this.zzf = l;
        return this;
    }

    public final zzii zzc(zzij zzijVar) {
        this.zze = zzijVar;
        return this;
    }

    public final zzii zzd(zzid zzidVar) {
        this.zzc = zzidVar;
        return this;
    }

    public final zzii zze(Long l) {
        this.zzd = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzii zzf(zziu zziuVar) {
        this.zza = zziuVar;
        return this;
    }

    public final zzii zzg(Long l) {
        this.zzb = Long.valueOf(l.longValue() & Long.MAX_VALUE);
        return this;
    }

    public final zzil zzi() {
        return new zzil(this, null);
    }
}
