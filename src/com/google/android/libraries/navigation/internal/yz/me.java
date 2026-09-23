package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class me extends lo implements Serializable {
    private static final long serialVersionUID = 0;
    final lo a;

    public me(lo loVar) {
        this.a = loVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo
    public final lo c() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.a.compare(obj2, obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo
    public final Object e(Object obj, Object obj2) {
        return this.a.g(obj, obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof me) {
            return this.a.equals(((me) obj).a);
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo
    public final Object g(Object obj, Object obj2) {
        return this.a.e(obj, obj2);
    }

    public final int hashCode() {
        return -this.a.hashCode();
    }

    public final String toString() {
        return String.valueOf(String.valueOf(this.a)).concat(".reverse()");
    }
}
