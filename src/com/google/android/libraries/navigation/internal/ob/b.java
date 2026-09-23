package com.google.android.libraries.navigation.internal.ob;

import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
class b extends r {
    public final u a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    private final com.google.android.libraries.navigation.internal.oe.r h;
    private final long i;
    private final an j;
    private final int k;
    private final boolean l;
    private final q m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ev f493n;
    private final an o;

    public b(com.google.android.libraries.navigation.internal.oe.r rVar, u uVar, long j, an anVar, int i, boolean z, q qVar, int i2, int i3, ev evVar, int i4, int i5, an anVar2) {
        Objects.requireNonNull(rVar);
        this.h = rVar;
        Objects.requireNonNull(uVar);
        this.a = uVar;
        this.i = j;
        Objects.requireNonNull(anVar);
        this.j = anVar;
        this.k = i;
        this.l = z;
        Objects.requireNonNull(qVar);
        this.m = qVar;
        this.b = i2;
        this.c = i3;
        Objects.requireNonNull(evVar);
        this.f493n = evVar;
        this.d = i4;
        this.e = i5;
        Objects.requireNonNull(anVar2);
        this.o = anVar2;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final int b() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final int c() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final int d() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final int e() {
        return this.k;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this.h.equals(rVar.i()) && this.a.equals(rVar.h()) && this.i == rVar.f() && this.j.equals(rVar.k()) && this.k == rVar.e() && this.l == rVar.m() && this.m.equals(rVar.g())) {
                rVar.n();
                if (this.b == rVar.a() && this.c == rVar.d() && hx.i(this.f493n, rVar.l())) {
                    rVar.o();
                    rVar.q();
                    rVar.p();
                    if (this.d == rVar.b() && this.e == rVar.c() && this.o.equals(rVar.j())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final long f() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final q g() {
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final u h() {
        return this.a;
    }

    public final int hashCode() {
        int iHashCode = ((this.h.hashCode() ^ 1000003) * 1000003) ^ this.a.hashCode();
        int i = true != this.l ? 1237 : 1231;
        long j = this.i;
        return (((((((((((((((((((((((((iHashCode * 1000003) ^ ((int) (j ^ (j >>> 32)))) * 1000003) ^ 2040732332) * 1000003) ^ this.k) * 1000003) ^ i) * 1000003) ^ this.m.hashCode()) * (-721379959)) ^ this.b) * 1000003) ^ this.c) * 1000003) ^ this.f493n.hashCode()) * (-721379959)) ^ 1237) * 1000003) ^ 1237) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003) ^ 2040732332;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final com.google.android.libraries.navigation.internal.oe.r i() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final an j() {
        return this.o;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final an k() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final ev l() {
        return this.f493n;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final boolean m() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final void n() {
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final void o() {
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final void p() {
    }

    @Override // com.google.android.libraries.navigation.internal.ob.r
    public final void q() {
    }

    public final String toString() {
        an anVar = this.o;
        ev evVar = this.f493n;
        q qVar = this.m;
        an anVar2 = this.j;
        u uVar = this.a;
        return "{" + String.valueOf(this.h) + ", " + String.valueOf(uVar) + ", " + this.i + ", " + String.valueOf(anVar2) + ", " + this.k + ", " + this.l + ", " + String.valueOf(qVar) + ", null, " + this.b + ", " + this.c + ", " + String.valueOf(evVar) + ", null, false, false, " + this.d + ", " + this.e + ", " + String.valueOf(anVar) + "}";
    }
}
