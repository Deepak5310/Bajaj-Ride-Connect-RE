package com.google.android.libraries.navigation.internal.afp;

import com.google.android.libraries.navigation.internal.afr.c;
import com.google.android.libraries.navigation.internal.yz.fd;
import com.google.android.libraries.navigation.internal.yz.ma;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: PG */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    private final Map a;

    public a(Map map, Map map2) {
        if (!map.isEmpty()) {
            LinkedHashMap linkedHashMapB = c.b(((ma) map).d + ((ma) map2).d);
            linkedHashMapB.putAll(map2);
            for (Map.Entry entry : ((fd) map).entrySet()) {
                linkedHashMapB.put(((Class) entry.getKey()).getName(), entry.getValue());
            }
            map2 = Collections.unmodifiableMap(linkedHashMapB);
        }
        this.a = map2;
    }
}
