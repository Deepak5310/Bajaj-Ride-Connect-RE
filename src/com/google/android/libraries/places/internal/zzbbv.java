package com.google.android.libraries.places.internal;

import java.io.IOException;
import java.util.Collections;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbbv implements Runnable {
    final /* synthetic */ zzbby zza;
    private final zzawg zzb;

    zzbbv(zzbby zzbbyVar, zzawg zzawgVar) {
        this.zza = zzbbyVar;
        zzkt.zzc(zzawgVar, "savedListener");
        this.zzb = zzawgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        zzbbu zzbbuVar;
        zzaxl zzaxlVar;
        if (zzbby.zzg.isLoggable(Level.FINER)) {
            zzbby.zzg.logp(Level.FINER, "io.grpc.internal.DnsNameResolver$Resolve", "run", "Attempting DNS resolution of ".concat(String.valueOf(this.zza.zzq)));
        }
        zzbbs zzbbsVarZzi = null;
        try {
            try {
                zzati zzatiVarZzg = zzbby.zzg(this.zza);
                zzawh zzawhVarZzc = zzawi.zzc();
                if (zzatiVarZzg == null) {
                    zzbbsVarZzi = this.zza.zzi(false);
                    if (zzbbsVarZzi.zza != null) {
                        this.zzb.zza(zzbbsVarZzi.zza);
                        z = zzbbsVarZzi.zza == null;
                        zzaxlVar = this.zza.zzu;
                        zzbbuVar = new zzbbu(this, z);
                    } else {
                        if (zzbbsVarZzi.zzb != null) {
                            zzawhVarZzc.zza(zzbbsVarZzi.zzb);
                        }
                        if (zzbbsVarZzi.zzc != null) {
                            zzawhVarZzc.zzc(zzbbsVarZzi.zzc);
                        }
                    }
                    zzaxlVar.zzc(zzbbuVar);
                    zzaxlVar.zzb();
                }
                if (zzbby.zzg.isLoggable(Level.FINER)) {
                    zzbby.zzg.logp(Level.FINER, "io.grpc.internal.DnsNameResolver$Resolve", "run", "Using proxy address " + zzatiVarZzg.toString());
                }
                zzawhVarZzc.zza(Collections.singletonList(zzatiVarZzg));
                this.zzb.zzb(zzawhVarZzc.zzd());
            } catch (IOException e) {
                this.zzb.zza(zzaxd.zzp.zzg("Unable to resolve host " + this.zza.zzq).zzf(e));
            }
            z = zzbbsVarZzi != null && zzbbsVarZzi.zza == null;
            zzaxlVar = this.zza.zzu;
            zzbbuVar = new zzbbu(this, z);
            zzaxlVar.zzc(zzbbuVar);
            zzaxlVar.zzb();
        } catch (Throwable th) {
            z = 0 != 0 && null.zza == null;
            zzaxl zzaxlVar2 = this.zza.zzu;
            zzaxlVar2.zzc(new zzbbu(this, z));
            zzaxlVar2.zzb();
            throw th;
        }
    }
}
