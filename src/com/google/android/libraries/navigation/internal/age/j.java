package com.google.android.libraries.navigation.internal.age;

import java.util.function.DoublePredicate;
import java.util.function.Predicate;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class j {
    @Deprecated
    public static boolean a(k kVar, Double d) {
        return kVar.c(d.doubleValue());
    }

    @Deprecated
    public static boolean b(k kVar, final Predicate predicate) {
        return kVar.i(predicate instanceof DoublePredicate ? (DoublePredicate) predicate : new DoublePredicate() { // from class: com.google.android.libraries.navigation.internal.age.h
            @Override // java.util.function.DoublePredicate
            public final boolean test(double d) {
                return predicate.test(Double.valueOf(d));
            }
        });
    }
}
