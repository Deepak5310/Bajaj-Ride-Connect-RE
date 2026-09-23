package com.google.android.libraries.navigation.internal.km;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements com.google.android.libraries.navigation.internal.ky.ab {
    private final long a;
    private final long b;
    private final long c;

    public a(long j, long j2, int i) {
        com.google.android.libraries.navigation.internal.yx.ar.a(true);
        com.google.android.libraries.navigation.internal.yx.ar.a(true);
        com.google.android.libraries.navigation.internal.yx.ar.a(true);
        this.a = j;
        this.b = j2;
        this.c = (-1) << (64 - i);
    }

    private final long b(long j) {
        return j & (this.c >>> Long.numberOfLeadingZeros(j));
    }

    /* JADX WARN: Code duplicated, block: B:8:0x000e A[PHI: r0
      0x000e: PHI (r0v1 long) = (r0v0 long), (r0v4 long) binds: [B:3:0x0004, B:6:0x000b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.libraries.navigation.internal.ky.ab
    public final long a(long j) {
        long j2 = this.a;
        if (j < j2) {
            j = j2;
        } else {
            j2 = this.b;
            if (j > j2) {
                j = j2;
            }
        }
        return j < 0 ? -b(1L) : b(j);
    }
}
