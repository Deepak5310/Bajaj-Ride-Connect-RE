package com.google.android.libraries.navigation.internal.xj;

import com.google.android.libraries.navigation.internal.nc.x;
import java.util.EnumMap;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class d {
    private final EnumMap a = new EnumMap(a.class);

    public d(b bVar) {
        for (a aVar : a.values()) {
            EnumMap enumMap = new EnumMap(c.class);
            for (c cVar : c.values()) {
                enumMap.put(cVar, (x) ((EnumMap) bVar.a.get(aVar)).get(cVar));
            }
            this.a.put(aVar, enumMap);
        }
    }

    public final x a(a aVar, c cVar) {
        return (x) ((EnumMap) this.a.get(aVar)).get(cVar);
    }
}
