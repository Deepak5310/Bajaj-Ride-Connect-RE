package com.google.android.libraries.navigation.internal.yz;

import java.util.ConcurrentModificationException;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class hl implements ListIterator {
    int a;
    hk b;
    hk c;
    hk d;
    int e;
    final /* synthetic */ hn f;

    public hl(hn hnVar, int i) {
        this.f = hnVar;
        this.e = hnVar.e;
        int i2 = hnVar.d;
        com.google.android.libraries.navigation.internal.yx.ar.u(i, i2);
        if (i >= i2 / 2) {
            this.d = hnVar.b;
            this.a = i2;
            while (i < i2) {
                previous();
                i++;
            }
        } else {
            this.b = hnVar.a;
            while (i > 0) {
                next();
                i--;
            }
        }
        this.c = null;
    }

    private final void c() {
        if (this.f.e != this.e) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final hk next() {
        c();
        hk hkVar = this.b;
        if (hkVar == null) {
            throw new NoSuchElementException();
        }
        this.c = hkVar;
        this.d = hkVar;
        this.b = hkVar.c;
        this.a++;
        return this.c;
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final hk previous() {
        c();
        hk hkVar = this.d;
        if (hkVar == null) {
            throw new NoSuchElementException();
        }
        this.c = hkVar;
        this.b = hkVar;
        this.d = hkVar.d;
        this.a--;
        return this.c;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        c();
        return this.b != null;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        c();
        return this.d != null;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.a;
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.a - 1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        c();
        com.google.android.libraries.navigation.internal.yx.ar.l(this.c != null, "no calls to next() since the last call to remove()");
        hk hkVar = this.c;
        if (hkVar != this.b) {
            this.d = hkVar.d;
            this.a--;
        } else {
            this.b = hkVar.c;
        }
        this.f.f(hkVar);
        this.c = null;
        this.e = this.f.e;
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
