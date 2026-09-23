package com.google.android.libraries.navigation.internal.abm;

import android.graphics.Bitmap;
import com.facebook.react.uimanager.ViewProps;
import com.google.android.gms.maps.model.LatLng;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h {
    com.google.android.libraries.navigation.internal.abh.as a;
    LatLng b;
    Float c;
    Float d;
    Boolean e;
    Float f;
    Boolean g;
    private final int h;
    private final int i;
    private com.google.android.libraries.navigation.internal.ol.aq j;
    private boolean k;
    private boolean l;
    private final com.google.android.libraries.navigation.internal.ol.as m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final com.google.android.libraries.navigation.internal.ol.z f137n;
    private final com.google.android.libraries.navigation.internal.on.h o;
    private com.google.android.libraries.navigation.internal.ol.j p;

    public h(int i, int i2, com.google.android.libraries.navigation.internal.ol.as asVar, com.google.android.libraries.navigation.internal.ol.z zVar, com.google.android.libraries.navigation.internal.on.h hVar) {
        this.h = i;
        this.i = i2;
        this.m = asVar;
        com.google.android.libraries.navigation.internal.abf.s.k(zVar, "phoenixGoogleMap");
        this.f137n = zVar;
        com.google.android.libraries.navigation.internal.abf.s.k(hVar, "clientRenderOpFactory");
        this.o = hVar;
        this.l = true;
        this.k = true;
        this.p = null;
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
    }

    private final com.google.android.libraries.navigation.internal.ol.aq j() {
        if (this.k) {
            if (this.j != null) {
                this.f137n.e().j(this.j);
            }
            this.j = this.f137n.e().l(this.a.b, f.a.b(this.f.floatValue()));
            this.k = false;
        }
        return this.j;
    }

    private final void k() {
        if (this.p == null) {
            this.l = true;
        } else if (this.g.booleanValue()) {
            this.p.k(this.m);
        } else {
            this.p.aq();
        }
    }

    private final void l() {
        com.google.android.libraries.navigation.internal.ol.j jVar = this.p;
        if (jVar == null) {
            this.l = true;
            return;
        }
        com.google.android.libraries.navigation.internal.ol.i iVarC = jVar.c();
        float fFloatValue = this.c.floatValue();
        com.google.android.libraries.navigation.internal.oe.r rVarE = f.e(this.b);
        iVarC.d = fFloatValue;
        iVarC.e.W(com.google.android.libraries.navigation.internal.oe.x.z(rVarE));
        LatLng latLng = this.b;
        iVarC.b(com.google.android.libraries.navigation.internal.oe.x.A(latLng.latitude, latLng.longitude));
        float fFloatValue2 = this.d.floatValue() / this.a.c().floatValue();
        Bitmap bitmap = this.a.b;
        iVarC.b.q(bitmap.getWidth() * fFloatValue2, bitmap.getHeight() * fFloatValue2);
        iVarC.c = com.google.android.libraries.navigation.internal.ol.h.PIXEL;
        this.p.d(iVarC);
        this.p.a(true != this.e.booleanValue() ? 0.0f : 1.0f);
    }

    public final com.google.android.libraries.navigation.internal.ol.j a() {
        com.google.android.libraries.navigation.internal.ol.j jVar;
        if (this.l) {
            this.p = null;
            com.google.android.libraries.navigation.internal.abh.as asVar = this.a;
            if (asVar != null && this.b != null && this.c != null && this.d != null && this.e != null && this.f != null && this.g != null) {
                if (asVar.a() != 3) {
                    this.l = false;
                } else {
                    com.google.android.libraries.navigation.internal.on.h hVar = this.o;
                    LatLng latLng = this.b;
                    this.p = hVar.c(latLng.latitude, latLng.longitude, 4, 1.0f, true, j(), false, 1, this.h, this.i);
                    l();
                    k();
                    this.l = false;
                }
            }
        } else if (this.k && (jVar = this.p) != null) {
            jVar.b(j());
        }
        return this.p;
    }

    public final void b() {
        this.b = null;
        this.c = null;
        c();
    }

    public final void c() {
        this.p = null;
        this.l = false;
        if (this.j != null) {
            this.f137n.e().j(this.j);
            this.j = null;
            this.k = true;
        }
    }

    public final void d(com.google.android.libraries.navigation.internal.abh.as asVar) {
        com.google.android.libraries.navigation.internal.abf.s.k(asVar, "capImpl");
        this.a = asVar;
        this.l = true;
        this.k = true;
    }

    public final void e(boolean z) {
        this.g = Boolean.valueOf(z);
        if (this.l) {
            return;
        }
        k();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return com.google.android.libraries.navigation.internal.abf.r.a(this.a, hVar.a) && com.google.android.libraries.navigation.internal.abf.r.a(this.b, hVar.b) && com.google.android.libraries.navigation.internal.abf.r.a(this.c, hVar.c) && com.google.android.libraries.navigation.internal.abf.r.a(this.d, hVar.d) && com.google.android.libraries.navigation.internal.abf.r.a(this.f, hVar.f) && com.google.android.libraries.navigation.internal.abf.r.a(this.e, hVar.e) && com.google.android.libraries.navigation.internal.abf.r.a(Integer.valueOf(this.h), Integer.valueOf(hVar.h)) && com.google.android.libraries.navigation.internal.abf.r.a(Integer.valueOf(this.i), Integer.valueOf(hVar.i));
    }

    public final void f(LatLng latLng, float f) {
        com.google.android.libraries.navigation.internal.abf.s.k(latLng, "anchor");
        this.b = latLng;
        com.google.android.libraries.navigation.internal.abf.s.i(f, "rotation cannot be NaN");
        this.c = Float.valueOf(f);
        l();
    }

    public final void g(boolean z) {
        this.e = Boolean.valueOf(z);
        l();
    }

    public final void h(float f) {
        this.d = Float.valueOf(f);
        l();
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.d, this.e, this.f, Integer.valueOf(this.h), Integer.valueOf(this.i)});
    }

    public final void i(float f) {
        this.f = Float.valueOf(f);
        this.k = true;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.abf.aj ajVarF = com.google.android.libraries.navigation.internal.abf.aj.f(this);
        ajVarF.g("capImpl", this.a);
        ajVarF.g("anchor", this.b);
        ajVarF.g("rotationDegrees", this.c);
        ajVarF.g("strokeWidthPx", this.d);
        ajVarF.g("isVisible", this.e);
        ajVarF.g(ViewProps.Z_INDEX, this.f);
        return ajVarF.c("zGrade", this.h).c("zWithinGrade", this.i).toString();
    }
}
