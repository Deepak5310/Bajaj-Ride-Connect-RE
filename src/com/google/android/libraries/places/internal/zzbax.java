package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbax implements zzbgc {
    private final Executor zzc;
    private final zzaxl zzd;
    private Runnable zze;
    private Runnable zzf;
    private Runnable zzg;
    private zzbgb zzh;
    private zzaxd zzj;

    @Nullable
    private zzauz zzk;
    private long zzl;
    private final zzauf zza = zzauf.zzb(zzbax.class, null);
    private final Object zzb = new Object();

    @Nonnull
    private Collection zzi = new LinkedHashSet();

    zzbax(Executor executor, zzaxl zzaxlVar) {
        this.zzc = executor;
        this.zzd = zzaxlVar;
    }

    private final zzbaw zzo(zzauu zzauuVar, zzaso[] zzasoVarArr) {
        int size;
        zzbaw zzbawVar = new zzbaw(this, zzauuVar, zzasoVarArr, null);
        this.zzi.add(zzbawVar);
        synchronized (this.zzb) {
            size = this.zzi.size();
        }
        if (size == 1) {
            this.zzd.zzc(this.zze);
        }
        for (zzaso zzasoVar : zzasoVarArr) {
        }
        return zzbawVar;
    }

    @Override // com.google.android.libraries.places.internal.zzazl
    public final zzazi zza(zzawa zzawaVar, zzavu zzavuVar, zzasa zzasaVar, zzaso[] zzasoVarArr) {
        zzazi zzbccVar;
        try {
            zzbgx zzbgxVar = new zzbgx(zzawaVar, zzavuVar, zzasaVar);
            long j = -1;
            zzauz zzauzVar = null;
            while (true) {
                synchronized (this.zzb) {
                    zzaxd zzaxdVar = this.zzj;
                    if (zzaxdVar == null) {
                        zzauz zzauzVar2 = this.zzk;
                        if (zzauzVar2 != null) {
                            if (zzauzVar != null && j == this.zzl) {
                                zzbccVar = zzo(zzbgxVar, zzasoVarArr);
                                break;
                            }
                            j = this.zzl;
                            zzazl zzazlVarZzc = zzbcu.zzc(zzauzVar2.zza(zzbgxVar), zzasaVar.zzo());
                            if (zzazlVarZzc != null) {
                                zzbccVar = zzazlVarZzc.zza(zzbgxVar.zzc(), zzbgxVar.zzb(), zzbgxVar.zza(), zzasoVarArr);
                                break;
                            }
                            zzauzVar = zzauzVar2;
                        } else {
                            zzbccVar = zzo(zzbgxVar, zzasoVarArr);
                            break;
                        }
                    } else {
                        zzbccVar = new zzbcc(zzaxdVar, zzazj.PROCESSED, zzasoVarArr);
                        break;
                    }
                }
            }
            this.zzd.zzb();
            return zzbccVar;
        } catch (Throwable th) {
            this.zzd.zzb();
            throw th;
        }
    }

    @Override // com.google.android.libraries.places.internal.zzauk
    public final zzauf zzc() {
        return this.zza;
    }

    @Override // com.google.android.libraries.places.internal.zzbgc
    public final void zzd(zzaxd zzaxdVar) {
        Runnable runnable;
        synchronized (this.zzb) {
            if (this.zzj != null) {
                return;
            }
            this.zzj = zzaxdVar;
            this.zzd.zzc(new zzbau(this, zzaxdVar));
            if (!zzn() && (runnable = this.zzg) != null) {
                this.zzd.zzc(runnable);
                this.zzg = null;
            }
            this.zzd.zzb();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbgc
    public final Runnable zzj(zzbgb zzbgbVar) {
        this.zzh = zzbgbVar;
        this.zze = new zzbar(this, zzbgbVar);
        this.zzf = new zzbas(this, zzbgbVar);
        this.zzg = new zzbat(this, zzbgbVar);
        return null;
    }

    final void zzm(@Nullable zzauz zzauzVar) {
        Runnable runnable;
        synchronized (this.zzb) {
            this.zzk = zzauzVar;
            this.zzl++;
            if (zzauzVar != null && zzn()) {
                ArrayList arrayList = new ArrayList(this.zzi);
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    zzbaw zzbawVar = (zzbaw) arrayList.get(i);
                    zzaut zzautVarZza = zzauzVar.zza(zzbawVar.zzb);
                    zzasa zzasaVarZza = zzbawVar.zzb.zza();
                    zzazl zzazlVarZzc = zzbcu.zzc(zzautVarZza, zzasaVarZza.zzo());
                    if (zzazlVarZzc != null) {
                        Executor executorZzn = this.zzc;
                        if (zzasaVarZza.zzn() != null) {
                            executorZzn = zzasaVarZza.zzn();
                        }
                        Runnable runnableZzb = zzbaw.zzb(zzbawVar, zzazlVarZzc);
                        if (runnableZzb != null) {
                            executorZzn.execute(runnableZzb);
                        }
                        arrayList2.add(zzbawVar);
                    }
                }
                synchronized (this.zzb) {
                    if (zzn()) {
                        this.zzi.removeAll(arrayList2);
                        if (this.zzi.isEmpty()) {
                            this.zzi = new LinkedHashSet();
                        }
                        if (!zzn()) {
                            this.zzd.zzc(this.zzf);
                            if (this.zzj != null && (runnable = this.zzg) != null) {
                                this.zzd.zzc(runnable);
                                this.zzg = null;
                            }
                        }
                        this.zzd.zzb();
                    }
                }
            }
        }
    }

    public final boolean zzn() {
        boolean z;
        synchronized (this.zzb) {
            z = !this.zzi.isEmpty();
        }
        return z;
    }
}
