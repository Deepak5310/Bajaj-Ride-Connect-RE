package com.google.android.libraries.navigation.internal.adr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class eu {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    private static final /* synthetic */ int[] d = {a, b, c};

    public static /* synthetic */ int a(int i) {
        if (i != 0) {
            return i;
        }
        throw null;
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

    public static String toString$ar$edu$f90caec3_0(int i) {
        if (i != 0) {
            return Integer.toString(i - 1);
        }
        throw null;
    }

    public static int[] values$ar$edu$2d8f0838_0() {
        return new int[]{a, b, c};
    }
}
