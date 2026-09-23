package com.google.android.libraries.navigation.internal.bt;

import java.util.EnumSet;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class c extends g {
    private final EnumSet a;

    public c(EnumSet enumSet) {
        Objects.requireNonNull(enumSet);
        this.a = enumSet;
    }

    @Override // com.google.android.libraries.navigation.internal.bt.g
    public final EnumSet a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            return this.a.equals(((g) obj).a());
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
