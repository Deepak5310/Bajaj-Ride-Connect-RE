package com.google.android.libraries.navigation.internal.yu;

import com.google.android.libraries.navigation.internal.aac.aq;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.t;
import com.google.android.libraries.navigation.internal.yr.am;
import com.google.android.libraries.navigation.internal.yr.aw;
import com.google.android.libraries.navigation.internal.yr.ax;
import com.google.android.libraries.navigation.internal.yx.aa;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a extends aq {
    private a(bj bjVar) {
        super(bjVar);
    }

    public static a b(bj bjVar) {
        return bjVar instanceof a ? (a) bjVar : new a(bjVar);
    }

    public final a a(Class cls, t tVar, Executor executor) {
        boolean zD = aw.d(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        bj bjVar = this.a;
        return new a(zD ? com.google.android.libraries.navigation.internal.aac.c.i(bjVar, cls, am.d(tVar), executor) : com.google.android.libraries.navigation.internal.aac.c.i(bjVar, cls, tVar, executor));
    }

    public final a c(aa aaVar, Executor executor) {
        return new a(c.b(this.a, aaVar, executor));
    }
}
