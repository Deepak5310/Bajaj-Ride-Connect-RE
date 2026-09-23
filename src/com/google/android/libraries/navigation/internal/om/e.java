package com.google.android.libraries.navigation.internal.om;

import com.google.android.libraries.navigation.internal.agg.ez;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e extends m {
    private boolean a;
    private boolean b;
    private ez c;
    private boolean d;
    private int e;
    private boolean f;
    private boolean g;
    private String h;
    private int i;
    private boolean j;
    private boolean k;
    private boolean l;
    private boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f500n;
    private boolean o;
    private boolean p;
    private boolean q;
    private int r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final n a() {
        ez ezVar;
        String str;
        if (this.v != 524287 || (ezVar = this.c) == null || (str = this.h) == null) {
            throw new IllegalStateException();
        }
        return new f(this.a, this.b, ezVar, this.d, this.e, this.f, this.g, str, this.i, this.j, this.k, this.l, this.m, this.f500n, this.o, this.p, this.q, this.r, this.s, this.t, this.u);
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void b(boolean z) {
        this.g = z;
        this.v |= 32;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void c(ez ezVar) {
        Objects.requireNonNull(ezVar);
        this.c = ezVar;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void d(boolean z) {
        this.b = z;
        this.v |= 2;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void e(boolean z) {
        this.u = z;
        this.v |= 262144;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void f(boolean z) {
        this.f = z;
        this.v |= 16;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void g(boolean z) {
        this.s = z;
        this.v |= 65536;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void h(boolean z) {
        this.q = z;
        this.v |= 16384;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void i(boolean z) {
        this.t = z;
        this.v |= 131072;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void j(boolean z) {
        this.f500n = z;
        this.v |= 2048;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void k(String str) {
        Objects.requireNonNull(str);
        this.h = str;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void l(boolean z) {
        this.a = z;
        this.v |= 1;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void m(boolean z) {
        this.k = z;
        this.v |= 256;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void n(boolean z) {
        this.j = z;
        this.v |= 128;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void o(boolean z) {
        this.o = z;
        this.v |= 4096;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void p(int i) {
        this.r = i;
        this.v |= 32768;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void q(int i) {
        this.e = i;
        this.v |= 8;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void r(boolean z) {
        this.d = z;
        this.v |= 4;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void s(boolean z) {
        this.l = z;
        this.v |= 512;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void t(boolean z) {
        this.p = z;
        this.v |= 8192;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void u(boolean z) {
        this.m = z;
        this.v |= 1024;
    }

    @Override // com.google.android.libraries.navigation.internal.om.m
    public final void v(int i) {
        this.i = i;
        this.v |= 64;
    }
}
