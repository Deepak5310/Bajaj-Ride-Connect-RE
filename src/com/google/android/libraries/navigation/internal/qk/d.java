package com.google.android.libraries.navigation.internal.qk;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d extends v {
    public final com.google.android.libraries.navigation.internal.op.f a;
    public final r b;
    public final t c;
    public final int d;
    public final ev e;
    public final com.google.android.libraries.navigation.internal.adg.b f;
    public final com.google.android.libraries.navigation.internal.oe.x g;

    public d(com.google.android.libraries.navigation.internal.op.f fVar, r rVar, t tVar, int i, ev evVar, com.google.android.libraries.navigation.internal.adg.b bVar, com.google.android.libraries.navigation.internal.oe.x xVar) {
        this.a = fVar;
        this.b = rVar;
        this.c = tVar;
        this.d = i;
        this.e = evVar;
        this.f = bVar;
        this.g = xVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.v
    public final int a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.v
    public final com.google.android.libraries.navigation.internal.oe.x b() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.v
    public final com.google.android.libraries.navigation.internal.op.f c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.v
    public final r d() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.v
    public final t e() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        com.google.android.libraries.navigation.internal.oe.x xVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof v) {
            v vVar = (v) obj;
            if (this.a.equals(vVar.c()) && this.b.equals(vVar.d()) && this.c.equals(vVar.e()) && this.d == vVar.a() && hx.i(this.e, vVar.f()) && this.f.equals(vVar.g()) && ((xVar = this.g) != null ? xVar.equals(vVar.b()) : vVar.b() == null)) {
                vVar.i();
                vVar.h();
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.v
    public final ev f() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.v
    public final com.google.android.libraries.navigation.internal.adg.b g() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.v
    public final void h() {
    }

    public final int hashCode() {
        int iHashCode = ((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode();
        com.google.android.libraries.navigation.internal.oe.x xVar = this.g;
        return ((((iHashCode * 1000003) ^ (xVar == null ? 0 : xVar.hashCode())) * 1000003) ^ 1237) * 1000003;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.v
    public final void i() {
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.oe.x xVar = this.g;
        com.google.android.libraries.navigation.internal.adg.b bVar = this.f;
        ev evVar = this.e;
        t tVar = this.c;
        r rVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(rVar) + ", " + String.valueOf(tVar) + ", " + this.d + ", " + String.valueOf(evVar) + ", " + String.valueOf(bVar) + ", " + String.valueOf(xVar) + ", false, null}";
    }
}
