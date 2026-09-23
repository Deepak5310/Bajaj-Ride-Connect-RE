package com.google.android.libraries.navigation.internal.zy;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Collection;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends c {
    public static float a(float... fArr) {
        ar.a(fArr.length > 0);
        float fMax = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            fMax = Math.max(fMax, fArr[i]);
        }
        return fMax;
    }

    public static float b(float... fArr) {
        ar.a(fArr.length > 0);
        float fMin = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            fMin = Math.min(fMin, fArr[i]);
        }
        return fMin;
    }

    public static float[] c(Collection collection) {
        if (collection instanceof a) {
            throw null;
        }
        Object[] array = collection.toArray();
        int length = array.length;
        float[] fArr = new float[length];
        for (int i = 0; i < length; i++) {
            Object obj = array[i];
            ar.q(obj);
            fArr[i] = ((Number) obj).floatValue();
        }
        return fArr;
    }
}
