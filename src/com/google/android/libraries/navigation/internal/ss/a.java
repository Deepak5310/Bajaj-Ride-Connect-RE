package com.google.android.libraries.navigation.internal.ss;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends d {
    private final ev a;

    public a(ev evVar) {
        Objects.requireNonNull(evVar);
        this.a = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ss.d
    public final ev c() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            return hx.i(this.a, ((d) obj).c());
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
