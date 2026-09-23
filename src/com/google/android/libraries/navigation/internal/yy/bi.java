package com.google.android.libraries.navigation.internal.yy;

import com.google.android.libraries.navigation.internal.aac.cj;
import com.google.android.libraries.navigation.internal.yx.bv;
import com.google.android.libraries.navigation.internal.yx.bz;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class bi extends AbstractMap implements ConcurrentMap {
    static final Logger a = Logger.getLogger(bi.class.getName());
    static final ax b = new n();
    static final Queue c = new o();
    public static final /* synthetic */ int y = 0;
    final int d;
    final int e;
    final ao[] f;
    final int g;
    final com.google.android.libraries.navigation.internal.yx.y h;
    final com.google.android.libraries.navigation.internal.yx.y i;
    final aq j;
    final aq k;
    final long l;
    final long m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final long f658n;
    final long o;
    final Queue p;
    final bz q;
    final aa r;
    final j s;
    Set t;
    Collection u;
    Set v;
    final g w;
    final f x;

    public bi(h hVar, j jVar) {
        long j;
        int i = hVar.e;
        this.g = Math.min(i == -1 ? 4 : i, 65536);
        aq aqVarD = hVar.d();
        this.j = aqVarD;
        this.k = hVar.e();
        this.h = (com.google.android.libraries.navigation.internal.yx.y) com.google.android.libraries.navigation.internal.yx.al.c(hVar.m, hVar.d().a());
        this.i = (com.google.android.libraries.navigation.internal.yx.y) com.google.android.libraries.navigation.internal.yx.al.c(hVar.f659n, hVar.e().a());
        if (hVar.j == 0 || hVar.k == 0) {
            j = 0;
        } else {
            j = hVar.q == null ? hVar.f : hVar.g;
        }
        this.l = j;
        this.w = (g) com.google.android.libraries.navigation.internal.yx.al.c(hVar.q, g.INSTANCE);
        long j2 = hVar.k;
        this.m = j2 == -1 ? 0L : j2;
        long j3 = hVar.j;
        this.f658n = j3 == -1 ? 0L : j3;
        this.o = 0L;
        f fVar = (f) com.google.android.libraries.navigation.internal.yx.al.c(hVar.r, f.INSTANCE);
        this.x = fVar;
        this.p = fVar == f.INSTANCE ? c : new ConcurrentLinkedQueue();
        int i2 = 1;
        boolean z = m() || j();
        bz bzVar = hVar.o;
        if (bzVar == null) {
            bzVar = z ? bz.a : h.b;
        }
        this.q = bzVar;
        char c2 = (n() || j()) ? (char) 1 : (char) 0;
        boolean z2 = k() || m();
        aa aaVar = aa.a;
        this.r = aa.i[(aqVarD != aq.WEAK ? (char) 0 : (char) 4) | c2 | (true != z2 ? 0 : 2)];
        this.s = jVar;
        int iMin = Math.min(16, 1073741824);
        if (i() && !h()) {
            iMin = (int) Math.min(iMin, j);
        }
        int i3 = 0;
        int i4 = 1;
        while (i4 < this.g && (!i() || ((long) i4) * 20 <= this.l)) {
            i3++;
            i4 += i4;
        }
        this.e = 32 - i3;
        this.d = i4 - 1;
        this.f = new ao[i4];
        int i5 = iMin / i4;
        while (i2 < (i5 * i4 < iMin ? i5 + 1 : i5)) {
            i2 += i2;
        }
        if (i()) {
            long j4 = i4;
            long j5 = this.l;
            long j6 = j5 % j4;
            long j7 = (j5 / j4) + 1;
            int i6 = 0;
            while (true) {
                ao[] aoVarArr = this.f;
                if (i6 >= aoVarArr.length) {
                    return;
                }
                if (i6 == j6) {
                    j7--;
                }
                long j8 = j7;
                aoVarArr[i6] = new ao(this, i2, j8, (a) ((bv) hVar.p).a);
                i6++;
                j7 = j8;
            }
        } else {
            int i7 = 0;
            while (true) {
                ao[] aoVarArr2 = this.f;
                if (i7 >= aoVarArr2.length) {
                    return;
                }
                aoVarArr2[i7] = new ao(this, i2, -1L, (a) ((bv) hVar.p).a);
                i7++;
            }
        }
    }

    static void d(bj bjVar, bj bjVar2) {
        bjVar.l(bjVar2);
        bjVar2.n(bjVar);
    }

    static void e(bj bjVar, bj bjVar2) {
        bjVar.m(bjVar2);
        bjVar2.o(bjVar);
    }

    static void f(bj bjVar) {
        an anVar = an.INSTANCE;
        bjVar.l(anVar);
        bjVar.n(anVar);
    }

    static void g(bj bjVar) {
        an anVar = an.INSTANCE;
        bjVar.m(anVar);
        bjVar.o(anVar);
    }

    final int a(Object obj) {
        int iC = this.h.c(obj);
        int i = iC + ((iC << 15) ^ (-12931));
        int i2 = i ^ (i >>> 10);
        int i3 = i2 + (i2 << 3);
        int i4 = i3 ^ (i3 >>> 6);
        int i5 = i4 + (i4 << 2) + (i4 << 14);
        return i5 ^ (i5 >>> 16);
    }

    final ao b(int i) {
        return this.f[(i >>> this.e) & this.d];
    }

    /* JADX WARN: Code duplicated, block: B:13:0x004b A[Catch: all -> 0x0122, ExecutionException -> 0x0124, TRY_LEAVE, TryCatch #0 {ExecutionException -> 0x0124, blocks: (B:3:0x0015, B:5:0x0019, B:7:0x001f, B:9:0x002d, B:10:0x003b, B:12:0x0045, B:13:0x004b, B:43:0x00ee, B:49:0x0102, B:57:0x0112, B:55:0x010c, B:56:0x0111, B:33:0x00c8, B:61:0x011b, B:62:0x0121), top: B:77:0x0015, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0070 A[Catch: all -> 0x011a, TryCatch #3 {all -> 0x011a, blocks: (B:14:0x004e, B:17:0x0070, B:20:0x007c, B:22:0x0086, B:39:0x00d9, B:41:0x00e0, B:42:0x00eb, B:25:0x0092, B:27:0x0098, B:31:0x00b3, B:28:0x00a2, B:30:0x00aa, B:32:0x00c0, B:35:0x00d0), top: B:81:0x004e }] */
    /* JADX WARN: Code duplicated, block: B:39:0x00d9 A[Catch: all -> 0x011a, TryCatch #3 {all -> 0x011a, blocks: (B:14:0x004e, B:17:0x0070, B:20:0x007c, B:22:0x0086, B:39:0x00d9, B:41:0x00e0, B:42:0x00eb, B:25:0x0092, B:27:0x0098, B:31:0x00b3, B:28:0x00a2, B:30:0x00aa, B:32:0x00c0, B:35:0x00d0), top: B:81:0x004e }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00e0 A[Catch: all -> 0x011a, TryCatch #3 {all -> 0x011a, blocks: (B:14:0x004e, B:17:0x0070, B:20:0x007c, B:22:0x0086, B:39:0x00d9, B:41:0x00e0, B:42:0x00eb, B:25:0x0092, B:27:0x0098, B:31:0x00b3, B:28:0x00a2, B:30:0x00aa, B:32:0x00c0, B:35:0x00d0), top: B:81:0x004e }] */
    /* JADX WARN: Code duplicated, block: B:42:0x00eb A[Catch: all -> 0x011a, TRY_LEAVE, TryCatch #3 {all -> 0x011a, blocks: (B:14:0x004e, B:17:0x0070, B:20:0x007c, B:22:0x0086, B:39:0x00d9, B:41:0x00e0, B:42:0x00eb, B:25:0x0092, B:27:0x0098, B:31:0x00b3, B:28:0x00a2, B:30:0x00aa, B:32:0x00c0, B:35:0x00d0), top: B:81:0x004e }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:57:0x0112 A[Catch: all -> 0x0122, ExecutionException -> 0x0124, TRY_LEAVE, TryCatch #0 {ExecutionException -> 0x0124, blocks: (B:3:0x0015, B:5:0x0019, B:7:0x001f, B:9:0x002d, B:10:0x003b, B:12:0x0045, B:13:0x004b, B:43:0x00ee, B:49:0x0102, B:57:0x0112, B:55:0x010c, B:56:0x0111, B:33:0x00c8, B:61:0x011b, B:62:0x0121), top: B:77:0x0015, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x00f6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:84:0x00d5 A[SYNTHETIC] */
    final Object c(Object obj, j jVar) throws ExecutionException {
        AtomicReferenceArray atomicReferenceArray;
        int length;
        bj bjVar;
        bj bjVarD;
        ai aiVar;
        ax axVarD;
        boolean z;
        Object objG;
        bj bjVarB;
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        int iA = a(obj);
        ao aoVarB = b(iA);
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        com.google.android.libraries.navigation.internal.yx.ar.q(jVar);
        try {
            try {
                if (aoVarB.b == 0 || (bjVarB = aoVarB.b(obj, iA)) == null) {
                    aoVarB.lock();
                    try {
                        long jA = aoVarB.a.q.a();
                        aoVarB.t(jA);
                        int i = aoVarB.b - 1;
                        atomicReferenceArray = aoVarB.f;
                        length = (atomicReferenceArray.length() - 1) & iA;
                        bjVar = (bj) atomicReferenceArray.get(length);
                        bjVarD = bjVar;
                        while (true) {
                            aiVar = null;
                            if (bjVarD != null) {
                                Object objJ = bjVarD.j();
                                if (bjVarD.a() == iA || objJ == null || !aoVarB.a.h.d(obj, objJ)) {
                                    bjVarD = bjVarD.e();
                                } else {
                                    axVarD = bjVarD.d();
                                    if (axVarD.g()) {
                                        z = false;
                                        break;
                                    }
                                    Object obj2 = axVarD.get();
                                    if (obj2 == null) {
                                        aoVarB.z(objJ, null, axVarD.a(), bk.COLLECTED);
                                    } else if (aoVarB.a.l(bjVarD, jA)) {
                                        aoVarB.z(objJ, obj2, axVarD.a(), bk.EXPIRED);
                                    } else {
                                        aoVarB.q(bjVarD, jA);
                                        aoVarB.f657n.b();
                                        aoVarB.unlock();
                                        aoVarB.u();
                                        objG = obj2;
                                    }
                                    aoVarB.l.remove(bjVarD);
                                    aoVarB.m.remove(bjVarD);
                                    aoVarB.b = i;
                                }
                            } else {
                                axVarD = null;
                            }
                            z = true;
                            break;
                        }
                        if (z) {
                            aiVar = new ai();
                            if (bjVarD == null) {
                                bjVarD = aoVarB.d(obj, iA, bjVar);
                                bjVarD.p(aiVar);
                                atomicReferenceArray.set(length, bjVarD);
                            } else {
                                bjVarD.p(aiVar);
                            }
                        }
                        aoVarB.unlock();
                        aoVarB.u();
                        if (z) {
                            try {
                                synchronized (bjVarD) {
                                    objG = aoVarB.g(obj, iA, aiVar, aiVar.i(obj, jVar));
                                }
                                aoVarB.f657n.e();
                            } catch (Throwable th) {
                                aoVarB.f657n.e();
                                throw th;
                            }
                        } else {
                            objG = aoVarB.j(bjVarD, obj, axVarD);
                        }
                    } catch (Throwable th2) {
                        aoVarB.unlock();
                        aoVarB.u();
                        throw th2;
                    }
                } else {
                    long jA2 = aoVarB.a.q.a();
                    Object objH = aoVarB.h(bjVarB, jA2);
                    if (objH != null) {
                        aoVarB.r(bjVarB, jA2);
                        aoVarB.f657n.b();
                        objG = ao.A(objH);
                    } else {
                        ax axVarD2 = bjVarB.d();
                        if (axVarD2.g()) {
                            objG = aoVarB.j(bjVarB, obj, axVarD2);
                        } else {
                            aoVarB.lock();
                            long jA3 = aoVarB.a.q.a();
                            aoVarB.t(jA3);
                            int i2 = aoVarB.b - 1;
                            atomicReferenceArray = aoVarB.f;
                            length = (atomicReferenceArray.length() - 1) & iA;
                            bjVar = (bj) atomicReferenceArray.get(length);
                            bjVarD = bjVar;
                            while (true) {
                                aiVar = null;
                                if (bjVarD != null) {
                                    Object objJ2 = bjVarD.j();
                                    if (bjVarD.a() == iA) {
                                    }
                                    bjVarD = bjVarD.e();
                                } else {
                                    axVarD = null;
                                }
                                z = true;
                                break;
                            }
                            if (z) {
                                aiVar = new ai();
                                if (bjVarD == null) {
                                    bjVarD = aoVarB.d(obj, iA, bjVar);
                                    bjVarD.p(aiVar);
                                    atomicReferenceArray.set(length, bjVarD);
                                } else {
                                    bjVarD.p(aiVar);
                                }
                            }
                            aoVarB.unlock();
                            aoVarB.u();
                            if (z) {
                                synchronized (bjVarD) {
                                    objG = aoVarB.g(obj, iA, aiVar, aiVar.i(obj, jVar));
                                    aoVarB.f657n.e();
                                }
                            } else {
                                objG = aoVarB.j(bjVarD, obj, axVarD);
                            }
                        }
                    }
                }
                aoVarB.p();
                return objG;
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                if (cause instanceof Error) {
                    throw new com.google.android.libraries.navigation.internal.aac.ad((Error) cause);
                }
                if (cause instanceof RuntimeException) {
                    throw new cj(cause);
                }
                throw e;
            }
        } catch (Throwable th3) {
            aoVarB.p();
            throw th3;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        for (ao aoVar : this.f) {
            if (aoVar.b != 0) {
                aoVar.lock();
                try {
                    aoVar.t(aoVar.a.q.a());
                    AtomicReferenceArray atomicReferenceArray = aoVar.f;
                    for (int i = 0; i < atomicReferenceArray.length(); i++) {
                        for (bj bjVarE = (bj) atomicReferenceArray.get(i); bjVarE != null; bjVarE = bjVarE.e()) {
                            if (bjVarE.d().f()) {
                                Object objJ = bjVarE.j();
                                Object obj = bjVarE.d().get();
                                bk bkVar = (objJ == null || obj == null) ? bk.COLLECTED : bk.EXPLICIT;
                                bjVarE.a();
                                aoVar.z(objJ, obj, bjVarE.d().a(), bkVar);
                            }
                        }
                    }
                    for (int i2 = 0; i2 < atomicReferenceArray.length(); i2++) {
                        atomicReferenceArray.set(i2, null);
                    }
                    if (aoVar.a.o()) {
                        while (aoVar.h.poll() != null) {
                        }
                    }
                    if (aoVar.a.p()) {
                        while (aoVar.i.poll() != null) {
                        }
                    }
                    aoVar.l.clear();
                    aoVar.m.clear();
                    aoVar.k.set(0);
                    aoVar.d++;
                    aoVar.b = 0;
                    aoVar.unlock();
                    aoVar.u();
                } catch (Throwable th) {
                    aoVar.unlock();
                    aoVar.u();
                    throw th;
                }
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        bj bjVarC;
        boolean z = false;
        if (obj == null) {
            return false;
        }
        int iA = a(obj);
        ao aoVarB = b(iA);
        try {
            if (aoVarB.b != 0 && (bjVarC = aoVarB.c(obj, iA, aoVarB.a.q.a())) != null && bjVarC.d().get() != null) {
                z = true;
            }
            return z;
        } finally {
            aoVarB.p();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1, types: [int] */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX WARN: Type inference failed for: r14v1, types: [java.util.concurrent.atomic.AtomicReferenceArray] */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1, types: [int] */
    /* JADX WARN: Type inference failed for: r15v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        boolean z = false;
        if (obj == null) {
            return false;
        }
        bz bzVar = this.q;
        ao[] aoVarArr = this.f;
        long jA = bzVar.a();
        long j = -1;
        int i = 0;
        while (i < 3) {
            int length = aoVarArr.length;
            long j2 = 0;
            for (?? r12 = z; r12 < length; r12++) {
                ao aoVar = aoVarArr[r12];
                int i2 = aoVar.b;
                ?? r14 = aoVar.f;
                for (?? r15 = z; r15 < r14.length(); r15++) {
                    bj bjVarE = (bj) r14.get(r15);
                    while (true) {
                        ao[] aoVarArr2 = aoVarArr;
                        if (bjVarE != null) {
                            Object objH = aoVar.h(bjVarE, jA);
                            long j3 = jA;
                            if (objH != null && this.i.d(obj, objH)) {
                                return true;
                            }
                            bjVarE = bjVarE.e();
                            aoVarArr = aoVarArr2;
                            jA = j3;
                        }
                    }
                }
                j2 += (long) aoVar.d;
                aoVarArr = aoVarArr;
                jA = jA;
                z = false;
            }
            ao[] aoVarArr3 = aoVarArr;
            long j4 = jA;
            if (j2 == j) {
                return false;
            }
            i++;
            j = j2;
            aoVarArr = aoVarArr3;
            jA = j4;
            z = false;
        }
        return z;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.v;
        if (set != null) {
            return set;
        }
        ac acVar = new ac(this);
        this.v = acVar;
        return acVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        long jA;
        bj bjVarC;
        Object objA = null;
        if (obj == null) {
            return null;
        }
        int iA = a(obj);
        ao aoVarB = b(iA);
        try {
            if (aoVarB.b != 0 && (bjVarC = aoVarB.c(obj, iA, (jA = aoVarB.a.q.a()))) != null) {
                Object obj2 = bjVarC.d().get();
                if (obj2 != null) {
                    aoVarB.r(bjVarC, jA);
                    bjVarC.j();
                    j jVar = aoVarB.a.s;
                    objA = ao.A(obj2);
                } else {
                    aoVarB.w();
                }
            }
            return objA;
        } finally {
            aoVarB.p();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    final boolean h() {
        return this.w != g.INSTANCE;
    }

    final boolean i() {
        return this.l >= 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        ao[] aoVarArr = this.f;
        long j = 0;
        for (ao aoVar : aoVarArr) {
            if (aoVar.b != 0) {
                return false;
            }
            j += (long) aoVar.d;
        }
        if (j == 0) {
            return true;
        }
        for (ao aoVar2 : aoVarArr) {
            if (aoVar2.b != 0) {
                return false;
            }
            j -= (long) aoVar2.d;
        }
        return j == 0;
    }

    final boolean j() {
        return this.m > 0;
    }

    final boolean k() {
        return this.f658n > 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.t;
        if (set != null) {
            return set;
        }
        af afVar = new af(this);
        this.t = afVar;
        return afVar;
    }

    final boolean l(bj bjVar, long j) {
        com.google.android.libraries.navigation.internal.yx.ar.q(bjVar);
        if (!j() || j - bjVar.b() < this.m) {
            return k() && j - bjVar.c() >= this.f658n;
        }
        return true;
    }

    final boolean m() {
        return k();
    }

    final boolean n() {
        return j() || i();
    }

    final boolean o() {
        return this.j != aq.STRONG;
    }

    final boolean p() {
        return this.k != aq.STRONG;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        com.google.android.libraries.navigation.internal.yx.ar.q(obj2);
        int iA = a(obj);
        return b(iA).i(obj, iA, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object putIfAbsent(Object obj, Object obj2) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        com.google.android.libraries.navigation.internal.yx.ar.q(obj2);
        int iA = a(obj);
        return b(iA).i(obj, iA, obj2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        bk bkVar;
        Object obj2 = null;
        if (obj == null) {
            return null;
        }
        int iA = a(obj);
        ao aoVarB = b(iA);
        aoVarB.lock();
        try {
            aoVarB.t(aoVarB.a.q.a());
            int i = aoVarB.b;
            AtomicReferenceArray atomicReferenceArray = aoVarB.f;
            int length = iA & (atomicReferenceArray.length() - 1);
            bj bjVar = (bj) atomicReferenceArray.get(length);
            for (bj bjVarE = bjVar; bjVarE != null; bjVarE = bjVarE.e()) {
                Object objJ = bjVarE.j();
                if (bjVarE.a() == iA && objJ != null && aoVarB.a.h.d(obj, objJ)) {
                    ax axVarD = bjVarE.d();
                    Object obj3 = axVarD.get();
                    if (obj3 == null) {
                        if (!axVarD.f()) {
                            break;
                        }
                        bkVar = bk.COLLECTED;
                    } else {
                        bkVar = bk.EXPLICIT;
                    }
                    bk bkVar2 = bkVar;
                    aoVarB.d++;
                    bj bjVarF = aoVarB.f(bjVar, bjVarE, objJ, iA, obj3, axVarD, bkVar2);
                    int i2 = aoVarB.b - 1;
                    atomicReferenceArray.set(length, bjVarF);
                    aoVarB.b = i2;
                    obj2 = obj3;
                    break;
                }
            }
            return obj2;
        } finally {
            aoVarB.unlock();
            aoVarB.u();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final Object replace(Object obj, Object obj2) {
        Object obj3;
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        com.google.android.libraries.navigation.internal.yx.ar.q(obj2);
        int iA = a(obj);
        ao aoVarB = b(iA);
        aoVarB.lock();
        try {
            long jA = aoVarB.a.q.a();
            aoVarB.t(jA);
            AtomicReferenceArray atomicReferenceArray = aoVarB.f;
            int length = iA & (atomicReferenceArray.length() - 1);
            bj bjVar = (bj) atomicReferenceArray.get(length);
            bj bjVarE = bjVar;
            while (true) {
                obj3 = null;
                if (bjVarE == null) {
                    break;
                }
                Object objJ = bjVarE.j();
                if (bjVarE.a() == iA && objJ != null && aoVarB.a.h.d(obj, objJ)) {
                    ax axVarD = bjVarE.d();
                    Object obj4 = axVarD.get();
                    if (obj4 != null) {
                        aoVarB.d++;
                        aoVarB.z(obj, obj4, axVarD.a(), bk.REPLACED);
                        aoVarB.v(bjVarE, obj, obj2, jA);
                        aoVarB.m(bjVarE);
                        obj3 = obj4;
                        break;
                    }
                    if (!axVarD.f()) {
                        break;
                    }
                    int i = aoVarB.b;
                    aoVarB.d++;
                    bj bjVarF = aoVarB.f(bjVar, bjVarE, objJ, iA, null, axVarD, bk.COLLECTED);
                    int i2 = aoVarB.b - 1;
                    atomicReferenceArray.set(length, bjVarF);
                    aoVarB.b = i2;
                    break;
                }
                bjVarE = bjVarE.e();
            }
            return obj3;
        } finally {
            aoVarB.unlock();
            aoVarB.u();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        long jMax = 0;
        for (ao aoVar : this.f) {
            jMax += (long) Math.max(0, aoVar.b);
        }
        return com.google.android.libraries.navigation.internal.zy.i.e(jMax);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.u;
        if (collection != null) {
            return collection;
        }
        ay ayVar = new ay(this);
        this.u = ayVar;
        return ayVar;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean remove(Object obj, Object obj2) {
        bk bkVar;
        boolean z = false;
        if (obj == null || obj2 == null) {
            return false;
        }
        int iA = a(obj);
        ao aoVarB = b(iA);
        aoVarB.lock();
        try {
            aoVarB.t(aoVarB.a.q.a());
            int i = aoVarB.b;
            AtomicReferenceArray atomicReferenceArray = aoVarB.f;
            int length = iA & (atomicReferenceArray.length() - 1);
            bj bjVar = (bj) atomicReferenceArray.get(length);
            for (bj bjVarE = bjVar; bjVarE != null; bjVarE = bjVarE.e()) {
                Object objJ = bjVarE.j();
                if (bjVarE.a() == iA && objJ != null && aoVarB.a.h.d(obj, objJ)) {
                    ax axVarD = bjVarE.d();
                    Object obj3 = axVarD.get();
                    if (aoVarB.a.i.d(obj2, obj3)) {
                        bkVar = bk.EXPLICIT;
                    } else {
                        if (obj3 != null || !axVarD.f()) {
                            break;
                            break;
                        }
                        bkVar = bk.COLLECTED;
                        obj3 = null;
                    }
                    Object obj4 = obj3;
                    aoVarB.d++;
                    bj bjVarF = aoVarB.f(bjVar, bjVarE, objJ, iA, obj4, axVarD, bkVar);
                    int i2 = aoVarB.b - 1;
                    atomicReferenceArray.set(length, bjVarF);
                    aoVarB.b = i2;
                    if (bkVar != bk.EXPLICIT) {
                        break;
                    }
                    z = true;
                    break;
                }
            }
            return z;
        } finally {
            aoVarB.unlock();
            aoVarB.u();
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        com.google.android.libraries.navigation.internal.yx.ar.q(obj3);
        boolean z = false;
        if (obj2 == null) {
            return false;
        }
        int iA = a(obj);
        ao aoVarB = b(iA);
        aoVarB.lock();
        try {
            long jA = aoVarB.a.q.a();
            aoVarB.t(jA);
            AtomicReferenceArray atomicReferenceArray = aoVarB.f;
            int length = iA & (atomicReferenceArray.length() - 1);
            bj bjVar = (bj) atomicReferenceArray.get(length);
            for (bj bjVarE = bjVar; bjVarE != null; bjVarE = bjVarE.e()) {
                Object objJ = bjVarE.j();
                if (bjVarE.a() == iA && objJ != null && aoVarB.a.h.d(obj, objJ)) {
                    ax axVarD = bjVarE.d();
                    Object obj4 = axVarD.get();
                    if (obj4 == null) {
                        if (!axVarD.f()) {
                            break;
                        }
                        int i = aoVarB.b;
                        aoVarB.d++;
                        bj bjVarF = aoVarB.f(bjVar, bjVarE, objJ, iA, null, axVarD, bk.COLLECTED);
                        int i2 = aoVarB.b - 1;
                        atomicReferenceArray.set(length, bjVarF);
                        aoVarB.b = i2;
                        break;
                    }
                    if (aoVarB.a.i.d(obj2, obj4)) {
                        aoVarB.d++;
                        aoVarB.z(obj, obj4, axVarD.a(), bk.REPLACED);
                        aoVarB.v(bjVarE, obj, obj3, jA);
                        aoVarB.m(bjVarE);
                        z = true;
                        break;
                    }
                    aoVarB.q(bjVarE, jA);
                    break;
                }
            }
            return z;
        } finally {
            aoVarB.unlock();
            aoVarB.u();
        }
    }
}
