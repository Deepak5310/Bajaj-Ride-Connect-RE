package com.google.android.libraries.navigation.internal.po;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class dg {
    private final Map d = Collections.synchronizedMap(new HashMap());
    public final Map a = Collections.synchronizedMap(new HashMap());
    public final Map b = new HashMap();
    public final Map c = new HashMap();

    public final com.google.android.libraries.navigation.internal.ol.bd a(com.google.android.libraries.navigation.internal.adg.ef efVar) {
        return efVar != com.google.android.libraries.navigation.internal.adg.ef.a ? (com.google.android.libraries.navigation.internal.ol.bd) this.d.get(efVar) : com.google.android.libraries.navigation.internal.ol.bd.a;
    }

    final void b(bb bbVar, com.google.android.libraries.navigation.internal.ol.bd bdVar) {
        com.google.android.libraries.navigation.internal.adg.ef efVarN = bbVar.n();
        if (efVarN != com.google.android.libraries.navigation.internal.adg.ef.a) {
            this.d.put(efVarN, bdVar);
        }
    }

    final void c(bb bbVar) {
        com.google.android.libraries.navigation.internal.adg.ef efVarN = bbVar.n();
        if (efVarN != com.google.android.libraries.navigation.internal.adg.ef.a) {
            this.d.remove(efVarN);
        }
    }
}
