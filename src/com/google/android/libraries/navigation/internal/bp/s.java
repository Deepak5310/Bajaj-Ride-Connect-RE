package com.google.android.libraries.navigation.internal.bp;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class s extends cg {
    private final com.google.android.libraries.navigation.internal.oe.r a;
    private final int b;
    private final int c;

    public s(com.google.android.libraries.navigation.internal.oe.r rVar, int i, int i2) {
        Objects.requireNonNull(rVar);
        this.a = rVar;
        this.b = i;
        this.c = i2;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cg
    public final int a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cg
    public final int b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.cg
    public final com.google.android.libraries.navigation.internal.oe.r c() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof cg) {
            cg cgVar = (cg) obj;
            if (this.a.equals(cgVar.c()) && this.b == cgVar.a() && this.c == cgVar.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c;
    }

    public final String toString() {
        return "{" + String.valueOf(this.a) + ", " + this.b + ", " + this.c + "}";
    }
}
