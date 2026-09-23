package com.google.android.libraries.navigation.internal.agi;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class bj {
    @Deprecated
    public static Integer a(bk bkVar, Object obj) {
        int iO = bkVar.o(obj);
        if (iO == 0) {
            if (!bkVar.containsKey(obj)) {
                return null;
            }
            iO = 0;
        }
        return Integer.valueOf(iO);
    }

    @Deprecated
    public static Integer b(bk bkVar, Object obj, Integer num) {
        boolean zContainsKey = bkVar.containsKey(obj);
        int iA = bkVar.a(obj, num.intValue());
        if (zContainsKey) {
            return Integer.valueOf(iA);
        }
        return null;
    }

    @Deprecated
    public static Integer c(bk bkVar, Object obj) {
        if (bkVar.containsKey(obj)) {
            return Integer.valueOf(bkVar.b(obj));
        }
        return null;
    }
}
