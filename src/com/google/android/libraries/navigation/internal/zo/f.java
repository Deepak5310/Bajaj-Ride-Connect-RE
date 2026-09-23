package com.google.android.libraries.navigation.internal.zo;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends g {
    private final g a;
    private final double b;

    public f(g gVar) {
        Double dValueOf = Double.valueOf(0.5d);
        ar.f(true, "randomnessFactor (%s) must be >= 0.0", dValueOf);
        ar.f(true, "randomnessFactor (%s) must be <= 1.0", dValueOf);
        this.a = gVar;
        this.b = 0.5d;
    }

    private static final long f(long j) {
        double dRandom = Math.random() - 0.5d;
        return com.google.android.libraries.navigation.internal.zw.g.e(j, (long) ((dRandom + dRandom) * j * 0.5d));
    }

    @Override // com.google.android.libraries.navigation.internal.zo.g
    public final long a(int i) {
        long jA = this.a.a(i);
        return jA <= 0 ? jA : f(jA);
    }

    @Override // com.google.android.libraries.navigation.internal.zo.g
    public final long c(int i, long j) {
        long jC = this.a.c(i, j);
        return jC <= 0 ? jC : f(jC);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (!this.a.equals(fVar.a)) {
            return false;
        }
        double d = fVar.b;
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Double.valueOf(0.5d)});
    }

    public final String toString() {
        return this.a.toString() + ".withRandomization(0.5)";
    }
}
