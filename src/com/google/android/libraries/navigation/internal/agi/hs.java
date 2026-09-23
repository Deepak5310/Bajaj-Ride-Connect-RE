package com.google.android.libraries.navigation.internal.agi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class hs {
    @Deprecated
    public static Integer a(ht htVar, Object obj) {
        int iO = htVar.o(obj);
        if (iO == 0) {
            if (!htVar.containsKey(obj)) {
                return null;
            }
            iO = 0;
        }
        return Integer.valueOf(iO);
    }

    @Deprecated
    public static Integer b(ht htVar, Object obj, Integer num) {
        boolean zContainsKey = htVar.containsKey(obj);
        int iA = htVar.a(obj, num.intValue());
        if (zContainsKey) {
            return Integer.valueOf(iA);
        }
        return null;
    }

    @Deprecated
    public static Integer c(ht htVar, Object obj) {
        if (htVar.containsKey(obj)) {
            return Integer.valueOf(htVar.b(obj));
        }
        return null;
    }
}
