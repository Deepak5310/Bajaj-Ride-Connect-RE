package com.google.android.libraries.navigation.internal.uh;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.hx.ap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class y extends com.google.android.libraries.navigation.internal.ia.k {
    private final int f;

    public y(int i, Class cls, u uVar, ap apVar) {
        super(cls, uVar, apVar, null);
        this.f = i;
    }

    @Override // com.google.android.libraries.navigation.internal.ia.k
    protected final void a(com.google.android.libraries.navigation.internal.ic.a aVar) {
        int i = this.f;
        if (i == 0) {
            com.google.android.libraries.navigation.internal.sr.f fVar = ((com.google.android.libraries.navigation.internal.sr.e) aVar).a;
            return;
        }
        if (i == 1) {
            ((u) this.c).a((com.google.android.libraries.navigation.internal.sr.j) aVar);
            return;
        }
        if (i == 2) {
            u uVar = (u) this.c;
            com.google.android.libraries.navigation.internal.si.f fVar2 = (com.google.android.libraries.navigation.internal.si.f) aVar;
            if (fVar2 instanceof com.google.android.libraries.navigation.internal.si.g) {
                com.google.android.libraries.navigation.internal.si.g gVar = (com.google.android.libraries.navigation.internal.si.g) fVar2;
                if (gVar.g()) {
                    w wVar = uVar.a;
                    wVar.b.g = gVar;
                    com.google.android.libraries.navigation.internal.ea.e eVar = wVar.c;
                    if (eVar == null || !((com.google.android.libraries.navigation.internal.ui.a) eVar).c()) {
                        return;
                    }
                    uVar.a.q();
                    return;
                }
                return;
            }
            return;
        }
        if (i != 3) {
            u uVar2 = (u) this.c;
            w wVar2 = uVar2.a;
            ((com.google.android.libraries.navigation.internal.ui.a.C0035a) wVar2.b).r = true;
            com.google.android.libraries.navigation.internal.ea.e eVar2 = wVar2.c;
            if (eVar2 == null || !((com.google.android.libraries.navigation.internal.ui.a) eVar2).c()) {
                return;
            }
            uVar2.a.q();
            return;
        }
        u uVar3 = (u) this.c;
        com.google.android.libraries.navigation.internal.sr.o oVar = (com.google.android.libraries.navigation.internal.sr.o) aVar;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NavigationUiStateTracker.onRequestDismissPromptEvent");
        try {
            com.google.android.libraries.navigation.internal.tj.u uVar4 = oVar.a;
            if ((uVar4 instanceof com.google.android.libraries.navigation.internal.tj.q) && (((com.google.android.libraries.navigation.internal.tj.q) uVar4).a instanceof com.google.android.libraries.navigation.internal.si.g)) {
                w wVar3 = uVar3.a;
                wVar3.b.g = null;
                com.google.android.libraries.navigation.internal.ea.e eVar3 = wVar3.c;
                if (eVar3 != null && ((com.google.android.libraries.navigation.internal.ui.a) eVar3).c()) {
                    uVar3.a.q();
                }
            }
            if (dVarB != null) {
                Trace.endSection();
            }
        } catch (Throwable th) {
            if (dVarB != null) {
                try {
                    Trace.endSection();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
