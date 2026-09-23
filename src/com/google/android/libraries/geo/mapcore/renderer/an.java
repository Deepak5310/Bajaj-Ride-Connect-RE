package com.google.android.libraries.geo.mapcore.renderer;

import androidx.tracing.Trace;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class an implements am {
    private final LinkedBlockingQueue a = new LinkedBlockingQueue();
    private final AtomicInteger b = new AtomicInteger(0);
    private final AtomicInteger c = new AtomicInteger(0);

    private final void f() {
        int size = this.a.size();
        String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
        Trace.setCounter("EntityQueueBuffer", size);
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.am
    public final dm a() {
        dm dmVar = (dm) this.a.poll();
        f();
        return dmVar;
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.am
    public final void b(aj ajVar, com.google.android.libraries.navigation.internal.ol.au auVar) {
        this.a.add(new dl(ajVar, auVar));
        this.b.incrementAndGet();
        f();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.am
    public final void c() {
        while (true) {
            dm dmVarA = a();
            if (dmVarA == null) {
                return;
            } else {
                dmVarA.b();
            }
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.am
    public final void d(aj ajVar) {
        this.a.add(new dn(ajVar));
        this.c.incrementAndGet();
        f();
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.am
    public final boolean e() {
        return this.a.isEmpty();
    }
}
