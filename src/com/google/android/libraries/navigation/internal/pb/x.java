package com.google.android.libraries.navigation.internal.pb;

import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class x implements com.google.android.libraries.navigation.internal.pc.c {
    protected final com.google.android.libraries.navigation.internal.ni.a c;
    protected long d;
    public long e;
    public volatile int f;
    protected final w g;
    protected final w h;
    protected final w i;
    protected final w j;
    protected final w k;
    protected final w[] l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.google.android.libraries.navigation.internal.pd.d f514n;
    private boolean o;
    static final TimeInterpolator b = com.google.android.libraries.navigation.internal.k.b.a;
    private static final TypeEvaluator a = new u();
    private static final TypeEvaluator m = new v();

    public x(com.google.android.libraries.navigation.internal.ni.a aVar) {
        this(aVar, null);
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public int a(long j) {
        int i;
        if (this.f514n == null || this.f == 0) {
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
                if (s(i3)) {
                    w[] wVarArr = this.l;
                    int i4 = i3 - 1;
                    if (i3 == 0) {
                        throw null;
                    }
                    w wVar = wVarArr[i4];
                    wVar.setCurrentPlayTime(Math.max(0L, Math.min(j2 - wVar.getStartDelay(), wVar.getDuration())));
                }
            }
        }
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public int b() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public long c() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public boolean d() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public boolean e() {
        return false;
    }

    public void f(TimeInterpolator timeInterpolator) {
        ar.l(this.o, "Cannot set time interpolator outside of initialization window.");
        synchronized (this.l) {
            for (w wVar : this.l) {
                wVar.setInterpolator(timeInterpolator);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public Object g(int i) {
        Object animatedValue;
        synchronized (this.l) {
            w[] wVarArr = this.l;
            int i2 = i - 1;
            if (i == 0) {
                throw null;
            }
            animatedValue = wVarArr[i2].getAnimatedValue();
        }
        return animatedValue;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public Object h(int i) {
        com.google.android.libraries.navigation.internal.pd.d dVar = this.f514n;
        if (dVar == null) {
            return null;
        }
        return dVar.d(i);
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final void i(com.google.android.libraries.navigation.internal.pc.c cVar, int i) {
        if (cVar != this) {
            r(i, false);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final void j() {
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public boolean k(com.google.android.libraries.navigation.internal.pc.c cVar) {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public void l(int i) {
        this.o = false;
        this.d = this.c.a();
        this.f = i;
        synchronized (this.l) {
            int[] iArrB = com.google.android.libraries.navigation.internal.pd.b.b();
            for (int i2 = 0; i2 < 5; i2++) {
                int i3 = iArrB[i2];
                if (s(i3)) {
                    w[] wVarArr = this.l;
                    int i4 = i3 - 1;
                    if (i3 == 0) {
                        throw null;
                    }
                    wVarArr[i4].start();
                }
            }
        }
    }

    public boolean m(com.google.android.libraries.navigation.internal.pd.d dVar, com.google.android.libraries.navigation.internal.pd.d dVar2) {
        this.o = true;
        this.f = 0;
        if (dVar2 == null) {
            return false;
        }
        if (dVar == null && (dVar = this.f514n) == null) {
            this.f514n = dVar2;
            return false;
        }
        this.f514n = new com.google.android.libraries.navigation.internal.pd.a(dVar2).a();
        com.google.android.libraries.navigation.internal.oe.x xVarD = dVar2.j.D(dVar.j);
        float f = dVar2.m;
        float f2 = dVar.m;
        float fAbs = Math.abs(f - f2);
        if (fAbs >= 360.0f - fAbs) {
            f = f < f2 ? f + 360.0f : f - 360.0f;
        }
        synchronized (this.l) {
            this.g.setObjectValues(dVar.j, xVarD);
            this.g.setEvaluator(a);
            this.g.setCurrentPlayTime(0L);
            this.h.setFloatValues(dVar.k, dVar2.k);
            this.h.setCurrentPlayTime(0L);
            this.i.setFloatValues(dVar.l, dVar2.l);
            this.i.setCurrentPlayTime(0L);
            this.j.setFloatValues(dVar.m, f);
            this.j.setCurrentPlayTime(0L);
            this.k.setObjectValues(dVar.f515n, dVar2.f515n);
            this.k.setEvaluator(m);
            this.k.setCurrentPlayTime(0L);
        }
        p(1000L);
        f(b);
        r(1, !dVar.j.equals(dVar2.j));
        r(2, dVar.k != dVar2.k);
        r(3, dVar.l != dVar2.l);
        r(4, dVar.m != dVar2.m);
        r(5, !dVar.f515n.equals(dVar2.f515n));
        return true;
    }

    public final void o(com.google.android.libraries.navigation.internal.pd.a aVar) {
        int[] iArrB = com.google.android.libraries.navigation.internal.pd.b.b();
        for (int i = 0; i < 5; i++) {
            int i2 = iArrB[i];
            if (s(i2)) {
                aVar.c(i2, g(i2));
            }
        }
    }

    public final void p(long j) {
        ar.l(this.o, "Cannot set duration outside of initialization window.");
        this.e = j;
        synchronized (this.l) {
            for (w wVar : this.l) {
                wVar.a(j);
            }
        }
    }

    public final void q() {
        synchronized (this.l) {
            this.e = 0L;
            int[] iArrB = com.google.android.libraries.navigation.internal.pd.b.b();
            for (int i = 0; i < 5; i++) {
                int i2 = iArrB[i];
                if (s(i2)) {
                    long j = this.e;
                    w[] wVarArr = this.l;
                    int i3 = i2 - 1;
                    if (i2 == 0) {
                        throw null;
                    }
                    this.e = Math.max(j, wVarArr[i3].getStartDelay() + this.l[i3].getDuration());
                }
            }
        }
    }

    protected final void r(int i, boolean z) {
        int i2;
        int i3 = i - 1;
        if (z) {
            i2 = (1 << i3) | this.f;
        } else {
            i2 = (~(1 << i3)) & this.f;
        }
        this.f = i2;
    }

    protected final boolean s(int i) {
        int i2 = this.f;
        if (i != 0) {
            return ((1 << (i + (-1))) & i2) != 0;
        }
        throw null;
    }

    public x(com.google.android.libraries.navigation.internal.ni.a aVar, byte[] bArr) {
        w[] wVarArr = new w[com.google.android.libraries.navigation.internal.pd.d.b];
        this.l = wVarArr;
        ar.q(aVar);
        this.c = aVar;
        w wVar = new w(this);
        this.g = wVar;
        w wVar2 = new w(this);
        this.h = wVar2;
        w wVar3 = new w(this);
        this.i = wVar3;
        w wVar4 = new w(this);
        this.j = wVar4;
        w wVar5 = new w(this);
        this.k = wVar5;
        wVarArr[0] = wVar;
        wVarArr[1] = wVar2;
        wVarArr[2] = wVar3;
        wVarArr[3] = wVar4;
        wVarArr[4] = wVar5;
    }
}
