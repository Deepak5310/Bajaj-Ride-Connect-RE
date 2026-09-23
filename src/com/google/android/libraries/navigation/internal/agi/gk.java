package com.google.android.libraries.navigation.internal.agi;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class gk extends gj implements gw {
    protected gk(int i) {
        super(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final void add(Object obj) {
        int i = this.b;
        this.b = i + 1;
        c(i, obj);
        this.c = -1;
    }

    protected abstract void c(int i, Object obj);

    protected abstract void e(int i, Object obj);

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    public Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.b - 1;
        this.b = i;
        this.c = i;
        return b(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override // com.google.android.libraries.navigation.internal.agi.gw, java.util.ListIterator
    public final void set(Object obj) {
        int i = this.c;
        if (i == -1) {
            throw new IllegalStateException();
        }
        e(i, obj);
    }
}
