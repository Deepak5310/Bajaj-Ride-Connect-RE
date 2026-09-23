package com.google.android.libraries.navigation.internal.rz;

import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.hx;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n extends ai {
    private final ev a;

    public n(ev evVar) {
        this.a = evVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rz.ai
    public final ev a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ai) {
            return hx.i(this.a, ((ai) obj).a());
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
