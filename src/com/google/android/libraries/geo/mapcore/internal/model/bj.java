package com.google.android.libraries.geo.mapcore.internal.model;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class bj {
    public static final int a;
    public static final int b;
    public static final int c;
    private static final int d;

    static {
        int i = com.google.android.libraries.navigation.internal.oe.x.A(0.0d, 180.0d).a;
        a = i;
        b = i + 1;
        c = i + 17;
        d = com.google.android.libraries.navigation.internal.oe.x.A(0.0d, 90.0d).a;
    }

    public static int a(int i, int i2) {
        int i3 = i + 1;
        return i3 < i2 ? i3 : i3 % i2;
    }

    public static boolean b(int i, int i2) {
        int i3;
        int iAbs = Math.abs(i2);
        int i4 = b;
        return iAbs != i4 && Math.abs(i) != i4 && (i3 = d) <= i && i <= i4 && (-i4) <= i2 && i2 <= (-i3);
    }
}
