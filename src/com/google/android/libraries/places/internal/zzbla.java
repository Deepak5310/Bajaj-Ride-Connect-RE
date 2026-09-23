package com.google.android.libraries.places.internal;

import io.grpc.internal.GrpcUtil;
import java.security.GeneralSecurityException;
import java.util.EnumSet;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbla extends zzatj {
    static final zzbme zza;
    static final zzbjs zzb;
    private static final Logger zzc = Logger.getLogger(zzbla.class.getName());
    private static final zzbjq zzd;
    private static final EnumSet zze;
    private final zzbfu zzf;
    private SSLSocketFactory zzh;
    private final zzbkb zzg = zzbke.zza();
    private final zzbjs zzl = zzb;
    private final zzbjs zzm = zzbjs.zza(zzbcu.zzq);
    private final zzbme zzi = zza;
    private int zzk = 1;
    private final long zzj = zzbcu.zzl;

    static {
        zzbmc zzbmcVar = new zzbmc(zzbme.zza);
        zzbmcVar.zza(zzbmb.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, zzbmb.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, zzbmb.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, zzbmb.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, zzbmb.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, zzbmb.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256);
        zzbmcVar.zzd(zzbmv.TLS_1_2);
        zzbmcVar.zzc(true);
        zza = zzbmcVar.zzf();
        TimeUnit.DAYS.toNanos(1000L);
        zzbks zzbksVar = new zzbks();
        zzd = zzbksVar;
        zzb = zzbjs.zza(zzbksVar);
        zze = EnumSet.of(zzaxn.MTLS, zzaxn.CUSTOM_MANAGERS);
    }

    private zzbla(String str) {
        this.zzf = new zzbfu(str, null, null, new zzbkw(this, null), new zzbku(this, null));
    }

    public static zzbla zze(String str, int i) {
        return new zzbla(zzbcu.zzd("places.googleapis.com", GrpcUtil.DEFAULT_PORT_SSL));
    }

    @Override // com.google.android.libraries.places.internal.zzatj
    protected final zzavh zzb() {
        return this.zzf;
    }

    final zzbkz zzd() {
        long j = this.zzj;
        zzbme zzbmeVar = this.zzi;
        zzbkb zzbkbVar = this.zzg;
        return new zzbkz(this.zzl, this.zzm, null, zzg(), null, zzbmeVar, 4194304, false, Long.MAX_VALUE, j, 65535, false, Integer.MAX_VALUE, zzbkbVar, false, null);
    }

    public final zzbla zzf() {
        this.zzk = 1;
        return this;
    }

    final int zzc() {
        int i = this.zzk;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 == 0) {
            return GrpcUtil.DEFAULT_PORT_SSL;
        }
        throw new AssertionError("TLS not handled");
    }

    @Nullable
    final SSLSocketFactory zzg() {
        int i = this.zzk;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        if (i2 != 0) {
            throw new RuntimeException("Unknown negotiation type: TLS");
        }
        try {
            if (this.zzh == null) {
                this.zzh = SSLContext.getInstance("Default", zzbmt.zze().zzf()).getSocketFactory();
            }
            return this.zzh;
        } catch (GeneralSecurityException e) {
            throw new RuntimeException("TLS Provider failure", e);
        }
    }
}
