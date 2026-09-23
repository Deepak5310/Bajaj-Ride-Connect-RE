package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class de implements Iterable {
    private final com.google.android.libraries.navigation.internal.yx.an a;

    protected de() {
        this.a = com.google.android.libraries.navigation.internal.yx.a.a;
    }

    public de(Iterable iterable) {
        this.a = com.google.android.libraries.navigation.internal.yx.an.j(iterable);
    }

    public static de a(Iterable iterable, Iterable iterable2) {
        return j(iterable, iterable2);
    }

    public static de b(Iterable iterable, Iterable iterable2, Iterable iterable3, Iterable iterable4) {
        return j(iterable, iterable2, iterable3, iterable4);
    }

    public static de d(Iterable iterable) {
        return iterable instanceof de ? (de) iterable : new db(iterable, iterable);
    }

    private static de j(Iterable... iterableArr) {
        for (Iterable iterable : iterableArr) {
            com.google.android.libraries.navigation.internal.yx.ar.q(iterable);
        }
        return new dd(iterableArr);
    }

    public final de c(com.google.android.libraries.navigation.internal.yx.as asVar) {
        return d(gs.a(h(), asVar));
    }

    public final de e(com.google.android.libraries.navigation.internal.yx.aa aaVar) {
        return d(gs.b(h(), aaVar));
    }

    public final ev f() {
        return ev.n(h());
    }

    public final fd g(com.google.android.libraries.navigation.internal.yx.aa aaVar) {
        Iterable iterableH = h();
        return iterableH instanceof Collection ? kc.c(iterableH.iterator(), aaVar, fd.h(((Collection) iterableH).size())) : kc.c(iterableH.iterator(), aaVar, new ez());
    }

    public final Iterable h() {
        return (Iterable) this.a.e(this);
    }

    public final boolean i(com.google.android.libraries.navigation.internal.yx.as asVar) {
        Iterator it2 = h().iterator();
        int i = 0;
        while (it2.hasNext()) {
            if (!asVar.a(it2.next())) {
                i++;
            } else if (i != -1) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        Iterator it2 = h().iterator();
        StringBuilder sb = new StringBuilder("[");
        boolean z = true;
        while (it2.hasNext()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(it2.next());
            z = false;
        }
        sb.append(']');
        return sb.toString();
    }
}
