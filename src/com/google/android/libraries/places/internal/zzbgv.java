package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbgv extends zzavb {
    private final zzaus zzc;
    private zzauy zzd;
    private zzasu zze = zzasu.IDLE;

    zzbgv(zzaus zzausVar) {
        this.zzc = zzausVar;
    }

    static /* bridge */ /* synthetic */ void zzh(zzbgv zzbgvVar, zzauy zzauyVar, zzasv zzasvVar) {
        zzauz zzbgsVar;
        zzasu zzasuVarZza = zzasvVar.zza();
        if (zzasuVarZza == zzasu.SHUTDOWN) {
            return;
        }
        if (zzasuVarZza == zzasu.TRANSIENT_FAILURE || zzasuVarZza == zzasu.IDLE) {
            zzbgvVar.zzc.zzc();
        }
        if (zzbgvVar.zze == zzasu.TRANSIENT_FAILURE) {
            if (zzasuVarZza == zzasu.CONNECTING) {
                return;
            }
            if (zzasuVarZza == zzasu.IDLE) {
                zzbgvVar.zzc();
                return;
            }
        }
        int iOrdinal = zzasuVarZza.ordinal();
        if (iOrdinal == 0) {
            zzbgsVar = new zzbgs(zzaut.zzc());
        } else if (iOrdinal == 1) {
            zzbgsVar = new zzbgs(zzaut.zzd(zzauyVar, null));
        } else if (iOrdinal == 2) {
            zzbgsVar = new zzbgs(zzaut.zzb(zzasvVar.zzd()));
        } else {
            if (iOrdinal != 3) {
                throw new IllegalArgumentException("Unsupported state:".concat(zzasuVarZza.toString()));
            }
            zzbgsVar = new zzbgu(zzbgvVar, zzauyVar);
        }
        zzbgvVar.zzi(zzasuVarZza, zzbgsVar);
    }

    private final void zzi(zzasu zzasuVar, zzauz zzauzVar) {
        this.zze = zzasuVar;
        this.zzc.zzd(zzasuVar, zzauzVar);
    }

    @Override // com.google.android.libraries.places.internal.zzavb
    public final void zza(zzaxd zzaxdVar) {
        zzauy zzauyVar = this.zzd;
        if (zzauyVar != null) {
            zzauyVar.zzb();
            this.zzd = null;
        }
        zzi(zzasu.TRANSIENT_FAILURE, new zzbgs(zzaut.zzb(zzaxdVar)));
    }

    @Override // com.google.android.libraries.places.internal.zzavb
    public final void zzc() {
        zzauy zzauyVar = this.zzd;
        if (zzauyVar != null) {
            zzauyVar.zza();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzavb
    public final void zzd() {
        zzauy zzauyVar = this.zzd;
        if (zzauyVar != null) {
            zzauyVar.zzb();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzavb
    public final boolean zze(zzaux zzauxVar) {
        zzbgr zzbgrVar;
        Boolean bool;
        List listZze = zzauxVar.zze();
        if (listZze.isEmpty()) {
            zza(zzaxd.zzp.zzg("NameResolver returned no usable address. addrs=" + String.valueOf(zzauxVar.zze()) + ", attrs=" + zzauxVar.zza().toString()));
            return false;
        }
        if ((zzauxVar.zzd() instanceof zzbgr) && (bool = (zzbgrVar = (zzbgr) zzauxVar.zzd()).zza) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(listZze);
            Long l = zzbgrVar.zzb;
            Collections.shuffle(arrayList, new Random());
            listZze = arrayList;
        }
        zzauy zzauyVar = this.zzd;
        if (zzauyVar != null) {
            zzbfo zzbfoVar = (zzbfo) zzauyVar;
            zzbfoVar.zzj.zzf.zzd();
            zzbfoVar.zze = listZze;
            zzbfoVar.zzf.zzF(listZze);
            return true;
        }
        zzaus zzausVar = this.zzc;
        zzaun zzaunVarZza = zzaup.zza();
        zzaunVarZza.zza(listZze);
        zzauy zzauyVarZza = zzausVar.zza(zzaunVarZza.zzb());
        zzbgq zzbgqVar = new zzbgq(this, zzauyVarZza);
        zzbfo zzbfoVar2 = (zzbfo) zzauyVarZza;
        zzbfoVar2.zzj.zzf.zzd();
        zzkt.zzo(!zzbfoVar2.zzg, "already started");
        zzkt.zzo(!zzbfoVar2.zzh, "already shutdown");
        zzkt.zzo(!zzbfoVar2.zzj.zzQ, "Channel is being terminated");
        zzbfoVar2.zzg = true;
        zzaup zzaupVar = zzbfoVar2.zza;
        zzbfr zzbfrVar = zzbfoVar2.zzj;
        List listZzb = zzaupVar.zzb();
        String strZzb = zzbfrVar.zzb();
        zzbca zzbcaVar = zzbfrVar.zzan;
        zzazn zzaznVar = zzbfrVar.zzr;
        ScheduledExecutorService scheduledExecutorServiceZzb = zzbfrVar.zzr.zzb();
        zzbfr zzbfrVar2 = zzbfoVar2.zzj;
        zzlc zzlcVar = zzbfrVar2.zzA;
        zzbfm zzbfmVar = new zzbfm(zzbfoVar2, zzbgqVar);
        zzbfr zzbfrVar3 = zzbfoVar2.zzj;
        zzbdu zzbduVar = new zzbdu(listZzb, strZzb, null, zzbcaVar, zzaznVar, scheduledExecutorServiceZzb, zzlcVar, zzbfrVar2.zzf, zzbfmVar, zzbfrVar3.zzX, zzbfrVar3.zzT.zza(), zzbfoVar2.zzd, zzbfoVar2.zzb, zzbfoVar2.zzc);
        zzayx zzayxVar = zzbfoVar2.zzj.zzV;
        zzatr zzatrVar = new zzatr();
        zzatrVar.zza("Child Subchannel started");
        zzatrVar.zzb(zzats.CT_INFO);
        zzatrVar.zzd(zzbfoVar2.zzj.zzx.zza());
        zzatrVar.zzc(zzbduVar);
        zzayxVar.zzc(zzatrVar.zze());
        zzbfoVar2.zzf = zzbduVar;
        zzbfoVar2.zzj.zzX.zze(zzbduVar);
        zzbfoVar2.zzj.zzJ.add(zzbduVar);
        this.zzd = zzauyVarZza;
        zzi(zzasu.CONNECTING, new zzbgs(zzaut.zzd(zzauyVarZza, null)));
        zzauyVarZza.zza();
        return true;
    }
}
