package com.google.android.libraries.geo.navcore.guidance.impl;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements com.google.android.libraries.navigation.internal.rw.f, com.google.android.libraries.navigation.internal.rw.g {
    public volatile com.google.android.libraries.navigation.internal.rw.p a = com.google.android.libraries.navigation.internal.rw.p.OFF;
    public volatile com.google.android.libraries.navigation.internal.rw.b b;
    public final com.google.android.libraries.navigation.internal.vm.e c;
    private final Executor d;

    public g(Executor executor) {
        com.google.android.libraries.navigation.internal.rw.p pVar = com.google.android.libraries.navigation.internal.rw.p.OFF;
        com.google.android.libraries.navigation.internal.rw.a aVarA = com.google.android.libraries.navigation.internal.rw.b.a();
        aVarA.b(pVar);
        com.google.android.libraries.navigation.internal.rw.h hVar = (com.google.android.libraries.navigation.internal.rw.h) aVarA;
        hVar.a = null;
        hVar.b = null;
        this.b = aVarA.a();
        this.c = new com.google.android.libraries.navigation.internal.vm.e();
        this.d = executor;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.f
    public final com.google.android.libraries.navigation.internal.rw.b a() {
        return this.b;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.f
    public final com.google.android.libraries.navigation.internal.rw.p b() {
        return this.a;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.f
    public final void c(com.google.android.libraries.navigation.internal.rw.e eVar, Executor executor) {
        this.c.c(eVar, executor);
    }

    @Override // com.google.android.libraries.navigation.internal.rw.f
    public final void d(com.google.android.libraries.navigation.internal.rw.e eVar) {
        this.c.b(eVar);
    }

    @Override // com.google.android.libraries.navigation.internal.rw.f
    public final /* synthetic */ boolean e() {
        return this.a != com.google.android.libraries.navigation.internal.rw.p.OFF;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.g
    public final void f(com.google.android.libraries.navigation.internal.rw.b bVar) {
        com.google.android.libraries.navigation.internal.rw.a aVarA = com.google.android.libraries.navigation.internal.rw.b.a();
        com.google.android.libraries.navigation.internal.rw.i iVar = (com.google.android.libraries.navigation.internal.rw.i) bVar;
        aVarA.c(iVar.a);
        aVarA.d(iVar.b);
        com.google.android.libraries.navigation.internal.tj.j jVar = iVar.d;
        if (jVar == null && com.google.android.libraries.navigation.internal.rw.t.a(bVar) == null) {
            com.google.android.libraries.navigation.internal.tj.h hVar = iVar.e;
            if (hVar != null) {
                ((com.google.android.libraries.navigation.internal.rw.h) aVarA).b = hVar;
                aVarA.b(com.google.android.libraries.navigation.internal.rw.p.CRUISING);
            } else {
                aVarA.b(com.google.android.libraries.navigation.internal.rw.p.OFF);
            }
        } else {
            ((com.google.android.libraries.navigation.internal.rw.h) aVarA).a = jVar;
            aVarA.b(com.google.android.libraries.navigation.internal.rw.p.GUIDING);
        }
        final com.google.android.libraries.navigation.internal.rw.b bVarA = aVarA.a();
        this.d.execute(new Runnable() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                g gVar = this.a;
                final com.google.android.libraries.navigation.internal.rw.b bVar2 = bVarA;
                com.google.android.libraries.navigation.internal.rw.p pVar = gVar.a;
                final com.google.android.libraries.navigation.internal.rw.p pVar2 = ((com.google.android.libraries.navigation.internal.rw.i) bVar2).c;
                if (pVar2 != pVar) {
                    final com.google.android.libraries.navigation.internal.rw.p pVar3 = gVar.a;
                    gVar.a = pVar2;
                    gVar.c.a(new com.google.android.libraries.navigation.internal.yx.ax() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.f
                        @Override // com.google.android.libraries.navigation.internal.yx.ax
                        public final void a(Object obj) {
                            com.google.android.libraries.navigation.internal.rw.e eVar = (com.google.android.libraries.navigation.internal.rw.e) obj;
                            if (eVar instanceof com.google.android.libraries.navigation.internal.rw.c) {
                                com.google.android.libraries.navigation.internal.rw.c cVar = (com.google.android.libraries.navigation.internal.rw.c) eVar;
                                cVar.i(pVar3, pVar2);
                            }
                        }
                    });
                }
                if (gVar.b.equals(bVar2)) {
                    return;
                }
                gVar.b = bVar2;
                gVar.c.a(new com.google.android.libraries.navigation.internal.yx.ax() { // from class: com.google.android.libraries.geo.navcore.guidance.impl.e
                    @Override // com.google.android.libraries.navigation.internal.yx.ax
                    public final void a(Object obj) {
                        com.google.android.libraries.navigation.internal.rw.e eVar = (com.google.android.libraries.navigation.internal.rw.e) obj;
                        if (eVar instanceof com.google.android.libraries.navigation.internal.rw.d) {
                            ((com.google.android.libraries.navigation.internal.rw.d) eVar).a(bVar2);
                        }
                    }
                });
            }
        });
    }
}
