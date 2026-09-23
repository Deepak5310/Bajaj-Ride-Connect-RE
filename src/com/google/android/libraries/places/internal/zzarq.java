package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzarq implements zzbpd {
    private static final Object zza = new Object();
    private volatile zzbpd zzb;
    private volatile Object zzc = zza;

    private zzarq(zzbpd zzbpdVar) {
        this.zzb = zzbpdVar;
    }

    public static zzbpd zza(zzbpd zzbpdVar) {
        return new zzarq(zzbpdVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbpd
    public final Object zzb() {
        Object obj = this.zzc;
        if (obj != zza) {
            return obj;
        }
        if (this.zzb == null) {
            return this.zzc;
        }
        zzdk zzdkVar = new zzdk();
        this.zzc = zzdkVar;
        this.zzb = null;
        return zzdkVar;
    }
}
