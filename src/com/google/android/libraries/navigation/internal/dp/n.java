package com.google.android.libraries.navigation.internal.dp;

import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class n implements com.google.android.libraries.navigation.internal.pc.c {
    public com.google.android.libraries.navigation.internal.pd.i c;
    public boolean d;
    public int e;
    private final com.google.android.libraries.navigation.internal.ni.a g;
    private final com.google.android.libraries.navigation.internal.ia.e h;
    private final l i;
    private final com.google.android.libraries.navigation.internal.oq.d j;
    private com.google.android.libraries.navigation.internal.oe.x m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f406n;
    private long o;
    private com.google.android.libraries.navigation.internal.og.h q;
    private com.google.android.libraries.navigation.internal.og.o r;
    private int s;
    private static final com.google.android.libraries.navigation.internal.zb.j f = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.dp.n");
    public static final long a = (long) ((-Math.log(0.01d)) * 500.0d);
    private final com.google.android.libraries.navigation.internal.oq.e k = com.google.android.libraries.navigation.internal.oq.f.g();
    private final com.google.android.libraries.navigation.internal.oq.e l = com.google.android.libraries.navigation.internal.oq.f.g();
    public final Object b = new Object();
    private final double p = (-a) / Math.log(0.01d);

    public n(com.google.android.libraries.navigation.internal.ni.a aVar, com.google.android.libraries.navigation.internal.ia.e eVar, l lVar, com.google.android.libraries.navigation.internal.oq.d dVar) {
        ar.q(aVar);
        this.g = aVar;
        ar.q(eVar);
        this.h = eVar;
        ar.q(lVar);
        this.i = lVar;
        this.j = dVar;
    }

    private final void f(boolean z, float f2) {
        if (this.f406n) {
            com.google.android.libraries.navigation.internal.pd.i iVar = this.c;
            if (iVar != null) {
                this.k.m(com.google.android.libraries.navigation.internal.pd.d.b(iVar.a(this.m.t(), f2)));
                return;
            }
            this.k.e(this.m.t());
            if (z) {
                this.k.h(f2);
            }
        }
    }

    private final void m() {
        com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x();
        boolean zF = this.i.f(xVar);
        synchronized (this.b) {
            this.f406n = zF;
            this.m = new com.google.android.libraries.navigation.internal.oe.x(xVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final int a(long j) {
        boolean z;
        int i = 0;
        if (this.i.j() == com.google.android.libraries.navigation.internal.ql.a.OFF) {
            return 0;
        }
        m();
        synchronized (this.b) {
            z = this.f406n;
        }
        if (!z) {
            this.i.d();
            return 0;
        }
        l lVar = this.i;
        int iG = lVar.g();
        boolean z2 = lVar.j() == com.google.android.libraries.navigation.internal.ql.a.COMPASS;
        l lVar2 = this.i;
        Object obj = this.b;
        float fA = lVar2.a();
        synchronized (obj) {
            int i2 = this.s;
            int i3 = i2 - 1;
            if (i2 == 0) {
                throw null;
            }
            if (i3 == 0) {
                ar.q(this.q);
                ar.q(this.r);
                int iA = this.q.a(j) | this.r.a(j);
                this.q.n(this.l);
                this.r.n(this.l);
                if (iA == 0) {
                    this.s = 3;
                    this.q = null;
                    this.r = null;
                    this.h.a(com.google.android.libraries.navigation.internal.ds.a.FINISH);
                }
            } else if (i3 == 1) {
                f(z2, fA);
                com.google.android.libraries.navigation.internal.oq.e eVar = this.l;
                com.google.android.libraries.navigation.internal.oq.e eVar2 = this.k;
                com.google.android.libraries.navigation.internal.oq.e eVarE = eVar.e(eVar2.d());
                eVarE.h(eVar2.a());
                eVarE.j(eVar2.b());
                eVarE.i(eVar2.g());
                eVarE.k(eVar2.c());
                this.s = 3;
            } else if (i3 != 2) {
                ((com.google.android.libraries.navigation.internal.zb.h) f.d(com.google.android.libraries.navigation.internal.nl.a.a).F(411)).p("unhandled animation mode");
            } else {
                f(z2, fA);
                double dExp = 1.0d - Math.exp((-(j - this.o)) / this.p);
                com.google.android.libraries.navigation.internal.oq.f fVarA = this.j.a();
                this.l.e(this.m.t());
                float f2 = (float) dExp;
                if (!z2 || iG == 1) {
                    float fA2 = fVarA.a();
                    float fA3 = this.k.a();
                    float fAbs = Math.abs(fA3 - fA2);
                    if (fAbs >= 360.0f - fAbs) {
                        fA3 = fA3 < fA2 ? fA3 + 360.0f : fA3 - 360.0f;
                    }
                    com.google.android.libraries.navigation.internal.oq.e eVar3 = this.l;
                    float fA4 = fVarA.a();
                    eVar3.h(fA4 + ((fA3 - fA4) * f2));
                } else {
                    this.l.h(this.k.a());
                }
                float fC = this.k.c();
                if (Math.abs(fC - fVarA.c()) < 0.001d) {
                    this.l.k(fC);
                } else {
                    com.google.android.libraries.navigation.internal.oq.e eVar4 = this.l;
                    float fC2 = fVarA.c();
                    eVar4.k(fC2 + ((fC - fC2) * f2));
                }
                com.google.android.libraries.navigation.internal.oq.e eVar5 = this.l;
                float fB = fVarA.b();
                eVar5.j(fB + ((this.k.b() - fB) * f2));
                com.google.android.libraries.navigation.internal.oq.e eVar6 = this.l;
                com.google.android.libraries.navigation.internal.oq.j jVarF = fVarA.f();
                com.google.android.libraries.navigation.internal.oq.j jVarG = this.k.g();
                float f3 = ((com.google.android.libraries.navigation.internal.oq.c) jVarF).a;
                float f4 = f3 + ((((com.google.android.libraries.navigation.internal.oq.c) jVarG).a - f3) * f2);
                float f5 = ((com.google.android.libraries.navigation.internal.oq.c) jVarF).b;
                eVar6.i(com.google.android.libraries.navigation.internal.oq.j.c(f4, f5 + ((((com.google.android.libraries.navigation.internal.oq.c) jVarG).b - f5) * f2)));
                com.google.android.libraries.navigation.internal.oq.e eVar7 = this.l;
                int i4 = this.e;
                if (((com.google.android.libraries.navigation.internal.pd.d.c & i4) == 0 || fVarA.d().equals(eVar7.d())) && (((com.google.android.libraries.navigation.internal.pd.d.d & i4) == 0 || Float.floatToIntBits(fVarA.c()) == Float.floatToIntBits(eVar7.c())) && (((com.google.android.libraries.navigation.internal.pd.d.e & i4) == 0 || Float.floatToIntBits(fVarA.b()) == Float.floatToIntBits(eVar7.b())) && (((com.google.android.libraries.navigation.internal.pd.d.f & i4) == 0 || Float.floatToIntBits(fVarA.a()) == Float.floatToIntBits(eVar7.a())) && ((i4 & com.google.android.libraries.navigation.internal.pd.d.g) == 0 || fVarA.f().equals(eVar7.g())))))) {
                    i = 2;
                }
            }
            i = 6;
        }
        this.o = j;
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final int b() {
        int i;
        com.google.android.libraries.navigation.internal.ql.a aVarJ = this.i.j();
        if (aVarJ == com.google.android.libraries.navigation.internal.ql.a.TRACKING) {
            i = com.google.android.libraries.navigation.internal.pd.d.c;
        } else {
            i = aVarJ == com.google.android.libraries.navigation.internal.ql.a.COMPASS ? com.google.android.libraries.navigation.internal.pd.d.c | com.google.android.libraries.navigation.internal.pd.d.f : 0;
        }
        synchronized (this.b) {
            if (this.c != null) {
                i = com.google.android.libraries.navigation.internal.pd.d.h;
            }
        }
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final long c() {
        return -1L;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final boolean d() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final boolean e() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final Object g(int i) {
        int i2 = i - 1;
        if ((this.e & (1 << i2)) == 0) {
            return null;
        }
        com.google.android.libraries.navigation.internal.oq.e eVar = this.l;
        if (i2 == 0) {
            return com.google.android.libraries.navigation.internal.oe.x.z(eVar.d());
        }
        if (i2 == 1) {
            return Float.valueOf(eVar.c());
        }
        if (i2 != 2) {
            return i2 != 3 ? new com.google.android.libraries.navigation.internal.pd.e(((com.google.android.libraries.navigation.internal.oq.c) eVar.g()).a, ((com.google.android.libraries.navigation.internal.oq.c) eVar.g()).b) : Float.valueOf(eVar.a());
        }
        return Float.valueOf(eVar.b());
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final Object h(int i) {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final void i(com.google.android.libraries.navigation.internal.pc.c cVar, int i) {
        this.e &= ~(1 << (i - 1));
        com.google.android.libraries.navigation.internal.ql.a aVarJ = this.i.j();
        if (cVar == null || cVar == this || aVarJ == com.google.android.libraries.navigation.internal.ql.a.OFF) {
            return;
        }
        if (i == 1) {
            synchronized (this.b) {
                if (this.s == 1) {
                    this.h.a(com.google.android.libraries.navigation.internal.ds.a.CANCEL);
                }
            }
            this.i.c(cVar.e());
            return;
        }
        if (i == 4 && aVarJ != com.google.android.libraries.navigation.internal.ql.a.TRACKING && cVar.e()) {
            this.i.e();
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
        this.e = i;
        this.o = this.g.a();
        com.google.android.libraries.navigation.internal.oq.d dVar = this.j;
        com.google.android.libraries.navigation.internal.oq.e eVar = this.k;
        com.google.android.libraries.navigation.internal.oq.f fVarA = dVar.a();
        eVar.m(fVarA);
        this.l.m(fVarA);
        m();
        com.google.android.libraries.navigation.internal.ql.a aVarJ = this.i.j();
        com.google.android.libraries.navigation.internal.ql.a aVar = com.google.android.libraries.navigation.internal.ql.a.COMPASS;
        float fA = this.i.a();
        synchronized (this.b) {
            if (this.d) {
                this.s = 2;
                this.q = null;
                this.r = null;
            } else {
                boolean z = true;
                this.s = 1;
                if (aVarJ != aVar) {
                    z = false;
                }
                f(z, fA);
                com.google.android.libraries.navigation.internal.oq.f fVarL = this.k.l();
                com.google.android.libraries.navigation.internal.og.h hVar = new com.google.android.libraries.navigation.internal.og.h(this.g, this.j);
                this.q = hVar;
                hVar.m(fVarA, fVarL);
                this.q.f(com.google.android.libraries.navigation.internal.k.b.a);
                com.google.android.libraries.navigation.internal.og.h hVar2 = this.q;
                hVar2.l(hVar2.f);
                com.google.android.libraries.navigation.internal.og.o oVar = new com.google.android.libraries.navigation.internal.og.o(this.g);
                this.r = oVar;
                oVar.m(fVarA, fVarL);
                this.r.f(com.google.android.libraries.navigation.internal.k.b.a);
                this.r.o(this.q.e);
                com.google.android.libraries.navigation.internal.og.o oVar2 = this.r;
                oVar2.l(oVar2.f);
            }
        }
    }
}
