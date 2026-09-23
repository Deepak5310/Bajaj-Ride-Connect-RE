package com.google.android.libraries.navigation.internal.po;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bf {
    private final gr e;
    private final AtomicBoolean b = new AtomicBoolean(false);
    private final List c = new ArrayList();
    private final List d = new ArrayList();
    private final boolean a = false;

    public bf(gr grVar) {
        this.e = grVar;
    }

    public final synchronized void a(Runnable runnable) {
        Iterator it2 = this.d.iterator();
        while (it2.hasNext()) {
            ((be) it2.next()).b();
        }
        if (runnable != null) {
            this.e.c(runnable);
            this.e.b();
        }
    }

    public final synchronized void b() {
        Iterator it2 = this.d.iterator();
        while (it2.hasNext()) {
            ((be) it2.next()).b();
        }
        Iterator it3 = this.c.iterator();
        while (it3.hasNext()) {
            this.e.c((Runnable) it3.next());
        }
        this.e.b();
        this.c.clear();
        this.b.set(false);
    }

    public final synchronized void c(be beVar) {
        this.d.remove(beVar);
    }

    public final synchronized void d(final Runnable runnable) {
        for (be beVar : this.d) {
            com.google.android.libraries.navigation.internal.ol.v vVar = beVar.a;
            com.google.android.libraries.navigation.internal.ol.v vVar2 = beVar.b;
            if (vVar != vVar2) {
                if (vVar2 != null && vVar2 != beVar.c) {
                    vVar2.h();
                }
                beVar.b = beVar.a;
            }
        }
        if (this.a) {
            if (runnable != null) {
                this.c.add(runnable);
            }
            if (this.b.compareAndSet(false, true)) {
                this.e.c(new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.bc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.a.b();
                    }
                });
                this.e.b();
                return;
            }
            return;
        }
        Runnable runnable2 = new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.bd
            @Override // java.lang.Runnable
            public final void run() {
                this.a.a(runnable);
            }
        };
        if (com.google.android.libraries.geo.mapcore.renderer.cc.b()) {
            runnable2.run();
        } else {
            this.e.c(runnable2);
            this.e.b();
        }
    }

    public final be e() {
        be beVar = new be(this);
        synchronized (this) {
            this.d.add(beVar);
        }
        return beVar;
    }

    public bf(gr grVar, byte[] bArr) {
        this.e = grVar;
    }
}
