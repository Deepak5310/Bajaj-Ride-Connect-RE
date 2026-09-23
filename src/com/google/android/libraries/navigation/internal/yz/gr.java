package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class gr extends de {
    final /* synthetic */ Iterable a;
    final /* synthetic */ int b;

    public gr(Iterable iterable, int i) {
        this.a = iterable;
        this.b = i;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Iterable iterable = this.a;
        if (iterable instanceof List) {
            List list = (List) iterable;
            return list.subList(Math.min(list.size(), this.b), list.size()).iterator();
        }
        int i = this.b;
        Iterator it2 = iterable.iterator();
        com.google.android.libraries.navigation.internal.yx.ar.q(it2);
        com.google.android.libraries.navigation.internal.yx.ar.b(i >= 0, "numberToAdvance must be nonnegative");
        for (int i2 = 0; i2 < i && it2.hasNext(); i2++) {
            it2.next();
        }
        return new gq(it2);
    }
}
