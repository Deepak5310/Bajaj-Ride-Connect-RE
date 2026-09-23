package com.google.android.libraries.geo.mapcore.internal.model;

import com.google.android.libraries.navigation.internal.adg.io;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class l extends by {
    private int a;
    private bs b;
    private int c;
    private int d;
    private int e;
    private float f;
    private float g;
    private float h;
    private int i;
    private int j;
    private int k;
    private float l;
    private ev m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private io f67n;
    private boolean o;
    private boolean p;
    private short q;

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final float a() {
        if ((this.q & 1024) != 0) {
            return this.l;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final float b() {
        if ((this.q & 16) != 0) {
            return this.f;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final float c() {
        if ((this.q & 32) != 0) {
            return this.g;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final float d() {
        if ((this.q & 64) != 0) {
            return this.h;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final int e() {
        if ((this.q & 512) != 0) {
            return this.k;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final int f() {
        if ((this.q & 128) != 0) {
            return this.i;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final int g() {
        if ((this.q & 256) != 0) {
            return this.j;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final int h() {
        if ((this.q & 2) != 0) {
            return this.c;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final int i() {
        if ((this.q & 4) != 0) {
            return this.d;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final bz j() {
        if (this.q != 8191 || this.b == null || this.m == null || this.f67n == null) {
            throw new IllegalStateException();
        }
        return new m(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.f67n, this.o, this.p);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final void k(boolean z) {
        this.o = z;
        this.q = (short) (this.q | 2048);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final void l(int i) {
        this.k = i;
        this.q = (short) (this.q | 512);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final void m(int i) {
        this.i = i;
        this.q = (short) (this.q | 128);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final void n(int i) {
        this.j = i;
        this.q = (short) (this.q | 256);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final void o(float f) {
        this.l = f;
        this.q = (short) (this.q | 1024);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final void p(float f) {
        this.f = f;
        this.q = (short) (this.q | 16);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final void q(int i) {
        this.e = i;
        this.q = (short) (this.q | 8);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final void r(int i) {
        this.c = i;
        this.q = (short) (this.q | 2);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final void s(int i) {
        this.d = i;
        this.q = (short) (this.q | 4);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final void t(int i) {
        this.a = i;
        this.q = (short) (this.q | 1);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final void u(boolean z) {
        this.p = z;
        this.q = (short) (this.q | 4096);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final void v(float f) {
        this.g = f;
        this.q = (short) (this.q | 32);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final void w(float f) {
        this.h = f;
        this.q = (short) (this.q | 64);
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final void x(bs bsVar) {
        Objects.requireNonNull(bsVar);
        this.b = bsVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final void y(io ioVar) {
        Objects.requireNonNull(ioVar);
        this.f67n = ioVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.internal.model.by
    public final void z(ev evVar) {
        Objects.requireNonNull(evVar);
        this.m = evVar;
    }
}
