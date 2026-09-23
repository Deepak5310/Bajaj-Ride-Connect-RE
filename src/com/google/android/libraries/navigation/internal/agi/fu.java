package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fu implements gw {
    int a;
    int b = -1;
    final /* synthetic */ int c;
    final /* synthetic */ fz d;

    public fu(fz fzVar, int i) {
        this.c = i;
        this.d = fzVar;
        this.a = i;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final void add(Object obj) {
        int i = this.a;
        this.a = i + 1;
        this.d.add(i, obj);
        this.b = -1;
    }

    @Override // java.util.Iterator
    public final void forEachRemaining(Consumer consumer) {
        while (true) {
            int i = this.a;
            fz fzVar = this.d;
            if (i >= fzVar.b) {
                return;
            }
            Object[] objArr = fzVar.a;
            this.a = i + 1;
            this.b = i;
            consumer.accept(objArr[i]);
        }
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.a < this.d.b;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return this.a > 0;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.d.a;
        int i = this.a;
        this.a = i + 1;
        this.b = i;
        return objArr[i];
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.a;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.d.a;
        int i = this.a - 1;
        this.a = i;
        this.b = i;
        return objArr[i];
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.a - 1;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        int i = this.b;
        if (i == -1) {
            throw new IllegalStateException();
        }
        this.d.remove(i);
        int i2 = this.b;
        int i3 = this.a;
        if (i2 < i3) {
            this.a = i3 - 1;
        }
        this.b = -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final void set(Object obj) {
        int i = this.b;
        if (i == -1) {
            throw new IllegalStateException();
        }
        this.d.set(i, obj);
    }
}
