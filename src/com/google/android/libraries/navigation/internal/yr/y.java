package com.google.android.libraries.navigation.internal.yr;

import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
final class y extends z {
    static final z a;
    static final z b;

    static {
        z zVarB = new y(null, new SimpleArrayMap(0)).b();
        a = zVarB;
        y yVar = new y(zVarB, new SimpleArrayMap());
        x xVar = z.c;
        com.google.android.libraries.navigation.internal.yx.ar.l(!yVar.e, "Can't mutate after handing to trace");
        com.google.android.libraries.navigation.internal.yx.ar.l(true ^ yVar.c(xVar), "Key already present");
        yVar.d.put(xVar, true);
        b = yVar.b();
    }

    public y(z zVar, SimpleArrayMap simpleArrayMap) {
        super(zVar, simpleArrayMap);
    }
}
