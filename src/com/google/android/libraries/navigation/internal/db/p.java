package com.google.android.libraries.navigation.internal.db;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p {
    private static final com.google.android.libraries.navigation.internal.zb.j c = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.db.p");
    private static final double d = Math.sqrt(6.283185307179586d);
    private static final double e;
    private static final double f;
    private static final double g;
    private static final double h;
    public final double a;
    public final double b;

    static {
        double d2 = -Math.sqrt(3.141592653589793d);
        e = d2;
        f = (4.0d * d2) / (Math.sqrt(2.0d) * 3.141592653589793d);
        g = 0.0413572909814d * d2;
        h = d2 * (-3.32628259277E-4d);
    }

    public p(double d2, double d3) {
        if (d3 <= 0.0d || Double.isNaN(d3)) {
            ((com.google.android.libraries.navigation.internal.zb.h) c.d(com.google.android.libraries.navigation.internal.nl.a.a).F(170)).s("Gaussian sigmas must be positive: %g", Double.valueOf(d3));
        }
        this.a = d2;
        this.b = Math.max(1.0E-20d, d3);
    }

    public static double b(double d2, double d3) {
        double d4 = d * d3;
        double d5 = d3 * d3;
        double d6 = d2 + 0.0d;
        return (1.0d / d4) * Math.exp(-((d6 * d6) / (d5 + d5)));
    }

    public final double a(double d2) {
        double d3 = (d2 - this.a) / this.b;
        if (d3 < -6.0d) {
            return 0.0d;
        }
        if (d3 > 6.0d) {
            return 1.0d;
        }
        double d4 = d3 * d3 * d3;
        return 1.0d / (Math.exp(((h * ((d4 * d3) * d3)) + (g * d4)) + (f * d3)) + 1.0d);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (Double.compare(this.a, pVar.a) == 0 && Double.compare(this.b, pVar.b) == 0) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Double.valueOf(this.a), Double.valueOf(this.b)});
    }

    public final String toString() {
        return com.google.android.libraries.navigation.internal.yx.al.a(p.class).a("mean", this.a).a("sigma", this.b).toString();
    }
}
