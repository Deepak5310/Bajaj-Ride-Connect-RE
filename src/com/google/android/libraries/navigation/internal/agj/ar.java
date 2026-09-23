package com.google.android.libraries.navigation.internal.agj;

import java.util.function.IntPredicate;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ar implements av {
    public final /* synthetic */ IntPredicate a;

    public /* synthetic */ ar(IntPredicate intPredicate) {
        this.a = intPredicate;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.av
    public final /* synthetic */ av a(av avVar) {
        return au.a(this, avVar);
    }

    @Override // java.util.function.IntPredicate
    public final /* bridge */ /* synthetic */ IntPredicate and(IntPredicate intPredicate) {
        return b(intPredicate);
    }

    @Override // java.util.function.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        au.l();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agj.av
    public final /* synthetic */ av b(IntPredicate intPredicate) {
        return au.b(this, intPredicate);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.av
    public final /* synthetic */ av c() {
        return new as(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.av
    public final /* synthetic */ av d(av avVar) {
        return au.c(this, avVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.av
    public final /* synthetic */ av e(IntPredicate intPredicate) {
        return au.d(this, intPredicate);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.av
    public final /* synthetic */ boolean f(Short sh) {
        return au.k(this, sh);
    }

    @Override // com.google.android.libraries.navigation.internal.agj.av
    public final boolean g(short s) {
        return this.a.test(s);
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
        au.m();
        return null;
    }

    @Override // java.util.function.IntPredicate
    public final /* synthetic */ boolean test(int i) {
        return au.i(this, i);
    }

    @Override // java.util.function.Predicate
    public final /* bridge */ /* synthetic */ boolean test(Object obj) {
        return f((Short) obj);
    }
}
