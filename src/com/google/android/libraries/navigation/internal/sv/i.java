package com.google.android.libraries.navigation.internal.sv;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public i(int i, Class cls, g gVar, com.google.android.libraries.navigation.internal.hx.ap apVar, Executor executor) {
        super(cls, gVar, apVar, executor);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        com.google.android.libraries.navigation.internal.db.r rVarC;
        switch (this.f) {
            case 0:
                ((g) this.c).f.e(((com.google.android.libraries.navigation.internal.cw.d) aVar).c);
                return;
            case 1:
                com.google.android.libraries.navigation.internal.sr.e eVar = (com.google.android.libraries.navigation.internal.sr.e) aVar;
                if (((g) this.c).f()) {
                    return;
                }
                com.google.android.libraries.navigation.internal.sr.f fVar = eVar.a;
                return;
            case 2:
                g gVar = (g) this.c;
                com.google.android.libraries.navigation.internal.sr.j jVar = (com.google.android.libraries.navigation.internal.sr.j) aVar;
                if (gVar.f.m()) {
                    com.google.android.libraries.navigation.internal.si.g gVar2 = jVar.a;
                    gVar.e(null);
                    return;
                }
                return;
            case 3:
                ((g) this.c).e.a.d();
                return;
            case 4:
                g gVar3 = (g) this.c;
                com.google.android.libraries.navigation.internal.si.g gVar4 = (com.google.android.libraries.navigation.internal.si.g) aVar;
                if (gVar3.f.m() && gVar4.g()) {
                    gVar3.e(gVar4);
                    return;
                }
                return;
            case 5:
                if (((g) this.c).f.m()) {
                    throw null;
                }
                return;
            case 6:
                g gVar5 = (g) this.c;
                com.google.android.libraries.navigation.internal.sr.p pVar = (com.google.android.libraries.navigation.internal.sr.p) aVar;
                boolean z = gVar5.g.w().c;
                if (gVar5.f()) {
                    return;
                }
                gVar5.d.a(gVar5.c, pVar).f();
                return;
            case 7:
                g gVar6 = (g) this.c;
                com.google.android.libraries.navigation.internal.ss.e eVar2 = (com.google.android.libraries.navigation.internal.ss.e) aVar;
                if (!gVar6.f.m() || (rVarC = gVar6.f.c()) == null) {
                    return;
                }
                eVar2.d().isPresent();
                gVar6.e.a(new com.google.android.libraries.navigation.internal.tj.x(rVarC, eVar2.e(), null));
                gVar6.b.n(com.google.android.libraries.navigation.internal.iv.ab.bL, true);
                return;
            default:
                ((g) this.c).e.a(((com.google.android.libraries.navigation.internal.sr.i) aVar).a);
                return;
        }
    }
}
