package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzds extends zzdu {
    private final long zza;
    private final long zzb;

    zzds(long j, long j2) {
        this.zza = j;
        this.zzb = j2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzdu) {
            zzdu zzduVar = (zzdu) obj;
            if (this.zza == zzduVar.zza() && this.zzb == zzduVar.zzb()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.zzb;
        long j2 = this.zza;
        return ((int) (j ^ (j >>> 32))) ^ ((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "PrimesInstant{elapsedRealtimeMs=" + this.zza + ", uptimeMillis=" + this.zzb + "}";
    }

    @Override // com.google.android.libraries.places.internal.zzdu
    public final long zza() {
        return this.zza;
    }

    @Override // com.google.android.libraries.places.internal.zzdu
    public final long zzb() {
        return this.zzb;
    }
}
