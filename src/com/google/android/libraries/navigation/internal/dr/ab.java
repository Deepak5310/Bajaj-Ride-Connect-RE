package com.google.android.libraries.navigation.internal.dr;

import android.content.res.Resources;
import com.google.android.libraries.geo.mapcore.renderer.ck;
import com.google.android.libraries.navigation.internal.afl.Cdo;
import com.google.android.libraries.navigation.internal.afl.ds;
import com.google.android.libraries.navigation.internal.pi.af;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.mp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab implements i {
    private static final com.google.android.libraries.navigation.internal.oe.x i = new com.google.android.libraries.navigation.internal.oe.x();
    public final l a;
    public final f b;
    public final Set c;
    public com.google.android.libraries.navigation.internal.dt.b d;
    public final k e;
    public final k f;
    public final k g;
    public boolean h;
    private final com.google.android.libraries.navigation.internal.pi.s j;
    private final com.google.android.libraries.navigation.internal.ia.e k;
    private final Executor l;
    private final com.google.android.libraries.navigation.internal.fr.e m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final Resources f408n;
    private final ds o;
    private final k p;
    private boolean q;
    private final aa r;
    private final aa s;
    private final k t;
    private final g u;
    private float v;
    private boolean w = true;
    private volatile boolean x = true;

    public ab(ds dsVar, com.google.android.libraries.navigation.internal.pi.s sVar, com.google.android.libraries.navigation.internal.ia.e eVar, Resources resources, l lVar, boolean z, int i2, com.google.android.libraries.navigation.internal.fr.e eVar2, com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.dt.b bVar, boolean z2, Executor executor) {
        this.q = false;
        this.j = sVar;
        this.k = eVar;
        this.a = lVar;
        this.m = eVar2;
        this.f408n = resources;
        this.d = bVar;
        this.o = dsVar;
        this.l = executor;
        this.h = e(bVar.t);
        f fVar2 = new f(eVar, lVar, fVar, new e(lVar, z, i2, bVar.y));
        this.b = fVar2;
        HashSet hashSetG = mp.g(13);
        this.c = hashSetG;
        aa aaVarI = lVar.a.i(bVar.A, false, ck.CLIENT_INJECTED_AREAS_ABOVE_LABELS_AND_CALLOUTS, 7);
        this.r = aaVarI;
        aa aaVarI2 = lVar.a.i(bVar.B, true, ck.CLIENT_INJECTED_AREAS_ABOVE_LABELS_AND_CALLOUTS, 8);
        this.s = aaVarI2;
        k kVarH = lVar.a.h("MyLocation dot picker", 17);
        this.p = kVarH;
        k kVarG = lVar.a.g(bVar.z, "Throbbing effect under the blue dot", 10);
        this.f = kVarG;
        k kVarG2 = lVar.a.g(bVar.u, bVar.v, 11);
        this.e = kVarG2;
        k kVarG3 = lVar.a.g(bVar.w, bVar.x, 14);
        this.g = kVarG3;
        this.v = resources.getDimensionPixelSize(com.google.android.libraries.navigation.internal.du.b.a) / kVarG2.d;
        this.q = false;
        hashSetG.add(aaVarI2);
        hashSetG.add(aaVarI);
        hashSetG.add(kVarG);
        hashSetG.add(kVarG2);
        hashSetG.add(fVar2.d);
        k kVar = fVar2.f;
        if (kVar != null) {
            hashSetG.add(kVar);
        }
        hashSetG.add(kVarG3);
        hashSetG.add(kVarH);
        if (j()) {
            k kVarG4 = z2 ? lVar.a.g(com.google.android.libraries.navigation.internal.du.c.A, "Pulsating Dot", 12) : lVar.a.g(com.google.android.libraries.navigation.internal.du.c.z, "Pulsating Dot", 12);
            this.t = kVarG4;
            hashSetG.add(kVarG4);
        } else {
            this.t = null;
        }
        this.u = null;
    }

    public static boolean e(com.google.android.libraries.navigation.internal.dt.c cVar) {
        return cVar == com.google.android.libraries.navigation.internal.dt.c.LITE_NAV;
    }

    private static void f(d dVar) {
        if (dVar != null) {
            dVar.b(false);
        }
    }

    private final void g(boolean z, com.google.android.libraries.navigation.internal.oe.x xVar) {
        Float fValueOf;
        if (this.q) {
            fValueOf = null;
        } else {
            this.q = true;
            float f = this.v * this.e.d;
            k kVar = this.p;
            com.google.android.libraries.navigation.internal.pi.s sVar = this.j;
            com.google.android.libraries.navigation.internal.ia.e eVar = this.k;
            fValueOf = Float.valueOf(f / 4.0f);
            kVar.d(af.INSTANCE, sVar, eVar);
        }
        this.p.b(z);
        this.p.c(xVar, fValueOf, null, null);
    }

    private final void h(com.google.android.libraries.navigation.internal.oe.x xVar, float f, com.google.android.libraries.navigation.internal.oe.x xVar2, float f2, float f3, float f4, com.google.android.libraries.navigation.internal.oe.x xVar3, float f5, float f6, float f7) {
        boolean z;
        boolean z2;
        Float fValueOf = Float.valueOf(-f6);
        com.google.android.libraries.navigation.internal.oe.x xVar4 = i;
        if (xVar == xVar4) {
            f(this.g);
            this.w = false;
            z = false;
            z2 = false;
        } else {
            this.g.b(i());
            this.g.c(xVar, Float.valueOf(f), fValueOf, null);
            g(this.x, xVar);
            z = this.x;
            z2 = true;
            this.w = true;
        }
        this.m.b(z2);
        if (xVar2 == xVar4) {
            f(this.e);
            f(this.f);
            f(this.t);
            f(null);
        } else {
            this.e.b(i());
            this.e.c(xVar2, Float.valueOf(f2), fValueOf, null);
            g(this.x, xVar2);
            z |= this.x;
            if (f4 == 0.0f) {
                f(this.f);
            } else {
                this.f.b(i());
                this.f.c(xVar2, Float.valueOf(f3), null, Float.valueOf(f4));
            }
            if (j()) {
                ar.q(this.t);
                if (com.google.android.libraries.navigation.internal.dt.b.c.v.equals(this.e.e)) {
                    this.t.b(i());
                    this.t.c(xVar2, Float.valueOf(f2 * f7 * 0.5f), null, null);
                } else {
                    f(this.t);
                }
            }
        }
        if (!z) {
            f(this.p);
        }
        if (xVar3 == xVar4) {
            this.r.b(false);
            this.s.b(false);
        } else {
            this.r.b(this.x);
            this.r.c(xVar3, f5);
            this.s.b(this.x);
            this.s.c(xVar3, f5);
        }
    }

    private final boolean i() {
        return this.x;
    }

    private final boolean j() {
        Cdo cdo = this.o.f;
        if (cdo == null) {
            cdo = Cdo.a;
        }
        return cdo.b;
    }

    @Override // com.google.android.libraries.navigation.internal.dr.i
    public final void a() {
        Iterator it2 = this.c.iterator();
        while (it2.hasNext()) {
            ((d) it2.next()).b(false);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.dr.i
    public final void b(boolean z) {
        this.x = z;
        this.b.g = z;
    }

    @Override // com.google.android.libraries.navigation.internal.dr.i
    public final void c(com.google.android.libraries.navigation.internal.dt.f fVar, com.google.android.libraries.navigation.internal.oq.d dVar) {
        boolean z;
        float fA = dVar.a().a();
        if (!fVar.f()) {
            com.google.android.libraries.navigation.internal.oe.x xVar = i;
            h(xVar, 0.0f, xVar, 0.0f, 0.0f, 0.0f, xVar, 0.0f, fA, 0.0f);
            this.b.a();
            return;
        }
        float f = 1.0f - fVar.j;
        float fB = this.v * ae.b(this.e.d, fVar.m);
        double d = fVar.f;
        com.google.android.libraries.navigation.internal.oe.x xVarA = fVar.a();
        ar.q(xVarA);
        double dE = d * xVarA.e();
        if (this.h) {
            if (f < 0.1f) {
                com.google.android.libraries.navigation.internal.oe.x xVar2 = fVar.a;
                com.google.android.libraries.navigation.internal.oe.x xVar3 = i;
                h(xVar2, fB, xVar3, 0.0f, 0.0f, 0.0f, xVar3, 0.0f, fVar.b, 0.0f);
            } else {
                float f2 = fVar.o;
                com.google.android.libraries.navigation.internal.oe.x xVar4 = i;
                h(xVar4, 0.0f, fVar.a, fB, fB * f2, fVar.f413n, xVar4, 0.0f, fVar.b, f2);
            }
            this.b.a();
            return;
        }
        if (f < 0.1f) {
            com.google.android.libraries.navigation.internal.oe.x xVar5 = fVar.a;
            com.google.android.libraries.navigation.internal.oe.x xVar6 = i;
            h(xVar5, fB, xVar6, 0.0f, 0.0f, 0.0f, xVar6, 0.0f, fA, 0.0f);
            this.b.a();
            return;
        }
        float f3 = (float) dE;
        com.google.android.libraries.navigation.internal.oe.x xVar7 = i;
        com.google.android.libraries.navigation.internal.oe.x xVar8 = fVar.a;
        float f4 = fVar.f413n;
        com.google.android.libraries.navigation.internal.oe.x xVarA2 = fVar.a();
        ar.q(xVarA2);
        h(xVar7, 0.0f, xVar8, fB, fB, f4, xVarA2, f3, fA, fVar.o);
        float f5 = fB / this.e.d;
        f fVar2 = this.b;
        if (fVar.c) {
            int iA = fVar2.c.a();
            if (fVar2.e != iA) {
                fVar2.e = iA;
                fVar2.b.a.e(fVar2.d, iA);
                z = true;
            } else {
                z = false;
            }
            k kVar = fVar2.d;
            if (kVar.e.equals("Direction cone around the blue dot")) {
                if (z) {
                }
                k kVar2 = fVar2.d;
                fVar2.b(kVar2, fVar.a, kVar2.d * f5, -fVar.b);
            } else {
                kVar.e = "Direction cone around the blue dot";
            }
            fVar2.a.a(new com.google.android.libraries.navigation.internal.cy.b());
            k kVar3 = fVar2.d;
            fVar2.b(kVar3, fVar.a, kVar3.d * f5, -fVar.b);
        } else {
            fVar2.d.b(false);
        }
        k kVar4 = fVar2.f;
        if (kVar4 != null) {
            if (fVar.i) {
                fVar2.b(kVar4, fVar.a, f5 * kVar4.d, -fVar.h);
            } else {
                kVar4.b(false);
            }
        }
    }

    public final synchronized com.google.android.libraries.navigation.internal.dt.c d() {
        return this.d.t;
    }
}
