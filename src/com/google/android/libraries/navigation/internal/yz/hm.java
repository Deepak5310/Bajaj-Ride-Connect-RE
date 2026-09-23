package com.google.android.libraries.navigation.internal.yz;

import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hm implements ListIterator {
    final Object a;
    int b;
    hk c;
    hk d;
    hk e;
    final /* synthetic */ hn f;

    public hm(hn hnVar, Object obj) {
        this.f = hnVar;
        this.a = obj;
        hj hjVar = (hj) hnVar.c.get(obj);
        this.c = hjVar == null ? null : hjVar.a;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        this.e = this.f.a(this.a, obj, this.c);
        this.b++;
        this.d = null;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.c != null;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.e != null;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        hk hkVar = this.c;
        if (hkVar == null) {
            throw new NoSuchElementException();
        }
        this.d = hkVar;
        this.e = hkVar;
        this.c = hkVar.e;
        this.b++;
        return this.d.b;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        hk hkVar = this.e;
        if (hkVar == null) {
            throw new NoSuchElementException();
        }
        this.d = hkVar;
        this.c = hkVar;
        this.e = hkVar.f;
        this.b--;
        return this.d.b;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        com.google.android.libraries.navigation.internal.yx.ar.l(this.d != null, "no calls to next() since the last call to remove()");
        hk hkVar = this.d;
        if (hkVar != this.c) {
            this.e = hkVar.f;
            this.b--;
        } else {
            this.c = hkVar.e;
        }
        this.f.f(hkVar);
        this.d = null;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        com.google.android.libraries.navigation.internal.yx.ar.k(this.d != null);
        this.d.b = obj;
    }

    public hm(hn hnVar, Object obj, int i) {
        this.f = hnVar;
        hj hjVar = (hj) hnVar.c.get(obj);
        int i2 = hjVar == null ? 0 : hjVar.c;
        com.google.android.libraries.navigation.internal.yx.ar.u(i, i2);
        if (i >= i2 / 2) {
            this.e = hjVar == null ? null : hjVar.b;
            this.b = i2;
            while (i < i2) {
                previous();
                i++;
            }
        } else {
            this.c = hjVar == null ? null : hjVar.a;
            while (i > 0) {
                next();
                i--;
            }
        }
        this.a = obj;
        this.d = null;
    }
}
