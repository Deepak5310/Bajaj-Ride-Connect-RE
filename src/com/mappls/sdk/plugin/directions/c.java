package com.mappls.sdk.plugin.directions;

/* JADX INFO: loaded from: classes4.dex */
public abstract class c {
    public static int a(float f, String str) {
        if (str == null || str.equalsIgnoreCase("left")) {
            if (f <= 45.0f) {
                return 65;
            }
            if (f <= 90.0f) {
                return 66;
            }
            if (f <= 135.0f) {
                return 67;
            }
            if (f <= 180.0f) {
                return 68;
            }
            if (f <= 225.0f) {
                return 69;
            }
            return f <= 270.0f ? 70 : 71;
        }
        if (f <= 45.0f) {
            return 58;
        }
        if (f <= 90.0f) {
            return 59;
        }
        if (f <= 135.0f) {
            return 60;
        }
        if (f <= 180.0f) {
            return 61;
        }
        if (f <= 225.0f) {
            return 62;
        }
        return f <= 270.0f ? 63 : 64;
    }

    public static Integer a(int i) {
        int i2;
        if (i == 41) {
            i2 = 6;
        } else {
            if (i != 72) {
                return Integer.valueOf(i);
            }
            i2 = 49;
        }
        return Integer.valueOf(i2);
    }
}
