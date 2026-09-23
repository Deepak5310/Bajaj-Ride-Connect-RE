package com.google.android.libraries.navigation.internal.afx;

import com.google.android.libraries.navigation.internal.aga.df;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class br {
    public final int a;
    public final cd b;
    public final cq c;
    public final bx d;
    public final ScheduledExecutorService e;
    public final Executor f;
    private final g g;
    private final df h;

    public br(Integer num, cd cdVar, cq cqVar, bx bxVar, ScheduledExecutorService scheduledExecutorService, g gVar, Executor executor, df dfVar) {
        com.google.android.libraries.navigation.internal.yx.ar.r(num, "defaultPort not set");
        this.a = num.intValue();
        com.google.android.libraries.navigation.internal.yx.ar.r(cdVar, "proxyDetector not set");
        this.b = cdVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(cqVar, "syncContext not set");
        this.c = cqVar;
        com.google.android.libraries.navigation.internal.yx.ar.r(bxVar, "serviceConfigParser not set");
        this.d = bxVar;
        this.e = scheduledExecutorService;
        this.g = gVar;
        this.f = executor;
        this.h = dfVar;
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarC = com.google.android.libraries.navigation.internal.yx.al.b(this).c("defaultPort", this.a);
        akVarC.g("proxyDetector", this.b);
        akVarC.g("syncContext", this.c);
        akVarC.g("serviceConfigParser", this.d);
        akVarC.g("scheduledExecutorService", this.e);
        akVarC.g("channelLogger", this.g);
        akVarC.g("executor", this.f);
        akVarC.g("overrideAuthority", null);
        akVarC.g("metricRecorder", this.h);
        return akVarC.toString();
    }
}
