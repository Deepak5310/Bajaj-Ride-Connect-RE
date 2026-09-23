package com.google.android.libraries.navigation.internal.rf;

import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static boolean a(float f, float f2, int i, int i2, int i3, int i4, int i5, float[] fArr, x xVar, float[] fArr2) {
        ar.k(true);
        fArr2[0] = f;
        fArr2[1] = f2;
        fArr2[2] = 1.0f;
        fArr2[3] = 1.0f;
        com.google.android.libraries.navigation.internal.rq.f.e(fArr2, 4, fArr, fArr2);
        float f3 = 1.0f / fArr2[7];
        float f4 = fArr2[4] * f3;
        float f5 = fArr2[5] * f3;
        double d = (fArr2[6] * f3) / i5;
        if (d >= 1.0d) {
            return false;
        }
        double d2 = 1.0d / (1.0d - d);
        double d3 = i3;
        double d4 = i4;
        xVar.J((int) ((((((double) f4) + ((double) i)) - d3) * d2) + d3), (int) ((((((double) f5) + ((double) i2)) - d4) * d2) + d4));
        return true;
    }
}
