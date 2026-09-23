package com.google.android.libraries.navigation.internal.kg;

import com.google.maps.android.BuildConfig;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final int a = 1;
    public static final int b = 2;
    private static final /* synthetic */ int[] c = {a, b};

    public static /* synthetic */ String a(int i) {
        if (i != 1) {
            return i != 2 ? BuildConfig.TRAVIS : "AUXILIARY";
        }
        return "MAIN";
    }

    public static int[] values$ar$edu$c2d38ee0_0() {
        return new int[]{a, b};
    }
}
