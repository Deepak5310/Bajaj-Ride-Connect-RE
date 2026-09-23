package com.google.android.libraries.places.internal;

import io.grpc.internal.GrpcUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzawd {
    private final int zza;
    private final zzawt zzb;
    private final zzaxl zzc;
    private final zzawj zzd;

    @Nullable
    private final ScheduledExecutorService zze;

    @Nullable
    private final zzasd zzf;

    @Nullable
    private final Executor zzg;

    /* synthetic */ zzawd(Integer num, zzawt zzawtVar, zzaxl zzaxlVar, zzawj zzawjVar, ScheduledExecutorService scheduledExecutorService, zzasd zzasdVar, Executor executor, String str, zzawc zzawcVar) {
        zzkt.zzc(num, "defaultPort not set");
        num.intValue();
        this.zza = GrpcUtil.DEFAULT_PORT_SSL;
        zzkt.zzc(zzawtVar, "proxyDetector not set");
        this.zzb = zzawtVar;
        zzkt.zzc(zzaxlVar, "syncContext not set");
        this.zzc = zzaxlVar;
        zzkt.zzc(zzawjVar, "serviceConfigParser not set");
        this.zzd = zzawjVar;
        this.zze = scheduledExecutorService;
        this.zzf = zzasdVar;
        this.zzg = executor;
    }

    public static zzawb zzb() {
        return new zzawb();
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzb("defaultPort", this.zza);
        zzknVarZzb.zzd("proxyDetector", this.zzb);
        zzknVarZzb.zzd("syncContext", this.zzc);
        zzknVarZzb.zzd("serviceConfigParser", this.zzd);
        zzknVarZzb.zzd("scheduledExecutorService", this.zze);
        zzknVarZzb.zzd("channelLogger", this.zzf);
        zzknVarZzb.zzd("executor", this.zzg);
        zzknVarZzb.zzd("overrideAuthority", null);
        return zzknVarZzb.toString();
    }

    public final int zza() {
        return this.zza;
    }

    public final zzawj zzc() {
        return this.zzd;
    }

    public final zzawt zzd() {
        return this.zzb;
    }

    public final zzaxl zze() {
        return this.zzc;
    }

    @Nullable
    public final Executor zzf() {
        return this.zzg;
    }

    public final ScheduledExecutorService zzg() {
        ScheduledExecutorService scheduledExecutorService = this.zze;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService;
        }
        throw new IllegalStateException("ScheduledExecutorService not set in Builder");
    }
}
