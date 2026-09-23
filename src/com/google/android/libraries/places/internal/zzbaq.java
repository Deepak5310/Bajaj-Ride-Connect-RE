package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbaq extends zzasf {
    private static final Logger zza = Logger.getLogger(zzbaq.class.getName());
    private static final zzasf zzb = new zzbaj();

    @Nullable
    private final ScheduledFuture zzc;
    private final Executor zzd;
    private final zzasz zze;
    private volatile boolean zzf;
    private zzase zzg;
    private zzasf zzh;
    private zzaxd zzi;
    private List zzj = new ArrayList();
    private zzbap zzk;

    protected zzbaq(Executor executor, ScheduledExecutorService scheduledExecutorService, @Nullable zzatd zzatdVar) {
        ScheduledFuture<?> scheduledFutureSchedule;
        zzkt.zzc(executor, "callExecutor");
        this.zzd = executor;
        zzkt.zzc(scheduledExecutorService, "scheduler");
        this.zze = zzasz.zzb();
        if (zzatdVar == null) {
            scheduledFutureSchedule = null;
        } else {
            long jZzb = zzatdVar.zzb(TimeUnit.NANOSECONDS);
            long jAbs = Math.abs(jZzb) / TimeUnit.SECONDS.toNanos(1L);
            long jAbs2 = Math.abs(jZzb) % TimeUnit.SECONDS.toNanos(1L);
            StringBuilder sb = new StringBuilder();
            if (jZzb < 0) {
                sb.append("ClientCall started after CallOptions deadline was exceeded. Deadline has been exceeded for ");
            } else {
                sb.append("Deadline CallOptions will be exceeded in ");
            }
            sb.append(jAbs);
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
            sb.append("s. ");
            scheduledFutureSchedule = scheduledExecutorService.schedule(new zzbac(this, sb), jZzb, TimeUnit.NANOSECONDS);
        }
        this.zzc = scheduledFutureSchedule;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzl(zzaxd zzaxdVar, boolean z) {
        zzase zzaseVar;
        boolean z2;
        synchronized (this) {
            if (this.zzh == null) {
                zzo(zzb);
                zzaseVar = this.zzg;
                this.zzi = zzaxdVar;
                z2 = false;
            } else {
                if (z) {
                    return;
                }
                zzaseVar = null;
                z2 = true;
            }
            if (z2) {
                zzm(new zzbaf(this, zzaxdVar));
            } else {
                if (zzaseVar != null) {
                    this.zzd.execute(new zzbak(this, zzaseVar, zzaxdVar));
                }
                zzn();
            }
            zzk();
        }
    }

    private final void zzm(Runnable runnable) {
        synchronized (this) {
            if (this.zzf) {
                runnable.run();
            } else {
                this.zzj.add(runnable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:25:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:9:0x0019  */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        r0 = r1.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r0.hasNext() == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0033, code lost:
    
        ((java.lang.Runnable) r0.next()).run();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzn() {
        zzbap zzbapVar;
        List list;
        List arrayList = new ArrayList();
        while (true) {
            synchronized (this) {
                if (this.zzj.isEmpty()) {
                    break;
                }
                list = this.zzj;
                this.zzj = arrayList;
            }
            if (zzbapVar != null) {
                this.zzd.execute(new zzbad(this, zzbapVar));
            }
            list.clear();
            arrayList = list;
        }
        this.zzj = null;
        this.zzf = true;
        zzbapVar = this.zzk;
        if (zzbapVar != null) {
            this.zzd.execute(new zzbad(this, zzbapVar));
        }
    }

    private final void zzo(zzasf zzasfVar) {
        zzasf zzasfVar2 = this.zzh;
        zzkt.zzq(zzasfVar2 == null, "realCall already set to %s", zzasfVar2);
        ScheduledFuture scheduledFuture = this.zzc;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.zzh = zzasfVar;
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("realCall", this.zzh);
        return zzknVarZzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzasf
    public final void zza(@Nullable String str, @Nullable Throwable th) {
        zzaxd zzaxdVar = zzaxd.zzb;
        zzaxd zzaxdVarZzg = str != null ? zzaxdVar.zzg(str) : zzaxdVar.zzg("Call cancelled without message");
        if (th != null) {
            zzaxdVarZzg = zzaxdVarZzg.zzf(th);
        }
        zzl(zzaxdVarZzg, false);
    }

    @Override // com.google.android.libraries.places.internal.zzasf
    public final void zzb() {
        zzm(new zzbai(this));
    }

    @Override // com.google.android.libraries.places.internal.zzasf
    public final void zzc(int i) {
        if (this.zzf) {
            this.zzh.zzc(2);
        } else {
            zzm(new zzbah(this, 2));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzasf
    public final void zzd(Object obj) {
        if (this.zzf) {
            this.zzh.zzd(obj);
        } else {
            zzm(new zzbag(this, obj));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzasf
    public final void zze(zzase zzaseVar, zzavu zzavuVar) {
        zzaxd zzaxdVar;
        boolean z;
        zzkt.zzo(this.zzg == null, "already started");
        synchronized (this) {
            this.zzg = zzaseVar;
            zzaxdVar = this.zzi;
            z = this.zzf;
            if (!z) {
                zzbap zzbapVar = new zzbap(zzaseVar);
                this.zzk = zzbapVar;
                zzaseVar = zzbapVar;
            }
        }
        if (zzaxdVar != null) {
            this.zzd.execute(new zzbak(this, zzaseVar, zzaxdVar));
        } else if (z) {
            this.zzh.zze(zzaseVar, zzavuVar);
        } else {
            zzm(new zzbae(this, zzaseVar, zzavuVar));
        }
    }

    protected void zzk() {
    }

    public final Runnable zzh(zzasf zzasfVar) {
        synchronized (this) {
            if (this.zzh != null) {
                return null;
            }
            zzo(zzasfVar);
            return new zzbab(this, this.zze);
        }
    }
}
