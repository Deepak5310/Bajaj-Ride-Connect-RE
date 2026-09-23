package com.google.android.libraries.navigation.internal.yz;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cn extends dh {
    final /* synthetic */ Iterator a;
    final /* synthetic */ cq b;
    private kt c;

    public cn(cq cqVar, Iterator it2) {
        this.a = it2;
        this.b = cqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dh
    protected final Iterator a() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dh, com.google.android.libraries.navigation.internal.yz.Cdo
    protected final /* synthetic */ Object aF() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dh, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        kt ktVar = (kt) super.next();
        this.c = ktVar;
        return ktVar;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.dh, java.util.Iterator
    public final void remove() {
        int i;
        com.google.android.libraries.navigation.internal.yx.ar.l(this.c != null, "no calls to next() since the last call to remove()");
        Object objB = this.c.b();
        com.google.android.libraries.navigation.internal.yx.ar.q(objB);
        bs.d(0, "count");
        cq cqVar = this.b;
        AtomicInteger atomicInteger = (AtomicInteger) kc.e(cqVar.countMap, objB);
        if (atomicInteger != null) {
            do {
                i = atomicInteger.get();
                if (i == 0) {
                }
            } while (!atomicInteger.compareAndSet(i, 0));
            cqVar.countMap.remove(objB, atomicInteger);
        }
        this.c = null;
    }
}
