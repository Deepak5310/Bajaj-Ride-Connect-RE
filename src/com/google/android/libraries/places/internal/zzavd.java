package com.google.android.libraries.places.internal;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzavd extends zzauq {
    private static final zzawe zza = zzawe.zza(new zzavc());

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("policy", zzd());
        zzknVarZzb.zzb("priority", 5);
        zzknVarZzb.zze("available", true);
        return zzknVarZzb.toString();
    }

    public abstract int zzb();

    public zzawe zzc(Map map) {
        throw null;
    }

    public abstract String zzd();

    public abstract boolean zze();
}
