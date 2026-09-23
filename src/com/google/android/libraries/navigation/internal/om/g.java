package com.google.android.libraries.navigation.internal.om;

import com.google.android.libraries.navigation.internal.afl.no;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g extends w {
    private float a;
    private float b;
    private int c;
    private boolean d;
    private boolean e;
    private no f;
    private int g;
    private int h;
    private boolean i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f502n;
    private boolean o;
    private short p;

    @Override // com.google.android.libraries.navigation.internal.om.w
    public final x a() {
        no noVar;
        if (this.p != 16383 || (noVar = this.f) == null) {
            throw new IllegalStateException();
        }
        return new h(this.a, this.b, this.c, this.d, this.e, noVar, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.f502n, this.o);
    }

    @Override // com.google.android.libraries.navigation.internal.om.w
    public final void b(boolean z) {
        this.k = z;
        this.p = (short) (this.p | 512);
    }

    @Override // com.google.android.libraries.navigation.internal.om.w
    public final void c(boolean z) {
        this.e = z;
        this.p = (short) (this.p | 16);
    }

    @Override // com.google.android.libraries.navigation.internal.om.w
    public final void d(boolean z) {
        this.j = z;
        this.p = (short) (this.p | 256);
    }

    @Override // com.google.android.libraries.navigation.internal.om.w
    public final void e(boolean z) {
        this.l = z;
        this.p = (short) (this.p | 1024);
    }

    @Override // com.google.android.libraries.navigation.internal.om.w
    public final void f(boolean z) {
        this.m = z;
        this.p = (short) (this.p | 2048);
    }

    @Override // com.google.android.libraries.navigation.internal.om.w
    public final void g(float f) {
        this.a = f;
        this.p = (short) (this.p | 1);
    }

    @Override // com.google.android.libraries.navigation.internal.om.w
    public final void h(boolean z) {
        this.f502n = z;
        this.p = (short) (this.p | 4096);
    }

    @Override // com.google.android.libraries.navigation.internal.om.w
    public final void i(float f) {
        this.b = f;
        this.p = (short) (this.p | 2);
    }

    @Override // com.google.android.libraries.navigation.internal.om.w
    public final void j(boolean z) {
        this.d = z;
        this.p = (short) (this.p | 8);
    }

    @Override // com.google.android.libraries.navigation.internal.om.w
    public final void k(int i) {
        this.g = i;
        this.p = (short) (this.p | 32);
    }

    @Override // com.google.android.libraries.navigation.internal.om.w
    public final void l(boolean z) {
        this.o = z;
        this.p = (short) (this.p | 8192);
    }

    @Override // com.google.android.libraries.navigation.internal.om.w
    public final void m(int i) {
        this.h = i;
        this.p = (short) (this.p | 64);
    }

    @Override // com.google.android.libraries.navigation.internal.om.w
    public final void n(no noVar) {
        Objects.requireNonNull(noVar);
        this.f = noVar;
    }

    @Override // com.google.android.libraries.navigation.internal.om.w
    public final void o(int i) {
        this.c = i;
        this.p = (short) (this.p | 4);
    }

    @Override // com.google.android.libraries.navigation.internal.om.w
    public final void p(boolean z) {
        this.i = z;
        this.p = (short) (this.p | 128);
    }
}
