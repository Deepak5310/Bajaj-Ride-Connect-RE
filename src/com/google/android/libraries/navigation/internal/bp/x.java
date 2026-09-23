package com.google.android.libraries.navigation.internal.bp;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class x extends a {
    public static y d(cf cfVar) {
        com.google.android.libraries.navigation.internal.ady.al alVarB = com.google.android.libraries.navigation.internal.ady.al.b(cfVar.f().c);
        if (alVarB == null) {
            alVarB = com.google.android.libraries.navigation.internal.ady.al.DRIVE;
        }
        if (alVarB != com.google.android.libraries.navigation.internal.ady.al.BIKESHARING) {
            return y.NONE;
        }
        com.google.android.libraries.navigation.internal.adr.p pVar = cfVar.f().k;
        if (pVar == null) {
            pVar = com.google.android.libraries.navigation.internal.adr.p.a;
        }
        com.google.android.libraries.navigation.internal.adr.bs bsVar = pVar.c;
        if (bsVar == null) {
            bsVar = com.google.android.libraries.navigation.internal.adr.bs.a;
        }
        if (b(bsVar)) {
            return y.DOCKLESS_BIKESHARING;
        }
        com.google.android.libraries.navigation.internal.adr.p pVar2 = cfVar.f().k;
        if (pVar2 == null) {
            pVar2 = com.google.android.libraries.navigation.internal.adr.p.a;
        }
        com.google.android.libraries.navigation.internal.adr.bq bqVar = pVar2.d;
        if (bqVar == null) {
            bqVar = com.google.android.libraries.navigation.internal.adr.bq.a;
        }
        if (a(bqVar)) {
            return y.DOCKED_BIKESHARING;
        }
        for (av avVar : cfVar.b) {
            for (bt btVar : avVar.g()) {
                if (a.b(btVar.d())) {
                    return y.DOCKLESS_BIKESHARING;
                }
                if (a.a(btVar.c())) {
                    return y.DOCKED_BIKESHARING;
                }
            }
        }
        return y.NONE;
    }
}
