package com.google.android.libraries.navigation.internal.tz;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c extends m {
    public t a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public float g;
    public short h;
    private t i;
    private t j;
    private t k;
    private t l;
    private t m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f607n;
    private int o;
    private int p;
    private float q;

    @Override // com.google.android.libraries.navigation.internal.tz.m
    public final float a() {
        if ((this.h & 512) != 0) {
            return this.q;
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.libraries.navigation.internal.tz.m
    public final n b() {
        t tVar;
        t tVar2;
        t tVar3;
        t tVar4;
        t tVar5;
        t tVar6;
        if (this.h != 2047 || (tVar = this.i) == null || (tVar2 = this.j) == null || (tVar3 = this.a) == null || (tVar4 = this.k) == null || (tVar5 = this.l) == null || (tVar6 = this.m) == null) {
            throw new IllegalStateException();
        }
        return new d(tVar, tVar2, tVar3, tVar4, tVar5, tVar6, this.f607n, this.o, this.b, this.c, this.d, this.e, this.f, this.p, this.q, this.g);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.m
    public final void c(int i) {
        this.p = i;
        this.h = (short) (this.h | 256);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.m
    public final void d(t tVar) {
        Objects.requireNonNull(tVar);
        this.k = tVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.m
    public final void e(t tVar) {
        Objects.requireNonNull(tVar);
        this.l = tVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.m
    public final void f(float f) {
        this.q = f;
        this.h = (short) (this.h | 512);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.m
    public final void g(t tVar) {
        Objects.requireNonNull(tVar);
        this.i = tVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.m
    public final void h(int i) {
        this.f607n = i;
        this.h = (short) (this.h | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.m
    public final void i(int i) {
        this.o = i;
        this.h = (short) (this.h | 4);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.m
    public final void j(t tVar) {
        Objects.requireNonNull(tVar);
        this.m = tVar;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.m
    public final void k(t tVar) {
        Objects.requireNonNull(tVar);
        this.j = tVar;
    }
}
