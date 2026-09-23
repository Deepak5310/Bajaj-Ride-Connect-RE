package com.google.android.libraries.navigation.internal.tz;

import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends l {
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private final int f;
    private final Optional g;
    private final Optional h;
    private final Optional i;
    private final Optional j;
    private final Optional k;
    private final Optional l;

    public b(int i, int i2, int i3, int i4, int i5, int i6, Optional optional, Optional optional2, Optional optional3, Optional optional4, Optional optional5, Optional optional6) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = optional;
        this.h = optional2;
        this.i = optional3;
        this.j = optional4;
        this.k = optional5;
        this.l = optional6;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.l
    public final int a() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.l
    public final int b() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.l
    public final int c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.l
    public final int d() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.l
    public final int e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (this.a == lVar.c() && this.b == lVar.e() && this.c == lVar.d() && this.d == lVar.f() && this.e == lVar.b() && this.f == lVar.a() && this.g.equals(lVar.h()) && this.h.equals(lVar.i()) && this.i.equals(lVar.j()) && this.j.equals(lVar.g()) && this.k.equals(lVar.k()) && this.l.equals(lVar.l())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.l
    public final int f() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.l
    public final Optional g() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.l
    public final Optional h() {
        return this.g;
    }

    public final int hashCode() {
        return ((((((((((((((((((((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003) ^ this.f) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i.hashCode()) * 1000003) ^ this.j.hashCode()) * 1000003) ^ this.k.hashCode()) * 1000003) ^ this.l.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.tz.l
    public final Optional i() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.l
    public final Optional j() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.l
    public final Optional k() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.l
    public final Optional l() {
        return this.l;
    }

    public final String toString() {
        Optional optional = this.l;
        Optional optional2 = this.k;
        Optional optional3 = this.j;
        Optional optional4 = this.i;
        Optional optional5 = this.h;
        return "{" + this.a + ", " + this.b + ", " + this.c + ", " + this.d + ", " + this.e + ", " + this.f + ", " + String.valueOf(this.g) + ", " + String.valueOf(optional5) + ", " + String.valueOf(optional4) + ", " + String.valueOf(optional3) + ", " + String.valueOf(optional2) + ", " + String.valueOf(optional) + "}";
    }
}
