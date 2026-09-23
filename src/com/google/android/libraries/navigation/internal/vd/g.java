package com.google.android.libraries.navigation.internal.vd;

import com.google.android.libraries.navigation.internal.ace.mw;
import com.google.android.libraries.navigation.internal.ael.dg;
import com.google.android.libraries.navigation.internal.iv.ab;
import com.google.android.libraries.navigation.internal.iv.w;
import j$.time.Duration;
import j$.time.Instant;
import java.util.Iterator;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class g {
    private final com.google.android.libraries.navigation.internal.iv.f a;
    private final com.google.android.libraries.navigation.internal.mj.a b;
    private final Duration c;
    private final int d;
    private final PriorityQueue e;
    private final e f;
    private final boolean g;

    public g(com.google.android.libraries.navigation.internal.iv.f fVar, com.google.android.libraries.navigation.internal.mj.a aVar, com.google.android.libraries.navigation.internal.hn.r rVar, e eVar) {
        PriorityQueue priorityQueue = new PriorityQueue();
        this.e = priorityQueue;
        this.b = aVar;
        this.a = fVar;
        this.c = Duration.ofMillis(((mw) rVar.b()).i);
        this.d = ((mw) rVar.b()).h;
        this.f = eVar;
        boolean z = ((mw) rVar.b()).g;
        this.g = z;
        if (z) {
            com.google.android.libraries.navigation.internal.vh.b bVar = (com.google.android.libraries.navigation.internal.vh.b) fVar.f(ab.bK, (dg) com.google.android.libraries.navigation.internal.vh.b.a.aH(7, null), com.google.android.libraries.navigation.internal.vh.b.a);
            priorityQueue.clear();
            priorityQueue.addAll(bVar.b);
        }
    }

    private final void c() {
        PriorityQueue priorityQueue = this.e;
        Instant instantF = this.b.f();
        Iterator it2 = priorityQueue.iterator();
        while (it2.hasNext() && !instantF.isBefore(Instant.ofEpochMilli(((Long) it2.next()).longValue()).plus(this.c))) {
            it2.remove();
        }
    }

    public final boolean a() {
        if (this.g) {
            c();
            PriorityQueue priorityQueue = this.e;
            if (priorityQueue.size() >= this.d) {
                return false;
            }
            this.e.add(Long.valueOf(this.b.f().toEpochMilli()));
            com.google.android.libraries.navigation.internal.iv.f fVar = this.a;
            w wVar = ab.bK;
            com.google.android.libraries.navigation.internal.vh.a aVar = (com.google.android.libraries.navigation.internal.vh.a) com.google.android.libraries.navigation.internal.vh.b.a.q();
            aVar.a(this.e);
            fVar.s(wVar, aVar.t());
            return true;
        }
        e eVar = this.f;
        long jA = eVar.b.a();
        if (eVar.a(jA) > 0) {
            return false;
        }
        eVar.d.add(Long.valueOf(jA));
        eVar.b(jA);
        com.google.android.libraries.navigation.internal.iv.f fVar2 = eVar.a;
        w wVar2 = ab.bK;
        com.google.android.libraries.navigation.internal.vh.a aVar2 = (com.google.android.libraries.navigation.internal.vh.a) com.google.android.libraries.navigation.internal.vh.b.a.q();
        aVar2.a(eVar.d);
        fVar2.s(wVar2, aVar2.t());
        return true;
    }

    public final boolean b() {
        if (!this.g) {
            return this.f.c;
        }
        c();
        return this.e.size() >= this.d;
    }
}
