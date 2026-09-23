package com.google.android.libraries.geo.mapcore.internal.vector.gl;

import com.google.android.libraries.geo.mapcore.renderer.bq;
import com.google.android.libraries.geo.mapcore.renderer.bt;
import com.google.android.libraries.navigation.internal.oe.ad;
import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.oe.x;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class GeometryUtil {
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.geo.mapcore.internal.vector.gl.GeometryUtil");
    public static final float a = ((float) Math.sqrt(2.0d)) * 255.0f;
    private static c c = new b();

    public static c getGeometryUtilFactory() {
        return c;
    }

    public static int getMaxGeneratedVerticesForLine(int i, int i2, int i3) {
        int i4;
        if (i == 0) {
            return 0;
        }
        if (i2 != 0) {
            i4 = i2 != 1 ? 24 : 8;
        } else {
            i4 = 6;
        }
        return ((i - 1) * i4) + 6 + i3 + i3;
    }

    public static int getMaxGeneratedVerticesForPointSpriteLine(float f, float f2, float f3) {
        if (f3 > 0.0f) {
            return (((int) Math.ceil((f * 1.1f) / (f2 * f3))) + 1) * 6;
        }
        return 25;
    }

    public static int getMaxVerticesForExtrudedPolyline(ad adVar) {
        return (adVar.e() * 8) + 6;
    }

    public static void setGeometryUtilFactoryForTest(c cVar) {
        c = cVar;
    }

    public void addExtrudedMultiSegmentRoadsWithNormals(float[] fArr, int[] iArr, float f, float f2, float[] fArr2, v vVar, int i, int i2, int i3, float f3, int[] iArr2, boolean z, float[] fArr3, float[] fArr4, float[] fArr5, float f4, int i4, float f5) {
        if (z) {
            m.g(fArr, f, f2, iArr, fArr3, fArr4, fArr5, f4, f5, vVar);
            return;
        }
        int i5 = m.a;
        m.e(new e(fArr, fArr.length, f, f2), fArr2, i, i2, i3, (int) (4.0f * f3), iArr2, i4, null, iArr, false, f5, vVar);
        vVar.j();
    }

    public void addExtrudedPolyline(ad adVar, float f, x xVar, float f2, float f3, boolean z, v vVar) {
        int i;
        if (adVar.e() - 1 > 0) {
            int[] iArr = adVar.b;
            int iE = adVar.e();
            int i2 = xVar.a;
            int i3 = xVar.b;
            if (iE <= 1) {
                return;
            }
            int i4 = vVar.f;
            x xVar2 = new x(i2, i3);
            x xVar3 = new x(iArr[0], iArr[1]);
            x xVar4 = new x();
            x xVar5 = new x();
            x xVar6 = new x();
            x xVar7 = new x();
            x xVar8 = new x();
            x xVar9 = new x();
            x xVar10 = new x();
            x xVar11 = new x();
            x xVar12 = xVar7;
            x xVar13 = new x();
            x.N(xVar3, xVar2, xVar3);
            x xVar14 = xVar5;
            int i5 = 1;
            float f4 = 0.0f;
            while (i5 < iE) {
                int i6 = i5 + i5;
                int i7 = i4;
                int i8 = iE;
                xVar4.J(iArr[i6], iArr[i6 + 1]);
                x.N(xVar4, xVar2, xVar4);
                x.N(xVar4, xVar3, xVar6);
                int i9 = xVar6.a;
                x xVar15 = xVar2;
                int[] iArr2 = iArr;
                int i10 = xVar6.b;
                int i11 = i5;
                x xVar16 = xVar6;
                float fHypot = (float) Math.hypot(i9, i10);
                if (fHypot == 0.0f) {
                    xVar8.J((int) f, 0);
                } else {
                    int i12 = -i10;
                    xVar8.a = i12;
                    xVar8.b = i9;
                    ay ayVar = new ay(i12, i9);
                    ay.l(ayVar, f / fHypot, ayVar);
                    xVar8.J((int) ayVar.b, (int) ayVar.c);
                }
                float f5 = true != z ? f3 : f4;
                f4 += fHypot * f2;
                float f6 = true != z ? f3 : f4;
                x.N(xVar3, xVar8, xVar9);
                x.F(xVar3, xVar8, xVar10);
                x.N(xVar4, xVar8, xVar11);
                x.F(xVar4, xVar8, xVar13);
                vVar.g(xVar10, 0.0f, f5);
                vVar.g(xVar9, 1.0f, f5);
                vVar.g(xVar11, 1.0f, f6);
                vVar.g(xVar13, 0.0f, f6);
                vVar.g(xVar4, 0.5f, f6);
                xVar3.W(xVar4);
                i5 = i11 + 1;
                xVar2 = xVar15;
                i4 = i7;
                iE = i8;
                iArr = iArr2;
                xVar6 = xVar16;
            }
            int i13 = iE;
            int[] iArr3 = iArr;
            int i14 = i4;
            x xVar17 = xVar6;
            int i15 = i13 - 1;
            for (int i16 = 0; i16 < i15; i16++) {
                int i17 = i14 + (i16 * 5);
                int i18 = i17 + 2;
                vVar.e(i17, i17 + 1, i18);
                vVar.e(i17, i18, i17 + 3);
            }
            int i19 = 0;
            while (true) {
                i = i13 - 2;
                if (i19 >= i) {
                    break;
                }
                int i20 = i19 + i19;
                xVar3.J(iArr3[i20], iArr3[i20 + 1]);
                xVar4.J(iArr3[i20 + 2], iArr3[i20 + 3]);
                x xVar18 = xVar14;
                xVar18.J(iArr3[i20 + 4], iArr3[i20 + 5]);
                x xVar19 = xVar17;
                x.N(xVar4, xVar3, xVar19);
                x xVar20 = xVar12;
                x.N(xVar18, xVar4, xVar20);
                int i21 = i14 + (i19 * 5);
                int i22 = i21 + 4;
                int i23 = i21 + 5;
                if (ay.a(ay.a, new ay(xVar19.a, xVar19.b), new ay(xVar20.a, xVar20.b)) > 0.0f) {
                    vVar.e(i21 + 2, i21 + 6, i22);
                } else {
                    vVar.e(i21 + 3, i22, i23);
                }
                i19++;
                xVar17 = xVar19;
                xVar12 = xVar20;
                xVar14 = xVar18;
            }
            x xVar21 = xVar12;
            x xVar22 = xVar14;
            x xVar23 = xVar17;
            int i24 = i13 + i13;
            int i25 = iArr3[0];
            int i26 = iArr3[i24 - 2];
            if (i25 == i26) {
                int i27 = iArr3[1];
                int i28 = iArr3[i24 - 1];
                if (i27 == i28) {
                    xVar3.J(i26, i28);
                    xVar4.J(iArr3[0], iArr3[1]);
                    xVar22.J(iArr3[2], iArr3[3]);
                    x.N(xVar4, xVar3, xVar23);
                    x.N(xVar22, xVar4, xVar21);
                    int i29 = i14 + (i * 5);
                    if (ay.a(ay.a, new ay(xVar23.a, xVar23.b), new ay(xVar21.a, xVar21.b)) > 0.0f) {
                        vVar.e(i29 + 2, i14 + 1, i29 + 4);
                    } else {
                        vVar.e(i29 + 3, i14 + 4, i14);
                    }
                }
            }
            vVar.j();
        }
    }

    public void addExtrudedRoadsWithNormals(int[] iArr, int[] iArr2, x xVar, float f, v vVar, int i, int i2, int i3, float f2, int i4, boolean z, float f3, float f4, float f5, float f6, int i5, float f7) {
        float[] fArr;
        int length = iArr.length >> 1;
        int i6 = 0;
        int length2 = iArr2 != null ? iArr2.length : 0;
        float[] fArr2 = {f};
        int[] iArr3 = {i4};
        float[] fArr3 = {f3};
        float[] fArr4 = {f4};
        float[] fArr5 = {f5};
        int i7 = 0;
        while (i7 <= length2) {
            int i8 = i7 < length2 ? iArr2[i7] : length;
            int i9 = i8 - i6;
            int[] iArr4 = {i9};
            if (z) {
                m.h(iArr, xVar.a, xVar.b, iArr2, fArr3, fArr4, fArr5, f6, f7, vVar);
                fArr = fArr2;
            } else {
                fArr = fArr2;
                m.f(i9 + i9, iArr, i6 + i6, xVar.a, xVar.b, fArr, i, i2, i3, (int) (4.0f * f2), iArr3, i5, null, iArr4, false, f7, null, null, vVar);
            }
            i7++;
            fArr2 = fArr;
            fArr3 = fArr3;
            length2 = length2;
            i6 = i8;
            fArr5 = fArr5;
            fArr4 = fArr4;
        }
    }

    public void addExtrudedRoadsWithNormalsAndWidths(int[] iArr, int[] iArr2, x xVar, float f, v vVar, int i, int i2, int i3, float f2, int i4, int i5, float[] fArr) {
        if (bt.a().b()) {
            ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1311)).p("addExtrudedRoadsWithNormalsAndWidths called with vertex shader texture fetching enabled");
        }
        int length = iArr.length >> 1;
        int i6 = 0;
        int length2 = iArr2 != null ? iArr2.length : 0;
        float[] fArr2 = {f};
        int[] iArr3 = {i4};
        int i7 = 0;
        while (i6 <= length2) {
            int i8 = i6 < length2 ? iArr2[i6] : length;
            int i9 = i8 - i7;
            m.f(i9 + i9, iArr, i7 + i7, xVar.a, xVar.b, fArr2, i, i2, i3, (int) (f2 * 4.0f), iArr3, i5, fArr, new int[]{i9}, false, 0.0f, null, null, vVar);
            i6++;
            i7 = i8;
            length2 = length2;
        }
    }

    public void copyExtrudedRoadsWithNormals(v vVar, int i, int i2, int i3) {
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = m.a;
            byte[] bArrO = vVar.o(i + i4);
            vVar.m(i3, bArrO);
            vVar.i(bArrO);
        }
    }

    public void copyExtrudedRoadsWithNormalsAndWidths(v vVar, int i, int i2, int i3, float[] fArr) {
        for (int i4 = 0; i4 < i2; i4++) {
            m.i(i + i4, i3, fArr, vVar);
        }
    }

    public v getBuilder(String str, int i, boolean z, int i2, int i3, bq bqVar) {
        return v.b(str, i3, i, z, i2, false, bqVar);
    }

    public v getBuilderWithNormalizedDistance(String str, int i, boolean z, int i2, int i3, bq bqVar) {
        return v.b(str, i3, i, z, i2, true, bqVar);
    }

    public boolean supportsVertexTextureFetching() {
        return bt.a().b();
    }

    public void addExtrudedMultiSegmentRoadsWithNormals(int[] iArr, int[] iArr2, x xVar, float[] fArr, v vVar, int i, int i2, int i3, float f, int[] iArr3, boolean z, float[] fArr2, float[] fArr3, float[] fArr4, boolean z2, float f2, float f3, int[] iArr4, int[] iArr5) {
        if (z) {
            m.h(iArr, xVar.a, xVar.b, iArr2, fArr2, fArr3, fArr4, f2, f3, vVar);
        } else {
            m.f(iArr.length, iArr, 0, xVar.a, xVar.b, fArr, i, i2, i3, (int) (4.0f * f), iArr3, 0, null, iArr2, z2, f3, iArr4, iArr5, vVar);
        }
    }
}
