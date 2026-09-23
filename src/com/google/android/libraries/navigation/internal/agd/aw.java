package com.google.android.libraries.navigation.internal.agd;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class aw implements ba {
    public final /* synthetic */ IntPredicate a;

    public /* synthetic */ aw(IntPredicate intPredicate) {
        this.a = intPredicate;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ba
    public final /* synthetic */ ba a(ba baVar) {
        return az.a(this, baVar);
    }

    @Override // java.util.function.IntPredicate
    public final /* bridge */ /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
        return b(intPredicate);
    }

    @Override // java.util.function.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        az.l();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ba
    public final /* synthetic */ ba b(IntPredicate intPredicate) {
        return az.b(this, intPredicate);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ba
    public final /* synthetic */ ba c() {
        return new av(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ba
    public final /* synthetic */ ba d(ba baVar) {
        return az.c(this, baVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ba
    public final /* synthetic */ ba e(IntPredicate intPredicate) {
        return az.d(this, intPredicate);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ba
    public final boolean f(byte b) {
        return this.a.test(b);
    }

    @Override // com.google.android.libraries.navigation.internal.agd.ba
    public final /* synthetic */ boolean g(Byte b) {
        return az.j(this, b);
    }

    @Override // java.util.function.Predicate, java.util.function.IntPredicate
    public final /* bridge */ /* synthetic */ IntPredicate negate() {
        return c();
    }

    @Override // java.util.function.Predicate, java.util.function.IntPredicate
    public final /* bridge */ /* synthetic */ Predicate negate() {
        return c();
    }

    @Override // java.util.function.IntPredicate
    public final /* bridge */ /* synthetic */ IntPredicate or(IntPredicate intPredicate) {
        return e(intPredicate);
    }

    @Override // java.util.function.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        az.m();
        return null;
    }

    @Override // java.util.function.IntPredicate
    public final /* synthetic */ boolean test(int i) {
        return az.i(this, i);
    }

    @Override // java.util.function.Predicate
    public final /* bridge */ /* synthetic */ boolean test(Object obj) {
        return g((Byte) obj);
    }
}
