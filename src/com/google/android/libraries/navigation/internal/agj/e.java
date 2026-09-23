package com.google.android.libraries.navigation.internal.agj;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class e implements ao {
    final /* synthetic */ g a;
    private final ao b;

    public e(g gVar, ao aoVar) {
        this.a = gVar;
        this.b = aoVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final /* synthetic */ Short a() {
        return ai.a(this);
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        f((Short) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.aj
    /* JADX INFO: renamed from: b */
    public final /* synthetic */ void forEachRemaining(ag agVar) {
        Objects.requireNonNull(agVar);
        while (hasNext()) {
            agVar.d(d());
        }
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final /* synthetic */ Short c() {
        return q.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.aj
    public final short d() {
        if (hasNext()) {
            return this.b.d();
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.android.libraries.navigation.internal.agj.r
    public final short e() {
        if (hasPrevious()) {
            return this.b.e();
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final /* synthetic */ void f(Short sh) {
        an.d(this, sh);
    }

    @Override // java.util.PrimitiveIterator
    public final /* bridge */ /* synthetic */ void forEachRemaining(Object obj) {
        forEachRemaining((ag) obj);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        ai.c(this, consumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final void g(short s) {
        this.b.g(s);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final /* synthetic */ void h(Short sh) {
        an.f(this, sh);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.b.nextIndex() < this.a.c;
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final boolean hasPrevious() {
        return this.b.previousIndex() >= this.a.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao
    public final void i(short s) {
        this.b.i(s);
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
        return c();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.b.previousIndex() - this.a.b;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.ao, java.util.ListIterator, java.util.Iterator
    public final void remove() {
        this.b.remove();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        h((Short) obj);
    }
}
