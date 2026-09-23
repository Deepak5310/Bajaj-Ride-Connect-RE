package com.google.android.libraries.navigation.environment;

import android.app.Application;
import android.content.Context;
import com.google.android.material.timepicker.TimeModel;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class y {
    private static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.environment.y");

    public static synchronized void a(Context context) {
        com.google.android.libraries.navigation.internal.aac.bj bjVarF;
        Application applicationA = com.google.android.libraries.navigation.internal.abf.b.a(context);
        StringBuilder sb = new StringBuilder();
        Iterator it2 = com.google.android.libraries.navigation.internal.yx.bj.d(".").g("6.1.0").iterator();
        while (it2.hasNext()) {
            sb.append(String.format(Locale.US, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(Integer.parseInt((String) it2.next()))));
        }
        int i = Integer.parseInt(sb.toString());
        com.google.android.libraries.navigation.internal.xo.y yVarA = com.google.android.libraries.navigation.internal.xo.y.a(applicationA);
        if (yVarA == null) {
            bjVarF = com.google.android.libraries.navigation.internal.aac.be.a;
        } else {
            com.google.android.libraries.navigation.internal.xp.l lVarB = yVarA.b();
            int i2 = com.google.android.libraries.navigation.internal.afv.a.a;
            bjVarF = lVarB.f(com.google.android.libraries.navigation.internal.xo.o.b(applicationA, "nav_android_sdk"), i, new String[]{"MAPS_API", "GMM_REALTIME_COUNTERS", "NAVIGATION_SDK_COUNTERS"});
        }
        com.google.android.libraries.navigation.internal.aac.az.o(bjVarF, new x(), com.google.android.libraries.navigation.internal.aac.ac.INSTANCE);
    }
}
