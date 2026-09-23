package com.google.android.libraries.navigation.internal.vd;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.ace.oc;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.iv.ab;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public final com.google.android.libraries.navigation.internal.iv.f a;
    public final com.google.android.libraries.navigation.internal.mj.a b;
    public boolean c = false;
    public final PriorityQueue d;
    public ScheduledFuture e;
    private final com.google.android.libraries.navigation.internal.ia.e f;
    private final bn g;
    private final long h;
    private final long i;
    private final long j;

    public e(com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.ia.e eVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.fz.d dVar, bn bnVar) {
        PriorityQueue priorityQueue = new PriorityQueue();
        this.d = priorityQueue;
        this.e = null;
        oc ocVarE = dVar.x().e();
        this.b = aVar;
        this.f = eVar;
        this.a = fVar;
        long j = ocVarE.c;
        this.i = j;
        this.j = ocVarE.d;
        this.g = bnVar;
        long j2 = ocVarE.b;
        if (j2 >= j) {
            this.h = j2;
        } else {
            this.h = j;
        }
        com.google.android.libraries.navigation.internal.vh.b bVar = (com.google.android.libraries.navigation.internal.vh.b) fVar.f(ab.bK, (dg) com.google.android.libraries.navigation.internal.vh.b.a.aH(7, null), com.google.android.libraries.navigation.internal.vh.b.a);
        priorityQueue.clear();
        priorityQueue.addAll(bVar.b);
        while (this.d.size() > this.j) {
            this.d.poll();
        }
        long jA = this.b.a();
        Iterator it2 = this.d.iterator();
        if (!it2.hasNext() || jA >= ((Long) it2.next()).longValue()) {
            b(jA);
        } else {
            this.d.clear();
        }
    }

    public final synchronized long a(long j) {
        Iterator it2 = this.d.iterator();
        while (this.d.size() >= this.j) {
            long jLongValue = (((Long) it2.next()).longValue() + this.h) - j;
            if (jLongValue > 0) {
                return jLongValue;
            }
            it2.remove();
        }
        return 0L;
    }

    public final synchronized void b(long j) {
        long jA = a(j);
        boolean z = jA > 0;
        if (z == this.c) {
            if (!z) {
            }
        }
        this.c = z;
        this.f.a(new com.google.android.libraries.navigation.internal.ve.c(z));
        if (z) {
            ScheduledFuture scheduledFuture = this.e;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.e = this.g.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.vd.d
                @Override // java.lang.Runnable
                public final void run() {
                    e eVar = this.a;
                    eVar.e = null;
                    eVar.b(eVar.b.a());
                }
            }, jA, TimeUnit.MILLISECONDS);
            return;
        }
        Iterator it2 = this.d.iterator();
        while (it2.hasNext() && j >= ((Long) it2.next()).longValue() + this.i) {
            it2.remove();
        }
    }
}
