package com.google.android.libraries.navigation.internal.aga;

import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class j implements ef {
    public static final Logger a = Logger.getLogger(j.class.getName());
    public final ScheduledExecutorService b;
    public final com.google.android.libraries.navigation.internal.afx.cq c;
    public com.google.android.libraries.navigation.internal.afx.cp d;
    public ap e;
    private final ao f;

    public j(ao aoVar, ScheduledExecutorService scheduledExecutorService, com.google.android.libraries.navigation.internal.afx.cq cqVar) {
        this.f = aoVar;
        this.b = scheduledExecutorService;
        this.c = cqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.aga.ef
    public final void a() {
        this.c.d();
        this.c.execute(new Runnable() { // from class: com.google.android.libraries.navigation.internal.aga.i
            @Override // java.lang.Runnable
            public final void run() {
                j jVar = this.a;
                com.google.android.libraries.navigation.internal.afx.cp cpVar = jVar.d;
                if (cpVar != null && cpVar.b()) {
                    jVar.d.a();
                }
                jVar.e = null;
            }
        });
    }
}
