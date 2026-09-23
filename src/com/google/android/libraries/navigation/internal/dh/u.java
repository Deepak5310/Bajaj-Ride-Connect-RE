package com.google.android.libraries.navigation.internal.dh;

import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u {
    private float[] a = new float[0];
    private boolean b = false;
    private boolean c = false;

    public final boolean a(float[] fArr) {
        boolean z = false;
        for (int i = 0; i < fArr.length; i++) {
            float f = fArr[i];
            z |= !(f <= 0.0f);
            if (f % 1.0f != 0.0f) {
                this.c = true;
            }
        }
        if (this.b && Arrays.equals(fArr, this.a) && z && this.c) {
            return true;
        }
        this.a = fArr;
        this.b = true;
        return false;
    }
}
