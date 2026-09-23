package com.google.android.libraries.navigation.internal.pd;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static /* synthetic */ String a(int i) {
        if (i == 1) {
            return "TARGET_POINT";
        }
        if (i == 2) {
            return "ZOOM";
        }
        if (i != 3) {
            return i != 4 ? "LOOK_AHEAD" : "BEARING";
        }
        return "TILT";
    }

    public static int[] b() {
        return new int[]{1, 2, 3, 4, 5};
    }
}
