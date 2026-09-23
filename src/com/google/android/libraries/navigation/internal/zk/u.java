package com.google.android.libraries.navigation.internal.zk;

import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u {
    public static final s[] a;
    private static final double b = (Math.sqrt(2.0d) * 8.0d) / 9.0d;
    private static final double c;
    private static final double d;
    private static final double e;
    private static final t[] f;

    static {
        double dSqrt = Math.sqrt(2.0d);
        c = (dSqrt + dSqrt) / 3.0d;
        double dSqrt2 = Math.sqrt(2.0d);
        d = (dSqrt2 + dSqrt2) / 3.0d;
        e = (Math.sqrt(2.0d) * 8.0d) / 9.0d;
        a = new s[]{new j(), new k(), new l(), new m(), new n(), new o()};
        f = new t[]{new p(), new q(), new r(), new g(), new h(), new i()};
    }

    public static double a(int i, int i2) {
        return c(((double) (i & (-i2))) * 9.313225746154785E-10d);
    }

    public static double b(long j) {
        return j * 4.656612873077393E-10d;
    }

    public static double c(double d2) {
        if (d2 >= 0.5d) {
            return (((4.0d * d2) * d2) - 1.0d) * 0.3333333333333333d;
        }
        double d3 = 1.0d - d2;
        return (1.0d - ((4.0d * d3) * d3)) * 0.3333333333333333d;
    }

    public static double d(double d2) {
        double d3 = d2 * 3.0d;
        return d2 >= 0.0d ? Math.sqrt(d3 + 1.0d) * 0.5d : 1.0d - (Math.sqrt(1.0d - d3) * 0.5d);
    }

    public static int e(double d2) {
        return Math.max(0, Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (int) Math.round((d2 * 1.073741824E9d) - 0.5d)));
    }

    public static f f(int i, double d2, double d3) {
        t tVar = f[Math.min(5, i)];
        return new f(tVar.a(d2, d3), tVar.b(d2, d3), tVar.c(d2, d3));
    }
}
