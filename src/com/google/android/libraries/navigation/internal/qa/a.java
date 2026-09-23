package com.google.android.libraries.navigation.internal.qa;

import com.google.android.libraries.navigation.internal.oe.ay;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public float a;
    public float b;
    public float c;
    public float d;
    public final ay e = new ay();

    public a() {
    }

    public a(float f, float f2, float f3, float f4) {
        d(f, f2, f3, f4);
    }

    public final float a() {
        return this.d - this.b;
    }

    public final float b() {
        return this.c - this.a;
    }

    public final void c(int i, ay ayVar) {
        ayVar.q((i == 0 || i == 3) ? this.c : this.a, i < 2 ? this.d : this.b);
    }

    public final void d(float f, float f2, float f3, float f4) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.e.q((f + f3) * 0.5f, (f2 + f4) * 0.5f);
    }

    public final boolean e(ay ayVar) {
        float f = ayVar.b;
        float f2 = ayVar.c;
        return this.a <= f && f <= this.c && this.b <= f2 && f2 <= this.d;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.a == aVar.a && this.c == aVar.c && this.b == aVar.b && this.d == aVar.d) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(a aVar) {
        return this.a <= aVar.c && this.b <= aVar.d && this.c >= aVar.a && this.d >= aVar.b;
    }

    public final int hashCode() {
        return ((((((Float.floatToIntBits(this.a) + 31) * 31) + Float.floatToIntBits(this.b)) * 31) + Float.floatToIntBits(this.c)) * 31) + Float.floatToIntBits(this.d);
    }

    public final String toString() {
        return "AABB[[" + this.a + ", " + this.b + "], [" + this.c + ", " + this.d + "]]";
    }
}
