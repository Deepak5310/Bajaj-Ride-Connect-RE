package com.google.android.libraries.navigation.internal.sv;

import com.google.android.libraries.navigation.internal.adr.el;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class bx implements com.google.android.libraries.navigation.internal.rw.d {
    final /* synthetic */ by a;

    public bx(by byVar) {
        this.a = byVar;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x007e  */
    /* JADX WARN: Code duplicated, block: B:20:0x0087  */
    @Override // com.google.android.libraries.navigation.internal.rw.d
    public final void a(com.google.android.libraries.navigation.internal.rw.b bVar) {
        boolean z;
        el elVarA;
        com.google.android.libraries.navigation.internal.tj.j jVarA = com.google.android.libraries.navigation.internal.rw.t.a(bVar);
        if (jVarA == null) {
            return;
        }
        double dA = jVarA.c().a();
        com.google.android.libraries.navigation.internal.bp.bg bgVar = jVarA.c().b;
        by byVar = this.a;
        if (byVar.d.K().h) {
            boolean z2 = true;
            if (!byVar.a().b || (elVarA = byVar.l.a(bgVar, dA)) == null) {
                z = false;
            } else {
                com.google.android.libraries.navigation.internal.mj.a aVar = byVar.e;
                Set set = byVar.f581n;
                long jA = aVar.a();
                com.google.android.libraries.navigation.internal.tt.d dVarI = com.google.android.libraries.navigation.internal.tt.d.I(elVarA);
                com.google.android.libraries.navigation.internal.tt.b bVar2 = (com.google.android.libraries.navigation.internal.tt.b) dVarI;
                if (set.contains(Long.valueOf(bVar2.a)) || byVar.d(jA)) {
                    z = false;
                } else {
                    ao aoVar = byVar.c;
                    com.google.android.libraries.navigation.internal.dx.o oVar = (com.google.android.libraries.navigation.internal.dx.o) byVar.f.a.a();
                    oVar.getClass();
                    aoVar.a(new com.google.android.libraries.navigation.internal.tj.y(oVar, dVarI, null));
                    byVar.f581n.add(Long.valueOf(bVar2.a));
                    byVar.b(dVarI);
                    z = true;
                }
            }
            el elVarA2 = byVar.k.a(bgVar, dA);
            if (elVarA2 == null) {
                z2 = false;
            } else {
                com.google.android.libraries.navigation.internal.tt.a aVar2 = new com.google.android.libraries.navigation.internal.tt.a(com.google.android.libraries.navigation.internal.tt.d.I(elVarA2));
                aVar2.o(true);
                com.google.android.libraries.navigation.internal.tt.d dVarL = aVar2.l();
                long epochMilli = byVar.e.f().toEpochMilli();
                com.google.android.libraries.navigation.internal.tt.b bVar3 = (com.google.android.libraries.navigation.internal.tt.b) dVarL;
                if (byVar.m.contains(Long.valueOf(bVar3.a)) || byVar.e(epochMilli)) {
                    z2 = false;
                } else {
                    byVar.b.a(new com.google.android.libraries.navigation.internal.sr.p(dVarL));
                    byVar.c(dVarL, false);
                    byVar.m.add(Long.valueOf(bVar3.a));
                    byVar.f(epochMilli);
                }
            }
            if (z || z2) {
                byVar.i = byVar.e.f().toEpochMilli();
            }
        }
    }
}
