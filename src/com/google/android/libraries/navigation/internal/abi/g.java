package com.google.android.libraries.navigation.internal.abi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class g {
    private Float a;
    private Float b;

    public static float h(float f, float f2, float f3, float f4) {
        return (float) Math.atan2(f3 - f, f4 - f2);
    }

    public abstract float a(int i);

    public abstract float b();

    public abstract float c(int i);

    public abstract float d();

    public abstract int e();

    public abstract long f();

    public abstract void g();

    public final float i() {
        if (this.a == null) {
            this.a = Float.valueOf(h(a(0), c(0), a(e() - 1), c(e() - 1)));
        }
        return this.a.floatValue();
    }

    public final float j() {
        if (this.b == null) {
            float fA = a(0) - a(e() - 1);
            float fC = c(0) - c(e() - 1);
            this.b = Float.valueOf((float) Math.sqrt((fA * fA) + (fC * fC)));
        }
        return this.b.floatValue();
    }
}
