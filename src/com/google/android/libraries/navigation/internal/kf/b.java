package com.google.android.libraries.navigation.internal.kf;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends w {
    public final com.google.android.libraries.navigation.internal.hj.i a;
    public final int b;
    public final String c;
    public final String d;
    public final Integer e;
    public final com.google.android.libraries.navigation.internal.jy.j f;

    public b(com.google.android.libraries.navigation.internal.hj.i iVar, int i, String str, String str2, Integer num, com.google.android.libraries.navigation.internal.jy.j jVar) {
        Objects.requireNonNull(iVar);
        this.a = iVar;
        this.b = i;
        Objects.requireNonNull(str);
        this.c = str;
        this.d = str2;
        this.e = num;
        Objects.requireNonNull(jVar);
        this.f = jVar;
    }

    @Override // com.google.android.libraries.navigation.internal.kf.w
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.kf.w
    public final com.google.android.libraries.navigation.internal.hj.i b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.kf.w
    public final com.google.android.libraries.navigation.internal.jy.j c() {
        return this.f;
    }

    @Override // com.google.android.libraries.navigation.internal.kf.w
    public final Integer d() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.kf.w
    public final String e() {
        return this.c;
    }

    public final boolean equals(Object obj) {
        String str;
        Integer num;
        if (obj == this) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            if (this.a.equals(wVar.b()) && this.b == wVar.a() && this.c.equals(wVar.e()) && ((str = this.d) != null ? str.equals(wVar.f()) : wVar.f() == null) && ((num = this.e) != null ? num.equals(wVar.d()) : wVar.d() == null) && this.f.equals(wVar.c())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.kf.w
    public final String f() {
        return this.d;
    }

    public final int hashCode() {
        int iHashCode = ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode();
        String str = this.d;
        int iHashCode2 = ((iHashCode * 1000003) ^ (str == null ? 0 : str.hashCode())) * 1000003;
        Integer num = this.e;
        return ((iHashCode2 ^ (num != null ? num.hashCode() : 0)) * 1000003) ^ this.f.hashCode();
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.jy.j jVar = this.f;
        return "{" + String.valueOf(this.a) + ", " + this.b + ", " + this.c + ", " + this.d + ", " + this.e + ", " + jVar.toString() + "}";
    }
}
