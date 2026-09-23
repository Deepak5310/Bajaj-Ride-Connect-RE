package com.google.android.libraries.geo.mapcore.internal.model;

import android.util.SparseIntArray;
import androidx.core.math.MathUtils;
import com.drew.metadata.photoshop.PhotoshopDirectory;
import com.google.android.libraries.navigation.internal.adg.en;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.lv;
import com.google.common.base.Ascii;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public class bt {
    public static final bt a;
    private static final com.google.android.libraries.navigation.internal.zb.j f = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.geo.mapcore.internal.model.bt");
    private static final ai[] g = new ai[0];
    private static final byte[] h = new byte[0];
    private static final ai i;
    public final long b;
    public final ai[] c;
    public final SparseIntArray d;
    private final ai[] j;
    private final byte[] k;
    private Boolean l = null;
    private ai m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f63n = false;
    public Map e = null;

    static {
        bs[] bsVarArr = ai.b;
        int i2 = ev.d;
        ai aiVar = new ai(true, true, true, true, true, true, bsVarArr, null, null, lv.a);
        i = aiVar;
        a = i(aiVar);
    }

    public bt(long j, ai[] aiVarArr, byte[] bArr, SparseIntArray sparseIntArray, boolean z) {
        this.b = j;
        this.c = aiVarArr == null ? g : aiVarArr;
        this.k = bArr == null ? h : bArr;
        this.d = sparseIntArray;
        this.j = new ai[23];
        if (z) {
            return;
        }
        for (int i2 = 0; i2 <= 22; i2++) {
            this.j[i2] = h(i2);
        }
    }

    public static bt i(ai aiVar) {
        return j(aiVar, false);
    }

    public static bt j(ai aiVar, boolean z) {
        return new bt(-1L, new ai[]{aiVar}, new byte[]{0}, null, z);
    }

    private static float n(float f2, float f3, int i2, int i3, float f4) {
        if (i2 == i3) {
            return f2;
        }
        double d = i2;
        float fPow = (float) ((Math.pow(2.0d, f4) - Math.pow(2.0d, d)) / (Math.pow(2.0d, i3) - Math.pow(2.0d, d)));
        return (f3 * fPow) + (f2 * (1.0f - fPow));
    }

    private static int o(int i2, int i3, int i4, int i5, float f2) {
        if (i4 == i5) {
            return i2;
        }
        float f3 = (f2 - i4) / (i5 - i4);
        float f4 = 1.0f - f3;
        return Math.round(((i3 & 255) * f3) + ((i2 & 255) * f4)) | (Math.round((((i3 >> 16) & 255) * f3) + (((i2 >> 16) & 255) * f4)) << 16) | (Math.round((((i3 >> 24) & 255) * f3) + (((i2 >> 24) & 255) * f4)) << 24) | (Math.round((((i3 >> 8) & 255) * f3) + (((i2 >> 8) & 255) * f4)) << 8);
    }

    private static bs[] p(bs[] bsVarArr, bs[] bsVarArr2, int i2, int i3, float f2) {
        if (f2 == i2) {
            return bsVarArr;
        }
        float f3 = i3;
        if (f2 == f3) {
            return bsVarArr2;
        }
        bs[] bsVarArr3 = new bs[Math.max(bsVarArr.length, bsVarArr2.length)];
        int i4 = 0;
        while (true) {
            int length = bsVarArr.length;
            int length2 = bsVarArr2.length;
            if (i4 >= Math.max(length, length2)) {
                return bsVarArr3;
            }
            bs bsVar = i4 < length ? bsVarArr[i4] : bs.a;
            bs bsVar2 = i4 < length2 ? bsVarArr2[i4] : bs.a;
            int iO = o(bsVar.b, bsVar2.b, i2, i3, f2);
            int iO2 = o(bsVar.c, bsVar2.c, i2, i3, f2);
            float fN = n(bsVar.d, bsVar2.d, i2, i3, f2);
            float fN2 = n(bsVar.h, bsVar2.h, i2, i3, f2);
            float fN3 = n(bsVar.l, bsVar2.l, i2, i3, f2);
            float fN4 = n(bsVar.m, bsVar2.m, i2, i3, f2);
            if (f2 < f3) {
                bsVar2 = bsVar;
            }
            bsVarArr3[i4] = new bs(iO, iO2, fN, bsVar.e, fN2, bsVar2.i, fN3, fN4, bsVar2.j, bsVar2.k);
            i4++;
        }
    }

    @Deprecated
    public final byte a(int i2) {
        return this.k[i2];
    }

    public final int b() {
        return this.c.length;
    }

    public final int c(int i2) {
        int i3 = 0;
        if (this.c.length == 0) {
            return 0;
        }
        int length = g(i2).o.length;
        if (length != 0) {
            while (true) {
                int i4 = i3 + i2;
                if (i4 >= 23 || g(i4).o.length != length) {
                    break;
                }
                i3++;
            }
        }
        return i3;
    }

    public final ai d() {
        ai[] aiVarArr = this.c;
        return aiVarArr.length == 0 ? i : aiVarArr[0];
    }

    final ai e() {
        if (this.m == null) {
            ah ahVarF = i.f();
            ahVarF.v = d().H;
            this.m = new ai(ahVarF);
        }
        return this.m;
    }

    public final ai f(float f2) {
        ai aiVar;
        float fClamp = MathUtils.clamp(f2, 0.0f, 22.0f);
        int iRound = Math.round(fClamp);
        return (fClamp != ((float) iRound) || (aiVar = this.j[iRound]) == null) ? h(fClamp) : aiVar;
    }

    public final ai g(int i2) {
        return f(i2);
    }

    public final ai h(float f2) {
        ai[] aiVarArr;
        byte b;
        int length = this.c.length;
        float fClamp = MathUtils.clamp(f2, 1.0f, 22.0f);
        if (length == 1) {
            return fClamp >= ((float) this.k[0]) ? this.c[0] : e();
        }
        int i2 = -1;
        int i3 = 0;
        byte b2 = 0;
        while (true) {
            aiVarArr = this.c;
            if (i3 >= aiVarArr.length) {
                b = Ascii.ETB;
                i3 = -1;
                break;
            }
            b = this.k[i3];
            if (b > fClamp) {
                break;
            }
            b2 = b;
            i2 = i3;
            i3++;
        }
        if (i2 == -1) {
            return e();
        }
        int i4 = i3 == -1 ? i2 : i3;
        if (i3 == -1) {
            b = b2;
        }
        ai aiVar = aiVarArr[i2];
        ai aiVar2 = aiVarArr[i4];
        ah ahVar = new ah();
        int i5 = aiVar.j;
        if (i5 != 0) {
            ahVar.g = o(i5, aiVar2.j, b2, b, fClamp);
        }
        ahVar.a = aiVar.d;
        bs[] bsVarArr = aiVar.f58n;
        if (bsVarArr.length > 0) {
            bs[] bsVarArr2 = aiVar2.f58n;
            if (bsVarArr2.length <= 0) {
                bsVarArr2 = bsVarArr;
            }
            ahVar.j = p(bsVarArr, bsVarArr2, b2, b, fClamp);
        }
        ahVar.b = aiVar.e;
        ahVar.w = aiVar.I;
        if (!aiVar.L.c()) {
            ahVar.A = aiVar.L;
        }
        if (aiVar.h()) {
            ahVar.B = (int) fClamp;
            ahVar.C = aiVar.N;
            ahVar.T = aiVar.S;
            ahVar.U = aiVar.T;
            ahVar.V = aiVar.U;
        }
        if (aiVar2.h() && b - fClamp <= 1.0f) {
            ahVar.D = (int) (1.0f + fClamp);
            ahVar.E = aiVar2.N;
            ahVar.W = aiVar2.S;
            ahVar.X = aiVar2.T;
            ahVar.Y = aiVar2.U;
        } else if (aiVar.h()) {
            ahVar.D = (int) (1.0f + fClamp);
            ahVar.E = aiVar.N;
            ahVar.W = aiVar.S;
            ahVar.X = aiVar.T;
            ahVar.Y = aiVar.U;
        }
        int i6 = aiVar.J;
        if (i6 != aiVar2.J) {
            ((com.google.android.libraries.navigation.internal.zb.h) f.d(com.google.android.libraries.navigation.internal.nl.a.a).F(PhotoshopDirectory.TAG_PATH_SELECTION_STATE)).t("lineStrokeRenderingAttributes mismatch for zoom: %d, and zoom: %d", b2, b);
        } else {
            ahVar.y = i6;
        }
        int i7 = aiVar.K;
        if (i7 != aiVar2.K) {
            ((com.google.android.libraries.navigation.internal.zb.h) f.d(com.google.android.libraries.navigation.internal.nl.a.a).F(PhotoshopDirectory.TAG_AUTO_SAVE_FORMAT)).t("areaStrokeRenderingAttributes mismatch for zoom: %d, and zoom: %d", b2, b);
        } else {
            ahVar.z = i7;
        }
        if (aiVar.q()) {
            o oVar = (o) aiVar.r;
            o oVar2 = (o) (aiVar2.q() ? aiVar2.r : aiVar.r);
            ahVar.f57n = cb.i(o(oVar.a, oVar2.a, b2, b, fClamp), o(oVar.b, oVar2.b, b2, b, fClamp), oVar.c, oVar.d, oVar.e, oVar.f, oVar.g, oVar.h);
        }
        if (aiVar.p()) {
            ahVar.o = aiVar.s;
        }
        if (aiVar.i()) {
            ahVar.p = aiVar.t;
        }
        float f3 = aiVar.C;
        if (f3 != 0.0f) {
            ahVar.q = f3;
        }
        float f4 = aiVar.D;
        if (f4 != 0.0f) {
            ahVar.r = f4;
        }
        float f5 = aiVar.E;
        if (f5 != 0.0f) {
            ahVar.s = f5;
        }
        en enVar = aiVar.u;
        if (enVar != null) {
            ahVar.F = enVar;
        }
        com.google.android.libraries.navigation.internal.adg.ak akVar = aiVar.v;
        if (akVar != null) {
            ahVar.G = akVar;
        }
        ahVar.H = aiVar.w;
        if (aiVar.n()) {
            ahVar.I = aiVar.x;
        }
        if (!aiVar.y.isEmpty()) {
            ahVar.J = aiVar.y;
        }
        if (aiVar.o()) {
            ahVar.K = aiVar.z;
        }
        com.google.android.libraries.navigation.internal.adg.p pVar = aiVar.A;
        if (pVar != null) {
            ahVar.a(pVar);
        }
        ahVar.M = aiVar.B;
        ahVar.c = aiVar.f;
        bs[] bsVarArr3 = aiVar.o;
        if (bsVarArr3.length > 0) {
            bs[] bsVarArr4 = aiVar2.o;
            if (bsVarArr4.length <= 0) {
                bsVarArr4 = bsVarArr3;
            }
            ahVar.k = p(bsVarArr3, bsVarArr4, b2, b, fClamp);
        }
        if (aiVar.t()) {
            ahVar.t = o(aiVar.e(), aiVar2.t() ? aiVar2.e() : aiVar.e(), b2, b, fClamp);
        }
        ahVar.f = aiVar.i;
        if (aiVar.s()) {
            ahVar.h = o(aiVar.m, aiVar2.s() ? aiVar2.m : aiVar.m, b2, b, fClamp);
            if (aiVar.m()) {
                ahVar.O = Float.valueOf(aiVar.d());
            }
            if (aiVar.k()) {
                ahVar.P = Float.valueOf(aiVar.b());
            }
            if (aiVar.l()) {
                ahVar.Q = Float.valueOf(aiVar.c());
            }
            if (aiVar.j()) {
                ahVar.R = Float.valueOf(aiVar.a());
            }
        }
        if (aiVar.r()) {
            ahVar.N = o(aiVar.Q, aiVar2.r() ? aiVar2.Q : aiVar.Q, b2, b, fClamp);
        }
        bs[] bsVarArr5 = aiVar.p;
        if (bsVarArr5.length > 0) {
            bs[] bsVarArr6 = aiVar2.p;
            if (bsVarArr6.length <= 0) {
                bsVarArr6 = bsVarArr5;
            }
            ahVar.l = p(bsVarArr5, bsVarArr6, b2, b, fClamp);
        }
        ahVar.d = aiVar.g;
        ahVar.u = aiVar.G;
        ahVar.e = aiVar.h;
        ahVar.i = o(aiVar.k, aiVar2.k, b2, b, fClamp);
        bs bsVar = aiVar.q;
        bs bsVar2 = aiVar2.q;
        if (bsVar != null && bsVar2 != null) {
            ahVar.m = p(new bs[]{bsVar}, new bs[]{bsVar2}, b2, b, fClamp)[0];
        }
        float f6 = aiVar.l;
        if (f6 > 0.0f) {
            ahVar.S = (int) n(f6, aiVar2.l, b2, b, fClamp);
        }
        ahVar.v = aiVar.H;
        ai aiVar3 = new ai(ahVar);
        return aiVar3.equals(aiVar) ? aiVar : aiVar3;
    }

    public final bt k(com.google.android.libraries.navigation.internal.adi.bo boVar) {
        Map map = this.e;
        if (map != null) {
            return (bt) map.get(boVar);
        }
        return null;
    }

    public final boolean l() {
        if (this.l == null) {
            this.l = Boolean.FALSE;
            int i2 = 0;
            while (true) {
                ai[] aiVarArr = this.c;
                if (i2 >= aiVarArr.length) {
                    break;
                }
                for (bs bsVar : aiVarArr[i2].o) {
                    if (bsVar.d()) {
                        this.l = Boolean.TRUE;
                        return true;
                    }
                }
                i2++;
            }
        }
        return this.l.booleanValue();
    }

    public final void m() {
        if (this.f63n) {
            return;
        }
        for (int length = this.c.length - 2; length >= 0; length--) {
            ai[] aiVarArr = this.c;
            ai aiVar = aiVarArr[length];
            int length2 = aiVar.o.length;
            int i2 = length + 1;
            ai aiVar2 = aiVarArr[i2];
            int length3 = aiVar2.o.length;
            if (length2 < length3) {
                aiVarArr[length] = aiVar.g(aiVar2);
            } else if (length2 > length3) {
                aiVarArr[i2] = aiVar2.g(aiVar);
            }
        }
        this.f63n = true;
    }
}
