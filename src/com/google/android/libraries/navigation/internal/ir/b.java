package com.google.android.libraries.navigation.internal.ir;

import android.app.ActivityManager;
import android.content.Context;
import com.google.android.libraries.navigation.internal.yx.an;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class b {
    private static an a = com.google.android.libraries.navigation.internal.yx.a.a;

    public static int a(Context context) {
        Integer numValueOf = (Integer) a.f();
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion);
            a = an.j(numValueOf);
        }
        return numValueOf.intValue();
    }
}
