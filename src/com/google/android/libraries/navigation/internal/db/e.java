package com.google.android.libraries.navigation.internal.db;

import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e extends f {
    public final com.google.android.libraries.navigation.internal.abc.a a;

    public e(com.google.android.libraries.navigation.internal.abc.a aVar) {
        Objects.requireNonNull(aVar);
        this.a = aVar;
    }

    @Override // com.google.android.libraries.navigation.internal.db.f
    public final com.google.android.libraries.navigation.internal.abc.a a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return this.a.equals(((f) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "{" + String.valueOf(this.a) + "}";
    }
}
