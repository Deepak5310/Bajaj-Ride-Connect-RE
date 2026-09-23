package com.google.android.libraries.navigation.internal.hx;

import com.google.android.libraries.navigation.internal.aac.bz;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ae implements Executor {
    private final Executor a;

    public ae(Executor executor) {
        this.a = new bz(executor);
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        Runnable runnableB = com.google.android.libraries.navigation.internal.yu.f.b(runnable);
        com.google.android.libraries.navigation.internal.yr.ai aiVarA = com.google.android.libraries.navigation.internal.yu.f.a();
        try {
            this.a.execute(runnableB);
            aiVarA.close();
        } catch (Throwable th) {
            try {
                aiVarA.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
