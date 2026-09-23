package com.google.android.libraries.navigation.internal.adr;

import com.google.maps.android.BuildConfig;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class be {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    private static final /* synthetic */ int[] d = {a, b, c};

    public static /* synthetic */ String a(int i) {
        if (i == 1) {
            return "UNKNOWN_STEP_CUE_PRIORITY";
        }
        if (i != 2) {
            return i != 3 ? BuildConfig.TRAVIS : "SECONDARY";
        }
        return "PRIMARY";
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

    public static int[] values$ar$edu$ac855105_0() {
        return new int[]{a, b, c};
    }
}
