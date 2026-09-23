package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class ar implements lu {
    @Override // com.google.android.libraries.navigation.internal.yz.lu
    public void a(lr lrVar) {
        throw null;
    }

    public final void b(Iterable iterable) {
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            a((lr) it2.next());
        }
    }

    public void c(lr lrVar) {
        throw null;
    }

    public final void d(Iterable iterable) {
        Iterator it2 = iterable.iterator();
        while (it2.hasNext()) {
            c((lr) it2.next());
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof lu) {
            return e().equals(((lu) obj).e());
        }
        return false;
    }

    public final int hashCode() {
        return e().hashCode();
    }

    public final String toString() {
        return e().toString();
    }
}
