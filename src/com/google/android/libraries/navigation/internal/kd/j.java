package com.google.android.libraries.navigation.internal.kd;

import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.zr.aj;
import com.google.android.libraries.navigation.internal.zr.ak;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    public int a;
    private final float c;
    private final float b = 0.0f;
    private float[] d = new float[100];
    private int[] e = null;

    public j(float f) {
        this.c = f;
    }

    private final float c(float f, int i, float f2) {
        ar.b(i < 100, "bucket must be smaller than numBuckets!");
        int i2 = i - 1;
        while (i2 >= 0 && this.e[i2] == 0) {
            i2--;
        }
        if (i2 < 0) {
            i2 = i;
        }
        return ((((i2 + 0.5f) + (((i - i2) * (f2 - f)) / this.e[i])) * (this.c + 0.0f)) / 100.0f) + 0.0f;
    }

    public final ak a() {
        float f;
        float f2;
        float f3;
        aj ajVar = (aj) ak.a.q();
        int i = this.a;
        if (!ajVar.b.H()) {
            ajVar.v();
        }
        ak akVar = (ak) ajVar.b;
        akVar.b |= 1;
        akVar.c = i;
        int i2 = this.a;
        if (i2 == 0) {
            return (ak) ajVar.t();
        }
        float[] fArr = this.d;
        int i3 = 0;
        if (fArr != null) {
            Arrays.sort(fArr, 0, i2);
            float f4 = this.d[((int) Math.ceil(((double) this.a) * 0.5d)) - 1];
            if (!ajVar.b.H()) {
                ajVar.v();
            }
            ak akVar2 = (ak) ajVar.b;
            akVar2.b |= 2;
            akVar2.d = f4;
            float f5 = this.d[((int) Math.ceil(((double) this.a) * 0.75d)) - 1];
            if (!ajVar.b.H()) {
                ajVar.v();
            }
            ak akVar3 = (ak) ajVar.b;
            akVar3.b |= 4;
            akVar3.e = f5;
            float f6 = this.d[((int) Math.ceil(((double) this.a) * 0.9d)) - 1];
            if (!ajVar.b.H()) {
                ajVar.v();
            }
            ak akVar4 = (ak) ajVar.b;
            akVar4.b |= 8;
            akVar4.f = f6;
        } else {
            float f7 = i2;
            float f8 = 0.0f;
            while (true) {
                f = 0.5f * f7;
                if (i3 >= 100) {
                    break;
                }
                float f9 = this.e[i3] + f8;
                if (f9 >= f) {
                    break;
                }
                i3++;
                f8 = f9;
            }
            float fC = c(f8, i3, f);
            if (!ajVar.b.H()) {
                ajVar.v();
            }
            ak akVar5 = (ak) ajVar.b;
            akVar5.b |= 2;
            akVar5.d = fC;
            float f10 = this.a;
            while (true) {
                f2 = 0.75f * f10;
                if (i3 >= 100) {
                    break;
                }
                float f11 = this.e[i3] + f8;
                if (f11 >= f2) {
                    break;
                }
                i3++;
                f8 = f11;
            }
            float fC2 = c(f8, i3, f2);
            if (!ajVar.b.H()) {
                ajVar.v();
            }
            ak akVar6 = (ak) ajVar.b;
            akVar6.b |= 4;
            akVar6.e = fC2;
            float f12 = this.a;
            while (true) {
                f3 = 0.9f * f12;
                if (i3 >= 100) {
                    break;
                }
                float f13 = this.e[i3] + f8;
                if (f13 >= f3) {
                    break;
                }
                i3++;
                f8 = f13;
            }
            float fC3 = c(f8, i3, f3);
            if (!ajVar.b.H()) {
                ajVar.v();
            }
            ak akVar7 = (ak) ajVar.b;
            akVar7.b |= 8;
            akVar7.f = fC3;
        }
        return (ak) ajVar.t();
    }

    public final void b(float f) {
        if (this.e == null && this.a == 100) {
            this.e = new int[100];
            this.a = 0;
            for (int i = 0; i < 100; i++) {
                b(this.d[i]);
            }
            this.d = null;
        }
        int[] iArr = this.e;
        if (iArr == null) {
            this.d[this.a] = f;
        } else {
            int iMax = Math.max(0, Math.min(99, Math.round(((f + 0.0f) * 100.0f) / (this.c + 0.0f))));
            iArr[iMax] = iArr[iMax] + 1;
        }
        this.a++;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = new com.google.android.libraries.navigation.internal.yx.ak("QuantilesTracker").e("logScale", false).b("minValue", 0.0f).b("maxValue", this.c);
        akVarB.g("values", Arrays.toString(this.d));
        akVarB.g("counts", Arrays.toString(this.e));
        return akVarB.toString();
    }
}
