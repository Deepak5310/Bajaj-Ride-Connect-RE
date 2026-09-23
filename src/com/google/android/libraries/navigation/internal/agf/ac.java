package com.google.android.libraries.navigation.internal.agf;

import java.util.function.DoublePredicate;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ac implements ah {
    public final /* synthetic */ ah a;

    public /* synthetic */ ac(ah ahVar) {
        this.a = ahVar;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.ah
    public final /* synthetic */ ah a(ah ahVar) {
        return ag.a(this, ahVar);
    }

    @Override // java.util.function.DoublePredicate
    public final /* bridge */ /* synthetic */ DoublePredicate and(DoublePredicate doublePredicate) {
        return b(doublePredicate);
    }

    @Override // java.util.function.Predicate
    public final /* synthetic */ Predicate and(Predicate predicate) {
        ag.l();
        return null;
    }

    @Override // com.google.android.libraries.navigation.internal.agf.ah
    public final /* synthetic */ ah b(DoublePredicate doublePredicate) {
        return ag.b(this, doublePredicate);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.ah
    public final /* synthetic */ ah c() {
        return new ac(this);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.ah
    public final /* synthetic */ ah d(ah ahVar) {
        return ag.c(this, ahVar);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.ah
    public final /* synthetic */ ah e(DoublePredicate doublePredicate) {
        return ag.d(this, doublePredicate);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.ah
    public final boolean f(float f) {
        return !this.a.f(f);
    }

    @Override // com.google.android.libraries.navigation.internal.agf.ah
    public final /* synthetic */ boolean g(Float f) {
        return ag.j(this, f);
    }

    @Override // java.util.function.Predicate, java.util.function.DoublePredicate
    public final /* bridge */ /* synthetic */ DoublePredicate negate() {
        return c();
    }

    @Override // java.util.function.Predicate, java.util.function.DoublePredicate
    public final /* bridge */ /* synthetic */ Predicate negate() {
        return c();
    }

    @Override // java.util.function.DoublePredicate
    public final /* bridge */ /* synthetic */ DoublePredicate or(DoublePredicate doublePredicate) {
        return e(doublePredicate);
    }

    @Override // java.util.function.Predicate
    public final /* synthetic */ Predicate or(Predicate predicate) {
        ag.m();
        return null;
    }

    @Override // java.util.function.DoublePredicate
    public final /* synthetic */ boolean test(double d) {
        return ag.i(this, d);
    }

    @Override // java.util.function.Predicate
    public final /* bridge */ /* synthetic */ boolean test(Object obj) {
        return g((Float) obj);
    }
}
