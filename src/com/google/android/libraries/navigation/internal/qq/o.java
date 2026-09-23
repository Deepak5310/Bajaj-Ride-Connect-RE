package com.google.android.libraries.navigation.internal.qq;

import com.google.android.libraries.geo.mapcore.internal.model.cj;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class o implements q {
    private static final com.google.android.libraries.navigation.internal.oe.x j = new com.google.android.libraries.navigation.internal.oe.x();
    private static final com.google.android.libraries.navigation.internal.oe.x k = new com.google.android.libraries.navigation.internal.oe.x();
    private static final com.google.android.libraries.navigation.internal.oe.x l = new com.google.android.libraries.navigation.internal.oe.x();
    private static final float[] m = new float[6];
    public final com.google.android.libraries.geo.mapcore.internal.model.g[] a;
    public boolean c;
    public float d;
    public float e;
    public boolean g = false;
    public float h = 1.0f;
    public float i = 1.0f;
    public final com.google.android.libraries.navigation.internal.rm.c b = new com.google.android.libraries.navigation.internal.rm.c();
    public final com.google.android.libraries.navigation.internal.rm.c f = new com.google.android.libraries.navigation.internal.rm.c();

    public o(List list) {
        this.a = (com.google.android.libraries.geo.mapcore.internal.model.g[]) list.toArray(new com.google.android.libraries.geo.mapcore.internal.model.g[0]);
    }

    @Override // com.google.android.libraries.navigation.internal.qq.q
    public final boolean a(x xVar, float f) {
        synchronized (this) {
            this.b.d(this.f);
            this.d = this.h;
            this.e = this.i;
            this.c = this.g;
        }
        for (com.google.android.libraries.geo.mapcore.internal.model.g gVar : this.a) {
            if (d(gVar, xVar)) {
                return true;
            }
        }
        return false;
    }

    public final synchronized void b(com.google.android.libraries.navigation.internal.rm.c cVar, float f, float f2) {
        this.f.d(cVar);
        this.h = f;
        this.i = f2;
        this.g = false;
    }

    public final synchronized void c(com.google.android.libraries.navigation.internal.rm.c cVar, float f) {
        this.f.d(cVar);
        this.h = f;
        this.i = f;
        this.g = true;
    }

    public final boolean d(com.google.android.libraries.geo.mapcore.internal.model.g gVar, x xVar) {
        boolean zC;
        int i = 0;
        while (true) {
            cj cjVar = gVar.g;
            if (i >= cjVar.d()) {
                return false;
            }
            if (cjVar.c.length > 0) {
                com.google.android.libraries.navigation.internal.oe.x xVar2 = j;
                com.google.android.libraries.navigation.internal.oe.x xVar3 = k;
                com.google.android.libraries.navigation.internal.oe.x xVar4 = l;
                cjVar.f(i, xVar2, xVar3, xVar4);
                com.google.android.libraries.navigation.internal.rm.c cVar = this.b;
                float f = this.d;
                if (com.google.android.libraries.navigation.internal.pb.j.p(xVar.c, xVar2, xVar.g)) {
                    float[] fArr = xVar.h;
                    float[] fArr2 = xVar.g;
                    fArr[0] = fArr2[0];
                    fArr[1] = fArr2[1];
                    if (com.google.android.libraries.navigation.internal.pb.j.p(xVar.c, xVar3, fArr2)) {
                        float[] fArr3 = xVar.h;
                        float[] fArr4 = xVar.g;
                        fArr3[2] = fArr4[0];
                        fArr3[3] = fArr4[1];
                        if (com.google.android.libraries.navigation.internal.pb.j.p(xVar.c, xVar4, fArr4)) {
                            float[] fArr5 = xVar.h;
                            float[] fArr6 = xVar.g;
                            fArr5[4] = fArr6[0];
                            fArr5[5] = fArr6[1];
                            zC = xVar.c(fArr5, false, 1.0f / f, cVar, xVar.f / f);
                        } else {
                            zC = xVar.d(xVar2, xVar3, xVar4, cVar);
                        }
                    } else {
                        zC = xVar.d(xVar2, xVar3, xVar4, cVar);
                    }
                } else {
                    zC = xVar.d(xVar2, xVar3, xVar4, cVar);
                }
                if (zC) {
                    return true;
                }
            } else {
                float[] fArr7 = m;
                int iC = cjVar.c(i, 0);
                int iC2 = cjVar.c(i, 1);
                int iC3 = cjVar.c(i, 2);
                float[] fArr8 = cjVar.d;
                if (fArr8.length > 0) {
                    fArr7[0] = fArr8[iC];
                    fArr7[1] = fArr8[iC + 1];
                    fArr7[2] = fArr8[iC2];
                    fArr7[3] = fArr8[iC2 + 1];
                    fArr7[4] = fArr8[iC3];
                    fArr7[5] = fArr8[iC3 + 1];
                }
                com.google.android.libraries.navigation.internal.rm.c cVar2 = this.b;
                float f2 = this.d;
                float f3 = this.e;
                if (this.c) {
                    float fPow = 2.0f / ((float) Math.pow(2.0d, 22.0f - xVar.c.w().k));
                    f2 *= fPow;
                    f3 *= fPow;
                }
                float[] fArr9 = xVar.h;
                fArr9[0] = fArr7[0] * f2;
                fArr9[1] = fArr7[1] * f3;
                fArr9[2] = fArr7[2] * f2;
                fArr9[3] = fArr7[3] * f3;
                fArr9[4] = fArr7[4] * f2;
                fArr9[5] = fArr7[5] * f3;
                if (xVar.c(fArr9, true, 1.0f, cVar2, xVar.f)) {
                    return true;
                }
            }
            i++;
        }
    }
}
