package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdm {
    static zzdm zza;
    private final zzdn zzb;

    private zzdm(zzdn zzdnVar) {
        this.zzb = zzdnVar;
    }

    public static zzdm zza() {
        zzdm zzdmVar = new zzdm(new zzdl());
        zza = zzdmVar;
        return zzdmVar;
    }
}
