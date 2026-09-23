package com.google.android.libraries.navigation.internal.zs;

import com.google.maps.android.BuildConfig;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dd {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    private static final /* synthetic */ int[] f = {a, b, c, d, e};

    public static /* synthetic */ String a(int i) {
        if (i == 1) {
            return "LOCATION_SAMPLES";
        }
        if (i == 2) {
            return "CLIENT_NAVIGATION";
        }
        if (i == 3) {
            return "SERVER_NAVIGATION";
        }
        if (i != 4) {
            return i != 5 ? BuildConfig.TRAVIS : "DETAILS_NOT_SET";
        }
        return "SENSOR_OBSERVATION";
    }

    public static int[] values$ar$edu$ce9322d2_0() {
        return new int[]{a, b, c, d, e};
    }
}
