package com.google.android.libraries.navigation.internal.po;

import com.google.android.libraries.navigation.internal.yz.lv;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b implements com.google.android.libraries.navigation.internal.ol.v {
    private final gr f;
    private com.google.android.libraries.navigation.internal.ol.as c = null;
    private boolean d = false;
    protected boolean a = false;
    protected boolean b = false;
    private final List e = new ArrayList();

    public b(gr grVar) {
        this.f = grVar;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.v
    public synchronized void aq() {
        this.c = null;
        this.d = false;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.v
    public final void ar(Runnable runnable) {
        synchronized (this) {
            if (this.b) {
                return;
            }
            t(runnable);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.ol.v
    public synchronized void k(com.google.android.libraries.navigation.internal.ol.as asVar) {
        this.c = asVar;
        this.d = false;
    }

    @Override // com.google.android.libraries.navigation.internal.ol.v
    public synchronized void l() {
        this.c = null;
        this.d = true;
    }

    protected final synchronized void o() {
        this.e.clear();
    }

    protected final void p(Runnable runnable) {
        com.google.android.libraries.navigation.internal.yx.ar.q(this.f);
        if (com.google.android.libraries.geo.mapcore.renderer.cc.b()) {
            runnable.run();
        } else {
            this.f.c(runnable);
            this.f.b();
        }
    }

    public final void q() {
        com.google.android.libraries.navigation.internal.yz.eq eqVar = new com.google.android.libraries.navigation.internal.yz.eq();
        synchronized (this) {
            this.a = true;
            if (this.b) {
                return;
            }
            eqVar.j(this.e);
            this.e.clear();
            final com.google.android.libraries.navigation.internal.yz.ev evVarG = eqVar.g();
            Runnable runnable = new Runnable() { // from class: com.google.android.libraries.navigation.internal.po.a
                @Override // java.lang.Runnable
                public final void run() {
                    int i = 0;
                    while (true) {
                        com.google.android.libraries.navigation.internal.yz.ev evVar = evVarG;
                        if (i >= ((lv) evVar).c) {
                            return;
                        }
                        ((Runnable) evVar.get(i)).run();
                        i++;
                    }
                }
            };
            if (this.f != null) {
                p(runnable);
            } else {
                runnable.run();
            }
        }
    }

    public final synchronized boolean r() {
        return this.d;
    }

    protected final synchronized boolean s() {
        return this.c != null || this.d;
    }

    protected final boolean t(Runnable runnable) {
        boolean z;
        synchronized (this) {
            z = this.a;
            if (!z) {
                this.e.add(runnable);
            }
        }
        if (!z) {
            return false;
        }
        runnable.run();
        return true;
    }

    protected abstract void u(int i);

    protected final void v(int i, com.google.android.libraries.navigation.internal.ol.v vVar) {
        com.google.android.libraries.navigation.internal.ol.as asVar;
        synchronized (this) {
            asVar = this.c;
        }
        if (asVar != null) {
            if (i - 1 != 0) {
                asVar.D(vVar);
            } else {
                asVar.C(vVar);
            }
        }
    }
}
