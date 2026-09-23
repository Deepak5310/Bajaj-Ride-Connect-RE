package com.google.android.libraries.navigation.internal.bp;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class g extends b {
    public final ev b;

    public g(ev evVar) {
        Objects.requireNonNull(evVar);
        this.b = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.bp.b
    public final ev a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            return hx.i(this.b, ((b) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "{" + String.valueOf(this.b) + "}";
    }
}
