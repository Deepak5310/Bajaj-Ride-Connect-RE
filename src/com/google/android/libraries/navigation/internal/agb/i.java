package com.google.android.libraries.navigation.internal.agb;

import com.google.android.libraries.navigation.internal.afx.ax;
import com.google.android.libraries.navigation.internal.yx.ak;
import com.google.android.libraries.navigation.internal.yx.al;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class i extends ax {
    private final List a;
    private final AtomicInteger b;
    private final int c;

    public i(List list, AtomicInteger atomicInteger) {
        ar.b(!list.isEmpty(), "empty list");
        this.a = list;
        this.b = atomicInteger;
        Iterator it2 = list.iterator();
        int iHashCode = 0;
        while (it2.hasNext()) {
            iHashCode += ((ax) it2.next()).hashCode();
        }
        this.c = iHashCode;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (iVar == this) {
            return true;
        }
        return this.c == iVar.c && this.b == iVar.b && this.a.size() == iVar.a.size() && new HashSet(this.a).containsAll(iVar.a);
    }

    public final int hashCode() {
        return this.c;
    }

    public final String toString() {
        ak akVarA = al.a(i.class);
        akVarA.g("subchannelPickers", this.a);
        return akVarA.toString();
    }
}
