package com.google.android.libraries.navigation.internal.agd;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class d implements aq {
    final /* synthetic */ f a;
    private final aq b;

    public d(f fVar, aq aqVar) {
        this.a = fVar;
        this.b = aqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final /* synthetic */ Byte a() {
        return ak.a(this);
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        g((Byte) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.al
    /* JADX INFO: renamed from: b */
    public final /* synthetic */ void forEachRemaining(ai aiVar) {
        Objects.requireNonNull(aiVar);
        while (hasNext()) {
            aiVar.c(c());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agd.al
    public final byte c() {
        if (hasNext()) {
            return this.b.c();
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.android.libraries.navigation.internal.agd.s
    public final byte d() {
        if (hasPrevious()) {
            return this.b.d();
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final /* synthetic */ Byte e() {
        return r.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final void f(byte b) {
        this.b.f(b);
    }

    @Override // java.util.PrimitiveIterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        forEachRemaining((ai) obj);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        ak.d(this, consumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final /* synthetic */ void g(Byte b) {
        ap.c(this, b);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final void h(byte b) {
        this.b.h(b);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.b.nextIndex() < this.a.c;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return this.b.previousIndex() >= this.a.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq
    public final /* synthetic */ void i(Byte b) {
        ap.e(this, b);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        return a();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.b.nextIndex() - this.a.b;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        return e();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b.previousIndex() - this.a.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.aq, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        this.b.remove();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        i((Byte) obj);
    }
}
