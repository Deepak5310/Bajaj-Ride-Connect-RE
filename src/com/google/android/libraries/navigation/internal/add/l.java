package com.google.android.libraries.navigation.internal.add;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l {
    public static final int a = 2;
    public static final int b = 3;
    public static final int c = 4;
    public static final int d = 5;
    public static final int e = 1;
    private static final /* synthetic */ int[] f = {a, b, c, d, e};

    public static int a(int i) {
        if (i == 0) {
            throw null;
        }
        if (i != e) {
            return i - 2;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static int b(int i) {
        if (i == 0) {
            return a;
        }
        if (i != 1) {
            return i != 2 ? d : c;
        }
        return b;
    }

    public static int[] values$ar$edu$32d6dd08_0() {
        return new int[]{a, b, c, d, e};
    }
}
