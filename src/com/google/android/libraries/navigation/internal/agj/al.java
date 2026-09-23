package com.google.android.libraries.navigation.internal.agj;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class al extends ak implements ao {
    protected al(int i) {
        super(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.b, com.google.android.libraries.navigation.internal.agj.aj, com.google.android.libraries.navigation.internal.agj.ao
    public final /* synthetic */ Short a() {
        return ai.a(this);
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        f((Short) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final /* synthetic */ Short c() {
        return q.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.r
    public short e() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.b - 1;
        this.b = i;
        this.c = i;
        return k(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final /* synthetic */ void f(Short sh) {
        an.d(this, sh);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final void g(short s) {
        int i = this.b;
        this.b = i + 1;
        l(i, s);
        this.c = -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final /* synthetic */ void h(Short sh) {
        an.f(this, sh);
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final void i(short s) {
        int i = this.c;
        if (i == -1) {
            throw new IllegalStateException();
        }
        n(i, s);
    }

    protected abstract void l(int i, short s);

    protected abstract void n(int i, short s);

    @Override // com.google.android.libraries.navigation.internal.agj.b, java.util.Iterator, java.util.ListIterator
    public final /* bridge */ /* synthetic */ Object next() {
        return a();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        return c();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        h((Short) obj);
    }
}
