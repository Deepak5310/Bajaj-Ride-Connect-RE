package com.google.android.libraries.places.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.firebase.sessions.settings.RemoteSettings;
import io.grpc.internal.GrpcUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbfr extends zzavg implements zzaue {
    static final Logger zza = Logger.getLogger(zzbfr.class.getName());
    static final Pattern zzb = Pattern.compile("[a-zA-Z][a-zA-Z0-9+.-]*:/.*");
    static final zzaxd zzc = zzaxd.zzp.zzg("Channel shutdownNow invoked");
    static final zzaxd zzd = zzaxd.zzp.zzg("Channel shutdown invoked");
    static final zzaxd zze = zzaxd.zzp.zzg("Subchannel shutdown invoked");
    private static final zzbga zzh = new zzbga(null, new HashMap(), new HashMap(), null, null, null);
    private static final zzauc zzi = new zzbec();
    private static final zzasf zzj = new zzbeg();
    private final zzlc zzA;
    private final long zzB;
    private final zzazy zzC;
    private final zzasb zzD;
    private zzawk zzE;
    private boolean zzF;

    @Nullable
    private zzbex zzG;

    @Nullable
    private volatile zzauz zzH;
    private boolean zzI;
    private final Set zzJ;

    @Nullable
    private Collection zzK;
    private final Object zzL;
    private final Set zzM;
    private final zzbax zzN;
    private final zzbfq zzO;
    private final AtomicBoolean zzP;
    private boolean zzQ;
    private volatile boolean zzR;
    private final CountDownLatch zzS;
    private final zzayu zzT;
    private final zzayv zzU;
    private final zzayx zzV;
    private final zzasd zzW;
    private final zzatx zzX;
    private final zzbfj zzY;
    private zzbga zzZ;
    private boolean zzaa;
    private final boolean zzab;
    private final zzbic zzac;
    private final long zzad;
    private final long zzae;
    private final boolean zzaf;
    private final zzatc zzag;
    private final zzbgb zzah;
    private final zzbek zzai;
    private final zzbhk zzaj;
    private int zzak;
    private final zzbjs zzal;
    private final zzbjs zzam;
    private final zzbca zzan;
    final zzaxl zzf;
    final zzbcz zzg;
    private final zzauf zzk;
    private final String zzl;
    private final zzawq zzm;
    private final zzawf zzn;
    private final zzawd zzo;
    private final zzayn zzp;
    private final zzazn zzq;
    private final zzazn zzr;
    private final zzazn zzs;
    private final zzbfl zzt;
    private final Executor zzu;
    private final zzbep zzv;
    private final zzbep zzw;
    private final zzbjy zzx;
    private final zzatg zzy;
    private final zzast zzz;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v2, types: [java.lang.Object, java.util.concurrent.Executor] */
    zzbfr(zzbfu zzbfuVar, zzazn zzaznVar, zzbca zzbcaVar, zzbjs zzbjsVar, zzlc zzlcVar, List list, zzbjy zzbjyVar) {
        zzaxl zzaxlVar = new zzaxl(new zzbef(this));
        this.zzf = zzaxlVar;
        this.zzC = new zzazy();
        this.zzJ = new HashSet(16, 0.75f);
        this.zzL = new Object();
        this.zzM = new HashSet(1, 0.75f);
        this.zzO = new zzbfq(this, null);
        this.zzP = new AtomicBoolean(false);
        this.zzS = new CountDownLatch(1);
        this.zzak = 1;
        this.zzZ = zzh;
        this.zzaa = false;
        this.zzac = new zzbic();
        this.zzag = zzatd.zzc();
        zzbeo zzbeoVar = new zzbeo(this, 0 == true ? 1 : 0);
        this.zzah = zzbeoVar;
        this.zzg = new zzber(this, 0 == true ? 1 : 0);
        this.zzai = new zzbek(this, 0 == true ? 1 : 0);
        String str = zzbfuVar.zze;
        this.zzl = str;
        zzauf zzaufVarZzc = zzauf.zzc("Channel", str);
        this.zzk = zzaufVarZzc;
        this.zzx = zzbjyVar;
        zzbjs zzbjsVar2 = zzbfuVar.zzk;
        zzkt.zzc(zzbjsVar2, "executorPool");
        this.zzal = zzbjsVar2;
        ?? Zzb = zzbjsVar2.zzb();
        zzkt.zzc(Zzb, "executor");
        this.zzu = Zzb;
        this.zzq = zzaznVar;
        zzbjs zzbjsVar3 = zzbfuVar.zzl;
        zzkt.zzc(zzbjsVar3, "offloadExecutorPool");
        zzbep zzbepVar = new zzbep(zzbjsVar3);
        this.zzw = zzbepVar;
        zzays zzaysVar = new zzays(zzaznVar, null, zzbepVar);
        this.zzr = zzaysVar;
        this.zzs = new zzays(zzaznVar, null, zzbepVar);
        zzbfl zzbflVar = new zzbfl(zzaysVar.zzb(), 0 == true ? 1 : 0);
        this.zzt = zzbflVar;
        zzayx zzayxVar = new zzayx(zzaufVarZzc, 0, zzbjyVar.zza(), "Channel for '" + str + "'");
        this.zzV = zzayxVar;
        zzayw zzaywVar = new zzayw(zzayxVar, zzbjyVar);
        this.zzW = zzaywVar;
        zzawt zzawtVar = zzbcu.zzm;
        this.zzaf = true;
        zzayn zzaynVar = new zzayn(zzavf.zzb(), zzbfuVar.zzf);
        this.zzp = zzaynVar;
        this.zzm = zzbfuVar.zzc;
        zzbjb zzbjbVar = new zzbjb(true, 5, 5, zzaynVar);
        zzawb zzawbVarZzb = zzawd.zzb();
        zzbfuVar.zzb();
        zzawbVarZzb.zzb(GrpcUtil.DEFAULT_PORT_SSL);
        zzawbVarZzb.zzd(zzawtVar);
        zzawbVarZzb.zzg(zzaxlVar);
        zzawbVarZzb.zze(zzbflVar);
        zzawbVarZzb.zzf(zzbjbVar);
        zzawbVarZzb.zza(zzaywVar);
        zzawbVarZzb.zzc(zzbepVar);
        zzawd zzawdVarZzh = zzawbVarZzb.zzh();
        this.zzo = zzawdVarZzh;
        zzawf zzawfVar = zzbfuVar.zzd;
        this.zzn = zzawfVar;
        this.zzE = zzo(str, null, zzawfVar, zzawdVarZzh);
        this.zzam = zzbjsVar;
        this.zzv = new zzbep(zzbjsVar);
        zzbax zzbaxVar = new zzbax(Zzb, zzaxlVar);
        this.zzN = zzbaxVar;
        zzbaxVar.zzj(zzbeoVar);
        this.zzan = zzbcaVar;
        this.zzab = true;
        zzbfj zzbfjVar = new zzbfj(this, this.zzE.zza(), null);
        this.zzY = zzbfjVar;
        this.zzD = zzask.zza(zzbfjVar, list);
        zzkt.zzc(zzlcVar, "stopwatchSupplier");
        this.zzA = zzlcVar;
        long j = zzbfuVar.zzi;
        if (j == -1) {
            this.zzB = -1L;
        } else {
            zzkt.zzi(j >= zzbfu.zzb, "invalid idleTimeoutMillis %s", j);
            this.zzB = zzbfuVar.zzi;
        }
        this.zzaj = new zzbhk(new zzbet(this, null), zzaxlVar, zzaysVar.zzb(), zzla.zzb());
        zzatg zzatgVar = zzbfuVar.zzg;
        zzkt.zzc(zzatgVar, "decompressorRegistry");
        this.zzy = zzatgVar;
        zzast zzastVar = zzbfuVar.zzh;
        zzkt.zzc(zzastVar, "compressorRegistry");
        this.zzz = zzastVar;
        this.zzae = 16777216L;
        this.zzad = PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        zzbed zzbedVar = new zzbed(this, zzbjyVar);
        this.zzT = zzbedVar;
        this.zzU = zzbedVar.zza();
        zzatx zzatxVar = zzbfuVar.zzj;
        zzatxVar.getClass();
        this.zzX = zzatxVar;
        zzatxVar.zzd(this);
    }

    static /* bridge */ /* synthetic */ Executor zzI(zzbfr zzbfrVar, zzasa zzasaVar) {
        Executor executorZzn = zzasaVar.zzn();
        return executorZzn == null ? zzbfrVar.zzu : executorZzn;
    }

    static /* bridge */ /* synthetic */ void zzO(zzbfr zzbfrVar) {
        zzbfrVar.zzag(true);
        zzbfrVar.zzN.zzm(null);
        zzbfrVar.zzW.zza(2, "Entering IDLE state");
        zzbfrVar.zzC.zza(zzasu.IDLE);
        if (zzbfrVar.zzg.zzd(zzbfrVar.zzL, zzbfrVar.zzN)) {
            zzbfrVar.zzU();
        }
    }

    static /* bridge */ /* synthetic */ void zzP(zzbfr zzbfrVar) {
        if (!zzbfrVar.zzR && zzbfrVar.zzP.get() && zzbfrVar.zzJ.isEmpty() && zzbfrVar.zzM.isEmpty()) {
            zzbfrVar.zzW.zza(2, "Terminated");
            zzbfrVar.zzX.zzg(zzbfrVar);
            zzbfrVar.zzal.zzc(zzbfrVar.zzu);
            zzbfrVar.zzv.zzb();
            zzbfrVar.zzw.zzb();
            zzbfrVar.zzr.close();
            zzbfrVar.zzR = true;
            zzbfrVar.zzS.countDown();
        }
    }

    static /* bridge */ /* synthetic */ void zzQ(zzbfr zzbfrVar) {
        zzbfrVar.zzf.zzd();
        if (zzbfrVar.zzF) {
            zzbfrVar.zzE.zzb();
        }
    }

    private static zzawk zzae(String str, zzawf zzawfVar, zzawd zzawdVar) {
        URI uri;
        zzawk zzawkVarZza;
        StringBuilder sb = new StringBuilder();
        try {
            uri = new URI(str);
        } catch (URISyntaxException e) {
            sb.append(e.getMessage());
            uri = null;
        }
        if (uri != null && (zzawkVarZza = zzawfVar.zza(uri, zzawdVar)) != null) {
            return zzawkVarZza;
        }
        String str2 = "";
        if (!zzb.matcher(str).matches()) {
            try {
                zzawk zzawkVarZza2 = zzawfVar.zza(new URI(zzawfVar.zzb(), "", RemoteSettings.FORWARD_SLASH_STRING + str, null), zzawdVar);
                if (zzawkVarZza2 != null) {
                    return zzawkVarZza2;
                }
            } catch (URISyntaxException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        if (sb.length() > 0) {
            str2 = " (" + sb.toString() + ")";
        }
        throw new IllegalArgumentException(String.format("cannot find a NameResolver for %s%s", str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaf() {
        long j = this.zzB;
        if (j == -1) {
            return;
        }
        this.zzaj.zzi(j, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzag(boolean z) {
        this.zzf.zzd();
        if (z) {
            zzkt.zzo(this.zzF, "nameResolver is not started");
            zzkt.zzo(this.zzG != null, "lbHelper is null");
        }
        zzawk zzawkVar = this.zzE;
        if (zzawkVar != null) {
            zzawkVar.zzc();
            this.zzF = false;
            if (z) {
                this.zzE = zzo(this.zzl, null, this.zzn, this.zzo);
            } else {
                this.zzE = null;
            }
        }
        zzbex zzbexVar = this.zzG;
        if (zzbexVar != null) {
            zzbexVar.zza.zzb();
            this.zzG = null;
        }
        this.zzH = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzah(zzauz zzauzVar) {
        this.zzH = zzauzVar;
        this.zzN.zzm(zzauzVar);
    }

    static zzawk zzo(String str, @Nullable String str2, zzawf zzawfVar, zzawd zzawdVar) {
        return new zzbja(zzae(str, zzawfVar, zzawdVar), new zzayp(new zzbca(), zzawdVar.zzg(), zzawdVar.zze()), zzawdVar.zze());
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzc("logId", this.zzk.zza());
        zzknVarZzb.zzd("target", this.zzl);
        return zzknVarZzb.toString();
    }

    final void zzU() {
        this.zzf.zzd();
        if (this.zzP.get() || this.zzI) {
            return;
        }
        if (this.zzg.zze()) {
            this.zzaj.zzh(false);
        } else {
            zzaf();
        }
        if (this.zzG == null) {
            this.zzW.zza(2, "Exiting idle mode");
            zzbex zzbexVar = new zzbex(this, null);
            zzbexVar.zza = new zzayf(this.zzp, zzbexVar);
            this.zzG = zzbexVar;
            this.zzE.zzd(new zzbfa(this, zzbexVar, this.zzE));
            this.zzF = true;
        }
    }

    final void zzV(Throwable th) {
        if (this.zzI) {
            return;
        }
        this.zzI = true;
        this.zzaj.zzh(true);
        zzag(false);
        zzah(new zzbee(this, th));
        this.zzY.zzg(null);
        this.zzW.zza(4, "PANIC! Entering TRANSIENT_FAILURE");
        this.zzC.zza(zzasu.TRANSIENT_FAILURE);
    }

    @Override // com.google.android.libraries.places.internal.zzasb
    public final zzasf zza(zzawa zzawaVar, zzasa zzasaVar) {
        return this.zzD.zza(zzawaVar, zzasaVar);
    }

    @Override // com.google.android.libraries.places.internal.zzasb
    public final String zzb() {
        return this.zzD.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzauk
    public final zzauf zzc() {
        return this.zzk;
    }
}
