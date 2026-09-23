package com.google.android.libraries.places.internal;

import androidx.core.app.NotificationCompat;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzayr extends zzbcg {
    final /* synthetic */ zzays zza;
    private final zzazw zzb;
    private final String zzc;
    private volatile zzaxd zze;
    private zzaxd zzf;
    private final AtomicInteger zzd = new AtomicInteger(-2147483647);
    private final zzbgo zzg = new zzayq(this);

    zzayr(zzays zzaysVar, zzazw zzazwVar, String str) {
        this.zza = zzaysVar;
        this.zzb = zzazwVar;
        zzkt.zzc(str, "authority");
        this.zzc = str;
    }

    @Override // com.google.android.libraries.places.internal.zzbcg, com.google.android.libraries.places.internal.zzazl
    public final zzazi zza(zzawa zzawaVar, zzavu zzavuVar, zzasa zzasaVar, zzaso[] zzasoVarArr) {
        return this.zzd.get() >= 0 ? new zzbcc(this.zze, zzazj.PROCESSED, zzasoVarArr) : this.zzb.zza(zzawaVar, zzavuVar, zzasaVar, zzasoVarArr);
    }

    @Override // com.google.android.libraries.places.internal.zzbcg
    protected final zzazw zzb() {
        return this.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzbcg, com.google.android.libraries.places.internal.zzbgc
    public final void zzd(zzaxd zzaxdVar) {
        zzkt.zzc(zzaxdVar, NotificationCompat.CATEGORY_STATUS);
        synchronized (this) {
            if (this.zzd.get() < 0) {
                this.zze = zzaxdVar;
                this.zzd.addAndGet(Integer.MAX_VALUE);
                if (this.zzd.get() != 0) {
                    this.zzf = zzaxdVar;
                } else {
                    super.zzd(zzaxdVar);
                }
            }
        }
    }
}
