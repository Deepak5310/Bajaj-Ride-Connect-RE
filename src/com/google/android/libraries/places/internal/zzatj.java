package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzatj extends zzavh {
    protected zzatj() {
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("delegate", zzb());
        return zzknVarZzb.toString();
    }

    @Override // com.google.android.libraries.places.internal.zzavh
    public final zzavg zza() {
        return zzb().zza();
    }

    protected abstract zzavh zzb();
}
