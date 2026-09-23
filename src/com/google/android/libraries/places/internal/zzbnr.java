package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbnr {
    private zzbnq zza;
    private final zzbmg zzb = new zzbmg();

    public final zzbnr zzc(String str, String str2) {
        this.zzb.zza(str, str2);
        return this;
    }

    public final zzbnr zzd(zzbnq zzbnqVar) {
        this.zza = zzbnqVar;
        return this;
    }

    public final zzbnt zze() {
        if (this.zza != null) {
            return new zzbnt(this, null);
        }
        throw new IllegalStateException("url == null");
    }
}
