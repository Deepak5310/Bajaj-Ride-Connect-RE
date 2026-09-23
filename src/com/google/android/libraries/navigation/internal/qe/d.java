package com.google.android.libraries.navigation.internal.qe;

import android.content.Context;
import com.google.android.libraries.navigation.internal.pb.m;
import com.google.android.libraries.navigation.internal.pb.t;
import com.google.android.libraries.navigation.internal.pb.x;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d extends x {
    private final a A;
    private final a B;
    private float a;
    private float m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private float f551n;
    private float o;
    private float p;
    private float q;
    private float r;
    private boolean s;
    private boolean t;
    private final float[] u;
    private final float[] v;
    private final float[] w;
    private final float[] x;
    private com.google.android.libraries.navigation.internal.pd.d y;
    private final t z;

    public d(Context context, t tVar, com.google.android.libraries.navigation.internal.ni.a aVar) {
        super(aVar);
        this.u = new float[4];
        this.v = new float[4];
        this.w = new float[4];
        this.x = new float[4];
        this.z = tVar;
        this.y = tVar.w();
        a aVar2 = new a(context);
        this.A = aVar2;
        this.B = aVar2;
    }

    final synchronized void A() {
        float[] fArr = this.w;
        a aVar = this.B;
        int i = 0;
        if (aVar.h == 0) {
            Arrays.fill(fArr, 0.0f);
        } else {
            aVar.c.computeScrollOffset();
            int currX = aVar.c.getCurrX();
            aVar.i = currX;
            float f = currX / aVar.h;
            fArr[0] = ((aVar.d + 0.0f) * f) + 0.0f;
            fArr[1] = ((aVar.e + 0.0f) * f) + 0.0f;
            fArr[2] = ((aVar.f + 0.0f) * f) + 0.0f;
            fArr[3] = ((aVar.g + 0.0f) * f) + 0.0f;
        }
        while (true) {
            float[] fArr2 = this.w;
            int length = fArr2.length;
            if (i < 4) {
                float[] fArr3 = this.x;
                float[] fArr4 = this.v;
                fArr3[i] = fArr2[i] - fArr4[i];
                fArr4[i] = fArr2[i];
                i++;
            }
        }
    }

    final synchronized void B(float f, float f2) {
        this.o += f;
        this.p += f2;
    }

    final synchronized void C(float f) {
        this.f551n += f;
    }

    final synchronized boolean D() {
        return this.t;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.x, com.google.android.libraries.navigation.internal.pc.c
    public final int a(long j) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        synchronized (this) {
            float f6 = this.q;
            float f7 = this.r;
            if (this.t) {
                A();
                float f8 = this.o;
                float[] fArr = this.x;
                f = f8 + fArr[0];
                f2 = this.p + fArr[1];
                f4 = this.a + fArr[2];
                f5 = this.m + fArr[3];
                f3 = this.f551n;
                this.f551n = 0.0f;
                this.m = 0.0f;
                this.a = 0.0f;
                this.p = 0.0f;
                this.o = 0.0f;
            } else {
                f = this.o;
                f2 = this.p;
                f3 = this.f551n;
                float f9 = this.a;
                float fMax = f9 < 0.0f ? Math.max(f9, f9 * f9 * (-10.0f)) : Math.min(f9, f9 * f9 * 10.0f);
                float f10 = this.m;
                float fMax2 = f10 < 0.0f ? Math.max(f10, f10 * f10 * (-0.1f)) : Math.min(f10, f10 * f10 * 0.1f);
                this.a = f9 - fMax;
                this.m = f10 - fMax2;
                this.o = 0.0f;
                this.p = 0.0f;
                this.f551n = 0.0f;
                f4 = fMax;
                f5 = fMax2;
            }
            if (this.f != 0) {
                if (Math.abs(f) < 0.1d && Math.abs(f2) < 0.1d && Math.abs(f4) < 1.0E-4d && Math.abs(f5) < 0.001d && f3 == 0.0f) {
                    a aVar = this.B;
                    if (aVar.i == aVar.h) {
                    }
                }
                boolean z = ((f == 0.0f && f2 == 0.0f) || (this.f & com.google.android.libraries.navigation.internal.pd.d.c) == 0) ? false : true;
                boolean z2 = (f5 == 0.0f || (this.f & com.google.android.libraries.navigation.internal.pd.d.f) == 0) ? false : true;
                boolean z3 = (f4 == 0.0f || (this.f & com.google.android.libraries.navigation.internal.pd.d.d) == 0) ? false : true;
                boolean z4 = (f3 == 0.0f || (this.f & com.google.android.libraries.navigation.internal.pd.d.e) == 0) ? false : true;
                if (z) {
                    com.google.android.libraries.navigation.internal.pd.d dVarL = com.google.android.libraries.navigation.internal.pb.j.l(this.z, this.y, f, f2);
                    this.y = dVarL;
                    if (z2 || z3 || z4) {
                        this.z.B(dVarL);
                    }
                }
                if (z2) {
                    if (this.s) {
                        t tVar = this.z;
                        com.google.android.libraries.navigation.internal.pd.d dVarW = tVar.w();
                        float fS = f6 - (tVar.s() * dVarW.f515n.a());
                        float fR = f7 - (tVar.r() * dVarW.f515n.b());
                        com.google.android.libraries.navigation.internal.pd.a aVar2 = new com.google.android.libraries.navigation.internal.pd.a(com.google.android.libraries.navigation.internal.pb.j.l(tVar, dVarW, fS, fR));
                        aVar2.e = dVarW.m + f5;
                        tVar.b.e(aVar2);
                        com.google.android.libraries.navigation.internal.pd.d dVarA = aVar2.a();
                        tVar.B(dVarA);
                        this.y = com.google.android.libraries.navigation.internal.pb.j.l(tVar, dVarA, -fS, -fR);
                    } else {
                        com.google.android.libraries.navigation.internal.pd.d dVar = this.y;
                        com.google.android.libraries.navigation.internal.pd.d dVar2 = com.google.android.libraries.navigation.internal.pd.d.a;
                        com.google.android.libraries.navigation.internal.pd.a aVar3 = new com.google.android.libraries.navigation.internal.pd.a(dVar);
                        aVar3.e = this.y.m + f5;
                        this.y = aVar3.a();
                    }
                    if (z3 || z4) {
                        this.z.B(this.y);
                    }
                }
                if (z3) {
                    com.google.android.libraries.navigation.internal.pd.d dVar3 = this.y;
                    float f11 = dVar3.k + f4;
                    if (this.s) {
                        this.y = com.google.android.libraries.navigation.internal.pb.j.k(this.z, dVar3, f11, f6, f7);
                    } else {
                        com.google.android.libraries.navigation.internal.pd.a aVar4 = new com.google.android.libraries.navigation.internal.pd.a(dVar3);
                        aVar4.c = f11;
                        this.y = aVar4.a();
                    }
                    if (z4) {
                        this.z.B(this.y);
                    }
                }
                if (z4) {
                    com.google.android.libraries.navigation.internal.pd.d dVar4 = this.y;
                    com.google.android.libraries.navigation.internal.pd.d dVar5 = com.google.android.libraries.navigation.internal.pd.d.a;
                    com.google.android.libraries.navigation.internal.pd.a aVar5 = new com.google.android.libraries.navigation.internal.pd.a(dVar4);
                    aVar5.d = this.y.l + f3;
                    this.y = aVar5.a();
                }
                this.y = this.z.b.d(this.y);
                return 6;
            }
            this.f551n = 0.0f;
            this.a = 0.0f;
            this.m = 0.0f;
            this.p = 0.0f;
            this.o = 0.0f;
            return 0;
        }
    }

    /* JADX WARN: Code duplicated, block: B:13:0x001f A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0008, B:7:0x000e, B:9:0x0013, B:11:0x0019, B:14:0x0021, B:16:0x0027, B:17:0x002a, B:19:0x0030, B:20:0x0033, B:22:0x0039, B:23:0x003c, B:25:0x0040, B:27:0x0048, B:30:0x0051, B:32:0x0059, B:33:0x005d, B:35:0x0065, B:29:0x004e, B:13:0x001f), top: B:44:0x0001 }] */
    @Override // com.google.android.libraries.navigation.internal.pb.x, com.google.android.libraries.navigation.internal.pc.c
    public final synchronized int b() {
        int i;
        if (this.o == 0.0f && this.p == 0.0f) {
            i = 0;
            if (this.s && (this.a != 0.0f || this.m != 0.0f)) {
                i = com.google.android.libraries.navigation.internal.pd.d.c;
            }
        } else {
            i = com.google.android.libraries.navigation.internal.pd.d.c;
        }
        if (this.a != 0.0f) {
            i |= com.google.android.libraries.navigation.internal.pd.d.d;
        }
        if (this.f551n != 0.0f) {
            i |= com.google.android.libraries.navigation.internal.pd.d.e;
        }
        if (this.m != 0.0f) {
            i |= com.google.android.libraries.navigation.internal.pd.d.f;
        }
        if (this.t) {
            a aVar = this.B;
            if (aVar.d != 0.0f || aVar.e != 0.0f) {
                i |= com.google.android.libraries.navigation.internal.pd.d.c;
            }
            if (this.B.f != 0.0f) {
                i = com.google.android.libraries.navigation.internal.pd.d.d | i;
            }
            if (this.B.g != 0.0f) {
                return com.google.android.libraries.navigation.internal.pd.d.f | i;
            }
        }
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.x, com.google.android.libraries.navigation.internal.pc.c
    public final long c() {
        return 0L;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.x, com.google.android.libraries.navigation.internal.pc.c
    public final boolean e() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.x, com.google.android.libraries.navigation.internal.pc.c
    public final Object g(int i) {
        return this.y.d(i);
    }

    @Override // com.google.android.libraries.navigation.internal.pb.x, com.google.android.libraries.navigation.internal.pc.c
    public final Object h(int i) {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.x, com.google.android.libraries.navigation.internal.pc.c
    public final void l(int i) {
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.pb.x
    public final boolean m(com.google.android.libraries.navigation.internal.pd.d dVar, com.google.android.libraries.navigation.internal.pd.d dVar2) {
        ar.q(dVar);
        this.y = dVar;
        return true;
    }

    final synchronized float n() {
        return this.y.k;
    }

    final synchronized float t() {
        return this.B.f;
    }

    final synchronized float u(float f) {
        float f2;
        f2 = this.m + f;
        this.m = f2;
        if (f != 0.0f) {
            this.s = false;
        }
        return m.a(this.y.m + f2);
    }

    final synchronized float v(float f, float f2, float f3) {
        float f4;
        f4 = this.m + f;
        this.m = f4;
        if (f != 0.0f) {
            this.q = f2;
            this.r = f3;
            this.s = true;
        }
        return m.a(this.y.m + f4);
    }

    final synchronized float w(float f) {
        float f2;
        f2 = this.a + f;
        this.a = f2;
        if (f != 0.0f) {
            this.s = false;
        }
        return m.b(this.y.k + f2);
    }

    final synchronized float x(float f, float f2, float f3) {
        float f4;
        f4 = this.a + f;
        this.a = f4;
        if (f != 0.0f) {
            this.q = f2;
            this.r = f3;
            this.s = true;
        }
        return m.b(this.y.k + f4);
    }

    final synchronized void y() {
        this.t = false;
        a aVar = this.B;
        aVar.c.abortAnimation();
        aVar.i = aVar.h;
    }

    final synchronized void z(float[] fArr) {
        this.t = true;
        float[] fArr2 = this.u;
        int length = fArr2.length;
        System.arraycopy(fArr, 0, fArr2, 0, 4);
        float[] fArr3 = this.u;
        float f = fArr3[0];
        float f2 = fArr3[1];
        float f3 = fArr3[2];
        float f4 = fArr3[3];
        float fAbs = f3 == 0.0f ? 1.0f : Math.abs(15.0f / f3);
        if (fAbs < 1.0f) {
            f *= fAbs;
            f2 *= fAbs;
            f3 *= fAbs;
            f4 *= fAbs;
        }
        a aVar = this.B;
        int iRound = (int) Math.round(Math.hypot(f, f2));
        float f5 = f3 * aVar.a;
        float f6 = f4 * aVar.b;
        int iRound2 = Math.round(f5);
        int iRound3 = Math.round(f6);
        int iA = aVar.a(iRound, Integer.MAX_VALUE);
        aVar.d = iRound == 0 ? 0.0f : (iA * f) / iRound;
        aVar.e = iRound == 0 ? 0.0f : (iA * f2) / iRound;
        aVar.f = aVar.a(iRound2, (int) (aVar.a * 4.0f)) / aVar.a;
        aVar.g = aVar.a(iRound3, Integer.MAX_VALUE) / aVar.b;
        int iAbs = Math.abs(iRound2);
        int iAbs2 = Math.abs(iRound3);
        int iD = com.google.android.libraries.navigation.internal.zy.i.d(iRound, iAbs, iAbs2);
        if (iD == iRound) {
            aVar.h = aVar.a(iRound, Integer.MAX_VALUE);
        } else if (iD == iAbs) {
            aVar.h = aVar.a(iAbs, (int) (aVar.a * 4.0f));
        } else {
            aVar.h = aVar.a(iAbs2, Integer.MAX_VALUE);
        }
        aVar.i = 0;
        Arrays.fill(this.v, 0.0f);
    }
}
