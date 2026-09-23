package com.google.android.libraries.navigation.internal.ca;

import com.google.android.libraries.navigation.internal.adr.el;
import com.google.android.libraries.navigation.internal.br.l;
import com.google.android.libraries.navigation.internal.gw.x;
import com.google.android.libraries.navigation.internal.nc.ah;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class e {
    public static ah a(el elVar, com.google.android.libraries.navigation.internal.bn.d dVar, ah ahVar) {
        com.google.android.libraries.navigation.internal.adr.ah ahVar2 = elVar.w;
        if (ahVar2 == null) {
            ahVar2 = com.google.android.libraries.navigation.internal.adr.ah.a;
        }
        com.google.android.libraries.navigation.internal.br.d dVar2 = (com.google.android.libraries.navigation.internal.br.d) l.a(ahVar2);
        String str = dVar2.a;
        String str2 = dVar2.b;
        ah ahVarC = str != null ? dVar.c(str, x.c) : null;
        ah ahVarC2 = str2 != null ? dVar.c(str2, x.c) : null;
        if (ahVarC == null) {
            return ahVar;
        }
        return ahVarC2 == null ? ahVarC : com.google.android.libraries.navigation.internal.af.e.d(ahVarC, ahVarC2);
    }
}
