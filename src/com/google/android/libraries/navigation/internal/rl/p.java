package com.google.android.libraries.navigation.internal.rl;

import com.google.android.libraries.navigation.internal.ol.av;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.io.Closeable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class p implements Closeable {
    private final av a;
    private final o b;
    private final AtomicBoolean c = new AtomicBoolean(false);

    public p(av avVar, o oVar) {
        this.a = avVar;
        this.b = oVar;
    }

    public final av a() {
        ar.k(!this.c.get());
        return this.a;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        av avVar;
        if (!this.c.compareAndSet(false, true)) {
            ((com.google.android.libraries.navigation.internal.zb.h) r.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F((char) 1309)).p("StyleCollectionImpl.close() called twice; this represents a usage error.");
            return;
        }
        o oVar = this.b;
        synchronized (oVar) {
            int i = oVar.b - 1;
            oVar.b = i;
            avVar = null;
            if (i == 0) {
                av avVar2 = oVar.c;
                ar.q(avVar2);
                oVar.c = null;
                avVar = avVar2;
            }
        }
        if (avVar != null) {
            oVar.a.k(avVar);
        }
    }
}
