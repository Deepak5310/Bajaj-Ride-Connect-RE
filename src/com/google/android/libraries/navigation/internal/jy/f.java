package com.google.android.libraries.navigation.internal.jy;

import com.google.android.libraries.navigation.internal.zp.ca;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class f extends z {
    public final ca a;
    public final int b;
    public final com.google.android.libraries.navigation.internal.hc.a c;
    public final com.google.android.libraries.navigation.internal.hc.a d;
    public final com.google.android.libraries.navigation.internal.hc.a e;
    public final com.google.android.libraries.navigation.internal.hc.a f;

    public f(ca caVar, int i, com.google.android.libraries.navigation.internal.hc.a aVar, com.google.android.libraries.navigation.internal.hc.a aVar2, com.google.android.libraries.navigation.internal.hc.a aVar3, com.google.android.libraries.navigation.internal.hc.a aVar4) {
        this.a = caVar;
        this.b = i;
        this.c = aVar;
        this.d = aVar2;
        this.e = aVar3;
        this.f = aVar4;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.z
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.z
    public final com.google.android.libraries.navigation.internal.hc.a b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.z
    public final com.google.android.libraries.navigation.internal.hc.a c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.z
    public final com.google.android.libraries.navigation.internal.hc.a d() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.z
    public final com.google.android.libraries.navigation.internal.hc.a e() {
        return this.e;
    }

    public final boolean equals(Object obj) {
        com.google.android.libraries.navigation.internal.hc.a aVar;
        com.google.android.libraries.navigation.internal.hc.a aVar2;
        com.google.android.libraries.navigation.internal.hc.a aVar3;
        com.google.android.libraries.navigation.internal.hc.a aVar4;
        if (obj == this) {
            return true;
        }
        if (obj instanceof z) {
            z zVar = (z) obj;
            if (this.a.equals(zVar.f()) && this.b == zVar.a() && ((aVar = this.c) != null ? aVar.equals(zVar.b()) : zVar.b() == null) && ((aVar2 = this.d) != null ? aVar2.equals(zVar.c()) : zVar.c() == null) && ((aVar3 = this.e) != null ? aVar3.equals(zVar.e()) : zVar.e() == null) && ((aVar4 = this.f) != null ? aVar4.equals(zVar.d()) : zVar.d() == null)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.z
    public final ca f() {
        return this.a;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() ^ 1000003;
        com.google.android.libraries.navigation.internal.hc.a aVar = this.c;
        int iHashCode2 = ((((iHashCode * 1000003) ^ this.b) * 1000003) ^ (aVar == null ? 0 : aVar.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.hc.a aVar2 = this.d;
        int iHashCode3 = (iHashCode2 ^ (aVar2 == null ? 0 : aVar2.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.hc.a aVar3 = this.e;
        int iHashCode4 = (iHashCode3 ^ (aVar3 == null ? 0 : aVar3.hashCode())) * 1000003;
        com.google.android.libraries.navigation.internal.hc.a aVar4 = this.f;
        return iHashCode4 ^ (aVar4 != null ? aVar4.hashCode() : 0);
    }
}
