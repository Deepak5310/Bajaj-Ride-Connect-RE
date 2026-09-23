package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class lh extends lo implements Serializable {
    private static final long serialVersionUID = 0;
    final lo a;

    public lh(lo loVar) {
        this.a = loVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo
    public final lo aw() {
        return this;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo
    public final lo b() {
        return this.a.b();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo
    public final lo c() {
        return this.a.c().b();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        if (obj2 == null) {
            return 1;
        }
        return this.a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof lh) {
            return this.a.equals(((lh) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() ^ 957692532;
    }

    public final String toString() {
        return this.a.toString().concat(".nullsFirst()");
    }
}
