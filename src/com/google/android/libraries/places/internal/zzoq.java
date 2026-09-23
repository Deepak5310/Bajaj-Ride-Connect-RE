package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzoq implements zzor {
    private final String zza;
    private final zznu zzb;

    public zzoq() {
        zznv zznvVar = zznv.NO_OP;
        this.zza = "";
        this.zzb = zznvVar;
    }

    @Override // com.google.android.libraries.places.internal.zzor
    public final zznw zza(String str) {
        return new zzoz(this.zza, str, true, this.zzb, true, true);
    }
}
