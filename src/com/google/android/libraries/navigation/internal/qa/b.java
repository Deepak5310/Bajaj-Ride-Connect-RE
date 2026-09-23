package com.google.android.libraries.navigation.internal.qa;

import com.google.android.libraries.navigation.internal.oe.ay;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    protected double b;
    private final ay j = new ay();
    public final ay a = new ay();
    protected final ay c = new ay();
    protected final ay d = new ay();
    public final ay e = new ay();
    public final ay f = new ay();
    public final ay g = new ay();
    public final ay h = new ay();
    public final a i = new a();

    private final boolean h(ay ayVar, ay ayVar2) {
        float fC = ayVar2.c(ayVar2);
        float fAbs = Math.abs(ayVar.c(ayVar2));
        return fAbs >= fC && fAbs >= fC + (Math.abs(this.c.c(ayVar2)) + Math.abs(this.d.c(ayVar2)));
    }

    private static boolean i(ay ayVar, ay ayVar2, a aVar) {
        float fC = ayVar2.c(ayVar2);
        float fAbs = Math.abs(ayVar.c(ayVar2));
        return fAbs >= fC && fAbs >= fC + (Math.abs((aVar.b() / 2.0f) * ayVar2.b) + Math.abs((aVar.a() / 2.0f) * ayVar2.c));
    }

    public final float a() {
        return this.d.d();
    }

    public final float b() {
        return this.c.d();
    }

    public final void c(ay ayVar) {
        ay ayVar2 = this.a;
        ay.j(ayVar2, ayVar, ayVar2);
        ay ayVar3 = this.e;
        ay.j(ayVar3, ayVar, ayVar3);
        ay ayVar4 = this.f;
        ay.j(ayVar4, ayVar, ayVar4);
        ay ayVar5 = this.g;
        ay.j(ayVar5, ayVar, ayVar5);
        ay ayVar6 = this.h;
        ay.j(ayVar6, ayVar, ayVar6);
        a aVar = this.i;
        float f = ayVar.b;
        float f2 = ayVar.c;
        aVar.a += f;
        aVar.b += f2;
        aVar.c += f;
        aVar.d += f2;
        ay ayVar7 = aVar.e;
        ay.j(ayVar7, ayVar, ayVar7);
    }

    public final boolean d(ay ayVar) {
        double d = this.b;
        if (d <= -0.0010000000474974513d || d >= 0.0010000000474974513d) {
            return this.i.e(ayVar) && ay.a(this.h, this.e, ayVar) >= 0.0f && ay.a(this.e, this.f, ayVar) >= 0.0f && ay.a(this.f, this.g, ayVar) >= 0.0f && ay.a(this.g, this.h, ayVar) >= 0.0f;
        }
        return this.i.e(ayVar);
    }

    public final boolean e(a aVar) {
        if (!aVar.f(this.i)) {
            return false;
        }
        double d = this.b;
        if (d > -0.0010000000474974513d && d < 0.0010000000474974513d) {
            return true;
        }
        ay ayVar = aVar.e;
        if (d(ayVar) || aVar.e(this.a)) {
            return true;
        }
        ay ayVar2 = this.j;
        ay.s(ayVar, this.a, ayVar2);
        return (i(ayVar2, this.d, aVar) || i(ayVar2, this.c, aVar)) ? false : true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.a.equals(bVar.a) && this.c.equals(bVar.c) && this.d.equals(bVar.d)) {
                return true;
            }
        }
        return false;
    }

    public final boolean f(b bVar) {
        double d = this.b;
        if (d > -0.0010000000474974513d && d < 0.0010000000474974513d) {
            double d2 = bVar.b;
            if (d2 > -0.0010000000474974513d && d2 < 0.0010000000474974513d) {
                return this.i.f(bVar.i);
            }
        }
        if (!this.i.f(bVar.i)) {
            return false;
        }
        if (d(bVar.a) || bVar.d(this.a)) {
            return true;
        }
        ay ayVar = this.j;
        ay.s(bVar.a, this.a, ayVar);
        return (h(ayVar, bVar.d) || bVar.h(ayVar, this.d) || h(ayVar, bVar.c) || bVar.h(ayVar, this.c)) ? false : true;
    }

    public final void g(float f, float f2, double d, float f3, float f4) {
        this.a.q(f, f2);
        this.b = d;
        float fCos = (float) Math.cos(d);
        float fSin = (float) Math.sin(d);
        float f5 = f3 * fCos;
        float f6 = f3 * fSin;
        this.c.q(f5, f6);
        float f7 = (-fSin) * f4;
        float f8 = f4 * fCos;
        this.d.q(f7, f8);
        float f9 = f2 + f6;
        float f10 = f + f5;
        this.e.q(f10 + f7, f9 + f8);
        float f11 = f2 - f6;
        float f12 = f - f5;
        this.f.q(f12 + f7, f11 + f8);
        this.g.q(f12 - f7, f11 - f8);
        this.h.q(f10 - f7, f9 - f8);
        ay ayVar = this.e;
        float f13 = ayVar.b;
        float f14 = ayVar.c;
        ay ayVar2 = this.f;
        float f15 = ayVar2.b;
        if (f15 < f13) {
            f15 = f13;
            f13 = f15;
        } else if (f15 <= f13) {
            f15 = f13;
        }
        float f16 = ayVar2.c;
        if (f16 < f14) {
            f16 = f14;
            f14 = f16;
        } else if (f16 <= f14) {
            f16 = f14;
        }
        ay ayVar3 = this.g;
        float f17 = ayVar3.b;
        if (f17 < f13) {
            f13 = f17;
        } else if (f17 > f15) {
            f15 = f17;
        }
        float f18 = ayVar3.c;
        if (f18 < f14) {
            f14 = f18;
        } else if (f18 > f16) {
            f16 = f18;
        }
        ay ayVar4 = this.h;
        float f19 = ayVar4.b;
        if (f19 < f13) {
            f13 = f19;
        } else if (f19 > f15) {
            f15 = f19;
        }
        float f20 = ayVar4.c;
        if (f20 < f14) {
            f14 = f20;
        } else if (f20 > f16) {
            f16 = f20;
        }
        this.i.d(f13, f14, f15, f16);
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 31) * 31) ^ this.c.hashCode()) * 31) ^ this.d.hashCode();
    }

    public final String toString() {
        return "OBB{center: " + String.valueOf(this.a) + " angle " + this.b + " abscissa: " + String.valueOf(this.c) + " ordinate: " + String.valueOf(this.d) + "}";
    }
}
