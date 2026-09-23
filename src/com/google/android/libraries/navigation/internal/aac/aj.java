package com.google.android.libraries.navigation.internal.aac;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class aj extends AtomicReference implements Executor, Runnable {
    al a;
    Executor b;
    Runnable c;
    Thread d;

    public aj(Executor executor, al alVar) {
        super(ai.NOT_RUN);
        this.b = executor;
        this.a = alVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (get() == ai.CANCELLED) {
            this.b = null;
            this.a = null;
            return;
        }
        this.d = Thread.currentThread();
        try {
            ak akVar = ((al) Objects.requireNonNull(this.a)).a;
            if (akVar.a == this.d) {
                this.a = null;
                com.google.android.libraries.navigation.internal.yx.ar.k(akVar.b == null);
                akVar.b = runnable;
                akVar.c = (Executor) Objects.requireNonNull(this.b);
                this.b = null;
            } else {
                Executor executor = (Executor) Objects.requireNonNull(this.b);
                this.b = null;
                this.c = runnable;
                executor.execute(this);
            }
        } finally {
            this.d = null;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        Executor executor;
        Thread threadCurrentThread = Thread.currentThread();
        if (threadCurrentThread != this.d) {
            Runnable runnable = (Runnable) Objects.requireNonNull(this.c);
            this.c = null;
            runnable.run();
            return;
        }
        ak akVar = new ak();
        akVar.a = threadCurrentThread;
        ((al) Objects.requireNonNull(this.a)).a = akVar;
        this.a = null;
        try {
            Runnable runnable2 = (Runnable) Objects.requireNonNull(this.c);
            this.c = null;
            runnable2.run();
            while (true) {
                Runnable runnable3 = akVar.b;
                if (runnable3 == null || (executor = akVar.c) == null) {
                    break;
                }
                akVar.b = null;
                akVar.c = null;
                executor.execute(runnable3);
            }
            akVar.a = null;
        } catch (Throwable th) {
            akVar.a = null;
            throw th;
        }
    }
}
