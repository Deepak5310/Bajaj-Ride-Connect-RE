package com.google.android.libraries.places.internal;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzbit implements zzazi {
    private zzbid zzA;
    private long zzB;
    private zzaxd zzC;
    private boolean zzD;
    private final zzawa zzc;
    private final Executor zzd;
    private final ScheduledExecutorService zzf;
    private final zzavu zzg;

    @Nullable
    private final zzbiu zzj;

    @Nullable
    private final zzbcv zzk;
    private final boolean zzl;
    private final zzbic zzn;
    private final long zzo;
    private final long zzp;

    @Nullable
    private final zzbis zzq;
    private zzbig zzw;
    private long zzx;
    private zzazk zzy;
    private zzbid zzz;
    static final zzavp zzh = zzavp.zzc("grpc-previous-rpc-attempts", zzavu.zzb);
    static final zzavp zzi = zzavp.zzc("grpc-retry-pushback-ms", zzavu.zzb);
    private static final zzaxd zza = zzaxd.zzb.zzg("Stream thrown away because RetriableStream committed");
    private static final Random zzb = new Random();
    private final Executor zze = new zzaxl(new zzbhl(this));
    private final Object zzm = new Object();
    private final zzbda zzr = new zzbda();
    private volatile zzbii zzs = new zzbii(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);
    private final AtomicBoolean zzt = new AtomicBoolean();
    private final AtomicInteger zzu = new AtomicInteger();
    private final AtomicInteger zzv = new AtomicInteger();

    zzbit(zzawa zzawaVar, zzavu zzavuVar, zzbic zzbicVar, long j, long j2, Executor executor, ScheduledExecutorService scheduledExecutorService, @Nullable zzbiu zzbiuVar, @Nullable zzbcv zzbcvVar, @Nullable zzbis zzbisVar) {
        this.zzc = zzawaVar;
        this.zzn = zzbicVar;
        this.zzo = j;
        this.zzp = j2;
        this.zzd = executor;
        this.zzf = scheduledExecutorService;
        this.zzg = zzavuVar;
        this.zzj = zzbiuVar;
        if (zzbiuVar != null) {
            this.zzB = zzbiuVar.zzb;
        }
        this.zzk = zzbcvVar;
        zzkt.zzf(zzbiuVar == null || zzbcvVar == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.zzl = zzbcvVar != null;
        this.zzq = zzbisVar;
    }

    static /* bridge */ /* synthetic */ void zzW(zzbit zzbitVar, zzbir zzbirVar) {
        Runnable runnableZzag = zzbitVar.zzag(zzbirVar);
        if (runnableZzag != null) {
            zzbitVar.zzd.execute(runnableZzag);
        }
    }

    static /* bridge */ /* synthetic */ void zzZ(zzbit zzbitVar, Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            zzbitVar.zzaj();
            return;
        }
        synchronized (zzbitVar.zzm) {
            zzbid zzbidVar = zzbitVar.zzA;
            if (zzbidVar == null) {
                return;
            }
            Future futureZza = zzbidVar.zza();
            zzbid zzbidVar2 = new zzbid(zzbitVar.zzm);
            zzbitVar.zzA = zzbidVar2;
            if (futureZza != null) {
                futureZza.cancel(false);
            }
            zzbidVar2.zzb(zzbitVar.zzf.schedule(new zzbif(zzbitVar, zzbidVar2), num.intValue(), TimeUnit.MILLISECONDS));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public final zzbir zzaf(int i, boolean z) {
        int i2;
        do {
            i2 = this.zzv.get();
            if (i2 < 0) {
                return null;
            }
        } while (!this.zzv.compareAndSet(i2, i2 + 1));
        zzbir zzbirVar = new zzbir(i);
        zzbhx zzbhxVar = new zzbhx(this, new zzbib(this, zzbirVar));
        zzavu zzavuVar = this.zzg;
        zzavu zzavuVar2 = new zzavu();
        zzavuVar2.zze(zzavuVar);
        if (i > 0) {
            zzavuVar2.zzf(zzh, String.valueOf(i));
        }
        zzbirVar.zza = zzb(zzavuVar2, zzbhxVar, i, z);
        return zzbirVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckReturnValue
    @Nullable
    public final Runnable zzag(zzbir zzbirVar) {
        List list;
        Collection collectionEmptyList;
        Future future;
        Future future2;
        synchronized (this.zzm) {
            if (this.zzs.zzf != null) {
                return null;
            }
            Collection collection = this.zzs.zzc;
            zzbii zzbiiVar = this.zzs;
            boolean z = true;
            zzkt.zzo(zzbiiVar.zzf == null, "Already committed");
            List list2 = zzbiiVar.zzb;
            if (zzbiiVar.zzc.contains(zzbirVar)) {
                list = null;
                collectionEmptyList = Collections.singleton(zzbirVar);
            } else {
                list = list2;
                collectionEmptyList = Collections.emptyList();
                z = false;
            }
            this.zzs = new zzbii(list, collectionEmptyList, zzbiiVar.zzd, zzbirVar, zzbiiVar.zzg, z, zzbiiVar.zzh, zzbiiVar.zze);
            this.zzn.zza(-this.zzx);
            zzbid zzbidVar = this.zzz;
            if (zzbidVar != null) {
                Future futureZza = zzbidVar.zza();
                this.zzz = null;
                future = futureZza;
            } else {
                future = null;
            }
            zzbid zzbidVar2 = this.zzA;
            if (zzbidVar2 != null) {
                Future futureZza2 = zzbidVar2.zza();
                this.zzA = null;
                future2 = futureZza2;
            } else {
                future2 = null;
            }
            return new zzbhm(this, collection, zzbirVar, future, future2);
        }
    }

    private final void zzah(zzbia zzbiaVar) {
        Collection collection;
        synchronized (this.zzm) {
            if (!this.zzs.zza) {
                this.zzs.zzb.add(zzbiaVar);
            }
            collection = this.zzs.zzc;
        }
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            zzbiaVar.zza((zzbir) it2.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008b, code lost:
    
        r2 = r3.size();
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
    
        if (r5 >= r2) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0092, code lost:
    
        r6 = (com.google.android.libraries.places.internal.zzbia) r3.get(r5);
        r6.zza(r10);
        r4 = r4 | (r6 instanceof com.google.android.libraries.places.internal.zzbih);
        r6 = r9.zzs;
        r8 = r6.zzf;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00a2, code lost:
    
        if (r8 == null) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a4, code lost:
    
        if (r8 != r10) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a6, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00aa, code lost:
    
        if (r6.zzg == false) goto L61;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzai(zzbir zzbirVar) {
        int iMin;
        zzbhy zzbhyVar = null;
        int i = 0;
        boolean z = false;
        ArrayList arrayList = null;
        while (true) {
            synchronized (this.zzm) {
                zzbii zzbiiVar = this.zzs;
                zzbir zzbirVar2 = zzbiiVar.zzf;
                if (zzbirVar2 == null || zzbirVar2 == zzbirVar) {
                    if (!zzbiiVar.zzg) {
                        if (i == zzbiiVar.zzb.size()) {
                            this.zzs = zzbiiVar.zzc(zzbirVar);
                            if (!zzp()) {
                                return;
                            } else {
                                zzbhyVar = new zzbhy(this);
                            }
                        } else {
                            if (zzbirVar.zzb) {
                                return;
                            }
                            iMin = Math.min(i + 128, zzbiiVar.zzb.size());
                            if (arrayList == null) {
                                arrayList = new ArrayList(zzbiiVar.zzb.subList(i, iMin));
                            } else {
                                arrayList.clear();
                                arrayList.addAll(zzbiiVar.zzb.subList(i, iMin));
                            }
                        }
                    }
                }
            }
            i = iMin;
        }
        if (zzbhyVar != null) {
            zzaxl zzaxlVar = (zzaxl) this.zze;
            zzaxlVar.zzc(zzbhyVar);
            zzaxlVar.zzb();
        } else {
            if (!z) {
                zzbirVar.zza.zzo(new zzbiq(this, zzbirVar));
            }
            zzbirVar.zza.zzh(this.zzs.zzf == zzbirVar ? this.zzC : zza);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaj() {
        Future future;
        synchronized (this.zzm) {
            zzbid zzbidVar = this.zzA;
            future = null;
            if (zzbidVar != null) {
                Future futureZza = zzbidVar.zza();
                this.zzA = null;
                future = futureZza;
            }
            this.zzs = this.zzs.zzb();
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzak(zzaxd zzaxdVar, zzazj zzazjVar, zzavu zzavuVar) {
        this.zzw = new zzbig(zzaxdVar, zzazjVar, zzavuVar);
        if (this.zzv.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            zzaxl zzaxlVar = (zzaxl) this.zze;
            zzaxlVar.zzc(new zzbhz(this, zzaxdVar, zzazjVar, zzavuVar));
            zzaxlVar.zzb();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zzal(zzbii zzbiiVar) {
        return zzbiiVar.zzf == null && zzbiiVar.zze < this.zzk.zza && !zzbiiVar.zzh;
    }

    @CheckReturnValue
    @Nullable
    abstract zzaxd zza();

    final void zzab(Object obj) {
        zzbii zzbiiVar = this.zzs;
        if (zzbiiVar.zza) {
            zzbiiVar.zzf.zza.zzw(this.zzc.zzc(obj));
        } else {
            zzah(new zzbhw(this, obj));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final zzarv zzam() {
        throw null;
    }

    abstract zzazi zzb(zzavu zzavuVar, zzasl zzaslVar, int i, boolean z);

    abstract void zzc();

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzg(zzbda zzbdaVar) {
        zzbii zzbiiVar;
        synchronized (this.zzm) {
            zzbdaVar.zzb("closed", this.zzr);
            zzbiiVar = this.zzs;
        }
        if (zzbiiVar.zzf != null) {
            zzbda zzbdaVar2 = new zzbda();
            zzbiiVar.zzf.zza.zzg(zzbdaVar2);
            zzbdaVar.zzb("committed", zzbdaVar2);
            return;
        }
        zzbda zzbdaVar3 = new zzbda();
        for (zzbir zzbirVar : zzbiiVar.zzc) {
            zzbda zzbdaVar4 = new zzbda();
            zzbirVar.zza.zzg(zzbdaVar4);
            zzbdaVar3.zza(zzbdaVar4);
        }
        zzbdaVar.zzb(AbstractCircuitBreaker.PROPERTY_NAME, zzbdaVar3);
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzh(zzaxd zzaxdVar) {
        zzbir zzbirVar;
        zzbir zzbirVar2 = new zzbir(0);
        zzbirVar2.zza = new zzbgp();
        Runnable runnableZzag = zzag(zzbirVar2);
        if (runnableZzag != null) {
            synchronized (this.zzm) {
                this.zzs = this.zzs.zzc(zzbirVar2);
            }
            runnableZzag.run();
            zzak(zzaxdVar, zzazj.PROCESSED, new zzavu());
            return;
        }
        synchronized (this.zzm) {
            if (this.zzs.zzc.contains(this.zzs.zzf)) {
                zzbirVar = this.zzs.zzf;
            } else {
                this.zzC = zzaxdVar;
                zzbirVar = null;
            }
            zzbii zzbiiVar = this.zzs;
            this.zzs = new zzbii(zzbiiVar.zzb, zzbiiVar.zzc, zzbiiVar.zzd, zzbiiVar.zzf, true, zzbiiVar.zza, zzbiiVar.zzh, zzbiiVar.zze);
        }
        if (zzbirVar != null) {
            zzbirVar.zza.zzh(zzaxdVar);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzj() {
        zzah(new zzbhr(this));
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzk(zzatd zzatdVar) {
        zzah(new zzbho(this, zzatdVar));
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzl(zzatg zzatgVar) {
        zzah(new zzbhp(this, zzatgVar));
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzm(int i) {
        zzah(new zzbhs(this, i));
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzn(int i) {
        zzah(new zzbht(this, i));
    }

    @Override // com.google.android.libraries.places.internal.zzazi
    public final void zzo(zzazk zzazkVar) {
        zzbid zzbidVar;
        zzbis zzbisVar;
        this.zzy = zzazkVar;
        zzaxd zzaxdVarZza = zza();
        if (zzaxdVarZza != null) {
            zzh(zzaxdVarZza);
            return;
        }
        synchronized (this.zzm) {
            this.zzs.zzb.add(new zzbih(this));
        }
        zzbir zzbirVarZzaf = zzaf(0, false);
        if (zzbirVarZzaf == null) {
            return;
        }
        if (this.zzl) {
            synchronized (this.zzm) {
                this.zzs = this.zzs.zza(zzbirVarZzaf);
                zzbidVar = null;
                if (zzal(this.zzs) && ((zzbisVar = this.zzq) == null || zzbisVar.zza())) {
                    zzbidVar = new zzbid(this.zzm);
                    this.zzA = zzbidVar;
                }
            }
            if (zzbidVar != null) {
                zzbidVar.zzb(this.zzf.schedule(new zzbif(this, zzbidVar), this.zzk.zzb, TimeUnit.NANOSECONDS));
            }
        }
        zzai(zzbirVarZzaf);
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final boolean zzp() {
        Iterator it2 = this.zzs.zzc.iterator();
        while (it2.hasNext()) {
            if (((zzbir) it2.next()).zza.zzp()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzr() {
        zzbii zzbiiVar = this.zzs;
        if (zzbiiVar.zza) {
            zzbiiVar.zzf.zza.zzr();
        } else {
            zzah(new zzbhq(this));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzt() {
        zzah(new zzbhu(this));
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzu(int i) {
        zzbii zzbiiVar = this.zzs;
        if (zzbiiVar.zza) {
            zzbiiVar.zzf.zza.zzu(2);
        } else {
            zzah(new zzbhv(this, 2));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzv(zzass zzassVar) {
        zzah(new zzbhn(this, zzassVar));
    }

    @Override // com.google.android.libraries.places.internal.zzbju
    public final void zzw(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }
}
