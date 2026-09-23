package com.google.android.libraries.navigation.internal.agg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class cc {
    @Deprecated
    public static Object a(cd cdVar, Object obj) {
        if (obj == null) {
            return null;
        }
        int iIntValue = ((Integer) obj).intValue();
        Object objH = cdVar.h(iIntValue);
        if (objH != null || cdVar.c(iIntValue)) {
            return objH;
        }
        return null;
    }

    @Deprecated
    public static Object b(cd cdVar, Integer num, Object obj) {
        int iIntValue = num.intValue();
        boolean zC = cdVar.c(iIntValue);
        Object objA = cdVar.a(iIntValue, obj);
        if (zC) {
            return objA;
        }
        return null;
    }

    @Deprecated
    public static Object c(cd cdVar, Object obj) {
        if (obj == null) {
            return null;
        }
        int iIntValue = ((Integer) obj).intValue();
        if (cdVar.c(iIntValue)) {
            return cdVar.b(iIntValue);
        }
        return null;
    }

    @Deprecated
    public static boolean d(cd cdVar, Object obj) {
        if (obj == null) {
            return false;
        }
        return cdVar.c(((Integer) obj).intValue());
    }
}
