package com.google.android.libraries.navigation.internal.qk;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends h {
    public final com.google.android.libraries.navigation.internal.ol.n a;
    public final r b;
    public final t c;
    public final int d;
    public final ev e;

    public b(com.google.android.libraries.navigation.internal.ol.n nVar, r rVar, t tVar, int i, ev evVar) {
        this.a = nVar;
        this.b = rVar;
        this.c = tVar;
        this.d = i;
        this.e = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.h
    public final int a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.h
    public final com.google.android.libraries.navigation.internal.ol.n b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.h
    public final r c() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.h
    public final t d() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.h
    public final ev e() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.a.equals(hVar.b()) && this.b.equals(hVar.c()) && this.c.equals(hVar.d()) && this.d == hVar.a() && hx.i(this.e, hVar.e())) {
                hVar.f();
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qk.h
    public final void f() {
    }

    public final int hashCode() {
        return (((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d) * 1000003) ^ this.e.hashCode()) * 1000003;
    }

    public final String toString() {
        ev evVar = this.e;
        t tVar = this.c;
        r rVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(rVar) + ", " + String.valueOf(tVar) + ", " + this.d + ", " + String.valueOf(evVar) + ", null}";
    }
}
