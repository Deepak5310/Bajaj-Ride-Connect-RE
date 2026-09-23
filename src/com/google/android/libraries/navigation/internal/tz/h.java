package com.google.android.libraries.navigation.internal.tz;

import android.graphics.Typeface;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class h extends r {
    private final int a;
    private final int b;
    private final Typeface c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;

    public h(int i, int i2, Typeface typeface, int i3, int i4, int i5, int i6) {
        this.a = i;
        this.b = i2;
        this.c = typeface;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.r
    public final int a() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.r
    public final int b() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.r
    public final int c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.r
    public final int d() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.r
    public final int e() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.a == rVar.e() && this.b == rVar.f() && this.c.equals(rVar.g()) && this.d == rVar.c() && this.e == rVar.d() && this.f == rVar.a() && this.g == rVar.b()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.r
    public final int f() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.r
    public final Typeface g() {
        return this.c;
    }

    public final int hashCode() {
        return ((((((((((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003) ^ this.f) * 1000003) ^ this.g;
    }

    public final String toString() {
        return "{" + this.a + ", " + this.b + ", " + String.valueOf(this.c) + ", " + this.d + ", " + this.e + ", " + this.f + ", " + this.g + "}";
    }
}
