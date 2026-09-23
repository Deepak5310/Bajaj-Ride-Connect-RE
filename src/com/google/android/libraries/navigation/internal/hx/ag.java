package com.google.android.libraries.navigation.internal.hx;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ag implements Executor {
    public final Executor a;
    public final Deque b = new ArrayDeque();
    public boolean c;

    public ag(Executor executor) {
        this.a = executor;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.b) {
            this.b.add(com.google.android.libraries.navigation.internal.yu.f.b(runnable));
            if (this.c) {
                return;
            }
            this.c = true;
            com.google.android.libraries.navigation.internal.yr.ai aiVarA = com.google.android.libraries.navigation.internal.yu.f.a();
            try {
                this.a.execute(new af(this));
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
}
