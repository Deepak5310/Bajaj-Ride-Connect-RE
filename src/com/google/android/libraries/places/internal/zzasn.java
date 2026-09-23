package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzasn {
    private final zzasa zza;
    private final int zzb;
    private final boolean zzc;

    zzasn(zzasa zzasaVar, int i, boolean z) {
        zzkt.zzc(zzasaVar, "callOptions");
        this.zza = zzasaVar;
        this.zzb = i;
        this.zzc = z;
    }

    public static zzasm zza() {
        return new zzasm();
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("callOptions", this.zza);
        zzknVarZzb.zzb("previousAttempts", this.zzb);
        zzknVarZzb.zze("isTransparentRetry", this.zzc);
        return zzknVarZzb.toString();
    }
}
