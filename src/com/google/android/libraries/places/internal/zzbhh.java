package com.google.android.libraries.places.internal;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbhh implements Runnable {
    final /* synthetic */ zzbhk zza;

    /* synthetic */ zzbhh(zzbhk zzbhkVar, zzbhg zzbhgVar) {
        this.zza = zzbhkVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbhk zzbhkVar = this.zza;
        zzbhi zzbhiVar = null;
        if (!zzbhkVar.zzf) {
            zzbhkVar.zzg = null;
            return;
        }
        long jZzk = zzbhkVar.zzk();
        if (zzbhkVar.zze - jZzk > 0) {
            zzbhk zzbhkVar2 = this.zza;
            zzbhkVar2.zzg = zzbhkVar2.zza.schedule(new zzbhj(zzbhkVar2, zzbhiVar), zzbhkVar2.zze - jZzk, TimeUnit.NANOSECONDS);
        } else {
            this.zza.zzf = false;
            this.zza.zzg = null;
            this.zza.zzc.run();
        }
    }
}
