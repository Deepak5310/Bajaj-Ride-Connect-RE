package com.google.android.libraries.navigation.internal.agg;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ds {
    @Deprecated
    public static int a(dt dtVar, Integer num, Integer num2) {
        return dtVar.a(num.intValue(), num2.intValue());
    }

    public static Comparator d(dt dtVar, Comparator comparator) {
        if (comparator instanceof dt) {
            return dtVar.d((dt) comparator);
        }
        throw new NoSuchMethodError();
    }
}
