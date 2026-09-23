package com.google.android.libraries.navigation.internal.agb;

import com.google.android.libraries.navigation.internal.afx.aq;
import com.google.android.libraries.navigation.internal.afx.ar;
import com.google.android.libraries.navigation.internal.afx.as;
import com.google.android.libraries.navigation.internal.afx.ax;
import com.google.android.libraries.navigation.internal.afx.r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j extends f {
    private final AtomicInteger l;
    private ax m;

    public j(ar arVar) {
        super(arVar);
        this.l = new AtomicInteger(new Random().nextInt());
        this.m = new aq(as.a);
    }

    private final ax h(Collection collection) {
        ArrayList arrayList = new ArrayList();
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(((d) it2.next()).d);
        }
        return new i(arrayList, this.l);
    }

    private final void i(r rVar, ax axVar) {
        if (rVar == this.k && axVar.equals(this.m)) {
            return;
        }
        this.h.f(rVar, axVar);
        this.k = rVar;
        this.m = axVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agb.f
    protected final d f(Object obj) {
        return new h(this, obj, this.j);
    }

    @Override // com.google.android.libraries.navigation.internal.agb.f
    protected final void g() {
        ArrayList arrayList = new ArrayList();
        for (d dVar : this.g) {
            if (dVar.c == r.READY) {
                arrayList.add(dVar);
            }
        }
        if (!arrayList.isEmpty()) {
            i(r.READY, h(arrayList));
            return;
        }
        Iterator it2 = this.g.iterator();
        while (it2.hasNext()) {
            r rVar = ((d) it2.next()).c;
            if (rVar == r.CONNECTING || rVar == r.IDLE) {
                i(r.CONNECTING, new aq(as.a));
                return;
            }
        }
        i(r.TRANSIENT_FAILURE, h(this.g));
    }
}
