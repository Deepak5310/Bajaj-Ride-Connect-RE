package com.google.android.libraries.navigation.internal.ea;

import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.cl.bd;
import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends g {
    public final bh a;
    public final bd b;
    public final com.google.android.libraries.navigation.internal.bt.e c;
    public final Optional d;
    public final boolean e;
    public final boolean f;
    public final Optional g;
    public final Optional h;

    public b(bh bhVar, bd bdVar, com.google.android.libraries.navigation.internal.bt.e eVar, Optional optional, boolean z, boolean z2, Optional optional2, Optional optional3) {
        this.a = bhVar;
        this.b = bdVar;
        this.c = eVar;
        this.d = optional;
        this.e = z;
        this.f = z2;
        this.g = optional2;
        this.h = optional3;
    }

    @Override // com.google.android.libraries.navigation.internal.ea.g
    public final bh a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ea.g
    public final com.google.android.libraries.navigation.internal.bt.e b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.ea.g
    public final bd c() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ea.g
    public final Optional d() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.ea.g
    public final Optional e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.a.equals(gVar.a()) && this.b.equals(gVar.c()) && this.c.equals(gVar.b()) && this.d.equals(gVar.e())) {
                gVar.i();
                gVar.k();
                gVar.j();
                gVar.l();
                gVar.m();
                if (this.e == gVar.h() && this.f == gVar.g() && this.g.equals(gVar.f()) && this.h.equals(gVar.d())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ea.g
    public final Optional f() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.ea.g
    public final boolean g() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.ea.g
    public final boolean h() {
        return this.e;
    }

    public final int hashCode() {
        return ((((((((((((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * (-721379959)) ^ 1237) * 1000003) ^ 1237) * 1000003) ^ 1237) * 1000003) ^ 1237) * 1000003) ^ (true != this.e ? 1237 : 1231)) * 1000003) ^ (true != this.f ? 1237 : 1231)) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.ea.g
    public final void i() {
    }

    @Override // com.google.android.libraries.navigation.internal.ea.g
    public final void j() {
    }

    @Override // com.google.android.libraries.navigation.internal.ea.g
    public final void k() {
    }

    @Override // com.google.android.libraries.navigation.internal.ea.g
    public final void l() {
    }

    @Override // com.google.android.libraries.navigation.internal.ea.g
    public final void m() {
    }

    public final String toString() {
        Optional optional = this.h;
        Optional optional2 = this.g;
        Optional optional3 = this.d;
        com.google.android.libraries.navigation.internal.bt.e eVar = this.c;
        bd bdVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(bdVar) + ", " + String.valueOf(eVar) + ", " + String.valueOf(optional3) + ", null, false, false, false, false, " + this.e + ", " + this.f + ", " + String.valueOf(optional2) + ", " + String.valueOf(optional) + "}";
    }
}
