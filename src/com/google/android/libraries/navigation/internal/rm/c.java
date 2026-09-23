package com.google.android.libraries.navigation.internal.rm;

import android.opengl.Matrix;
import com.google.android.libraries.navigation.internal.rq.f;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public final float[] a = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    public boolean b = true;

    public final void a() {
        this.b = false;
    }

    public final void b(d dVar, float f) {
        float[] fArr = dVar.a;
        float f2 = fArr[0];
        float f3 = fArr[1];
        float f4 = fArr[2];
        float[] fArr2 = f.a;
        float[] fArr3 = this.a;
        synchronized (fArr2) {
            Matrix.setRotateM(f.a, 0, f, f2, f3, f4);
            f.d(fArr3, fArr3, f.a);
        }
        this.b = false;
    }

    public final void c(float f, float f2, float f3) {
        Matrix.scaleM(this.a, 0, f, f2, f3);
        this.b = false;
    }

    public final void d(c cVar) {
        System.arraycopy(cVar.a, 0, this.a, 0, 16);
        this.b = cVar.b;
    }

    public final void e() {
        f.f(this.a);
        this.b = true;
    }

    public final void f(float f, float f2, float f3) {
        float[] fArr = this.a;
        fArr[12] = f;
        fArr[13] = f2;
        fArr[14] = f3;
        this.b = false;
    }

    public final void g(float f, float f2, float f3) {
        f.g(this.a, f, f2, f3);
        this.b = false;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            sb.append(this.a[i] + "  ");
            if (i % 4 == 3) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
