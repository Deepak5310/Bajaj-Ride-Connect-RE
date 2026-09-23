package com.google.android.libraries.places.internal;

import java.util.Arrays;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbiu {
    final int zza;
    final long zzb;
    final long zzc;
    final double zzd;

    @Nullable
    final Long zze;
    final Set zzf;

    zzbiu(int i, long j, long j2, double d, @Nullable Long l, @Nonnull Set set) {
        this.zza = i;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = d;
        this.zze = l;
        this.zzf = zzmb.zzj(set);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbiu)) {
            return false;
        }
        zzbiu zzbiuVar = (zzbiu) obj;
        return this.zza == zzbiuVar.zza && this.zzb == zzbiuVar.zzb && this.zzc == zzbiuVar.zzc && Double.compare(this.zzd, zzbiuVar.zzd) == 0 && zzkp.zza(this.zze, zzbiuVar.zze) && zzkp.zza(this.zzf, zzbiuVar.zzf);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Long.valueOf(this.zzb), Long.valueOf(this.zzc), Double.valueOf(this.zzd), this.zze, this.zzf});
    }

    public final String toString() {
        zzkn zzknVarZzb = zzko.zzb(this);
        zzknVarZzb.zzb("maxAttempts", this.zza);
        zzknVarZzb.zzc("initialBackoffNanos", this.zzb);
        zzknVarZzb.zzc("maxBackoffNanos", this.zzc);
        zzknVarZzb.zza("backoffMultiplier", this.zzd);
        zzknVarZzb.zzd("perAttemptRecvTimeoutNanos", this.zze);
        zzknVarZzb.zzd("retryableStatusCodes", this.zzf);
        return zzknVarZzb.toString();
    }
}
