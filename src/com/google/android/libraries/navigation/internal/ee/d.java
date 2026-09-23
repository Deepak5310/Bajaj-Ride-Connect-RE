package com.google.android.libraries.navigation.internal.ee;

import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d extends p {
    private final String a;
    private final int b;
    private final int c;
    private final an d;
    private final boolean e;
    private final boolean f;
    private final an g;

    public d(String str, int i, int i2, an anVar, boolean z, boolean z2, an anVar2) {
        this.a = str;
        this.b = i;
        this.c = i2;
        this.d = anVar;
        this.e = z;
        this.f = z2;
        this.g = anVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.ee.p
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ee.p
    public final int b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.ee.p
    public final an c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.ee.p
    public final an d() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.ee.p
    public final String e() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            if (this.a.equals(pVar.e()) && this.b == pVar.a() && this.c == pVar.b() && this.d.equals(pVar.c()) && this.e == pVar.g() && this.f == pVar.f() && this.g.equals(pVar.d())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ee.p
    public final boolean f() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.ee.p
    public final boolean g() {
        return this.e;
    }

    public final int hashCode() {
        return ((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.d.hashCode()) * 1000003) ^ (true != this.e ? 1237 : 1231)) * 1000003) ^ (true == this.f ? 1231 : 1237)) * 1000003) ^ this.g.hashCode();
    }

    public final String toString() {
        an anVar = this.g;
        return "{" + this.a + ", " + this.b + ", " + this.c + ", " + String.valueOf(this.d) + ", " + this.e + ", " + this.f + ", " + String.valueOf(anVar) + "}";
    }
}
