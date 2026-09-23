package com.google.android.libraries.navigation.internal.dp;

import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class m implements com.google.android.libraries.navigation.internal.pc.c {
    private final com.google.android.libraries.navigation.internal.ni.a c;
    private final com.google.android.libraries.navigation.internal.pb.t d;
    private final com.google.android.libraries.navigation.internal.ia.e e;
    private final l f;
    private final com.google.android.libraries.navigation.internal.oq.d g;
    private final com.google.android.libraries.navigation.internal.pd.a h;
    private final com.google.android.libraries.navigation.internal.pd.a i;
    private final Object j;
    private com.google.android.libraries.navigation.internal.oe.x k;
    private boolean l;
    private long m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.google.android.libraries.navigation.internal.pd.i f405n;
    private final double o;
    private boolean p;
    private com.google.android.libraries.navigation.internal.pb.x q;
    private com.google.android.libraries.navigation.internal.pb.y r;
    private int s;
    private int t;
    private static final com.google.android.libraries.navigation.internal.zb.j b = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.dp.m");
    public static final long a = (long) ((-Math.log(0.01d)) * 500.0d);

    public m(com.google.android.libraries.navigation.internal.ni.a aVar, com.google.android.libraries.navigation.internal.pb.t tVar, com.google.android.libraries.navigation.internal.ia.e eVar, l lVar, Optional optional) {
        com.google.android.libraries.navigation.internal.pd.d dVar = com.google.android.libraries.navigation.internal.pd.d.a;
        this.h = new com.google.android.libraries.navigation.internal.pd.a();
        this.i = new com.google.android.libraries.navigation.internal.pd.a();
        this.j = new Object();
        this.o = (-a) / Math.log(0.01d);
        ar.q(aVar);
        this.c = aVar;
        ar.q(tVar);
        this.d = tVar;
        ar.q(eVar);
        this.e = eVar;
        ar.q(lVar);
        this.f = lVar;
        this.g = (com.google.android.libraries.navigation.internal.oq.d) optional.orElse(null);
    }

    private final com.google.android.libraries.navigation.internal.pd.d m() {
        com.google.android.libraries.navigation.internal.oq.d dVar = this.g;
        return dVar != null ? com.google.android.libraries.navigation.internal.pd.d.c(dVar.a()) : this.d.w();
    }

    private final void n(boolean z, float f) {
        if (this.l) {
            com.google.android.libraries.navigation.internal.pd.i iVar = this.f405n;
            if (iVar != null) {
                this.h.b(iVar.a(this.k.t(), f));
                return;
            }
            this.h.e(this.k);
            if (z) {
                this.h.e = f;
            }
        }
    }

    private final void o() {
        com.google.android.libraries.navigation.internal.oe.x xVar = new com.google.android.libraries.navigation.internal.oe.x();
        boolean zF = this.f.f(xVar);
        synchronized (this.j) {
            this.l = zF;
            this.k = new com.google.android.libraries.navigation.internal.oe.x(xVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final int a(long j) {
        boolean z;
        int i = 0;
        if (this.f.j() == com.google.android.libraries.navigation.internal.ql.a.OFF) {
            return 0;
        }
        o();
        synchronized (this.j) {
            z = this.l;
        }
        if (!z) {
            this.f.d();
            return 0;
        }
        l lVar = this.f;
        int iG = lVar.g();
        boolean z2 = lVar.j() == com.google.android.libraries.navigation.internal.ql.a.COMPASS;
        l lVar2 = this.f;
        Object obj = this.j;
        float fA = lVar2.a();
        synchronized (obj) {
            int i2 = this.t;
            int i3 = i2 - 1;
            if (i2 == 0) {
                throw null;
            }
            if (i3 == 0) {
                ar.q(this.q);
                ar.q(this.r);
                int iA = this.q.a(j) | this.r.a(j);
                this.q.o(this.i);
                this.r.o(this.i);
                if (iA == 0) {
                    this.t = 3;
                    this.q = null;
                    this.r = null;
                    this.e.a(com.google.android.libraries.navigation.internal.ds.a.FINISH);
                }
            } else if (i3 == 1) {
                n(z2, fA);
                com.google.android.libraries.navigation.internal.pd.a aVar = this.i;
                com.google.android.libraries.navigation.internal.pd.a aVar2 = this.h;
                aVar.a = aVar2.a;
                aVar.b = aVar2.b;
                aVar.c = aVar2.c;
                aVar.d = aVar2.d;
                aVar.e = aVar2.e;
                aVar.f = aVar2.f;
                this.t = 3;
            } else if (i3 != 2) {
                ((com.google.android.libraries.navigation.internal.zb.h) b.d(com.google.android.libraries.navigation.internal.nl.a.a).F(409)).p("unhandled animation mode");
            } else {
                n(z2, fA);
                double dExp = 1.0d - Math.exp((-(j - this.m)) / this.o);
                com.google.android.libraries.navigation.internal.pd.d dVarM = m();
                this.i.e(this.k);
                float f = (float) dExp;
                if (!z2 || iG == 1) {
                    float f2 = dVarM.m;
                    float f3 = this.h.e;
                    float fAbs = Math.abs(f3 - f2);
                    if (fAbs >= 360.0f - fAbs) {
                        f3 = f3 < f2 ? f3 + 360.0f : f3 - 360.0f;
                    }
                    this.i.e = f2 + ((f3 - f2) * f);
                } else {
                    this.i.e = this.h.e;
                }
                com.google.android.libraries.navigation.internal.pd.a aVar3 = this.h;
                float f4 = aVar3.c;
                float f5 = dVarM.k;
                float f6 = f4 - f5;
                if (Math.abs(f6) < 0.001d) {
                    this.i.c = f4;
                } else {
                    this.i.c = f5 + (f6 * f);
                }
                com.google.android.libraries.navigation.internal.pd.a aVar4 = this.i;
                float f7 = dVarM.l;
                aVar4.d = f7 + ((aVar3.d - f7) * f);
                aVar4.f = dVarM.f515n.d(aVar3.f, f);
                com.google.android.libraries.navigation.internal.pd.a aVar5 = this.i;
                int i4 = this.s;
                if (((com.google.android.libraries.navigation.internal.pd.d.c & i4) == 0 || dVarM.i.equals(aVar5.a)) && (((com.google.android.libraries.navigation.internal.pd.d.d & i4) == 0 || Float.floatToIntBits(dVarM.k) == Float.floatToIntBits(aVar5.c)) && (((com.google.android.libraries.navigation.internal.pd.d.e & i4) == 0 || Float.floatToIntBits(dVarM.l) == Float.floatToIntBits(aVar5.d)) && (((com.google.android.libraries.navigation.internal.pd.d.f & i4) == 0 || Float.floatToIntBits(dVarM.m) == Float.floatToIntBits(aVar5.e)) && ((i4 & com.google.android.libraries.navigation.internal.pd.d.g) == 0 || dVarM.f515n.equals(aVar5.f)))))) {
                    i = 2;
                }
            }
            i = 6;
        }
        this.m = j;
        return i;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final int b() {
        int i;
        com.google.android.libraries.navigation.internal.ql.a aVarJ = this.f.j();
        if (aVarJ == com.google.android.libraries.navigation.internal.ql.a.TRACKING) {
            i = com.google.android.libraries.navigation.internal.pd.d.c;
        } else {
            i = aVarJ == com.google.android.libraries.navigation.internal.ql.a.COMPASS ? com.google.android.libraries.navigation.internal.pd.d.c | com.google.android.libraries.navigation.internal.pd.d.f : 0;
        }
        synchronized (this.j) {
            if (this.f405n != null) {
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

    public final boolean f(com.google.android.libraries.navigation.internal.pd.i iVar, boolean z) {
        boolean z2;
        com.google.android.libraries.navigation.internal.pd.g gVar;
        synchronized (this.j) {
            com.google.android.libraries.navigation.internal.pd.i iVar2 = this.f405n;
            z2 = true;
            boolean z3 = (iVar2 == null || iVar == null || (gVar = iVar2.a) == null || gVar != iVar.a) ? false : true;
            this.f405n = iVar;
            boolean z4 = this.p;
            this.p = z;
            int iB = b();
            if (z4 == z && z3 && (this.s & iB) == iB) {
                z2 = false;
            }
        }
        return z2;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final Object g(int i) {
        float f;
        int i2 = i - 1;
        if ((this.s & (1 << i2)) == 0) {
            return null;
        }
        com.google.android.libraries.navigation.internal.pd.a aVar = this.i;
        if (i2 == 0) {
            return aVar.b;
        }
        if (i2 == 1) {
            f = aVar.c;
        } else if (i2 == 2) {
            f = aVar.d;
        } else {
            if (i2 != 3) {
                return aVar.f;
            }
            f = aVar.e;
        }
        return Float.valueOf(f);
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final Object h(int i) {
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.pc.c
    public final void i(com.google.android.libraries.navigation.internal.pc.c cVar, int i) {
        this.s &= ~(1 << (i - 1));
        com.google.android.libraries.navigation.internal.ql.a aVarJ = this.f.j();
        if (cVar == null || cVar == this || aVarJ == com.google.android.libraries.navigation.internal.ql.a.OFF) {
            return;
        }
        if (i == 1) {
            synchronized (this.j) {
                if (this.t == 1) {
                    this.e.a(com.google.android.libraries.navigation.internal.ds.a.CANCEL);
                }
            }
            this.f.c(cVar.e());
            return;
        }
        if (i == 4 && aVarJ != com.google.android.libraries.navigation.internal.ql.a.TRACKING && cVar.e()) {
            this.f.e();
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
        this.s = i;
        this.m = this.c.a();
        com.google.android.libraries.navigation.internal.pd.a aVar = this.h;
        com.google.android.libraries.navigation.internal.pd.d dVarM = m();
        aVar.b(dVarM);
        this.i.b(dVarM);
        o();
        com.google.android.libraries.navigation.internal.ql.a aVarJ = this.f.j();
        com.google.android.libraries.navigation.internal.ql.a aVar2 = com.google.android.libraries.navigation.internal.ql.a.COMPASS;
        float fA = this.f.a();
        synchronized (this.j) {
            if (this.p) {
                this.t = 2;
                this.q = null;
                this.r = null;
            } else {
                boolean z = true;
                this.t = 1;
                if (aVarJ != aVar2) {
                    z = false;
                }
                n(z, fA);
                com.google.android.libraries.navigation.internal.pd.d dVarA = this.h.a();
                com.google.android.libraries.navigation.internal.pb.q qVar = new com.google.android.libraries.navigation.internal.pb.q(this.c, this.d);
                this.q = qVar;
                qVar.m(dVarM, dVarA);
                this.q.f(com.google.android.libraries.navigation.internal.k.b.a);
                com.google.android.libraries.navigation.internal.pb.x xVar = this.q;
                xVar.l(xVar.f);
                com.google.android.libraries.navigation.internal.pb.y yVar = new com.google.android.libraries.navigation.internal.pb.y(this.c);
                this.r = yVar;
                yVar.m(dVarM, dVarA);
                this.r.f(com.google.android.libraries.navigation.internal.k.b.a);
                this.r.p(this.q.e);
                com.google.android.libraries.navigation.internal.pb.y yVar2 = this.r;
                yVar2.l(yVar2.f);
            }
        }
    }
}
