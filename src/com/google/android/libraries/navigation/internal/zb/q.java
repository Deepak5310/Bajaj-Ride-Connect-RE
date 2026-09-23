package com.google.android.libraries.navigation.internal.zb;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class q implements z, com.google.android.libraries.navigation.internal.zd.f {
    private static final String a = new String();
    public final long b;
    public p c;
    public ah d;
    private final Level e;
    private t f;
    private com.google.android.libraries.navigation.internal.zd.ak g;
    private Object[] h;

    protected q(Level level) {
        long jB = com.google.android.libraries.navigation.internal.zd.ah.b();
        this.c = null;
        this.f = null;
        this.d = null;
        this.g = null;
        this.h = null;
        com.google.android.libraries.navigation.internal.zj.b.d(level, FirebaseAnalytics.Param.LEVEL);
        this.e = level;
        this.b = jB;
    }

    private final void G(String str, Object... objArr) {
        this.h = objArr;
        for (int i = 0; i < objArr.length; i++) {
            Object obj = objArr[i];
            if (obj instanceof l) {
                objArr[i] = ((l) obj).a();
            }
        }
        if (str != a) {
            this.g = new com.google.android.libraries.navigation.internal.zd.ak(a(), str);
        }
        com.google.android.libraries.navigation.internal.zg.l lVarK = com.google.android.libraries.navigation.internal.zd.ah.k();
        if (!lVarK.a()) {
            com.google.android.libraries.navigation.internal.zg.l lVar = (com.google.android.libraries.navigation.internal.zg.l) i().d(o.h);
            if (lVar != null && !lVar.a()) {
                lVarK = lVarK.a() ? lVar : new com.google.android.libraries.navigation.internal.zg.l(new com.google.android.libraries.navigation.internal.zg.j(lVarK.c, lVar.c));
            }
            n(o.h, lVarK);
        }
        a aVarC = c();
        try {
            com.google.android.libraries.navigation.internal.zj.d dVarA = com.google.android.libraries.navigation.internal.zj.d.a();
            int i2 = dVarA.a + 1;
            dVarA.a = i2;
            if (i2 == 0) {
                throw new AssertionError("Overflow of RecursionDepth (possible error in core library)");
            }
            try {
                if (i2 <= 100) {
                    aVarC.a.c(this);
                } else {
                    a.b("unbounded recursion in log statement", this);
                }
                if (dVarA != null) {
                    dVarA.close();
                }
            } catch (Throwable th) {
                if (dVarA != null) {
                    try {
                        dVarA.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (RuntimeException e) {
            try {
                aVarC.a.b(e, this);
            } catch (com.google.android.libraries.navigation.internal.zd.k e2) {
                throw e2;
            } catch (RuntimeException e3) {
                a.b(e3.getClass().getName() + ": " + e3.getMessage(), this);
                try {
                    e3.printStackTrace(System.err);
                } catch (RuntimeException unused) {
                }
            }
        }
    }

    private final boolean H() {
        u uVarB;
        p pVar;
        if (this.f == null) {
            this.f = com.google.android.libraries.navigation.internal.zd.ah.g().a(q.class, 1);
        }
        if (this.f != t.a) {
            uVarB = this.f;
            p pVar2 = this.c;
            if (pVar2 != null && pVar2.b > 0) {
                com.google.android.libraries.navigation.internal.zj.b.d(uVarB, "logSiteKey");
                int i = pVar2.b;
                for (int i2 = 0; i2 < i; i2++) {
                    if (o.f.equals(pVar2.c(i2))) {
                        Object objE = pVar2.e(i2);
                        uVarB = objE instanceof aa ? ((aa) objE).b() : new al(uVarB, objE);
                    }
                }
            }
        } else {
            uVarB = null;
        }
        boolean zB = b(uVarB);
        ah ahVar = this.d;
        if (ahVar == null) {
            return zB;
        }
        ag agVar = (ag) ag.a.b(uVarB, this.c);
        int iIncrementAndGet = agVar.c.incrementAndGet();
        int i3 = -1;
        if (ahVar != ah.c && agVar.b.compareAndSet(false, true)) {
            try {
                ahVar.a();
                agVar.b.set(false);
                agVar.c.addAndGet(-iIncrementAndGet);
                i3 = (-1) + iIncrementAndGet;
            } catch (Throwable th) {
                agVar.b.set(false);
                throw th;
            }
        }
        if (zB && i3 > 0 && (pVar = this.c) != null) {
            pVar.f(o.e, Integer.valueOf(i3));
        }
        return zB & (i3 >= 0);
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final void A(String str, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        if (H()) {
            G("PolylineStitcher given polylines with different scales (%s, %s)  or xOffset (%s, %s) or yOffset(%s, %s)", obj, obj2, obj3, obj4, obj5, obj6);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final void B(String str, Object[] objArr) {
        if (H()) {
            G(str, Arrays.copyOf(objArr, objArr.length));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zd.f
    public final boolean C() {
        return this.c != null && Boolean.TRUE.equals(this.c.d(o.g));
    }

    @Override // com.google.android.libraries.navigation.internal.zd.f
    public final Object[] D() {
        com.google.android.libraries.navigation.internal.zj.b.b(this.g != null, "cannot get arguments unless a template context exists");
        Object[] objArr = this.h;
        if (objArr != null) {
            return objArr;
        }
        throw new IllegalStateException("cannot get arguments before calling log()");
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final z E(TimeUnit timeUnit) {
        throw null;
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final z F(int i) {
        t tVar = t.a;
        s sVar = new s(i);
        if (this.f == null) {
            this.f = sVar;
        }
        return d();
    }

    protected abstract com.google.android.libraries.navigation.internal.zi.d a();

    protected boolean b(u uVar) {
        throw null;
    }

    protected abstract a c();

    protected abstract z d();

    @Override // com.google.android.libraries.navigation.internal.zd.f
    public final long e() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.f
    public final t f() {
        t tVar = this.f;
        if (tVar != null) {
            return tVar;
        }
        throw new IllegalStateException("cannot request log site information prior to postProcess()");
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final z g(Throwable th) {
        ac acVar = o.a;
        com.google.android.libraries.navigation.internal.zj.b.d(acVar, "metadata key");
        if (th != null) {
            n(acVar, th);
        }
        return d();
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final z h(an anVar) {
        com.google.android.libraries.navigation.internal.zj.b.d(anVar, "stack size");
        if (anVar != an.NONE) {
            n(o.i, anVar);
        }
        return d();
    }

    @Override // com.google.android.libraries.navigation.internal.zd.f
    public final com.google.android.libraries.navigation.internal.zd.n i() {
        p pVar = this.c;
        return pVar != null ? pVar : com.google.android.libraries.navigation.internal.zd.m.a;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.f
    public final com.google.android.libraries.navigation.internal.zd.ak j() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.zd.f
    public final Object k() {
        com.google.android.libraries.navigation.internal.zj.b.b(this.g == null, "cannot get literal argument if a template context exists");
        Object[] objArr = this.h;
        if (objArr != null) {
            return objArr[0];
        }
        throw new IllegalStateException("cannot get literal argument before calling log()");
    }

    @Override // com.google.android.libraries.navigation.internal.zd.f
    public final String l() {
        return c().a.a();
    }

    @Override // com.google.android.libraries.navigation.internal.zd.f
    public final Level m() {
        return this.e;
    }

    protected final void n(ac acVar, Object obj) {
        if (this.c == null) {
            this.c = new p();
        }
        this.c.f(acVar, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final void o() {
        if (H()) {
            G(a, "");
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final void p(String str) {
        if (H()) {
            G(a, str);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final void q(String str, int i) {
        if (H()) {
            G(str, Integer.valueOf(i));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final void r(String str, long j) {
        if (H()) {
            G(str, Long.valueOf(j));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final void s(String str, Object obj) {
        if (H()) {
            G(str, obj);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final void t(String str, int i, int i2) {
        if (H()) {
            G(str, Integer.valueOf(i), Integer.valueOf(i2));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final void u(String str, int i, Object obj) {
        if (H()) {
            G("Legend urls not found (getTableUrl) for epoch = %s, legend = %s", Integer.valueOf(i), obj);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final void v(String str, long j, Object obj) {
        if (H()) {
            G(str, Long.valueOf(j), obj);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final void w(String str, Object obj, int i) {
        if (H()) {
            G(str, obj, Integer.valueOf(i));
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final void x(String str, Object obj, Object obj2) {
        if (H()) {
            G(str, obj, obj2);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final void y(String str, Object obj, Object obj2, Object obj3) {
        if (H()) {
            G(str, obj, obj2, obj3);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.zb.z
    public final void z(String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (H()) {
            G("updateTileMetadata failed: coords= %d,%d,%d , paintRequestTemplateTileType= %s :", obj, obj2, obj3, obj4);
        }
    }
}
