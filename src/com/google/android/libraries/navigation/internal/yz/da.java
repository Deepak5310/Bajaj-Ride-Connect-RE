package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class da extends lo implements Serializable {
    private static final long serialVersionUID = 0;
    final fd a;

    public da(fd fdVar) {
        this.a = fdVar;
    }

    private final int h(Object obj) {
        Integer num = (Integer) this.a.get(obj);
        if (num != null) {
            return num.intValue();
        }
        throw new ln(obj);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return h(obj) - h(obj2);
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj instanceof da) {
            return kc.k(this.a, ((da) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Ordering.explicit(" + String.valueOf(this.a.keySet()) + ")";
    }
}
