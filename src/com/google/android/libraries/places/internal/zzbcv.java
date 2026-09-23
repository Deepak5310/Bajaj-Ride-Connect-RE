package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbcv {
    final int zza;
    final long zzb;
    final Set zzc;

    zzbcv(int i, long j, Set set) {
        this.zza = i;
        this.zzb = j;
        this.zzc = zzmb.zzj(set);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzbcv zzbcvVar = (zzbcv) obj;
            if (this.zza == zzbcvVar.zza && this.zzb == zzbcvVar.zzb && zzkp.zza(this.zzc, zzbcvVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc});
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzb("maxAttempts", this.zza);
        zzknVarZzb.zzc("hedgingDelayNanos", this.zzb);
        zzknVarZzb.zzd("nonFatalStatusCodes", this.zzc);
        return zzknVarZzb.toString();
    }
}
