package com.google.android.libraries.navigation.internal.px;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class s extends dy {
    public final com.google.android.libraries.navigation.internal.pb.t a;
    public final float b;
    public final com.google.android.libraries.geo.mapcore.internal.model.aq c;
    public final com.google.android.libraries.navigation.internal.pz.d d;
    public final boolean e;
    public final com.google.android.libraries.navigation.internal.om.n f;
    public final com.google.android.libraries.navigation.internal.qb.c g;

    public s(com.google.android.libraries.navigation.internal.pb.t tVar, float f, com.google.android.libraries.geo.mapcore.internal.model.aq aqVar, com.google.android.libraries.navigation.internal.pz.d dVar, com.google.android.libraries.navigation.internal.qb.c cVar, boolean z, com.google.android.libraries.navigation.internal.om.n nVar) {
        Objects.requireNonNull(tVar);
        this.a = tVar;
        this.b = f;
        Objects.requireNonNull(aqVar);
        this.c = aqVar;
        Objects.requireNonNull(dVar);
        this.d = dVar;
        Objects.requireNonNull(cVar);
        this.g = cVar;
        this.e = z;
        Objects.requireNonNull(nVar);
        this.f = nVar;
    }

    @Override // com.google.android.libraries.navigation.internal.px.dy
    public final float a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.px.dy
    public final com.google.android.libraries.navigation.internal.om.n b() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.px.dy
    public final com.google.android.libraries.navigation.internal.pb.t c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.px.dy
    public final com.google.android.libraries.navigation.internal.pz.d d() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.px.dy
    public final com.google.android.libraries.geo.mapcore.internal.model.aq e() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof dy) {
            dy dyVar = (dy) obj;
            if (this.a.equals(dyVar.c()) && Float.floatToIntBits(this.b) == Float.floatToIntBits(dyVar.a()) && this.c.equals(dyVar.e()) && this.d.equals(dyVar.d()) && this.g.equals(dyVar.g()) && this.e == dyVar.f() && this.f.equals(dyVar.b())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.px.dy
    public final boolean f() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.px.dy
    public final com.google.android.libraries.navigation.internal.qb.c g() {
        return this.g;
    }

    public final int hashCode() {
        return ((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.b)) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.g.hashCode()) * 1000003) ^ (true != this.e ? 1237 : 1231)) * 1000003) ^ this.f.hashCode();
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.om.n nVar = this.f;
        com.google.android.libraries.navigation.internal.qb.c cVar = this.g;
        com.google.android.libraries.navigation.internal.pz.d dVar = this.d;
        com.google.android.libraries.geo.mapcore.internal.model.aq aqVar = this.c;
        return "{" + this.a.toString() + ", " + this.b + ", " + String.valueOf(aqVar) + ", " + String.valueOf(dVar) + ", " + cVar.toString() + ", " + this.e + ", " + String.valueOf(nVar) + "}";
    }
}
