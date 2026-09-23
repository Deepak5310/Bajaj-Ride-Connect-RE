package com.google.android.libraries.navigation.internal.ky;

import com.google.android.libraries.navigation.internal.ael.cy;
import com.google.android.libraries.navigation.internal.lh.be;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ah {
    final cy a;

    public ah() {
        this.a = null;
    }

    private ah(cy cyVar) {
        this.a = cyVar;
    }

    public static ah a(cy cyVar) {
        return (cyVar == null || cyVar == com.google.android.libraries.navigation.internal.ael.ao.a) ? ap.b : new ah(cyVar);
    }

    public final boolean equals(Object obj) {
        cy cyVar;
        if (this == obj) {
            return true;
        }
        return (obj instanceof ah) && (cyVar = this.a) != null && cyVar.equals(((ah) obj).a);
    }

    public final int hashCode() {
        be.f(!ap.c.equals(this));
        if (ap.b.equals(this)) {
            return 0;
        }
        cy cyVar = this.a;
        be.j(cyVar);
        return cyVar.hashCode();
    }

    public final String toString() {
        if (ap.c.equals(this)) {
            return "$use_sticky_dims$";
        }
        if (ap.b.equals(this)) {
            return "$no_dims$";
        }
        cy cyVar = this.a;
        be.j(cyVar);
        return cyVar.toString();
    }
}
