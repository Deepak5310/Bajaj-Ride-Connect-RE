package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dr {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    private static final /* synthetic */ int[] e = {a, b, c, d};

    public static int a(int i) {
        if (i == 0) {
            return a;
        }
        if (i == 1) {
            return b;
        }
        if (i == 2) {
            return c;
        }
        if (i != 3) {
            return 0;
        }
        return d;
    }

    public static String toString$ar$edu$9cfe165a_0(int i) {
        if (i != 0) {
            return Integer.toString(i - 1);
        }
        throw null;
    }

    public static int[] values$ar$edu$5624e547_0() {
        return new int[]{a, b, c, d};
    }
}
