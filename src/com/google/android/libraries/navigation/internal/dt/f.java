package com.google.android.libraries.navigation.internal.dt;

import com.google.android.libraries.navigation.internal.oe.x;
import com.google.android.libraries.navigation.internal.oq.i;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    public x a;
    public float b;
    public boolean c;
    public float d;
    public boolean e;
    public int f;
    public x g;
    public float h;
    public boolean i;
    public float j;
    public long k;
    public long l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f413n;
    public float o;
    private e q;
    private e r;
    private e s;
    public float m = 1.0f;
    public boolean p = true;
    private final x t = new x();

    public f() {
        b();
    }

    public final x a() {
        x xVar = this.g;
        return xVar == null ? this.a : xVar;
    }

    public final void b() {
        this.a = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.b = 0.0f;
        this.c = false;
        this.e = false;
        this.d = 0.0f;
        this.f = -1;
        this.g = null;
        this.h = -1.0f;
        this.i = false;
        this.j = 0.0f;
        this.k = 0L;
        this.l = 0L;
        this.f413n = 1.0f;
        this.o = 1.0f;
        this.m = 1.0f;
        this.p = true;
    }

    public final void c(f fVar) {
        if (fVar == null) {
            b();
            return;
        }
        d(fVar.a, fVar.b, fVar.f, fVar.c);
        e eVar = fVar.q;
        if (eVar == null) {
            this.q = null;
        } else {
            e eVar2 = this.q;
            if (eVar2 == null) {
                this.q = new e(eVar);
            } else {
                eVar2.a(eVar);
            }
        }
        e eVar3 = fVar.r;
        if (eVar3 == null) {
            this.r = null;
        } else {
            e eVar4 = this.r;
            if (eVar4 == null) {
                this.r = new e(eVar3);
            } else {
                eVar4.a(eVar3);
            }
        }
        e eVar5 = fVar.s;
        if (eVar5 == null) {
            this.s = null;
        } else {
            e eVar6 = this.s;
            if (eVar6 == null) {
                this.s = new e(eVar5);
            } else {
                eVar6.a(eVar5);
            }
        }
        x xVar = fVar.g;
        this.g = xVar != null ? new x(xVar) : null;
        this.e = fVar.e;
        this.d = fVar.d;
        this.h = fVar.h;
        this.i = fVar.i;
        this.j = fVar.j;
        this.f413n = fVar.f413n;
        this.o = fVar.o;
        this.m = fVar.m;
        this.p = fVar.p;
        this.k = fVar.k;
        this.l = fVar.l;
    }

    public final void d(x xVar, float f, int i, boolean z) {
        this.a = xVar == null ? null : new x(xVar);
        this.b = f;
        this.f = i;
        this.c = z;
    }

    public final boolean e(com.google.android.libraries.navigation.internal.oq.d dVar) {
        e eVar;
        e eVar2;
        e eVar3;
        final i iVarH = dVar.c().h();
        Objects.requireNonNull(iVarH);
        Predicate predicate = new Predicate() { // from class: com.google.android.libraries.navigation.internal.dt.d
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return iVarH.a.g((x) obj);
            }
        };
        if (!f()) {
            return false;
        }
        x xVar = this.a;
        ar.q(xVar);
        if (!predicate.test(xVar)) {
            x xVarA = a();
            ar.q(xVarA);
            int iE = this.f * ((int) xVarA.e());
            this.t.J(xVarA.a + iE, xVarA.b + iE);
            if (!predicate.test(this.t)) {
                this.t.J(xVarA.a - iE, xVarA.b - iE);
                if (!predicate.test(this.t) && (((eVar = this.q) == null || !predicate.test(eVar.a)) && (((eVar2 = this.r) == null || !predicate.test(eVar2.a)) && ((eVar3 = this.s) == null || !predicate.test(eVar3.a))))) {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return am.a(this.a, fVar.a) && this.b == fVar.b && this.c == fVar.c && this.e == fVar.e && this.d == fVar.d && this.f == fVar.f && am.a(this.g, fVar.g) && this.h == fVar.h && this.i == fVar.i && this.j == fVar.j && this.f413n == fVar.f413n && this.o == fVar.o && this.m == fVar.m && this.p == fVar.p && this.k == fVar.k && this.l == fVar.l;
    }

    public final boolean f() {
        return this.a != null;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.b), Boolean.valueOf(this.c), Boolean.valueOf(this.e), Float.valueOf(this.d), Integer.valueOf(this.f), Float.valueOf(this.h), Boolean.valueOf(this.i), null, Float.valueOf(this.j), Float.valueOf(this.f413n), Float.valueOf(this.o), Float.valueOf(this.m), Boolean.valueOf(this.p)});
    }

    public final String toString() {
        x xVar = this.a;
        if (xVar == null) {
            return "Invalid point";
        }
        ak akVarB = al.b(this);
        akVarB.g("@", xVar.E());
        akVarB.c("Accuracy (meters)", this.f);
        x xVar2 = this.g;
        if (xVar2 != null) {
            akVarB.g("Accuracy point", xVar2.E());
        }
        akVarB.e("Use angle", this.c);
        if (this.c) {
            akVarB.b("Angle (degrees)", this.b);
        }
        akVarB.e("Use GPS angle", this.i);
        if (this.i) {
            akVarB.b("GPS angle (degrees)", this.h);
        }
        akVarB.e("Moving", this.e);
        akVarB.b("ThrobFactor", this.f413n);
        akVarB.d("Absolute time of last location update (ms)", this.k);
        akVarB.d("Relative time of last location update (ms)", this.l);
        akVarB.b("Staleness (0=not stale, 1=stale)", this.j);
        akVarB.b("Scaling factor", this.m);
        akVarB.e("Currently displayed", this.p);
        return akVarB.toString();
    }

    public f(f fVar) {
        c(fVar);
    }
}
