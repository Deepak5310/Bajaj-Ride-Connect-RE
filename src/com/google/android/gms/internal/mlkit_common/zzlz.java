package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlz {
    private static zzlz zza;

    private zzlz() {
    }

    public static synchronized zzlz zza() {
        if (zza == null) {
            zza = new zzlz();
        }
        return zza;
    }

    public static void zzb() {
        zzly.zza();
    }
}
