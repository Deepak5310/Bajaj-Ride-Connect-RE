package com.google.android.libraries.navigation.internal.rl;

import com.google.android.libraries.navigation.internal.yz.ev;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements Closeable {
    public final ev a;
    private final n b;
    private final AtomicBoolean c = new AtomicBoolean(false);

    public l(ev evVar, n nVar) {
        this.a = evVar;
        this.b = nVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ev evVar;
        if (!this.c.compareAndSet(false, true)) {
            ((com.google.android.libraries.navigation.internal.zb.h) r.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1308)).p("CvoStylesRef.close() called twice; this represents a usage error.");
            return;
        }
        n nVar = this.b;
        synchronized (nVar) {
            int i = nVar.a - 1;
            nVar.a = i;
            evVar = null;
            if (i == 0) {
                ev evVar2 = nVar.b;
                nVar.b = null;
                nVar.c = null;
                evVar = evVar2;
            }
        }
        if (evVar != null) {
            int size = evVar.size();
            for (int i2 = 0; i2 < size; i2++) {
                nVar.d.b((String) evVar.get(i2));
            }
        }
    }
}
