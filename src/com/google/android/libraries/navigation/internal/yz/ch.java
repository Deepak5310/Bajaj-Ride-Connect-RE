package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ch extends lo implements Serializable {
    private static final long serialVersionUID = 0;
    final Comparator a;

    public ch(Comparator comparator) {
        com.google.android.libraries.navigation.internal.yx.ar.q(comparator);
        this.a = comparator;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ch) {
            return this.a.equals(((ch) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return this.a.toString();
    }
}
