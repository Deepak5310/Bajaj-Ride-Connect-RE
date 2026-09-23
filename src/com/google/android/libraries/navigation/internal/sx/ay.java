package com.google.android.libraries.navigation.internal.sx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ay {
    public static final int a = 2;
    public static final int b = 3;
    public static final int c = 4;
    public static final int d = 5;
    public static final int e = 6;
    public static final int f = 1;
    private static final /* synthetic */ int[] g = {a, b, c, d, e, f};

    public static int a(int i) {
        if (i == 0) {
            throw null;
        }
        if (i != f) {
            return i - 2;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static int[] values$ar$edu$e8d620c6_0() {
        return new int[]{a, b, c, d, e, f};
    }
}
