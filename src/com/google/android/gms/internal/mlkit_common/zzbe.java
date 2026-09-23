package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbe {
    private int zza;
    private final zzbh zzb = zzbh.DEFAULT;

    public final zzbe zza(int i) {
        this.zza = i;
        return this;
    }

    public final zzbi zzb() {
        return new zzbd(this.zza, this.zzb);
    }
}
