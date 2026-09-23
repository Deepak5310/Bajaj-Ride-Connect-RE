package com.google.android.libraries.places.internal;

import okhttp3.internal.http2.Header;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbnb {
    public static final zzbpp zza;
    public static final zzbpp zzb;
    public static final zzbpp zzc;
    public static final zzbpp zzd;
    public static final zzbpp zze;
    public static final zzbpp zzf;
    public static final zzbpp zzg;
    public final zzbpp zzh;
    public final zzbpp zzi;
    final int zzj;

    static {
        zzbpo zzbpoVar = zzbpp.zza;
        zza = zzbpo.zza(Header.RESPONSE_STATUS_UTF8);
        zzb = zzbpo.zza(Header.TARGET_METHOD_UTF8);
        zzc = zzbpo.zza(Header.TARGET_PATH_UTF8);
        zzd = zzbpo.zza(Header.TARGET_SCHEME_UTF8);
        zze = zzbpo.zza(Header.TARGET_AUTHORITY_UTF8);
        zzf = zzbpo.zza(":host");
        zzg = zzbpo.zza(":version");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public zzbnb(String str, String str2) {
        this(zzbpo.zza(str), zzbpo.zza(str2));
        zzbpo zzbpoVar = zzbpp.zza;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbnb) {
            zzbnb zzbnbVar = (zzbnb) obj;
            if (this.zzh.equals(zzbnbVar.zzh) && this.zzi.equals(zzbnbVar.zzi)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zzh.hashCode() + 527) * 31) + this.zzi.hashCode();
    }

    public final String toString() {
        return String.format("%s: %s", this.zzh.zzf(), this.zzi.zzf());
    }

    public zzbnb(zzbpp zzbppVar, zzbpp zzbppVar2) {
        this.zzh = zzbppVar;
        this.zzi = zzbppVar2;
        this.zzj = zzbppVar.zzc() + 32 + zzbppVar2.zzc();
    }
}
