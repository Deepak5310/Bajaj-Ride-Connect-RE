package com.google.android.libraries.navigation.internal.abh;

import java.util.HashMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dz {
    private static final HashMap a = new HashMap();

    public static synchronized dv a(m mVar, be beVar, com.google.android.libraries.navigation.internal.afm.d dVar, ht htVar) {
        HashMap map = a;
        dv dvVar = (dv) map.get(dVar);
        if (dvVar != null) {
            return dvVar;
        }
        dv dvVar2 = new dv(beVar, dVar);
        mVar.c.e(dvVar2.f, dvVar2);
        ((com.google.android.libraries.navigation.internal.abg.q) mVar.a.b.a()).i(dvVar2);
        map.put(dVar, dvVar2);
        return dvVar2;
    }
}
