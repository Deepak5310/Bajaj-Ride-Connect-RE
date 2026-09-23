package com.google.android.libraries.navigation.internal.px;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class r extends dx {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final long g;
    private final long h;

    public r(int i, int i2, int i3, int i4, int i5, int i6, long j, long j2) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = j;
        this.h = j2;
    }

    @Override // com.google.android.libraries.navigation.internal.px.dx
    public final int a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.px.dx
    public final int b() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.px.dx
    public final int c() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.px.dx
    public final int d() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.px.dx
    public final int e() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof dx) {
            dx dxVar = (dx) obj;
            if (this.a == dxVar.e() && this.b == dxVar.d() && this.c == dxVar.a() && this.d == dxVar.f() && this.e == dxVar.c() && this.f == dxVar.b() && this.g == dxVar.h() && this.h == dxVar.g()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.px.dx
    public final int f() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.px.dx
    public final long g() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.px.dx
    public final long h() {
        return this.g;
    }

    public final int hashCode() {
        long j = this.h;
        int i = this.a;
        long j2 = this.g;
        return ((int) (j ^ (j >>> 32))) ^ ((((((((((((((i ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003) ^ this.f) * 1000003) ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003);
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + ", " + this.c + ", " + this.d + ", " + this.e + ", " + this.f + ", " + this.g + ", " + this.h + "}";
    }
}
