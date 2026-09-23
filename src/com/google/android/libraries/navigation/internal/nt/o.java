package com.google.android.libraries.navigation.internal.nt;

import com.google.android.libraries.navigation.internal.aac.az;
import com.google.android.libraries.navigation.internal.aac.bj;
import com.google.android.libraries.navigation.internal.aac.ca;
import com.google.android.libraries.navigation.internal.yx.ar;
import com.google.android.libraries.navigation.internal.yx.br;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public class o extends s implements m {
    static final ab a = new n();
    private ca b;
    private br d;
    private Runnable e;
    private Runnable f;

    public o() {
        super(a);
        this.e = null;
        this.f = null;
        this.d = null;
        this.b = new ca();
    }

    @Override // com.google.android.libraries.navigation.internal.nt.m
    public final synchronized Object c() {
        br brVar = this.d;
        if (brVar == null) {
            return null;
        }
        return brVar.a();
    }

    @Override // com.google.android.libraries.navigation.internal.nt.s
    public final synchronized bj d() {
        bj bjVarI;
        ca caVar = this.b;
        if (caVar == null) {
            br brVar = this.d;
            ar.q(brVar);
            bjVarI = az.h(brVar.a());
        } else {
            bjVarI = az.i(caVar);
        }
        return bjVarI;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.m
    public final void e(t tVar, Executor executor) {
        super.o(tVar, executor);
    }

    @Override // com.google.android.libraries.navigation.internal.nt.m
    public final void f(t tVar, Executor executor) {
        o(new ad(new WeakReference(tVar)), executor);
    }

    @Override // com.google.android.libraries.navigation.internal.nt.m
    public final void g(t tVar, Executor executor) {
        super.p(tVar, executor);
    }

    @Override // com.google.android.libraries.navigation.internal.nt.m
    public final void h(t tVar) {
        super.s(tVar);
    }

    @Override // com.google.android.libraries.navigation.internal.nt.m
    public final synchronized boolean i() {
        ca caVar = this.b;
        return caVar == null || caVar.isDone();
    }

    final void j() {
        synchronized (this) {
            ar.k(this.d != null);
        }
        super.r();
        k kVar = (k) this.c.get();
        while (true) {
            aa aaVar = (aa) kVar.a.poll();
            if (aaVar == null) {
                return;
            } else {
                aaVar.b(this);
            }
        }
    }

    @Override // com.google.android.libraries.navigation.internal.nt.s
    protected final void k() {
        Runnable runnable;
        synchronized (this) {
            runnable = this.e;
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public final synchronized void l(Runnable runnable) {
        this.f = runnable;
    }

    public final synchronized void m(Runnable runnable) {
        this.e = runnable;
    }

    final synchronized void n(br brVar) {
        this.d = brVar;
        ca caVar = this.b;
        if (caVar != null) {
            caVar.d(brVar.a());
            this.b = null;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.nt.s
    protected void u() {
        Runnable runnable;
        synchronized (this) {
            runnable = this.f;
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public o(br brVar) {
        super(a);
        this.e = null;
        this.f = null;
        this.d = brVar;
        this.b = null;
    }
}
