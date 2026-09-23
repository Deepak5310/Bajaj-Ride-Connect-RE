package com.google.android.libraries.navigation.internal.xe;

import java.util.EnumMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class fv implements fl {
    public final Executor a;
    public final ScheduledExecutorService b;
    public final Map c = new EnumMap(com.google.android.libraries.navigation.internal.afm.d.class);
    public final com.google.android.libraries.navigation.internal.aac.al d;
    public final com.google.android.libraries.navigation.internal.yh.k e;
    private final Executor h;
    private final com.google.android.libraries.navigation.internal.gq.b i;
    private static final com.google.android.libraries.navigation.internal.zb.j g = com.google.android.libraries.navigation.internal.zb.j.e("com.google.android.libraries.navigation.internal.xe.fv");
    public static final fq f = new fq();

    public fv(com.google.android.libraries.navigation.internal.gq.b bVar, Executor executor, ScheduledExecutorService scheduledExecutorService, Executor executor2, com.google.android.libraries.navigation.internal.yh.k kVar, com.google.android.libraries.navigation.internal.aac.al alVar) {
        com.google.android.libraries.navigation.internal.yx.ar.q(bVar);
        this.i = bVar;
        com.google.android.libraries.navigation.internal.yx.ar.q(executor);
        this.h = executor;
        this.b = scheduledExecutorService;
        this.a = executor2;
        this.e = kVar;
        this.d = alVar;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.fl
    public final boolean a() {
        boolean zF = f(com.google.android.libraries.navigation.internal.afm.d.NAVIGATION_SET_WAYPOINTS);
        if (!zF) {
            b(1);
        }
        return zF;
    }

    @Override // com.google.android.libraries.navigation.internal.xe.fl
    public final void b(int i) {
        com.google.android.libraries.navigation.internal.afm.b bVar = (com.google.android.libraries.navigation.internal.afm.b) com.google.android.libraries.navigation.internal.afm.e.a.q();
        com.google.android.libraries.navigation.internal.afm.d dVar = com.google.android.libraries.navigation.internal.afm.d.NAVIGATION_SET_WAYPOINTS;
        if (!bVar.b.H()) {
            bVar.v();
        }
        com.google.android.libraries.navigation.internal.afm.e eVar = (com.google.android.libraries.navigation.internal.afm.e) bVar.b;
        eVar.c = dVar.k;
        eVar.b |= 1;
        if (!bVar.b.H()) {
            bVar.v();
        }
        com.google.android.libraries.navigation.internal.afm.e eVar2 = (com.google.android.libraries.navigation.internal.afm.e) bVar.b;
        eVar2.b |= 8;
        eVar2.d = i;
        g(bVar, 0);
    }

    @Override // com.google.android.libraries.navigation.internal.xe.fl
    public final void c(int i) {
        com.google.android.libraries.navigation.internal.afm.b bVar = (com.google.android.libraries.navigation.internal.afm.b) com.google.android.libraries.navigation.internal.afm.e.a.q();
        com.google.android.libraries.navigation.internal.afm.d dVar = com.google.android.libraries.navigation.internal.afm.d.NAVIGATION_SET_WAYPOINTS_WITH_ROUTE_TOKEN;
        if (!bVar.b.H()) {
            bVar.v();
        }
        com.google.android.libraries.navigation.internal.afm.e eVar = (com.google.android.libraries.navigation.internal.afm.e) bVar.b;
        eVar.c = dVar.k;
        eVar.b |= 1;
        if (!bVar.b.H()) {
            bVar.v();
        }
        com.google.android.libraries.navigation.internal.afm.e eVar2 = (com.google.android.libraries.navigation.internal.afm.e) bVar.b;
        eVar2.b |= 8;
        eVar2.d = i;
        g(bVar, 0);
    }

    public final void d() {
        if (this.e == null || !com.google.android.libraries.navigation.internal.afw.j.c()) {
            return;
        }
        com.google.android.libraries.navigation.internal.aac.az.o(this.d.a(new com.google.android.libraries.navigation.internal.aac.s() { // from class: com.google.android.libraries.navigation.internal.xe.fp
            @Override // com.google.android.libraries.navigation.internal.aac.s
            public final com.google.android.libraries.navigation.internal.aac.bj a() {
                final fv fvVar = this.a;
                return fvVar.e.b(new com.google.android.libraries.navigation.internal.yx.aa() { // from class: com.google.android.libraries.navigation.internal.xe.fm
                    @Override // com.google.android.libraries.navigation.internal.yx.aa
                    public final Object ak(Object obj) {
                        com.google.android.libraries.navigation.internal.xi.b bVar = (com.google.android.libraries.navigation.internal.xi.b) obj;
                        com.google.android.libraries.navigation.internal.ael.bb bbVar = (com.google.android.libraries.navigation.internal.ael.bb) bVar.aH(5, null);
                        bbVar.x(bVar);
                        com.google.android.libraries.navigation.internal.xi.a aVar = (com.google.android.libraries.navigation.internal.xi.a) bbVar;
                        fv fvVar2 = fvVar;
                        boolean zF = fvVar2.f(com.google.android.libraries.navigation.internal.afm.d.NAVIGATION_SET_WAYPOINTS);
                        if (!aVar.b.H()) {
                            aVar.v();
                        }
                        com.google.android.libraries.navigation.internal.xi.b bVar2 = (com.google.android.libraries.navigation.internal.xi.b) aVar.b;
                        com.google.android.libraries.navigation.internal.xi.b bVar3 = com.google.android.libraries.navigation.internal.xi.b.a;
                        bVar2.b |= 1;
                        bVar2.c = zF;
                        boolean zF2 = fvVar2.f(com.google.android.libraries.navigation.internal.afm.d.NAVIGATION_SET_WAYPOINTS_WITH_ROUTE_TOKEN);
                        if (!aVar.b.H()) {
                            aVar.v();
                        }
                        com.google.android.libraries.navigation.internal.xi.b bVar4 = (com.google.android.libraries.navigation.internal.xi.b) aVar.b;
                        bVar4.b |= 2;
                        bVar4.d = zF2;
                        return (com.google.android.libraries.navigation.internal.xi.b) aVar.t();
                    }
                }, fvVar.a);
            }
        }, this.a), new fs(), this.a);
    }

    public final void e(com.google.android.libraries.navigation.internal.afm.d dVar, boolean z) {
        this.c.put(dVar, Boolean.valueOf(z));
        if (dVar != com.google.android.libraries.navigation.internal.afm.d.NAVIGATION_INIT) {
            d();
        }
    }

    public final boolean f(com.google.android.libraries.navigation.internal.afm.d dVar) {
        Boolean bool = (Boolean) this.c.get(dVar);
        return bool == null || bool.booleanValue();
    }

    public final void g(com.google.android.libraries.navigation.internal.afm.b bVar, int i) {
        com.google.android.libraries.navigation.internal.afm.a aVar = (com.google.android.libraries.navigation.internal.afm.a) com.google.android.libraries.navigation.internal.afm.f.a.q();
        aVar.c(bVar);
        this.i.a((com.google.android.libraries.navigation.internal.afm.f) aVar.t(), new fu(this, bVar, i), this.h);
    }
}
