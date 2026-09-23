package com.google.android.libraries.places.internal;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbey implements Runnable {
    final /* synthetic */ zzaxd zza;
    final /* synthetic */ zzbfa zzb;

    zzbey(zzbfa zzbfaVar, zzaxd zzaxdVar) {
        this.zzb = zzbfaVar;
        this.zza = zzaxdVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Logger logger = zzbfr.zza;
        Level level = Level.WARNING;
        zzbfa zzbfaVar = this.zzb;
        zzauf zzaufVarZzc = zzbfaVar.zzc.zzc();
        zzaxd zzaxdVar = this.zza;
        logger.logp(level, "io.grpc.internal.ManagedChannelImpl$NameResolverListener", "handleErrorInSyncContext", "[{0}] Failed to resolve name. status={1}", new Object[]{zzaufVarZzc, zzaxdVar});
        zzbfaVar.zzc.zzY.zzf();
        zzbfr zzbfrVar = zzbfaVar.zzc;
        if (zzbfrVar.zzak != 3) {
            zzbfrVar.zzW.zzb(3, "Failed to resolve name: {0}", zzaxdVar);
            zzbfaVar.zzc.zzak = 3;
        }
        zzbex zzbexVar = zzbfaVar.zza;
        if (zzbexVar != zzbfaVar.zzc.zzG) {
            return;
        }
        zzbexVar.zza.zza().zza(zzaxdVar);
    }
}
