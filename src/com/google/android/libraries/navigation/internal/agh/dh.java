package com.google.android.libraries.navigation.internal.agh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class dh {
    @Deprecated
    public static Object a(di diVar, Object obj) {
        if (obj == null) {
            return null;
        }
        long jLongValue = ((Long) obj).longValue();
        Object objAO = diVar.aO(jLongValue);
        if (objAO != null || diVar.c(jLongValue)) {
            return objAO;
        }
        return null;
    }

    @Deprecated
    public static Object b(di diVar, Long l, Object obj) {
        long jLongValue = l.longValue();
        boolean zC = diVar.c(jLongValue);
        Object objA = diVar.a(jLongValue, obj);
        if (zC) {
            return objA;
        }
        return null;
    }

    @Deprecated
    public static Object c(di diVar, Object obj) {
        if (obj == null) {
            return null;
        }
        long jLongValue = ((Long) obj).longValue();
        if (diVar.c(jLongValue)) {
            return diVar.b(jLongValue);
        }
        return null;
    }

    @Deprecated
    public static boolean d(di diVar, Object obj) {
        if (obj == null) {
            return false;
        }
        return diVar.c(((Long) obj).longValue());
    }
}
