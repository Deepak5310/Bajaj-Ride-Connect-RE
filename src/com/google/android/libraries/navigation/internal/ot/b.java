package com.google.android.libraries.navigation.internal.ot;

import com.google.android.libraries.navigation.internal.adg.jr;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b extends g {
    public final jr a;

    public b(jr jrVar) {
        this.a = jrVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ot.g
    public final jr a() {
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
