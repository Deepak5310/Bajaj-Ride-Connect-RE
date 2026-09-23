package com.google.android.libraries.places.internal;

import com.facebook.common.util.UriUtil;
import io.grpc.internal.GrpcUtil;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbnq {
    private final String zza;
    private final String zzb;
    private final int zzc;
    private final String zzd;

    /* synthetic */ zzbnq(zzbno zzbnoVar, zzbnp zzbnpVar) {
        this.zza = zzbnoVar.zza;
        this.zzb = zzbnoVar.zzb;
        this.zzc = zzbnoVar.zza();
        this.zzd = zzbnoVar.toString();
    }

    static int zza(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return c - 'W';
        }
        if (c < 'A' || c > 'F') {
            return -1;
        }
        return c - '7';
    }

    public static int zzb(String str) {
        if (str.equals(UriUtil.HTTP_SCHEME)) {
            return 80;
        }
        if (str.equals(UriUtil.HTTPS_SCHEME)) {
            return GrpcUtil.DEFAULT_PORT_SSL;
        }
        return -1;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof zzbnq) && ((zzbnq) obj).zzd.equals(this.zzd);
    }

    public final int hashCode() {
        return this.zzd.hashCode();
    }

    public final String toString() {
        return this.zzd;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzb;
    }
}
