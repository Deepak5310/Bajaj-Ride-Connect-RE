package com.google.android.libraries.navigation.internal.xo;

import com.google.android.libraries.navigation.internal.yr.am;
import java.util.concurrent.Executor;
import java.util.logging.Level;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class aj {

    /* JADX INFO: compiled from: PG */
    final class a {
        static final com.google.android.libraries.navigation.internal.zb.j a = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.xo.aj$a");
    }

    public static final void b(final Level level, Executor executor, final Throwable th, final String str, final Object... objArr) {
        executor.execute(am.e(new Runnable() { // from class: com.google.android.libraries.navigation.internal.xo.ai
            @Override // java.lang.Runnable
            public final void run() {
                ((com.google.android.libraries.navigation.internal.zb.h) ((com.google.android.libraries.navigation.internal.zb.h) aj.a.a.d(level).g(th)).F(2024)).B(str, objArr);
            }
        }));
    }

    public final void a(Level level, Executor executor, String str, Object... objArr) {
        b(level, executor, null, str, objArr);
    }
}
