package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: com.google.android.libraries.places:places@@3.3.0 */
/* JADX INFO: loaded from: classes2.dex */
public enum zzawy {
    OK(0),
    CANCELLED(1),
    UNKNOWN(2),
    INVALID_ARGUMENT(3),
    DEADLINE_EXCEEDED(4),
    NOT_FOUND(5),
    ALREADY_EXISTS(6),
    PERMISSION_DENIED(7),
    RESOURCE_EXHAUSTED(8),
    FAILED_PRECONDITION(9),
    ABORTED(10),
    OUT_OF_RANGE(11),
    UNIMPLEMENTED(12),
    INTERNAL(13),
    UNAVAILABLE(14),
    DATA_LOSS(15),
    UNAUTHENTICATED(16);

    private final int zzs;
    private final byte[] zzt;

    zzawy(int i) {
        this.zzs = i;
        this.zzt = Integer.toString(i).getBytes(zzkc.zza);
    }

    public final int zza() {
        return this.zzs;
    }

    public final zzaxd zzb() {
        return (zzaxd) zzaxd.zzt.get(this.zzs);
    }
}
