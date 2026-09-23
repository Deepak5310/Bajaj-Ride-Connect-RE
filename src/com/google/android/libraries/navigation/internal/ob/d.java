package com.google.android.libraries.navigation.internal.ob;

import com.google.android.libraries.navigation.internal.yx.br;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d extends n {
    private final br a;
    private final m b;
    private final s c;
    private final boolean d;
    private final String e;

    public d(br brVar, m mVar, s sVar, boolean z, String str) {
        this.a = brVar;
        this.b = mVar;
        this.c = sVar;
        this.d = z;
        this.e = str;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.n
    public final m a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.n
    public final s b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.n
    public final br c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.n
    public final String d() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.n
    public final boolean e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (this.a.equals(nVar.c()) && this.b.equals(nVar.a()) && this.c.equals(nVar.b())) {
                nVar.f();
                if (this.d == nVar.e() && this.e.equals(nVar.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.n
    public final void f() {
    }

    public final int hashCode() {
        return ((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ 1237) * 1000003) ^ (true != this.d ? 1237 : 1231)) * 1000003) ^ this.e.hashCode();
    }

    public final String toString() {
        s sVar = this.c;
        m mVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(mVar) + ", " + String.valueOf(sVar) + ", false, " + this.d + ", " + this.e + "}";
    }
}
