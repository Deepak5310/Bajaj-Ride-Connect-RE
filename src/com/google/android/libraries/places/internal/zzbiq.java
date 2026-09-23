package com.google.android.libraries.places.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbiq implements zzazk {
    final zzbir zza;
    final /* synthetic */ zzbit zzb;

    zzbiq(zzbit zzbitVar, zzbir zzbirVar) {
        this.zzb = zzbitVar;
        this.zza = zzbirVar;
    }

    @Nullable
    private static final Integer zza(zzavu zzavuVar) {
        String str = (String) zzavuVar.zzb(zzbit.zzi);
        if (str == null) {
            return null;
        }
        try {
            return Integer.valueOf(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    /* JADX WARN: Code duplicated, block: B:82:0x01db  */
    @Override // com.google.android.libraries.places.internal.zzazk
    public final void zzd(zzaxd zzaxdVar, zzazj zzazjVar, zzavu zzavuVar) {
        long nanos;
        boolean z;
        zzbid zzbidVar;
        synchronized (this.zzb.zzm) {
            zzbit zzbitVar = this.zzb;
            zzbii zzbiiVar = zzbitVar.zzs;
            zzbir zzbirVar = this.zza;
            zzbirVar.zzb = true;
            if (zzbiiVar.zzc.contains(zzbirVar)) {
                ArrayList arrayList = new ArrayList(zzbiiVar.zzc);
                arrayList.remove(zzbirVar);
                zzbiiVar = new zzbii(zzbiiVar.zzb, Collections.unmodifiableCollection(arrayList), zzbiiVar.zzd, zzbiiVar.zzf, zzbiiVar.zzg, zzbiiVar.zza, zzbiiVar.zzh, zzbiiVar.zze);
            }
            zzbitVar.zzs = zzbiiVar;
            this.zzb.zzr.zza(zzaxdVar.zza());
        }
        if (this.zzb.zzv.decrementAndGet() == Integer.MIN_VALUE) {
            zzaxl zzaxlVar = (zzaxl) this.zzb.zze;
            zzaxlVar.zzc(new zzbim(this));
            zzaxlVar.zzb();
            return;
        }
        zzbir zzbirVar2 = this.zza;
        if (zzbirVar2.zzc) {
            zzbit.zzW(this.zzb, zzbirVar2);
            if (this.zzb.zzs.zzf == this.zza) {
                this.zzb.zzak(zzaxdVar, zzazjVar, zzavuVar);
                return;
            }
            return;
        }
        if (zzazjVar == zzazj.MISCARRIED && this.zzb.zzu.incrementAndGet() > 1000) {
            zzbit.zzW(this.zzb, this.zza);
            if (this.zzb.zzs.zzf == this.zza) {
                this.zzb.zzak(zzaxd.zzo.zzg("Too many transparent retries. Might be a bug in gRPC").zzf(new zzaxf(zzaxdVar, null)), zzazjVar, zzavuVar);
                return;
            }
            return;
        }
        if (this.zzb.zzs.zzf == null) {
            if (zzazjVar == zzazj.MISCARRIED || (zzazjVar == zzazj.REFUSED && this.zzb.zzt.compareAndSet(false, true))) {
                zzbir zzbirVarZzaf = this.zzb.zzaf(this.zza.zzd, true);
                if (zzbirVarZzaf != null) {
                    zzbit zzbitVar2 = this.zzb;
                    if (zzbitVar2.zzl) {
                        synchronized (zzbitVar2.zzm) {
                            zzbit zzbitVar3 = this.zzb;
                            zzbii zzbiiVar2 = zzbitVar3.zzs;
                            zzbir zzbirVar3 = this.zza;
                            ArrayList arrayList2 = new ArrayList(zzbiiVar2.zzd);
                            arrayList2.remove(zzbirVar3);
                            arrayList2.add(zzbirVarZzaf);
                            zzbitVar3.zzs = new zzbii(zzbiiVar2.zzb, zzbiiVar2.zzc, Collections.unmodifiableCollection(arrayList2), zzbiiVar2.zzf, zzbiiVar2.zzg, zzbiiVar2.zza, zzbiiVar2.zzh, zzbiiVar2.zze);
                        }
                    }
                    this.zzb.zzd.execute(new zzbin(this, zzbirVarZzaf));
                    return;
                }
                return;
            }
            if (zzazjVar == zzazj.DROPPED) {
                zzbit zzbitVar4 = this.zzb;
                if (zzbitVar4.zzl) {
                    zzbitVar4.zzaj();
                }
            } else {
                this.zzb.zzt.set(true);
                zzbit zzbitVar5 = this.zzb;
                if (zzbitVar5.zzl) {
                    Integer numZza = zza(zzavuVar);
                    boolean zContains = this.zzb.zzk.zzc.contains(zzaxdVar.zza());
                    boolean z2 = (this.zzb.zzq == null || (!zContains && (numZza == null || numZza.intValue() >= 0))) ? false : !this.zzb.zzq.zzb();
                    if (zContains && !z2 && !zzaxdVar.zzl() && numZza != null && numZza.intValue() > 0) {
                        numZza = 0;
                    }
                    boolean z3 = zContains && !z2;
                    if (z3) {
                        zzbit.zzZ(this.zzb, numZza);
                    }
                    synchronized (this.zzb.zzm) {
                        zzbit zzbitVar6 = this.zzb;
                        zzbii zzbiiVar3 = zzbitVar6.zzs;
                        zzbir zzbirVar4 = this.zza;
                        ArrayList arrayList3 = new ArrayList(zzbiiVar3.zzd);
                        arrayList3.remove(zzbirVar4);
                        zzbitVar6.zzs = new zzbii(zzbiiVar3.zzb, zzbiiVar3.zzc, Collections.unmodifiableCollection(arrayList3), zzbiiVar3.zzf, zzbiiVar3.zzg, zzbiiVar3.zza, zzbiiVar3.zzh, zzbiiVar3.zze);
                        if (z3) {
                            zzbit zzbitVar7 = this.zzb;
                            if (zzbitVar7.zzal(zzbitVar7.zzs) || !this.zzb.zzs.zzd.isEmpty()) {
                                return;
                            }
                        }
                    }
                } else {
                    long j = 0;
                    if (zzbitVar5.zzj == null) {
                        z = false;
                    } else {
                        boolean zContains2 = zzbitVar5.zzj.zzf.contains(zzaxdVar.zza());
                        Integer numZza2 = zza(zzavuVar);
                        boolean z4 = (this.zzb.zzq == null || (!zContains2 && (numZza2 == null || numZza2.intValue() >= 0))) ? false : !this.zzb.zzq.zzb();
                        zzbit zzbitVar8 = this.zzb;
                        if (zzbitVar8.zzj.zza <= this.zza.zzd + 1 || z4) {
                            z = false;
                        } else if (numZza2 == null) {
                            if (zContains2) {
                                double dNextDouble = zzbitVar8.zzB * zzbit.zzb.nextDouble();
                                zzbit zzbitVar9 = this.zzb;
                                zzbitVar9.zzB = Math.min((long) (zzbitVar9.zzB * zzbitVar9.zzj.zzd), zzbitVar9.zzj.zzc);
                                nanos = (long) dNextDouble;
                                j = nanos;
                                z = true;
                            } else {
                                z = false;
                            }
                        } else if (numZza2.intValue() >= 0) {
                            nanos = TimeUnit.MILLISECONDS.toNanos(numZza2.intValue());
                            zzbit zzbitVar10 = this.zzb;
                            zzbitVar10.zzB = zzbitVar10.zzj.zzb;
                            j = nanos;
                            z = true;
                        } else {
                            z = false;
                        }
                    }
                    if (z) {
                        zzbir zzbirVarZzaf2 = this.zzb.zzaf(this.zza.zzd + 1, false);
                        if (zzbirVarZzaf2 != null) {
                            synchronized (this.zzb.zzm) {
                                zzbit zzbitVar11 = this.zzb;
                                zzbidVar = new zzbid(zzbitVar11.zzm);
                                zzbitVar11.zzz = zzbidVar;
                            }
                            zzbidVar.zzb(this.zzb.zzf.schedule(new zzbil(this, zzbirVarZzaf2), j, TimeUnit.NANOSECONDS));
                            return;
                        }
                        return;
                    }
                }
            }
        }
        zzbit.zzW(this.zzb, this.zza);
        if (this.zzb.zzs.zzf == this.zza) {
            this.zzb.zzak(zzaxdVar, zzazjVar, zzavuVar);
        }
    }

    @Override // com.google.android.libraries.places.internal.zzazk
    public final void zze(zzavu zzavuVar) {
        int i;
        int i2;
        if (this.zza.zzd > 0) {
            zzavuVar.zzd(zzbit.zzh);
            zzavuVar.zzf(zzbit.zzh, String.valueOf(this.zza.zzd));
        }
        zzbit.zzW(this.zzb, this.zza);
        if (this.zzb.zzs.zzf == this.zza) {
            zzbit zzbitVar = this.zzb;
            if (zzbitVar.zzq != null) {
                zzbis zzbisVar = zzbitVar.zzq;
                do {
                    i = zzbisVar.zzd.get();
                    i2 = zzbisVar.zza;
                    if (i == i2) {
                        break;
                    }
                } while (!zzbisVar.zzd.compareAndSet(i, Math.min(zzbisVar.zzc + i, i2)));
            }
            zzaxl zzaxlVar = (zzaxl) this.zzb.zze;
            zzaxlVar.zzc(new zzbij(this, zzavuVar));
            zzaxlVar.zzb();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbjw
    public final void zzf(zzbjv zzbjvVar) {
        zzbii zzbiiVar = this.zzb.zzs;
        zzkt.zzo(zzbiiVar.zzf != null, "Headers should be received prior to messages.");
        if (zzbiiVar.zzf != this.zza) {
            zzbcu.zzh(zzbjvVar);
            return;
        }
        zzaxl zzaxlVar = (zzaxl) this.zzb.zze;
        zzaxlVar.zzc(new zzbio(this, zzbjvVar));
        zzaxlVar.zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbjw
    public final void zzg() {
        if (this.zzb.zzp()) {
            zzaxl zzaxlVar = (zzaxl) this.zzb.zze;
            zzaxlVar.zzc(new zzbip(this));
            zzaxlVar.zzb();
        }
    }
}
