package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class md extends lo implements Serializable {
    public static final md a = new md();
    private static final long serialVersionUID = 0;

    private md() {
    }

    private Object readResolve() {
        return a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo
    public final lo c() {
        return lg.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo, java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        com.google.android.libraries.navigation.internal.yx.ar.q(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo
    public final /* bridge */ /* synthetic */ Object e(Object obj, Object obj2) {
        return (Comparable) lg.a.g((Comparable) obj, (Comparable) obj2);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo
    public final /* bridge */ /* synthetic */ Object g(Object obj, Object obj2) {
        return (Comparable) lg.a.e((Comparable) obj, (Comparable) obj2);
    }

    public final String toString() {
        return "Ordering.natural().reverse()";
    }
}
