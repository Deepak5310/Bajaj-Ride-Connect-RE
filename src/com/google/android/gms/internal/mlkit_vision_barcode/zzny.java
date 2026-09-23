package com.google.android.gms.internal.mlkit_vision_barcode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-mlkit-barcode-scanning@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzny {
    private static zzny zza;

    private zzny() {
    }

    public static synchronized zzny zza() {
        if (zza == null) {
            zza = new zzny();
        }
        return zza;
    }
}
