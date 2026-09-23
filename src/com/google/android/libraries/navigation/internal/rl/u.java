package com.google.android.libraries.navigation.internal.rl;

import android.util.SparseArray;
import com.google.android.libraries.navigation.internal.ol.ax;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class u {
    private final AtomicInteger a = new AtomicInteger();
    private final SparseArray b = new SparseArray();
    private final ax c;
    private final com.google.android.libraries.navigation.internal.pm.a d;

    public u(ax axVar, com.google.android.libraries.navigation.internal.pm.a aVar) {
        this.c = axVar;
        this.d = aVar;
    }

    public final c a(int i) {
        t tVar;
        synchronized (this) {
            tVar = (t) this.b.get(i);
            if (tVar == null) {
                tVar = new t(i);
                this.b.put(i, tVar);
            }
        }
        return tVar;
    }

    public final d b() {
        return new r(this.a.getAndIncrement(), this.c, this.d);
    }
}
