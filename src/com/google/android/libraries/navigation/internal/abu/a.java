package com.google.android.libraries.navigation.internal.abu;

import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.s;
import com.google.android.libraries.navigation.internal.abt.n;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final String a = "a";
    public static final a b = new a(null, null, null, null);
    public final byte[][] c;
    public final c[] d;
    public final byte[][] e;
    public final b[] f;

    public a(byte[][] bArr, c[] cVarArr, byte[][] bArr2, b[] bVarArr) {
        this.c = bArr;
        this.d = cVarArr;
        this.e = bArr2;
        this.f = bVarArr;
    }

    public static int b(float f, float f2, byte[][] bArr) {
        if (bArr == null) {
            return 0;
        }
        int length = bArr.length;
        int iD = d(((f2 + 180.0f) / 360.0f) * length, length);
        int length2 = bArr[iD].length;
        return bArr[iD][d(((90.0f - f) / 180.0f) * length2, length2)] & 255;
    }

    private static int d(float f, int i) {
        int i2 = (int) f;
        while (i2 < 0) {
            i2 += i;
        }
        return i2 % i;
    }

    private static String e(int[] iArr) {
        if (iArr == null) {
            return "<null[]>";
        }
        StringBuilder sb = new StringBuilder("#");
        sb.append(iArr.length);
        sb.append("[");
        for (int i = 0; i < iArr.length; i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(i);
            sb.append(":");
            sb.append(iArr[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    private static String f(Object[] objArr) {
        if (objArr == null) {
            return "<null[]>";
        }
        StringBuilder sb = new StringBuilder("#");
        sb.append(objArr.length);
        sb.append("[");
        for (int i = 0; i < objArr.length; i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(i);
            sb.append(":");
            sb.append(objArr[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    private static int[] g(byte[][] bArr) {
        if (bArr == null) {
            return null;
        }
        int i = 0;
        int iMax = 0;
        while (true) {
            if (i >= bArr.length) {
                break;
            }
            for (byte b2 : bArr[i]) {
                iMax = Math.max(iMax, b2 & 255);
            }
            i++;
        }
        int[] iArr = new int[iMax + 1];
        for (byte[] bArr2 : bArr) {
            for (byte b3 : bArr2) {
                int i2 = b3 & 255;
                iArr[i2] = iArr[i2] + 1;
            }
        }
        return iArr;
    }

    public final float a(n nVar, float f, float f2, float f3) {
        p.f(a, 2);
        s.k(nVar, "world");
        s.i(f, "rayTiltDeg cannot be NaN");
        s.i(f2, "rayBearingDeg cannot be NaN");
        byte[][] bArr = this.c;
        if (bArr == null) {
            return 200.0f;
        }
        float f4 = nVar.b;
        float f5 = f2 - f4;
        float radians = (float) Math.toRadians(f2);
        float radians2 = (float) Math.toRadians(f4);
        float radians3 = (float) Math.toRadians(nVar.c);
        float radians4 = (float) Math.toRadians(nVar.d);
        float radians5 = (float) Math.toRadians(f);
        float fCos = (float) Math.cos(radians - radians3);
        int iB = b(f, f5, bArr);
        c cVar = iB == 0 ? null : this.d[iB];
        if (cVar == null) {
            return 200.0f;
        }
        float f6 = radians5 - (radians4 * fCos);
        double d = radians - radians2;
        float fSin = (float) Math.sin(d);
        float fCos2 = (float) Math.cos(d);
        double d2 = f6;
        float fSin2 = (float) Math.sin(d2);
        float fCos3 = (float) Math.cos(d2);
        Float fA = cVar.a(fSin * fCos3, fCos2 * fCos3, fSin2);
        if (fA != null) {
            return fA.floatValue();
        }
        return 200.0f;
    }

    public final boolean c() {
        return this.e != null;
    }

    public final String toString() {
        aj ajVarF = aj.f(this);
        ajVarF.g("planeIndexPixelMap", e(g(this.c)));
        ajVarF.g("planes", f(this.d));
        ajVarF.g("panoIndexPixelMap", e(g(this.e)));
        ajVarF.g("panos", f(this.f));
        return ajVarF.toString();
    }
}
