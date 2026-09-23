package com.google.android.libraries.navigation.internal.cl;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class k extends f {
    public final bd a;
    public final bc b;
    public final be c;
    public final boolean d;
    public final int e;
    public final int f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final String k;
    public final com.google.android.libraries.navigation.internal.ol.aq l;
    public final com.google.android.libraries.navigation.internal.oo.f m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.libraries.navigation.internal.ol.aq f375n;
    public final com.google.android.libraries.navigation.internal.oo.f o;
    public final com.google.android.libraries.navigation.internal.ol.aq p;
    public final com.google.android.libraries.navigation.internal.oo.f q;
    public final boolean r;
    private final boolean s;
    private final boolean t;

    public k(bd bdVar, bc bcVar, be beVar, boolean z, boolean z2, int i, int i2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str, com.google.android.libraries.navigation.internal.ol.aq aqVar, com.google.android.libraries.navigation.internal.oo.f fVar, com.google.android.libraries.navigation.internal.ol.aq aqVar2, com.google.android.libraries.navigation.internal.oo.f fVar2, com.google.android.libraries.navigation.internal.ol.aq aqVar3, com.google.android.libraries.navigation.internal.oo.f fVar3, boolean z8) {
        this.a = bdVar;
        this.b = bcVar;
        this.c = beVar;
        this.d = z;
        this.s = z2;
        this.e = i;
        this.f = i2;
        this.t = z3;
        this.g = z4;
        this.h = z5;
        this.i = z6;
        this.j = z7;
        this.k = str;
        this.l = aqVar;
        this.m = fVar;
        this.f375n = aqVar2;
        this.o = fVar2;
        this.p = aqVar3;
        this.q = fVar3;
        this.r = z8;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final int a() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final int b() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final bc c() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final bd d() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final be e() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        String str;
        com.google.android.libraries.navigation.internal.ol.aq aqVar;
        com.google.android.libraries.navigation.internal.oo.f fVar;
        com.google.android.libraries.navigation.internal.ol.aq aqVar2;
        com.google.android.libraries.navigation.internal.oo.f fVar2;
        com.google.android.libraries.navigation.internal.ol.aq aqVar3;
        com.google.android.libraries.navigation.internal.oo.f fVar3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar4 = (f) obj;
            if (this.a.equals(fVar4.d()) && this.b.equals(fVar4.c()) && this.c.equals(fVar4.e()) && this.d == fVar4.r() && this.s == fVar4.q() && this.e == fVar4.b() && this.f == fVar4.a() && this.t == fVar4.o() && this.g == fVar4.t() && this.h == fVar4.n() && this.i == fVar4.m() && this.j == fVar4.p() && ((str = this.k) != null ? str.equals(fVar4.l()) : fVar4.l() == null) && ((aqVar = this.l) != null ? aqVar.equals(fVar4.f()) : fVar4.f() == null) && ((fVar = this.m) != null ? fVar.equals(fVar4.i()) : fVar4.i() == null) && ((aqVar2 = this.f375n) != null ? aqVar2.equals(fVar4.h()) : fVar4.h() == null) && ((fVar2 = this.o) != null ? fVar2.equals(fVar4.k()) : fVar4.k() == null) && ((aqVar3 = this.p) != null ? aqVar3.equals(fVar4.g()) : fVar4.g() == null) && ((fVar3 = this.q) != null ? fVar3.equals(fVar4.j()) : fVar4.j() == null) && this.r == fVar4.s()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final com.google.android.libraries.navigation.internal.ol.aq f() {
        return this.l;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final com.google.android.libraries.navigation.internal.ol.aq g() {
        return this.p;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final com.google.android.libraries.navigation.internal.ol.aq h() {
        return this.f375n;
    }

    public final int hashCode() {
        int iHashCode = ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode();
        String str = this.k;
        int iHashCode2 = str == null ? 0 : str.hashCode();
        int i = true != this.d ? 1237 : 1231;
        int i2 = iHashCode * 1000003;
        int i3 = true != this.s ? 1237 : 1231;
        int i4 = (i2 ^ i) * 1000003;
        int i5 = this.e;
        int i6 = (i4 ^ i3) * 1000003;
        int i7 = this.f;
        int i8 = (i6 ^ i5) * 1000003;
        int i9 = true != this.t ? 1237 : 1231;
        int i10 = (i8 ^ i7) * 1000003;
        int i11 = true != this.g ? 1237 : 1231;
        int i12 = (i10 ^ i9) * 1000003;
        int i13 = (((((((((i12 ^ i11) * 1000003) ^ (true != this.h ? 1237 : 1231)) * 1000003) ^ (true != this.i ? 1237 : 1231)) * 1000003) ^ (true != this.j ? 1237 : 1231)) * 1000003) ^ iHashCode2) * 1000003;
        com.google.android.libraries.navigation.internal.ol.aq aqVar = this.l;
        int iHashCode3 = (i13 ^ (aqVar == null ? 0 : aqVar.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.oo.f fVar = this.m;
        int iHashCode4 = (iHashCode3 ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.ol.aq aqVar2 = this.f375n;
        int iHashCode5 = (iHashCode4 ^ (aqVar2 == null ? 0 : aqVar2.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.oo.f fVar2 = this.o;
        int iHashCode6 = (iHashCode5 ^ (fVar2 == null ? 0 : fVar2.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.ol.aq aqVar3 = this.p;
        int iHashCode7 = (iHashCode6 ^ (aqVar3 == null ? 0 : aqVar3.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.oo.f fVar3 = this.q;
        return ((iHashCode7 ^ (fVar3 != null ? fVar3.hashCode() : 0)) * 1000003) ^ (true == this.r ? 1231 : 1237);
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final com.google.android.libraries.navigation.internal.oo.f i() {
        return this.m;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final com.google.android.libraries.navigation.internal.oo.f j() {
        return this.q;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final com.google.android.libraries.navigation.internal.oo.f k() {
        return this.o;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final String l() {
        return this.k;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final boolean m() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final boolean n() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final boolean o() {
        return this.t;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final boolean p() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final boolean q() {
        return this.s;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final boolean r() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final boolean s() {
        return this.r;
    }

    @Override // com.google.android.libraries.navigation.internal.cl.f
    public final boolean t() {
        return this.g;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.oo.f fVar = this.q;
        com.google.android.libraries.navigation.internal.ol.aq aqVar = this.p;
        com.google.android.libraries.navigation.internal.oo.f fVar2 = this.o;
        com.google.android.libraries.navigation.internal.ol.aq aqVar2 = this.f375n;
        com.google.android.libraries.navigation.internal.oo.f fVar3 = this.m;
        com.google.android.libraries.navigation.internal.ol.aq aqVar3 = this.l;
        be beVar = this.c;
        bc bcVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(bcVar) + ", " + String.valueOf(beVar) + ", " + this.d + ", " + this.s + ", " + this.e + ", " + this.f + ", " + this.t + ", " + this.g + ", " + this.h + ", " + this.i + ", " + this.j + ", " + this.k + ", " + String.valueOf(aqVar3) + ", " + String.valueOf(fVar3) + ", " + String.valueOf(aqVar2) + ", " + String.valueOf(fVar2) + ", " + String.valueOf(aqVar) + ", " + String.valueOf(fVar) + ", " + this.r + "}";
    }
}
