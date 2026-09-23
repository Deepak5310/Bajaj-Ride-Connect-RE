package com.google.android.libraries.places.internal;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbie implements Runnable {
    final /* synthetic */ zzbir zza;
    final /* synthetic */ zzbif zzb;

    zzbie(zzbif zzbifVar, zzbir zzbirVar) {
        this.zzb = zzbifVar;
        this.zza = zzbirVar;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0057 A[Catch: all -> 0x00b9, TryCatch #0 {, blocks: (B:4:0x0009, B:16:0x006e, B:7:0x0014, B:9:0x0032, B:11:0x003c, B:13:0x0046, B:14:0x0057), top: B:27:0x0009 }] */
    @Override // java.lang.Runnable
    public final void run() {
        zzbid zzbidVar;
        boolean z;
        synchronized (this.zzb.zzb.zzm) {
            zzbif zzbifVar = this.zzb;
            zzbidVar = null;
            if (zzbifVar.zza.zzc) {
                z = true;
            } else {
                zzbit zzbitVar = zzbifVar.zzb;
                zzbitVar.zzs = zzbitVar.zzs.zza(this.zza);
                zzbit zzbitVar2 = this.zzb.zzb;
                if (zzbitVar2.zzal(zzbitVar2.zzs)) {
                    zzbit zzbitVar3 = this.zzb.zzb;
                    if (zzbitVar3.zzq == null || zzbitVar3.zzq.zza()) {
                        zzbit zzbitVar4 = this.zzb.zzb;
                        zzbidVar = new zzbid(zzbitVar4.zzm);
                        zzbitVar4.zzA = zzbidVar;
                    } else {
                        zzbit zzbitVar5 = this.zzb.zzb;
                        zzbitVar5.zzs = zzbitVar5.zzs.zzb();
                        this.zzb.zzb.zzA = null;
                    }
                } else {
                    zzbit zzbitVar6 = this.zzb.zzb;
                    zzbitVar6.zzs = zzbitVar6.zzs.zzb();
                    this.zzb.zzb.zzA = null;
                }
                z = false;
            }
        }
        if (z) {
            zzbir zzbirVar = this.zza;
            zzbirVar.zza.zzo(new zzbiq(this.zzb.zzb, zzbirVar));
            this.zza.zza.zzh(zzaxd.zzb.zzg("Unneeded hedging"));
            return;
        }
        if (zzbidVar != null) {
            zzbit zzbitVar7 = this.zzb.zzb;
            zzbidVar.zzb(zzbitVar7.zzf.schedule(new zzbif(zzbitVar7, zzbidVar), zzbitVar7.zzk.zzb, TimeUnit.NANOSECONDS));
        }
        this.zzb.zzb.zzai(this.zza);
    }
}
