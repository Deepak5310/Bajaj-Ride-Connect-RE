package com.google.android.libraries.geo.mapcore.internal.legacy.vector.gl.drawable;

import com.google.android.libraries.geo.mapcore.internal.model.bt;
import com.google.android.libraries.navigation.internal.agg.de;
import com.google.android.libraries.navigation.internal.agg.er;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class u {
    public final int[] a;
    public final int[] b;
    public final float[] c;
    public int[] d;
    public int[] e;
    public float[] f;
    public float[] g;
    public float h;
    public final int[] i;
    public final bt[] j;

    public u(int[] iArr, int[] iArr2, int[] iArr3, float[] fArr) {
        int[] iArrM;
        int length;
        int i;
        this.a = iArr;
        this.i = iArr2;
        this.j = new bt[iArr2.length];
        int length2 = iArr3.length;
        if (length2 > 0) {
            int i2 = iArr.length == 0 ? length2 >> 1 : iArr[0];
            de deVar = new de(length2);
            de deVar2 = new de();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                length = iArr3.length;
                i = length - 2;
                if (i3 >= i) {
                    break;
                }
                int i5 = i3 + 2;
                int i6 = iArr3[i3];
                int i7 = iArr3[i3 + 1];
                deVar.c(i6);
                deVar.c(i7);
                int i8 = 1;
                if ((i3 / 2) + 1 == i2) {
                    i4++;
                    i2 = i4 < iArr.length ? iArr[i4] : length >> 1;
                } else {
                    int i9 = iArr3[i5];
                    int i10 = iArr3[i3 + 3];
                    int iS = com.google.android.libraries.navigation.internal.oe.x.s(i9 - i6);
                    int iAbs = Math.abs(iS) / 153391689;
                    if (iAbs > 0) {
                        int i11 = iAbs + 1;
                        while (i8 <= iAbs) {
                            float f = (1.0f / i11) * i8;
                            deVar.c(com.google.android.libraries.navigation.internal.oe.x.s(((int) (iS * f)) + i6));
                            deVar.c(((int) ((i10 - i7) * f)) + i7);
                            deVar2.c(deVar.b / 2);
                            i8++;
                            i2 = i2;
                        }
                    }
                    i2 = i2;
                }
                i3 = i5;
            }
            deVar.c(iArr3[i]);
            deVar.c(iArr3[length - 1]);
            for (int i12 = 0; i12 < deVar2.b; i12++) {
                int iIntValue = er.a(deVar2, i12).intValue();
                for (int i13 = 0; i13 < iArr.length; i13++) {
                    int i14 = iArr[i13];
                    if (i14 >= iIntValue) {
                        iArr[i13] = i14 + 1;
                    }
                }
            }
            iArrM = deVar.M(new int[deVar.b]);
        } else {
            iArrM = iArr3;
        }
        this.b = iArrM;
        this.c = fArr;
    }

    public static float a(float[] fArr) {
        com.google.android.libraries.navigation.internal.oe.ay ayVar = new com.google.android.libraries.navigation.internal.oe.ay();
        com.google.android.libraries.navigation.internal.oe.ay ayVar2 = new com.google.android.libraries.navigation.internal.oe.ay();
        com.google.android.libraries.navigation.internal.oe.ay ayVar3 = new com.google.android.libraries.navigation.internal.oe.ay();
        int i = 0;
        float fD = 0.0f;
        while (i < fArr.length - 2) {
            ayVar.b = fArr[i];
            ayVar.c = fArr[i + 1];
            int i2 = i + 2;
            ayVar2.b = fArr[i2];
            ayVar2.c = fArr[i + 3];
            com.google.android.libraries.navigation.internal.oe.ay.s(ayVar2, ayVar, ayVar3);
            fD += ayVar3.d();
            i = i2;
        }
        return fD;
    }
}
