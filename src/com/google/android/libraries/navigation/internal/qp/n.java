package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.afm.dh;
import com.google.android.libraries.navigation.internal.afm.dj;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class n implements y {
    private final cg a;

    public n(cg cgVar) {
        this.a = cgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final void a(com.google.android.libraries.navigation.internal.pt.d dVar, com.google.android.libraries.navigation.internal.adi.ag agVar) {
        dh dhVar = ((com.google.android.libraries.geo.mapcore.internal.model.b) this.a).i;
        if (dhVar != null) {
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
                if (iA == com.google.android.libraries.navigation.internal.adi.w.g && agVar.c(i).d.isEmpty()) {
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
            String str = dhVar.c;
            if (!uVar.b.H()) {
                uVar.v();
            }
            com.google.android.libraries.navigation.internal.adi.x xVar = (com.google.android.libraries.navigation.internal.adi.x) uVar.b;
            com.google.android.libraries.navigation.internal.adi.x xVar2 = com.google.android.libraries.navigation.internal.adi.x.a;
            str.getClass();
            xVar.b |= 2;
            xVar.d = str;
            for (dj djVar : dhVar.d) {
                com.google.android.libraries.navigation.internal.adi.s sVar = (com.google.android.libraries.navigation.internal.adi.s) com.google.android.libraries.navigation.internal.adi.t.a.q();
                String str2 = djVar.c;
                if (!sVar.b.H()) {
                    sVar.v();
                }
                com.google.android.libraries.navigation.internal.adi.t tVar = (com.google.android.libraries.navigation.internal.adi.t) sVar.b;
                str2.getClass();
                tVar.b |= 1;
                tVar.c = str2;
                String str3 = djVar.d;
                if (!sVar.b.H()) {
                    sVar.v();
                }
                com.google.android.libraries.navigation.internal.adi.t tVar2 = (com.google.android.libraries.navigation.internal.adi.t) sVar.b;
                str3.getClass();
                tVar2.b |= 2;
                tVar2.d = str3;
                uVar.c(sVar);
            }
            com.google.android.libraries.navigation.internal.adi.s sVar2 = (com.google.android.libraries.navigation.internal.adi.s) com.google.android.libraries.navigation.internal.adi.t.a.q();
            if (!sVar2.b.H()) {
                sVar2.v();
            }
            com.google.android.libraries.navigation.internal.adi.t tVar3 = (com.google.android.libraries.navigation.internal.adi.t) sVar2.b;
            tVar3.b |= 1;
            tVar3.c = "mymapslayerid";
            String str4 = dhVar.e;
            if (!sVar2.b.H()) {
                sVar2.v();
            }
            com.google.android.libraries.navigation.internal.adi.t tVar4 = (com.google.android.libraries.navigation.internal.adi.t) sVar2.b;
            str4.getClass();
            tVar4.b |= 2;
            tVar4.d = str4;
            uVar.c(sVar2);
            agVar.g(i, uVar);
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final boolean b(List list, aa aaVar) {
        return true;
    }
}
