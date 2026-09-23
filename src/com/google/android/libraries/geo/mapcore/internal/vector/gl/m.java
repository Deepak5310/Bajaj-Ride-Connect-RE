package com.google.android.libraries.geo.mapcore.internal.vector.gl;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.oe.ba;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class m {
    public static final /* synthetic */ int a = 0;
    private static final int[] b = {d.a(2), d.a(1), d.a(4), d.a(3)};
    private static final int[] c = {d.a(4), d.a(3), d.a(2), d.a(1)};
    private static final int[] d = {d.a(6), d.a(5)};
    private static final int[] e = {d.a(6), d.a(5), d.a(7), d.a(6), d.a(5)};
    private static final float f = 0.5f / GeometryUtil.a;

    public static float a(float f2) {
        while (f2 > 5.368709E8f) {
            f2 -= 1.0737418E9f;
        }
        while (f2 < -5.368709E8f) {
            f2 += 1.0737418E9f;
        }
        return f2;
    }

    static int b(float f2) {
        return ((int) (((f2 * f) + 0.5f) * 255.0f)) & 255;
    }

    static int c(float f2) {
        return (char) (((f2 * f) + 0.5f) * 65535.0f);
    }

    public static j d(float[] fArr) {
        ar.k(fArr.length == 4);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < 4) {
            ar.k(fArr[i] <= 255.0f);
            float f2 = fArr[i] * 0.003921569f;
            i++;
            int i4 = (int) (f2 * 65535.0f);
            i3 = (i3 << 8) | (i4 & 255);
            i2 = (i2 << 8) | ((i4 >> 8) & 255);
        }
        return new j(i2, i3);
    }

    public static void e(l lVar, float[] fArr, int i, int i2, int i3, int i4, int[] iArr, int i5, float[] fArr2, int[] iArr2, boolean z, float f2, v vVar) {
        if (lVar.a() < 4) {
            return;
        }
        g gVar = new g(lVar, vVar.g, i4, i5, fArr2, iArr2, iArr, fArr);
        gVar.i = i;
        gVar.j = i2;
        gVar.k = i3;
        gVar.l = z;
        i iVar = new i(gVar);
        iVar.l = 0;
        iVar.k = 0;
        iVar.j = iArr2.length == 0 ? gVar.f72n : iArr2[0];
        iVar.i = f2;
        int iA = lVar.a() / 2;
        float[] fArr3 = new float[iA];
        fArr3[0] = f2;
        ay ayVar = new ay();
        ay ayVar2 = new ay();
        for (int i6 = 1; i6 < iA; i6++) {
            int i7 = i6 - 1;
            lVar.d(i7 + i7, ayVar);
            lVar.d(i6 + i6, ayVar2);
            ay ayVar3 = new ay();
            ay.s(ayVar2, ayVar, ayVar3);
            if (z) {
                ayVar3.b = a(ayVar3.b);
            }
            fArr3[i6] = fArr3[i7] + ayVar3.d();
        }
        int i8 = iVar.k;
        h hVar = new h(iArr[i8]);
        hVar.d = f2;
        hVar.c = fArr3[Math.min(iA - 1, iVar.j)] - f2;
        hVar.b = 0.0f;
        hVar.e = gVar.m ? 0.0f : fArr[i8];
        k kVar = new k();
        ba baVarB = ba.b();
        ay ayVarA = baVarB.a();
        ay ayVarA2 = baVarB.a();
        ay ayVarC = lVar.c();
        if (ayVarC == null) {
            lVar.d(0, iVar.a);
            lVar.d(2, iVar.b);
            iVar.a();
            ay.o(iVar.e, ayVarA2);
            ay.j(iVar.a, o(iVar.e, hVar.e, kVar.a), ayVarA);
            ba baVarB2 = ba.b();
            ay ayVarA3 = baVarB2.a();
            ayVarA3.r(iVar.e);
            ay.m(ayVarA3, ayVarA3);
            ay ayVar4 = iVar.e;
            if (t(gVar.i) && !gVar.h) {
                ay ayVar5 = new ay();
                ay.s(ayVarA2, ayVar4, ayVar5);
                int[] iArr3 = b;
                q(vVar, gVar, ayVarA, iArr3[0], -1.0f, ayVar5, hVar);
                vVar.k();
                ay ayVarA4 = baVarB2.a();
                ay.j(ayVarA2, iVar.e, ayVarA4);
                q(vVar, gVar, ayVarA, iArr3[1], -1.0f, ayVarA4, hVar);
                baVarB2.c(ayVarA4);
            } else if (gVar.h) {
                q(vVar, gVar, ayVarA, b[2], iVar.i, ayVarA3, hVar);
            } else {
                q(vVar, gVar, ayVarA, b[2], iVar.i, ayVarA3, hVar);
            }
            int[] iArr4 = b;
            q(vVar, gVar, ayVarA, iArr4[2], iVar.i, ayVarA3, hVar);
            q(vVar, gVar, ayVarA, iArr4[3], iVar.i, ayVar4, hVar);
            baVarB2.c(ayVarA3);
        } else {
            iVar.a = ayVarC;
            lVar.d(0, iVar.b);
            lVar.d(2, iVar.c);
            iVar.a();
            u(vVar, gVar, hVar, iVar, kVar, fArr3, ayVarA, true);
        }
        iVar.l = 1;
        if (lVar.a() > 4) {
            int i9 = 2;
            while (i9 < lVar.a() - 2) {
                i9 += 2;
                lVar.d(i9, iVar.c);
                u(vVar, gVar, hVar, iVar, kVar, fArr3, ayVarA, false);
                iVar.l++;
            }
        } else {
            iVar.c.r(iVar.b);
            iVar.f.r(iVar.e);
        }
        float fD = iVar.i + iVar.d.d();
        iVar.i = fD;
        hVar.b = (fD - hVar.d) / hVar.c;
        ay ayVarB = lVar.b();
        if (ayVarB == null) {
            ay.j(iVar.c, o(iVar.f, hVar.e, kVar.a), ayVarA);
            if (t(gVar.j) && !gVar.h) {
                boolean z2 = gVar.e;
                int[] iArr5 = c;
                int iM = m(z2, iArr5[0]);
                float f3 = iVar.i;
                ay ayVar6 = iVar.f;
                ay ayVar7 = kVar.b;
                ay.m(ayVar6, ayVar7);
                q(vVar, gVar, ayVarA, iM, f3, ayVar7, hVar);
                q(vVar, gVar, ayVarA, m(gVar.e, iArr5[1]), iVar.i, iVar.f, hVar);
                float f4 = iVar.i + 2.0f;
                ay.o(iVar.f, ayVarA2);
                ay.m(ayVarA2, ayVarA2);
                int iM2 = m(gVar.e, iArr5[2]);
                ay ayVar8 = iVar.f;
                float f5 = -f4;
                ay ayVar9 = kVar.b;
                ay.s(ayVarA2, ayVar8, ayVar9);
                q(vVar, gVar, ayVarA, iM2, f5, ayVar9, hVar);
                int iM3 = m(gVar.e, iArr5[3]);
                ay ayVar10 = iVar.f;
                ay ayVar11 = kVar.b;
                ay.j(ayVarA2, ayVar10, ayVar11);
                q(vVar, gVar, ayVarA, iM3, f5, ayVar11, hVar);
                vVar.k();
            } else if (gVar.h) {
                gVar.o.d(2, iVar.c);
                ay ayVar12 = iVar.c;
                ay ayVar13 = iVar.b;
                ay ayVar14 = kVar.b;
                ay.s(ayVar12, ayVar13, ayVar14);
                if (gVar.l) {
                    ayVar14.b = a(ayVar14.b);
                }
                ay ayVar15 = iVar.f;
                ay.o(ayVar14, ayVar15);
                ay.n(ayVar15, ayVar15);
                ay.l(ayVar15, 255.0f, ayVar15);
                boolean z3 = ay.a(ay.a, iVar.d, ayVar14) > 0.0f;
                ay ayVar16 = iVar.e;
                ay ayVar17 = iVar.f;
                ay ayVar18 = iVar.b;
                ay ayVarN = n(ayVar16, ayVar17);
                ay ayVarO = o(ayVarN, hVar.e, kVar.a);
                ay ayVar19 = kVar.d;
                ay.j(ayVar18, ayVarO, ayVar19);
                r(vVar, gVar, ayVar19, iVar.e, iVar.f, ayVarN, iVar.i, hVar, hVar, false, z3);
                vVar.k();
            } else {
                int[] iArr6 = c;
                int i10 = iArr6[0];
                float f6 = iVar.i;
                ay ayVar20 = iVar.f;
                ay ayVar21 = kVar.b;
                ay.m(ayVar20, ayVar21);
                q(vVar, gVar, ayVarA, i10, f6, ayVar21, hVar);
                q(vVar, gVar, ayVarA, iArr6[1], iVar.i, iVar.f, hVar);
                vVar.k();
            }
        } else {
            iVar.c = ayVarB;
            u(vVar, gVar, hVar, iVar, kVar, fArr3, ayVarA, false);
            vVar.k();
        }
        baVarB.c(ayVarA);
        baVarB.c(ayVarA2);
    }

    static void f(int i, int[] iArr, int i2, int i3, int i4, float[] fArr, int i5, int i6, int i7, int i8, int[] iArr2, int i9, float[] fArr2, int[] iArr3, boolean z, float f2, int[] iArr4, int[] iArr5, v vVar) {
        e(new f(iArr, i, i2, i3, i4, z, iArr4, iArr5), fArr, i5, i6, i7, i8, iArr2, i9, fArr2, iArr3, z, f2, vVar);
        vVar.j();
    }

    static void g(float[] fArr, float f2, float f3, int[] iArr, float[] fArr2, float[] fArr3, float[] fArr4, float f4, float f5, v vVar) {
        float[] fArr5 = fArr;
        int length = fArr5.length;
        if (length < 4) {
            return;
        }
        int i = length >> 1;
        int i2 = (iArr == null || iArr.length == 0) ? i : iArr[0];
        float f6 = fArr2[0] * f4;
        float f7 = fArr3[0] * f4;
        float f8 = fArr4[0] * f4;
        if (f6 > 0.0f) {
            ba baVarB = ba.b();
            ay ayVarA = baVarB.a();
            ay ayVarA2 = baVarB.a();
            ay ayVarA3 = baVarB.a();
            float f9 = f8 + f5;
            ayVarA.b = a(fArr5[0] - f2);
            ayVarA.c = fArr5[1] - f3;
            ayVarA2.b = a(fArr5[2] - f2);
            ayVarA2.c = fArr5[3] - f3;
            ay.s(ayVarA2, ayVarA, ayVarA3);
            ayVarA3.b = a(ayVarA3.b);
            float fD = ayVarA3.d();
            ay ayVarA4 = baVarB.a();
            ay ayVarA5 = baVarB.a();
            float f10 = f6;
            float f11 = f7;
            float f12 = f9;
            int i3 = 0;
            int i4 = 0;
            boolean z = false;
            float f13 = 0.0f;
            int i5 = 1;
            int i6 = i2;
            float f14 = fD;
            int i7 = 0;
            while (i7 < i) {
                int i8 = i7;
                if (i3 >= 20) {
                    break;
                }
                float f15 = f12 - f5;
                float f16 = f15 - f13;
                float f17 = f13;
                float fD2 = f14;
                int i9 = i8;
                while (f16 > fD2) {
                    int i10 = i5 + 1;
                    if (i10 == i) {
                        z = true;
                        int i11 = i5;
                        i5 = i10;
                        i9 = i11;
                        break;
                    }
                    ayVarA.r(ayVarA2);
                    int i12 = i10 + i10;
                    ayVarA2.b = a(fArr5[i12] - f2);
                    ayVarA2.c = fArr5[i12 + 1] - f3;
                    ay.s(ayVarA2, ayVarA, ayVarA3);
                    ayVarA3.b = a(ayVarA3.b);
                    f17 += fD2;
                    fD2 = ayVarA3.d();
                    f16 = f15 - f17;
                    i9 = i5;
                    i5 = i10;
                }
                if (z) {
                    break;
                }
                ay.l(ayVarA3, f16 / fD2, ayVarA4);
                ay.j(ayVarA4, ayVarA, ayVarA4);
                ayVarA4.b = a(ayVarA4.b);
                ayVarA5.r(ayVarA3);
                float f18 = f10 / 2.0f;
                ay ayVar = ayVarA3;
                ba baVarB2 = ba.b();
                ay.n(ayVarA5, ayVarA5);
                ay.o(ayVarA5, ayVarA5);
                ay ayVarA6 = baVarB2.a();
                int i13 = i;
                ay ayVarA7 = baVarB2.a();
                ay ayVar2 = ayVarA2;
                ay ayVarA8 = baVarB2.a();
                ay ayVar3 = ayVarA;
                ay ayVarA9 = baVarB2.a();
                int i14 = i9;
                float f19 = -f18;
                s(f19, f18, ayVarA5, ayVarA6);
                s(f19, f19, ayVarA5, ayVarA7);
                s(f18, f19, ayVarA5, ayVarA8);
                s(f18, f18, ayVarA5, ayVarA9);
                boolean zN = vVar.n(vVar.f + 6);
                int i15 = i6;
                int i16 = i3;
                float f20 = f12;
                ay ayVar4 = ayVarA4;
                ay ayVar5 = ayVarA5;
                vVar.f(ayVarA6.b + ayVarA4.b, ayVarA6.c + ayVarA4.c, f20, 0, 1);
                vVar.f(ayVarA7.b + ayVar4.b, ayVarA7.c + ayVar4.c, f20, 0, 0);
                vVar.f(ayVarA8.b + ayVar4.b, ayVarA8.c + ayVar4.c, f20, 1, 0);
                vVar.f(ayVarA6.b + ayVar4.b, ayVarA6.c + ayVar4.c, f20, 0, 1);
                vVar.f(ayVarA8.b + ayVar4.b, ayVarA8.c + ayVar4.c, f20, 1, 0);
                vVar.f(ayVarA9.b + ayVar4.b, ayVarA9.c + ayVar4.c, f20, 1, 1);
                baVarB2.c(ayVarA6);
                baVarB2.c(ayVarA7);
                baVarB2.c(ayVarA8);
                baVarB2.c(ayVarA9);
                i3 = !zN ? i16 + 1 : i16;
                if (i14 >= i15) {
                    i4++;
                    int i17 = (iArr == null || i4 >= iArr.length) ? i13 : iArr[i4];
                    if (i4 < fArr2.length) {
                        f10 = f4 * fArr2[i4];
                    }
                    if (i4 < fArr3.length) {
                        f11 = fArr3[i4] * f4;
                    }
                    i6 = i17;
                } else {
                    i6 = i15;
                }
                f12 += f10 + f11;
                fArr5 = fArr;
                ayVarA5 = ayVar5;
                i7 = i14;
                ayVarA4 = ayVar4;
                f14 = fD2;
                f13 = f17;
                i = i13;
                ayVarA2 = ayVar2;
                ayVarA = ayVar3;
                ayVarA3 = ayVar;
            }
            vVar.j();
            baVarB.c(ayVarA4);
            baVarB.c(ayVarA5);
            baVarB.c(ayVarA);
            baVarB.c(ayVarA2);
            baVarB.c(ayVarA3);
        }
    }

    static void h(int[] iArr, int i, int i2, int[] iArr2, float[] fArr, float[] fArr2, float[] fArr3, float f2, float f3, v vVar) {
        int length = iArr.length;
        if (length < 4) {
            return;
        }
        float[] fArr4 = new float[length];
        for (int i3 = 0; i3 < iArr.length; i3 += 2) {
            fArr4[i3] = iArr[i3] - i;
            int i4 = i3 + 1;
            fArr4[i4] = iArr[i4] - i2;
        }
        g(fArr4, 0.0f, 0.0f, iArr2, fArr, fArr2, fArr3, f2, f3, vVar);
    }

    static void i(int i, int i2, float[] fArr, v vVar) {
        j jVarD = d(fArr);
        int i3 = jVarD.a;
        int i4 = jVarD.b;
        byte[] bArrO = vVar.o(i);
        vVar.m(i2, bArrO);
        byte[] bArr = vVar.d;
        bArr[0] = (byte) i3;
        bArr[1] = (byte) (i3 >>> 8);
        bArr[2] = (byte) (i3 >>> 16);
        bArr[3] = (byte) (i3 >> 24);
        bArr[4] = (byte) i4;
        bArr[5] = (byte) (i4 >>> 8);
        bArr[6] = (byte) (i4 >>> 16);
        bArr[7] = (byte) (i4 >> 24);
        int i5 = vVar.e;
        while (i5 < bArrO.length) {
            byte[] bArr2 = vVar.d;
            bArrO[i5] = bArr2[0];
            bArrO[i5 + 1] = bArr2[1];
            bArrO[i5 + 2] = bArr2[2];
            bArrO[i5 + 3] = bArr2[3];
            bArrO[i5 + 4] = bArr2[4];
            bArrO[i5 + 5] = bArr2[5];
            bArrO[i5 + 6] = bArr2[6];
            bArrO[i5 + 7] = bArr2[7];
            i5 += vVar.c;
        }
        vVar.i(bArrO);
    }

    private static float j(ay ayVar, ay ayVar2) {
        return (float) Math.atan2(ay.a(ay.a, ayVar, ayVar2), ayVar.c(ayVar2));
    }

    private static float k(ay ayVar, ay ayVar2, ay ayVar3, ay ayVar4, ay ayVar5) {
        ay.s(ayVar2, ayVar, ayVar4);
        ay.s(ayVar3, ayVar, ayVar5);
        return ayVar5.c(ayVar4) / ayVar4.c(ayVar4);
    }

    private static int l(v vVar, g gVar, h hVar, int i) {
        int i2;
        int i3;
        int i4;
        int i5 = i << 24;
        if (vVar.b) {
            int i6 = i5 & ViewCompat.MEASURED_STATE_MASK;
            int i7 = gVar.f;
            float f2 = hVar.b * 255.0f;
            i4 = hVar.a & 255;
            i2 = i6 | ((i7 << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
            i3 = 16711680 & (((int) f2) << 16);
        } else {
            i2 = i5 & ViewCompat.MEASURED_STATE_MASK;
            i3 = gVar.g;
            i4 = hVar.a & 255;
        }
        return i2 | i3 | i4;
    }

    private static int m(boolean z, int i) {
        return z ? i : i + 8;
    }

    private static ay n(ay ayVar, ay ayVar2) {
        ay ayVar3 = new ay();
        ay.j(ayVar, ayVar2, ayVar3);
        double dAbs = Math.abs(255.0d / Math.cos(j(ayVar, ayVar2) / 2.0f));
        ay.n(ayVar3, ayVar3);
        ay.l(ayVar3, (float) dAbs, ayVar3);
        return ayVar3;
    }

    private static ay o(ay ayVar, float f2, ay ayVar2) {
        if (f2 == 0.0f) {
            ayVar2.q(0.0f, 0.0f);
            return ayVar2;
        }
        float fD = ayVar.d();
        if (fD == 0.0f) {
            ayVar2.r(ayVar);
            return ayVar2;
        }
        ay.l(ayVar, f2 / fD, ayVar2);
        return ayVar2;
    }

    private static void q(v vVar, g gVar, ay ayVar, int i, float f2, ay ayVar2, h hVar) {
        j jVar = gVar.d;
        if (gVar.e) {
            int iL = l(vVar, gVar, hVar, i);
            float f3 = vVar.h * f2;
            double d2 = f3 >= 0.0f ? 1.0d : -1.0d;
            int iMin = ((int) Math.min(65535.0d, ((d2 * Math.min(((double) f3) * d2, 131068.0d)) + 131068.0d) * 0.25d)) | ((b(ayVar2.b) << 16) & 16711680) | ((b(ayVar2.c) << 24) & ViewCompat.MEASURED_STATE_MASK);
            if (jVar == null) {
                vVar.d(vVar.i, ayVar.b, ayVar.c, 0.0f);
                vVar.i.putInt(iL);
                vVar.i.putInt(iMin);
                vVar.f++;
                return;
            }
            vVar.d(vVar.i, ayVar.b, ayVar.c, 0.0f);
            vVar.i.putInt(iL);
            vVar.i.putInt(iMin);
            vVar.i.putInt(jVar.a);
            vVar.i.putInt(jVar.b);
            vVar.f++;
            return;
        }
        int iL2 = l(vVar, gVar, hVar, i);
        int iC = c(ayVar2.b);
        int iC2 = c(ayVar2.c);
        int i2 = (iC >> 8) | ((iC2 << 8) & 16711680) | ((iC2 << 24) & ViewCompat.MEASURED_STATE_MASK) | (65280 & (iC << 8));
        if (jVar == null) {
            vVar.d(vVar.i, ayVar.b, ayVar.c, f2);
            vVar.i.putInt(iL2);
            vVar.i.putInt(i2);
            vVar.f++;
            return;
        }
        vVar.d(vVar.i, ayVar.b, ayVar.c, f2);
        vVar.i.putInt(iL2);
        vVar.i.putInt(i2);
        vVar.i.putInt(jVar.a);
        vVar.i.putInt(jVar.b);
        vVar.f++;
    }

    private static void r(v vVar, g gVar, ay ayVar, ay ayVar2, ay ayVar3, ay ayVar4, float f2, h hVar, h hVar2, boolean z, boolean z2) {
        ay ayVar5;
        ay ayVar6;
        ay ayVar7;
        ay ayVar8;
        ay ayVar9;
        ay ayVar10;
        ay ayVar11;
        ba baVarB = ba.b();
        ay ayVarA = baVarB.a();
        ayVarA.r(ayVar2);
        ay.m(ayVarA, ayVarA);
        ay ayVarA2 = baVarB.a();
        ayVarA2.r(ayVar2);
        ay ayVarA3 = baVarB.a();
        ayVarA3.q(0.0f, 0.0f);
        ay ayVarA4 = baVarB.a();
        ayVarA4.r(ayVar3);
        ay.m(ayVarA4, ayVarA4);
        ay ayVarA5 = baVarB.a();
        ayVarA5.r(ayVar3);
        ay ayVarA6 = baVarB.a();
        ayVarA6.r(ayVar4);
        ay.m(ayVarA6, ayVarA6);
        ay ayVarA7 = baVarB.a();
        ayVarA7.r(ayVar4);
        if (z2) {
            int[] iArr = e;
            ayVar5 = ayVarA7;
            ayVar6 = ayVarA6;
            q(vVar, gVar, ayVar, iArr[0], f2, ayVarA, hVar);
            q(vVar, gVar, ayVar, iArr[1], f2, ayVarA2, hVar);
            q(vVar, gVar, ayVar, iArr[0], f2, ayVarA, hVar);
            q(vVar, gVar, ayVar, iArr[2], f2, ayVarA3, hVar);
            ay ayVar12 = new ay();
            ay.m(ayVar2, ayVar12);
            ay ayVar13 = new ay();
            ay.m(ayVar3, ayVar13);
            p(vVar, gVar, ayVar, f2, hVar, ayVar12, ayVar13, iArr[0]);
            q(vVar, gVar, ayVar, iArr[3], f2, ayVarA4, hVar);
            q(vVar, gVar, ayVar, iArr[4], f2, ayVarA5, hVar);
            if (z) {
                q(vVar, gVar, ayVar, iArr[3], f2, ayVarA4, hVar2);
                q(vVar, gVar, ayVar, iArr[4], f2, ayVarA5, hVar2);
            }
            ayVar9 = ayVarA3;
            ayVar10 = ayVarA4;
            ayVar8 = ayVarA2;
            ayVar11 = ayVarA5;
            ayVar7 = ayVarA;
        } else {
            ayVar5 = ayVarA7;
            ayVar6 = ayVarA6;
            int[] iArr2 = e;
            q(vVar, gVar, ayVar, iArr2[0], f2, ayVarA, hVar);
            q(vVar, gVar, ayVar, iArr2[1], f2, ayVarA2, hVar);
            q(vVar, gVar, ayVar, iArr2[2], f2, ayVarA3, hVar);
            p(vVar, gVar, ayVar, f2, hVar, ayVar2, ayVar3, iArr2[4]);
            ayVar7 = ayVarA;
            ayVar8 = ayVarA2;
            ayVar9 = ayVarA3;
            ayVar10 = ayVarA4;
            ayVar11 = ayVarA5;
            q(vVar, gVar, ayVar, iArr2[4], f2, ayVarA5, hVar);
            q(vVar, gVar, ayVar, iArr2[3], f2, ayVar10, hVar);
            q(vVar, gVar, ayVar, iArr2[4], f2, ayVar11, hVar);
            if (z) {
                q(vVar, gVar, ayVar, iArr2[3], f2, ayVar10, hVar2);
                q(vVar, gVar, ayVar, iArr2[4], f2, ayVar11, hVar2);
            }
        }
        baVarB.c(ayVar7);
        baVarB.c(ayVar8);
        baVarB.c(ayVar9);
        baVarB.c(ayVar10);
        baVarB.c(ayVar11);
        baVarB.c(ayVar6);
        baVarB.c(ayVar5);
    }

    private static void s(float f2, float f3, ay ayVar, ay ayVar2) {
        ayVar2.q(f2, f3);
        ay.g(ayVar2, ayVar, ayVar2);
    }

    private static boolean t(int i) {
        return i == 2 || i == 1 || i == 4;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0157  */
    /* JADX WARN: Code duplicated, block: B:36:0x0171  */
    /* JADX WARN: Code duplicated, block: B:38:0x017b  */
    /* JADX WARN: Code duplicated, block: B:39:0x017e  */
    /* JADX WARN: Code duplicated, block: B:41:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:44:0x01b0  */
    /* JADX WARN: Code duplicated, block: B:46:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:47:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:48:0x0206  */
    private static void u(v vVar, g gVar, h hVar, i iVar, k kVar, float[] fArr, ay ayVar, boolean z) {
        h hVar2;
        ay ayVar2;
        float f2;
        ay ayVar3;
        ay ayVar4;
        int i;
        int[] iArr;
        int i2;
        ay ayVar5;
        int i3 = iVar.l;
        int i4 = iVar.j;
        float f3 = fArr[i3];
        iVar.i = f3;
        hVar.b = (f3 - hVar.d) / hVar.c;
        ay.s(iVar.c, iVar.b, iVar.g);
        if (gVar.l) {
            ay ayVar6 = iVar.g;
            ayVar6.b = a(ayVar6.b);
        }
        boolean z2 = true;
        boolean z3 = i3 >= i4;
        ay ayVar7 = iVar.g;
        ay ayVar8 = iVar.f;
        ay.o(ayVar7, ayVar8);
        ay.n(ayVar8, ayVar8);
        ay.l(ayVar8, 255.0f, ayVar8);
        boolean z4 = ay.a(ay.a, iVar.d, iVar.g) > 0.0f;
        ay.j(iVar.e, iVar.f, iVar.h);
        float fC = iVar.f.c(iVar.h);
        if (fC <= 1.0f || iVar.d.c(iVar.g) < 0.0f) {
            hVar2 = new h(hVar);
            ay ayVar9 = iVar.b;
            ay ayVarO = o(iVar.h, hVar.e, kVar.a);
            ayVar2 = kVar.b;
            ay.j(ayVar9, ayVarO, ayVar2);
            if (z3) {
                i = iVar.k + 1;
                iVar.k = i;
                iArr = gVar.a;
                if (i < iArr.length) {
                    i2 = iArr[i];
                } else {
                    i2 = gVar.f72n;
                }
                iVar.j = i2;
                hVar.e = gVar.c[i];
                hVar.a = gVar.b[i];
                hVar.b = 0.0f;
                float f4 = fArr[Math.min(fArr.length - 1, i2)];
                float f5 = fArr[iVar.l];
                hVar.c = f4 - f5;
                hVar.d = f5;
            } else {
                z2 = false;
            }
            iVar.h = n(iVar.e, iVar.f);
            if (z) {
                ay ayVar10 = iVar.f;
                ay ayVar11 = iVar.h;
                f2 = iVar.i;
                ayVar3 = new ay(ayVar10);
                ay.m(ayVar3, ayVar3);
                ayVar4 = new ay(ayVar10);
                ay ayVar12 = new ay(ayVar11);
                ay.m(ayVar12, ayVar12);
                new ay(ayVar11);
                if (z4) {
                    int[] iArr2 = e;
                    q(vVar, gVar, ayVar2, iArr2[3], f2, ayVar3, hVar);
                    vVar.k();
                    q(vVar, gVar, ayVar2, iArr2[4], f2, ayVar4, hVar);
                } else {
                    int[] iArr3 = e;
                    q(vVar, gVar, ayVar2, iArr3[3], f2, ayVar3, hVar);
                    vVar.k();
                    q(vVar, gVar, ayVar2, iArr3[4], f2, ayVar4, hVar);
                }
            } else {
                r(vVar, gVar, ayVar2, iVar.e, iVar.f, iVar.h, iVar.i, hVar2, hVar, z2, z4);
            }
        } else {
            ay ayVar13 = iVar.h;
            ay.l(ayVar13, 65025.0f / fC, ayVar13);
            if (z4) {
                ay ayVar14 = iVar.b;
                ay ayVar15 = iVar.h;
                ayVar5 = kVar.d;
                ay.j(ayVar14, ayVar15, ayVar5);
            } else {
                ay ayVar16 = iVar.b;
                ay ayVar17 = iVar.h;
                ayVar5 = kVar.d;
                ay.s(ayVar16, ayVar17, ayVar5);
            }
            if (gVar.m || k(iVar.b, iVar.a, ayVar5, kVar.b, kVar.c) >= 0.5f || k(iVar.b, iVar.c, ayVar5, kVar.b, kVar.c) >= 0.5f) {
                hVar2 = new h(hVar);
                ay ayVar18 = iVar.b;
                ay ayVarO2 = o(iVar.h, hVar.e, kVar.a);
                ayVar2 = kVar.b;
                ay.j(ayVar18, ayVarO2, ayVar2);
                if (z3) {
                    i = iVar.k + 1;
                    iVar.k = i;
                    iArr = gVar.a;
                    if (i < iArr.length) {
                        i2 = iArr[i];
                    } else {
                        i2 = gVar.f72n;
                    }
                    iVar.j = i2;
                    hVar.e = gVar.c[i];
                    hVar.a = gVar.b[i];
                    hVar.b = 0.0f;
                    float f6 = fArr[Math.min(fArr.length - 1, i2)];
                    float f7 = fArr[iVar.l];
                    hVar.c = f6 - f7;
                    hVar.d = f7;
                } else {
                    z2 = false;
                }
                iVar.h = n(iVar.e, iVar.f);
                if (z) {
                    ay ayVar19 = iVar.f;
                    ay ayVar110 = iVar.h;
                    f2 = iVar.i;
                    ayVar3 = new ay(ayVar19);
                    ay.m(ayVar3, ayVar3);
                    ayVar4 = new ay(ayVar19);
                    ay ayVar111 = new ay(ayVar110);
                    ay.m(ayVar111, ayVar111);
                    new ay(ayVar110);
                    if (z4) {
                        int[] iArr4 = e;
                        q(vVar, gVar, ayVar2, iArr4[3], f2, ayVar3, hVar);
                        vVar.k();
                        q(vVar, gVar, ayVar2, iArr4[4], f2, ayVar4, hVar);
                    } else {
                        int[] iArr5 = e;
                        q(vVar, gVar, ayVar2, iArr5[3], f2, ayVar3, hVar);
                        vVar.k();
                        q(vVar, gVar, ayVar2, iArr5[4], f2, ayVar4, hVar);
                    }
                } else {
                    r(vVar, gVar, ayVar2, iVar.e, iVar.f, iVar.h, iVar.i, hVar2, hVar, z2, z4);
                }
            } else {
                ay.j(iVar.b, o(iVar.h, hVar.e, kVar.a), ayVar);
                int[] iArr6 = d;
                int i5 = iArr6[0];
                float f8 = iVar.i;
                ay ayVar20 = iVar.h;
                ay ayVar21 = kVar.b;
                ay.m(ayVar20, ayVar21);
                q(vVar, gVar, ayVar, i5, f8, ayVar21, hVar);
                q(vVar, gVar, ayVar, iArr6[1], iVar.i, iVar.h, hVar);
                if (z3) {
                    int i6 = iVar.k + 1;
                    iVar.k = i6;
                    int[] iArr7 = gVar.a;
                    int i7 = i6 < iArr7.length ? iArr7[i6] : gVar.f72n;
                    iVar.j = i7;
                    float f9 = gVar.c[i6];
                    hVar.e = f9;
                    hVar.a = gVar.b[i6];
                    hVar.b = 0.0f;
                    float f10 = fArr[Math.min(fArr.length - 1, i7)];
                    float f11 = fArr[iVar.l];
                    hVar.c = f10 - f11;
                    hVar.d = f11;
                    ay.j(iVar.b, o(iVar.h, f9, kVar.a), ayVar);
                    int i8 = iArr6[0];
                    float f12 = iVar.i;
                    ay ayVar22 = iVar.h;
                    ay ayVar23 = kVar.b;
                    ay.m(ayVar22, ayVar23);
                    q(vVar, gVar, ayVar, i8, f12, ayVar23, hVar);
                    q(vVar, gVar, ayVar, iArr6[1], iVar.i, iVar.h, hVar);
                }
            }
        }
        iVar.e.r(iVar.f);
        iVar.d.r(iVar.g);
        iVar.a.r(iVar.b);
        iVar.b.r(iVar.c);
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0073 A[LOOP:0: B:19:0x0070->B:21:0x0073, LOOP_END] */
    private static void p(v vVar, g gVar, ay ayVar, float f2, h hVar, ay ayVar2, ay ayVar3, int i) {
        ay[] ayVarArr;
        int iAbs;
        ay[] ayVarArr2;
        int i2;
        int i3 = gVar.k;
        if (i3 != 0) {
            float fJ = j(ayVar2, ayVar3);
            if (i3 != 1) {
                if (i3 != 2 || (iAbs = (int) (((double) (Math.abs(fJ) * 10.0f)) / 3.141592653589793d)) <= 0) {
                    ayVarArr = new ay[0];
                }
                for (ay ayVar4 : ayVarArr2) {
                    q(vVar, gVar, ayVar, i, f2, ayVar4, hVar);
                    q(vVar, gVar, ayVar, e[2], f2, ay.a, hVar);
                }
            }
            iAbs = 2;
            ay[] ayVarArr3 = new ay[iAbs - 1];
            for (int i4 = 1; i4 < iAbs; i4++) {
                ay ayVar5 = new ay();
                double d2 = (i4 * fJ) / iAbs;
                double dCos = ((double) ayVar2.b) * Math.cos(d2);
                double d3 = ayVar2.c;
                ayVar5.b = (float) (dCos - (Math.sin(d2) * d3));
                ayVar5.c = (float) ((((double) ayVar2.b) * Math.sin(d2)) + (d3 * Math.cos(d2)));
                ayVarArr3[i4 - 1] = ayVar5;
            }
            ayVarArr2 = ayVarArr3;
            while (i2 < ayVarArr2.length) {
                q(vVar, gVar, ayVar, i, f2, ayVar4, hVar);
                q(vVar, gVar, ayVar, e[2], f2, ay.a, hVar);
            }
        }
        ayVarArr = new ay[0];
        ayVarArr2 = ayVarArr;
        while (i2 < ayVarArr2.length) {
            q(vVar, gVar, ayVar, i, f2, ayVar4, hVar);
            q(vVar, gVar, ayVar, e[2], f2, ay.a, hVar);
        }
    }
}
