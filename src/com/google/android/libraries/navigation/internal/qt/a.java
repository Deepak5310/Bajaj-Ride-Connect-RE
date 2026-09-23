package com.google.android.libraries.navigation.internal.qt;

import com.google.android.libraries.navigation.internal.vw.b;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private final Set b = new HashSet();
    public int a = 0;

    public final synchronized int a() {
        return this.a;
    }

    public final void b() {
        HashSet hashSet = new HashSet();
        synchronized (this) {
            hashSet.addAll(this.b);
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            ((b) it2.next()).a();
        }
    }

    public final synchronized void c(b bVar) {
        this.b.add(bVar);
    }

    public final synchronized void d(b bVar) {
        this.b.remove(bVar);
    }
}
