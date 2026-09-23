package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbif implements Runnable {
    final zzbid zza;
    final /* synthetic */ zzbit zzb;

    zzbif(zzbit zzbitVar, zzbid zzbidVar) {
        this.zzb = zzbitVar;
        this.zza = zzbidVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbir zzbirVarZzaf = this.zzb.zzaf(this.zzb.zzs.zze, false);
        if (zzbirVarZzaf == null) {
            return;
        }
        this.zzb.zzd.execute(new zzbie(this, zzbirVarZzaf));
    }
}
