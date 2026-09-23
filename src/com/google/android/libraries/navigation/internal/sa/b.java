package com.google.android.libraries.navigation.internal.sa;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class b extends f {
    private final ev a;

    public b(ev evVar) {
        this.a = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.sa.f
    public final ev a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return hx.i(this.a, ((f) obj).a());
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
