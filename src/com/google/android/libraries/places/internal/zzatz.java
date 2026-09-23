package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzatz {
    private Object zza;

    private zzatz() {
    }

    /* synthetic */ zzatz(zzaty zzatyVar) {
    }

    public final zzatz zza(Object obj) {
        this.zza = obj;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzaub zzb() {
        zzkt.zzo(this.zza != null, "config is not set");
        return new zzaub(zzaxd.zza, this.zza, null, 0 == true ? 1 : 0);
    }
}
