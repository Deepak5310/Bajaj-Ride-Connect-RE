package com.google.android.libraries.navigation.internal.agh;

import java.util.Comparator;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class gj {
    @Deprecated
    public static int a(gk gkVar, Long l, Long l2) {
        return gkVar.a(l.longValue(), l2.longValue());
    }

    public static Comparator d(gk gkVar, Comparator comparator) {
        if (comparator instanceof gk) {
            return gkVar.d((gk) comparator);
        }
        throw new NoSuchMethodError();
    }
}
