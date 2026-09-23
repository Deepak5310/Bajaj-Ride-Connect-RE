package com.google.android.libraries.navigation.internal.yz;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class df extends Cdo implements Collection {
    protected df() {
    }

    protected abstract Collection a();

    @Override // com.google.android.libraries.navigation.internal.yz.Cdo
    protected /* bridge */ /* synthetic */ Object aF() {
        throw null;
    }

    public boolean add(Object obj) {
        return a().add(obj);
    }

    public boolean addAll(Collection collection) {
        return a().addAll(collection);
    }

    public void clear() {
        a().clear();
    }

    public boolean contains(Object obj) {
        return a().contains(obj);
    }

    public boolean containsAll(Collection collection) {
        return a().containsAll(collection);
    }

    public final boolean d(Object obj) {
        return hb.g(iterator(), obj);
    }

    protected final boolean e(Collection collection) {
        Iterator it2 = iterator();
        com.google.android.libraries.navigation.internal.yx.ar.q(collection);
        boolean z = false;
        while (it2.hasNext()) {
            if (!collection.contains(it2.next())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    protected final Object[] f() {
        return toArray(new Object[size()]);
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return a().isEmpty();
    }

    public Iterator iterator() {
        return a().iterator();
    }

    public boolean remove(Object obj) {
        return a().remove(obj);
    }

    public boolean removeAll(Collection collection) {
        return a().removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        return a().retainAll(collection);
    }

    @Override // java.util.Collection
    public final int size() {
        return a().size();
    }

    public Object[] toArray() {
        return a().toArray();
    }

    public Object[] toArray(Object[] objArr) {
        return a().toArray(objArr);
    }
}
