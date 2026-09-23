package com.google.android.libraries.navigation.internal.aga;

import java.util.IdentityHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class er {
    private static final er c = new er(new en());
    public final IdentityHashMap a = new IdentityHashMap();
    public ScheduledExecutorService b;
    private final en d;

    public er(en enVar) {
        this.d = enVar;
    }

    public static Object a(eq eqVar) {
        return c.b(eqVar);
    }

    public static void d(eq eqVar, Object obj) {
        c.e(eqVar, obj);
    }

    final synchronized Object b(eq eqVar) {
        ep epVar;
        epVar = (ep) this.a.get(eqVar);
        if (epVar == null) {
            epVar = new ep(eqVar.a());
            this.a.put(eqVar, epVar);
        }
        ScheduledFuture scheduledFuture = epVar.c;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            epVar.c = null;
        }
        epVar.b++;
        return epVar.a;
    }

    final synchronized void e(eq eqVar, Object obj) {
        ep epVar = (ep) this.a.get(eqVar);
        if (epVar == null) {
            throw new IllegalArgumentException("No cached instance found for ".concat(String.valueOf(String.valueOf(eqVar))));
        }
        boolean z = true;
        com.google.android.libraries.navigation.internal.yx.ar.b(obj == epVar.a, "Releasing the wrong instance");
        com.google.android.libraries.navigation.internal.yx.ar.l(epVar.b > 0, "Refcount has already reached zero");
        int i = epVar.b - 1;
        epVar.b = i;
        if (i == 0) {
            if (epVar.c != null) {
                z = false;
            }
            com.google.android.libraries.navigation.internal.yx.ar.l(z, "Destroy task already scheduled");
            if (this.b == null) {
                this.b = Executors.newSingleThreadScheduledExecutor(az.c("grpc-shared-destroyer-%d"));
            }
            epVar.c = this.b.schedule(new bx(new eo(this, epVar, eqVar, obj)), 1L, TimeUnit.SECONDS);
        }
    }
}
