package com.google.android.libraries.navigation.internal.sa;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d extends h {
    public final ev a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;

    public d(ev evVar, String str, String str2, String str3, String str4) {
        this.a = evVar;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
    }

    @Override // com.google.android.libraries.navigation.internal.sa.h
    public final ev a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.sa.h
    public final String b() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.sa.h
    public final String c() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.sa.h
    public final String d() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.sa.h
    public final String e() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            if (hx.i(this.a, hVar.a()) && this.b.equals(hVar.e()) && this.c.equals(hVar.d()) && this.d.equals(hVar.c()) && this.e.equals(hVar.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e.hashCode();
    }

    public final String toString() {
        return "{" + String.valueOf(this.a) + ", " + this.b + ", " + this.c + ", " + this.d + ", " + this.e + "}";
    }
}
