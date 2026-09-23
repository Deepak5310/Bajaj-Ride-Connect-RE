package com.google.android.libraries.places.internal;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzazg implements Runnable {
    final /* synthetic */ zzazh zza;
    private final long zzb;

    zzazg(zzazh zzazhVar, long j) {
        this.zza = zzazhVar;
        this.zzb = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbda zzbdaVar = new zzbda();
        this.zza.zzm.zzg(zzbdaVar);
        long jAbs = Math.abs(this.zzb) / TimeUnit.SECONDS.toNanos(1L);
        long jAbs2 = Math.abs(this.zzb) % TimeUnit.SECONDS.toNanos(1L);
        StringBuilder sb = new StringBuilder("deadline exceeded after ");
        if (this.zzb < 0) {
            sb.append('-');
        }
        sb.append(jAbs);
        sb.append(String.format(Locale.US, ".%09d", Long.valueOf(jAbs2)));
        sb.append("s. ");
        Long l = (Long) this.zza.zzl.zzl(zzaso.zza);
        sb.append(String.format(Locale.US, "Name resolution delay %.9f seconds. ", Double.valueOf(l == null ? 0.0d : l.longValue() / zzazh.zzc)));
        sb.append(zzbdaVar);
        this.zza.zzm.zzh(zzaxd.zze.zzc(sb.toString()));
    }
}
