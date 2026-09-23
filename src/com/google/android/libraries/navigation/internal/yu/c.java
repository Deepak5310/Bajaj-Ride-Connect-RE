package com.google.android.libraries.navigation.internal.yu;

import com.google.android.libraries.navigation.internal.aac.as;
import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.j;
import com.google.android.libraries.navigation.internal.aac.s;
import com.google.android.libraries.navigation.internal.aac.t;
import com.google.android.libraries.navigation.internal.yr.am;
import com.google.android.libraries.navigation.internal.yr.ar;
import com.google.android.libraries.navigation.internal.yr.aw;
import com.google.android.libraries.navigation.internal.yr.ax;
import com.google.android.libraries.navigation.internal.yr.i;
import com.google.android.libraries.navigation.internal.yx.aa;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class c {
    public static bj a(s sVar, Executor executor) {
        return aw.d(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS) ? az.l(am.c(sVar), executor) : az.l(sVar, executor);
    }

    public static bj b(bj bjVar, aa aaVar, Executor executor) {
        return aw.d(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS) ? j.h(bjVar, am.b(aaVar), executor) : j.h(bjVar, aaVar, executor);
    }

    public static bj c(bj bjVar, t tVar, Executor executor) {
        return aw.d(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS) ? j.i(bjVar, am.d(tVar), executor) : j.i(bjVar, tVar, executor);
    }

    public static void d(bj bjVar, as callback, Executor executor) {
        if (!aw.d(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS)) {
            az.o(bjVar, callback, executor);
            return;
        }
        int i = am.a;
        Intrinsics.checkNotNullParameter(callback, "callback");
        az.o(bjVar, new ar(i.c(), callback), executor);
    }
}
