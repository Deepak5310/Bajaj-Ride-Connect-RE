package com.google.android.libraries.navigation.internal.agg;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class ay extends bc implements eu {
    final /* synthetic */ be a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(be beVar) {
        super(beVar);
        this.a = beVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agg.dk
    public final int a() {
        return this.a.a[h()];
    }

    @Override // com.google.android.libraries.navigation.internal.agg.bc
    public final /* bridge */ /* synthetic */ void aN(Object obj, int i) {
        ((IntConsumer) obj).accept(this.a.a[i]);
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        d((Integer) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.eu
    public final /* synthetic */ Integer b() {
        return dj.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.eu
    public final /* synthetic */ void c(int i) {
        et.g();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.eu
    public final /* synthetic */ void d(Integer num) {
        et.c(this, num);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.eu
    public final /* synthetic */ void e(int i) {
        et.i();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.eu
    public final /* synthetic */ void f(Integer num) {
        et.e(this, num);
    }

    @Override // java.util.Iterator, com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        eh.c(this, consumer);
    }

    @Override // java.util.PrimitiveIterator.OfInt
    public final /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        super.forEachRemaining((Object) intConsumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agg.eu, java.util.ListIterator, java.util.Iterator, com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt
    public final /* synthetic */ Integer next() {
        return eh.a(this);
    }

    @Override // java.util.ListIterator, java.util.Iterator, java.util.PrimitiveIterator.OfInt
    public final /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // com.google.android.libraries.navigation.internal.agg.ei, java.util.PrimitiveIterator.OfInt
    public final int nextInt() {
        return this.a.a[g()];
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        return b();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        f((Integer) obj);
    }
}
