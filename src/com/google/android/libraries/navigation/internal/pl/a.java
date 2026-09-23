package com.google.android.libraries.navigation.internal.pl;

import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.yx.ar;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private float[] c = new float[0];
    public float[] a = m(16, new float[0]);
    private boolean d = false;
    public int b = 0;

    private final int k(float f, ay ayVar) {
        int i;
        l();
        int i2 = this.b;
        int i3 = 0;
        while (true) {
            i = i3 + 1;
            if (i3 >= i2 - 2 || this.c[i] >= f) {
                break;
            }
            i3 = i;
        }
        float[] fArr = this.c;
        float f2 = fArr[i];
        float f3 = fArr[i3];
        float f4 = f2 - f3;
        float f5 = f - f3;
        float[] fArr2 = this.a;
        int i4 = i3 + i3;
        float f6 = fArr2[i4];
        float f7 = fArr2[i4 + 1];
        float f8 = f5 / f4;
        ayVar.q(((fArr2[i4 + 2] - f6) * f8) + f6, (f8 * (fArr2[i4 + 3] - f7)) + f7);
        return i3;
    }

    private final void l() {
        if (this.d) {
            return;
        }
        int length = this.c.length;
        int i = this.b;
        if (length < i) {
            this.c = new float[i];
        }
        this.c[0] = 0.0f;
        for (int i2 = 1; i2 < this.b; i2++) {
            int i3 = i2 - 1;
            float[] fArr = this.a;
            int i4 = i3 + i3;
            float f = fArr[i4];
            float f2 = fArr[i4 + 1];
            float f3 = fArr[i4 + 2];
            float f4 = fArr[i4 + 3] - f2;
            float[] fArr2 = this.c;
            fArr2[i2] = fArr2[i3] + ((float) Math.hypot(f3 - f, f4));
        }
        this.d = true;
    }

    private static float[] m(int i, float[] fArr) {
        int length = fArr.length;
        int i2 = length >> 1;
        if (i2 >= i) {
            return fArr;
        }
        int iMax = Math.max(i2 + i2, i);
        float[] fArr2 = new float[iMax + iMax];
        if (length == 0) {
            return fArr2;
        }
        System.arraycopy(fArr, 0, fArr2, 0, length);
        return fArr2;
    }

    public final float a() {
        if (this.b < 2) {
            return 0.0f;
        }
        l();
        return this.c[this.b - 1];
    }

    public final float b(int i) {
        ar.p(i, this.b - 1);
        l();
        float[] fArr = this.c;
        return fArr[i + 1] - fArr[i];
    }

    public final void c(float f, float f2) {
        f(this.b + 1);
        float[] fArr = this.a;
        int i = this.b;
        int i2 = i + i;
        fArr[i2] = f;
        fArr[i2 + 1] = f2;
        this.b = i + 1;
        e();
    }

    public final void d() {
        this.b = 0;
        e();
    }

    public final void e() {
        this.d = false;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.b != aVar.b) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = this.b;
            if (i >= i2 + i2) {
                return true;
            }
            if (this.a[i] != aVar.a[i]) {
                return false;
            }
            i++;
        }
    }

    public final void f(int i) {
        this.a = m(i, this.a);
    }

    public final void g(ay ayVar, ay ayVar2, ay ayVar3, float f, float f2) {
        if (this.b < 2 || f2 <= f) {
            return;
        }
        int iK = k(f, ayVar);
        int iK2 = k(f2, ayVar2);
        i(iK2, ayVar3);
        if (!ayVar3.equals(ayVar2)) {
            iK2++;
        }
        float[] fArr = this.a;
        fArr[0] = ayVar.b;
        fArr[1] = ayVar.c;
        int i = iK + 1;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            int i4 = i2 + i2;
            if (i >= iK2) {
                float[] fArr2 = this.a;
                fArr2[i4] = ayVar2.b;
                fArr2[i4 + 1] = ayVar2.c;
                this.b = i3;
                e();
                return;
            }
            float[] fArr3 = this.a;
            int i5 = i + i;
            fArr3[i4] = fArr3[i5];
            fArr3[i4 + 1] = fArr3[i5 + 1];
            i++;
            i2 = i3;
        }
    }

    public final void h(int i, ay ayVar) {
        ar.p(i, this.b - 1);
        float[] fArr = this.a;
        int i2 = i + i;
        ayVar.q(fArr[i2 + 2] - fArr[i2], fArr[i2 + 3] - fArr[i2 + 1]);
    }

    public final int hashCode() {
        int i = 0;
        int i2 = 1;
        while (true) {
            int i3 = this.b;
            if (i >= i3 + i3) {
                return i2;
            }
            int iFloatToIntBits = Float.floatToIntBits(this.a[i]);
            i2 = (i2 * 31) + (iFloatToIntBits ^ (iFloatToIntBits >>> 16));
            i++;
        }
    }

    public final void i(int i, ay ayVar) {
        float[] fArr = this.a;
        int i2 = i + i;
        ayVar.q(fArr[i2], fArr[i2 + 1]);
    }

    public final void j(float f, ay ayVar) {
        int i = this.b;
        if (i < 2) {
            return;
        }
        if (f <= 0.0f) {
            i(0, ayVar);
        } else if (f >= 1.0f) {
            i(i - 1, ayVar);
        } else {
            k(f * a(), ayVar);
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < this.b; i++) {
            float[] fArr = this.a;
            int i2 = i + i;
            float f = fArr[i2];
            float f2 = fArr[i2 + 1];
            sb.append("(");
            sb.append(f);
            sb.append(",");
            sb.append(f2);
            sb.append(")");
            if (i < this.b - 1) {
                sb.append(StringUtils.SPACE);
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
