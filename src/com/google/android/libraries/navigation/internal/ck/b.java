package com.google.android.libraries.navigation.internal.ck;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends v {
    private final com.google.android.libraries.navigation.internal.bp.ap a;
    private final boolean b;
    private final com.google.android.libraries.navigation.internal.aap.l c;

    public b(com.google.android.libraries.navigation.internal.bp.ap apVar, boolean z, com.google.android.libraries.navigation.internal.aap.l lVar) {
        Objects.requireNonNull(apVar);
        this.a = apVar;
        this.b = z;
        Objects.requireNonNull(lVar);
        this.c = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.v
    public final com.google.android.libraries.navigation.internal.bp.ap a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.v
    public final com.google.android.libraries.navigation.internal.aap.l b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.ck.v
    public final boolean c() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof v) {
            v vVar = (v) obj;
            if (this.a.equals(vVar.a()) && this.b == vVar.c() && this.c.equals(vVar.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ (true != this.b ? 1237 : 1231)) * 1000003) ^ this.c.hashCode();
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.aap.l lVar = this.c;
        return "{" + String.valueOf(this.a) + ", " + this.b + ", " + String.valueOf(lVar) + "}";
    }
}
