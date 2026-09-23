package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class mi extends i {
    final Iterator a;
    final Iterator b;
    final /* synthetic */ Set c;
    final /* synthetic */ Set d;

    public mi(Set set, Set set2) {
        this.c = set;
        this.d = set2;
        this.a = set.iterator();
        this.b = set2.iterator();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.i
    protected final Object a() {
        if (this.a.hasNext()) {
            return this.a.next();
        }
        while (this.b.hasNext()) {
            Iterator it2 = this.b;
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
