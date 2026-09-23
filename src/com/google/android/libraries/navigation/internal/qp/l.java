package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.yx.am;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements y {
    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final void a(com.google.android.libraries.navigation.internal.pt.d dVar, com.google.android.libraries.navigation.internal.adi.ag agVar) {
        if (dVar == null) {
            return;
        }
        String strF = dVar.b.f();
        int i = 0;
        while (true) {
            if (i >= ((com.google.android.libraries.navigation.internal.adi.aj) agVar.b).d.size()) {
                i = -1;
                break;
            }
            int iA = com.google.android.libraries.navigation.internal.adi.w.a(agVar.c(i).c);
            if (iA == 0) {
                iA = com.google.android.libraries.navigation.internal.adi.w.a;
            }
            if (iA == com.google.android.libraries.navigation.internal.adi.w.g && agVar.c(i).d.equals("indoor")) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        com.google.android.libraries.navigation.internal.adi.x xVarC = agVar.c(i);
        bb bbVar = (bb) xVarC.aH(5, null);
        bbVar.x(xVarC);
        com.google.android.libraries.navigation.internal.adi.u uVar = (com.google.android.libraries.navigation.internal.adi.u) bbVar;
        com.google.android.libraries.navigation.internal.adi.s sVar = (com.google.android.libraries.navigation.internal.adi.s) com.google.android.libraries.navigation.internal.adi.t.a.q();
        if (!sVar.b.H()) {
            sVar.v();
        }
        com.google.android.libraries.navigation.internal.adi.t tVar = (com.google.android.libraries.navigation.internal.adi.t) sVar.b;
        tVar.b |= 1;
        tVar.c = "lv";
        if (!sVar.b.H()) {
            sVar.v();
        }
        com.google.android.libraries.navigation.internal.adi.t tVar2 = (com.google.android.libraries.navigation.internal.adi.t) sVar.b;
        tVar2.b |= 2;
        tVar2.d = strF;
        uVar.c(sVar);
        agVar.h(i, (com.google.android.libraries.navigation.internal.adi.x) uVar.t());
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final boolean b(List list, aa aaVar) {
        if (list.isEmpty()) {
            return true;
        }
        return am.a(((aa) list.get(0)).c().d, ((c) aaVar).a.d);
    }
}
