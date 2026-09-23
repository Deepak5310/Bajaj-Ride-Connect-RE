package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.navigation.internal.adi.bw;
import com.google.android.libraries.navigation.internal.adi.bx;
import com.google.android.libraries.navigation.internal.ael.bb;
import com.google.android.libraries.navigation.internal.yx.br;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements y {
    private final br a;

    public h(br brVar) {
        this.a = brVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final void a(com.google.android.libraries.navigation.internal.pt.d dVar, com.google.android.libraries.navigation.internal.adi.ag agVar) {
        if (((Boolean) this.a.a()).booleanValue()) {
            bx bxVar = ((com.google.android.libraries.navigation.internal.adi.aj) agVar.b).h;
            if (bxVar == null) {
                bxVar = bx.a;
            }
            bb bbVar = (bb) bxVar.aH(5, null);
            bbVar.x(bxVar);
            bw bwVar = (bw) bbVar;
            if (!bwVar.b.H()) {
                bwVar.v();
            }
            bx bxVar2 = (bx) bwVar.b;
            bxVar2.b |= 1073741824;
            bxVar2.c = true;
            if (!agVar.b.H()) {
                agVar.v();
            }
            com.google.android.libraries.navigation.internal.adi.aj ajVar = (com.google.android.libraries.navigation.internal.adi.aj) agVar.b;
            bx bxVar3 = (bx) bwVar.t();
            bxVar3.getClass();
            ajVar.h = bxVar3;
            ajVar.b |= 32;
        }
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final boolean b(List list, aa aaVar) {
        return true;
    }
}
