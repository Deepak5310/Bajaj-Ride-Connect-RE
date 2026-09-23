package com.google.android.libraries.navigation.internal.ex;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class a extends e {
    private final d b;
    private final String c;

    public a(d dVar) {
        Objects.requireNonNull(dVar);
        this.b = dVar;
        this.c = "disabled";
    }

    @Override // com.google.android.libraries.navigation.internal.ex.e
    public final d a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.ex.e
    public final String b() {
        return this.c;
    }

    @Override // com.google.android.libraries.navigation.internal.ex.e
    public final void c() {
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof e) {
            e eVar = (e) obj;
            eVar.c();
            if (this.b.equals(eVar.a()) && this.c.equals(eVar.b())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.b.hashCode() ^ (-721379959)) * 1000003) ^ this.c.hashCode();
    }

    public final String toString() {
        return "{null, " + String.valueOf(this.b) + ", " + this.c + "}";
    }
}
