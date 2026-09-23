package com.google.android.libraries.navigation.internal.add;

import com.google.maps.android.BuildConfig;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab {
    public static final int a = 2;
    public static final int b = 3;
    public static final int c = 4;
    public static final int d = 5;
    public static final int e = 1;
    private static final /* synthetic */ int[] f = {a, b, c, d, e};

    public static /* synthetic */ String a(int i) {
        if (i == 1) {
            return "UNRECOGNIZED";
        }
        if (i == 2) {
            return "STATUS_UNSPECIFIED";
        }
        if (i == 3) {
            return "STATUS_IDLE";
        }
        if (i != 4) {
            return i != 5 ? BuildConfig.TRAVIS : "STATUS_ACTIVE_GUIDANCE";
        }
        return "STATUS_PENDING";
    }

    public static int b(int i) {
        if (i == 0) {
            throw null;
        }
        if (i != e) {
            return i - 2;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static int[] values$ar$edu$b9b2bd20_0() {
        return new int[]{a, b, c, d, e};
    }
}
