package com.google.android.libraries.navigation.internal.dr;

import android.content.res.Resources;
import com.google.android.libraries.navigation.internal.ace.bk;
import com.google.android.libraries.navigation.internal.oe.ay;
import com.google.android.libraries.navigation.internal.pi.af;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.bp;
import com.google.android.libraries.navigation.internal.yz.mp;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad implements i {
    public float a = 1.0f;
    public volatile boolean b;
    public volatile boolean c;
    public volatile String d;
    public volatile boolean e;
    public String f;
    private final o g;
    private final com.google.android.libraries.navigation.internal.aw.c h;
    private volatile boolean i;
    private final Set j;
    private final m k;
    private final m l;
    private final m m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final k f409n;
    private final m o;
    private final m p;
    private final m q;
    private final h r;
    private final h s;
    private final ac t;
    private volatile long u;
    private volatile boolean v;
    private final float w;
    private final float x;
    private volatile boolean y;

    public ad(Resources resources, o oVar, boolean z, String str, boolean z2, com.google.android.libraries.navigation.internal.aw.c cVar, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.navigation.internal.ia.e eVar, bk bkVar, Executor executor) {
        ac acVar = new ac();
        this.t = acVar;
        this.b = false;
        this.u = 0L;
        this.v = false;
        this.c = false;
        this.y = true;
        this.g = oVar;
        this.e = z;
        this.d = str;
        this.b = z2;
        m mVarC = oVar.c(n.CHEVRON);
        this.k = mVarC;
        m mVarC2 = oVar.c(n.BEARINGLESS_CHEVRON);
        this.l = mVarC2;
        m mVarC3 = oVar.c(n.CHEVRON_DISC);
        this.m = mVarC3;
        this.w = g(mVarC, mVarC3, resources);
        if (!bkVar.m || eVar == null || sVar == null) {
            this.f409n = null;
        } else {
            k kVarH = oVar.b.h("Custom chevron picker", 5);
            this.f409n = kVarH;
            kVarH.d(af.INSTANCE, sVar, eVar);
        }
        if (eVar != null && sVar != null) {
            mVarC.d(af.INSTANCE, sVar, eVar);
            mVarC2.d(af.INSTANCE, sVar, eVar);
            mVarC3.d(af.INSTANCE, sVar, eVar);
        }
        this.h = cVar;
        h hVarA = oVar.a();
        this.r = hVarA;
        hVarA.d(acVar);
        m mVarC4 = oVar.c(n.DIM_CHEVRON);
        this.o = mVarC4;
        m mVarC5 = oVar.c(n.DIM_BEARINGLESS_CHEVRON);
        this.p = mVarC5;
        m mVarC6 = oVar.c(n.DIM_CHEVRON_DISC);
        this.q = mVarC6;
        h hVarB = oVar.b();
        this.s = hVarB;
        hVarB.d(acVar);
        this.x = g(mVarC4, mVarC6, resources);
        HashSet hashSetF = mp.f(mVarC, mVarC2, null, null, null, mVarC3, null, this.f409n, hVarA, hVarB, mVarC4, mVarC5, mVarC6);
        hashSetF.removeAll(Collections.singleton(null));
        this.j = hashSetF;
    }

    private static float g(k kVar, k kVar2, Resources resources) {
        float f = kVar2.d;
        return resources.getDisplayMetrics() != null ? (resources.getDisplayMetrics().density * 92.0f) / f : 92.0f / f;
    }

    private static void h(d dVar, boolean z) {
        dVar.b(z);
    }

    private static void i(k kVar, com.google.android.libraries.navigation.internal.oe.x xVar, float f, boolean z, float f2) {
        kVar.c(xVar, Float.valueOf(f2), z ? Float.valueOf(-f) : null, null);
    }

    private final void j(h hVar, com.google.android.libraries.navigation.internal.oe.x xVar, float f, com.google.android.libraries.navigation.internal.oq.d dVar) {
        float fH;
        float fB = dVar.a().b();
        com.google.android.libraries.navigation.internal.rf.g gVarC = dVar.c();
        boolean z = true;
        if (((com.google.android.libraries.navigation.internal.oq.b) gVarC.g()).c == 0.0f) {
            fH = 1.0f;
        } else {
            fH = gVarC.a.h() / gVarC.a.m(xVar, true);
        }
        float fCos = f * fH * ((float) Math.cos(Math.toRadians(fB)));
        hVar.b(this.y);
        ay ayVarF = dVar.c().f(xVar);
        if (ayVarF == null) {
            ayVarF = new ay(Float.NaN, Float.NaN);
        }
        com.google.android.libraries.navigation.internal.oe.q qVarE = gVarC.e(ayVarF.b, ayVarF.c + fCos);
        if (qVarE == null) {
            qVarE = new com.google.android.libraries.navigation.internal.oe.q(0, 0, 0);
        }
        this.t.a.W(new com.google.android.libraries.navigation.internal.oe.x(qVarE.a, qVarE.b, 0));
        ac acVar = this.t;
        boolean z2 = hVar.d;
        com.google.android.libraries.navigation.internal.oe.x xVar2 = acVar.a;
        if (z2) {
            z = false;
        } else {
            hVar.b = xVar2;
            hVar.d = true;
        }
        com.google.android.libraries.navigation.internal.op.f fVar = hVar.a;
        boolean z3 = fVar instanceof com.google.android.libraries.navigation.internal.oj.d;
        if (fVar == null || !hVar.c) {
            return;
        }
        if (z || !z3) {
            fVar.f(xVar2.t(), com.google.android.libraries.navigation.internal.adg.b.BOTTOM);
        }
    }

    private final void k(com.google.android.libraries.navigation.internal.oe.x xVar, float f, com.google.android.libraries.navigation.internal.oq.d dVar) {
        String str = this.d;
        boolean z = this.e;
        boolean z2 = !z && this.b;
        h hVar = this.s;
        boolean z3 = (z || z2 || str == null || str.equalsIgnoreCase("unknown road")) ? false : true;
        if (z2) {
            ar.q(hVar);
            h(this.r, false);
            j(hVar, xVar, f, dVar);
            this.f = null;
            return;
        }
        if (!z3) {
            h(this.r, false);
            h(hVar, false);
            this.f = null;
            return;
        }
        ar.q(str);
        h(hVar, false);
        if (str.equals(this.f)) {
            j(this.r, xVar, f, dVar);
            return;
        }
        String strConcat = str.length() <= 26 ? str : String.valueOf(bp.b(str, 23)).concat("...");
        try {
            o oVar = this.g;
            ar.q(strConcat);
            oVar.f(strConcat, this.r);
            this.f = str;
            j(this.r, xVar, f, dVar);
        } catch (NullPointerException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 424)).p("Failed to load background image drawable for current road name callout.");
            h(this.r, false);
            this.f = null;
        } catch (OutOfMemoryError unused2) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 423)).p("Could not allocate memory for current road name callout.");
            h(this.r, false);
            this.f = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.dr.i
    public final void a() {
        Iterator it2 = this.j.iterator();
        while (it2.hasNext()) {
            ((d) it2.next()).b(false);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.dr.i
    public final void b(boolean z) {
        this.y = z;
    }

    public final void d() {
        Iterator it2 = this.j.iterator();
        while (it2.hasNext()) {
            ((d) it2.next()).a();
        }
    }

    public final void e() {
        this.v = true;
    }

    public final void f(p pVar) {
        o oVar = this.g;
        oVar.a = pVar;
        oVar.e(this.k);
        this.g.e(this.l);
        this.g.e(this.m);
        this.g.e(this.o);
        this.g.e(this.q);
        this.g.d(this.s);
        this.f = null;
    }

    @Override // com.google.android.libraries.navigation.internal.dr.i
    public final void c(com.google.android.libraries.navigation.internal.dt.f fVar, com.google.android.libraries.navigation.internal.oq.d dVar) {
        if (!fVar.f()) {
            Iterator it2 = this.j.iterator();
            while (it2.hasNext()) {
                ((d) it2.next()).b(false);
            }
            return;
        }
        com.google.android.libraries.navigation.internal.oe.x xVar = fVar.a;
        ar.q(xVar);
        float f = this.w;
        float f2 = this.k.d;
        float f3 = fVar.m * this.a;
        k kVar = this.f409n;
        if (kVar != null) {
            kVar.b(false);
        }
        float fB = f * ae.b(f2, f3);
        m mVar = this.o;
        float f4 = this.x;
        float f5 = mVar.d;
        float f6 = fVar.m * this.a;
        boolean z = fVar.c;
        float fB2 = f4 * ae.b(f5, f6);
        if (z) {
            if (this.b) {
                i(this.o, xVar, fVar.b, fVar.c, fB2);
                h(this.k, false);
                h(this.l, false);
                h(this.o, this.y);
                h(this.p, false);
            } else {
                i(this.k, xVar, fVar.b, fVar.c, fB);
                h(this.k, this.y);
                h(this.l, false);
                h(this.o, false);
                h(this.p, false);
            }
        } else if (this.b) {
            i(this.p, xVar, 0.0f, false, fB2);
            h(this.k, false);
            h(this.l, false);
            h(this.o, false);
            h(this.p, this.y);
        } else {
            i(this.l, xVar, 0.0f, false, fB);
            h(this.k, false);
            h(this.l, this.y);
            h(this.o, false);
            h(this.p, false);
        }
        if (this.b) {
            h(this.m, false);
            h(this.q, this.y);
        } else {
            h(this.m, this.y);
            h(this.q, false);
        }
        float f7 = -dVar.a().a();
        m mVar2 = this.m;
        Float fValueOf = Float.valueOf(f7);
        mVar2.c(xVar, Float.valueOf(fVar.f413n * fB), fValueOf, null);
        this.q.c(xVar, Float.valueOf(fVar.f413n * fB), fValueOf, null);
        k(xVar, fB, dVar);
    }
}
