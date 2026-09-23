package com.google.android.libraries.navigation.internal.agh;

import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* JADX INFO: renamed from: com.google.android.libraries.navigation.internal.agh.do, reason: invalid class name */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class Cdo extends ds implements ha {
    final /* synthetic */ du a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Cdo(du duVar) {
        super(duVar);
        this.a = duVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gb
    public final long a() {
        return this.a.a[h()];
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ds
    public final /* bridge */ /* synthetic */ void aQ(Object obj, int i) {
        ((LongConsumer) obj).accept(this.a.a[i]);
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void add(Object obj) {
        d((Long) obj);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final /* synthetic */ Long b() {
        return ga.a(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final /* synthetic */ void c(long j) {
        gz.g();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final /* synthetic */ void d(Long l) {
        gz.c(this, l);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final /* synthetic */ void e(long j) {
        gz.h();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha
    public final /* synthetic */ void f(Long l) {
        gz.e(this, l);
    }

    @Override // java.util.Iterator, com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        gr.c(this, consumer);
    }

    @Override // java.util.PrimitiveIterator.OfLong
    public final /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        super.forEachRemaining((Object) longConsumer);
    }

    @Override // com.google.android.libraries.navigation.internal.agh.ha, java.util.ListIterator, java.util.Iterator, com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    public final /* synthetic */ Long next() {
        return gr.a(this);
    }

    @Override // java.util.ListIterator, java.util.Iterator, java.util.PrimitiveIterator.OfLong
    public final /* bridge */ /* synthetic */ Object next() {
        return next();
    }

    @Override // com.google.android.libraries.navigation.internal.agh.gs, java.util.PrimitiveIterator.OfLong
    public final long nextLong() {
        return this.a.a[g()];
    }

    @Override // java.util.ListIterator, com.google.android.libraries.navigation.internal.agc.b
    public final /* bridge */ /* synthetic */ Object previous() {
        return b();
    }

    @Override // java.util.ListIterator
    public final /* bridge */ /* synthetic */ void set(Object obj) {
        f((Long) obj);
    }
}
