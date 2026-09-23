package com.google.android.libraries.navigation.internal.le;

import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public abstract class q extends com.google.android.libraries.navigation.internal.ld.u {
    public static final ThreadLocal b = new o();
    public com.google.android.libraries.navigation.internal.ld.y f;
    public volatile boolean g;
    public volatile bl h;
    private com.google.android.libraries.navigation.internal.ld.ab j;
    private boolean k;
    public final Object c = new Object();
    public final CountDownLatch d = new CountDownLatch(1);
    private final ArrayList a = new ArrayList();
    public final AtomicReference e = new AtomicReference();
    public boolean i = false;

    @Deprecated
    q() {
        new p(Looper.getMainLooper());
        new WeakReference(null);
    }

    public static void h(com.google.android.libraries.navigation.internal.ld.y yVar) {
        if (yVar instanceof com.google.android.libraries.navigation.internal.ld.v) {
            try {
                ((com.google.android.libraries.navigation.internal.ld.v) yVar).a();
            } catch (RuntimeException unused) {
            }
        }
    }

    protected abstract com.google.android.libraries.navigation.internal.ld.y a(com.google.android.libraries.navigation.internal.ld.ab abVar);

    @Override // com.google.android.libraries.navigation.internal.ld.u
    public final void c(com.google.android.libraries.navigation.internal.ld.t tVar) {
        com.google.android.libraries.navigation.internal.lh.be.b(true, "Callback cannot be null.");
        synchronized (this.c) {
            if (j()) {
                tVar.a(this.j);
            } else {
                this.a.add(tVar);
            }
        }
    }

    @Deprecated
    public final void g(com.google.android.libraries.navigation.internal.ld.ab abVar) {
        synchronized (this.c) {
            if (!j()) {
                i(a(abVar));
                this.k = true;
            }
        }
    }

    public final void i(com.google.android.libraries.navigation.internal.ld.y yVar) {
        synchronized (this.c) {
            if (this.k) {
                h(yVar);
                return;
            }
            j();
            com.google.android.libraries.navigation.internal.lh.be.g(!j(), "Results have already been set");
            com.google.android.libraries.navigation.internal.lh.be.g(!this.g, "Result has already been consumed");
            this.f = yVar;
            this.j = yVar.a();
            this.d.countDown();
            ArrayList arrayList = this.a;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((com.google.android.libraries.navigation.internal.ld.t) arrayList.get(i)).a(this.j);
            }
            this.a.clear();
        }
    }

    public final boolean j() {
        return this.d.getCount() == 0;
    }

    protected q(com.google.android.libraries.navigation.internal.ld.s sVar) {
        new p(sVar.a());
        new WeakReference(sVar);
    }
}
