package com.google.android.libraries.places.internal;

import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbjr {
    private static final zzbjr zza = new zzbjr(new zzbjn());
    private final IdentityHashMap zzb = new IdentityHashMap();
    private ScheduledExecutorService zzc;
    private final zzbjn zzd;

    zzbjr(zzbjn zzbjnVar) {
        this.zzd = zzbjnVar;
    }

    public static Object zza(zzbjq zzbjqVar) {
        return zza.zzb(zzbjqVar);
    }

    public static Object zzc(zzbjq zzbjqVar, Object obj) {
        zza.zzd(zzbjqVar, obj);
        return null;
    }

    final synchronized Object zzb(zzbjq zzbjqVar) {
        zzbjp zzbjpVar;
        zzbjpVar = (zzbjp) this.zzb.get(zzbjqVar);
        if (zzbjpVar == null) {
            zzbjpVar = new zzbjp(zzbjqVar.zza());
            this.zzb.put(zzbjqVar, zzbjpVar);
        }
        ScheduledFuture scheduledFuture = zzbjpVar.zzc;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            zzbjpVar.zzc = null;
        }
        zzbjpVar.zzb++;
        return zzbjpVar.zza;
    }

    final synchronized Object zzd(zzbjq zzbjqVar, Object obj) {
        zzbjp zzbjpVar = (zzbjp) this.zzb.get(zzbjqVar);
        if (zzbjpVar == null) {
            throw new IllegalArgumentException("No cached instance found for ".concat(String.valueOf(String.valueOf(zzbjqVar))));
        }
        zzkt.zzf(obj == zzbjpVar.zza, "Releasing the wrong instance");
        zzkt.zzo(zzbjpVar.zzb > 0, "Refcount has already reached zero");
        int i = zzbjpVar.zzb - 1;
        zzbjpVar.zzb = i;
        if (i == 0) {
            zzkt.zzo(zzbjpVar.zzc == null, "Destroy task already scheduled");
            if (this.zzc == null) {
                this.zzc = Executors.newSingleThreadScheduledExecutor(zzbcu.zzg("grpc-shared-destroyer-%d", true));
            }
            zzbjpVar.zzc = this.zzc.schedule(new zzbdz(new zzbjo(this, zzbjpVar, zzbjqVar, obj)), 1L, TimeUnit.SECONDS);
        }
        return null;
    }
}
