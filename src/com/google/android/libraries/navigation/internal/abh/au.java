package com.google.android.libraries.navigation.internal.abh;

import android.os.RemoteException;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class au extends com.google.android.libraries.navigation.internal.lz.c implements fl, fw {
    private static final CircleOptions b = new CircleOptions();
    private static final com.google.android.libraries.navigation.internal.lo.l c = new com.google.android.libraries.navigation.internal.lo.n(null);
    private static final AtomicInteger d = new AtomicInteger(0);
    public fn a;
    private final String e;
    private final fm f;
    private final ht g;
    private LatLng h;
    private double i;
    private boolean j;
    private final LatLng[] k;
    private boolean l;
    private int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f114n;
    private float o;
    private PatternItem[] p;
    private float q;
    private boolean r;
    private boolean s;
    private boolean t;
    private com.google.android.libraries.navigation.internal.lo.l u;
    private final com.google.android.libraries.navigation.internal.abf.z v;

    public au(CircleOptions circleOptions, fm fmVar, ht htVar, com.google.android.libraries.navigation.internal.abf.z zVar) {
        com.google.android.libraries.navigation.internal.abf.s.j(fmVar);
        this.f = fmVar;
        com.google.android.libraries.navigation.internal.abf.s.j(htVar);
        this.g = htVar;
        com.google.android.libraries.navigation.internal.abf.s.j(zVar);
        this.v = zVar;
        this.u = c;
        this.e = String.format(Locale.getDefault(), "ci%d", Integer.valueOf(d.getAndIncrement()));
        com.google.android.libraries.navigation.internal.abf.s.a(circleOptions.getStrokeWidth() >= 0.0f, "stroke width is negative");
        com.google.android.libraries.navigation.internal.abf.s.j(circleOptions.getCenter());
        com.google.android.libraries.navigation.internal.abf.s.a(circleOptions.getRadius() >= 0.0d, "radius is negative");
        this.h = circleOptions.getCenter();
        this.i = circleOptions.getRadius();
        this.o = circleOptions.getStrokeWidth();
        this.m = circleOptions.getStrokeColor();
        this.p = PatternItem.b(circleOptions.getStrokePattern());
        this.f114n = circleOptions.getFillColor();
        this.q = circleOptions.getZIndex();
        this.r = circleOptions.isVisible();
        this.s = circleOptions.isClickable();
        int fillColor = circleOptions.getFillColor();
        CircleOptions circleOptions2 = b;
        if (fillColor != circleOptions2.getFillColor()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_FILL_COLOR);
        }
        if (circleOptions.getStrokeColor() != circleOptions2.getStrokeColor()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_STROKE_COLOR);
        }
        if (circleOptions.getStrokeWidth() != circleOptions2.getStrokeWidth()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_WIDTH);
        }
        if (!com.google.android.libraries.navigation.internal.abf.r.a(circleOptions.getStrokePattern(), circleOptions2.getStrokePattern())) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_STROKE_PATTERN);
        }
        if (circleOptions.isVisible() != circleOptions2.isVisible()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_VISIBILITY);
        }
        if (circleOptions.getZIndex() != circleOptions2.getZIndex()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_Z_INDEX);
        }
        if (circleOptions.isClickable() != circleOptions2.isClickable()) {
            htVar.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_CLICKABILITY);
        }
        this.k = new LatLng[100];
        this.l = false;
    }

    private final void L(int i) {
        synchronized (this) {
            if (this.t) {
                return;
            }
            fn fnVar = this.a;
            if (fnVar != null) {
                fnVar.c(i);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized int A() {
        return this.f114n;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized int B() {
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final int C() {
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized void D(List list) {
        com.google.android.libraries.navigation.internal.abf.s.k(list, "Null outputHoles");
        list.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized void E(List list) {
        boolean z;
        boolean z2;
        com.google.android.libraries.navigation.internal.abf.s.k(list, "Null outputOutline");
        if (!this.l) {
            LatLng latLng = this.h;
            double d2 = this.i;
            LatLng[] latLngArr = this.k;
            com.google.android.libraries.navigation.internal.abf.s.k(latLng, "Null center");
            com.google.android.libraries.navigation.internal.abf.s.b(d2 >= 0.0d, "Negative radius: %s", Double.valueOf(d2));
            com.google.android.libraries.navigation.internal.abf.s.b(true, "Insufficient buffer size: %s", 100);
            if (Double.compare(d2, 0.0d) == 0) {
                Arrays.fill(latLngArr, latLng);
            } else {
                double radians = Math.toRadians(latLng.latitude);
                double radians2 = Math.toRadians(latLng.longitude);
                double d3 = d2 / 6371009.0d;
                double dCos = Math.cos(d3);
                double dSin = Math.sin(d3);
                double dCos2 = Math.cos(radians);
                double dSin2 = Math.sin(radians);
                int i = 0;
                for (int i2 = 100; i < i2; i2 = 100) {
                    double d4 = (((double) i) * 6.283185307179586d) / 99.0d;
                    double dCos3 = (dSin2 * dCos) + (dCos2 * dSin * Math.cos(d4));
                    latLngArr[i] = new LatLng(Math.toDegrees(Math.asin(dCos3)), Math.toDegrees(Math.atan2(Math.sin(d4) * dSin * dCos2, dCos - (dSin2 * dCos3)) + radians2));
                    i++;
                }
            }
            LatLng latLng2 = this.h;
            double dA = bw.a(latLng2, this.i);
            double d5 = latLng2.longitude;
            if (d5 < 0.0d ? d5 + dA > 0.0d || d5 - dA < -180.0d : d5 - dA < 0.0d || d5 + dA > 180.0d) {
                z = true;
                z2 = true;
            } else {
                z = true;
                z2 = false;
            }
            this.j = !z2;
            this.l = z;
        }
        list.clear();
        Collections.addAll(list, this.k);
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final void F() {
        this.v.a();
        fm fmVar = this.f;
        com.google.android.libraries.navigation.internal.ly.af afVar = fmVar.c;
        if (afVar == null) {
            fmVar.f.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_CLICK_WITHOUT_LISTENER);
            return;
        }
        try {
            ((com.google.android.gms.maps.l) afVar).a.onCircleClick(new Circle(this));
            fmVar.f.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_CLICK_WITH_LISTENER);
        } catch (RemoteException e) {
            throw new RuntimeRemoteException(e);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fl
    public final void G() {
        synchronized (this) {
            if (this.t) {
                return;
            }
            this.u = c;
            this.t = true;
            fn fnVar = this.a;
            if (fnVar != null) {
                fnVar.d();
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized boolean H() {
        return this.s;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final boolean I() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized boolean J() {
        return this.r;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized PatternItem[] K() {
        return this.p;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final synchronized double a() {
        this.v.a();
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final synchronized float b() {
        this.v.a();
        return y();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final synchronized float c() {
        this.v.a();
        return z();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final synchronized int d() {
        this.v.a();
        return A();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final synchronized int e() {
        this.v.a();
        return B();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final int f() {
        return hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final com.google.android.libraries.navigation.internal.lo.l g() {
        this.v.a();
        return this.u;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final synchronized LatLng h() {
        this.v.a();
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final String i() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final List j() {
        this.v.a();
        PatternItem[] patternItemArrK = K();
        if (patternItemArrK == null) {
            return null;
        }
        return new ArrayList(Arrays.asList(patternItemArrK));
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final void k() {
        this.v.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_REMOVE);
        G();
        this.f.b(this);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final void l(LatLng latLng) {
        boolean z;
        this.v.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_SET_CENTER);
        synchronized (this) {
            if (this.h.equals(latLng)) {
                z = false;
            } else {
                this.h = latLng;
                this.l = false;
                z = true;
            }
        }
        if (z) {
            L(0);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final void m(boolean z) {
        this.v.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_CLICKABILITY);
        synchronized (this) {
            this.s = z;
        }
        L(12);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final void n(int i) {
        this.v.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_FILL_COLOR);
        synchronized (this) {
            this.f114n = i;
        }
        L(5);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final void o(double d2) {
        boolean z;
        this.v.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_SET_RADIUS);
        synchronized (this) {
            if (Double.doubleToLongBits(this.i) != Double.doubleToLongBits(d2)) {
                this.i = d2;
                this.l = false;
                z = true;
            } else {
                z = false;
            }
        }
        if (z) {
            L(0);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final void p(int i) {
        this.v.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_STROKE_COLOR);
        synchronized (this) {
            this.m = i;
        }
        L(4);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final void q(List list) {
        this.v.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_STROKE_PATTERN);
        synchronized (this) {
            this.p = PatternItem.b(list);
        }
        L(11);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final void r(float f) {
        this.v.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_WIDTH);
        com.google.android.libraries.navigation.internal.abf.s.a(f >= 0.0f, "stroke width is negative");
        synchronized (this) {
            this.o = f;
        }
        L(3);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final void s(com.google.android.libraries.navigation.internal.lo.l lVar) {
        this.v.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_SET_TAG);
        this.u = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final void t(boolean z) {
        this.v.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_VISIBILITY);
        synchronized (this) {
            this.r = z;
        }
        L(6);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final void u(float f) {
        this.v.a();
        this.g.c(com.google.android.libraries.navigation.internal.abx.b.CIRCLE_Z_INDEX);
        synchronized (this) {
            this.q = f;
        }
        L(7);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final boolean v(com.google.android.libraries.navigation.internal.lz.d dVar) {
        return equals(dVar);
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final boolean w() {
        this.v.a();
        return H();
    }

    @Override // com.google.android.libraries.navigation.internal.lz.d
    public final synchronized boolean x() {
        this.v.a();
        return J();
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized float y() {
        return this.o;
    }

    @Override // com.google.android.libraries.navigation.internal.abh.fw
    public final synchronized float z() {
        return this.q;
    }
}
