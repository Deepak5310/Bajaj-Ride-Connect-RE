package com.google.android.libraries.navigation.internal.qp;

import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements y {
    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final void a(com.google.android.libraries.navigation.internal.pt.d dVar, com.google.android.libraries.navigation.internal.adi.ag agVar) {
        com.google.android.libraries.navigation.internal.acx.a aVar = (com.google.android.libraries.navigation.internal.acx.a) com.google.android.libraries.navigation.internal.acx.d.a.q();
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.acx.d dVar2 = (com.google.android.libraries.navigation.internal.acx.d) aVar.b;
        dVar2.c |= 256;
        dVar2.e = true;
        int i = com.google.android.libraries.navigation.internal.acx.c.d;
        if (!aVar.b.H()) {
            aVar.v();
        }
        com.google.android.libraries.navigation.internal.acx.d dVar3 = (com.google.android.libraries.navigation.internal.acx.d) aVar.b;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        }
        dVar3.d = i2;
        dVar3.c |= 1;
        com.google.android.libraries.navigation.internal.adf.a aVar2 = (com.google.android.libraries.navigation.internal.adf.a) com.google.android.libraries.navigation.internal.adf.b.a.q();
        aVar2.C(com.google.android.libraries.navigation.internal.acx.d.b, (com.google.android.libraries.navigation.internal.acx.d) aVar.t());
        agVar.f((com.google.android.libraries.navigation.internal.adf.b) aVar2.t());
    }

    @Override // com.google.android.libraries.navigation.internal.qp.y
    public final boolean b(List list, aa aaVar) {
        return true;
    }
}
