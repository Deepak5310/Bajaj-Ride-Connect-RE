package com.google.android.libraries.navigation.internal.me;

import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class y {
    private final Object a = new Object();
    private Queue b;
    private boolean c;

    public final void a(x xVar) {
        synchronized (this.a) {
            if (this.b == null) {
                this.b = new ArrayDeque();
            }
            this.b.add(xVar);
        }
    }

    public final void b(w wVar) {
        x xVar;
        synchronized (this.a) {
            if (this.b != null && !this.c) {
                this.c = true;
                while (true) {
                    synchronized (this.a) {
                        xVar = (x) this.b.poll();
                        if (xVar == null) {
                            this.c = false;
                            return;
                        }
                    }
                    xVar.a(wVar);
                }
            }
        }
    }
}
