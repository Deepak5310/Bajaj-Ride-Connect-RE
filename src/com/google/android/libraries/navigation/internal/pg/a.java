package com.google.android.libraries.navigation.internal.pg;

import com.google.android.libraries.geo.mapcore.internal.model.cd;
import com.google.android.libraries.navigation.internal.oe.x;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static Set a(f fVar, Set set, x xVar) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it2 = set.iterator();
        while (it2.hasNext()) {
            cd cdVarC = fVar.c((cd) it2.next(), xVar);
            if (cdVarC != null) {
                linkedHashSet.add(cdVarC);
            }
        }
        return linkedHashSet;
    }
}
