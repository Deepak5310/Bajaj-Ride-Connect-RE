package com.google.android.libraries.navigation.internal.ade;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final int a = 2;
    public static final int b = 3;
    public static final int c = 4;
    public static final int d = 1;
    private static final /* synthetic */ int[] e = {a, b, c, d};

    public static int a(int i) {
        if (i == 0) {
            throw null;
        }
        if (i != d) {
            return i - 2;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static int b(int i) {
        if (i == 0) {
            return a;
        }
        if (i == 1) {
            return b;
        }
        if (i != 2) {
            return 0;
        }
        return c;
    }

    public static int[] values$ar$edu$fc0c78f_0() {
        return new int[]{a, b, c, d};
    }
}
