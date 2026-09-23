package com.google.android.libraries.navigation.internal.yy;

import com.google.android.libraries.navigation.internal.aac.ck;
import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ao extends ReentrantLock {
    final bi a;
    volatile int b;
    long c;
    int d;
    int e;
    volatile AtomicReferenceArray f;
    final long g;
    final ReferenceQueue h;
    final ReferenceQueue i;
    final Queue j;
    final AtomicInteger k = new AtomicInteger();
    final Queue l;
    final Queue m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final a f657n;

    public ao(bi biVar, int i, long j, a aVar) {
        this.a = biVar;
        this.g = j;
        com.google.android.libraries.navigation.internal.yx.ar.q(aVar);
        this.f657n = aVar;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i);
        this.e = (atomicReferenceArray.length() * 3) / 4;
        if (!biVar.h()) {
            int i2 = this.e;
            if (i2 == j) {
                this.e = i2 + 1;
            }
        }
        this.f = atomicReferenceArray;
        this.h = biVar.o() ? new ReferenceQueue() : null;
        this.i = biVar.p() ? new ReferenceQueue() : null;
        this.j = biVar.n() ? new ConcurrentLinkedQueue() : bi.c;
        this.l = biVar.k() ? new bg() : bi.c;
        this.m = biVar.n() ? new t() : bi.c;
    }

    static final Object A(Object obj) {
        return obj;
    }

    final bj a(bj bjVar, bj bjVar2) {
        Object objJ = bjVar.j();
        if (objJ == null) {
            return null;
        }
        ax axVarD = bjVar.d();
        Object obj = axVarD.get();
        if (obj == null && axVarD.f()) {
            return null;
        }
        bj bjVarA = this.a.r.a(this, bjVar, bjVar2, objJ);
        bjVarA.p(axVarD.b(this.i, obj, bjVarA));
        return bjVarA;
    }

    final bj b(Object obj, int i) {
        AtomicReferenceArray atomicReferenceArray = this.f;
        for (bj bjVarE = (bj) atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i); bjVarE != null; bjVarE = bjVarE.e()) {
            if (bjVarE.a() == i) {
                Object objJ = bjVarE.j();
                if (objJ == null) {
                    w();
                } else if (this.a.h.d(obj, objJ)) {
                    return bjVarE;
                }
            }
        }
        return null;
    }

    final bj c(Object obj, int i, long j) {
        bj bjVarB = b(obj, i);
        if (bjVarB == null) {
            return null;
        }
        if (!this.a.l(bjVarB, j)) {
            return bjVarB;
        }
        x(j);
        return null;
    }

    final bj d(Object obj, int i, bj bjVar) {
        aa aaVar = this.a.r;
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        return aaVar.b(this, obj, i, bjVar);
    }

    final bj e(bj bjVar, bj bjVar2) {
        int i = this.b;
        bj bjVarE = bjVar2.e();
        while (bjVar != bjVar2) {
            bj bjVarA = a(bjVar, bjVarE);
            if (bjVarA != null) {
                bjVarE = bjVarA;
            } else {
                s(bjVar);
                i--;
            }
            bjVar = bjVar.e();
        }
        this.b = i;
        return bjVarE;
    }

    final bj f(bj bjVar, bj bjVar2, Object obj, int i, Object obj2, ax axVar, bk bkVar) {
        z(obj, obj2, axVar.a(), bkVar);
        this.l.remove(bjVar2);
        this.m.remove(bjVar2);
        if (!axVar.g()) {
            return e(bjVar, bjVar2);
        }
        axVar.e(null);
        return bjVar;
    }

    final Object g(Object obj, int i, ai aiVar, com.google.android.libraries.navigation.internal.aac.bj bjVar) throws Throwable {
        Object obj2 = null;
        try {
            Object objA = ck.a(bjVar);
            try {
                if (objA == null) {
                    throw new i(com.google.android.libraries.navigation.internal.b.b.e(obj, "CacheLoader returned null for key ", "."));
                }
                a aVar = this.f657n;
                aiVar.h();
                aVar.d();
                lock();
                try {
                    long jA = this.a.q.a();
                    t(jA);
                    int i2 = this.b + 1;
                    if (i2 > this.e) {
                        n();
                        i2 = this.b + 1;
                    }
                    AtomicReferenceArray atomicReferenceArray = this.f;
                    int length = i & (atomicReferenceArray.length() - 1);
                    bj bjVar2 = (bj) atomicReferenceArray.get(length);
                    for (bj bjVarE = bjVar2; bjVarE != null; bjVarE = bjVarE.e()) {
                        Object objJ = bjVarE.j();
                        if (bjVarE.a() == i && objJ != null && this.a.h.d(obj, objJ)) {
                            ax axVarD = bjVarE.d();
                            Object obj3 = axVarD.get();
                            if (aiVar != axVarD) {
                                if (obj3 != null || axVarD == bi.b) {
                                    z(obj, objA, 0, bk.REPLACED);
                                    unlock();
                                }
                                return objA;
                            }
                            obj2 = obj3;
                            this.d++;
                            if (aiVar.f()) {
                                z(obj, obj2, aiVar.a(), obj2 == null ? bk.COLLECTED : bk.REPLACED);
                                i2--;
                            }
                            v(bjVarE, obj, objA, jA);
                            this.b = i2;
                            m(bjVarE);
                            unlock();
                            return objA;
                        }
                    }
                    this.d++;
                    bj bjVarD = d(obj, i, bjVar2);
                    v(bjVarD, obj, objA, jA);
                    atomicReferenceArray.set(length, bjVarD);
                    this.b = i2;
                    m(bjVarD);
                    unlock();
                    return objA;
                } finally {
                    unlock();
                    u();
                }
            } catch (Throwable th) {
                th = th;
                obj2 = objA;
                if (obj2 == null) {
                    a aVar2 = this.f657n;
                    aiVar.h();
                    aVar2.c();
                    lock();
                    try {
                        AtomicReferenceArray atomicReferenceArray2 = this.f;
                        int length2 = (atomicReferenceArray2.length() - 1) & i;
                        bj bjVar3 = (bj) atomicReferenceArray2.get(length2);
                        for (bj bjVarE2 = bjVar3; bjVarE2 != null; bjVarE2 = bjVarE2.e()) {
                            Object objJ2 = bjVarE2.j();
                            if (bjVarE2.a() == i && objJ2 != null && this.a.h.d(obj, objJ2)) {
                                if (bjVarE2.d() != aiVar) {
                                    break;
                                }
                                if (!aiVar.f()) {
                                    atomicReferenceArray2.set(length2, e(bjVar3, bjVarE2));
                                    break;
                                }
                                bjVarE2.p(aiVar.a);
                                break;
                            }
                        }
                    } finally {
                        unlock();
                        u();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    final Object h(bj bjVar, long j) {
        if (bjVar.j() == null) {
            w();
            return null;
        }
        Object obj = bjVar.d().get();
        if (obj == null) {
            w();
            return null;
        }
        if (!this.a.l(bjVar, j)) {
            return obj;
        }
        x(j);
        return null;
    }

    final Object i(Object obj, int i, Object obj2, boolean z) {
        Object obj3;
        int i2;
        lock();
        try {
            long jA = this.a.q.a();
            t(jA);
            if (this.b + 1 > this.e) {
                n();
            }
            AtomicReferenceArray atomicReferenceArray = this.f;
            int length = i & (atomicReferenceArray.length() - 1);
            bj bjVar = (bj) atomicReferenceArray.get(length);
            bj bjVarE = bjVar;
            while (true) {
                obj3 = null;
                if (bjVarE == null) {
                    this.d++;
                    bj bjVarD = d(obj, i, bjVar);
                    v(bjVarD, obj, obj2, jA);
                    atomicReferenceArray.set(length, bjVarD);
                    this.b++;
                    m(bjVarD);
                    break;
                }
                Object objJ = bjVarE.j();
                if (bjVarE.a() == i && objJ != null && this.a.h.d(obj, objJ)) {
                    ax axVarD = bjVarE.d();
                    Object obj4 = axVarD.get();
                    if (obj4 != null) {
                        if (z) {
                            q(bjVarE, jA);
                        } else {
                            this.d++;
                            z(obj, obj4, axVarD.a(), bk.REPLACED);
                            v(bjVarE, obj, obj2, jA);
                            m(bjVarE);
                        }
                        obj3 = obj4;
                        break;
                    }
                    this.d++;
                    if (axVarD.f()) {
                        z(obj, null, axVarD.a(), bk.COLLECTED);
                        v(bjVarE, obj, obj2, jA);
                        i2 = this.b;
                    } else {
                        v(bjVarE, obj, obj2, jA);
                        i2 = this.b + 1;
                    }
                    this.b = i2;
                    m(bjVarE);
                    break;
                }
                bjVarE = bjVarE.e();
            }
            return obj3;
        } finally {
            unlock();
            u();
        }
    }

    final Object j(bj bjVar, Object obj, ax axVar) throws ExecutionException {
        if (!axVar.g()) {
            throw new AssertionError();
        }
        com.google.android.libraries.navigation.internal.yx.ar.o(!Thread.holdsLock(bjVar), "Recursive load of: %s", obj);
        try {
            Object objD = axVar.d();
            if (objD == null) {
                throw new i(com.google.android.libraries.navigation.internal.b.b.e(obj, "CacheLoader returned null for key ", "."));
            }
            r(bjVar, this.a.q.a());
            this.f657n.e();
            return objD;
        } catch (Throwable th) {
            this.f657n.e();
            throw th;
        }
    }

    final void k() {
        while (true) {
            bj bjVar = (bj) this.j.poll();
            if (bjVar == null) {
                return;
            }
            if (this.m.contains(bjVar)) {
                this.m.add(bjVar);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0110 A[EDGE_INSN: B:45:0x0110->B:46:0x0113 BREAK  A[LOOP:3: B:26:0x00b6->B:41:0x0102]] */
    final void l() {
        int i = 0;
        if (this.a.o()) {
            int i2 = 0;
            do {
                Object objPoll = this.h.poll();
                if (objPoll == null) {
                    break;
                }
                bi biVar = this.a;
                bj bjVar = (bj) objPoll;
                int iA = bjVar.a();
                ao aoVarB = biVar.b(iA);
                aoVarB.lock();
                try {
                    int i3 = aoVarB.b;
                    AtomicReferenceArray atomicReferenceArray = aoVarB.f;
                    int length = iA & (atomicReferenceArray.length() - 1);
                    bj bjVar2 = (bj) atomicReferenceArray.get(length);
                    for (bj bjVarE = bjVar2; bjVarE != null; bjVarE = bjVarE.e()) {
                        if (bjVarE == bjVar) {
                            aoVarB.d++;
                            bj bjVarF = aoVarB.f(bjVar2, bjVarE, bjVarE.j(), iA, bjVarE.d().get(), bjVarE.d(), bk.COLLECTED);
                            int i4 = aoVarB.b - 1;
                            atomicReferenceArray.set(length, bjVarF);
                            aoVarB.b = i4;
                            break;
                        }
                    }
                    aoVarB.unlock();
                    aoVarB.u();
                    i2++;
                } catch (Throwable th) {
                    aoVarB.unlock();
                    aoVarB.u();
                    throw th;
                }
            } while (i2 != 16);
        }
        if (this.a.p()) {
            do {
                Object objPoll2 = this.i.poll();
                if (objPoll2 == null) {
                    return;
                }
                bi biVar2 = this.a;
                ax axVar = (ax) objPoll2;
                bj bjVarC = axVar.c();
                int iA2 = bjVarC.a();
                ao aoVarB2 = biVar2.b(iA2);
                Object objJ = bjVarC.j();
                aoVarB2.lock();
                try {
                    int i5 = aoVarB2.b;
                    AtomicReferenceArray atomicReferenceArray2 = aoVarB2.f;
                    int length2 = iA2 & (atomicReferenceArray2.length() - 1);
                    bj bjVar3 = (bj) atomicReferenceArray2.get(length2);
                    bj bjVarE2 = bjVar3;
                    while (true) {
                        if (bjVarE2 == null) {
                            aoVarB2.unlock();
                            if (!aoVarB2.isHeldByCurrentThread()) {
                                aoVarB2.u();
                                break;
                            }
                            break;
                        }
                        Object objJ2 = bjVarE2.j();
                        if (bjVarE2.a() == iA2 && objJ2 != null && aoVarB2.a.h.d(objJ, objJ2)) {
                            if (bjVarE2.d() != axVar) {
                                aoVarB2.unlock();
                                if (!aoVarB2.isHeldByCurrentThread()) {
                                    aoVarB2.u();
                                    break;
                                }
                                break;
                            }
                            aoVarB2.d++;
                            bj bjVarF2 = aoVarB2.f(bjVar3, bjVarE2, objJ2, iA2, axVar.get(), axVar, bk.COLLECTED);
                            int i6 = aoVarB2.b - 1;
                            atomicReferenceArray2.set(length2, bjVarF2);
                            aoVarB2.b = i6;
                            aoVarB2.unlock();
                            if (!aoVarB2.isHeldByCurrentThread()) {
                                aoVarB2.u();
                                break;
                            }
                            break;
                        }
                        bjVarE2 = bjVarE2.e();
                    }
                    i++;
                } catch (Throwable th2) {
                    aoVarB2.unlock();
                    if (!aoVarB2.isHeldByCurrentThread()) {
                        aoVarB2.u();
                    }
                    throw th2;
                }
            } while (i != 16);
        }
    }

    final void m(bj bjVar) {
        bj bjVar2;
        if (this.a.i()) {
            k();
            if (bjVar.d().a() > this.g && !y(bjVar, bjVar.a(), bk.SIZE)) {
                throw new AssertionError();
            }
            while (this.c > this.g) {
                Iterator it2 = this.m.iterator();
                do {
                    if (!it2.hasNext()) {
                        throw new AssertionError();
                    }
                    bjVar2 = (bj) it2.next();
                } while (bjVar2.d().a() <= 0);
                if (!y(bjVar2, bjVar2.a(), bk.SIZE)) {
                    throw new AssertionError();
                }
            }
        }
    }

    final void n() {
        AtomicReferenceArray atomicReferenceArray = this.f;
        int length = atomicReferenceArray.length();
        if (length >= 1073741824) {
            return;
        }
        int i = this.b;
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(length + length);
        this.e = (atomicReferenceArray2.length() * 3) / 4;
        int length2 = atomicReferenceArray2.length() - 1;
        for (int i2 = 0; i2 < length; i2++) {
            bj bjVarE = (bj) atomicReferenceArray.get(i2);
            if (bjVarE != null) {
                bj bjVarE2 = bjVarE.e();
                int iA = bjVarE.a() & length2;
                if (bjVarE2 == null) {
                    atomicReferenceArray2.set(iA, bjVarE);
                } else {
                    bj bjVar = bjVarE;
                    while (bjVarE2 != null) {
                        int iA2 = bjVarE2.a() & length2;
                        int i3 = iA2 != iA ? iA2 : iA;
                        if (iA2 != iA) {
                            bjVar = bjVarE2;
                        }
                        bjVarE2 = bjVarE2.e();
                        iA = i3;
                    }
                    atomicReferenceArray2.set(iA, bjVar);
                    while (bjVarE != bjVar) {
                        int iA3 = bjVarE.a() & length2;
                        bj bjVarA = a(bjVarE, (bj) atomicReferenceArray2.get(iA3));
                        if (bjVarA != null) {
                            atomicReferenceArray2.set(iA3, bjVarA);
                        } else {
                            s(bjVarE);
                            i--;
                        }
                        bjVarE = bjVarE.e();
                    }
                }
            }
        }
        this.f = atomicReferenceArray2;
        this.b = i;
    }

    final void o(long j) {
        bj bjVar;
        bj bjVar2;
        k();
        do {
            bjVar = (bj) this.l.peek();
            if (bjVar == null || !this.a.l(bjVar, j)) {
                do {
                    bjVar2 = (bj) this.m.peek();
                    if (bjVar2 == null || !this.a.l(bjVar2, j)) {
                        return;
                    }
                } while (y(bjVar2, bjVar2.a(), bk.EXPIRED));
                throw new AssertionError();
            }
        } while (y(bjVar, bjVar.a(), bk.EXPIRED));
        throw new AssertionError();
    }

    final void p() {
        if ((this.k.incrementAndGet() & 63) == 0) {
            t(this.a.q.a());
            u();
        }
    }

    final void q(bj bjVar, long j) {
        if (this.a.j()) {
            bjVar.k(j);
        }
        this.m.add(bjVar);
    }

    final void r(bj bjVar, long j) {
        if (this.a.j()) {
            bjVar.k(j);
        }
        this.j.add(bjVar);
    }

    final void s(bj bjVar) {
        Object objJ = bjVar.j();
        bjVar.a();
        z(objJ, bjVar.d().get(), bjVar.d().a(), bk.COLLECTED);
        this.l.remove(bjVar);
        this.m.remove(bjVar);
    }

    final void t(long j) {
        if (tryLock()) {
            try {
                l();
                o(j);
                this.k.set(0);
            } finally {
                unlock();
            }
        }
    }

    final void u() {
        if (isHeldByCurrentThread()) {
            return;
        }
        bi biVar = this.a;
        while (((bl) biVar.p.poll()) != null) {
            try {
                f fVar = biVar.x;
            } catch (Throwable th) {
                bi.a.logp(Level.WARNING, "com.google.common.cache.LocalCache", "processPendingNotifications", "Exception thrown by removal listener", th);
            }
        }
    }

    final void v(bj bjVar, Object obj, Object obj2, long j) {
        ax auVar;
        bi biVar = this.a;
        ax axVarD = bjVar.d();
        g gVar = biVar.w;
        com.google.android.libraries.navigation.internal.yx.ar.l(true, "Weights must be non-negative");
        int iOrdinal = this.a.k.ordinal();
        if (iOrdinal == 0) {
            auVar = new au(obj2);
        } else if (iOrdinal == 1) {
            auVar = new ap(this.i, obj2, bjVar);
        } else {
            if (iOrdinal != 2) {
                throw null;
            }
            auVar = new bc(this.i, obj2, bjVar);
        }
        bjVar.p(auVar);
        k();
        this.c++;
        if (this.a.j()) {
            bjVar.k(j);
        }
        if (this.a.m()) {
            bjVar.q(j);
        }
        this.m.add(bjVar);
        this.l.add(bjVar);
        axVarD.e(obj2);
    }

    final void w() {
        if (tryLock()) {
            try {
                l();
            } finally {
                unlock();
            }
        }
    }

    final void x(long j) {
        if (tryLock()) {
            try {
                o(j);
            } finally {
                unlock();
            }
        }
    }

    final boolean y(bj bjVar, int i, bk bkVar) {
        AtomicReferenceArray atomicReferenceArray = this.f;
        int length = (atomicReferenceArray.length() - 1) & i;
        bj bjVar2 = (bj) atomicReferenceArray.get(length);
        for (bj bjVarE = bjVar2; bjVarE != null; bjVarE = bjVarE.e()) {
            if (bjVarE == bjVar) {
                this.d++;
                bj bjVarF = f(bjVar2, bjVarE, bjVarE.j(), i, bjVarE.d().get(), bjVarE.d(), bkVar);
                int i2 = this.b - 1;
                atomicReferenceArray.set(length, bjVarF);
                this.b = i2;
                return true;
            }
        }
        return false;
    }

    final void z(Object obj, Object obj2, int i, bk bkVar) {
        this.c -= (long) i;
        int iOrdinal = bkVar.ordinal();
        if (iOrdinal != 0 && iOrdinal != 1) {
            if (iOrdinal != 2 && iOrdinal != 3 && iOrdinal != 4) {
                throw null;
            }
            this.f657n.a();
        }
        if (this.a.p != bi.c) {
            this.a.p.offer(new bl(obj, obj2, bkVar));
        }
    }
}
