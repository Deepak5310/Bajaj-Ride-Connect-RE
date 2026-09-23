package com.google.android.libraries.places.internal;

import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaxf extends RuntimeException {
    private final zzaxd zza;
    private final zzavu zzb;
    private final boolean zzc;

    public zzaxf(zzaxd zzaxdVar, @Nullable zzavu zzavuVar) {
        super(zzaxd.zzh(zzaxdVar), zzaxdVar.zzj());
        this.zza = zzaxdVar;
        this.zzb = zzavuVar;
        this.zzc = true;
        fillInStackTrace();
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        if (!this.zzc) {
            return this;
        }
        return super.fillInStackTrace();
    }

    public final zzaxd zza() {
        return this.zza;
    }
}
