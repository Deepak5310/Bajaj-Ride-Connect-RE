package com.google.android.libraries.navigation.internal.ade;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i {
    public static final int a = 2;
    public static final int b = 3;
    public static final int c = 4;
    public static final int d = 5;
    public static final int e = 6;
    public static final int f = 7;
    public static final int g = 1;
    private static final /* synthetic */ int[] h = {a, b, c, d, e, f, g};

    public static int a(int i) {
        if (i == 0) {
            throw null;
        }
        if (i != g) {
            return i - 2;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static int[] values$ar$edu$4c111881_0() {
        return new int[]{a, b, c, d, e, f, g};
    }
}
