package com.google.android.libraries.navigation.internal.xp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static final int a = 2;
    public static final int b = 3;
    public static final int c = 4;
    public static final int d = 5;
    public static final int e = 6;
    public static final int f = 7;
    public static final int g = 8;
    public static final int h = 9;
    public static final int i = 10;
    public static final int j = 11;
    public static final int k = 12;
    public static final int l = 13;
    public static final int m = 14;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Deprecated
    public static final int f652n = 15;
    public static final int o = 1;
    private static final /* synthetic */ int[] p = {a, b, c, d, e, f, g, h, i, j, k, l, m, f652n, o};

    public static int a(int i2) {
        if (i2 == 0) {
            throw null;
        }
        if (i2 != o) {
            return i2 - 2;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static int[] values$ar$edu$21544a16_0() {
        return new int[]{a, b, c, d, e, f, g, h, i, j, k, l, m, f652n, o};
    }
}
