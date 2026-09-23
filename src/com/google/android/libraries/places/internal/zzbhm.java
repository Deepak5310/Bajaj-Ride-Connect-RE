package com.google.android.libraries.places.internal;

import java.util.Collection;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbhm implements Runnable {
    final /* synthetic */ Collection zza;
    final /* synthetic */ zzbir zzb;
    final /* synthetic */ Future zzc;
    final /* synthetic */ Future zzd;
    final /* synthetic */ zzbit zze;

    zzbhm(zzbit zzbitVar, Collection collection, zzbir zzbirVar, Future future, Future future2) {
        this.zze = zzbitVar;
        this.zza = collection;
        this.zzb = zzbirVar;
        this.zzc = future;
        this.zzd = future2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        for (zzbir zzbirVar : this.zza) {
            if (zzbirVar != this.zzb) {
                zzbirVar.zza.zzh(zzbit.zza);
            }
        }
        Future future = this.zzc;
        if (future != null) {
            future.cancel(false);
        }
        Future future2 = this.zzd;
        if (future2 != null) {
            future2.cancel(false);
        }
        this.zze.zzc();
    }
}
