package com.google.android.libraries.navigation.internal.df;

import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g {
    int b = 0;
    public final float[] a = new float[10];

    public final float b(int i) {
        if (this.b <= i) {
            return Float.NaN;
        }
        return this.a[i];
    }

    public final void c(float f) {
        if (Float.isNaN(f)) {
            return;
        }
        int i = this.b;
        if (i == 10) {
            float[] fArr = this.a;
            System.arraycopy(fArr, 1, fArr, 0, 9);
            this.a[this.b - 1] = f;
        } else {
            float[] fArr2 = this.a;
            this.b = i + 1;
            fArr2[i] = f;
        }
    }

    public final void d() {
        this.b = 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.b; i++) {
            sb.append(this.a[i] + StringUtils.SPACE);
        }
        return sb.toString();
    }

    public final double a() {
        int i;
        int i2;
        int i3 = this.b;
        double d = 0.0d;
        if (i3 != 0) {
            int i4 = 0;
            double d2 = 0.0d;
            if (i3 != 0) {
                int i5 = 0;
                while (true) {
                    i2 = this.b;
                    if (i5 >= i2) {
                        break;
                    }
                    d2 += (double) this.a[i5];
                    i5++;
                }
                d2 /= (double) i2;
            }
            while (true) {
                i = this.b;
                if (i4 >= i) {
                    break;
                }
                double d3 = ((double) this.a[i4]) - d2;
                d += d3 * d3;
                i4++;
            }
            d /= (double) i;
        }
        return Math.sqrt(d);
    }
}
