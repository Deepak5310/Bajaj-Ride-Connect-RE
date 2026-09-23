package com.google.android.libraries.navigation.internal.b;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class w {
    public final c d;
    public final l e;
    public final aa f;
    public e h;
    private final AtomicInteger j = new AtomicInteger();
    public final Set a = new HashSet();
    public final PriorityBlockingQueue b = new PriorityBlockingQueue();
    public final PriorityBlockingQueue c = new PriorityBlockingQueue();
    public final List i = new ArrayList();
    private final List k = new ArrayList();
    public final m[] g = new m[4];

    public w(c cVar, l lVar, aa aaVar) {
        this.d = cVar;
        this.e = lVar;
        this.f = aaVar;
    }

    public t a(t tVar) {
        tVar.h = this;
        synchronized (this.a) {
            this.a.add(tVar);
        }
        tVar.g = Integer.valueOf(this.j.incrementAndGet());
        tVar.f("add-to-queue");
        b(tVar, 0);
        if (tVar.i) {
            this.b.add(tVar);
        } else {
            this.c.add(tVar);
        }
        return tVar;
    }

    final void b(t tVar, int i) {
        synchronized (this.k) {
            Iterator it2 = this.k.iterator();
            while (it2.hasNext()) {
                ((u) it2.next()).a();
            }
        }
    }
}
