package com.google.android.libraries.navigation.internal.agd;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class an extends am implements aq {
    protected an(int i) {
        super(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.b, com.google.android.libraries.navigation.internal.agd.al, com.google.android.libraries.navigation.internal.agd.aq
    public final /* synthetic */ Byte a() {
        return ak.a(this);
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        g((Byte) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.s
    public byte d() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.b - 1;
        this.b = i;
        this.c = i;
        return j(i);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final /* synthetic */ Byte e() {
        return r.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final void f(byte b) {
        int i = this.b;
        this.b = i + 1;
        l(i, b);
        this.c = -1;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final /* synthetic */ void g(Byte b) {
        ap.c(this, b);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final void h(byte b) {
        int i = this.c;
        if (i == -1) {
            throw new IllegalStateException();
        }
        n(i, b);
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return this.b > 0;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final /* synthetic */ void i(Byte b) {
        ap.e(this, b);
    }

    protected abstract void l(int i, byte b);

    protected abstract void n(int i, byte b);

    @Override // com.google.android.libraries.navigation.internal.agd.b, java.util.Iterator, java.util.ListIterator
    public final /* bridge */ /* synthetic */ Object next() {
        return a();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        return e();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b - 1;
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        i((Byte) obj);
    }
}
