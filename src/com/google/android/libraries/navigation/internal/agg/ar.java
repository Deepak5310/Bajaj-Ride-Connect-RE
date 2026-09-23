package com.google.android.libraries.navigation.internal.agg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ar {
    @Deprecated
    public static Object a(as asVar, Object obj) {
        if (obj == null) {
            return null;
        }
        int iIntValue = ((Integer) obj).intValue();
        Object objP = asVar.p(iIntValue);
        if (objP != null || asVar.c(iIntValue)) {
            return objP;
        }
        return null;
    }

    @Deprecated
    public static Object b(as asVar, Integer num, Object obj) {
        int iIntValue = num.intValue();
        boolean zC = asVar.c(iIntValue);
        Object objA = asVar.a(iIntValue, obj);
        if (zC) {
            return objA;
        }
        return null;
    }

    @Deprecated
    public static Object c(as asVar, Object obj) {
        if (obj == null) {
            return null;
        }
        int iIntValue = ((Integer) obj).intValue();
        if (asVar.c(iIntValue)) {
            return asVar.b(iIntValue);
        }
        return null;
    }

    @Deprecated
    public static boolean d(as asVar, Object obj) {
        if (obj == null) {
            return false;
        }
        return asVar.c(((Integer) obj).intValue());
    }
}
