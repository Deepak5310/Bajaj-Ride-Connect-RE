package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.adg.el;
import com.google.android.libraries.navigation.internal.adg.en;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ai {
    static final int[] a = new int[0];
    static final bs[] b;
    public static final ai c;
    public final com.google.android.libraries.navigation.internal.adg.p A;
    public final int B;
    public final float C;
    public final float D;
    public final float E;
    public int F;
    public final float[] G;
    public final int H;
    public final float I;
    public final int J;
    public final int K;
    public final com.google.android.libraries.geo.mapcore.internal.vector.gl.n L;
    public final int M;
    public final com.google.android.libraries.geo.mapcore.internal.vector.gl.n N;
    public final int O;
    public final com.google.android.libraries.geo.mapcore.internal.vector.gl.n P;
    public final int Q;
    public Integer R;
    public final int S;
    public final int T;
    public final int U;
    public final int V;
    public final int W;
    public final int X;
    private final float Y;
    private final Float Z;
    private final Float aa;
    private final Float ab;
    private final Float ac;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final int j;
    public final int k;
    public final float l;
    public final int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final bs[] f58n;
    public final bs[] o;
    public final bs[] p;
    public final bs q;
    public final cb r;
    public final bz s;
    public final ab t;
    public final en u;
    public final com.google.android.libraries.navigation.internal.adg.ak v;
    public final int w;
    public final com.google.android.libraries.navigation.internal.adg.b x;
    public final ev y;
    public final el z;

    static {
        bs[] bsVarArr = new bs[0];
        b = bsVarArr;
        cb cbVar = cb.m;
        bz bzVar = bz.p;
        int i = ev.d;
        c = new ai(false, false, false, false, false, false, bsVarArr, cbVar, bzVar, lv.a);
    }

    public ai(ah ahVar) {
        this.R = null;
        this.d = ahVar.a;
        this.e = ahVar.b;
        this.f = ahVar.c;
        this.g = ahVar.d;
        this.h = ahVar.e;
        this.i = ahVar.f;
        this.j = ahVar.g;
        this.m = ahVar.h;
        this.f58n = ahVar.j;
        this.o = ahVar.k;
        this.p = ahVar.l;
        this.k = ahVar.i;
        this.q = ahVar.m;
        this.r = ahVar.f57n;
        this.s = ahVar.o;
        this.t = ahVar.p;
        this.C = ahVar.q;
        this.D = ahVar.r;
        this.E = ahVar.s;
        this.F = ahVar.t;
        this.G = ahVar.u;
        this.H = ahVar.v;
        this.I = ahVar.w;
        this.Y = ahVar.x;
        this.J = ahVar.y;
        this.K = ahVar.z;
        this.L = ahVar.A;
        this.M = ahVar.B;
        this.N = ahVar.C;
        this.S = ahVar.T;
        this.T = ahVar.U;
        this.U = ahVar.V;
        this.O = ahVar.D;
        this.P = ahVar.E;
        this.V = ahVar.W;
        this.W = ahVar.X;
        this.X = ahVar.Y;
        this.u = ahVar.F;
        this.v = ahVar.G;
        this.w = ahVar.H;
        this.x = ahVar.I;
        this.y = ahVar.J;
        this.z = ahVar.K;
        this.A = ahVar.L;
        this.B = ahVar.M;
        this.Q = ahVar.N;
        this.Z = ahVar.O;
        this.aa = ahVar.P;
        this.ab = ahVar.Q;
        this.ac = ahVar.R;
        this.l = ahVar.S;
    }

    protected ai(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, bs[] bsVarArr, cb cbVar, bz bzVar, ev evVar) {
        this.R = null;
        this.d = z;
        this.e = z2;
        this.f = z3;
        this.g = z4;
        this.h = z5;
        this.i = z6;
        this.j = 0;
        this.m = 0;
        this.f58n = bsVarArr;
        this.o = bsVarArr;
        this.k = 0;
        this.l = 0.0f;
        this.q = null;
        this.p = bsVarArr;
        this.r = cbVar;
        this.s = bzVar;
        this.t = null;
        this.C = 0.0f;
        this.D = 0.0f;
        this.E = 0.0f;
        this.z = null;
        this.F = 0;
        this.G = null;
        this.H = 0;
        this.I = 0.375f;
        this.Y = 0.375f;
        this.J = 0;
        this.K = 0;
        this.L = com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b;
        this.M = -1;
        this.N = com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b;
        this.S = com.google.android.libraries.navigation.internal.adg.az.a;
        this.T = com.google.android.libraries.navigation.internal.adg.av.a;
        this.U = com.google.android.libraries.navigation.internal.adg.ax.a;
        this.O = -1;
        this.P = com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b;
        this.V = com.google.android.libraries.navigation.internal.adg.az.a;
        this.W = com.google.android.libraries.navigation.internal.adg.av.a;
        this.X = com.google.android.libraries.navigation.internal.adg.ax.a;
        this.x = null;
        this.y = evVar;
        this.u = null;
        this.v = null;
        this.w = 0;
        this.A = null;
        this.B = 0;
        this.Q = 0;
        this.Z = null;
        this.aa = null;
        this.ab = null;
        this.ac = null;
    }

    private static int u(int i, int i2) {
        return Math.abs(com.google.android.libraries.navigation.internal.rq.b.b(i) - com.google.android.libraries.navigation.internal.rq.b.b(i2)) + Math.abs(com.google.android.libraries.navigation.internal.rq.b.e(i) - com.google.android.libraries.navigation.internal.rq.b.e(i2)) + Math.abs(com.google.android.libraries.navigation.internal.rq.b.d(i) - com.google.android.libraries.navigation.internal.rq.b.d(i2)) + Math.abs(com.google.android.libraries.navigation.internal.rq.b.c(i) - com.google.android.libraries.navigation.internal.rq.b.c(i2));
    }

    private static void v(int[] iArr, bs[] bsVarArr, bs[] bsVarArr2, ag agVar) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 <= bsVarArr.length; i4++) {
            while (i2 < iArr.length && iArr[i2] == i4) {
                i2++;
                i3++;
            }
            if (i4 < bsVarArr.length) {
                int i5 = i3 + 1;
                bs bsVar = bsVarArr[i4];
                bs bsVar2 = bsVarArr2[i3];
                int iU = (u(bsVar.b, bsVar2.b) + u(bsVar.c, bsVar2.c)) / 2;
                if (bsVar.c() != bsVar2.c()) {
                    iU += 2048;
                }
                i += iU;
                i3 = i5;
            }
        }
        if (i < agVar.b) {
            agVar.b = i;
            System.arraycopy(iArr, 0, agVar.a, 0, iArr.length);
        }
    }

    public final float a() {
        Float f = this.ac;
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public final float b() {
        Float f = this.aa;
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public final float c() {
        Float f = this.ab;
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public final float d() {
        Float f = this.Z;
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public final int e() {
        int i;
        synchronized (this) {
            i = this.F;
        }
        return i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ai aiVar = (ai) obj;
        if (this.d != aiVar.d || this.e != aiVar.e || this.f != aiVar.f || this.g != aiVar.g || this.h != aiVar.h || this.i != aiVar.i || this.j != aiVar.j || this.m != aiVar.m || this.k != aiVar.k || !Arrays.equals(this.f58n, aiVar.f58n) || !Arrays.equals(this.o, aiVar.o) || !Arrays.equals(this.p, aiVar.p)) {
            return false;
        }
        bs bsVar = this.q;
        if (bsVar == null) {
            if (aiVar.q != null) {
                return false;
            }
        } else if (!bsVar.equals(aiVar.q)) {
            return false;
        }
        bz bzVar = this.s;
        if (bzVar == null) {
            if (aiVar.s != null) {
                return false;
            }
        } else if (!bzVar.equals(aiVar.s)) {
            return false;
        }
        cb cbVar = this.r;
        if (cbVar == null) {
            if (aiVar.r != null) {
                return false;
            }
        } else if (!cbVar.equals(aiVar.r)) {
            return false;
        }
        if (this.H != aiVar.H) {
            return false;
        }
        ab abVar = this.t;
        if (abVar == null) {
            if (aiVar.t != null) {
                return false;
            }
        } else if (!abVar.equals(aiVar.t)) {
            return false;
        }
        if (this.C != aiVar.C || this.D != aiVar.D || this.E != aiVar.E || e() != aiVar.e() || !Arrays.equals(this.G, aiVar.G) || !this.L.equals(aiVar.L) || this.M != aiVar.M || !this.N.equals(aiVar.N)) {
            return false;
        }
        int i = this.S;
        boolean z = i == aiVar.S;
        if (i == 0) {
            throw null;
        }
        if (!z) {
            return false;
        }
        int i2 = this.T;
        boolean z2 = i2 == aiVar.T;
        if (i2 == 0) {
            throw null;
        }
        if (!z2) {
            return false;
        }
        int i3 = this.U;
        boolean z3 = i3 == aiVar.U;
        if (i3 == 0) {
            throw null;
        }
        if (!z3 || this.O != aiVar.O || !this.P.equals(aiVar.P)) {
            return false;
        }
        int i4 = this.V;
        boolean z4 = i4 == aiVar.V;
        if (i4 == 0) {
            throw null;
        }
        if (!z4) {
            return false;
        }
        int i5 = this.W;
        boolean z5 = i5 == aiVar.W;
        if (i5 == 0) {
            throw null;
        }
        if (!z5) {
            return false;
        }
        int i6 = this.X;
        boolean z6 = i6 == aiVar.X;
        if (i6 != 0) {
            return z6 && com.google.android.libraries.navigation.internal.yx.am.a(this.u, aiVar.u) && com.google.android.libraries.navigation.internal.yx.am.a(this.v, aiVar.v) && this.w == aiVar.w && com.google.android.libraries.navigation.internal.yx.am.a(this.x, aiVar.x) && hx.i(this.y, aiVar.y) && com.google.android.libraries.navigation.internal.yx.am.a(this.z, aiVar.z) && this.Q == aiVar.Q && com.google.android.libraries.navigation.internal.yx.am.a(this.Z, aiVar.Z) && com.google.android.libraries.navigation.internal.yx.am.a(this.aa, aiVar.aa) && com.google.android.libraries.navigation.internal.yx.am.a(this.ac, aiVar.ac) && com.google.android.libraries.navigation.internal.yx.am.a(this.ab, aiVar.ab);
        }
        throw null;
    }

    public final ah f() {
        ah ahVar = new ah();
        ahVar.a = this.d;
        ahVar.b = this.e;
        ahVar.c = this.f;
        ahVar.d = this.g;
        ahVar.e = this.h;
        ahVar.f = this.i;
        ahVar.g = this.j;
        ahVar.h = this.m;
        ahVar.j = this.f58n;
        ahVar.k = this.o;
        ahVar.l = this.p;
        ahVar.i = this.k;
        ahVar.m = this.q;
        ahVar.S = this.l;
        ahVar.f57n = this.r;
        ahVar.o = this.s;
        ahVar.p = this.t;
        ahVar.q = this.C;
        ahVar.r = this.D;
        ahVar.s = this.E;
        ahVar.u = this.G;
        ahVar.v = this.H;
        ahVar.w = this.I;
        ahVar.x = this.Y;
        ahVar.y = this.J;
        ahVar.z = this.K;
        ahVar.A = this.L;
        ahVar.B = this.M;
        ahVar.C = this.N;
        ahVar.T = this.S;
        ahVar.U = this.T;
        ahVar.V = this.U;
        ahVar.D = this.O;
        ahVar.E = this.P;
        ahVar.W = this.V;
        ahVar.X = this.W;
        ahVar.Y = this.X;
        ahVar.F = this.u;
        ahVar.G = this.v;
        ahVar.H = this.w;
        ahVar.I = this.x;
        ahVar.J = this.y;
        ahVar.K = this.z;
        ahVar.a(this.A);
        ahVar.M = this.B;
        ahVar.N = this.Q;
        ahVar.O = this.Z;
        ahVar.P = this.aa;
        ahVar.Q = this.ab;
        ahVar.R = this.ac;
        synchronized (this) {
            ahVar.t = this.F;
        }
        return ahVar;
    }

    public final ai g(ai aiVar) {
        bs[] bsVarArr = this.o;
        bs[] bsVarArr2 = aiVar.o;
        int length = bsVarArr.length;
        int length2 = bsVarArr2.length;
        if (length >= length2) {
            return this;
        }
        int i = length2 - length;
        int[] iArr = new int[i];
        ag agVar = new ag(i);
        for (int i2 = 0; i2 <= length; i2++) {
            iArr[0] = i2;
            if (i > 1) {
                for (int i3 = i2; i3 <= length; i3++) {
                    iArr[1] = i3;
                    if (i > 2) {
                        for (int i4 = i3; i4 <= length; i4++) {
                            iArr[2] = i4;
                            if (i > 3) {
                                for (int i5 = i4; i5 <= length; i5++) {
                                    iArr[3] = i5;
                                    v(iArr, bsVarArr, bsVarArr2, agVar);
                                }
                            } else {
                                v(iArr, bsVarArr, bsVarArr2, agVar);
                            }
                        }
                    } else {
                        v(iArr, bsVarArr, bsVarArr2, agVar);
                    }
                }
            } else {
                v(iArr, bsVarArr, bsVarArr2, agVar);
            }
        }
        if (agVar.b == Integer.MAX_VALUE) {
            throw new IllegalStateException("Couldn't find best insertion indices");
        }
        bs[] bsVarArr3 = new bs[length2];
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 <= length; i8++) {
            while (true) {
                int[] iArr2 = agVar.a;
                if (i6 >= iArr2.length || iArr2[i6] != i8) {
                    break;
                }
                bs bsVar = bsVarArr2[i7];
                int i9 = bsVar.b;
                int i10 = bsVar.c;
                float f = bsVar.h;
                int[] iArr3 = a;
                com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar = com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b;
                com.google.android.libraries.geo.mapcore.internal.vector.gl.n nVar2 = com.google.android.libraries.geo.mapcore.internal.vector.gl.n.b;
                bsVarArr3[i7] = new bs(i9, i10, 0.0f, iArr3, f, nVar, 0.0f, 0.0f, nVar2, nVar2);
                i6++;
                i7++;
            }
            if (i8 < length) {
                bsVarArr3[i7] = bsVarArr[i8];
                i7++;
            }
        }
        ah ahVarF = f();
        ahVarF.k = bsVarArr3;
        return new ai(ahVarF);
    }

    public final boolean h() {
        return (this.N.c() && this.P.c()) ? false : true;
    }

    public final int hashCode() {
        int i;
        if (this.R == null) {
            boolean z = this.d;
            boolean z2 = this.e;
            boolean z3 = this.f;
            boolean z4 = this.g;
            boolean z5 = this.h;
            boolean z6 = this.i;
            int i2 = this.j;
            int i3 = this.m;
            int i4 = this.k;
            bs[] bsVarArr = this.f58n;
            int i5 = true != z ? 1237 : 1231;
            int iHashCode = ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((i5 + 31) * 31) + (true != z2 ? 1237 : 1231)) * 31) + (true != z3 ? 1237 : 1231)) * 31) + (true != z4 ? 1237 : 1231)) * 31) + (true != z5 ? 1237 : 1231)) * 31) + (true == z6 ? 1231 : 1237)) * 31) + i2) * 31) + i3) * 31) + i4) * 31) + Arrays.hashCode(bsVarArr)) * 31) + Arrays.hashCode(this.o)) * 31) + Arrays.hashCode(this.p)) * 31) + Arrays.hashCode(new Object[]{this.q})) * 31) + Arrays.hashCode(new Object[]{this.r})) * 31) + Arrays.hashCode(new Object[]{this.s})) * 31) + Arrays.hashCode(new Object[]{this.t})) * 31) + Arrays.hashCode(new Object[]{Float.valueOf(this.C)})) * 31) + Arrays.hashCode(new Object[]{Float.valueOf(this.D)})) * 31) + Arrays.hashCode(new Object[]{Float.valueOf(this.E)})) * 31) + Arrays.hashCode(new Object[]{this.u})) * 31) + Arrays.hashCode(new Object[]{this.v})) * 31) + Arrays.hashCode(new Object[]{Integer.valueOf(this.w)})) * 31) + Arrays.hashCode(new Object[]{this.x})) * 31) + this.y.hashCode()) * 31) + Arrays.hashCode(new Object[]{this.z})) * 31) + Arrays.hashCode(new Object[]{this.L})) * 31) + this.M) * 31) + Arrays.hashCode(new Object[]{this.N})) * 31) + Arrays.hashCode(new Object[]{Integer.valueOf(this.S)})) * 31) + Arrays.hashCode(new Object[]{Integer.valueOf(this.T)})) * 31) + Arrays.hashCode(new Object[]{Integer.valueOf(this.U)})) * 31) + this.O) * 31) + Arrays.hashCode(new Object[]{this.P})) * 31) + Arrays.hashCode(new Object[]{Integer.valueOf(this.V)})) * 31) + Arrays.hashCode(new Object[]{Integer.valueOf(this.W)})) * 31) + Arrays.hashCode(new Object[]{Integer.valueOf(this.X)});
            synchronized (this) {
                i = (iHashCode * 31) + this.F;
            }
            int iHashCode2 = ((((i * 31) + Arrays.hashCode(this.G)) * 31) + this.H) * 31;
            int i6 = this.Q;
            Float f = this.Z;
            int iHashCode3 = iHashCode2 + i6;
            if (f != null) {
                iHashCode3 = (iHashCode3 * 31) + f.hashCode();
            }
            Float f2 = this.aa;
            if (f2 != null) {
                iHashCode3 = (iHashCode3 * 31) + f2.hashCode();
            }
            Float f3 = this.ac;
            if (f3 != null) {
                iHashCode3 = (iHashCode3 * 31) + f3.hashCode();
            }
            Float f4 = this.ab;
            if (f4 != null) {
                iHashCode3 = (iHashCode3 * 31) + f4.hashCode();
            }
            this.R = Integer.valueOf(iHashCode3);
        }
        return this.R.intValue();
    }

    public final boolean i() {
        return this.t != null;
    }

    public final boolean j() {
        return this.ac != null;
    }

    public final boolean k() {
        return this.aa != null;
    }

    public final boolean l() {
        return this.ab != null;
    }

    public final boolean m() {
        return this.Z != null;
    }

    public final boolean n() {
        return this.x != null;
    }

    public final boolean o() {
        return this.z != null;
    }

    public final boolean p() {
        return this.s != null;
    }

    public final boolean q() {
        return this.r != null;
    }

    public final boolean r() {
        return this.Q != 0;
    }

    public final boolean s() {
        return this.m != 0;
    }

    public final boolean t() {
        boolean z;
        synchronized (this) {
            z = this.F != 0;
        }
        return z;
    }
}
