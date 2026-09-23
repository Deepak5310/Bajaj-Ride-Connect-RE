package com.google.android.libraries.navigation.internal.rm;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private static final float[] d = {1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    public final float[] a;
    public final float[] b = new float[6];
    public final float[] c = new float[6];

    public a() {
        float[] fArr = new float[6];
        this.a = fArr;
        j(d, fArr);
    }

    private static void j(float[] fArr, float[] fArr2) {
        fArr2[0] = fArr[0];
        fArr2[1] = fArr[1];
        fArr2[2] = fArr[2];
        fArr2[3] = fArr[3];
        fArr2[4] = fArr[4];
        fArr2[5] = fArr[5];
    }

    private static void k(float[] fArr, float[] fArr2, float[] fArr3) {
        float f = fArr[0] * fArr2[0];
        float f2 = fArr[1];
        float f3 = fArr2[3];
        fArr3[0] = f + (f2 * f3);
        float f4 = fArr[0];
        float f5 = fArr2[1] * f4;
        float f6 = fArr2[4];
        fArr3[1] = f5 + (f2 * f6);
        float f7 = f4 * fArr2[2];
        float f8 = fArr[1];
        float f9 = fArr2[5];
        fArr3[2] = f7 + (f8 * f9) + fArr[2];
        float f10 = fArr[3] * fArr2[0];
        float f11 = fArr[4];
        fArr3[3] = f10 + (f3 * f11);
        float f12 = fArr[3];
        fArr3[4] = (fArr2[1] * f12) + (f11 * f6);
        fArr3[5] = (f12 * fArr2[2]) + (fArr[4] * f9) + fArr[5];
    }

    private final void l() {
        j(this.a, this.c);
        k(this.b, this.c, this.a);
    }

    private final void m(float f, float f2) {
        float[] fArr = this.b;
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = f;
        fArr[3] = 0.0f;
        fArr[4] = 1.0f;
        fArr[5] = f2;
    }

    public final void a(float[] fArr, float[] fArr2) {
        int length;
        int length2 = fArr.length;
        if ((length2 & 1) != 0 || length2 != (length = fArr2.length)) {
            throw new IllegalArgumentException("Destination and source arrays must be of an even, equal length.");
        }
        int i = length >> 1;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 + i2;
            float f = fArr2[i3];
            int i4 = i3 + 1;
            float f2 = fArr2[i4];
            float[] fArr3 = this.a;
            fArr[i3] = (fArr3[0] * f) + (fArr3[1] * f2) + fArr3[2];
            fArr[i4] = (f * fArr3[3]) + (f2 * fArr3[4]) + fArr3[5];
        }
    }

    public final void b(float f) {
        if (f != 0.0f) {
            double d2 = f;
            float fSin = (float) Math.sin(d2);
            float fCos = (float) Math.cos(d2);
            float[] fArr = this.b;
            fArr[0] = fCos;
            fArr[1] = -fSin;
            fArr[2] = 0.0f;
            fArr[3] = fSin;
            fArr[4] = fCos;
            fArr[5] = 0.0f;
            l();
        }
    }

    public final void c(float f, float f2) {
        i(f, f2);
        l();
    }

    public final void d(float f, float f2) {
        m(f, f2);
        l();
    }

    public final void e() {
        j(this.a, this.c);
        k(this.c, this.b, this.a);
    }

    public final void f(float f, float f2) {
        m(f, f2);
        e();
    }

    public final void g(a aVar) {
        j(aVar.a, this.a);
    }

    public final void h() {
        j(d, this.a);
    }

    public final void i(float f, float f2) {
        float[] fArr = this.b;
        fArr[0] = f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = f2;
        fArr[5] = 0.0f;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i += 3) {
            sb.append(this.a[i]);
            sb.append(", ");
            sb.append(this.a[i + 1]);
            sb.append(", ");
            sb.append(this.a[i + 2]);
            sb.append("\n");
        }
        return sb.toString();
    }
}
