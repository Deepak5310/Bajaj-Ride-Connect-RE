package com.google.android.libraries.navigation.internal.tj;

import com.google.android.libraries.navigation.internal.bp.bh;
import com.google.android.libraries.navigation.internal.yx.am;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class r extends a {
    public final com.google.android.libraries.navigation.internal.si.f a;
    public final com.google.android.libraries.navigation.internal.se.b b;

    public r(com.google.android.libraries.navigation.internal.si.f fVar, com.google.android.libraries.navigation.internal.se.b bVar) {
        this.a = fVar;
        this.b = bVar;
    }

    public static final void g(bh bhVar) {
        boolean z = true;
        if (bhVar != null && !bhVar.k()) {
            z = false;
        }
        ar.a(z);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (rVar.getClass() == getClass() && am.a(this.a, rVar.a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final t j() {
        return t.NAVIGATION_POI;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final boolean m() {
        return true;
    }

    @Override // com.google.android.libraries.navigation.internal.tj.u
    public final boolean n() {
        return true;
    }
}
