package com.google.android.libraries.navigation.internal.db;

import j$.time.Duration;
import j$.time.Instant;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class q implements aj {
    public String a;
    public double b;
    public double c;
    public float d;
    public double e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public Duration k;
    public Instant l;
    public ak m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public u f386n;
    public f o;
    public r p;
    public ab q;
    public float r;
    public com.google.android.libraries.navigation.internal.pt.d s;
    public int t;
    public boolean u;
    public boolean v;
    public boolean w;
    public int x;
    public boolean y;
    private com.google.android.libraries.navigation.internal.mj.a z;

    public q(com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.b = Double.NaN;
        this.c = Double.NaN;
        this.d = Float.NaN;
        this.e = Double.NaN;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = Float.NaN;
        this.i = Float.NaN;
        this.j = Float.NaN;
        this.k = null;
        this.l = null;
        this.m = null;
        this.f386n = null;
        this.o = null;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.w = false;
        this.y = false;
        this.z = aVar;
    }

    public q(Duration duration) {
        this.b = Double.NaN;
        this.c = Double.NaN;
        this.d = Float.NaN;
        this.e = Double.NaN;
        this.f = Float.NaN;
        this.g = Float.NaN;
        this.h = Float.NaN;
        this.i = Float.NaN;
        this.j = Float.NaN;
        this.l = null;
        this.m = null;
        this.f386n = null;
        this.o = null;
        this.t = 0;
        this.u = false;
        this.v = false;
        this.w = false;
        this.y = false;
        this.k = duration;
    }

    public final r a() {
        if (l()) {
            return new r(this);
        }
        throw new IllegalStateException("latitude and longitude must be set");
    }

    public final u b() {
        if (this.f386n == null) {
            this.f386n = new u();
        }
        return this.f386n;
    }

    public final v c() {
        u uVar = this.f386n;
        return uVar == null ? v.a : uVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.db.aj
    public final ak d() {
        if (this.m == null) {
            this.m = new ak();
        }
        return this.m;
    }

    public final ak e() {
        ak akVar = this.m;
        return akVar == null ? ak.a : akVar;
    }

    public final com.google.android.libraries.navigation.internal.oe.x f() {
        double d = this.b;
        if (!Double.isNaN(d)) {
            double d2 = this.c;
            if (!Double.isNaN(d2)) {
                return com.google.android.libraries.navigation.internal.oe.x.A(d, d2);
            }
        }
        throw new IllegalStateException("latitude and longitude must be set to generate point.");
    }

    public final Duration g() {
        if (k()) {
            return this.k;
        }
        com.google.android.libraries.navigation.internal.mj.a aVar = this.z;
        com.google.android.libraries.navigation.internal.yx.ar.q(aVar);
        return Duration.ofNanos(aVar.b());
    }

    public final boolean h() {
        return !Float.isNaN(this.d);
    }

    public final boolean i() {
        return !Float.isNaN(this.g);
    }

    public final boolean j() {
        return !Float.isNaN(this.h);
    }

    public final boolean k() {
        return this.k != null;
    }

    public final boolean l() {
        return (Double.isNaN(this.b) || Double.isNaN(this.c)) ? false : true;
    }

    public final boolean m() {
        return !Float.isNaN(this.i);
    }

    public final boolean n() {
        return !Float.isNaN(this.j);
    }

    public final void o() {
        this.g = Float.NaN;
    }

    public final void p() {
        this.i = Float.NaN;
    }

    public final void q() {
        this.v = true;
    }

    public final void r(boolean z) {
        b().a = z;
    }

    public final void s(double d, double d2) {
        this.b = d;
        this.c = d2;
    }

    public final void t(com.google.android.libraries.navigation.internal.pt.d dVar) {
        this.t = 3;
        this.s = dVar;
    }

    public final void u(int i) {
        b().b = i;
    }

    public final void v(r rVar) {
        if (rVar != null && rVar.k != null) {
            throw new IllegalArgumentException("GmmLocations used as the rawLocation field cannot themselves have a rawLocation.");
        }
        this.p = rVar;
    }
}
