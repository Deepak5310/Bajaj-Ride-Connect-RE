package com.google.android.libraries.navigation.internal.hx;

import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yz.ev;
import com.google.android.libraries.navigation.internal.yz.no;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ab implements Executor {
    private final Executor a;
    private final Object b;
    private final List c;
    private volatile boolean d;

    public ab(Executor executor) {
        this(executor, false);
    }

    public final void a() {
        synchronized (this.b) {
            this.d = true;
        }
    }

    public final void b() {
        if (this.d) {
            synchronized (this.b) {
                while (!this.c.isEmpty()) {
                    ev evVarO = ev.o(this.c);
                    this.c.clear();
                    no it2 = evVarO.iterator();
                    while (it2.hasNext()) {
                        this.a.execute((Runnable) it2.next());
                    }
                }
                this.d = false;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (!this.d) {
            this.a.execute(runnable);
            return;
        }
        synchronized (this.b) {
            if (this.d) {
                this.c.add(runnable);
            } else {
                this.a.execute(runnable);
            }
        }
    }

    public ab(Executor executor, boolean z) {
        this.b = new Object();
        this.c = new ArrayList();
        ar.q(executor);
        this.a = executor;
        this.d = z;
    }
}
