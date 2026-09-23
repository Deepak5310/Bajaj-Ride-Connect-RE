package com.google.android.libraries.navigation.internal.sv;

import java.util.Optional;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class cf implements com.google.android.libraries.navigation.internal.rw.d {
    final /* synthetic */ cg a;

    public cf(cg cgVar) {
        this.a = cgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.rw.d
    public final void a(com.google.android.libraries.navigation.internal.rw.b bVar) {
        if (this.a.b()) {
            com.google.android.libraries.navigation.internal.rw.i iVar = (com.google.android.libraries.navigation.internal.rw.i) bVar;
            com.google.android.libraries.navigation.internal.rw.ac acVar = ((com.google.android.libraries.navigation.internal.rw.j) iVar.b).b;
            if (acVar == null) {
                this.a.g.d();
                return;
            }
            com.google.android.libraries.navigation.internal.rw.l lVar = (com.google.android.libraries.navigation.internal.rw.l) acVar;
            if (!lVar.d.isEmpty()) {
                cg cgVar = this.a;
                cgVar.h.b(lVar.d);
            }
            com.google.android.libraries.navigation.internal.bp.bw bwVar = lVar.b;
            if (bwVar == null) {
                this.a.g.d();
                return;
            }
            com.google.android.libraries.navigation.internal.add.ae aeVar = iVar.a.d;
            if (aeVar == null) {
                aeVar = com.google.android.libraries.navigation.internal.add.ae.a;
            }
            com.google.android.libraries.navigation.internal.add.d dVar = aeVar.d;
            if (dVar == null) {
                dVar = com.google.android.libraries.navigation.internal.add.d.a;
            }
            com.google.android.libraries.navigation.internal.add.c cVar = dVar.f;
            if (cVar == null) {
                cVar = com.google.android.libraries.navigation.internal.add.c.a;
            }
            cg cgVar2 = this.a;
            String str = cVar.c;
            if (cgVar2.c.isPresent() && str.equals(this.a.c.get())) {
                this.a.g.d();
                return;
            }
            com.google.android.libraries.navigation.internal.add.c cVar2 = dVar.f;
            if (cVar2 == null) {
                cVar2 = com.google.android.libraries.navigation.internal.add.c.a;
            }
            com.google.android.libraries.navigation.internal.add.bb bbVar = cVar2.d;
            if (bbVar == null) {
                bbVar = com.google.android.libraries.navigation.internal.add.bb.a;
            }
            com.google.android.libraries.navigation.internal.vn.d dVarB = com.google.android.libraries.navigation.internal.vn.d.b(bwVar, bbVar.b, lVar.a, lVar.e);
            com.google.android.libraries.navigation.internal.vn.a aVar = lVar.c;
            if (aVar != null) {
                dVarB.f = aVar;
            }
            this.a.c = Optional.of(str);
            this.a.h.a(dVarB);
        }
    }
}
