package com.google.android.libraries.navigation.internal.bp;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class l extends ap {
    private final String a;
    private final com.google.android.libraries.navigation.internal.oe.j b;
    private final com.google.android.libraries.navigation.internal.oe.x c;
    private final int d;
    private final int e;

    public l(String str, com.google.android.libraries.navigation.internal.oe.j jVar, com.google.android.libraries.navigation.internal.oe.x xVar, int i, int i2) {
        Objects.requireNonNull(str);
        this.a = str;
        Objects.requireNonNull(jVar);
        this.b = jVar;
        Objects.requireNonNull(xVar);
        this.c = xVar;
        this.d = i;
        this.e = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.ap
    public final int a() {
        return this.d;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.ap
    public final int b() {
        return this.e;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.ap
    public final com.google.android.libraries.navigation.internal.oe.j c() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.ap
    public final com.google.android.libraries.navigation.internal.oe.x d() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.ap
    public final String e() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ap) {
            ap apVar = (ap) obj;
            if (this.a.equals(apVar.e()) && this.b.equals(apVar.c()) && this.c.equals(apVar.d()) && this.d == apVar.a() && this.e == apVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d) * 1000003) ^ this.e;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.oe.x xVar = this.c;
        return "{" + this.a + ", " + this.b.f() + ", " + xVar.toString() + ", " + this.d + ", " + this.e + "}";
    }
}
