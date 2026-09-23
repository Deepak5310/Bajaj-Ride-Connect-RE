package com.google.android.libraries.navigation.internal.agh;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class aw {
    @Deprecated
    public static Integer a(ax axVar, Object obj) {
        if (obj == null) {
            return null;
        }
        long jLongValue = ((Long) obj).longValue();
        int iS = axVar.s(jLongValue);
        if (iS == 0) {
            if (!axVar.d(jLongValue)) {
                return null;
            }
            iS = 0;
        }
        return Integer.valueOf(iS);
    }

    @Deprecated
    public static Integer b(ax axVar, Long l, Integer num) {
        long jLongValue = l.longValue();
        boolean zD = axVar.d(jLongValue);
        int iA = axVar.a(jLongValue, num.intValue());
        if (zD) {
            return Integer.valueOf(iA);
        }
        return null;
    }

    @Deprecated
    public static Integer c(ax axVar, Object obj) {
        if (obj == null) {
            return null;
        }
        long jLongValue = ((Long) obj).longValue();
        if (axVar.d(jLongValue)) {
            return Integer.valueOf(axVar.b(jLongValue));
        }
        return null;
    }

    @Deprecated
    public static boolean d(ax axVar, Object obj) {
        if (obj == null) {
            return false;
        }
        return axVar.d(((Long) obj).longValue());
    }
}
