package com.google.android.libraries.navigation.internal.oe;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ay {
    public static final ay a = new ay();
    public float b;
    public float c;

    public ay() {
        this.b = 0.0f;
        this.c = 0.0f;
    }

    public ay(float f, float f2) {
        this.b = f;
        this.c = f2;
    }

    public ay(ay ayVar) {
        this.b = ayVar.b;
        this.c = ayVar.c;
    }

    public static float a(ay ayVar, ay ayVar2, ay ayVar3) {
        float f = ayVar2.b;
        float f2 = ayVar.b;
        float f3 = ayVar2.c;
        float f4 = ayVar.c;
        return ((f - f2) * (ayVar3.c - f4)) - ((f3 - f4) * (ayVar3.b - f2));
    }

    public static float b(ay ayVar, ay ayVar2) {
        return (float) Math.hypot(ayVar.b - ayVar2.b, ayVar.c - ayVar2.c);
    }

    public static float e(ay ayVar, ay ayVar2) {
        float f = ayVar.b - ayVar2.b;
        float f2 = ayVar.c - ayVar2.c;
        return (f * f) + (f2 * f2);
    }

    public static void f(ay ayVar, ay ayVar2, float f, ay ayVar3) {
        float f2 = ayVar2.b;
        float f3 = ayVar.b;
        ayVar3.b = ((f2 - f3) * f) + f3;
        float f4 = ayVar2.c;
        float f5 = ayVar.c;
        ayVar3.c = (f * (f4 - f5)) + f5;
    }

    public static void g(ay ayVar, ay ayVar2, ay ayVar3) {
        float f = ayVar2.b;
        float f2 = ayVar2.c;
        float f3 = ayVar.b;
        float f4 = ayVar.c;
        ayVar3.b = (f3 * f) - (f4 * f2);
        ayVar3.c = (f3 * f2) + (f4 * f);
    }

    public static boolean h(ay ayVar, ay ayVar2, ay ayVar3, ay ayVar4, ay ayVar5) {
        float f = ayVar2.b;
        float f2 = ayVar.b;
        float f3 = f - f2;
        float f4 = ayVar2.c;
        float f5 = ayVar.c;
        float f6 = f4 - f5;
        float f7 = ayVar4.b;
        float f8 = ayVar3.b;
        float f9 = f7 - f8;
        float f10 = ayVar4.c;
        float f11 = ayVar3.c;
        float f12 = f10 - f11;
        float f13 = (f3 * f12) - (f6 * f9);
        if (f13 == 0.0f) {
            return false;
        }
        float f14 = (((f8 - f2) * f12) - (f9 * (f11 - f5))) / f13;
        if (f14 < 0.0f || f14 > 1.0f) {
            return false;
        }
        float f15 = (-(((f2 - f8) * f6) - ((f5 - f11) * f3))) / f13;
        if (f15 < 0.0f || f15 > 1.0f) {
            return false;
        }
        ayVar5.b = f2 + (f3 * f14);
        ayVar5.c = f5 + (f14 * f6);
        return true;
    }

    public static void j(ay ayVar, ay ayVar2, ay ayVar3) {
        ayVar3.b = ayVar.b + ayVar2.b;
        ayVar3.c = ayVar.c + ayVar2.c;
    }

    public static void k(ay ayVar, float f, ay ayVar2) {
        ayVar2.b = ayVar.b / f;
        ayVar2.c = ayVar.c / f;
    }

    public static void l(ay ayVar, float f, ay ayVar2) {
        ayVar2.b = ayVar.b * f;
        ayVar2.c = ayVar.c * f;
    }

    public static void m(ay ayVar, ay ayVar2) {
        ayVar2.b = -ayVar.b;
        ayVar2.c = -ayVar.c;
    }

    public static void n(ay ayVar, ay ayVar2) {
        float fD = ayVar.d();
        if (fD == 0.0f) {
            ayVar2.b = 0.0f;
            ayVar2.c = 0.0f;
        } else {
            ayVar2.b = ayVar.b / fD;
            ayVar2.c = ayVar.c / fD;
        }
    }

    public static void o(ay ayVar, ay ayVar2) {
        float f = ayVar.b;
        ayVar2.b = -ayVar.c;
        ayVar2.c = f;
    }

    public static void s(ay ayVar, ay ayVar2, ay ayVar3) {
        ayVar3.b = ayVar.b - ayVar2.b;
        ayVar3.c = ayVar.c - ayVar2.c;
    }

    public final float c(ay ayVar) {
        return (this.b * ayVar.b) + (this.c * ayVar.c);
    }

    public final float d() {
        return (float) Math.hypot(this.b, this.c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            if (obj.getClass() == getClass()) {
                ay ayVar = (ay) obj;
                if (this.b == ayVar.b && this.c == ayVar.c) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return Float.floatToIntBits(this.b) ^ Float.floatToIntBits(this.c);
    }

    public final void i(float f, float f2) {
        this.b += f;
        this.c += f2;
    }

    public final void p(float f) {
        this.b *= f;
        this.c *= f;
    }

    public final void q(float f, float f2) {
        this.b = f;
        this.c = f2;
    }

    public final void r(ay ayVar) {
        this.b = ayVar.b;
        this.c = ayVar.c;
    }

    public final String toString() {
        return "(" + this.b + "," + this.c + ")";
    }
}
