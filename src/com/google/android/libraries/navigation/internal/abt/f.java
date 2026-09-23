package com.google.android.libraries.navigation.internal.abt;

import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import com.google.android.libraries.navigation.internal.abf.aj;
import com.google.android.libraries.navigation.internal.abf.p;
import com.google.android.libraries.navigation.internal.abf.r;
import com.google.android.libraries.navigation.internal.abf.s;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    public static final Interpolator a = new AccelerateDecelerateInterpolator();
    public final c b;
    public final boolean c;
    public final a d;
    public final StreetViewPanoramaCamera e;
    private final String f;
    private final Interpolator g;
    private c h;
    private boolean i;
    private Double j;
    private Double k;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(c cVar) {
        this(cVar, null, null, null, false, null);
        s.k(cVar, "srcPanoTarget");
        synchronized (this) {
            this.h = c.a;
        }
    }

    private final synchronized double h() {
        if (this.d != null && !f()) {
            Double d = this.j;
            if (d == null) {
                return 0.0d;
            }
            Double d2 = this.k;
            if (d2.doubleValue() >= d.doubleValue() + 1.0d) {
                return 1.0d;
            }
            return com.google.android.libraries.navigation.internal.abw.k.h(this.g.getInterpolation((float) com.google.android.libraries.navigation.internal.abw.k.a(d2.doubleValue() - d.doubleValue())));
        }
        return 1.0d;
    }

    public final synchronized double a(double d) {
        if (this.j == null) {
            this.j = Double.valueOf(d);
        }
        this.k = Double.valueOf(d);
        return h();
    }

    public final synchronized c b() {
        return f() ? this.b : this.h;
    }

    public final synchronized void c() {
        this.i = true;
    }

    public final synchronized boolean d() {
        return this.f == null || this.i;
    }

    public final boolean e() {
        return h() >= 1.0d;
    }

    public final boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        synchronized (this) {
            synchronized (fVar) {
                if (!r.a(this.b, fVar.b) || !r.a(this.f, fVar.f) || !r.a(this.d, fVar.d) || !r.a(this.e, fVar.e) || !r.a(Boolean.valueOf(this.c), Boolean.valueOf(fVar.c)) || !r.a(Boolean.valueOf(this.i), Boolean.valueOf(fVar.i)) || !r.a(this.j, fVar.j) || !r.a(this.h, fVar.h)) {
                    z = false;
                }
            }
        }
        return z;
    }

    public final boolean f() {
        if (this.b.i()) {
            return this.f == null;
        }
        return r.a(this.b.b, this.f);
    }

    public final boolean g(c cVar) {
        s.k(cVar, "destPanoTarget");
        if (this.f == null || cVar.i()) {
            return this.f == null && cVar.i();
        }
        if (!r.a(this.f, cVar.b)) {
            return false;
        }
        synchronized (this) {
            this.h = cVar;
        }
        a aVar = this.d;
        if (aVar != null) {
            n nVarF = cVar.f();
            s.k(nVarF, "destWorldOrientation");
            float[] fArrB = a.b(aVar, nVarF, true);
            synchronized (aVar) {
                aVar.c = fArrB;
            }
        }
        return true;
    }

    public final synchronized int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.f, this.d, this.e, Boolean.valueOf(this.c), Boolean.valueOf(this.i), this.j});
    }

    public final synchronized String toString() {
        aj ajVarE;
        aj ajVarF = aj.f(this);
        ajVarF.g("srcPanoTarget", this.b.b);
        ajVarF.g("destPanoId", this.f);
        aj ajVarE2 = ajVarF.e("isUserGesture", this.c);
        ajVarE2.g("connectedPanoramaGeometry", this.d);
        ajVarE2.g("turnToLookAtCamera", this.e);
        c cVar = this.h;
        ajVarE2.g("destPanoTarget", cVar == null ? null : cVar.b);
        ajVarE = ajVarE2.e("isDestinationPanoReadyToRender", this.i);
        ajVarE.g("startTimeSec", this.j);
        ajVarE.g("currTimeSec", this.k);
        return ajVarE.a("getClampedTransitionRatio()", h()).toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(c cVar, String str, StreetViewPanoramaCamera streetViewPanoramaCamera, boolean z) {
        this(cVar, str, null, streetViewPanoramaCamera, z, null);
        s.k(cVar, "srcPanoTarget");
        s.k(str, "destPanoId");
    }

    public f(c cVar, String str, com.google.android.libraries.navigation.internal.abu.b bVar, StreetViewPanoramaCamera streetViewPanoramaCamera, boolean z, Interpolator interpolator) {
        StreetViewPanoramaOrientation streetViewPanoramaOrientation;
        this.b = cVar;
        this.f = str;
        if (bVar == null) {
            this.d = null;
        } else {
            s.a(!cVar.i(), "Cannot blend from the null target");
            a aVar = new a(bVar);
            this.d = aVar;
            com.google.android.libraries.navigation.internal.abu.a aVarG = cVar.g();
            n nVarF = cVar.f();
            s.k(aVarG, "srcDepthMap");
            s.k(nVarF, "srcWorldOrientation");
            float[] fArrB = a.b(aVar, nVarF, false);
            float f = fArrB[0];
            float f2 = fArrB[1];
            float f3 = fArrB[2];
            if (Float.isNaN(f) || Float.isNaN(f2) || Float.isNaN(f3) || (f == 0.0f && f2 == 0.0f && f3 == 0.0f)) {
                streetViewPanoramaOrientation = null;
            } else if (f == 0.0f && f3 == 0.0f) {
                streetViewPanoramaOrientation = new StreetViewPanoramaOrientation(f2 > 0.0f ? 90.0f : -90.0f, 0.0f);
            } else {
                double dE = com.google.android.libraries.navigation.internal.abw.k.e(Math.asin(((double) f2) / Math.sqrt(((f * f) + (f2 * f2)) + (f3 * f3))));
                double dE2 = com.google.android.libraries.navigation.internal.abw.k.e(Math.atan2(f, -f3));
                if (Double.isNaN(dE) || Double.isNaN(dE2)) {
                    p.f(i.a, 6);
                    streetViewPanoramaOrientation = null;
                } else {
                    streetViewPanoramaOrientation = new StreetViewPanoramaOrientation(com.google.android.libraries.navigation.internal.abw.k.j((float) dE), (float) dE2);
                }
            }
            double dA = 0.0d;
            double dAbs = Math.abs(streetViewPanoramaOrientation == null ? 0.0d : aVarG.a(nVarF, streetViewPanoramaOrientation.tilt, streetViewPanoramaOrientation.bearing, 200.0f)) * 0.9d;
            double dHypot = Math.hypot(aVar.f, aVar.g);
            if (p.f(a.a, 4)) {
                Arrays.toString(fArrB);
            }
            synchronized (aVar) {
                aVar.b = fArrB;
                if (dHypot != 0.0d) {
                    dA = com.google.android.libraries.navigation.internal.abw.k.a(dAbs / dHypot);
                }
                aVar.d = dA;
            }
        }
        this.e = streetViewPanoramaCamera;
        this.c = z;
        this.g = interpolator;
        synchronized (this) {
            this.h = null;
            this.i = false;
            this.j = null;
            this.k = null;
        }
    }
}
