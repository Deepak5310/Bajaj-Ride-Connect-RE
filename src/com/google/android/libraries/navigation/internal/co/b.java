package com.google.android.libraries.navigation.internal.co;

import com.google.android.libraries.navigation.internal.adr.el;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends h {
    public final int a;
    public final int b;
    public final String c;
    public final el d;
    public final String e;
    public final String f;
    public final String g;
    public final boolean h;
    public final com.google.android.libraries.navigation.internal.afd.a i;

    public b(int i, int i2, String str, el elVar, com.google.android.libraries.navigation.internal.afd.a aVar, String str2, String str3, String str4, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = str;
        this.d = elVar;
        this.i = aVar;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = z;
    }

    @Override // com.google.android.libraries.navigation.internal.co.h
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.co.h
    public final int b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.co.h
    public final el c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.co.h
    public final String d() {
        return this.g;
    }

    @Override // com.google.android.libraries.navigation.internal.co.h
    public final String e() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (this.a == hVar.b() && this.b == hVar.a() && this.c.equals(hVar.f()) && this.d.equals(hVar.c()) && this.i.equals(hVar.i()) && ((str = this.e) != null ? str.equals(hVar.g()) : hVar.g() == null) && ((str2 = this.f) != null ? str2.equals(hVar.e()) : hVar.e() == null) && ((str3 = this.g) != null ? str3.equals(hVar.d()) : hVar.d() == null) && this.h == hVar.h()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.co.h
    public final String f() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.co.h
    public final String g() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.co.h
    public final boolean h() {
        return this.h;
    }

    @Override // com.google.android.libraries.navigation.internal.co.h
    public final com.google.android.libraries.navigation.internal.afd.a i() {
        return this.i;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.afd.a aVar = this.i;
        return "{" + this.a + ", " + this.b + ", " + this.c + ", " + String.valueOf(this.d) + ", " + String.valueOf(aVar) + ", " + this.e + ", " + this.f + ", " + this.g + ", " + this.h + "}";
    }

    public final int hashCode() {
        int iN;
        int iHashCode = ((((this.a ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode();
        el elVar = this.d;
        if (elVar.H()) {
            iN = elVar.n();
        } else {
            int iN2 = elVar.ak;
            if (iN2 == 0) {
                iN2 = elVar.n();
                elVar.ak = iN2;
            }
            iN = iN2;
        }
        int iHashCode2 = ((((iHashCode * 1000003) ^ iN) * 1000003) ^ this.i.hashCode()) * 1000003;
        String str = this.e;
        int iHashCode3 = (iHashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.f;
        int iHashCode4 = (iHashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.g;
        return ((iHashCode4 ^ (str3 != null ? str3.hashCode() : 0)) * 1000003) ^ (true != this.h ? 1237 : 1231);
    }
}
