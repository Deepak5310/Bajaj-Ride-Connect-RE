package com.google.android.libraries.places.internal;

import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbdu implements zzaue, zzbka {
    private final zzauf zza;
    private final String zzb;
    private final zzbdn zzc;
    private final zzazn zzd;
    private final ScheduledExecutorService zze;
    private final zzatx zzf;
    private final zzayv zzg;
    private final zzayx zzh;
    private final zzasd zzi;
    private final zzaxl zzj;
    private final zzbdo zzk;
    private volatile List zzl;
    private final zzla zzm;

    @Nullable
    private zzaxk zzn;

    @Nullable
    private zzaxk zzo;

    @Nullable
    private zzbgc zzp;

    @Nullable
    private zzazw zzs;

    @Nullable
    private volatile zzbgc zzt;
    private zzaxd zzv;
    private final zzbca zzw;
    private zzbcb zzx;
    private final Collection zzq = new ArrayList();
    private final zzbcz zzr = new zzbdb(this);
    private volatile zzasv zzu = zzasv.zzb(zzasu.IDLE);

    zzbdu(List list, String str, String str2, zzbca zzbcaVar, zzazn zzaznVar, ScheduledExecutorService scheduledExecutorService, zzlc zzlcVar, zzaxl zzaxlVar, zzbdn zzbdnVar, zzatx zzatxVar, zzayv zzayvVar, zzayx zzayxVar, zzauf zzaufVar, zzasd zzasdVar) {
        zzkt.zzf(!list.isEmpty(), "addressGroups is empty");
        zzH(list, "addressGroups contains null entry");
        List listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        this.zzl = listUnmodifiableList;
        this.zzk = new zzbdo(listUnmodifiableList);
        this.zzb = str;
        this.zzw = zzbcaVar;
        this.zzd = zzaznVar;
        this.zze = scheduledExecutorService;
        this.zzm = zzla.zzb();
        this.zzj = zzaxlVar;
        this.zzc = zzbdnVar;
        this.zzf = zzatxVar;
        this.zzg = zzayvVar;
        this.zzh = zzayxVar;
        this.zza = zzaufVar;
        this.zzi = zzasdVar;
    }

    static /* bridge */ /* synthetic */ void zzA(zzbdu zzbduVar) {
        zzbdh zzbdhVar = new zzbdh(zzbduVar);
        zzaxl zzaxlVar = zzbduVar.zzj;
        zzaxlVar.zzc(zzbdhVar);
        zzaxlVar.zzb();
    }

    static /* bridge */ /* synthetic */ void zzB(zzbdu zzbduVar, zzazw zzazwVar, boolean z) {
        zzbdi zzbdiVar = new zzbdi(zzbduVar, zzazwVar, z);
        zzaxl zzaxlVar = zzbduVar.zzj;
        zzaxlVar.zzc(zzbdiVar);
        zzaxlVar.zzb();
    }

    static /* bridge */ /* synthetic */ void zzC(zzbdu zzbduVar, zzaxd zzaxdVar) {
        zzbduVar.zzj.zzd();
        zzbduVar.zzI(zzasv.zzc(zzaxdVar));
        if (zzbduVar.zzx == null) {
            zzbduVar.zzx = new zzbcb();
        }
        long jZza = zzbduVar.zzx.zza() - zzbduVar.zzm.zza(TimeUnit.NANOSECONDS);
        zzbduVar.zzi.zzb(2, "TRANSIENT_FAILURE ({0}). Will reconnect after {1} ns", zzJ(zzaxdVar), Long.valueOf(jZza));
        zzkt.zzo(zzbduVar.zzn == null, "previous reconnectTask is not done");
        zzbduVar.zzn = zzbduVar.zzj.zza(new zzbdc(zzbduVar), jZza, TimeUnit.NANOSECONDS, zzbduVar.zze);
    }

    static /* bridge */ /* synthetic */ void zzD(zzbdu zzbduVar) {
        zzatq zzatqVar;
        zzbduVar.zzj.zzd();
        zzkt.zzo(zzbduVar.zzn == null, "Should have no reconnectTask scheduled");
        if (zzbduVar.zzk.zzf()) {
            zzla zzlaVar = zzbduVar.zzm;
            zzlaVar.zzc();
            zzlaVar.zzd();
        }
        SocketAddress socketAddressZzb = zzbduVar.zzk.zzb();
        zzbdl zzbdlVar = null;
        if (socketAddressZzb instanceof zzatq) {
            zzatq zzatqVar2 = (zzatq) socketAddressZzb;
            zzatqVar = zzatqVar2;
            socketAddressZzb = zzatqVar2.zzd();
        } else {
            zzatqVar = null;
        }
        zzarv zzarvVarZza = zzbduVar.zzk.zza();
        String str = (String) zzarvVarZza.zzc(zzati.zza);
        zzazm zzazmVar = new zzazm();
        if (str == null) {
            str = zzbduVar.zzb;
        }
        zzazmVar.zzc(str);
        zzazmVar.zzd(zzarvVarZza);
        zzazmVar.zzf(null);
        zzazmVar.zze(zzatqVar);
        zzbdt zzbdtVar = new zzbdt();
        zzbdtVar.zza = zzbduVar.zza;
        zzbdm zzbdmVar = new zzbdm(zzbduVar.zzd.zza(socketAddressZzb, zzazmVar, zzbdtVar), zzbduVar.zzg, zzbdlVar);
        zzbdtVar.zza = zzbdmVar.zzc();
        zzbduVar.zzf.zzc(zzbdmVar);
        zzbduVar.zzs = zzbdmVar;
        zzbduVar.zzq.add(zzbdmVar);
        zzbdmVar.zzj(new zzbds(zzbduVar, zzbdmVar));
        zzbduVar.zzi.zzb(2, "Started transport {0}", zzbdtVar.zza);
    }

    private static void zzH(List list, String str) {
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            zzkt.zzc(it2.next(), str);
        }
    }

    private final void zzI(zzasv zzasvVar) {
        this.zzj.zzd();
        if (this.zzu.zza() != zzasvVar.zza()) {
            zzkt.zzo(this.zzu.zza() != zzasu.SHUTDOWN, "Cannot transition out of SHUTDOWN to ".concat(zzasvVar.toString()));
            this.zzu = zzasvVar;
            zzbgq zzbgqVar = (zzbgq) ((zzbfm) this.zzc).zza;
            zzbgv.zzh(zzbgqVar.zzb, zzbgqVar.zza, zzasvVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String zzJ(zzaxd zzaxdVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(zzaxdVar.zza());
        if (zzaxdVar.zzi() != null) {
            sb.append("(");
            sb.append(zzaxdVar.zzi());
            sb.append(")");
        }
        if (zzaxdVar.zzj() != null) {
            sb.append("[");
            sb.append(zzaxdVar.zzj());
            sb.append("]");
        }
        return sb.toString();
    }

    static /* bridge */ /* synthetic */ void zzy(zzbdu zzbduVar) {
        zzbduVar.zzj.zzd();
        zzaxk zzaxkVar = zzbduVar.zzn;
        if (zzaxkVar != null) {
            zzaxkVar.zza();
            zzbduVar.zzn = null;
            zzbduVar.zzx = null;
        }
    }

    static /* bridge */ /* synthetic */ void zzz(zzbdu zzbduVar, zzasu zzasuVar) {
        zzbduVar.zzj.zzd();
        zzbduVar.zzI(zzasv.zzb(zzasuVar));
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzc("logId", this.zza.zza());
        zzknVarZzb.zzd("addressGroups", this.zzl);
        return zzknVarZzb.toString();
    }

    public final void zzE(zzaxd zzaxdVar) {
        zzbdg zzbdgVar = new zzbdg(this, zzaxdVar);
        zzaxl zzaxlVar = this.zzj;
        zzaxlVar.zzc(zzbdgVar);
        zzaxlVar.zzb();
    }

    public final void zzF(List list) {
        zzkt.zzc(list, "newAddressGroups");
        zzH(list, "newAddressGroups contains null entry");
        zzkt.zzf(!list.isEmpty(), "newAddressGroups is empty");
        zzbdf zzbdfVar = new zzbdf(this, Collections.unmodifiableList(new ArrayList(list)));
        zzaxl zzaxlVar = this.zzj;
        zzaxlVar.zzc(zzbdfVar);
        zzaxlVar.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzauk
    public final zzauf zzc() {
        return this.zza;
    }

    @Override // com.google.android.libraries.places.internal.zzbka
    public final zzazl zzh() {
        zzbgc zzbgcVar = this.zzt;
        if (zzbgcVar != null) {
            return zzbgcVar;
        }
        zzaxl zzaxlVar = this.zzj;
        zzaxlVar.zzc(new zzbdd(this));
        zzaxlVar.zzb();
        return null;
    }
}
