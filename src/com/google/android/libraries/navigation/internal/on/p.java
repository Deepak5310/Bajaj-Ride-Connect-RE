package com.google.android.libraries.navigation.internal.on;

import com.google.android.libraries.navigation.internal.ol.aq;
import com.google.android.libraries.navigation.internal.yx.ar;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
abstract class p implements l {
    private final aq a;
    final /* synthetic */ q b;
    private final AtomicInteger c = new AtomicInteger(1);
    private boolean d = false;

    public p(q qVar, aq aqVar) {
        this.b = qVar;
        this.a = aqVar;
    }

    @Override // com.google.android.libraries.navigation.internal.on.l
    public final aq a() {
        ar.k(!this.d);
        ar.k(this.c.get() > 0);
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.on.l
    public final void b() {
        synchronized (this.b) {
            ar.k(!this.d);
            if (this.c.decrementAndGet() == 0) {
                this.b.a.j(this.a);
                this.d = true;
                c();
            }
        }
    }

    protected abstract void c();

    public final void d() {
        ar.k(!this.d);
        ar.k(this.c.incrementAndGet() > 1);
    }
}
