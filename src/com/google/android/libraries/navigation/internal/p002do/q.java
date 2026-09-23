package com.google.android.libraries.navigation.internal.p002do;

import com.google.android.libraries.navigation.internal.nq.a;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q {
    private long b;
    private float c = -1.0f;
    public float a = -1.0f;

    public final void a(float f) {
        this.c = a.d(f);
        if (this.a == -1.0f || this.b == 0) {
            this.a = f;
        }
    }

    public final void b(long j) {
        if (c()) {
            this.b = j;
            return;
        }
        long j2 = this.b;
        long jMin = 0;
        if (j2 == 0) {
            jMin = 16;
        } else {
            long j3 = j - j2;
            if (j3 > 0) {
                jMin = Math.min(j3, 40L);
            }
        }
        this.b = j;
        float f = this.a;
        float fD = this.c;
        float fE = a.e(fD - f);
        if (Math.abs(fE) > 0.05f) {
            fD = a.d(f + (fE * (jMin / 1000.0f) * 10.0f));
        }
        this.a = fD;
    }

    public final boolean c() {
        return Math.abs(this.a - this.c) < 1.0E-4f;
    }
}
