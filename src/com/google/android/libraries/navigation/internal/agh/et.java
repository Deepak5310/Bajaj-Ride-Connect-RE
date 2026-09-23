package com.google.android.libraries.navigation.internal.agh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class et {
    @Deprecated
    public static Object a(eu euVar, Object obj) {
        if (obj == null) {
            return null;
        }
        long jLongValue = ((Long) obj).longValue();
        Object objH = euVar.h(jLongValue);
        if (objH != null || euVar.c(jLongValue)) {
            return objH;
        }
        return null;
    }

    @Deprecated
    public static Object b(eu euVar, Long l, Object obj) {
        long jLongValue = l.longValue();
        boolean zC = euVar.c(jLongValue);
        Object objA = euVar.a(jLongValue, obj);
        if (zC) {
            return objA;
        }
        return null;
    }

    @Deprecated
    public static Object c(eu euVar, Object obj) {
        if (obj == null) {
            return null;
        }
        long jLongValue = ((Long) obj).longValue();
        if (euVar.c(jLongValue)) {
            return euVar.b(jLongValue);
        }
        return null;
    }

    @Deprecated
    public static boolean d(eu euVar, Object obj) {
        if (obj == null) {
            return false;
        }
        return euVar.c(((Long) obj).longValue());
    }
}
