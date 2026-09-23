package com.google.android.libraries.navigation.internal.on;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    static final float a = (float) Math.sqrt(2.0d);

    public static void a(float f, float f2, float f3, com.google.android.libraries.navigation.internal.adg.b bVar, float[] fArr) {
        switch (bVar) {
            case CENTER:
                fArr[0] = f;
                fArr[1] = f2;
                break;
            case LEFT:
                fArr[0] = f - f3;
                fArr[1] = f2;
                break;
            case RIGHT:
                fArr[0] = f + f3;
                fArr[1] = f2;
                break;
            case TOP:
                fArr[0] = f;
                fArr[1] = f2 - f3;
                break;
            case TOP_LEFT:
                float f4 = f3 / a;
                fArr[0] = f - f4;
                fArr[1] = f2 - f4;
                break;
            case TOP_RIGHT:
                float f5 = f3 / a;
                fArr[0] = f + f5;
                fArr[1] = f2 - f5;
                break;
            case BOTTOM:
                fArr[0] = f;
                fArr[1] = f2 + f3;
                break;
            case BOTTOM_LEFT:
                float f6 = f3 / a;
                fArr[0] = f - f6;
                fArr[1] = f2 + f6;
                break;
            case BOTTOM_RIGHT:
                float f7 = f3 / a;
                fArr[0] = f + f7;
                fArr[1] = f2 + f7;
                break;
        }
    }
}
