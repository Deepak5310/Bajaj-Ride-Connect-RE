package com.google.android.libraries.navigation.internal.agh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class bw {
    @Deprecated
    public static Long a(bx bxVar, Object obj) {
        if (obj == null) {
            return null;
        }
        long jLongValue = ((Long) obj).longValue();
        long jT = bxVar.t(jLongValue);
        if (jT != bxVar.a() || bxVar.e(jLongValue)) {
            return Long.valueOf(jT);
        }
        return null;
    }

    @Deprecated
    public static Long b(bx bxVar, Long l, Long l2) {
        long jLongValue = l.longValue();
        boolean zE = bxVar.e(jLongValue);
        long jB = bxVar.b(jLongValue, l2.longValue());
        if (zE) {
            return Long.valueOf(jB);
        }
        return null;
    }

    @Deprecated
    public static Long c(bx bxVar, Object obj) {
        if (obj == null) {
            return null;
        }
        long jLongValue = ((Long) obj).longValue();
        if (bxVar.e(jLongValue)) {
            return Long.valueOf(bxVar.c(jLongValue));
        }
        return null;
    }

    @Deprecated
    public static boolean d(bx bxVar, Object obj) {
        if (obj == null) {
            return false;
        }
        return bxVar.e(((Long) obj).longValue());
    }
}
