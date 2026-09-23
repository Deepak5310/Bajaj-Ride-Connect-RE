package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbgu extends zzauz {
    final /* synthetic */ zzbgv zza;
    private final zzauy zzb;
    private final AtomicBoolean zzc = new AtomicBoolean(false);

    zzbgu(zzbgv zzbgvVar, zzauy zzauyVar) {
        this.zza = zzbgvVar;
        this.zzb = zzauyVar;
    }

    @Override // com.google.android.libraries.places.internal.zzauz
    public final zzaut zza(zzauu zzauuVar) {
        if (this.zzc.compareAndSet(false, true)) {
            zzaxl zzaxlVarZzb = this.zza.zzc.zzb();
            zzaxlVarZzb.zzc(new zzbgt(this));
            zzaxlVarZzb.zzb();
        }
        return zzaut.zzc();
    }
}
