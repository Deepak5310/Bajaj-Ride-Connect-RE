package com.google.android.libraries.navigation.internal.yz;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class gl extends fy implements NavigableSet, mr {
    private static final long serialVersionUID = 912559;
    final transient Comparator a;
    transient gl b;

    public gl(Comparator comparator) {
        this.a = comparator;
    }

    static mc H(Comparator comparator) {
        if (lg.a.equals(comparator)) {
            return mc.c;
        }
        int i = ev.d;
        return new mc(lv.a, comparator);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    static gl x(Comparator comparator, int i, Object... objArr) {
        if (i == 0) {
            return H(comparator);
        }
        lj.d(objArr, i);
        Arrays.sort(objArr, 0, i, comparator);
        int i2 = 1;
        for (int i3 = 1; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (comparator.compare(obj, objArr[i2 - 1]) != 0) {
                objArr[i2] = obj;
                i2++;
            }
        }
        Arrays.fill(objArr, i2, i, (Object) null);
        if (i2 < (objArr.length >> 1)) {
            objArr = Arrays.copyOf(objArr, i2);
        }
        return new mc(ev.l(objArr, i2), comparator);
    }

    public static gl y(Collection collection) {
        lg lgVar = lg.a;
        ms.a(lgVar, collection);
        Object[] objArrI = gs.i(collection);
        return x(lgVar, objArrI.length, objArrI);
    }

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public final gl descendingSet() {
        gl glVar = this.b;
        if (glVar != null) {
            return glVar;
        }
        gl glVarZ = z();
        this.b = glVarZ;
        glVarZ.b = this;
        return glVarZ;
    }

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public final gl headSet(Object obj, boolean z) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        return C(obj, z);
    }

    public abstract gl C(Object obj, boolean z);

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public final gl subSet(Object obj, boolean z, Object obj2, boolean z2) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        com.google.android.libraries.navigation.internal.yx.ar.q(obj2);
        com.google.android.libraries.navigation.internal.yx.ar.a(this.a.compare(obj, obj2) <= 0);
        return E(obj, z, obj2, z2);
    }

    public abstract gl E(Object obj, boolean z, Object obj2, boolean z2);

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public final gl tailSet(Object obj, boolean z) {
        com.google.android.libraries.navigation.internal.yx.ar.q(obj);
        return G(obj, z);
    }

    public abstract gl G(Object obj, boolean z);

    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public abstract nn descendingIterator();

    @Deprecated
    public final void addFirst(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void addLast(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    public Object ceiling(Object obj) {
        return gs.c(tailSet(obj, true), null);
    }

    @Override // java.util.SortedSet, com.google.android.libraries.navigation.internal.yz.mr
    public final Comparator comparator() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: e */
    public abstract nn listIterator();

    @Override // java.util.SortedSet
    public Object first() {
        return listIterator().next();
    }

    @Override // java.util.NavigableSet
    public Object floor(Object obj) {
        return hb.b(headSet(obj, true).descendingIterator(), null);
    }

    public final Object getFirst() {
        return first();
    }

    public final Object getLast() {
        return last();
    }

    final int h(Object obj, Object obj2) {
        return this.a.compare(obj, obj2);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    @Override // java.util.NavigableSet
    public Object higher(Object obj) {
        return gs.c(tailSet(obj, false), null);
    }

    @Override // java.util.SortedSet
    public Object last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    public Object lower(Object obj) {
        return hb.b(headSet(obj, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @Deprecated
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object removeFirst() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final Object removeLast() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public final /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }

    @Override // com.google.android.libraries.navigation.internal.yz.fy, com.google.android.libraries.navigation.internal.yz.ek
    public Object writeReplace() {
        return new gk(this.a, toArray());
    }

    public abstract gl z();
}
