package com.google.android.libraries.navigation.internal.agf;

import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class w implements Serializable, Cloneable, aa {
    private static final long serialVersionUID = -7046029254386353129L;

    protected w() {
    }

    private Object readResolve() {
        return y.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.v
    public final float a() {
        throw new NoSuchElementException();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        g((Float) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.aa, com.google.android.libraries.navigation.internal.agf.v
    public final /* synthetic */ Float b() {
        return u.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.v
    /* JADX INFO: renamed from: c */
    public final void forEachRemaining(s sVar) {
    }

    public final Object clone() {
        return y.a;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.h
    public final float d() {
        throw new NoSuchElementException();
    }

    @Override // com.google.android.libraries.navigation.internal.agf.aa
    public final /* synthetic */ Float e() {
        return g.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.aa
    public final /* synthetic */ void f(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.PrimitiveIterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
    }

    @Override // java.util.Iterator, com.google.android.libraries.navigation.internal.agf.v
    @Deprecated
    public final void forEachRemaining(Consumer consumer) {
    }

    @Override // com.google.android.libraries.navigation.internal.agf.aa
    public final /* synthetic */ void g(Float f) {
        z.c(this, f);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.aa
    public final /* synthetic */ void h(float f) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return false;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return false;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.aa
    public final /* synthetic */ void i(Float f) {
        z.e(this, f);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return b();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return 0;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        return e();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return -1;
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        i((Float) obj);
    }
}
