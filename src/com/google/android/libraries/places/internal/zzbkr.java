package com.google.android.libraries.places.internal;

import com.facebook.common.util.UriUtil;
import io.grpc.internal.GrpcUtil;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbkr {
    public static final zzbnb zza;
    public static final zzbnb zzb;
    public static final zzbnb zzc;
    public static final zzbnb zzd;
    public static final zzbnb zze;
    public static final zzbnb zzf;

    static {
        zzbpp zzbppVar = zzbnb.zzd;
        zzbpo zzbpoVar = zzbpp.zza;
        zza = new zzbnb(zzbppVar, zzbpo.zza(UriUtil.HTTPS_SCHEME));
        zzb = new zzbnb(zzbnb.zzd, zzbpo.zza(UriUtil.HTTP_SCHEME));
        zzc = new zzbnb(zzbnb.zzb, zzbpo.zza("POST"));
        zzd = new zzbnb(zzbnb.zzb, zzbpo.zza("GET"));
        zze = new zzbnb(zzbcu.zzh.zzd(), GrpcUtil.CONTENT_TYPE_GRPC);
        zzf = new zzbnb("te", GrpcUtil.TE_TRAILERS);
    }
}
