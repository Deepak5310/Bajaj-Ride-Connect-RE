package com.google.android.libraries.navigation.internal.ll;

import android.os.Process;
import com.google.android.libraries.navigation.internal.yx.bq;
import com.google.android.libraries.navigation.internal.yx.cb;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class j {
    public static String a;
    public static int b;
    private static Boolean c;

    public static boolean a() {
        Boolean boolValueOf = c;
        if (boolValueOf == null) {
            if (i.e()) {
                boolValueOf = Boolean.valueOf(Process.isIsolated());
            } else {
                try {
                    Object objInvoke = Process.class.getDeclaredMethod("isIsolated", null).invoke(null, null);
                    Object[] objArr = new Object[0];
                    if (objInvoke == null) {
                        throw new cb(bq.a("expected a non-null reference", objArr));
                    }
                    boolValueOf = (Boolean) objInvoke;
                } catch (ReflectiveOperationException unused) {
                    boolValueOf = false;
                }
            }
            c = boolValueOf;
        }
        return boolValueOf.booleanValue();
    }
}
