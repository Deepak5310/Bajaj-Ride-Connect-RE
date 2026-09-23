package com.google.android.libraries.navigation.internal.adi;

import com.google.maps.android.BuildConfig;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class au {
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 3;
    public static final int d = 4;
    public static final int e = 5;
    public static final int f = 6;
    public static final int g = 7;
    public static final int h = 8;
    public static final int i = 9;
    private static final /* synthetic */ int[] j = {a, b, c, d, e, f, g, h, i};

    public static /* synthetic */ String a(int i2) {
        switch (i2) {
            case 1:
                return "STATUS_OK";
            case 2:
                return "STATUS_NOT_FOUND";
            case 3:
                return "STATUS_BAD_REQUEST";
            case 4:
                return "STATUS_SERVER_ERROR";
            case 5:
                return "STATUS_IVSERVER_AMBIGUOUS_RESPONSE";
            case 6:
                return "STATUS_OK_EMPTY";
            case 7:
                return "STATUS_OK_DATA_UNCHANGED";
            case 8:
                return "STATUS_SERVICE_UNAVAILABLE";
            case 9:
                return "STATUS_INVALID_EPOCH";
            default:
                return BuildConfig.TRAVIS;
        }
    }

    public static int b(int i2) {
        switch (i2) {
            case 0:
                return a;
            case 1:
                return b;
            case 2:
                return c;
            case 3:
                return d;
            case 4:
                return e;
            case 5:
                return f;
            case 6:
                return g;
            case 7:
                return h;
            case 8:
                return i;
            default:
                return 0;
        }
    }

    public static int[] values$ar$edu$36dbbe84_0() {
        return new int[]{a, b, c, d, e, f, g, h, i};
    }
}
