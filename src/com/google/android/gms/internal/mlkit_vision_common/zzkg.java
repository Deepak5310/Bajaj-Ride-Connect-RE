package com.google.android.gms.internal.mlkit_vision_common;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@17.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkg {
    private static zzkg zza;

    private zzkg() {
    }

    public static synchronized zzkg zza() {
        if (zza == null) {
            zza = new zzkg();
        }
        return zza;
    }

    public static final boolean zzb() {
        return zzkf.zza("mlkit-dev-profiling");
    }
}
