package com.google.android.gms.internal.mlkit_vision_common;

/* JADX INFO: compiled from: com.google.mlkit:vision-common@@17.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzkc {
    private static zzkb zza;

    public static synchronized zzjt zza(zzjn zzjnVar) {
        if (zza == null) {
            zza = new zzkb(null);
        }
        return (zzjt) zza.get(zzjnVar);
    }

    public static synchronized zzjt zzb(String str) {
        return zza(zzjn.zzd("vision-common").zzd());
    }
}
