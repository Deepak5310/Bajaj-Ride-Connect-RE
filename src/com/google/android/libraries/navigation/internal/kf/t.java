package com.google.android.libraries.navigation.internal.kf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.libraries.navigation.internal.yx.an;
import com.google.android.libraries.navigation.internal.yx.br;
import com.google.android.libraries.navigation.internal.yx.bw;
import com.google.android.libraries.navigation.internal.yz.eq;
import com.google.android.libraries.navigation.internal.yz.ev;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class t implements com.google.android.libraries.navigation.internal.jy.t {
    public final com.google.android.libraries.navigation.internal.jy.af a;
    public final com.google.android.libraries.navigation.internal.mj.a b;
    public final n c;
    public final com.google.android.libraries.navigation.internal.afo.a d;
    public final an e;
    private final br f;
    private final c g = new c();

    public t(com.google.android.libraries.navigation.internal.mj.a aVar, n nVar, com.google.android.libraries.navigation.internal.afo.a aVar2, com.google.android.libraries.navigation.internal.jy.af afVar, an anVar) {
        new HashSet();
        this.a = afVar;
        this.b = aVar;
        this.c = nVar;
        this.d = aVar2;
        this.f = bw.a(new br() { // from class: com.google.android.libraries.navigation.internal.kf.s
            @Override // com.google.android.libraries.navigation.internal.yx.br
            public final Object a() {
                com.google.android.libraries.navigation.internal.kd.m mVar = new com.google.android.libraries.navigation.internal.kd.m(com.google.android.libraries.navigation.internal.afe.c.a);
                t tVar = this.a;
                q qVar = new q(tVar, mVar, tVar.a.f(mVar), tVar.a, tVar.b, tVar.d);
                final n nVar2 = tVar.c;
                if (nVar2.d == null) {
                    synchronized (nVar2) {
                        if (nVar2.d == null) {
                            com.google.android.libraries.navigation.internal.nk.p pVar = ((com.google.android.libraries.navigation.internal.nk.s) nVar2.b.a()).a().e;
                            if (pVar == null) {
                                pVar = com.google.android.libraries.navigation.internal.nk.p.a;
                            }
                            int i = pVar.o;
                            if (i <= 0) {
                                ((com.google.android.libraries.navigation.internal.zb.h) n.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(761)).q("Flush period is %d, must be > 0. Using 60 instead", i);
                                i = 60;
                            }
                            long j = i;
                            nVar2.d = nVar2.c.scheduleAtFixedRate(new Runnable() { // from class: com.google.android.libraries.navigation.internal.kf.m
                                @Override // java.lang.Runnable
                                public final void run() {
                                    Iterator it2 = nVar2.e.iterator();
                                    while (it2.hasNext()) {
                                        com.google.android.libraries.navigation.internal.jy.r rVar = (com.google.android.libraries.navigation.internal.jy.r) ((WeakReference) it2.next()).get();
                                        if (rVar != null) {
                                            rVar.d();
                                        }
                                    }
                                }
                            }, j, j, TimeUnit.SECONDS);
                        }
                    }
                }
                nVar2.e.add(new WeakReference(qVar));
                return qVar;
            }
        });
        this.e = anVar;
    }

    @Override // com.google.android.libraries.navigation.internal.jy.g
    public final List a() {
        eq eqVar = new eq();
        synchronized (this) {
            eqVar.k(ev.o(this.g.a).stream().map(new Function() { // from class: com.google.android.libraries.navigation.internal.kf.r
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    throw null;
                }
            }).iterator());
        }
        return eqVar.g();
    }

    @Override // com.google.android.libraries.navigation.internal.jy.g
    public final void b() {
    }

    @Override // com.google.android.libraries.navigation.internal.jy.s
    public final com.google.android.libraries.navigation.internal.jy.r c(View view) {
        com.google.android.libraries.navigation.internal.jy.r rVarB;
        com.google.android.libraries.navigation.internal.jy.r rVarB2 = com.google.android.libraries.navigation.internal.jw.e.b(view);
        if (rVarB2 != null) {
            return rVarB2;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if ((parent instanceof ViewGroup) && (rVarB = com.google.android.libraries.navigation.internal.jw.e.b((ViewGroup) parent)) != null) {
                return rVarB;
            }
        }
        return d();
    }

    @Override // com.google.android.libraries.navigation.internal.jy.t
    public final com.google.android.libraries.navigation.internal.jy.r d() {
        return (com.google.android.libraries.navigation.internal.jy.r) this.f.a();
    }
}
