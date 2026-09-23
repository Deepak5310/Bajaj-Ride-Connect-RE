package com.google.android.libraries.navigation.internal.agb;

import com.google.android.libraries.navigation.internal.afx.z;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    final Collection a;
    final int b;

    public e(z zVar) {
        ar.r(zVar, "eag");
        if (zVar.b.size() < 10) {
            this.a = zVar.b;
        } else {
            this.a = new HashSet(zVar.b);
        }
        Iterator it2 = zVar.b.iterator();
        int iHashCode = 0;
        while (it2.hasNext()) {
            iHashCode += ((SocketAddress) it2.next()).hashCode();
        }
        this.b = iHashCode;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (eVar.b == this.b && eVar.a.size() == this.a.size()) {
            return eVar.a.containsAll(this.a);
        }
        return false;
    }

    public final int hashCode() {
        return this.b;
    }

    public final String toString() {
        return this.a.toString();
    }
}
