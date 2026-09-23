package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class lg extends lo implements Serializable {
    public static final lg a = new lg();
    private static final long serialVersionUID = 0;
    private transient lo b;
    private transient lo c;

    private lg() {
    }

    private Object readResolve() {
        return a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo
    public final lo aw() {
        lo loVar = this.b;
        if (loVar != null) {
            return loVar;
        }
        lh lhVar = new lh(this);
        this.b = lhVar;
        return lhVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo
    public final lo b() {
        lo loVar = this.c;
        if (loVar != null) {
            return loVar;
        }
        li liVar = new li(this);
        this.c = liVar;
        return liVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo
    public final lo c() {
        return md.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo, java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        com.google.android.libraries.navigation.internal.yx.ar.q(comparable);
        com.google.android.libraries.navigation.internal.yx.ar.q(comparable2);
        return comparable.compareTo(comparable2);
    }

    public final String toString() {
        return "Ordering.natural()";
    }
}
