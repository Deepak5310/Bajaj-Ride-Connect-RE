package com.google.android.libraries.navigation.internal.rd;

import com.google.android.libraries.navigation.internal.yz.gi;
import com.google.android.libraries.navigation.internal.yz.kc;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends d {
    private final gi a;

    public a(gi giVar) {
        Objects.requireNonNull(giVar);
        this.a = giVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rd.d
    public final gi a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return kc.k(this.a, ((d) obj).a());
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
