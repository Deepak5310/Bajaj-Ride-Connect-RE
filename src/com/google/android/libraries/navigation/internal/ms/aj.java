package com.google.android.libraries.navigation.internal.ms;

import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aj extends ca {
    private final List b;

    public aj(List list) {
        if (list == null) {
            throw new NullPointerException("Null verbRules");
        }
        this.b = list;
    }

    @Override // com.google.android.libraries.navigation.internal.ms.ca
    public final List a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ca) {
            return this.b.equals(((ca) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "RelativeLayoutRules{verbRules=" + this.b.toString() + "}";
    }
}
