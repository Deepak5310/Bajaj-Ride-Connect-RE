package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class mk extends i {
    final Iterator a;
    final /* synthetic */ Set b;
    final /* synthetic */ Set c;

    public mk(Set set, Set set2) {
        this.b = set;
        this.c = set2;
        this.a = set.iterator();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.i
    protected final Object a() {
        while (this.a.hasNext()) {
            Iterator it2 = this.a;
            Set set = this.c;
            Object next = it2.next();
            if (!set.contains(next)) {
                return next;
            }
        }
        b();
        return null;
    }
}
