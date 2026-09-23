package com.google.android.libraries.places.internal;

import com.facebook.react.animated.InterpolationAnimatedNode;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.apache.commons.lang3.CharEncoding;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzazh extends zzasf {
    private static final Logger zza = Logger.getLogger(zzazh.class.getName());
    private static final byte[] zzb = "gzip".getBytes(Charset.forName(CharEncoding.US_ASCII));
    private static final double zzc = TimeUnit.SECONDS.toNanos(1);
    private final zzawa zzd;
    private final zzbpc zze;
    private final Executor zzf;
    private final boolean zzg;
    private final zzayv zzh;
    private final zzasz zzi;
    private volatile ScheduledFuture zzj;
    private final boolean zzk;
    private zzasa zzl;
    private zzazi zzm;
    private volatile boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private final zzazd zzq;
    private final ScheduledExecutorService zzs;
    private final zzazf zzr = new zzazf(this, null);
    private zzatg zzt = zzatg.zzb();
    private zzast zzu = zzast.zza();

    zzazh(zzawa zzawaVar, Executor executor, zzasa zzasaVar, zzazd zzazdVar, ScheduledExecutorService scheduledExecutorService, zzayv zzayvVar, @Nullable zzauc zzaucVar) {
        this.zzd = zzawaVar;
        this.zze = zzbpb.zzc(zzawaVar.zzf(), System.identityHashCode(this));
        if (executor == zzahp.zza()) {
            this.zzf = new zzbjc();
            this.zzg = true;
        } else {
            this.zzf = new zzbjj(executor);
            this.zzg = false;
        }
        this.zzh = zzayvVar;
        this.zzi = zzasz.zzb();
        this.zzk = zzawaVar.zzb() == zzavy.UNARY || zzawaVar.zzb() == zzavy.SERVER_STREAMING;
        this.zzl = zzasaVar;
        this.zzq = zzazdVar;
        this.zzs = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public final zzatd zzr() {
        zzatd zzatdVarZzi = this.zzl.zzi();
        if (zzatdVarZzi == null) {
            return null;
        }
        return zzatdVarZzi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzs() {
        ScheduledFuture scheduledFuture = this.zzj;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
    }

    private final void zzt(Object obj) {
        zzkt.zzo(this.zzm != null, "Not started");
        zzkt.zzo(!this.zzo, "call was cancelled");
        zzkt.zzo(!this.zzp, "call was half-closed");
        try {
            zzazi zzaziVar = this.zzm;
            if (zzaziVar instanceof zzbit) {
                ((zzbit) zzaziVar).zzab(obj);
            } else {
                zzaziVar.zzw(this.zzd.zzc(obj));
            }
            if (this.zzk) {
                return;
            }
            this.zzm.zzr();
        } catch (Error e) {
            this.zzm.zzh(zzaxd.zzb.zzg("Client sendMessage() failed with Error"));
            throw e;
        } catch (RuntimeException e2) {
            this.zzm.zzh(zzaxd.zzb.zzf(e2).zzg("Failed to stream message"));
        }
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd(FirebaseAnalytics.Param.METHOD, this.zzd);
        return zzknVarZzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzasf
    public final void zza(@Nullable String str, @Nullable Throwable th) {
        int i = zzbpb.zza;
        if (str == null && th == null) {
            th = new CancellationException("Cancelled without a message or cause");
            zza.logp(Level.WARNING, "io.grpc.internal.ClientCallImpl", "cancelInternal", "Cancelling without a message or cause is suboptimal", th);
        }
        if (this.zzo) {
            return;
        }
        this.zzo = true;
        try {
            if (this.zzm != null) {
                zzaxd zzaxdVar = zzaxd.zzb;
                zzaxd zzaxdVarZzg = str != null ? zzaxdVar.zzg(str) : zzaxdVar.zzg("Call cancelled without message");
                if (th != null) {
                    zzaxdVarZzg = zzaxdVarZzg.zzf(th);
                }
                this.zzm.zzh(zzaxdVarZzg);
            }
        } finally {
            zzs();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzasf
    public final void zzb() {
        int i = zzbpb.zza;
        zzkt.zzo(this.zzm != null, "Not started");
        zzkt.zzo(!this.zzo, "call was cancelled");
        zzkt.zzo(!this.zzp, "call already half-closed");
        this.zzp = true;
        this.zzm.zzj();
    }

    @Override // com.google.android.libraries.places.internal.zzasf
    public final void zzc(int i) {
        int i2 = zzbpb.zza;
        zzkt.zzo(this.zzm != null, "Not started");
        this.zzm.zzu(2);
    }

    @Override // com.google.android.libraries.places.internal.zzasf
    public final void zzd(Object obj) {
        int i = zzbpb.zza;
        zzt(obj);
    }

    @Override // com.google.android.libraries.places.internal.zzasf
    public final void zze(zzase zzaseVar, zzavu zzavuVar) {
        int i = zzbpb.zza;
        zzkt.zzo(this.zzm == null, "Already started");
        zzkt.zzo(!this.zzo, "call was cancelled");
        zzbfx zzbfxVar = (zzbfx) this.zzl.zzl(zzbfx.zza);
        if (zzbfxVar != null) {
            Long l = zzbfxVar.zzb;
            if (l != null) {
                zzatd zzatdVarZzd = zzatd.zzd(l.longValue(), TimeUnit.NANOSECONDS);
                zzatd zzatdVarZzi = this.zzl.zzi();
                if (zzatdVarZzi == null || zzatdVarZzd.compareTo(zzatdVarZzi) < 0) {
                    this.zzl = this.zzl.zza(zzatdVarZzd);
                }
            }
            Boolean bool = zzbfxVar.zzc;
            if (bool != null) {
                this.zzl = bool.booleanValue() ? this.zzl.zzg() : this.zzl.zzh();
            }
            if (zzbfxVar.zzd != null) {
                Integer numZzj = this.zzl.zzj();
                if (numZzj != null) {
                    this.zzl = this.zzl.zzc(Math.min(numZzj.intValue(), zzbfxVar.zzd.intValue()));
                } else {
                    this.zzl = this.zzl.zzc(zzbfxVar.zzd.intValue());
                }
            }
            if (zzbfxVar.zze != null) {
                Integer numZzk = this.zzl.zzk();
                if (numZzk != null) {
                    this.zzl = this.zzl.zzd(Math.min(numZzk.intValue(), zzbfxVar.zze.intValue()));
                } else {
                    this.zzl = this.zzl.zzd(zzbfxVar.zze.intValue());
                }
            }
        }
        zzasr zzasrVar = zzasq.zza;
        zzatg zzatgVar = this.zzt;
        zzavuVar.zzd(zzbcu.zzg);
        zzavuVar.zzd(zzbcu.zzc);
        if (zzasrVar != zzasq.zza) {
            zzavuVar.zzf(zzbcu.zzc, InterpolationAnimatedNode.EXTRAPOLATE_TYPE_IDENTITY);
        }
        zzavuVar.zzd(zzbcu.zzd);
        byte[] bArrZza = zzaud.zza(zzatgVar);
        if (bArrZza.length != 0) {
            zzavuVar.zzf(zzbcu.zzd, bArrZza);
        }
        zzavuVar.zzd(zzbcu.zze);
        zzavuVar.zzd(zzbcu.zzf);
        zzatd zzatdVarZzr = zzr();
        if (zzatdVarZzr == null || !zzatdVarZzr.zze()) {
            zzatd zzatdVarZzi2 = this.zzl.zzi();
            Logger logger = zza;
            if (logger.isLoggable(Level.FINE) && zzatdVarZzr != null && zzatdVarZzr.equals(null)) {
                StringBuilder sb = new StringBuilder(String.format(Locale.US, "Call timeout set to '%d' ns, due to context deadline.", Long.valueOf(Math.max(0L, zzatdVarZzr.zzb(TimeUnit.NANOSECONDS)))));
                if (zzatdVarZzi2 == null) {
                    sb.append(" Explicit call timeout was not set.");
                } else {
                    sb.append(String.format(Locale.US, " Explicit call timeout was '%d' ns.", Long.valueOf(zzatdVarZzi2.zzb(TimeUnit.NANOSECONDS))));
                }
                logger.logp(Level.FINE, "io.grpc.internal.ClientCallImpl", "logIfContextNarrowedTimeout", sb.toString());
            }
            this.zzm = this.zzq.zza(this.zzd, this.zzl, zzavuVar, this.zzi);
        } else {
            zzaso[] zzasoVarArrZzj = zzbcu.zzj(this.zzl, zzavuVar, 0, false);
            String str = this.zzl.zzi() == null ? "Context" : "CallOptions";
            Long l2 = (Long) this.zzl.zzl(zzaso.zza);
            double dZzb = zzatdVarZzr.zzb(TimeUnit.NANOSECONDS);
            double d = zzc;
            this.zzm = new zzbcc(zzaxd.zze.zzg(String.format("ClientCall started after %s deadline was exceeded %.9f seconds ago. Name resolution delay %.9f seconds.", str, Double.valueOf(dZzb / d), Double.valueOf(l2 == null ? 0.0d : l2.longValue() / d))), zzazj.PROCESSED, zzasoVarArrZzj);
        }
        if (this.zzg) {
            this.zzm.zzt();
        }
        if (this.zzl.zzj() != null) {
            this.zzm.zzm(this.zzl.zzj().intValue());
        }
        if (this.zzl.zzk() != null) {
            this.zzm.zzn(this.zzl.zzk().intValue());
        }
        if (zzatdVarZzr != null) {
            this.zzm.zzk(zzatdVarZzr);
        }
        this.zzm.zzv(zzasrVar);
        this.zzm.zzl(this.zzt);
        this.zzh.zzb();
        this.zzm.zzo(new zzazc(this, zzaseVar));
        this.zzi.zzd(this.zzr, zzahp.zza());
        if (zzatdVarZzr != null && !zzatdVarZzr.equals(null) && this.zzs != null) {
            long jZzb = zzatdVarZzr.zzb(TimeUnit.NANOSECONDS);
            this.zzj = this.zzs.schedule(new zzbdz(new zzazg(this, jZzb)), jZzb, TimeUnit.NANOSECONDS);
        }
        if (this.zzn) {
            zzs();
        }
    }

    final zzazh zzl(zzast zzastVar) {
        this.zzu = zzastVar;
        return this;
    }

    final zzazh zzm(zzatg zzatgVar) {
        this.zzt = zzatgVar;
        return this;
    }
}
