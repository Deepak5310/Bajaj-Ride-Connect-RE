package com.google.android.libraries.navigation.internal.yz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cq<E> extends aq<E> implements Serializable {
    private static final long serialVersionUID = 1;
    public final transient ConcurrentMap<E, AtomicInteger> countMap;

    public cq(ConcurrentMap concurrentMap) {
        com.google.android.libraries.navigation.internal.yx.ar.f(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final List g() {
        ArrayList arrayListF = hx.f(size());
        for (kt ktVar : m()) {
            Object objB = ktVar.b();
            for (int iA = ktVar.a(); iA > 0; iA--) {
                arrayListF.add(objB);
            }
        }
        return arrayListF;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        cp.a.b(this, (ConcurrentMap) Objects.requireNonNull(objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aq, com.google.android.libraries.navigation.internal.yz.ku
    public final int a(Object obj, int i) {
        AtomicInteger atomicIntegerPutIfAbsent;
        int i2;
        AtomicInteger atomicInteger;
        int i3;
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        if (i == 0) {
            return b(obj);
        }
        bs.b(i, "occurrences");
        do {
            atomicIntegerPutIfAbsent = (AtomicInteger) kc.e(this.countMap, obj);
            if (atomicIntegerPutIfAbsent == null && (atomicIntegerPutIfAbsent = this.countMap.putIfAbsent(obj, new AtomicInteger(i))) == null) {
                return 0;
            }
            do {
                i2 = atomicIntegerPutIfAbsent.get();
                if (i2 == 0) {
                    atomicInteger = new AtomicInteger(i);
                    if (this.countMap.putIfAbsent(obj, atomicInteger) == null) {
                        break;
                    }
                } else {
                    long j = ((long) i2) + ((long) i);
                    try {
                        i3 = (int) j;
                        if (j != i3) {
                            throw new ArithmeticException("overflow: checkedAdd(" + i2 + ", " + i + ")");
                        }
                    } catch (ArithmeticException unused) {
                        throw new IllegalArgumentException(com.google.android.libraries.navigation.internal.b.b.l(i2, i, "Overflow adding ", " occurrences to a count of "));
                    }
                }
            } while (!atomicIntegerPutIfAbsent.compareAndSet(i2, i3));
            return i2;
        } while (!this.countMap.replace(obj, atomicIntegerPutIfAbsent, atomicInteger));
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.ku
    public final int b(Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) kc.e(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aq
    public final int c() {
        return this.countMap.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        this.countMap.clear();
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aq, com.google.android.libraries.navigation.internal.yz.ku
    public final int d(Object obj, int i) {
        int i2;
        int iMax;
        bs.b(i, "occurrences");
        AtomicInteger atomicInteger = (AtomicInteger) kc.e(this.countMap, obj);
        if (atomicInteger != null) {
            do {
                i2 = atomicInteger.get();
                if (i2 != 0) {
                    iMax = Math.max(0, i2 - i);
                }
            } while (!atomicInteger.compareAndSet(i2, iMax));
            if (iMax == 0) {
                this.countMap.remove(obj, atomicInteger);
            }
            return i2;
        }
        return 0;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aq
    public final Iterator e() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aq
    public final Iterator f() {
        return new cn(this, new cm(this));
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aq, com.google.android.libraries.navigation.internal.yz.ku
    public final boolean i(Object obj, int i) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        bs.d(i, "oldCount");
        bs.d(0, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) kc.e(this.countMap, obj);
        if (atomicInteger == null) {
            return i == 0;
        }
        int i2 = atomicInteger.get();
        if (i2 == i) {
            if (i2 == 0) {
                this.countMap.remove(obj, atomicInteger);
                return true;
            }
            if (atomicInteger.compareAndSet(i2, 0)) {
                this.countMap.remove(obj, atomicInteger);
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aq, java.util.AbstractCollection, java.util.Collection
    public final boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return la.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aq
    public final Set j() {
        return new cl(this.countMap.keySet());
    }

    @Override // com.google.android.libraries.navigation.internal.yz.aq
    @Deprecated
    public final Set k() {
        return new co(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.android.libraries.navigation.internal.yz.ku
    public final int size() {
        Iterator<AtomicInteger> it2 = this.countMap.values().iterator();
        long j = 0;
        while (it2.hasNext()) {
            j += (long) it2.next().get();
        }
        return com.google.android.libraries.navigation.internal.zy.i.e(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return g().toArray();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return g().toArray(objArr);
    }
}
