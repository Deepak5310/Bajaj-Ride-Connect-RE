package com.google.android.libraries.geo.mapcore.internal.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes2.dex */
public final class ae {
    public static void a(Object obj, com.google.android.libraries.navigation.internal.pt.f fVar, Map map) {
        if (fVar == null || fVar.a.isEmpty()) {
            return;
        }
        com.google.android.libraries.navigation.internal.pt.d dVar = (com.google.android.libraries.navigation.internal.pt.d) fVar.a.get(0);
        List arrayList = (List) map.get(dVar);
        if (arrayList == null) {
            arrayList = new ArrayList();
            map.put(dVar, arrayList);
        }
        arrayList.add(obj);
    }
}
