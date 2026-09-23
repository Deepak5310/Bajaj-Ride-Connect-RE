package com.google.android.libraries.navigation.internal.uu;

import android.view.View;
import com.google.android.libraries.navigation.SpeedAlertSeverity;
import com.google.android.libraries.navigation.internal.adr.bm;
import com.google.android.libraries.navigation.internal.ady.al;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.jy.aa;
import com.google.android.libraries.navigation.internal.jy.x;
import com.google.android.libraries.navigation.internal.ms.cs;
import com.google.android.libraries.navigation.internal.zp.ca;
import com.google.android.libraries.navigation.internal.zt.am;
import com.google.android.libraries.navigation.internal.zt.ao;
import com.google.android.libraries.navigation.internal.zt.ap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class q {
    private final a B;
    private boolean C;
    public final com.google.android.libraries.navigation.internal.iv.f a;
    public final l b;
    public final t c;
    public final r d;
    public final a e;
    public al g;
    public boolean j;
    public boolean k;
    public com.google.android.libraries.navigation.internal.ux.e l;
    public com.google.android.libraries.navigation.internal.ux.c m;
    public boolean q;
    public boolean r;
    public boolean t;
    public final com.google.android.libraries.navigation.internal.ux.d w;
    public final com.google.android.libraries.navigation.internal.ux.f x;
    public final com.google.android.libraries.navigation.internal.afd.a z;
    public int y = 1;
    public bm.a f = bm.a.KILOMETERS;
    public int h = -1;
    public int i = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f629n = false;
    public boolean o = false;
    public boolean p = false;
    public final boolean s = true;
    public final View.OnAttachStateChangeListener u = new n(this);
    public final k v = new o(this);
    public final p A = new p(this);

    public q(com.google.android.libraries.navigation.internal.iv.f fVar, l lVar, t tVar, com.google.android.libraries.navigation.internal.afd.a aVar, r rVar) {
        com.google.android.libraries.navigation.internal.ux.d dVar = new com.google.android.libraries.navigation.internal.ux.d() { // from class: com.google.android.libraries.navigation.internal.uu.q.1
            @Override // com.google.android.libraries.navigation.internal.ux.d
            public com.google.android.libraries.navigation.internal.ux.f a() {
                return q.this.x;
            }

            @Override // com.google.android.libraries.navigation.internal.ux.d
            public void b(int i) {
                q.this.x.C(i);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.d
            public void c(int i) {
                q.this.x.D(i);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.d
            public void d(int i) {
                q.this.x.E(i);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.d
            public void e(int i) {
                q.this.x.F(i);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.d
            public void f(int i) {
                q.this.x.G(i);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.d
            public void g(int i) {
                q.this.x.H(i);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.d
            public void h(int i) {
                q.this.x.I(i);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.d
            public void i(int i) {
                q.this.x.J(i);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.d
            public void j(boolean z) {
                q qVar = q.this;
                qVar.q = z;
                qVar.o = true;
                qVar.e.b();
            }

            @Override // com.google.android.libraries.navigation.internal.ux.d
            public void k(boolean z) {
                q qVar = q.this;
                qVar.r = z;
                qVar.f629n = true;
                qVar.e.b();
            }
        };
        this.w = dVar;
        com.google.android.libraries.navigation.internal.ux.f fVar2 = new com.google.android.libraries.navigation.internal.ux.f() { // from class: com.google.android.libraries.navigation.internal.uu.q.2
            private int b = 16777215;
            private int c = 0;
            private int d = 14233637;
            private int e = 14233637;
            private int f = 14233637;
            private int g = 14233637;
            private int h = 16777215;
            private int i = 16777215;

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Integer A() {
                if (q.this.f != bm.a.MILES) {
                    return Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.bn);
                }
                n().booleanValue();
                return Integer.valueOf(com.google.android.libraries.navigation.internal.dw.h.bl);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public String B() {
                int i = q.this.i;
                return i == -1 ? "--" : Integer.toString(i);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public void C(int i) {
                this.f = i;
                q qVar = q.this;
                qVar.f629n = true;
                qVar.e.b();
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public void D(int i) {
                this.g = i;
                q qVar = q.this;
                qVar.f629n = true;
                qVar.e.b();
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public void E(int i) {
                this.h = i;
                q qVar = q.this;
                qVar.f629n = true;
                qVar.e.b();
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public void F(int i) {
                this.i = i;
                q qVar = q.this;
                qVar.f629n = true;
                qVar.e.b();
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public void G(int i) {
                this.b = i;
                q qVar = q.this;
                qVar.f629n = true;
                qVar.e.b();
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public void H(int i) {
                this.c = i;
                q qVar = q.this;
                qVar.f629n = true;
                qVar.e.b();
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public void I(int i) {
                this.d = i;
                q qVar = q.this;
                qVar.f629n = true;
                qVar.e.b();
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public void J(int i) {
                this.e = i;
                q qVar = q.this;
                qVar.f629n = true;
                qVar.e.b();
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public View.OnAttachStateChangeListener a() {
                return q.this.u;
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public aa b() {
                q qVar = q.this;
                if (qVar.h < 0 || !qVar.j) {
                    return null;
                }
                com.google.android.libraries.navigation.internal.zb.j jVar = aa.a;
                x xVar = new x();
                am amVar = (am) ap.a.q();
                int i = q.this.k ? ao.b : ao.c;
                if (!amVar.b.H()) {
                    amVar.v();
                }
                ap apVar = (ap) amVar.b;
                int i2 = i - 1;
                if (i == 0) {
                    throw null;
                }
                apVar.c = i2;
                apVar.b |= 1;
                xVar.a = (ap) amVar.t();
                xVar.i = q.this.z;
                if (!k().booleanValue()) {
                    xVar.k(ca.VISIBILITY_REPRESSED_COUNTERFACTUAL);
                }
                return xVar.b();
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public aa c() {
                if (!q.this.k) {
                    return null;
                }
                com.google.android.libraries.navigation.internal.zb.j jVar = aa.a;
                x xVar = new x();
                am amVar = (am) ap.a.q();
                int i = k().booleanValue() ? ao.b : ao.c;
                if (!amVar.b.H()) {
                    amVar.v();
                }
                ap apVar = (ap) amVar.b;
                int i2 = i - 1;
                if (i == 0) {
                    throw null;
                }
                apVar.c = i2;
                apVar.b |= 1;
                xVar.a = (ap) amVar.t();
                xVar.i = com.google.android.libraries.navigation.internal.afe.i.f;
                return xVar.b();
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public com.google.android.libraries.navigation.internal.ms.d d() {
                int i;
                com.google.android.libraries.navigation.internal.ux.c cVar = q.this.m;
                if (cVar != null && !cVar.g) {
                    return cVar;
                }
                q qVar = q.this;
                if (qVar.f629n) {
                    qVar.f629n = false;
                    i = 1;
                } else if (qVar.o) {
                    qVar.o = false;
                    i = 2;
                } else if (qVar.p) {
                    qVar.p = false;
                    i = 3;
                } else {
                    i = 4;
                }
                qVar.m = new com.google.android.libraries.navigation.internal.ux.c(i, this);
                return q.this.m;
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public cs.a e() {
                n().booleanValue();
                if (k().booleanValue()) {
                    q qVar = q.this;
                    qVar.a.n(ab.aP, !qVar.k);
                }
                return cs.a.a;
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public com.google.android.libraries.navigation.internal.ux.e f() {
                return q.this.l;
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Boolean g() {
                n().booleanValue();
                return Boolean.valueOf(k().booleanValue());
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Boolean h() {
                return Boolean.valueOf(q.this.t);
            }

            /* JADX WARN: Code duplicated, block: B:13:0x003d  */
            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Boolean i() {
                boolean z = false;
                if (!k().booleanValue()) {
                    return false;
                }
                q qVar = q.this;
                com.google.android.libraries.navigation.environment.cs csVar = (com.google.android.libraries.navigation.environment.cs) qVar.d;
                Map map = csVar.a;
                int i = qVar.i;
                int i2 = qVar.h;
                bm.a aVar2 = qVar.f;
                Float f = (Float) map.get(SpeedAlertSeverity.MAJOR);
                if (f != null) {
                    if (i >= com.google.android.libraries.navigation.internal.xf.q.a(f.floatValue(), i2)) {
                        z = true;
                    } else if (csVar.b.g() && csVar.c.g()) {
                        if (csVar.d.a() - ((Long) csVar.c.c()).longValue() >= ((Double) csVar.b.c()).doubleValue() * 1000.0d) {
                            z = true;
                        }
                    }
                } else if (i >= com.google.android.libraries.navigation.internal.xf.q.b(i2, aVar2)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Boolean j() {
                return Boolean.valueOf(q.this.y == 3);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Boolean k() {
                q qVar = q.this;
                boolean z = false;
                if (qVar.q && qVar.t) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Boolean l() {
                return Boolean.valueOf(q.this.i >= 100);
            }

            /* JADX WARN: Code duplicated, block: B:13:0x003d  */
            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Boolean m() {
                boolean z = false;
                if (!k().booleanValue()) {
                    return false;
                }
                q qVar = q.this;
                Map map = ((com.google.android.libraries.navigation.environment.cs) qVar.d).a;
                int i = qVar.i;
                int i2 = qVar.h;
                bm.a aVar2 = qVar.f;
                Float f = (Float) map.get(SpeedAlertSeverity.MINOR);
                if (f != null) {
                    if (i >= com.google.android.libraries.navigation.internal.xf.q.a(f.floatValue(), i2)) {
                        z = true;
                    }
                } else if (i >= com.google.android.libraries.navigation.internal.xf.q.c(i2, aVar2)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Boolean n() {
                return true;
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Boolean o() {
                al alVar;
                n().booleanValue();
                q qVar = q.this;
                boolean z = false;
                if (qVar.r && qVar.k && (qVar.g == al.TWO_WHEELER || (alVar = q.this.g) == al.DRIVE || alVar == al.TAXICAB || alVar == al.BICYCLE)) {
                    z = true;
                }
                return Boolean.valueOf(z);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Boolean p() {
                boolean z = true;
                if (!k().booleanValue() && !o().booleanValue()) {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Integer q() {
                return Integer.valueOf(this.f);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Integer r() {
                return Integer.valueOf(this.g);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Integer s() {
                return Integer.valueOf(this.h);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Integer t() {
                return Integer.valueOf(this.i);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Integer u() {
                return Integer.valueOf(this.b);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Integer v() {
                return Integer.valueOf(this.c);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Integer w() {
                return Integer.valueOf(this.d);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Integer x() {
                return Integer.valueOf(this.e);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Integer y() {
                return Integer.valueOf(q.this.f == bm.a.MILES ? com.google.android.libraries.navigation.internal.f.g.f426n : com.google.android.libraries.navigation.internal.f.g.m);
            }

            @Override // com.google.android.libraries.navigation.internal.ux.f
            public Integer z() {
                return Integer.valueOf(q.this.i);
            }
        };
        this.x = fVar2;
        this.a = fVar;
        this.b = lVar;
        this.c = tVar;
        this.z = aVar;
        this.d = rVar;
        this.q = false;
        this.r = false;
        this.l = new com.google.android.libraries.navigation.internal.uw.c(com.google.android.libraries.navigation.internal.si.h.a, false, false);
        this.e = new a(fVar2);
        this.B = new a(dVar);
        this.C = fVar.y(ab.aO, false);
    }

    public final void a() {
        int i = this.h;
        this.l = new com.google.android.libraries.navigation.internal.uw.c(new com.google.android.libraries.navigation.internal.si.h(i >= 0 ? Integer.valueOf(i) : null, this.f, this.y == 3), false, false);
    }

    public final void b() {
        boolean z = false;
        if (this.h >= 0 && this.j) {
            z = true;
        }
        if (z == this.t) {
            return;
        }
        this.t = z;
        this.o = true;
        this.B.c();
        if (this.t && !this.C) {
            this.C = true;
            this.a.n(ab.aO, true);
        }
        this.B.b();
        this.B.a();
        this.e.b();
    }
}
