package com.google.android.libraries.navigation.internal.p002do;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.core.view.animation.PathInterpolatorCompat;
import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.afl.Cdo;
import com.google.android.libraries.navigation.internal.db.r;
import com.google.android.libraries.navigation.internal.dr.ae;
import com.google.android.libraries.navigation.internal.dt.f;
import com.google.android.libraries.navigation.internal.nw.d;
import com.google.android.libraries.navigation.internal.nw.e;
import com.google.android.libraries.navigation.internal.oe.q;
import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.pb.j;
import com.google.android.libraries.navigation.internal.rf.g;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k implements l {
    static final long a;
    static final long b;
    static final long c;
    public static final TimeInterpolator d;
    private static final long h;
    private static final TimeInterpolator i;
    private static final TypeEvaluator j;
    private static final TimeInterpolator k;
    private static final TimeInterpolator l;
    private static final TimeInterpolator m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final TimeInterpolator f401n;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private float F;
    private float G;
    private final ValueAnimator H;
    private final ValueAnimator I;
    private final ValueAnimator J;
    private final ValueAnimator K;
    private final List L;
    private int M;
    private int N;
    final ValueAnimator e;
    final ValueAnimator f;
    public final f g;
    private long o;
    private long p;
    private final f q;
    private final f r;
    private final q s;
    private final br t;
    private float u;
    private double v;
    private float w;
    private float x;
    private float y;
    private float z;

    static {
        long millis = TimeUnit.SECONDS.toMillis(1L);
        a = millis;
        b = millis;
        c = TimeUnit.MINUTES.toMillis(1L);
        h = TimeUnit.SECONDS.toMillis(3L);
        i = PathInterpolatorCompat.create(0.33f, 0.0f, 0.67f, 1.0f);
        j = new c();
        k = new LinearInterpolator();
        d = new AccelerateDecelerateInterpolator();
        l = new d();
        m = new e();
        f401n = new f();
    }

    public k(Cdo cdo) {
        ValueAnimator valueAnimator = new ValueAnimator();
        this.e = valueAnimator;
        ValueAnimator valueAnimator2 = new ValueAnimator();
        this.f = valueAnimator2;
        this.o = 0L;
        this.p = 500L;
        this.q = new f();
        this.r = new f();
        this.g = new f();
        this.s = new q();
        this.u = 1.0f;
        this.v = 1.0d;
        this.w = 1.0f;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.A = false;
        this.B = false;
        this.C = true;
        this.D = false;
        this.E = false;
        this.F = -1.0f;
        this.G = -1.0f;
        this.M = 1;
        this.N = 1;
        ValueAnimator valueAnimator3 = new ValueAnimator();
        this.H = valueAnimator3;
        ValueAnimator valueAnimator4 = new ValueAnimator();
        this.I = valueAnimator4;
        ValueAnimator valueAnimator5 = new ValueAnimator();
        this.J = valueAnimator5;
        ValueAnimator valueAnimator6 = new ValueAnimator();
        this.K = valueAnimator6;
        this.L = hx.d(valueAnimator4, valueAnimator3, valueAnimator5, valueAnimator6);
        valueAnimator4.addUpdateListener(new g(this));
        valueAnimator5.addUpdateListener(new h(this));
        valueAnimator3.addUpdateListener(new i(this));
        valueAnimator6.addUpdateListener(new j(this));
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.setDuration(a);
        valueAnimator.setInterpolator(k);
        valueAnimator.setRepeatCount(5);
        valueAnimator.setRepeatMode(2);
        boolean z = cdo.b;
        this.D = z;
        if (z) {
            valueAnimator2.setFloatValues(0.82f, 0.62f, 0.72f, 0.82f);
            valueAnimator2.setDuration(h);
            valueAnimator2.setInterpolator(i);
            valueAnimator2.setRepeatCount(cdo.c);
            valueAnimator2.setRepeatMode(1);
        }
        this.t = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.do.b
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                TimeInterpolator timeInterpolator = k.d;
                return new a();
            }
        });
    }

    private final float o(float f) {
        return p((float) (((double) f) * this.v));
    }

    private final float p(float f) {
        return (f / this.u) / this.w;
    }

    private final void q(f fVar) {
        if (o(fVar.f) >= 17.0f || this.z >= 12.0f) {
            return;
        }
        fVar.f = 0;
    }

    private final void r(long j2) {
        int size = this.L.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((ValueAnimator) ((Animator) this.L.get(i2))).setDuration(j2);
        }
        this.p = j2;
    }

    private final boolean s(long j2) {
        long j3 = this.o;
        return j2 >= j3 && j2 <= this.p + j3;
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final void a(boolean z) {
        if (this.E == z) {
            return;
        }
        this.E = z;
        if (z) {
        } else {
            ((a) this.t.a()).b();
        }
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final void b(f fVar) {
        f fVar2 = this.g;
        fVar.a = fVar2.a;
        fVar.g = fVar2.a();
        fVar.f = fVar2.f;
        fVar.b = this.s.a;
        fVar.c = this.F != -1.0f;
        float f = this.G;
        fVar.h = f;
        fVar.i = f != -1.0f;
        if (this.e.isRunning()) {
            fVar.f413n = ((Float) this.e.getAnimatedValue()).floatValue();
        } else {
            fVar.f413n = 1.0f;
        }
        fVar.m = this.g.m * ae.a(this.z);
        if (this.f.isRunning()) {
            fVar.o = ((Float) this.f.getAnimatedValue()).floatValue();
        } else {
            fVar.o = 0.82f;
        }
        q(fVar);
        if (this.E) {
            ((a) this.t.a()).a(fVar, this.z);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final void c() {
        this.A = false;
        this.B = false;
        e();
        if (this.E) {
        }
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        h();
        g();
        ((a) this.t.a()).b();
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final void d(boolean z) {
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final void e() {
        if (this.D) {
            ValueAnimator valueAnimator = this.f;
            d dVarB = e.b("MyLocationMapMarkerAnimation.startPulsatingImpl");
            try {
                if (!valueAnimator.isRunning()) {
                    valueAnimator.start();
                }
                if (dVarB != null) {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                if (dVarB != null) {
                    try {
                        Trace.endSection();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final void f() {
        d dVarB = e.b("MyLocationMapMarkerAnimation.startThrobbing");
        try {
            if (this.C && !this.e.isRunning()) {
                this.e.start();
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final void g() {
        d dVarB = e.b("MyLocationMapMarkerAnimation.stopPulsating");
        try {
            if (this.f.isRunning()) {
                this.f.end();
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final void h() {
        d dVarB = e.b("MyLocationMapMarkerAnimation.stopThrobbing");
        try {
            this.e.end();
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final void i(com.google.android.libraries.navigation.internal.oq.d dVar) {
        g gVarC = dVar.c();
        this.u = j.s(gVarC);
        this.w = gVarC.b();
        this.x = gVarC.d() / this.w;
        this.y = gVarC.c() / this.w;
        this.v = new q(gVarC.a.t()).a().e();
        this.z = dVar.a().c();
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final void j(float f) {
        this.G = f;
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final boolean l(float f) {
        this.s.a(f);
        this.F = f;
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final boolean m(r rVar) {
        this.B = true;
        x xVarN = rVar.n();
        int iF = -1;
        if (rVar != null && rVar.t()) {
            iF = (int) rVar.f();
        }
        this.r.d(xVarN, iF, rVar.r() ? (int) rVar.d : 1, rVar.t());
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final void n() {
        this.C = false;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00b7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:42:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:44:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:45:0x00d1  */
    @Override // com.google.android.libraries.navigation.internal.p002do.l
    public final boolean k(long j2) {
        boolean z;
        if (this.B) {
            f fVar = this.r;
            if (fVar.f()) {
                this.B = false;
                if (this.A) {
                    this.N = 1;
                    long j3 = j2 - this.o;
                    if (j3 >= 250) {
                        f fVar2 = this.q;
                        if (fVar2.f() && this.r.f()) {
                            x xVar = fVar2.a;
                            ar.q(xVar);
                            x xVar2 = this.r.a;
                            ar.q(xVar2);
                            float fP = !xVar2.equals(xVar) ? p(xVar.h(xVar2)) : 0.0f;
                            float fO = o(Math.min(this.r.f, this.q.f));
                            long j4 = c;
                            if (j3 > j4 || (fP > 0.0f && fP > fO * 0.0f)) {
                                xVar.W(xVar2);
                                z = true;
                            } else {
                                z = false;
                            }
                            q(this.r);
                            f fVar3 = this.q;
                            f fVar4 = this.r;
                            int i2 = fVar3.f;
                            int i3 = fVar4.f;
                            if (i2 != i3) {
                                float fAbs = Math.abs(o(i3 - i2));
                                if (j3 > j4 || fAbs > 50.0f || (i2 != 0 && i3 == 0)) {
                                    fVar3.f = i3;
                                } else if (z) {
                                }
                                if (fP < 100.0f) {
                                    this.N = 2;
                                } else if (fP < Math.min(this.x, this.y)) {
                                    this.N = 3;
                                } else {
                                    this.N = 4;
                                }
                            } else if (z) {
                                if (fP < 100.0f) {
                                    this.N = 2;
                                } else if (fP < Math.min(this.x, this.y)) {
                                    this.N = 3;
                                } else {
                                    this.N = 4;
                                }
                            }
                        }
                    }
                } else {
                    this.g.c(fVar);
                    this.q.c(this.r);
                    this.A = true;
                }
            }
        }
        this.s.b(j2);
        if (!s(j2)) {
            int i4 = this.N;
            this.M = i4;
            this.N = 1;
            if (i4 != 1) {
                x xVar3 = this.g.a;
                ar.q(xVar3);
                x xVar4 = this.q.a;
                ar.q(xVar4);
                this.I.setObjectValues(xVar3, xVar4);
                ValueAnimator valueAnimator = this.I;
                TypeEvaluator typeEvaluator = j;
                valueAnimator.setEvaluator(typeEvaluator);
                this.J.setObjectValues(xVar3, xVar4);
                this.J.setEvaluator(typeEvaluator);
                this.H.setIntValues(this.g.f, this.q.f);
                this.K.setFloatValues(1.0f);
                int i5 = this.M;
                int i6 = i5 - 1;
                if (i5 == 0) {
                    throw null;
                }
                if (i6 == 1) {
                    ValueAnimator valueAnimator2 = this.I;
                    TimeInterpolator timeInterpolator = k;
                    valueAnimator2.setInterpolator(timeInterpolator);
                    this.J.setInterpolator(timeInterpolator);
                    this.H.setInterpolator(timeInterpolator);
                    this.K.setInterpolator(l);
                    r(500L);
                } else if (i6 == 2) {
                    ValueAnimator valueAnimator3 = this.I;
                    TimeInterpolator timeInterpolator2 = d;
                    valueAnimator3.setInterpolator(timeInterpolator2);
                    this.J.setInterpolator(timeInterpolator2);
                    this.H.setInterpolator(timeInterpolator2);
                    this.K.setInterpolator(l);
                    r(a);
                } else if (i6 == 3) {
                    ValueAnimator valueAnimator4 = this.I;
                    TimeInterpolator timeInterpolator3 = m;
                    valueAnimator4.setInterpolator(timeInterpolator3);
                    this.J.setInterpolator(timeInterpolator3);
                    this.H.setInterpolator(k);
                    this.K.setFloatValues(0.5f, 1.0f);
                    this.K.setInterpolator(f401n);
                    r(b);
                }
                this.o = j2;
            }
        }
        if (this.M != 1) {
            long j5 = this.o;
            if (j2 >= j5) {
                long jMax = Math.max(0L, Math.min(j2 - j5, this.p));
                int size = this.L.size();
                for (int i7 = 0; i7 < size; i7++) {
                    ((ValueAnimator) this.L.get(i7)).setCurrentPlayTime(jMax);
                }
            }
        }
        return s(j2) || this.e.isRunning();
    }
}
