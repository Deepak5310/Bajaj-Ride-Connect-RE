package com.google.android.libraries.navigation.internal.hr;

import com.google.android.libraries.navigation.internal.iv.ab;
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class q implements com.google.android.libraries.navigation.internal.nt.t {
    final /* synthetic */ r a;

    public q(r rVar) {
        this.a = rVar;
    }

    @Override // com.google.android.libraries.navigation.internal.nt.t
    public final void a(com.google.android.libraries.navigation.internal.nt.m mVar) {
        if (!((Boolean) mVar.c()).booleanValue() || this.a.b.p.get()) {
            return;
        }
        this.a.e.y(ab.cc, false);
        r rVar = this.a;
        com.google.android.libraries.navigation.internal.hu.a aVar = rVar.a;
        Objects.requireNonNull(aVar);
        p pVar = new p(aVar);
        com.google.android.libraries.navigation.internal.hj.i iVarC = ((com.google.android.libraries.navigation.internal.di.b) this.a.c.a()).c();
        Locale localeC = ((com.google.android.libraries.navigation.internal.no.a) this.a.d.a()).c();
        r rVar2 = this.a;
        o oVar = rVar.b;
        long jA = rVar2.a.a();
        synchronized (oVar.i) {
            if (oVar.p.getAndSet(true)) {
                ((com.google.android.libraries.navigation.internal.zb.h) o.a.d(com.google.android.libraries.navigation.internal.nl.a.a).F(684)).p("ClientParametersUpdater start() already called.");
                return;
            }
            oVar.t = pVar;
            oVar.l = iVarC;
            oVar.m = localeC;
            oVar.f446n = jA;
            oVar.o = oVar.j.Y();
            oVar.c(oVar.s == 2 ? 0L : oVar.a(jA, oVar.h), com.google.android.libraries.navigation.internal.ir.a.INITIAL_REFRESH);
            oVar.s = 3;
            Iterator it2 = oVar.r.iterator();
            while (it2.hasNext()) {
                ((n) it2.next()).b();
            }
        }
    }
}
