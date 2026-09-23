package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzic {
    abstract zzic zzb(int i);

    abstract zzid zzc();

    public abstract zzic zzd(int i);

    public final zzid zze() {
        zzid zzidVarZzc = zzc();
        zzkt.zzo(!zzidVarZzc.zzb().isEmpty(), "Package name must not be empty.");
        return zzidVarZzc;
    }
}
