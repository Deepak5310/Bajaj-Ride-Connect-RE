package com.google.android.gms.internal.mlkit_vision_common;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@17.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzad {
    private int zza;
    private final zzag zzb = zzag.DEFAULT;

    public final zzad zza(int i) {
        this.zza = i;
        return this;
    }

    public final zzah zzb() {
        return new zzac(this.zza, this.zzb);
    }
}
