package com.google.android.libraries.navigation.internal.agf;

import java.util.Objects;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ag {
    public static ah a(final ah ahVar, final ah ahVar2) {
        Objects.requireNonNull(ahVar2);
        return new ah() { // from class: com.google.android.libraries.navigation.internal.agf.ab
            @Override // com.google.android.libraries.navigation.internal.agf.ah
            public final /* synthetic */ ah a(ah ahVar3) {
                return ag.a(this, ahVar3);
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
            public final /* synthetic */ ah d(ah ahVar3) {
                return ag.c(this, ahVar3);
            }

            @Override // com.google.android.libraries.navigation.internal.agf.ah
            public final /* synthetic */ ah e(DoublePredicate doublePredicate) {
                return ag.d(this, doublePredicate);
            }

            @Override // com.google.android.libraries.navigation.internal.agf.ah
            public final boolean f(float f) {
                return ahVar.f(f) && ahVar2.f(f);
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
        };
    }

    public static ah b(ah ahVar, DoublePredicate doublePredicate) {
        ah adVar;
        if (doublePredicate instanceof ah) {
            adVar = (ah) doublePredicate;
        } else {
            Objects.requireNonNull(doublePredicate);
            adVar = new ad(doublePredicate);
        }
        return ahVar.a(adVar);
    }

    public static ah c(final ah ahVar, final ah ahVar2) {
        Objects.requireNonNull(ahVar2);
        return new ah() { // from class: com.google.android.libraries.navigation.internal.agf.ae
            @Override // com.google.android.libraries.navigation.internal.agf.ah
            public final /* synthetic */ ah a(ah ahVar3) {
                return ag.a(this, ahVar3);
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
            public final /* synthetic */ ah d(ah ahVar3) {
                return ag.c(this, ahVar3);
            }

            @Override // com.google.android.libraries.navigation.internal.agf.ah
            public final /* synthetic */ ah e(DoublePredicate doublePredicate) {
                return ag.d(this, doublePredicate);
            }

            @Override // com.google.android.libraries.navigation.internal.agf.ah
            public final boolean f(float f) {
                return ahVar.f(f) || ahVar2.f(f);
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
        };
    }

    public static ah d(ah ahVar, DoublePredicate doublePredicate) {
        ah adVar;
        if (doublePredicate instanceof ah) {
            adVar = (ah) doublePredicate;
        } else {
            Objects.requireNonNull(doublePredicate);
            adVar = new ad(doublePredicate);
        }
        return ahVar.d(adVar);
    }

    @Deprecated
    public static boolean i(ah ahVar, double d) {
        return ahVar.f(com.google.android.libraries.navigation.internal.agc.g.b(d));
    }

    @Deprecated
    public static boolean j(ah ahVar, Float f) {
        return ahVar.f(f.floatValue());
    }

    @Deprecated
    public static void l() {
        af.a();
    }

    @Deprecated
    public static void m() {
        af.a();
    }
}
