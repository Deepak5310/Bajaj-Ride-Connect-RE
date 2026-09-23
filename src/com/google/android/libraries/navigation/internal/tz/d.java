package com.google.android.libraries.navigation.internal.tz;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d extends n {
    private final t a;
    private final t b;
    private final t c;
    private final t d;
    private final t e;
    private final t f;
    private final int g;
    private final int h;
    private final int i;
    private final int j;
    private final int k;
    private final int l;
    private final int m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final int f608n;
    private final float o;
    private final float p;

    public d(t tVar, t tVar2, t tVar3, t tVar4, t tVar5, t tVar6, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, float f, float f2) {
        this.a = tVar;
        this.b = tVar2;
        this.c = tVar3;
        this.d = tVar4;
        this.e = tVar5;
        this.f = tVar6;
        this.g = i;
        this.h = i2;
        this.i = i3;
        this.j = i4;
        this.k = i5;
        this.l = i6;
        this.m = i7;
        this.f608n = i8;
        this.o = f;
        this.p = f2;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final float a() {
        return this.p;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final float b() {
        return this.o;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final int c() {
        return this.f608n;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final int d() {
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final int e() {
        return this.j;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.a.equals(nVar.n()) && this.b.equals(nVar.p()) && this.c.equals(nVar.k()) && this.d.equals(nVar.l()) && this.e.equals(nVar.m()) && this.f.equals(nVar.o())) {
                nVar.q();
                if (this.g == nVar.g() && this.h == nVar.h() && this.i == nVar.f() && this.j == nVar.e() && this.k == nVar.j() && this.l == nVar.i() && this.m == nVar.d() && this.f608n == nVar.c() && Float.floatToIntBits(this.o) == Float.floatToIntBits(nVar.b()) && Float.floatToIntBits(this.p) == Float.floatToIntBits(nVar.a())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final int f() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final int g() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final int h() {
        return this.h;
    }

    public final int hashCode() {
        return ((((((((((((((((((((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * (-721379959)) ^ this.g) * 1000003) ^ this.h) * 1000003) ^ this.i) * 1000003) ^ this.j) * 1000003) ^ this.k) * 1000003) ^ this.l) * 1000003) ^ this.m) * 1000003) ^ this.f608n) * 1000003) ^ Float.floatToIntBits(this.o)) * 1000003) ^ Float.floatToIntBits(this.p);
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final int i() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final int j() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final t k() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final t l() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final t m() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final t n() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final t o() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final t p() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.n
    public final void q() {
    }

    public final String toString() {
        t tVar = this.f;
        t tVar2 = this.e;
        t tVar3 = this.d;
        t tVar4 = this.c;
        t tVar5 = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(tVar5) + ", " + String.valueOf(tVar4) + ", " + String.valueOf(tVar3) + ", " + String.valueOf(tVar2) + ", " + String.valueOf(tVar) + ", 0, " + this.g + ", " + this.h + ", " + this.i + ", " + this.j + ", " + this.k + ", " + this.l + ", " + this.m + ", " + this.f608n + ", " + this.o + ", " + this.p + "}";
    }
}
