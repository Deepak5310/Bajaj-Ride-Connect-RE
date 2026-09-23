package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.geo.mapcore.internal.model.cg;
import com.google.android.libraries.navigation.internal.ael.bi;
import com.google.android.libraries.navigation.internal.ael.bz;
import com.google.android.libraries.navigation.internal.yz.fy;
import com.google.android.libraries.navigation.internal.yz.nn;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ad implements y {
    private final cg a;

    public ad(cg cgVar) {
        this.a = cgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final void a(com.google.android.libraries.navigation.internal.pt.d dVar, com.google.android.libraries.navigation.internal.adi.ag agVar) {
        fy fyVar = ((com.google.android.libraries.geo.mapcore.internal.model.b) this.a).q;
        if (fyVar.isEmpty()) {
            return;
        }
        com.google.android.libraries.navigation.internal.aca.a aVar = (com.google.android.libraries.navigation.internal.aca.a) com.google.android.libraries.navigation.internal.aca.b.a.q();
        nn nnVarListIterator = fyVar.listIterator();
        while (nnVarListIterator.hasNext()) {
            com.google.android.libraries.navigation.internal.oe.j jVar = (com.google.android.libraries.navigation.internal.oe.j) nnVarListIterator.next();
            com.google.android.libraries.navigation.internal.aax.a aVar2 = (com.google.android.libraries.navigation.internal.aax.a) com.google.android.libraries.navigation.internal.aax.b.a.q();
            long j = jVar.b;
            if (!aVar2.b.H()) {
                aVar2.v();
            }
            com.google.android.libraries.navigation.internal.aax.b bVar = (com.google.android.libraries.navigation.internal.aax.b) aVar2.b;
            bVar.b |= 1;
            bVar.c = j;
            long j2 = jVar.c;
            if (!aVar2.b.H()) {
                aVar2.v();
            }
            com.google.android.libraries.navigation.internal.aax.b bVar2 = (com.google.android.libraries.navigation.internal.aax.b) aVar2.b;
            bVar2.b |= 2;
            bVar2.d = j2;
            com.google.android.libraries.navigation.internal.aax.b bVar3 = (com.google.android.libraries.navigation.internal.aax.b) aVar2.t();
            if (!aVar.b.H()) {
                aVar.v();
            }
            com.google.android.libraries.navigation.internal.aca.b bVar4 = (com.google.android.libraries.navigation.internal.aca.b) aVar.b;
            bVar3.getClass();
            bz bzVar = bVar4.c;
            if (!bzVar.c()) {
                bVar4.c = bi.A(bzVar);
            }
            bVar4.c.add(bVar3);
        }
        com.google.android.libraries.navigation.internal.adf.a aVar3 = (com.google.android.libraries.navigation.internal.adf.a) com.google.android.libraries.navigation.internal.adf.b.a.q();
        aVar3.C(com.google.android.libraries.navigation.internal.aca.b.b, (com.google.android.libraries.navigation.internal.aca.b) aVar.t());
        agVar.f((com.google.android.libraries.navigation.internal.adf.b) aVar3.t());
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final boolean b(List list, aa aaVar) {
        return true;
    }
}
