package com.google.android.libraries.navigation.internal.tz;

import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f extends p {
    private final int a;
    private final l b;
    private final l c;
    private final l d;
    private final r e;
    private final r f;
    private final int g;
    private final r h;
    private final int i;
    private final int j;
    private final r k;
    private final int l;
    private final Optional m;

    public f(int i, l lVar, l lVar2, l lVar3, r rVar, r rVar2, int i2, r rVar3, int i3, int i4, r rVar4, int i5, Optional optional) {
        this.a = i;
        this.b = lVar;
        this.c = lVar2;
        this.d = lVar3;
        this.e = rVar;
        this.f = rVar2;
        this.g = i2;
        this.h = rVar3;
        this.i = i3;
        this.j = i4;
        this.k = rVar4;
        this.l = i5;
        this.m = optional;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.p
    public final int a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.p
    public final int b() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.p
    public final int c() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.p
    public final int d() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.p
    public final int e() {
        return this.i;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.a == pVar.a() && this.b.equals(pVar.f()) && this.c.equals(pVar.g()) && this.d.equals(pVar.h()) && this.e.equals(pVar.k()) && this.f.equals(pVar.l()) && this.g == pVar.b() && this.h.equals(pVar.i()) && this.i == pVar.e() && this.j == pVar.c() && this.k.equals(pVar.j()) && this.l == pVar.d()) {
                pVar.o();
                pVar.n();
                if (this.m.equals(pVar.m())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.p
    public final l f() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.p
    public final l g() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.p
    public final l h() {
        return this.d;
    }

    public final int hashCode() {
        return ((((((((((((((((((((((((this.a ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g) * 1000003) ^ this.h.hashCode()) * 1000003) ^ this.i) * 1000003) ^ this.j) * 1000003) ^ this.k.hashCode()) * 1000003) ^ this.l) * 583896283) ^ this.m.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.tz.p
    public final r i() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.p
    public final r j() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.p
    public final r k() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.p
    public final r l() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.p
    public final Optional m() {
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.tz.p
    public final void n() {
    }

    @Override // com.google.android.libraries.navigation.internal.tz.p
    public final void o() {
    }

    public final String toString() {
        Optional optional = this.m;
        r rVar = this.k;
        r rVar2 = this.h;
        r rVar3 = this.f;
        r rVar4 = this.e;
        l lVar = this.d;
        l lVar2 = this.c;
        return "{" + this.a + ", " + String.valueOf(this.b) + ", " + String.valueOf(lVar2) + ", " + String.valueOf(lVar) + ", " + String.valueOf(rVar4) + ", " + String.valueOf(rVar3) + ", " + this.g + ", " + String.valueOf(rVar2) + ", " + this.i + ", " + this.j + ", " + String.valueOf(rVar) + ", " + this.l + ", 0, 0, " + String.valueOf(optional) + "}";
    }
}
