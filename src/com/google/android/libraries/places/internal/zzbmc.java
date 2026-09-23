package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbmc {
    private final boolean zza;
    private String[] zzb;
    private String[] zzc;
    private boolean zzd;

    public zzbmc(zzbme zzbmeVar) {
        this.zza = zzbmeVar.zzd;
        this.zzb = zzbmeVar.zzg;
        this.zzc = zzbmeVar.zzh;
        this.zzd = zzbmeVar.zze;
    }

    public zzbmc(boolean z) {
        this.zza = z;
    }

    public final zzbmc zza(zzbmb... zzbmbVarArr) {
        if (!this.zza) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        String[] strArr = new String[zzbmbVarArr.length];
        for (int i = 0; i < zzbmbVarArr.length; i++) {
            strArr[i] = zzbmbVarArr[i].zzbb;
        }
        this.zzb = strArr;
        return this;
    }

    public final zzbmc zzb(String... strArr) throws CloneNotSupportedException {
        if (!this.zza) {
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        if (strArr == null) {
            this.zzb = null;
        } else {
            this.zzb = (String[]) strArr.clone();
        }
        return this;
    }

    public final zzbmc zzc(boolean z) {
        if (!this.zza) {
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }
        this.zzd = true;
        return this;
    }

    public final zzbmc zzd(zzbmv... zzbmvVarArr) {
        if (!this.zza) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        String[] strArr = new String[zzbmvVarArr.length];
        for (int i = 0; i < zzbmvVarArr.length; i++) {
            strArr[i] = zzbmvVarArr[i].zzf;
        }
        this.zzc = strArr;
        return this;
    }

    public final zzbmc zze(String... strArr) throws CloneNotSupportedException {
        if (!this.zza) {
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        if (strArr == null) {
            this.zzc = null;
        } else {
            this.zzc = (String[]) strArr.clone();
        }
        return this;
    }

    public final zzbme zzf() {
        return new zzbme(this);
    }
}
