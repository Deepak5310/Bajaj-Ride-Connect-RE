package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbme {
    public static final zzbme zza;
    public static final zzbme zzb;
    public static final zzbme zzc;
    private static final zzbmb[] zzf;
    final boolean zzd;
    final boolean zze;
    private final String[] zzg;
    private final String[] zzh;

    static {
        zzbmb[] zzbmbVarArr = {zzbmb.TLS_AES_128_GCM_SHA256, zzbmb.TLS_AES_256_GCM_SHA384, zzbmb.TLS_CHACHA20_POLY1305_SHA256, zzbmb.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, zzbmb.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, zzbmb.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, zzbmb.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, zzbmb.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, zzbmb.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, zzbmb.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, zzbmb.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, zzbmb.TLS_RSA_WITH_AES_128_GCM_SHA256, zzbmb.TLS_RSA_WITH_AES_256_GCM_SHA384, zzbmb.TLS_RSA_WITH_AES_128_CBC_SHA, zzbmb.TLS_RSA_WITH_AES_256_CBC_SHA, zzbmb.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        zzf = zzbmbVarArr;
        zzbmc zzbmcVar = new zzbmc(true);
        zzbmcVar.zza(zzbmbVarArr);
        zzbmcVar.zzd(zzbmv.TLS_1_3, zzbmv.TLS_1_2);
        zzbmcVar.zzc(true);
        zzbme zzbmeVar = new zzbme(zzbmcVar);
        zza = zzbmeVar;
        zzbmc zzbmcVar2 = new zzbmc(zzbmeVar);
        zzbmcVar2.zzd(zzbmv.TLS_1_3, zzbmv.TLS_1_2, zzbmv.TLS_1_1, zzbmv.TLS_1_0);
        zzbmcVar2.zzc(true);
        zzb = new zzbme(zzbmcVar2);
        zzc = new zzbme(new zzbmc(false));
    }

    private zzbme(zzbmc zzbmcVar) {
        this.zzd = zzbmcVar.zza;
        this.zzg = zzbmcVar.zzb;
        this.zzh = zzbmcVar.zzc;
        this.zze = zzbmcVar.zzd;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbme)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzbme zzbmeVar = (zzbme) obj;
        boolean z = this.zzd;
        if (z != zzbmeVar.zzd) {
            return false;
        }
        return !z || (Arrays.equals(this.zzg, zzbmeVar.zzg) && Arrays.equals(this.zzh, zzbmeVar.zzh) && this.zze == zzbmeVar.zze);
    }

    public final int hashCode() {
        if (!this.zzd) {
            return 17;
        }
        return ((((Arrays.hashCode(this.zzg) + 527) * 31) + Arrays.hashCode(this.zzh)) * 31) + (!this.zze ? 1 : 0);
    }

    public final void zza(SSLSocket sSLSocket, boolean z) throws CloneNotSupportedException {
        String[] strArr;
        if (this.zzg != null) {
            strArr = (String[]) zzbmw.zzb(String.class, this.zzg, sSLSocket.getEnabledCipherSuites());
        } else {
            strArr = null;
        }
        String[] strArr2 = (String[]) zzbmw.zzb(String.class, this.zzh, sSLSocket.getEnabledProtocols());
        zzbmc zzbmcVar = new zzbmc(this);
        zzbmcVar.zzb(strArr);
        zzbmcVar.zze(strArr2);
        zzbme zzbmeVar = new zzbme(zzbmcVar);
        sSLSocket.setEnabledProtocols(zzbmeVar.zzh);
        String[] strArr3 = zzbmeVar.zzg;
        if (strArr3 != null) {
            sSLSocket.setEnabledCipherSuites(strArr3);
        }
    }

    public final boolean zzb() {
        return this.zze;
    }

    public final String toString() {
        List listZza;
        zzbmv zzbmvVar;
        if (!this.zzd) {
            return "ConnectionSpec()";
        }
        String[] strArr = this.zzg;
        int i = 0;
        if (strArr == null) {
            listZza = null;
        } else {
            zzbmb[] zzbmbVarArr = new zzbmb[strArr.length];
            int i2 = 0;
            while (true) {
                String[] strArr2 = this.zzg;
                if (i2 >= strArr2.length) {
                    break;
                }
                String str = strArr2[i2];
                zzbmb zzbmbVar = zzbmb.TLS_RSA_WITH_NULL_MD5;
                zzbmbVarArr[i2] = str.startsWith("SSL_") ? zzbmb.zza("TLS_".concat(String.valueOf(str.substring(4)))) : zzbmb.zza(str);
                i2++;
            }
            listZza = zzbmw.zza(zzbmbVarArr);
        }
        String string = listZza == null ? "[use default]" : listZza.toString();
        zzbmv[] zzbmvVarArr = new zzbmv[this.zzh.length];
        while (true) {
            String[] strArr3 = this.zzh;
            if (i >= strArr3.length) {
                return "ConnectionSpec(cipherSuites=" + string + ", tlsVersions=" + String.valueOf(zzbmw.zza(zzbmvVarArr)) + ", supportsTlsExtensions=" + this.zze + ")";
            }
            String str2 = strArr3[i];
            zzbmv zzbmvVar2 = zzbmv.TLS_1_3;
            if ("TLSv1.3".equals(str2)) {
                zzbmvVar = zzbmv.TLS_1_3;
            } else if ("TLSv1.2".equals(str2)) {
                zzbmvVar = zzbmv.TLS_1_2;
            } else if ("TLSv1.1".equals(str2)) {
                zzbmvVar = zzbmv.TLS_1_1;
            } else if ("TLSv1".equals(str2)) {
                zzbmvVar = zzbmv.TLS_1_0;
            } else {
                if (!"SSLv3".equals(str2)) {
                    throw new IllegalArgumentException("Unexpected TLS version: ".concat(String.valueOf(str2)));
                }
                zzbmvVar = zzbmv.SSL_3_0;
            }
            zzbmvVarArr[i] = zzbmvVar;
            i++;
        }
    }
}
