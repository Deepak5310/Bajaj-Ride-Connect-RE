package com.google.android.libraries.navigation.internal.agh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ak {
    @Deprecated
    public static Double a(al alVar, Object obj) {
        if (obj == null) {
            return null;
        }
        long jLongValue = ((Long) obj).longValue();
        double dT = alVar.t(jLongValue);
        if (dT != alVar.a() || alVar.e(jLongValue)) {
            return Double.valueOf(dT);
        }
        return null;
    }

    @Deprecated
    public static Double b(al alVar, Long l, Double d) {
        long jLongValue = l.longValue();
        boolean zE = alVar.e(jLongValue);
        double dB = alVar.b(jLongValue, d.doubleValue());
        if (zE) {
            return Double.valueOf(dB);
        }
        return null;
    }

    @Deprecated
    public static Double c(al alVar, Object obj) {
        if (obj == null) {
            return null;
        }
        long jLongValue = ((Long) obj).longValue();
        if (alVar.e(jLongValue)) {
            return Double.valueOf(alVar.c(jLongValue));
        }
        return null;
    }

    @Deprecated
    public static boolean d(al alVar, Object obj) {
        if (obj == null) {
            return false;
        }
        return alVar.e(((Long) obj).longValue());
    }
}
