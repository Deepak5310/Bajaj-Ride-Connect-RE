package com.google.android.libraries.navigation.internal.gd;

import com.google.maps.android.BuildConfig;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    public static final int a = 1;
    public static final int b = 2;
    private static final /* synthetic */ int[] c = {a, b};

    public static /* synthetic */ String a(int i) {
        if (i != 1) {
            return i != 2 ? BuildConfig.TRAVIS : "GET";
        }
        return "DEFAULT";
    }

    public static int b(int i) {
        if (i == 0) {
            return a;
        }
        if (i != 1) {
            return 0;
        }
        return b;
    }

    public static int[] values$ar$edu$167bf89d_0() {
        return new int[]{a, b};
    }
}
