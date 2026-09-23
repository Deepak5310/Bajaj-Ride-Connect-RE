package com.google.android.libraries.navigation.internal.pi;

import com.google.android.libraries.navigation.internal.yx.ax;
import java.util.Collections;
import java.util.TreeSet;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class s {
    private final com.google.android.libraries.navigation.internal.nn.b i;
    public final com.google.android.libraries.navigation.internal.nn.b a = new com.google.android.libraries.navigation.internal.nn.b();
    private final com.google.android.libraries.navigation.internal.nn.b d = new com.google.android.libraries.navigation.internal.nn.b();
    private final com.google.android.libraries.navigation.internal.nn.b e = new com.google.android.libraries.navigation.internal.nn.b();
    public final com.google.android.libraries.navigation.internal.nn.b b = new com.google.android.libraries.navigation.internal.nn.b();
    private final com.google.android.libraries.navigation.internal.nn.b f = new com.google.android.libraries.navigation.internal.nn.b();
    public final com.google.android.libraries.navigation.internal.nn.b c = new com.google.android.libraries.navigation.internal.nn.b();
    private final com.google.android.libraries.navigation.internal.nn.b g = new com.google.android.libraries.navigation.internal.nn.b();
    private final ab h = new ab();

    public s() {
        Collections.synchronizedSortedSet(new TreeSet(com.google.android.libraries.navigation.internal.pj.d.a));
        this.i = new com.google.android.libraries.navigation.internal.nn.b();
    }

    public final void a(n nVar, Executor executor) {
        this.i.b(nVar, executor);
    }

    public final void b(o oVar, Executor executor) {
        this.g.b(oVar, executor);
    }

    public final void c(com.google.android.libraries.navigation.internal.pj.a aVar) {
        this.h.a.size();
        this.h.a.add(aVar);
    }

    public final void d(p pVar, Executor executor) {
        this.f.b(pVar, executor);
    }

    public final void e(final u uVar) {
        this.e.d(new ax() { // from class: com.google.android.libraries.navigation.internal.pi.k
            @Override // com.google.android.libraries.navigation.internal.yx.ax
            public final void a(Object obj) {
                ((l) obj).a();
            }
        });
    }

    public final void f(final w wVar) {
        this.i.d(new ax() { // from class: com.google.android.libraries.navigation.internal.pi.i
            @Override // com.google.android.libraries.navigation.internal.yx.ax
            public final void a(Object obj) {
                ((n) obj).i(wVar);
            }
        });
    }

    public final void g(final x xVar) {
        this.g.d(new ax() { // from class: com.google.android.libraries.navigation.internal.pi.j
            @Override // com.google.android.libraries.navigation.internal.yx.ax
            public final void a(Object obj) {
                ((o) obj).b(xVar);
            }
        });
    }

    public final void h(final ac acVar) {
        this.f.d(new ax() { // from class: com.google.android.libraries.navigation.internal.pi.f
            @Override // com.google.android.libraries.navigation.internal.yx.ax
            public final void a(Object obj) {
                ((p) obj).aB(acVar);
            }
        });
    }

    public final void i(final ad adVar) {
        this.a.d(new ax() { // from class: com.google.android.libraries.navigation.internal.pi.h
            @Override // com.google.android.libraries.navigation.internal.yx.ax
            public final void a(Object obj) {
                ((q) obj).c(adVar);
            }
        });
    }

    public final void j(final ae aeVar) {
        this.d.d(new ax() { // from class: com.google.android.libraries.navigation.internal.pi.e
            @Override // com.google.android.libraries.navigation.internal.yx.ax
            public final void a(Object obj) {
                ((r) obj).a();
            }
        });
    }

    public final void k(n nVar) {
        this.i.e(nVar);
    }

    public final void l(o oVar) {
        this.g.e(oVar);
    }

    public final void m(com.google.android.libraries.navigation.internal.pj.a aVar) {
        this.h.a.remove(aVar);
    }

    public final void n(p pVar) {
        this.f.e(pVar);
    }
}
