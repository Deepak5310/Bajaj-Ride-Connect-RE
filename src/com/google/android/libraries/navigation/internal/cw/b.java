package com.google.android.libraries.navigation.internal.cw;

import com.google.maps.android.BuildConfig;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    private static final /* synthetic */ int[] f = {a, b, c, d, e};

    public static /* synthetic */ String a(int i) {
        if (i == 1) {
            return "UNKNOWN";
        }
        if (i == 2) {
            return "HARDWARE_MISSING";
        }
        if (i == 3) {
            return "ENABLED";
        }
        if (i != 4) {
            return i != 5 ? BuildConfig.TRAVIS : "DISABLED_BY_SECURITY";
        }
        return "DISABLED_BY_SETTING";
    }

    public static int[] values$ar$edu$bcdb10f3_0() {
        return new int[]{a, b, c, d, e};
    }
}
