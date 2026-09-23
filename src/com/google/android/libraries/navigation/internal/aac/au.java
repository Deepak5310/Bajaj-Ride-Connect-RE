package com.google.android.libraries.navigation.internal.aac;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class au implements Runnable {
    final Future a;
    final as b;

    public au(Future future, as asVar) {
        this.a = future;
        this.b = asVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Throwable thK;
        Object obj = this.a;
        if ((obj instanceof com.google.android.libraries.navigation.internal.aad.a) && (thK = ((com.google.android.libraries.navigation.internal.aad.a) obj).k()) != null) {
            this.b.a(thK);
            return;
        }
        try {
            this.b.b(az.n(this.a));
        } catch (ExecutionException e) {
            this.b.a(e.getCause());
        } catch (Throwable th) {
            this.b.a(th);
        }
    }

    public final String toString() {
        com.google.android.libraries.navigation.internal.yx.ak akVarB = com.google.android.libraries.navigation.internal.yx.al.b(this);
        akVarB.f(this.b);
        return akVarB.toString();
    }
}
