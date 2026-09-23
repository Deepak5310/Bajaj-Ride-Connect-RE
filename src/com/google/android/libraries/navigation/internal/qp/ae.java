package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.navigation.internal.adi.bi;
import com.google.android.libraries.navigation.internal.adi.bj;
import com.google.android.libraries.navigation.internal.ael.bb;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ae implements y {
    private boolean a;
    private final int b;
    private final boolean c = false;

    public ae(boolean z, int i, boolean z2) {
        this.a = z;
        this.b = i;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final void a(com.google.android.libraries.navigation.internal.pt.d dVar, com.google.android.libraries.navigation.internal.adi.ag agVar) {
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
            if (iA == com.google.android.libraries.navigation.internal.adi.w.h) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        if (this.a) {
            bj bjVar = ((com.google.android.libraries.navigation.internal.adi.aj) agVar.b).i;
            if (bjVar == null) {
                bjVar = bj.a;
            }
            bb bbVar = (bb) bjVar.aH(5, null);
            bbVar.x(bjVar);
            bi biVar = (bi) bbVar;
            if (!biVar.b.H()) {
                biVar.v();
            }
            bj bjVar2 = (bj) biVar.b;
            bjVar2.b |= 1;
            bjVar2.c = true;
            if (!agVar.b.H()) {
                agVar.v();
            }
            com.google.android.libraries.navigation.internal.adi.aj ajVar = (com.google.android.libraries.navigation.internal.adi.aj) agVar.b;
            bj bjVar3 = (bj) biVar.t();
            bjVar3.getClass();
            ajVar.i = bjVar3;
            ajVar.b |= 2048;
        }
        com.google.android.libraries.navigation.internal.adi.x xVarC = agVar.c(i);
        bb bbVar2 = (bb) xVarC.aH(5, null);
        bbVar2.x(xVarC);
        int i2 = this.b;
        com.google.android.libraries.navigation.internal.adi.u uVar = (com.google.android.libraries.navigation.internal.adi.u) bbVar2;
        if (!uVar.b.H()) {
            uVar.v();
        }
        com.google.android.libraries.navigation.internal.adi.x xVar = (com.google.android.libraries.navigation.internal.adi.x) uVar.b;
        com.google.android.libraries.navigation.internal.adi.x xVar2 = com.google.android.libraries.navigation.internal.adi.x.a;
        xVar.b |= 4;
        xVar.e = i2;
        agVar.h(i, (com.google.android.libraries.navigation.internal.adi.x) uVar.t());
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final boolean b(List list, aa aaVar) {
        return true;
    }

    public final synchronized void c(boolean z) {
        this.a = z;
    }
}
