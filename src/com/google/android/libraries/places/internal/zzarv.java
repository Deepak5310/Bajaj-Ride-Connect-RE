package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzarv {
    public static final zzarv zza;
    private static final IdentityHashMap zzb;
    private final IdentityHashMap zzc;

    static {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        zzb = identityHashMap;
        zza = new zzarv(identityHashMap);
    }

    private zzarv(IdentityHashMap identityHashMap) {
        this.zzc = identityHashMap;
    }

    /* synthetic */ zzarv(IdentityHashMap identityHashMap, zzaru zzaruVar) {
        this.zzc = identityHashMap;
    }

    public static zzars zza() {
        return new zzars(zza, null);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzarv zzarvVar = (zzarv) obj;
        if (this.zzc.size() != zzarvVar.zzc.size()) {
            return false;
        }
        for (Map.Entry entry : this.zzc.entrySet()) {
            if (!zzarvVar.zzc.containsKey(entry.getKey()) || !zzkp.zza(entry.getValue(), zzarvVar.zzc.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int iHashCode = 0;
        for (Map.Entry entry : this.zzc.entrySet()) {
            iHashCode += Arrays.hashCode(new Object[]{entry.getKey(), entry.getValue()});
        }
        return iHashCode;
    }

    public final String toString() {
        return this.zzc.toString();
    }

    public final zzars zzb() {
        return new zzars(this, null);
    }

    @Nullable
    public final Object zzc(zzart zzartVar) {
        return this.zzc.get(zzartVar);
    }
}
