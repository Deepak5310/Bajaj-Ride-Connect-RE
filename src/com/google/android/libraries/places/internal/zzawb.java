package com.google.android.libraries.places.internal;

import io.grpc.internal.GrpcUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzawb {
    private Integer zza;
    private zzawt zzb;
    private zzaxl zzc;
    private zzawj zzd;
    private ScheduledExecutorService zze;
    private zzasd zzf;
    private Executor zzg;

    zzawb() {
    }

    public final zzawb zza(zzasd zzasdVar) {
        zzasdVar.getClass();
        this.zzf = zzasdVar;
        return this;
    }

    public final zzawb zzb(int i) {
        this.zza = Integer.valueOf(GrpcUtil.DEFAULT_PORT_SSL);
        return this;
    }

    public final zzawb zzc(Executor executor) {
        this.zzg = executor;
        return this;
    }

    public final zzawb zzd(zzawt zzawtVar) {
        zzawtVar.getClass();
        this.zzb = zzawtVar;
        return this;
    }

    public final zzawb zze(ScheduledExecutorService scheduledExecutorService) {
        scheduledExecutorService.getClass();
        this.zze = scheduledExecutorService;
        return this;
    }

    public final zzawb zzf(zzawj zzawjVar) {
        this.zzd = zzawjVar;
        return this;
    }

    public final zzawb zzg(zzaxl zzaxlVar) {
        zzaxlVar.getClass();
        this.zzc = zzaxlVar;
        return this;
    }

    public final zzawd zzh() {
        return new zzawd(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, null, null);
    }
}
