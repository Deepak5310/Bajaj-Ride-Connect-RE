package com.google.android.libraries.navigation.internal.yz;

import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class lo implements Comparator {
    protected lo() {
    }

    public lo aw() {
        return new lh(this);
    }

    public lo b() {
        return new li(this);
    }

    public lo c() {
        return new me(this);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public final Object d(Iterator it2) {
        Object next = it2.next();
        while (it2.hasNext()) {
            next = e(next, it2.next());
        }
        return next;
    }

    public Object e(Object obj, Object obj2) {
        return compare(obj, obj2) >= 0 ? obj : obj2;
    }

    public final Object f(Iterator it2) {
        Object next = it2.next();
        while (it2.hasNext()) {
            next = g(next, it2.next());
        }
        return next;
    }

    public Object g(Object obj, Object obj2) {
        return compare(obj, obj2) <= 0 ? obj : obj2;
    }
}
