package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class az {
    public long a;
    public long b;

    public az(boolean z) {
        this.a = true != z ? -1L : -2L;
        this.b = true != z ? -2L : -1L;
    }

    public final float a(long j) {
        long j2 = this.a;
        return Math.max(Math.min(1.0f, (j - j2) / (this.b - j2)), 0.0f);
    }

    public final void b(long j, long j2) {
        long j3 = this.a;
        if (j3 >= 0) {
            long j4 = this.b;
            if (j4 >= 0 && j4 >= j3) {
                return;
            }
        }
        long jMax = j - Math.max(j3 - j, 0L);
        this.a = jMax;
        this.b = jMax + j2;
    }

    public final boolean c(long j) {
        return j >= this.a && j >= this.b;
    }
}
