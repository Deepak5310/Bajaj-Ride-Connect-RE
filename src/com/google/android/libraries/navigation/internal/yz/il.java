package com.google.android.libraries.navigation.internal.yz;

import java.lang.ref.ReferenceQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class il extends ReentrantLock {
    final jk a;
    volatile int b;
    int c;
    int d;
    volatile AtomicReferenceArray e;
    final AtomicInteger f = new AtomicInteger();

    public il(jk jkVar, int i) {
        this.a = jkVar;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(i);
        this.d = (atomicReferenceArray.length() * 3) / 4;
        this.e = atomicReferenceArray;
    }

    static boolean n(ih ihVar) {
        return ihVar.d() == null;
    }

    static final void o(ReferenceQueue referenceQueue) {
        while (referenceQueue.poll() != null) {
        }
    }

    final ih a(ih ihVar, ih ihVar2) {
        return this.a.g.a(d(), ihVar, ihVar2);
    }

    final ih b(Object obj, int i) {
        if (this.b == 0) {
            return null;
        }
        AtomicReferenceArray atomicReferenceArray = this.e;
        for (ih ihVarB = (ih) atomicReferenceArray.get((atomicReferenceArray.length() - 1) & i); ihVarB != null; ihVarB = ihVarB.b()) {
            if (ihVarB.a() == i) {
                Object objC = ihVarB.c();
                if (objC == null) {
                    m();
                } else if (this.a.f.d(obj, objC)) {
                    return ihVarB;
                }
            }
        }
        return null;
    }

    final ih c(ih ihVar, ih ihVar2) {
        int i = this.b;
        ih ihVarB = ihVar2.b();
        while (ihVar != ihVar2) {
            ih ihVarA = a(ihVar, ihVarB);
            if (ihVarA != null) {
                ihVarB = ihVarA;
            } else {
                i--;
            }
            ihVar = ihVar.b();
        }
        this.b = i;
        return ihVarB;
    }

    public abstract il d();

    final Object e(Object obj, int i, Object obj2, boolean z) {
        Object obj3;
        lock();
        try {
            k();
            int i2 = this.b + 1;
            if (i2 > this.d) {
                AtomicReferenceArray atomicReferenceArray = this.e;
                int length = atomicReferenceArray.length();
                if (length < 1073741824) {
                    int i3 = this.b;
                    AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(length + length);
                    this.d = (atomicReferenceArray2.length() * 3) / 4;
                    int length2 = atomicReferenceArray2.length() - 1;
                    for (int i4 = 0; i4 < length; i4++) {
                        ih ihVarB = (ih) atomicReferenceArray.get(i4);
                        if (ihVarB != null) {
                            ih ihVarB2 = ihVarB.b();
                            int iA = ihVarB.a() & length2;
                            if (ihVarB2 == null) {
                                atomicReferenceArray2.set(iA, ihVarB);
                            } else {
                                ih ihVar = ihVarB;
                                while (ihVarB2 != null) {
                                    int iA2 = ihVarB2.a() & length2;
                                    int i5 = iA2 != iA ? iA2 : iA;
                                    if (iA2 != iA) {
                                        ihVar = ihVarB2;
                                    }
                                    ihVarB2 = ihVarB2.b();
                                    iA = i5;
                                }
                                atomicReferenceArray2.set(iA, ihVar);
                                while (ihVarB != ihVar) {
                                    int iA3 = ihVarB.a() & length2;
                                    ih ihVarA = a(ihVarB, (ih) atomicReferenceArray2.get(iA3));
                                    if (ihVarA != null) {
                                        atomicReferenceArray2.set(iA3, ihVarA);
                                    } else {
                                        i3--;
                                    }
                                    ihVarB = ihVarB.b();
                                }
                            }
                        }
                    }
                    this.e = atomicReferenceArray2;
                    this.b = i3;
                }
                i2 = this.b + 1;
            }
            AtomicReferenceArray atomicReferenceArray3 = this.e;
            int length3 = (atomicReferenceArray3.length() - 1) & i;
            ih ihVar2 = (ih) atomicReferenceArray3.get(length3);
            ih ihVarB3 = ihVar2;
            while (true) {
                obj3 = null;
                if (ihVarB3 == null) {
                    this.c++;
                    ih ihVarB4 = this.a.g.b(d(), obj, i, ihVar2);
                    l(ihVarB4, obj2);
                    atomicReferenceArray3.set(length3, ihVarB4);
                    this.b = i2;
                    break;
                }
                Object objC = ihVarB3.c();
                if (ihVarB3.a() == i && objC != null && this.a.f.d(obj, objC)) {
                    Object objD = ihVarB3.d();
                    if (objD != null) {
                        if (!z) {
                            this.c++;
                            l(ihVarB3, obj2);
                        }
                        obj3 = objD;
                        break;
                    }
                    this.c++;
                    l(ihVarB3, obj2);
                    this.b = this.b;
                    break;
                }
                ihVarB3 = ihVarB3.b();
            }
            return obj3;
        } finally {
            unlock();
        }
    }

    final void f(ReferenceQueue referenceQueue) {
        int i = 0;
        do {
            Object objPoll = referenceQueue.poll();
            if (objPoll == null) {
                return;
            }
            jk jkVar = this.a;
            ih ihVar = (ih) objPoll;
            int iA = ihVar.a();
            il ilVarC = jkVar.c(iA);
            ilVarC.lock();
            try {
                int i2 = ilVarC.b;
                AtomicReferenceArray atomicReferenceArray = ilVarC.e;
                int length = iA & (atomicReferenceArray.length() - 1);
                ih ihVar2 = (ih) atomicReferenceArray.get(length);
                for (ih ihVarB = ihVar2; ihVarB != null; ihVarB = ihVarB.b()) {
                    if (ihVarB == ihVar) {
                        ilVarC.c++;
                        ih ihVarC = ilVarC.c(ihVar2, ihVarB);
                        int i3 = ilVarC.b - 1;
                        atomicReferenceArray.set(length, ihVarC);
                        ilVarC.b = i3;
                        break;
                    }
                }
                ilVarC.unlock();
                i++;
            } catch (Throwable th) {
                ilVarC.unlock();
                throw th;
            }
        } while (i != 16);
    }

    final void g(ReferenceQueue referenceQueue) {
        int i = 0;
        do {
            Object objPoll = referenceQueue.poll();
            if (objPoll == null) {
                return;
            }
            jk jkVar = this.a;
            jh jhVar = (jh) objPoll;
            ih ihVarA = jhVar.a();
            int iA = ihVarA.a();
            il ilVarC = jkVar.c(iA);
            Object objC = ihVarA.c();
            ilVarC.lock();
            try {
                int i2 = ilVarC.b;
                AtomicReferenceArray atomicReferenceArray = ilVarC.e;
                int length = (atomicReferenceArray.length() - 1) & iA;
                ih ihVar = (ih) atomicReferenceArray.get(length);
                for (ih ihVarB = ihVar; ihVarB != null; ihVarB = ihVarB.b()) {
                    Object objC2 = ihVarB.c();
                    if (ihVarB.a() == iA && objC2 != null && ilVarC.a.f.d(objC, objC2)) {
                        if (((jg) ihVarB).e() != jhVar) {
                            break;
                        }
                        ilVarC.c++;
                        ih ihVarC = ilVarC.c(ihVar, ihVarB);
                        int i3 = ilVarC.b - 1;
                        atomicReferenceArray.set(length, ihVarC);
                        ilVarC.b = i3;
                        break;
                    }
                }
                ilVarC.unlock();
                i++;
            } catch (Throwable th) {
                ilVarC.unlock();
                throw th;
            }
        } while (i != 16);
    }

    public void h() {
    }

    public void i() {
    }

    final void j() {
        if ((this.f.incrementAndGet() & 63) == 0) {
            k();
        }
    }

    final void k() {
        if (tryLock()) {
            try {
                i();
                this.f.set(0);
            } finally {
                unlock();
            }
        }
    }

    final void l(ih ihVar, Object obj) {
        this.a.g.f(d(), ihVar, obj);
    }

    final void m() {
        if (tryLock()) {
            try {
                i();
            } finally {
                unlock();
            }
        }
    }
}
