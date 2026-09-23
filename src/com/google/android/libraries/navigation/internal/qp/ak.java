package com.google.android.libraries.navigation.internal.qp;

import com.google.android.libraries.geo.mapcore.internal.model.cg;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class ak implements y {
    private final cg a;

    public ak(cg cgVar) {
        this.a = cgVar;
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final void a(com.google.android.libraries.navigation.internal.pt.d dVar, com.google.android.libraries.navigation.internal.adi.ag agVar) {
        com.google.android.libraries.navigation.internal.aec.b bVar = ((com.google.android.libraries.geo.mapcore.internal.model.b) this.a).p;
        if (bVar == null) {
            return;
        }
        com.google.android.libraries.navigation.internal.afi.a aVar = (com.google.android.libraries.navigation.internal.afi.a) com.google.android.libraries.navigation.internal.afi.b.a.q();
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.afi.b bVar2 = (com.google.android.libraries.navigation.internal.afi.b) aVar.b;
        bVar2.d = bVar;
        bVar2.c |= 1;
        com.google.android.libraries.navigation.internal.afi.b bVar3 = (com.google.android.libraries.navigation.internal.afi.b) aVar.t();
        com.google.android.libraries.navigation.internal.adf.a aVar2 = (com.google.android.libraries.navigation.internal.adf.a) com.google.android.libraries.navigation.internal.adf.b.a.q();
        aVar2.C(com.google.android.libraries.navigation.internal.afi.b.b, bVar3);
        agVar.f((com.google.android.libraries.navigation.internal.adf.b) aVar2.t());
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final boolean b(List list, aa aaVar) {
        return true;
    }
}
