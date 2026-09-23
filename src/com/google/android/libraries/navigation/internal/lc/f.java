package com.google.android.libraries.navigation.internal.lc;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    static int a(int i) {
        int[] iArrB = b();
        for (int i2 = 0; i2 < 3; i2++) {
            int i3 = iArrB[i2];
            int i4 = i3 - 1;
            if (i3 == 0) {
                throw null;
            }
            if (i4 == i) {
                return i3;
            }
        }
        return 1;
    }

    public static int[] b() {
        return new int[]{1, 2, 3};
    }
}
