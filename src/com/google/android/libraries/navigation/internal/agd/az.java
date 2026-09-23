package com.google.android.libraries.navigation.internal.agd;

import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class az {
    public static ba a(final ba baVar, final ba baVar2) {
        Objects.requireNonNull(baVar2);
        return new ba() { // from class: com.google.android.libraries.navigation.internal.agd.ax
            @Override // com.google.android.libraries.navigation.internal.agd.ba
            public final /* synthetic */ ba a(ba baVar3) {
                return az.a(this, baVar3);
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
            public final /* synthetic */ ba d(ba baVar3) {
                return az.c(this, baVar3);
            }

            @Override // com.google.android.libraries.navigation.internal.agd.ba
            public final /* synthetic */ ba e(IntPredicate intPredicate) {
                return az.d(this, intPredicate);
            }

            @Override // com.google.android.libraries.navigation.internal.agd.ba
            public final boolean f(byte b) {
                return baVar.f(b) && baVar2.f(b);
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
        };
    }

    public static ba b(ba baVar, IntPredicate intPredicate) {
        ba awVar;
        if (intPredicate instanceof ba) {
            awVar = (ba) intPredicate;
        } else {
            Objects.requireNonNull(intPredicate);
            awVar = new aw(intPredicate);
        }
        return baVar.a(awVar);
    }

    public static ba c(final ba baVar, final ba baVar2) {
        Objects.requireNonNull(baVar2);
        return new ba() { // from class: com.google.android.libraries.navigation.internal.agd.au
            @Override // com.google.android.libraries.navigation.internal.agd.ba
            public final /* synthetic */ ba a(ba baVar3) {
                return az.a(this, baVar3);
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
            public final /* synthetic */ ba d(ba baVar3) {
                return az.c(this, baVar3);
            }

            @Override // com.google.android.libraries.navigation.internal.agd.ba
            public final /* synthetic */ ba e(IntPredicate intPredicate) {
                return az.d(this, intPredicate);
            }

            @Override // com.google.android.libraries.navigation.internal.agd.ba
            public final boolean f(byte b) {
                return baVar.f(b) || baVar2.f(b);
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
        };
    }

    public static ba d(ba baVar, IntPredicate intPredicate) {
        ba awVar;
        if (intPredicate instanceof ba) {
            awVar = (ba) intPredicate;
        } else {
            Objects.requireNonNull(intPredicate);
            awVar = new aw(intPredicate);
        }
        return baVar.d(awVar);
    }

    @Deprecated
    public static boolean i(ba baVar, int i) {
        return baVar.f(com.google.android.libraries.navigation.internal.agc.g.a(i));
    }

    @Deprecated
    public static boolean j(ba baVar, Byte b) {
        return baVar.f(b.byteValue());
    }

    @Deprecated
    public static void l() {
        ay.a();
    }

    @Deprecated
    public static void m() {
        ay.a();
    }
}
