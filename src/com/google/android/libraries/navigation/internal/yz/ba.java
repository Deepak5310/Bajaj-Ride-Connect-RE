package com.google.android.libraries.navigation.internal.yz;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ba extends lo implements Serializable {
    private static final long serialVersionUID = 0;
    final com.google.android.libraries.navigation.internal.yx.aa a;
    final lo b;

    public ba(com.google.android.libraries.navigation.internal.yx.aa aaVar, lo loVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(aaVar);
        this.a = aaVar;
        this.b = loVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.lo, java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        com.google.android.libraries.navigation.internal.yx.aa aaVar = this.a;
        return this.b.compare(aaVar.ak(obj), aaVar.ak(obj2));
    }

    @Override // java.util.Comparator
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ba) {
            ba baVar = (ba) obj;
            if (this.a.equals(baVar.a) && this.b.equals(baVar.b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.a, this.b});
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.aa aaVar = this.a;
        return String.valueOf(this.b) + ".onResultOf(" + String.valueOf(aaVar) + ")";
    }
}
