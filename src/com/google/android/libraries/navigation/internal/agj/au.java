package com.google.android.libraries.navigation.internal.agj;

import java.util.Objects;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class au {
    public static av a(final av avVar, final av avVar2) {
        Objects.requireNonNull(avVar2);
        return new av() { // from class: com.google.android.libraries.navigation.internal.agj.aq
            @Override // com.google.android.libraries.navigation.internal.agj.av
            public final /* synthetic */ av a(av avVar3) {
                return au.a(this, avVar3);
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
            public final /* synthetic */ av d(av avVar3) {
                return au.c(this, avVar3);
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
                return avVar.g(s) && avVar2.g(s);
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
        };
    }

    public static av b(av avVar, IntPredicate intPredicate) {
        av arVar;
        if (intPredicate instanceof av) {
            arVar = (av) intPredicate;
        } else {
            Objects.requireNonNull(intPredicate);
            arVar = new ar(intPredicate);
        }
        return avVar.a(arVar);
    }

    public static av c(final av avVar, final av avVar2) {
        Objects.requireNonNull(avVar2);
        return new av() { // from class: com.google.android.libraries.navigation.internal.agj.ap
            @Override // com.google.android.libraries.navigation.internal.agj.av
            public final /* synthetic */ av a(av avVar3) {
                return au.a(this, avVar3);
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
            public final /* synthetic */ av d(av avVar3) {
                return au.c(this, avVar3);
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
                return avVar.g(s) || avVar2.g(s);
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
        };
    }

    public static av d(av avVar, IntPredicate intPredicate) {
        av arVar;
        if (intPredicate instanceof av) {
            arVar = (av) intPredicate;
        } else {
            Objects.requireNonNull(intPredicate);
            arVar = new ar(intPredicate);
        }
        return avVar.d(arVar);
    }

    @Deprecated
    public static boolean i(av avVar, int i) {
        return avVar.g(com.google.android.libraries.navigation.internal.agc.g.c(i));
    }

    @Deprecated
    public static boolean k(av avVar, Short sh) {
        return avVar.g(sh.shortValue());
    }

    @Deprecated
    public static void l() {
        at.a();
    }

    @Deprecated
    public static void m() {
        at.a();
    }
}
