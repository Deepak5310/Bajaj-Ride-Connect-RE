package com.google.android.libraries.navigation.internal.abh;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class cy {
    public final Executor a;
    public final ht b;
    public dn c;
    public com.google.android.libraries.navigation.internal.ly.aj d;
    public com.google.android.libraries.navigation.internal.abm.aj e;
    private final cx f;

    public cy(ht htVar) {
        Executor executorA = com.google.android.libraries.navigation.internal.abf.ah.a();
        cx cxVar = cx.a;
        this.b = htVar;
        this.a = executorA;
        this.f = cxVar;
        synchronized (this) {
            this.c = null;
            this.d = null;
            this.e = null;
        }
    }

    public final synchronized void a(com.google.android.libraries.navigation.internal.abm.aj ajVar) {
        this.e = ajVar;
    }
}
