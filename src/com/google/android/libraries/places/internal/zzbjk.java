package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbjk {
    private final String zza;
    private final Map zzb;

    public zzbjk(String str, Map map) {
        zzkt.zzc(str, "policyName");
        this.zza = str;
        zzkt.zzc(map, "rawConfigValue");
        this.zzb = map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbjk) {
            zzbjk zzbjkVar = (zzbjk) obj;
            if (this.zza.equals(zzbjkVar.zza) && this.zzb.equals(zzbjkVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb});
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzd("policyName", this.zza);
        zzknVarZzb.zzd("rawConfigValue", this.zzb);
        return zzknVarZzb.toString();
    }

    public final String zza() {
        return this.zza;
    }

    public final Map zzb() {
        return this.zzb;
    }
}
