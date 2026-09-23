package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ag implements gw {
    final /* synthetic */ ai a;
    private final gw b;

    public ag(ai aiVar, gw gwVar) {
        this.a = aiVar;
        this.b = gwVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final void add(Object obj) {
        this.b.add(obj);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.b.nextIndex() < this.a.c;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return this.b.previousIndex() >= this.a.b;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (hasNext()) {
            return this.b.next();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b.nextIndex() - this.a.b;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final Object previous() {
        if (hasPrevious()) {
            return this.b.previous();
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b.previousIndex() - this.a.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        this.b.remove();
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final void set(Object obj) {
        this.b.set(obj);
    }
}
