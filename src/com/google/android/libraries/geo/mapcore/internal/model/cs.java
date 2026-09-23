package com.google.android.libraries.geo.mapcore.internal.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
final class cs {
    public final ArrayList a;
    public final cr b;

    public cs(cr crVar, List list) {
        this.b = crVar;
        this.a = new ArrayList(list.size());
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            com.google.android.libraries.navigation.internal.aeg.d dVar = (com.google.android.libraries.navigation.internal.aeg.d) it2.next();
            this.a.add(new cd(dVar.c, dVar.d, dVar.e));
        }
    }
}
