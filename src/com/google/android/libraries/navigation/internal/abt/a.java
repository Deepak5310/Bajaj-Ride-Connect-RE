package com.google.android.libraries.navigation.internal.abt;

import android.opengl.Matrix;
import com.google.android.libraries.navigation.internal.abf.s;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends com.google.android.libraries.navigation.internal.abu.b {
    public static final String a = "a";
    private static final ThreadLocal h = com.google.android.libraries.navigation.internal.abw.k.q();
    private static final ThreadLocal i = com.google.android.libraries.navigation.internal.abw.k.q();
    public float[] b;
    public float[] c;
    public double d;

    public a(com.google.android.libraries.navigation.internal.abu.b bVar) {
        super(bVar.e, bVar.f, bVar.g);
        synchronized (this) {
            this.b = null;
            this.c = null;
            this.d = 0.0d;
        }
    }

    public static float[] b(com.google.android.libraries.navigation.internal.abu.b bVar, n nVar, boolean z) {
        float[] fArr = (float[]) h.get();
        float[] fArr2 = (float[]) i.get();
        float f = true != z ? 1.0f : -1.0f;
        float[] fArr3 = new float[4];
        fArr[0] = bVar.f * f;
        fArr[1] = 0.0f * f;
        fArr[2] = f * (-bVar.g);
        fArr[3] = 1.0f;
        s.k(fArr, "originalRay");
        s.k(fArr2, "outputRay");
        Matrix.multiplyMV(fArr2, 0, nVar.f, 0, fArr, 0);
        Matrix.multiplyMV(fArr3, 0, nVar.e, 0, fArr2, 0);
        return fArr3;
    }

    public final synchronized double a() {
        return this.d;
    }

    public final synchronized float[] c() {
        return this.c;
    }

    public final synchronized float[] d() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.abu.b
    public final synchronized String toString() {
        return String.format("%s=>{%s,%s,%s}", super.toString(), Double.valueOf(this.d), Arrays.toString(this.b), Arrays.toString(this.c));
    }
}
