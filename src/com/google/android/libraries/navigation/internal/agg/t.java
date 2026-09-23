package com.google.android.libraries.navigation.internal.agg;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class t {
    @Deprecated
    public static Integer a(u uVar, Object obj) {
        if (obj == null) {
            return null;
        }
        int iIntValue = ((Integer) obj).intValue();
        int iS = uVar.s(iIntValue);
        if (iS == 0) {
            if (!uVar.d(iIntValue)) {
                return null;
            }
            iS = 0;
        }
        return Integer.valueOf(iS);
    }

    @Deprecated
    public static Integer b(u uVar, Integer num, Integer num2) {
        int iIntValue = num.intValue();
        boolean zD = uVar.d(iIntValue);
        int iA = uVar.a(iIntValue, num2.intValue());
        if (zD) {
            return Integer.valueOf(iA);
        }
        return null;
    }

    @Deprecated
    public static Integer c(u uVar, Object obj) {
        if (obj == null) {
            return null;
        }
        int iIntValue = ((Integer) obj).intValue();
        if (uVar.d(iIntValue)) {
            return Integer.valueOf(uVar.b(iIntValue));
        }
        return null;
    }

    @Deprecated
    public static boolean d(u uVar, Object obj) {
        if (obj == null) {
            return false;
        }
        return uVar.d(((Integer) obj).intValue());
    }
}
