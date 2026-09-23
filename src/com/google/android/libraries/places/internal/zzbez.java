package com.google.android.libraries.places.internal;

import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbez implements Runnable {
    final /* synthetic */ zzawi zza;
    final /* synthetic */ zzbfa zzb;

    zzbez(zzbfa zzbfaVar, zzawi zzawiVar) {
        this.zzb = zzbfaVar;
        this.zza = zzawiVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbga zzbgaVar;
        zzbfa zzbfaVar = this.zzb;
        zzbfr zzbfrVar = zzbfaVar.zzc;
        if (zzbfrVar.zzE != zzbfaVar.zzb) {
            return;
        }
        zzawi zzawiVar = this.zza;
        List listZze = zzawiVar.zze();
        zzbfrVar.zzW.zzb(1, "Resolved address: {0}, config={1}", listZze, zzawiVar.zza());
        zzbfr zzbfrVar2 = this.zzb.zzc;
        if (zzbfrVar2.zzak != 2) {
            zzbfrVar2.zzW.zzb(2, "Address resolved: {0}", listZze);
            this.zzb.zzc.zzak = 2;
        }
        zzawi zzawiVar2 = this.zza;
        zzawe zzaweVarZzb = zzawiVar2.zzb();
        zzbix zzbixVar = (zzbix) zzawiVar2.zza().zzc(zzbja.zza);
        zzauc zzaucVar = (zzauc) this.zza.zza().zzc(zzauc.zza);
        zzbga zzbgaVar2 = (zzaweVarZzb == null || zzaweVarZzb.zzd() == null) ? null : (zzbga) zzaweVarZzb.zzd();
        zzaxd zzaxdVarZzc = zzaweVarZzb != null ? zzaweVarZzb.zzc() : null;
        zzbfr zzbfrVar3 = this.zzb.zzc;
        if (zzbfrVar3.zzab) {
            if (zzbgaVar2 != null) {
                if (zzaucVar != null) {
                    zzbfrVar3.zzY.zzg(zzaucVar);
                    if (zzbgaVar2.zza() != null) {
                        this.zzb.zzc.zzW.zza(1, "Method configs in service config will be discarded due to presence ofconfig-selector");
                    }
                } else {
                    zzbfrVar3.zzY.zzg(zzbgaVar2.zza());
                }
            } else if (zzaxdVarZzc == null) {
                zzbgaVar2 = zzbfr.zzh;
                zzbfrVar3.zzY.zzg(null);
            } else {
                if (!zzbfrVar3.zzaa) {
                    zzbfrVar3.zzW.zza(2, "Fallback to error due to invalid first service config without default config");
                    this.zzb.zza(zzaweVarZzb.zzc());
                    if (zzbixVar != null) {
                        zzbixVar.zza(false);
                        return;
                    }
                    return;
                }
                zzbgaVar2 = zzbfrVar3.zzZ;
            }
            if (!zzbgaVar2.equals(this.zzb.zzc.zzZ)) {
                this.zzb.zzc.zzW.zzb(2, "Service config changed{0}", zzbgaVar2 == zzbfr.zzh ? " to empty" : "");
                this.zzb.zzc.zzZ = zzbgaVar2;
                this.zzb.zzc.zzai.zza = zzbgaVar2.zzc();
            }
            try {
                this.zzb.zzc.zzaa = true;
            } catch (RuntimeException e) {
                zzbfr zzbfrVar4 = this.zzb.zzc;
                zzbfr.zza.logp(Level.WARNING, "io.grpc.internal.ManagedChannelImpl$NameResolverListener$1NamesResolved", "run", "[" + String.valueOf(zzbfrVar4.zzc()) + "] Unexpected exception from parsing service config", (Throwable) e);
            }
            zzbgaVar = zzbgaVar2;
        } else {
            if (zzbgaVar2 != null) {
                zzbfrVar3.zzW.zza(2, "Service config from name resolver discarded by channel settings");
            }
            zzbfa zzbfaVar2 = this.zzb;
            zzbgaVar = zzbfr.zzh;
            if (zzaucVar != null) {
                zzbfaVar2.zzc.zzW.zza(2, "Config selector from name resolver discarded by channel settings");
            }
            this.zzb.zzc.zzY.zzg(zzbgaVar.zza());
        }
        zzawi zzawiVar3 = this.zza;
        zzbfa zzbfaVar3 = this.zzb;
        zzbfr zzbfrVar5 = zzbfaVar3.zzc;
        zzarv zzarvVarZza = zzawiVar3.zza();
        if (zzbfaVar3.zza == zzbfrVar5.zzG) {
            zzars zzarsVarZzb = zzarvVarZza.zzb();
            zzarsVarZzb.zza(zzauc.zza);
            Map mapZze = zzbgaVar.zze();
            if (mapZze != null) {
                zzarsVarZzb.zzb(zzavb.zza, mapZze);
                zzarsVarZzb.zzc();
            }
            zzarv zzarvVarZzc = zzarsVarZzb.zzc();
            zzayf zzayfVar = this.zzb.zza.zza;
            zzauv zzauvVarZzb = zzaux.zzb();
            zzauvVarZzb.zza(listZze);
            zzauvVarZzb.zzb(zzarvVarZzc);
            zzauvVarZzb.zzc(zzbgaVar.zzd());
            boolean zZzc = zzayfVar.zzc(zzauvVarZzb.zzd());
            if (zzbixVar != null) {
                zzbixVar.zza(zZzc);
            }
        }
    }
}
