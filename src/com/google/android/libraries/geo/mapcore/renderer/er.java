package com.google.android.libraries.geo.mapcore.renderer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class er {
    final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final float h;
    public final ep i;
    public final int j;
    public final int k;
    public final int l;

    public er(ep epVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, float f) {
        this.a = i;
        this.b = i5;
        this.c = i6;
        this.f = i3;
        this.g = i4;
        this.d = i7;
        this.e = i8;
        this.j = i9;
        this.k = i10;
        this.h = f;
        this.i = epVar;
        this.l = i2;
    }

    public final float a() {
        return this.e * this.h;
    }

    public final float b() {
        return this.d * this.h;
    }

    public final void c() {
        ep epVar = this.i;
        synchronized (epVar.a) {
            el elVar = (el) epVar.c.h(this.a);
            com.google.android.libraries.navigation.internal.yx.ar.q(elVar);
            com.google.android.libraries.navigation.internal.yx.ar.k(elVar.a == this);
            com.google.android.libraries.navigation.internal.yx.ar.k(elVar.b >= 0);
            int i = elVar.b - 1;
            elVar.b = i;
            if (i == 0) {
                epVar.c.b(elVar.a.a);
                eq eqVar = epVar.b;
                int i2 = elVar.a.l;
                if (i2 >= 0) {
                    c cVar = eqVar.a;
                    com.google.android.libraries.navigation.internal.yx.ar.k(true);
                    com.google.android.libraries.navigation.internal.yx.ar.k(i2 < cVar.c());
                    com.google.android.libraries.navigation.internal.yx.ar.k(true);
                    com.google.android.libraries.navigation.internal.yx.ar.k(i2 < cVar.c());
                    int iE = cVar.e(i2);
                    int iF = cVar.f(i2);
                    int iD = cVar.d(i2);
                    int iB = cVar.b(i2);
                    int i3 = cVar.j[iF];
                    boolean z = i3 >= 0;
                    com.google.android.libraries.navigation.internal.yx.ar.k(z);
                    com.google.android.libraries.navigation.internal.yx.ar.k(i3 < cVar.j());
                    int i4 = (iF * cVar.a) + iE;
                    cVar.d.clear(i4, i4 + iD);
                    cVar.n(i2);
                    int i5 = cVar.i(i3);
                    int i6 = i5 - iD;
                    cVar.x(i3, i6);
                    cVar.z(i3, cVar.a);
                    if (i5 == cVar.a) {
                        com.google.android.libraries.navigation.internal.yx.ar.k(z);
                        com.google.android.libraries.navigation.internal.yx.ar.k(i3 < cVar.j());
                        com.google.android.libraries.navigation.internal.yx.ar.k(cVar.h(i3) != -1 || cVar.i == i3);
                        int iH = cVar.h(i3);
                        int iG = cVar.g(i3);
                        if (i3 == cVar.i) {
                            cVar.i = iG;
                        }
                        if (iH != -1) {
                            cVar.v(iH, iG);
                        }
                        if (iG != -1) {
                            cVar.w(iG, iH);
                        }
                        cVar.w(i3, -1);
                        cVar.v(i3, -1);
                        if (i6 == 0) {
                            cVar.m(i3, iB);
                        } else {
                            cVar.l(i3, iB);
                        }
                    } else if (i6 == 0) {
                        cVar.p(i3, iB);
                        cVar.m(i3, iB);
                    }
                    cVar.m--;
                }
                synchronized (epVar.d) {
                    en enVar = epVar.d;
                    eq eqVar2 = epVar.b;
                    boolean z2 = eqVar2.b() == 0;
                    int iF2 = eqVar2.f();
                    enVar.b = z2;
                    enVar.c = iF2;
                    enVar.a(this);
                }
            }
        }
    }
}
