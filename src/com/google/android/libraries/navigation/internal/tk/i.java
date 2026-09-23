package com.google.android.libraries.navigation.internal.tk;

import androidx.tracing.Trace;
import com.google.android.libraries.navigation.internal.yx.ar;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class i implements com.google.android.libraries.navigation.internal.rw.d {
    final /* synthetic */ l a;

    public i(l lVar) {
        this.a = lVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.d
    public final void a(com.google.android.libraries.navigation.internal.rw.b bVar) {
        int iC = -1;
        if (((com.google.android.libraries.navigation.internal.rw.i) bVar).c == com.google.android.libraries.navigation.internal.rw.p.OFF) {
            l lVar = this.a;
            lVar.c.o = -1;
            c cVar = lVar.d;
            cVar.d = null;
            cVar.b();
            return;
        }
        l lVar2 = this.a;
        com.google.android.libraries.navigation.internal.nw.d dVarB = com.google.android.libraries.navigation.internal.nw.e.b("NotificationController.onNavigationStateChangedInternal");
        try {
            if (((com.google.android.libraries.navigation.internal.rw.i) bVar).c == com.google.android.libraries.navigation.internal.rw.p.GUIDING) {
                com.google.android.libraries.navigation.internal.tj.j jVar = ((com.google.android.libraries.navigation.internal.rw.i) bVar).d;
                ar.q(jVar);
                iC = jVar.c().c();
            }
            lVar2.c.o = iC;
            lVar2.d.c(bVar);
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
