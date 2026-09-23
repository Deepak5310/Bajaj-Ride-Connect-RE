package com.google.android.libraries.geo.mapcore.renderer;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.agi.fo;
import com.google.android.libraries.navigation.internal.yz.gs;
import com.google.android.libraries.navigation.internal.yz.hc;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ay implements am {
    private final hc a = hc.n();
    private final hc b = hc.n();
    private final fo c = new fo();
    private int d = 0;
    private int e = 0;
    private int f = 0;
    private final ReentrantLock g;
    private final Condition h;

    public ay() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.g = reentrantLock;
        this.h = reentrantLock.newCondition();
    }

    private final void g() {
        int size = this.a.size();
        String[] strArr = com.google.android.libraries.navigation.internal.nw.e.a;
        Trace.setCounter("EntitySetBuffer-pendingAdds", size);
        Trace.setCounter("EntitySetBuffer-pendingRemoves", this.b.size());
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.am
    public final dm a() {
        this.g.lock();
        try {
            dm dmVarF = null;
            if (!e()) {
                if (this.b.isEmpty()) {
                    this.g.lock();
                    try {
                        aj ajVar = (aj) gs.c(this.a, null);
                        if (ajVar == null) {
                            this.g.unlock();
                        } else {
                            com.google.android.libraries.navigation.internal.ol.au auVar = (com.google.android.libraries.navigation.internal.ol.au) this.c.get(ajVar);
                            if (this.a.d(ajVar, 1) == 1) {
                                this.c.remove(ajVar);
                            }
                            g();
                            dl dlVar = new dl(ajVar, auVar);
                            this.g.unlock();
                            dmVarF = dlVar;
                        }
                    } finally {
                        this.g.unlock();
                    }
                } else {
                    dmVarF = f();
                }
            }
            return dmVarF;
        } catch (Throwable th) {
            this.g.unlock();
            throw th;
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.am
    public final void b(aj ajVar, com.google.android.libraries.navigation.internal.ol.au auVar) {
        this.g.lock();
        try {
            this.a.add(ajVar);
            this.d++;
            if (auVar != null) {
                this.c.put(ajVar, auVar);
            }
            g();
            this.h.signal();
        } finally {
            this.g.unlock();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.am
    public final void c() {
        while (true) {
            dm dmVarF = f();
            if (dmVarF == null) {
                return;
            } else {
                dmVarF.b();
            }
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.am
    public final void d(aj ajVar) {
        this.g.lock();
        try {
            this.e++;
            int iD = this.a.d(ajVar, 1);
            if (iD == 0) {
                this.b.add(ajVar);
                g();
                this.h.signal();
            } else {
                this.f++;
                if (iD == 1) {
                    this.c.remove(ajVar);
                }
                g();
            }
        } finally {
            this.g.unlock();
        }
    }

    @Override // com.google.android.libraries.geo.mapcore.renderer.am
    public final boolean e() {
        this.g.lock();
        try {
            boolean z = false;
            if (this.a.isEmpty() && this.b.isEmpty()) {
                z = true;
            }
            return z;
        } finally {
            this.g.unlock();
        }
    }

    final dm f() {
        this.g.lock();
        try {
            dn dnVar = null;
            aj ajVar = (aj) gs.c(this.b, null);
            if (ajVar != null) {
                this.b.remove(ajVar);
                g();
                dnVar = new dn(ajVar);
            }
            return dnVar;
        } finally {
            this.g.unlock();
        }
    }
}
