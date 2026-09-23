package com.google.android.libraries.navigation.internal.gk;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends ao {
    private final Class a;
    private final com.google.android.libraries.navigation.internal.gg.k b;

    public a(Class cls, com.google.android.libraries.navigation.internal.gg.k kVar) {
        Objects.requireNonNull(cls);
        this.a = cls;
        Objects.requireNonNull(kVar);
        this.b = kVar;
    }

    @Override // com.google.android.libraries.navigation.internal.gk.ao
    public final com.google.android.libraries.navigation.internal.gg.k a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.gk.ao
    public final Class b() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ao) {
            ao aoVar = (ao) obj;
            if (this.a.equals(aoVar.b()) && this.b.equals(aoVar.a())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode();
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.gg.k kVar = this.b;
        return "{" + String.valueOf(this.a) + ", " + String.valueOf(kVar) + "}";
    }
}
