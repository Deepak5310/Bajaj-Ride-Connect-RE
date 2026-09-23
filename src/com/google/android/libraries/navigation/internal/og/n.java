package com.google.android.libraries.navigation.internal.og;

import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class n implements com.google.android.libraries.navigation.internal.pc.c {
    protected final com.google.android.libraries.navigation.internal.ni.a c;
    protected long d;
    public long e;
    public volatile int f;
    protected final m g;
    protected final m h;
    protected final m i;
    protected final m j;
    protected final m k;
    protected final m[] l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.google.android.libraries.navigation.internal.oq.f f496n;
    private boolean o;
    static final TimeInterpolator b = com.google.android.libraries.navigation.internal.k.b.a;
    private static final TypeEvaluator a = new k();
    private static final TypeEvaluator m = new l();

    public n(com.google.android.libraries.navigation.internal.ni.a aVar) {
        this(aVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final int a(long j) {
        int i;
        if (this.f496n == null || this.f == 0) {
            return 0;
        }
        long j2 = j - this.d;
        if (j2 < 0) {
            i = 0;
            j2 = 0;
        } else {
            long j3 = this.e;
            if (j2 >= j3) {
                i = 0;
                j2 = j3;
            } else {
                i = 6;
            }
        }
        synchronized (this.l) {
            int[] iArrB = com.google.android.libraries.navigation.internal.pd.b.b();
            for (int i2 = 0; i2 < 5; i2++) {
                int i3 = iArrB[i2];
                if (r(i3)) {
                    m[] mVarArr = this.l;
                    int i4 = i3 - 1;
                    if (i3 == 0) {
                        throw null;
                    }
                    m mVar = mVarArr[i4];
                    mVar.setCurrentPlayTime(Math.max(0L, Math.min(j2 - mVar.getStartDelay(), mVar.getDuration())));
                }
            }
        }
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final int b() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final long c() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public boolean d() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final boolean e() {
        return false;
    }

    public void f(TimeInterpolator timeInterpolator) {
        ar.l(this.o, "Cannot set time interpolator outside of initialization window.");
        synchronized (this.l) {
            for (m mVar : this.l) {
                mVar.setInterpolator(timeInterpolator);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final Object g(int i) {
        Object animatedValue;
        synchronized (this.l) {
            m[] mVarArr = this.l;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            animatedValue = mVarArr[i2].getAnimatedValue();
        }
        return animatedValue;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final Object h(int i) {
        float fC;
        com.google.android.libraries.navigation.internal.oq.f fVar = this.f496n;
        if (fVar == null) {
            return null;
        }
        int i2 = i - 1;
        if (i2 == 0) {
            return x.z(fVar.d());
        }
        if (i2 == 1) {
            fC = fVar.c();
        } else if (i2 == 2) {
            fC = fVar.b();
        } else {
            if (i2 != 3) {
                return new com.google.android.libraries.navigation.internal.pd.e(((com.google.android.libraries.navigation.internal.oq.c) fVar.f()).a, ((com.google.android.libraries.navigation.internal.oq.c) fVar.f()).b);
            }
            fC = fVar.a();
        }
        return Float.valueOf(fC);
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final void i(com.google.android.libraries.navigation.internal.pc.c cVar, int i) {
        if (cVar != this) {
            q(i, false);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final void j() {
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final boolean k(com.google.android.libraries.navigation.internal.pc.c cVar) {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final void l(int i) {
        this.o = false;
        this.d = this.c.a();
        this.f = i;
        synchronized (this.l) {
            int[] iArrB = com.google.android.libraries.navigation.internal.pd.b.b();
            for (int i2 = 0; i2 < 5; i2++) {
                int i3 = iArrB[i2];
                if (r(i3)) {
                    m[] mVarArr = this.l;
                    int i4 = i3 - 1;
                    if (i3 == 0) {
                        throw null;
                    }
                    mVarArr[i4].start();
                }
            }
        }
    }

    public boolean m(com.google.android.libraries.navigation.internal.oq.f fVar, com.google.android.libraries.navigation.internal.oq.f fVar2) {
        this.o = true;
        this.f = 0;
        this.f496n = fVar2.e().l();
        x xVarD = x.z(fVar2.d()).D(x.z(fVar.d()));
        float fA = fVar.a();
        float fA2 = fVar2.a();
        float fAbs = Math.abs(fA2 - fA);
        if (fAbs >= 360.0f - fAbs) {
            fA2 = fA2 < fA ? fA2 + 360.0f : fA2 - 360.0f;
        }
        synchronized (this.l) {
            this.g.setObjectValues(x.z(fVar.d()), xVarD);
            this.g.setEvaluator(a);
            this.g.setCurrentPlayTime(0L);
            this.h.setFloatValues(fVar.c(), fVar2.c());
            this.h.setCurrentPlayTime(0L);
            this.i.setFloatValues(fVar.b(), fVar2.b());
            this.i.setCurrentPlayTime(0L);
            this.j.setFloatValues(fVar.a(), fA2);
            this.j.setCurrentPlayTime(0L);
            this.k.setObjectValues(new com.google.android.libraries.navigation.internal.pd.e(((com.google.android.libraries.navigation.internal.oq.c) fVar.f()).a, ((com.google.android.libraries.navigation.internal.oq.c) fVar.f()).b), new com.google.android.libraries.navigation.internal.pd.e(((com.google.android.libraries.navigation.internal.oq.c) fVar2.f()).a, ((com.google.android.libraries.navigation.internal.oq.c) fVar2.f()).b));
            this.k.setEvaluator(m);
            this.k.setCurrentPlayTime(0L);
        }
        o(1000L);
        f(b);
        q(1, !fVar.d().equals(fVar2.d()));
        q(2, fVar.c() != fVar2.c());
        q(3, fVar.b() != fVar2.b());
        q(4, fVar.a() != fVar2.a());
        q(5, !fVar.f().equals(fVar2.f()));
        return true;
    }

    public final void n(com.google.android.libraries.navigation.internal.oq.e eVar) {
        int[] iArrB = com.google.android.libraries.navigation.internal.pd.b.b();
        for (int i = 0; i < 5; i++) {
            int i2 = iArrB[i];
            if (r(i2)) {
                Object objG = g(i2);
                com.google.android.libraries.navigation.internal.pd.d dVar = com.google.android.libraries.navigation.internal.pd.d.a;
                if (objG != null) {
                    int i3 = i2 - 1;
                    if (i2 == 0) {
                        throw null;
                    }
                    if (i3 == 0) {
                        eVar.e(((x) objG).t());
                    } else if (i3 == 1) {
                        eVar.k(((Float) objG).floatValue());
                    } else if (i3 == 2) {
                        eVar.j(((Float) objG).floatValue());
                    } else if (i3 == 3) {
                        eVar.h(((Float) objG).floatValue());
                    } else if (i3 == 4) {
                        com.google.android.libraries.navigation.internal.pd.e eVar2 = (com.google.android.libraries.navigation.internal.pd.e) objG;
                        eVar.i(com.google.android.libraries.navigation.internal.oq.j.c(eVar2.b, eVar2.c));
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public final void o(long j) {
        ar.l(this.o, "Cannot set duration outside of initialization window.");
        this.e = j;
        synchronized (this.l) {
            for (m mVar : this.l) {
                mVar.a(j);
            }
        }
    }

    public final void p() {
        synchronized (this.l) {
            this.e = 0L;
            int[] iArrB = com.google.android.libraries.navigation.internal.pd.b.b();
            for (int i = 0; i < 5; i++) {
                int i2 = iArrB[i];
                if (r(i2)) {
                    long j = this.e;
                    m[] mVarArr = this.l;
                    int i3 = i2 - 1;
                    if (i2 == 0) {
                        throw null;
                    }
                    this.e = Math.max(j, mVarArr[i3].getStartDelay() + this.l[i3].getDuration());
                }
            }
        }
    }

    protected final void q(int i, boolean z) {
        int i2;
        int i3 = i - 1;
        if (z) {
            i2 = (1 << i3) | this.f;
        } else {
            i2 = (~(1 << i3)) & this.f;
        }
        this.f = i2;
    }

    protected final boolean r(int i) {
        int i2 = this.f;
        if (i != 0) {
            return ((1 << (i + (-1))) & i2) != 0;
        }
        throw null;
    }

    public n(com.google.android.libraries.navigation.internal.ni.a aVar, byte[] bArr) {
        m[] mVarArr = new m[com.google.android.libraries.navigation.internal.pd.d.b];
        this.l = mVarArr;
        ar.q(aVar);
        this.c = aVar;
        m mVar = new m(this);
        this.g = mVar;
        m mVar2 = new m(this);
        this.h = mVar2;
        m mVar3 = new m(this);
        this.i = mVar3;
        m mVar4 = new m(this);
        this.j = mVar4;
        m mVar5 = new m(this);
        this.k = mVar5;
        mVarArr[0] = mVar;
        mVarArr[1] = mVar2;
        mVarArr[2] = mVar3;
        mVarArr[3] = mVar4;
        mVarArr[4] = mVar5;
    }
}
