package com.google.android.libraries.navigation.internal.agj;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class w {
    @Deprecated
    public static int b(x xVar, Short sh, Short sh2) {
        return xVar.b(sh.shortValue(), sh2.shortValue());
    }

    public static Comparator d(x xVar, Comparator comparator) {
        if (comparator instanceof x) {
            return xVar.d((x) comparator);
        }
        throw new NoSuchMethodError();
    }
}
