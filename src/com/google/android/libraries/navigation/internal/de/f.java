package com.google.android.libraries.navigation.internal.de;

import com.google.android.libraries.navigation.internal.aac.bn;
import com.google.android.libraries.navigation.internal.hx.ap;
import com.google.android.libraries.navigation.internal.yz.fz;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.google.android.libraries.navigation.internal.cw.p {
    public final com.google.android.libraries.navigation.internal.mj.a a;
    final e b;
    private final com.google.android.libraries.navigation.internal.ia.e k;
    private final bn l;
    private final Executor m;
    public final Object c = new Object();
    public final WeakHashMap d = new WeakHashMap();
    public volatile float e = -1.0f;
    public volatile float f = Float.NaN;
    public volatile int g = -1;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f388n = false;
    public volatile boolean h = false;
    public long i = 0;
    public boolean j = false;

    public f(com.google.android.libraries.navigation.internal.ia.e eVar, bn bnVar, Executor executor, com.google.android.libraries.navigation.internal.mj.a aVar) {
        this.k = eVar;
        this.l = bnVar;
        this.m = executor;
        this.a = aVar;
        e eVar2 = new e(this);
        this.b = eVar2;
        fz fzVar = new fz();
        fzVar.b(com.google.android.libraries.navigation.internal.cy.d.class, new g(com.google.android.libraries.navigation.internal.cy.d.class, eVar2, ap.UI_THREAD));
        eVar.c(eVar2, fzVar.a());
    }

    @Override // com.google.android.libraries.navigation.internal.cw.p
    public final void a() {
        this.h = true;
    }

    @Override // com.google.android.libraries.navigation.internal.cw.p
    public final void b() {
        this.h = false;
    }

    @Override // com.google.android.libraries.navigation.internal.cw.p
    public final void c(com.google.android.libraries.navigation.internal.cw.n nVar) {
    }

    @Override // com.google.android.libraries.navigation.internal.cw.p
    public final void d(h hVar) {
        synchronized (this.c) {
            this.d.put(hVar, null);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.cw.p
    public final void e(h hVar) {
        synchronized (this.c) {
            this.d.remove(hVar);
        }
    }

    public final void f(boolean z) {
        com.google.android.libraries.navigation.internal.nj.i.b();
        if (z == this.f388n) {
            return;
        }
        this.f388n = z;
        if (!z) {
            this.e = -1.0f;
            this.f = Float.NaN;
            this.g = -1;
        }
        this.k.a(new com.google.android.libraries.navigation.internal.cy.c(z));
    }

    public final void g() {
        com.google.android.libraries.navigation.internal.nj.i.b();
        if (this.j) {
            return;
        }
        try {
            com.google.android.libraries.navigation.internal.yu.c.d(this.l.schedule(new Runnable() { // from class: com.google.android.libraries.navigation.internal.de.d
                @Override // java.lang.Runnable
                public final void run() {
                    f fVar = this.a;
                    fVar.j = false;
                    if (fVar.a.a() - fVar.i >= 2000) {
                        fVar.f(false);
                    } else {
                        fVar.g();
                    }
                }
            }, Math.max(0L, (this.i + 2000) - this.a.a()), TimeUnit.MILLISECONDS), new com.google.android.libraries.navigation.internal.hx.o(), this.m);
        } catch (RejectedExecutionException unused) {
            ((com.google.android.libraries.navigation.internal.zb.h) com.google.android.libraries.navigation.internal.zb.j.b.F((char) 323)).p("Failed to schedule hearbeat runnable; will force mark provider as inactive.");
            f(false);
        }
        this.j = true;
    }
}
