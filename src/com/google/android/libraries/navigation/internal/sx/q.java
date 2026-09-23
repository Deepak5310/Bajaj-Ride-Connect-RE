package com.google.android.libraries.navigation.internal.sx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q {
    public static final int a = 2;
    public static final int b = 3;
    public static final int c = 4;
    public static final int d = 5;
    public static final int e = 6;
    public static final int f = 7;
    public static final int g = 8;
    public static final int h = 1;
    private static final /* synthetic */ int[] i = {a, b, c, d, e, f, g, h};

    public static int a(int i2) {
        if (i2 == 0) {
            throw null;
        }
        if (i2 != h) {
            return i2 - 2;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static int[] values$ar$edu$4e15c513_0() {
        return new int[]{a, b, c, d, e, f, g, h};
    }
}
