package com.google.android.libraries.navigation.internal.jb;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends g {
    public final com.google.android.libraries.navigation.internal.jc.b a;
    public final String b;
    private final int c;
    private final int d;
    private final int e;
    private final String f;

    public a(int i, int i2, int i3, String str, com.google.android.libraries.navigation.internal.jc.b bVar, String str2) {
        this.c = i;
        this.d = i2;
        this.e = i3;
        Objects.requireNonNull(str);
        this.f = str;
        Objects.requireNonNull(bVar);
        this.a = bVar;
        Objects.requireNonNull(str2);
        this.b = str2;
    }

    @Override // com.google.android.libraries.navigation.internal.jb.g
    public final int a() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.jb.g
    public final int b() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.jb.g
    public final int c() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.jb.g
    public final com.google.android.libraries.navigation.internal.jc.b d() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.jb.g
    public final String e() {
        return this.f;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            if (this.c == gVar.a() && this.d == gVar.b() && this.e == gVar.c() && this.f.equals(gVar.e()) && this.a.equals(gVar.d()) && this.b.equals(gVar.f())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.jb.g
    public final String f() {
        return this.b;
    }

    public final int hashCode() {
        return ((((((((((this.c ^ 1000003) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.a.hashCode()) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        return "{" + this.c + ", " + this.d + ", " + this.e + ", " + this.f + ", " + this.a.toString() + ", " + this.b + "}";
    }
}
