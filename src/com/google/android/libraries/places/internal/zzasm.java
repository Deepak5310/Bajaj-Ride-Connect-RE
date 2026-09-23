package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzasm {
    private zzasa zza = zzasa.zza;
    private int zzb;
    private boolean zzc;

    zzasm() {
    }

    public final zzasm zza(zzasa zzasaVar) {
        zzkt.zzc(zzasaVar, "callOptions cannot be null");
        this.zza = zzasaVar;
        return this;
    }

    public final zzasm zzb(boolean z) {
        this.zzc = z;
        return this;
    }

    public final zzasm zzc(int i) {
        this.zzb = i;
        return this;
    }

    public final zzasn zzd() {
        return new zzasn(this.zza, this.zzb, this.zzc);
    }
}
