package com.google.android.libraries.navigation.internal.yu;

import com.google.android.libraries.navigation.internal.yr.ai;
import com.google.android.libraries.navigation.internal.yr.am;
import com.google.android.libraries.navigation.internal.yr.aw;
import com.google.android.libraries.navigation.internal.yr.ax;
import com.google.android.libraries.navigation.internal.yr.t;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f {
    public static final ai a() {
        final t tVarA = aw.a(null, ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
        return new ai() { // from class: com.google.android.libraries.navigation.internal.yu.d
            @Override // com.google.android.libraries.navigation.internal.yr.ai, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                aw.a(tVarA, ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS);
            }
        };
    }

    public static Runnable b(Runnable runnable) {
        return aw.d(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS) ? am.e(runnable) : runnable;
    }

    public static Callable c(Callable callable) {
        return aw.d(ax.I_HAVE_PERMISSION_TO_USE_RESTRICTED_APIS) ? am.f(callable) : callable;
    }
}
