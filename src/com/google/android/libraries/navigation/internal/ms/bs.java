package com.google.android.libraries.navigation.internal.ms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bs {
    public final boolean a = true;
    public final List b = new ArrayList();

    public final void a(bu buVar) {
        com.google.android.libraries.navigation.internal.yx.ar.r(buVar, "Null item provided");
        this.b.add(buVar);
    }

    public final void b(bt btVar, cs csVar) {
        com.google.android.libraries.navigation.internal.yx.ar.r(csVar, "Null viewModel provided");
        a(ah.a(btVar, csVar));
    }

    public final void c(bt btVar, Iterable iterable) {
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            b(btVar, (cs) it2.next());
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof bs) {
            return ((bs) obj).b.equals(this.b);
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode();
    }
}
