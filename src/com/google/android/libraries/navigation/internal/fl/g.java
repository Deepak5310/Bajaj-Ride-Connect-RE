package com.google.android.libraries.navigation.internal.fl;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class g implements Runnable {
    final /* synthetic */ i a;

    public g(i iVar) {
        this.a = iVar;
    }

    public final /* synthetic */ void a() {
        q qVarE;
        i iVar = this.a;
        synchronized (iVar) {
            qVarE = iVar.e();
        }
        qVarE.b();
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.c.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.fl.f
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a();
            }
        }, 4372L, TimeUnit.MILLISECONDS);
    }
}
