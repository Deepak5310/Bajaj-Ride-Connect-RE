package com.google.android.libraries.navigation.internal.sl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class k extends g {
    public final i a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final m e;
    public final int f;
    public final boolean g;
    public final e h;

    public k(i iVar, boolean z, boolean z2, boolean z3, m mVar, int i, boolean z4, e eVar) {
        this.a = iVar;
        this.b = z;
        this.c = z2;
        this.d = z3;
        this.e = mVar;
        this.f = i;
        this.g = z4;
        this.h = eVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sl.g
    public final int a() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.sl.g
    public final e b() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.sl.g
    public final i d() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.sl.g
    public final m e() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.a.equals(gVar.d()) && this.b == gVar.h() && this.c == gVar.g() && this.d == gVar.f() && this.e.equals(gVar.e()) && this.f == gVar.a() && this.g == gVar.i() && this.h.equals(gVar.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.sl.g
    public final boolean f() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.sl.g
    public final boolean g() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.sl.g
    public final boolean h() {
        return this.b;
    }

    public final int hashCode() {
        return ((((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ (true != this.b ? 1237 : 1231)) * 1000003) ^ (true != this.c ? 1237 : 1231)) * 1000003) ^ (true != this.d ? 1237 : 1231)) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f) * 1000003) ^ (true == this.g ? 1231 : 1237)) * 1000003) ^ this.h.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.sl.g
    public final boolean i() {
        return this.g;
    }

    public final String toString() {
        e eVar = this.h;
        m mVar = this.e;
        return "{" + String.valueOf(this.a) + ", " + this.b + ", " + this.c + ", " + this.d + ", " + String.valueOf(mVar) + ", " + this.f + ", " + this.g + ", " + String.valueOf(eVar) + "}";
    }
}
