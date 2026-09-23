package com.google.android.libraries.navigation.internal.om;

import com.google.android.libraries.navigation.internal.agg.ez;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends n {
    public final boolean a;
    public final ez b;
    public final String c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    private final boolean g;
    private final boolean h;
    private final int i;
    private final boolean j;
    private final boolean k;
    private final int l;
    private final boolean m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final boolean f501n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private final int s;
    private final boolean t;
    private final boolean u;

    public f(boolean z, boolean z2, ez ezVar, boolean z3, int i, boolean z4, boolean z5, String str, int i2, boolean z6, boolean z7, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, int i3, boolean z14, boolean z15, boolean z16) {
        this.g = z;
        this.a = z2;
        this.b = ezVar;
        this.h = z3;
        this.i = i;
        this.j = z4;
        this.k = z5;
        this.c = str;
        this.l = i2;
        this.m = z6;
        this.f501n = z7;
        this.d = z8;
        this.o = z9;
        this.p = z10;
        this.q = z11;
        this.e = z12;
        this.r = z13;
        this.s = i3;
        this.t = z14;
        this.f = z15;
        this.u = z16;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final int a() {
        return this.s;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final int b() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final int c() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final ez d() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final String e() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.g == nVar.n() && this.a == nVar.g() && this.b.equals(nVar.d()) && this.h == nVar.r() && this.i == nVar.b() && this.j == nVar.i() && this.k == nVar.f() && this.c.equals(nVar.e()) && this.l == nVar.c() && this.m == nVar.p() && this.f501n == nVar.o() && this.d == nVar.s() && this.o == nVar.u() && this.p == nVar.m() && this.q == nVar.q() && this.e == nVar.t() && this.r == nVar.k() && this.s == nVar.a() && this.t == nVar.j() && this.f == nVar.l() && this.u == nVar.h()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final boolean f() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final boolean g() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final boolean h() {
        return this.u;
    }

    public final int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((true != this.g ? 1237 : 1231) ^ 1000003) * 1000003) ^ (true != this.a ? 1237 : 1231)) * 1000003) ^ this.b.hashCode()) * 1000003) ^ (true != this.h ? 1237 : 1231)) * 1000003) ^ this.i) * 1000003) ^ (true != this.j ? 1237 : 1231)) * 1000003) ^ (true != this.k ? 1237 : 1231)) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.l) * 1000003) ^ (true != this.m ? 1237 : 1231)) * 1000003) ^ (true != this.f501n ? 1237 : 1231)) * 1000003) ^ (true != this.d ? 1237 : 1231)) * 1000003) ^ (true != this.o ? 1237 : 1231)) * 1000003) ^ (true != this.p ? 1237 : 1231)) * 1000003) ^ (true != this.q ? 1237 : 1231)) * 1000003) ^ (true != this.e ? 1237 : 1231)) * 1000003) ^ (true != this.r ? 1237 : 1231)) * 1000003) ^ this.s) * 1000003) ^ (true != this.t ? 1237 : 1231)) * 1000003) ^ (true != this.f ? 1237 : 1231)) * 1000003) ^ (true == this.u ? 1231 : 1237);
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final boolean i() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final boolean j() {
        return this.t;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final boolean k() {
        return this.r;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final boolean l() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final boolean m() {
        return this.p;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final boolean n() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final boolean o() {
        return this.f501n;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final boolean p() {
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final boolean q() {
        return this.q;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final boolean r() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final boolean s() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final boolean t() {
        return this.e;
    }

    public final String toString() {
        return "{" + this.g + ", " + this.a + ", " + String.valueOf(this.b) + ", " + this.h + ", " + this.i + ", " + this.j + ", " + this.k + ", " + this.c + ", " + this.l + ", " + this.m + ", " + this.f501n + ", " + this.d + ", " + this.o + ", " + this.p + ", " + this.q + ", " + this.e + ", " + this.r + ", " + this.s + ", " + this.t + ", " + this.f + ", " + this.u + "}";
    }

    @Override // com.google.android.libraries.navigation.internal.om.n
    public final boolean u() {
        return this.o;
    }
}
