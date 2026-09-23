package com.google.android.libraries.navigation.internal.xe;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class fq {
    private fv a = null;

    public final /* bridge */ /* synthetic */ fl a(com.google.android.libraries.navigation.internal.gq.b bVar, Executor executor, ScheduledExecutorService scheduledExecutorService, Executor executor2, com.google.android.libraries.navigation.internal.yh.k kVar) {
        fv fvVar;
        synchronized (this) {
            if (this.a == null) {
                final fv fvVar2 = new fv(bVar, executor, scheduledExecutorService, executor2, kVar, new com.google.android.libraries.navigation.internal.aac.al());
                this.a = fvVar2;
                if (fvVar2.e != null && com.google.android.libraries.navigation.internal.afw.j.c()) {
                    com.google.android.libraries.navigation.internal.aac.az.o(fvVar2.d.a(new com.google.android.libraries.navigation.internal.aac.s() { // from class: com.google.android.libraries.navigation.internal.xe.fn
                        @Override // com.google.android.libraries.navigation.internal.aac.s
                        public final com.google.android.libraries.navigation.internal.aac.bj a() {
                            final fv fvVar3 = fvVar2;
                            return com.google.android.libraries.navigation.internal.aac.j.h(fvVar3.e.a(), new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.xe.fo
                                @Override // com.google.android.libraries.navigation.internal.yx.aa
                                public final Object ak(Object obj) {
                                    com.google.android.libraries.navigation.internal.xi.b bVar2 = (com.google.android.libraries.navigation.internal.xi.b) obj;
                                    int i = bVar2.b & 1;
                                    fv fvVar4 = fvVar3;
                                    if (i != 0) {
                                        fvVar4.c.put(com.google.android.libraries.navigation.internal.afm.d.NAVIGATION_SET_WAYPOINTS, Boolean.valueOf(bVar2.c));
                                    }
                                    if ((bVar2.b & 2) != 0) {
                                        fvVar4.c.put(com.google.android.libraries.navigation.internal.afm.d.NAVIGATION_SET_WAYPOINTS_WITH_ROUTE_TOKEN, Boolean.valueOf(bVar2.d));
                                    }
                                    return bVar2;
                                }
                            }, fvVar3.a);
                        }
                    }, fvVar2.a), new fr(), fvVar2.a);
                }
            }
            fvVar = this.a;
        }
        return fvVar;
    }
}
