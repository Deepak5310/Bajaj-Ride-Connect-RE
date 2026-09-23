package com.google.android.libraries.navigation.internal.zo;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.ca;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class n implements Runnable {
    final /* synthetic */ ca a;
    final /* synthetic */ q b;

    public n(q qVar, ca caVar) {
        this.a = caVar;
        this.b = qVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            if (!this.a.isCancelled() && az.n(this.a) == q.b) {
                return;
            }
        } catch (ExecutionException unused) {
        }
        this.b.aA(this.a);
    }
}
