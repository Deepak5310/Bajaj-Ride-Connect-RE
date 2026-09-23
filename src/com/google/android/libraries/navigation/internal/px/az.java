package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class az {
    private final ay[] a;

    private az(ay[] ayVarArr) {
        this.a = ayVarArr;
    }

    public static az e(float f, float f2, float[] fArr, float f3) {
        int length = fArr.length - 1;
        ay[] ayVarArr = new ay[length];
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            float f4 = fArr[i2] - fArr[i];
            ayVarArr[i] = new ay(f, f2, f4, f3);
            f += f4;
            i = i2;
        }
        return new az(ayVarArr);
    }

    public final int a() {
        return this.a.length;
    }

    final ay b(int i) {
        return this.a[i];
    }

    public final void d(com.google.android.libraries.navigation.internal.oe.ay ayVar) {
        int i = 0;
        while (true) {
            ay[] ayVarArr = this.a;
            if (i >= ayVarArr.length) {
                return;
            }
            com.google.android.libraries.navigation.internal.oe.ay ayVar2 = ayVarArr[i].g;
            com.google.android.libraries.navigation.internal.oe.ay.j(ayVar2, ayVar, ayVar2);
            i++;
        }
    }

    public final void c(com.google.android.libraries.navigation.internal.pl.a aVar, float[] fArr, float f, float f2, ct ctVar) {
        int i;
        float f3 = 0.5f;
        int i2 = 0;
        if (aVar.b == 2) {
            com.google.android.libraries.navigation.internal.oe.ay ayVar = ctVar.a;
            aVar.i(0, ayVar);
            com.google.android.libraries.navigation.internal.oe.ay ayVar2 = ctVar.b;
            aVar.i(1, ayVar2);
            com.google.android.libraries.navigation.internal.oe.ay ayVar3 = ctVar.c;
            com.google.android.libraries.navigation.internal.oe.ay.s(ayVar2, ayVar, ayVar3);
            int length = fArr.length - 1;
            float fA = aVar.a();
            float f4 = fA - ((fArr[length] * f) * f2);
            while (i2 < length) {
                int i3 = i2 + 1;
                com.google.android.libraries.navigation.internal.oe.ay.f(ayVar, ayVar2, ((f4 * f3) + (((f2 * f) * (fArr[i2] + fArr[i3])) / 2.0f)) / fA, this.a[i2].g);
                float f5 = ayVar3.b;
                float f6 = ayVar3.c;
                float fHypot = (float) Math.hypot(f5, f6);
                ay ayVar4 = this.a[i2];
                ayVar4.e = f5 / fHypot;
                ayVar4.f = f6 / fHypot;
                i2 = i3;
                f3 = 0.5f;
            }
            return;
        }
        com.google.android.libraries.navigation.internal.oe.ay ayVar5 = ctVar.a;
        com.google.android.libraries.navigation.internal.oe.ay ayVar6 = ctVar.b;
        com.google.android.libraries.navigation.internal.oe.ay ayVar7 = ctVar.c;
        com.google.android.libraries.navigation.internal.oe.ay ayVar8 = ctVar.d;
        com.google.android.libraries.navigation.internal.oe.ay ayVar9 = ctVar.e;
        com.google.android.libraries.navigation.internal.oe.ay ayVar10 = ctVar.f;
        com.google.android.libraries.navigation.internal.oe.ay ayVar11 = ctVar.g;
        com.google.android.libraries.navigation.internal.oe.ay ayVar12 = ctVar.h;
        int length2 = fArr.length - 1;
        float fA2 = aVar.a();
        float f7 = fArr[length2] * f * f2;
        float f8 = 1.0f / fA2;
        float f9 = (fA2 - f7) * 0.5f;
        aVar.j(((fArr[0] * f * f2) + f9) * f8, ayVar5);
        aVar.j(((0.33333334f * f7) + f9) * f8, ayVar6);
        aVar.j(((0.6666667f * f7) + f9) * f8, ayVar7);
        aVar.j((f7 + f9) * f8, ayVar8);
        ayVar9.r(ayVar5);
        com.google.android.libraries.navigation.internal.oe.ay ayVar13 = ayVar9;
        com.google.android.libraries.navigation.internal.oe.ay ayVar14 = ayVar10;
        ayVar14.q((float) com.google.android.libraries.navigation.internal.oe.b.a(ayVar5.b, ayVar6.b, ayVar7.b, ayVar8.b), (float) com.google.android.libraries.navigation.internal.oe.b.a(ayVar5.c, ayVar6.c, ayVar7.c, ayVar8.c));
        ayVar11.q((float) com.google.android.libraries.navigation.internal.oe.b.b(ayVar5.b, ayVar6.b, ayVar7.b, ayVar8.b), (float) com.google.android.libraries.navigation.internal.oe.b.b(ayVar5.c, ayVar6.c, ayVar7.c, ayVar8.c));
        ayVar12.r(ayVar8);
        int i4 = 0;
        while (i4 < i) {
            i = length2;
            int i5 = i4 + 1;
            com.google.android.libraries.navigation.internal.oe.ay ayVar15 = this.a[i4].g;
            com.google.android.libraries.navigation.internal.oe.ay ayVar16 = ayVar13;
            double d = ayVar16.b;
            com.google.android.libraries.navigation.internal.oe.ay ayVar17 = ayVar14;
            com.google.android.libraries.navigation.internal.oe.ay ayVar18 = ayVar11;
            double d2 = (((fArr[i4] + fArr[i5]) * f) * f2) / (f7 + f7);
            ayVar15.q((float) com.google.android.libraries.navigation.internal.oe.b.d(d2, d, ayVar17.b, ayVar11.b, ayVar12.b), (float) com.google.android.libraries.navigation.internal.oe.b.d(d2, ayVar16.c, ayVar17.c, ayVar18.c, ayVar12.c));
            float f10 = ayVar15.b;
            float f11 = ayVar15.c;
            float fHypot2 = (float) Math.hypot(f10, f11);
            ay ayVar19 = this.a[i4];
            ayVar19.e = f10 / fHypot2;
            ayVar19.f = f11 / fHypot2;
            ayVar19.g.q((float) com.google.android.libraries.navigation.internal.oe.b.f(d2, ayVar16.b, ayVar17.b, ayVar18.b, ayVar12.b), (float) com.google.android.libraries.navigation.internal.oe.b.f(d2, ayVar16.c, ayVar17.c, ayVar18.c, ayVar12.c));
            i4 = i5;
            i = i;
            ayVar13 = ayVar16;
            ayVar14 = ayVar17;
            ayVar11 = ayVar18;
        }
        i = length2;
    }
}
