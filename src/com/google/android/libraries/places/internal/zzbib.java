package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbib extends zzaso {
    long zzb;
    final /* synthetic */ zzbit zzc;
    private final zzbir zzd;

    zzbib(zzbit zzbitVar, zzbir zzbirVar) {
        this.zzc = zzbitVar;
        this.zzd = zzbirVar;
    }

    @Override // com.google.android.libraries.places.internal.zzaxg
    public final void zza(long j) {
        if (this.zzc.zzs.zzf != null) {
            return;
        }
        synchronized (this.zzc.zzm) {
            if (this.zzc.zzs.zzf == null) {
                zzbir zzbirVar = this.zzd;
                if (!zzbirVar.zzb) {
                    long j2 = this.zzb + j;
                    this.zzb = j2;
                    zzbit zzbitVar = this.zzc;
                    if (j2 <= zzbitVar.zzx) {
                        return;
                    }
                    if (j2 > zzbitVar.zzo) {
                        zzbirVar.zzc = true;
                    } else {
                        long jZza = zzbitVar.zzn.zza(j2 - zzbitVar.zzx);
                        this.zzc.zzx = this.zzb;
                        if (jZza > this.zzc.zzp) {
                            this.zzd.zzc = true;
                        }
                    }
                    zzbir zzbirVar2 = this.zzd;
                    Runnable runnableZzag = zzbirVar2.zzc ? this.zzc.zzag(zzbirVar2) : null;
                    if (runnableZzag != null) {
                        runnableZzag.run();
                    }
                }
            }
        }
    }
}
