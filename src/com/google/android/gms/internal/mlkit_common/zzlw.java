package com.google.android.gms.internal.mlkit_common;

/* JADX INFO: compiled from: com.google.mlkit:common@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzlw {
    private static zzlv zza;

    public static synchronized zzll zza(zzle zzleVar) {
        if (zza == null) {
            zza = new zzlv(null);
        }
        return (zzll) zza.get(zzleVar);
    }

    public static synchronized zzll zzb(String str) {
        return zza(zzle.zzd("common").zzd());
    }
}
