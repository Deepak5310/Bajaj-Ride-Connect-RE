package com.google.android.libraries.navigation.internal.qu;

import com.google.android.libraries.navigation.internal.afm.dc;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l extends bq {
    public final com.google.android.libraries.navigation.internal.adi.an a;
    public final com.google.android.libraries.geo.mapcore.internal.model.cd b;
    public final com.google.android.libraries.navigation.internal.qv.i c;
    public final dc d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final String h;
    public final boolean i;
    public final com.google.android.libraries.navigation.internal.gp.b j;

    public l(com.google.android.libraries.navigation.internal.adi.an anVar, com.google.android.libraries.geo.mapcore.internal.model.cd cdVar, com.google.android.libraries.navigation.internal.qv.i iVar, dc dcVar, boolean z, boolean z2, boolean z3, String str, boolean z4, com.google.android.libraries.navigation.internal.gp.b bVar) {
        Objects.requireNonNull(anVar);
        this.a = anVar;
        Objects.requireNonNull(cdVar);
        this.b = cdVar;
        this.c = iVar;
        Objects.requireNonNull(dcVar);
        this.d = dcVar;
        this.e = z;
        this.f = z2;
        this.g = z3;
        Objects.requireNonNull(str);
        this.h = str;
        this.i = z4;
        Objects.requireNonNull(bVar);
        this.j = bVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qu.bq
    public final com.google.android.libraries.navigation.internal.gp.b a() {
        return this.j;
    }

    @Override // com.google.android.libraries.navigation.internal.qu.bq
    public final com.google.android.libraries.geo.mapcore.internal.model.cd b() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.qu.bq
    public final com.google.android.libraries.navigation.internal.qv.i c() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.qu.bq
    public final com.google.android.libraries.navigation.internal.adi.an d() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.qu.bq
    public final dc e() {
        return this.d;
    }

    public final boolean equals(Object obj) {
        com.google.android.libraries.navigation.internal.qv.i iVar;
        if (obj == this) {
            return true;
        }
        if (obj instanceof bq) {
            bq bqVar = (bq) obj;
            if (this.a.equals(bqVar.d()) && this.b.equals(bqVar.b()) && ((iVar = this.c) != null ? iVar.equals(bqVar.c()) : bqVar.c() == null) && this.d.equals(bqVar.e()) && this.e == bqVar.i() && this.f == bqVar.j() && this.g == bqVar.h() && this.h.equals(bqVar.f())) {
                bqVar.k();
                if (this.i == bqVar.g() && this.j.equals(bqVar.a())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.qu.bq
    public final String f() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.qu.bq
    public final boolean g() {
        return this.i;
    }

    @Override // com.google.android.libraries.navigation.internal.qu.bq
    public final boolean h() {
        return this.g;
    }

    public final int hashCode() {
        int iHashCode = ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
        com.google.android.libraries.navigation.internal.qv.i iVar = this.c;
        return ((((~(((((((((((((iHashCode * 1000003) ^ (iVar == null ? 0 : iVar.hashCode())) * 1000003) ^ this.d.hashCode()) * 1000003) ^ (true != this.e ? 1237 : 1231)) * 1000003) ^ (true != this.f ? 1237 : 1231)) * 1000003) ^ (true != this.g ? 1237 : 1231)) * 1000003) ^ this.h.hashCode()) * 1000003)) * 1000003) ^ (true == this.i ? 1231 : 1237)) * 1000003) ^ this.j.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.qu.bq
    public final boolean i() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.qu.bq
    public final boolean j() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.qu.bq
    public final void k() {
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.gp.b bVar = this.j;
        dc dcVar = this.d;
        com.google.android.libraries.navigation.internal.qv.i iVar = this.c;
        com.google.android.libraries.geo.mapcore.internal.model.cd cdVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(cdVar) + ", " + String.valueOf(iVar) + ", " + String.valueOf(dcVar) + ", " + this.e + ", " + this.f + ", " + this.g + ", " + this.h + ", -1, " + this.i + ", " + bVar.toString() + "}";
    }
}
